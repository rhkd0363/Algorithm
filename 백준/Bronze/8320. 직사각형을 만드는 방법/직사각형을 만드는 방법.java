import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = n;
		
		for(int i =2;i<=n/i;i++) {
			for(int j=i;;j++) {
				if(i*j>n) break;
				sum++;
			}
		}
		System.out.println(sum);
	}
}