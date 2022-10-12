import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(arr[i], 987654321);
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start-1][end-1]= Math.min(arr[start-1][end-1],cost);
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				if(i==k) continue;
				for(int j=0;j<n;j++) {
					if(j==i) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 987654321) {
					sb.append(0).append(' ');
					continue;
				}
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}