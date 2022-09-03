import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tN = sc.nextInt();
		for (int n = 1; n <= tN; n++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] iArr = new int[N];
			int[] jArr = new int[M];

			for (int i = 0; i < N; i++) {
				iArr[i] = sc.nextInt();
			}
			for (int j = 0; j < M; j++) {
				jArr[j] = sc.nextInt();
			}
			int max = 0;
			int big = iArr.length >= jArr.length ? iArr.length : jArr.length;
			int small = iArr.length <= jArr.length ? iArr.length : jArr.length;
			for (int i = 0; i <= big - small; i++) {
				int sum = 0;
				if (iArr.length > jArr.length) {
					for (int j = 0; j < small; j++) {
						sum += iArr[j+i] * jArr[j];
					}
				}else if(iArr.length < jArr.length){
					for (int j = 0; j < small; j++) {
						sum += iArr[j] * jArr[i+j];
					}
				}else {
					for (int j = 0; j < small; j++) {
						sum += iArr[j] * jArr[j];
					}
				}
				if (max < sum) {
					max = sum;
				}
			}

			System.out.println("#" + n + " " + max);
		}
	}
}
