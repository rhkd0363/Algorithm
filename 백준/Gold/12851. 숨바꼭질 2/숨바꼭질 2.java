import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		queue.add(new int[] { N, 0 });

		int time = 0;
		int number = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();

				if (curr[0] == K) {
					time = curr[1];
					number++;
					continue;
				}

				visited[curr[0]] = true;

				if (curr[0] - 1 >= 0 && !visited[curr[0] - 1])
					queue.add(new int[] { curr[0] - 1, curr[1] + 1 });
				if (curr[0] + 1 < 100001 && !visited[curr[0] + 1])
					queue.add(new int[] { curr[0] + 1, curr[1] + 1 });
				if (curr[0] * 2 < 100001 && !visited[curr[0] * 2])
					queue.add(new int[] { curr[0] * 2, curr[1] + 1 });

			}

			if (number != 0) {
				break;
			}
		}

		System.out.println(time + "\n" + number);

	}
}