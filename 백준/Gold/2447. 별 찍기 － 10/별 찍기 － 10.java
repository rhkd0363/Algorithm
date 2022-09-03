import java.io.*;
import java.util.Arrays;

public class Main {
	static char[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 3의 거듭제곱 입력 받음
		N = Integer.parseInt(br.readLine());
		// N크기만큼의 2차원 배열 생성
		map = new char[N][N];

		//'*'로 배열을 전부 채워줌
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], '*');
		}

		star(N);
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	// N 마다 (N/3) 행(N/3) 열 만큼 공백
	// N = 27 => map[9][9] 부터 27칸 간격마다 9줄-9칸 공백 
	// N = 9  => map[3][3] 부터 9칸 간격마다 3줄-3칸 공백
	// N = 3  => map[1][1] 부터 3칸 간격마다 1줄-1칸 공백
	public static void star(int N) {
		if (N == 1)
			return;
		// ... => 27 => 9 => 3 => 1(종료)
		N = N / 3;
		
		for (int i = N; i < map.length; i += N*3) {
			for (int j = N; j < map.length; j += N*3) {
				for (int k = i; k < i + N && k< map.length-N; k++) {
					for (int l = j; l < j + N && l<map.length-N; l++) {
						map[k][l] = ' ';
					}
				}
			}
		}
		//확인용도
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		// ... => 27 => 9 => 3 => 1(종료)
		star(N);
	}
}

