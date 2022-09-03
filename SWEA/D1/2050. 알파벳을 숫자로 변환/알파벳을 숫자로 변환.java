import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		String Alpha = sc.next();
		
		for (int i = 0;i<Alpha.length();i++) {
			int num = Alpha.charAt(i);
			System.out.format("%d ", num-64);		
		}
	}
}
