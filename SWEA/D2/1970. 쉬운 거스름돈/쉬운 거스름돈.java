import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int price = sc.nextInt();
			int[] iArr = {50000,10000,5000,1000,500,100,50,10};
			int[] cArr = new int[8];

			for (int j = 0; j < iArr.length; j++) {
				cArr[j] = price/iArr[j];
				price = price%iArr[j];
			}
			System.out.println("#"+i);
			System.out.println(cArr[0]+" "+cArr[1]+" "+cArr[2]+" "+cArr[3]+" "+cArr[4]+" "
					+cArr[5]+" "+cArr[6]+" "+cArr[7]);
		}
	}
}
