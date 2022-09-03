import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] arr = new char[80];
			st = new StringTokenizer(br.readLine());
			arr = st.nextToken().toCharArray();
			int cnt =1;
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == 'O') {
					sum += cnt++;
					continue;
				}
				cnt = 1;
			}
			System.out.println(sum);
		}

	}
}
