import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		int ans = 0;

		boolean[] check = new boolean[100001];

		pq.add(new int[] { N, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (curr[0] == K) {
				ans = curr[1];
				break;
			}

			if (check[curr[0]])
				continue;

			check[curr[0]] = true;

			if (curr[0] != 0)
				pq.add(new int[] { curr[0] - 1, curr[1] + 1 });

			if (curr[0] != 100000)
				pq.add(new int[] { curr[0] + 1, curr[1] + 1 });

			if (curr[0] * 2 < 100001)
				pq.add(new int[] { curr[0] * 2, curr[1] + 1 });

		}

		System.out.println(ans);
	}
}