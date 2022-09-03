import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			int cnt = 0;
			//n보다 크고 2n보다 작거나 같은.
			fo: for (int i = N+1; i <= 2 * N; i++) {
				if (i == 1)
					continue fo;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0)
						continue fo;
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
