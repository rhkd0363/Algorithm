import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i =1;i<=T;i++) {
			int[] arr = new int[10];			
			
			for(int j=0;j<arr.length;j++) {
				arr[j] = sc.nextInt();
			}
			
			int[] temp = countSort(arr);
			double res =0;
			for(int j=0;j<temp.length;j++) {
				res += temp[j];
			}
			res = res - temp[0] - temp[temp.length-1];
			
			res = res/8;
			
			System.out.println("#"+i+" "+Math.round(res));
		}
		
	}
	
	
	
	static int[] countSort(int[] arr) {
		int N = arr.length;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(arr[i]>max) max = arr[i];
		}
		int[] count = new int[max+1];
		int[] temp =  new int[N];
		
		for(int i=0;i<N;i++) {
			count[arr[i]]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i] +=count[i-1];
		}
		for(int i =N-1; i>=0;i--) {
			temp[--count[arr[i]]] = arr[i];
		}
		return temp;
	}
}
