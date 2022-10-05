import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigDecimal[] fact = new BigDecimal[n+1];
		fact[0] = new BigDecimal(1);
		fact[1] = new BigDecimal(1);
		
		for(int i=2;i<n+1;i++) {
			fact[i] = fact[i-1].multiply(new BigDecimal(i));
		}
		
		System.out.println(fact[n].divide(fact[n-m].multiply(fact[m])));
	}
}