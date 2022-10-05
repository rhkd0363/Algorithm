import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 계단의 수
		int N = Integer.parseInt(br.readLine());

		// (연속1번), (연속2번)
		int[][] score = new int[N + 1][2];

		score[1][0] = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			score[i][0] = Math.max(score[i-2][0],score[i-2][1])+val; // 연속(1)
			score[i][1] = score[i-1][0]+val; // 연속(2)
		}

		int ans = Math.max(score[N][0], score[N][1]);
		System.out.println(ans);
	}
}