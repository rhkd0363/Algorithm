import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, maxValue;
	static int[] Arr;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Arr = new int[N+M+1];
			check = new boolean[N+M+1];
			getSum();				
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" ");
			
			for(int i=2;i<check.length;i++) {
				if(check[i])
					sb.append(i+" ");					
			}
			
			System.out.println(sb);
		}		
	}
	
	static void getSum() {
		maxValue = 0;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				Arr[i+j]++;
				maxValue = Math.max(maxValue, Arr[i+j]);
			}
		}
		
		for(int i=2;i<Arr.length;i++) {
			if(maxValue == Arr[i])
				check[i] = true;
		}
		
	}
}
