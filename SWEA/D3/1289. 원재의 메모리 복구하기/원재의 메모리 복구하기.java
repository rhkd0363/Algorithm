import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			
			int[] arr = new int[ch.length];
			int cnt = 0;
			for(int i =0;i<arr.length;i++) {
				if(arr[i] != (ch[i]-'0')) {
					for(int j=i;j<arr.length;j++) {
						arr[j] = (ch[i]-'0');
					}
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		
	}
}
