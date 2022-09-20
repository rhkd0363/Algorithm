import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 파일 수 입력
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		// Map에 확장자명, 수 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();

			String key = st.nextToken();

			if (map.get(key) == null) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}

		}

		// 키 값(확장자 명) 정렬
		Object[] keySet = map.keySet().toArray();
		Arrays.sort(keySet);

		StringBuilder sb = new StringBuilder();
		for (Object s : keySet) {
			sb.append(s).append(' ').append(map.get(s)).append('\n');
		}
		System.out.println(sb);
	}
}