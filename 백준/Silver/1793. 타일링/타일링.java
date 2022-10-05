import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		BigDecimal[] memo = new BigDecimal[251];
		memo[0] = new BigDecimal(1);
		memo[1] = new BigDecimal(1);
		memo[2] = new BigDecimal(3);
		
		for(int i=3;i<251;i++) {
			memo[i] = memo[i-1].add(memo[i-2].multiply(new BigDecimal(2)));
		}
		
		
		String input;
		while((input = br.readLine()) != null) {
			sb.append(memo[Integer.parseInt(input)]).append('\n');
		}
		
		System.out.println(sb);
	}
}