import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Floor {
		int floor;
		int count;

		public Floor(int floor, int count) {
			super();
			this.floor = floor;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken()); // 총 층
		int S = Integer.parseInt(st.nextToken()); // 시작 층
		int G = Integer.parseInt(st.nextToken()); // 도착 층
		int U = Integer.parseInt(st.nextToken()); // 상승
		int D = Integer.parseInt(st.nextToken()); // 하강

		if ((G > S && U == 0) || (G < S && D == 0)) {
			System.out.println("use the stairs");
			return;
		}

		int ans = -1;

		Queue<Floor> queue = new LinkedList<>();

		boolean[] visited = new boolean[F + 1];

		queue.add(new Floor(S, 0));

		while (!queue.isEmpty()) {
			Floor curr = queue.poll();

			if (curr.floor == G) {
				ans = curr.count;
				break;
			}
			
			if (curr.floor + U <= F && !visited[curr.floor + U]) {
				queue.add(new Floor(curr.floor + U, curr.count + 1));
				visited[curr.floor + U] = true;
			}
			// 0층은 없으므로 1층까지 가능
			if (curr.floor - D > 0 && !visited[curr.floor - D] && curr.floor - D > 0) {
				queue.add(new Floor(curr.floor - D, curr.count + 1));
				visited[curr.floor - D] = true;
			}
			
		}

		if (ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}
}