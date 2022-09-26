import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] time;
	static int N, min, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		time = new int[N][2];
		min = 0;
		res = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같을경우.. 시작시간이 작은거부터?
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			if (time[i][0] >= min) {
				min = time[i][1];
				res++;
			}
		}

		System.out.println(res);

	}
}