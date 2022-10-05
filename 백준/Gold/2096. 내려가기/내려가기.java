import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] score = new int[4][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			// 최대점수
			score[1][0] = Math.max(score[0][0], score[0][1]) + left;
			score[1][1] = Math.max(Math.max(score[0][0], score[0][1]), score[0][2]) + mid;
			score[1][2] = Math.max(score[0][1], score[0][2]) + right;

			score[0][0] = score[1][0];
			score[0][1] = score[1][1];
			score[0][2] = score[1][2];
			// 최소점수
			score[3][0] = Math.min(score[2][0], score[2][1]) + left;
			score[3][1] = Math.min(Math.min(score[2][0], score[2][1]), score[2][2]) + mid;
			score[3][2] = Math.min(score[2][1], score[2][2]) + right;

			score[2][0] = score[3][0];
			score[2][1] = score[3][1];
			score[2][2] = score[3][2];
		}
		int max = Math.max(Math.max(score[1][0], score[1][1]), score[1][2]);
		int min = Math.min(Math.min(score[3][0], score[3][1]), score[3][2]);
		System.out.println(max + " " + min);
	}
}