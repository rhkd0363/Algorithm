import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		
		int _a =0;
		int _b =0;
		for (int j = a.length()-1; j >= 0; j--) {
			_a += (int) ((a.charAt(j)-48) * Math.pow(10, j));
		}
		for (int j = b.length()-1; j >= 0; j--) {
			_b += (int) ((b.charAt(j)-48) * Math.pow(10, j));

		}
		if(_a > _b)
			System.out.println(_a);
		else
			System.out.println(_b);
	}
}
