import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] buildings = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			buildings[i][0] = Integer.parseInt(st.nextToken());
			buildings[i][2] = 100_001;
		}

		Stack<int[]> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			while (true) {
				if (!stack.isEmpty() && stack.peek()[0] <= buildings[i][0]) {
					stack.pop();
				} else {
					if (!stack.isEmpty()) {
						buildings[i][1] += stack.size();
						buildings[i][2] = stack.peek()[1];
					}
					stack.push(new int[] { buildings[i][0], i });
					break;
				}
			}
		}

		stack = new Stack<>();

		for (int i = N; i >= 1; i--) {
			while (true) {
				if (!stack.isEmpty() && stack.peek()[0] <= buildings[i][0]) {
					stack.pop();
				} else {
					if(!stack.isEmpty()) {						
						buildings[i][1] += stack.size();
						buildings[i][2] = Math.abs(i - buildings[i][2]) > Math.abs(i - stack.peek()[1]) ? 
								stack.peek()[1] : buildings[i][2];
					}
					stack.push(new int[] { buildings[i][0], i });
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++)
			sb.append(buildings[i][1] + " " + (buildings[i][1] != 0 ? buildings[i][2] : "")).append('\n');

		System.out.println(sb);
	}
}