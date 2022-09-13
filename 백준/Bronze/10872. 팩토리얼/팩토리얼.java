import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 1;
		for(int i=N;i>1;i--) {
			result *= i;
		}
		System.out.print(result);
	}
}