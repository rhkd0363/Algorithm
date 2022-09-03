import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			String str = br.readLine();
			
			int[] arr = new int[str.length()];
			int cnt = 0;
			for(int i =0;i<arr.length;i++) {
				if(arr[i] != (str.charAt(i)-'0')) {
					for(int j=i;j<arr.length;j++) {
						arr[j] = (str.charAt(i)-'0');
					}
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		
	}
}
