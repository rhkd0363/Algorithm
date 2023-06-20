import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numList = new int[N-1];
		
		for(int i=0;i<N-1;i++)
			numList[i] = Integer.parseInt(st.nextToken());
		
		int answer = Integer.parseInt(st.nextToken());
		
		long[][] arr = new long[N-1][21];
		
		arr[0][numList[0]] = 1;
		
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<=20;j++) {
				if(arr[i-1][j] != 0) {
					if(j + numList[i] >= 0 && j + numList[i] <= 20) {
						arr[i][j + numList[i]] += arr[i-1][j];
					}
					
					if(j - numList[i] >= 0 && j - numList[i] <= 20) {
						arr[i][j - numList[i]] += arr[i-1][j];
					}			
				}
			}
		}
		System.out.println(arr[N-2][answer]);
	}
}