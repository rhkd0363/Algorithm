import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 1;
		
		factorial(N,result);
	}

	public static void factorial(int N, int result) {
		if (N < 2) {
			System.out.print(result);
			return;
		}
		result *= N--;
		factorial(N,result);
	}
}
