import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		int a = 0;
		int b = 0;
		char c;
		for(int i =1;i<Tc+1;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			if (a<b)
				c = '<';
			else if (a>b)
				c = '>';
			else
				c = '=';
			
			System.out.println("#"+i+" "+c);
		}
	}
}
