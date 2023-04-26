import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[][] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int ans=3;
		int[][][] dp=new int[N+1][2][3];
		dp[1][0][0]=1;
		dp[1][0][1]=1;
		dp[1][1][0]=1;
		
		for(int i=2;i<=N;i++) {
			dp[i][0][0]=dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]; //출석
			dp[i][0][1]=dp[i-1][0][0]; // 0,0 -> 0,1
			dp[i][0][2]=dp[i-1][0][1]; // 0,1 -> 0,2
			dp[i][1][0]=ans; // 0,0 -> 1,0
			dp[i][1][1]=dp[i-1][1][0]; // 1,0 -> 1,1
			dp[i][1][2]=dp[i-1][1][1]; // 1,1 -> 1,2
			
			ans=0;
			
			for(int j=0;j<2;j++) {
				for(int k=0;k<3;k++){
					dp[i][j][k]%=1000000;
					ans+=dp[i][j][k];
				}
			}
			
			ans%=1000000;
		}
		
		System.out.println(ans);
   }
}