import java.util.Scanner;

/*
 * SWEA 5607 조합
 * N comb R 의 값을 1234567891 로 나눈 나머지를 출력하는 문제
 * 모듈러 연산
 *  - 모듈러 연산은 나눗셈에서 사용할 수 없다.
 *  - 나눗셈에서 사용이 불가하므로 페르마의 소정리를 이용해야 한다.
 * 페르마의 소정리
 * 	- P, Q가 서로소이다.
 *  - P^(Q-1) mod Q 는 P의 항등원이다.
 *  - P^(Q-2) mod Q 는 P의 역원이다.
 * 조합
 *  - N 에서 R 개를 뽑는 경우의 수 => N!/{(N-R)!*R!}
 *  - 나눗셈에서 모듈러 연산이 불가능하므로 페르마 소정리 적용
 *  - 위,아래변에  (N-R)!*R! 의 역원을 곱해준다.
 *  - N! * (N-R! * R!)^(P-2)
 */

public class Solution {
	static int mod = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 팩토리얼의 모듈러 연산한 값을 배열에 저장한다.
		long[] fact = new long[1000001];
		fact[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			fact[i] = fact[i - 1] * i;
			fact[i] %= mod;
		}

		int T = sc.nextInt(); //테스트 케이스 입력

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();

			int result = (int) (fact[N] * pow(fact[N-R] * fact[R] % mod, mod-2) % mod);
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
		}

		System.out.println(sb);
	}
	
	static long pow(long a, long b) {
		// 분할 정복 사용. ex) 2^6 = 2^3 * 2^3 = ...
		if(b == 1)
			return a;
		
		long result = pow(a,b/2);
		
		if(b%2 == 0) 
			return (result * result) % mod;
		else
			return (((result * result) % mod) * a) % mod;
	}
}