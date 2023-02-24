import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input  = br.readLine();
		int length = input.length();
		
		long answer = 0;
		
		for(int i = 1; i < length; i++) {
			answer += 9 * Math.pow(10, i-1) * i;
		}
		
		answer += (Integer.parseInt(input) - Math.pow(10, length-1) + 1) * length;
		
		System.out.println(answer);
		
	}
}