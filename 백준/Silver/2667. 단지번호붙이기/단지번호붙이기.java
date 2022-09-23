import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static int[][] map;
	static int cnt;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}

		dfs(0,0);
		
		StringBuilder sb = new StringBuilder();

		Collections.sort(list);
		
		sb.append(cnt).append('\n');
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');			
		}
		
		System.out.println(sb);
	}

	static void dfs(int r, int idx) {

		int sR = -1, sC = -1;
		out: for (int i = r; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					sR = i;
					sC = j;
					break out;
				}
			}
		}
		
		if(sR == -1 && sC == -1) {
			cnt = idx;
			return;
		}
		
		num = 0;
		getNum(sR,sC);
		list.add(num);
		
		dfs(sR,idx+1);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};	
	static int num;
	
	static void getNum(int r, int c) {
		if(map[r][c] != 1)
			return;
		
		map[r][c] = 0;		
		num++;
		
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			
			if(nx >= N || ny >= N || nx <0 || ny <0)
				continue;
			
			getNum(nx,ny);
		}	
	}
}
