import java.io.*;
import java.util.*;

public class Main {
	static List<int[]>[] positionList;
	static int answer;
	static boolean[] checked;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=0;tc<T;tc++) {
			answer = 0;
			checked = new boolean[12];
			positionList = new ArrayList[12];
			
			for(int i=1;i<12;i++)
				positionList[i] = new ArrayList<>();
			
			for(int i=0;i<11;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=1;j<12;j++) {
					int stats = Integer.parseInt(st.nextToken());
					
					if(stats > 0)
						positionList[j].add(new int[] {i, stats});
				}
			}
			
			DFS(1,0);
			
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int idx, int value) {
		if(idx > 11) {
			answer = Math.max(answer, value);
			return;
		}
		
		for(int i=0;i<positionList[idx].size();i++) {
			if(!checked[positionList[idx].get(i)[0]]) {
				checked[positionList[idx].get(i)[0]] = true;
				DFS(idx+1, value + positionList[idx].get(i)[1]);
				checked[positionList[idx].get(i)[0]] = false;				
			}
		}
	}
}