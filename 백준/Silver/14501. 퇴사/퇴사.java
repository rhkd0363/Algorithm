import java.io.*;
import java.util.*;

public class Main {
	static int N, answer;
	static int[][] consultingList;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		consultingList = new int[N+1][2];
		
		StringTokenizer st;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			consultingList[i][0] = Integer.parseInt(st.nextToken());
			consultingList[i][1] = Integer.parseInt(st.nextToken());			
		}
		
		answer = 0;
		
		DFS(1,0);
		
		System.out.println(answer);
	}
	
	static void DFS(int day, int value) {
		if(day > N + 1)
			return;
		
		answer = Math.max(answer, value);
		
		for(int i=day;i<=N;i++) {
			DFS(i + consultingList[i][0], value + consultingList[i][1]);
		}
	}
}
