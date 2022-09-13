import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int min = N;
		//소수확인
		fo:for(int i=M;i<=N;i++) {
			if(i==1)
				continue;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j == 0)
					continue fo;
			}
			min = Math.min(min, i);
			sum+=i;
		}
		if(sum == 0) {
			System.out.print("-1");
		}
		else {
			System.out.println(sum+"\n"+min);
		}
	}
}
