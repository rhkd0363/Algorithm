import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 사람 수 입력
		int N = Integer.parseInt(br.readLine());
		// 몸무게, 키를 담을 배열 선언
		int[][] person = new int[N][N];
		// 등수를 나타낼 배열 선언
		int[] rank = new int[N];
		// rank배열의 초기값을 1로 세팅
		Arrays.fill(rank, 1);
		
		// 몸무게, 키 입력받음
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			//몸무게
			person[i][0] = Integer.parseInt(st.nextToken());
			//키
			person[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 맨 처음부터 끝까지 앞에 등수가 계산된 사람과의 몸무게와 키를 비교
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				// 몸무게와 키 둘 다 크면 비교대상 등수 증가
				if(person[i][0] > person[j][0] && person[i][1] > person[j][1]) {
					rank[j]++;
				}
				// 몸무게와 키 둘 다 작으면 현재 인덱스의 등수 증가
				else if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
					rank[i]++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			sb.append(rank[i]+" ");
		}
		
		System.out.print(sb);
	}
}