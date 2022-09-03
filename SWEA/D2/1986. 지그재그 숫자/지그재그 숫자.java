import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tn = sc.nextInt();
		
		for(int i=1;i<=tn;i++) {
			int num = sc.nextInt();
			int hap = 0;
			for (int j=1;j<=num;j++) {
				if (j%2 ==1)
					hap = hap+j;
				else
					hap = hap-j;
			}
			System.out.println("#"+i+" "+hap);
		}
	}
}
