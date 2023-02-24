import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder answer = new StringBuilder();

		while (true) {
			String input = br.readLine();
			boolean flag = true;
			
			if (input.equals("0"))
				break;

			for (int i = 0; i < input.length() / 2; i++) {
				if(input.charAt(i) != input.charAt(input.length()-1-i)) {
					flag = false;
					break;
				}
			}
			
			answer.append(flag ? "yes" : "no").append("\n");
		}

		System.out.println(answer);
	}
}
