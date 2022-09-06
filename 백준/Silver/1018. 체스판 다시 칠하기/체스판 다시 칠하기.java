import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로 길이, 세로 길이
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 보드 배열 선언
		char[][] board = new char[N][M];
		// 보드 값 입력
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
		}
        // 결과로 출력할 변수 선언
		int result = Integer.MAX_VALUE;
        // 8*8 크기로 보드 전체를 확인
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				int count = 0;
                // 8*8 크기를 확인하며 체스판의 색이 다른 곳을 찾으면 count++
				for(int x=i;x<i+8;x++) {
					char check;
					if(x%2 == 0)
						check = 'W';
					else
						check = 'B';
					for(int y=j;y<j+8;y+=2) {
						if(board[x][y] == check) {
							count++;
						}
					}
					for(int y=j+1;y<j+8;y+=2) {
						if(board[x][y] != check) {
							count++;
						}
					}
				}
                // 최솟값을 찾아 결과에 할당
				result = Math.min(result, Math.min(count, 64-count));
			}
		}
        // 결과 출력
		System.out.println(result);
	}
}