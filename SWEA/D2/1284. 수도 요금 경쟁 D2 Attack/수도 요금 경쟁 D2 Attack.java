import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tC = sc.nextInt();
		
		for(int i=1;i<=tC;i++) {
			// A사 1리터당 금액
			int P = sc.nextInt();
			// B사 기본요금
			int Q = sc.nextInt();
			// B사 기본요금 기준리터
			int R = sc.nextInt();
			// B사 1리터 당 요금
			int S = sc.nextInt();
			// 수도량
			int W = sc.nextInt();
			
			int A = P*W;
			
			int B = W>R? Q+(W-R)*S:Q;
			
			if(A>B) {
				System.out.println("#"+i+" "+B);
			}else {
				System.out.println("#"+i+" "+A);
			}
		}
	}
}
