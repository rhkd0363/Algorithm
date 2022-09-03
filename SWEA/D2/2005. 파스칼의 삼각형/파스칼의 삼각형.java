import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tN = sc.nextInt();
		for (int i = 1; i <= tN; i++) {
			int tC = sc.nextInt();
			int[] iArr = new int[tC];
			System.out.println("#"+i);
			for (int j = 0; j < iArr.length; j++) {
				for (int k = j; k >= 0; k--) {
					if (k == 0) {
						iArr[0] = 1;
					} else {
						iArr[k] = iArr[k - 1] + iArr[k];
					}
					if (k == j) {
						System.out.print(iArr[k]);
					} else {
						System.out.print(" " + iArr[k]);

					}
				}
				System.out.println();
			}
		}
	}
}
