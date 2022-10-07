import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 가능한 무게
		
		int[][] value = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<K+1;j++) {
				if(j < W)
					value[i][j] = value[i-1][j];
				else
					value[i][j] = Math.max(value[i-1][j], value[i-1][j-W]+V);
			}
		}
		
		System.out.println(value[N][K]);
		
	}
}