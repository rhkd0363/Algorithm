import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[2][7];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		int sum = 0;
		for(int i=0;i<=1;i++) {
			for(int j=1;j<=6;j++) {
				if(arr[i][j] != 0) {
					sum += Math.ceil((double)arr[i][j]/K);
			}}
		}
		System.out.println(sum);
	}
}