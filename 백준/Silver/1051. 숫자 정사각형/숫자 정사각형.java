import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String inputLine = br.readLine();
			map[i] = inputLine.toCharArray();
		}
		
		int result = 1;
		
		for(int i=0;i<N-result+1;i++) {
			for(int j=0;j<M-result+1;j++) {
				for(int k=j+result;k<M;k++) {
					
					if(map[i][j] == map[i][k]) {
						int diff = k - j;
						
						if(i+diff >= N || k >= M) continue;
						
						if(map[i][j] == map[i+diff][j] && map[i][k] == map[i+diff][k]) {
							result = Math.max(result, diff+1);
						}
					}
					
				}
			}
		}
		
		System.out.println(result*result);
	}
}