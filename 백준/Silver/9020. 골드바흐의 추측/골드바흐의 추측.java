import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 10000보다 작은 소수 확인할 배열 선언
		boolean[] primeArr = new boolean[10001];
		// 소수 개수
		int count = 0;
		// 반복문을 돌며, 소수에 해당하는 인덱스 true로 값 할당
		fo: for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)// 나머지가 0이 되면 첫번째 반복문 continue
					continue fo;
			}
			primeArr[i] = true;
			count++;
		}
		// 소수를 담아줄 배열 선언
		int[] arr = new int[count];
		// 배열에 소수를 담아줌
		for (int i = 2, j = 0; i <= 10000; i++) {
			if (primeArr[i]) {
				arr[j] = i;
				j++;
			}
		}
		// 테스트케이수 수 입력 받음
		int T = Integer.parseInt(br.readLine());
		// 테스트케이수 수 만큼 반복
		for (int tc = 0; tc < T; tc++) {
			// 10000보다 작거나 같은 짝수 입력받음
			int N = Integer.parseInt(br.readLine());
			// 작은 소수와 큰 소수를 담아줄 변수 선언
			int lPrime = 0, gPrime = 0;
			// 두 소수의 차를 입력받을 변수 선언
			int diffNum = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					// 배열의 i번째 소수와 j번째 소수의 합이 N과 같고, 두 소수의 차가 diffNum의 값보다 작으면
					// diffNum을 두 소수의 차, 그리고 lPrime, gPrime에 두 소수의 값을 할당
					if (arr[i] + arr[j] == N && arr[j] - arr[i] < diffNum) {
						diffNum = arr[j] - arr[i];
						lPrime = arr[i];
						gPrime = arr[j];
					}
					// 두 소수의 합이 N 보다 커지면 STOP
					else if (arr[i] + arr[j] > N) {
						break;
					}
				} // for:j
			} // for:i
				// 결과 출력
			System.out.println(lPrime + " " + gPrime);
		}
	}
}
