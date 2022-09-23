import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W,H;
	static int[][] map;
	static int ans;
	
	static int[] dx = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		while(W != 0 && H != 0) {
			map = new int[W][H];
						
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			findIsland(0);
			
			sb.append(ans).append('\n');
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}//테케
		
		System.out.print(sb);
	}
	
	static void findIsland(int idx) {
		
		// 섬을 찾는다.
		int sR = -1,sC = -1;
		out : for(int i=0;i<W;i++) {
			for(int j=0;j<H;j++) {
				if(map[i][j] == 1) {
					sR = i; sC = j;
					break out;
				}
			}
		}
		
		// 더이상찾을 섬이 없다면
		if(sR == -1 && sC == -1) {
			ans = idx;
			return;
		}
		
		// 섬의 개수를 센다..
		// 찾은 sR,sC 와 연결된 섬의 범위를 0으로 만든다.
		checkMap(sR,sC);
		findIsland(idx+1);
	}
	
	static void checkMap(int i, int j) {
		if(map[i][j] == 1) {
			map[i][j] = 0;
			for(int x=0;x<3;x++) {
				for(int y=0;y<3;y++) {
					if(i+dx[x] >= W || j+dx[y] >= H || i+dx[x] < 0||j+dx[y] < 0) {
						continue;
					}
					checkMap(i+dx[x],j+dx[y]);		
				}
			}
		}
	}
}
