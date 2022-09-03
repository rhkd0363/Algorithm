import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T;tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int n =0;n<N;n++) {
				for(int i=N-1;i>=0;i--) {
					sb.append(arr[i][n]);
				}
				sb.append(" ");
				for(int i=N-1;i>=0;i--) {
					sb.append(arr[N-1-n][i]);
				}
				sb.append(" ");
				for(int i=0;i<N;i++) {
					sb.append(arr[i][N-1-n]);
				}
				sb.append("\n");
			}
			sb.delete(sb.length()-1, sb.length());
			System.out.println("#"+tc);
			System.out.println(sb);
		}
	}
}
