import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());

			int str = 0;
			int end = N - 1;
			int mid = (str + end) / 2;
			boolean flag = false;

			while (str <= end) {
				if (input == list[mid]) {
					flag = true;
					break;
				} else if (input > list[mid]) {
					str = mid + 1;
				} else {
					end = mid - 1;
				}

				mid = (str + end) / 2;
			}
			answer.append(flag ? 1 : 0).append("\n");
		}

		System.out.println(answer);
	}
}
