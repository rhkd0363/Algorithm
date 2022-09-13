import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[101][101];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					paper[j][k] = 1;
				}
			}
		}
		int result =0;
		for(int i=0;i<paper.length;i++) {
			for(int j=0;j<paper.length;j++) {
				if(paper[i][j] == 1) result++;
			}
		}
		
		System.out.println(result);
		
	}
}
