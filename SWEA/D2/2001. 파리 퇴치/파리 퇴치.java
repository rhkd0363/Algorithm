import java.util.Scanner;

//M크기만큼 제일 큰 수 
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tN = sc.nextInt();

		for (int i = 1; i <= tN; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					map[x][y] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int sum = 0;
					for(int dx = 0;dx<M;dx++) {
						for(int dy = 0;dy<M;dy++) {
							int nx = x+dx;
							int ny = y+dy;
							if(nx>=0 && ny>=0 && nx<N && ny<N) {
								int value = map[nx][ny];
								sum += value;								
							}
						}
					}
					if(sum>max) {
						max =sum;
					}
				}
			}
			System.out.println("#"+i+" "+max);
		}
	}
}
