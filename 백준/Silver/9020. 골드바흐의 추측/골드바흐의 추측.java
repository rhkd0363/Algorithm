import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 10000보다 작은 소수를 담아줄 리스트 선언
		List<Integer> primeList = new ArrayList<Integer>();
		// 반복문을 돌며, 소수에 해당하는 값을 리스트에 추가
		fo: for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)// 나머지가 0이 되면 첫번째 반복문 continue
					continue fo;
			}
			primeList.add(i);
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
			
			for (int i = 0; i < primeList.size(); i++) {
				// 만약 리스트의 i번째 소수의 값이 입력받은 N보다 커지면 STOP
				if (primeList.get(i) > N)
					break;
				for (int j = i; j < primeList.size(); j++) {
					// 리스트의 i번째 소수와 j번째 소수의 합이 N과 같고, 두 소수의 차가 diffNum의 값보다 작으면
					// diffNum을 두 소수의 차, 그리고 lPrime, gPrime에 두 소수의 값을 할당
					if (primeList.get(i) + primeList.get(j) == N && primeList.get(j) - primeList.get(i) < diffNum) {
						diffNum = primeList.get(j) - primeList.get(i);
						lPrime = primeList.get(i);
						gPrime = primeList.get(j);
					}
					// 두 소수의 합이 N 보다 커지면 STOP
					else if (primeList.get(i) + primeList.get(j) > N) {
						break;
					}
				} // for:j
			} // for:i
				// 결과 출력
			System.out.println(lPrime + " " + gPrime);

		}
	}
}