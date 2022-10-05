import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		memo = new int[1001];
		Arrays.fill(memo, -1);
		memo[1] = 1;
		memo[2] = 3;
		
		
		System.out.println(dp(n));
	}
	
	static int[] memo;
			
	static int dp(int n) {
		if(memo[n] == -1)
			memo[n] = (dp(n-1)+(dp(n-2)*2)%10007)%10007;
		return memo[n];
	}
}