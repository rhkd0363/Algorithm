import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tn = sc.nextInt();

		for ( int i = 1; i <= tn; i++) {
			int tc = sc.nextInt();
			int temp = tc;
			int temp_next =0;
			int[] iArr = new int[10];
			while(sum_arr(iArr) != 10) {
				temp_next = temp;
				for(;temp !=0;) {
					int num= temp%10;
					temp = temp/10;
					iArr[num] = 1;
				}
				temp = temp_next +tc;
			}
		System.out.println("#"+i+" "+temp_next);
		}
	}
	
	public static int sum_arr(int[] arr) {
		int sum =0;
		for (int i =0; i<arr.length;i++) {
			sum = sum + arr[i];
		}
		
		return sum;
	}
}