import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tC = sc.nextInt();

		for (int i = 1; i <= tC; i++) {
			String str = sc.next();
			int chk = 0;
			for (int j = str.length() - 1; j >= 0; j--) {
				if (str.substring(str.length() - j - 1, str.length() - j).equals(str.substring(j, j + 1))) {
					chk++;
				}
			}
			if (chk == str.length()) {
				System.out.println("#" + i + " 1");
			} else {
				System.out.println("#" + i + " 0");
			}
		}
	}
}
