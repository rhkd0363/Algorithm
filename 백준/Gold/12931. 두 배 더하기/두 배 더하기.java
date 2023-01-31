import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] count = new int[1001];

		int max = 0;

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			max = Math.max(max, value);
			count[value]++;
		}

		// 1이나 홀수가 있다면 전부 짝수로 바꿔준다..
		int ans = 0;

		while (count[0] != N) { // count[0] 이 N개가 되면 완료
			for (int i = 1; i <= max; i += 2) { // 홀수번쨰 전체 연산횟수 추가
				if (count[i] != 0) {
					ans += count[i];
					count[i - 1] += count[i];
					count[i] = 0;
				}
			}
			
			if (count[0] == N) { // count[0]이 N개가 되었다면 멈춘다.
				break;
			}

			ans++; // 전체를 2로 나눠주는 연산횟수 추가

			for (int i = 2; i <= max; i += 2) { // 전체를 2로 나눠줌
				if (count[i] != 0) {
					count[i / 2] += count[i];
					count[i] = 0;
				}
			}
		}

		System.out.println(ans);
	}
}