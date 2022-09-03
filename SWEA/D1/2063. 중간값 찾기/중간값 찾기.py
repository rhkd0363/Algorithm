import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for(int i= 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}		
		Arrays.sort(arr);
		//N은 항상 홀수
		System.out.println(arr[arr.length/2]);
	}
}
