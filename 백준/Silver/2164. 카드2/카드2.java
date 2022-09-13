import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int i = 0;
		while(true) {
			if(N <= Math.pow(2,i)) {
				int tmp = (int)(Math.pow(2,i))-N;
				System.out.println((int)(2 * (Math.pow(2,i-1)-tmp)));
				break;
			}
			i++;
		}
	}
}
