import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int N;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			map = new int[N][N];
			res = 0;
			
			putQueen(0);
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	static void putQueen(int r) {
		if(r == N) {
			res++;
			return;
		}
		
		fo : for(int c=0;c<N;c++) {
			int left = c - 1;
			int right = c + 1;
			for(int i = r-1;i>=0;i--) {
				if(map[i][c] == 1) {
					continue fo;
				}else if(left>=0 && map[i][left--] == 1) {
					continue fo;
				}else if(right <N&&map[i][right++] == 1) {
					continue fo;
				}
			}
			map[r][c] = 1;
			putQueen(r+1);
			map[r][c] = 0;
		}
	}
}
