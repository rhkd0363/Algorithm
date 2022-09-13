import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		String[] c = b.split("");
		
		for(int i=c.length-1;i>=0;i--) {
			System.out.println(a*Integer.parseInt(c[i]));
		}
		System.out.println(a*Integer.parseInt(b));
	}
}