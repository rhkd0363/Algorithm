import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 0;
		
		while(true) {
			
			if (a % 10 != 0) {
				b = b + (a%10);
				a = a/10;
			}
			else
				break;
	
		}
		System.out.println(b);
	}
}
