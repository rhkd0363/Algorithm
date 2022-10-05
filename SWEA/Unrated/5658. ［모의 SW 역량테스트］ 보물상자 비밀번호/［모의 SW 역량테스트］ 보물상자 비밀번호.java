import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

		// 테스트케이스 시작
		for (int t = 1; t <= T; t++) {
			// N, K 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 16진수 N개 입력
			String data = br.readLine();
			// 회전하므로 끝에서 시작해서 처음부분으로 이어지는 것을 고려 16진수데이터를 한번 더 이어붙힘
			data += data;
			// 중복제거용도 Set 선언
			Set<Integer> set = new HashSet<>();

			// N/4 자릿 수의 16진수 값 확인
			for (int i = 0; i < N; i++) {
				String hexData = ""; // 16진수이므로 String으로 받아줌
				for (int j = i; j < i + N / 4; j++) { // i 번째 자리부터 i+N/4 자리까지 더함
					hexData += data.charAt(j);
				}
				// 10진수로 변환하고 set에 넣어줌(중복 존재 시 제거됨)
				set.add(Integer.parseInt(hexData, 16));
			}
			// 구한 Set을 List로 변환
			List<Integer> list = new ArrayList<>(set);
			// 내림차순 정렬
			Collections.sort(list,Collections.reverseOrder());
			// 답 출력
			sb.append('#').append(t).append(' ').append(list.get(K-1)).append('\n');
		}
		System.out.println(sb);
	}
}