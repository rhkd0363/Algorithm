import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] memo = new int[11]; // n은 11보다 작다, n은 양수이다.
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
		for(int i=3;i<11;i++) {
			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			sb.append(memo[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.println(sb);
	}
}