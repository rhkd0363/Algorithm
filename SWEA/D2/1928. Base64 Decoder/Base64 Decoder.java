import java.util.Base64;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();

		for (int i = 1; i <= tn; i++) {
			String text = sc.next();

			byte[] decodeBytes = Base64.getDecoder().decode(text.getBytes());

			String ans = new String(decodeBytes);

			System.out.println("#"+i+" "+ans);
		}
	}
}