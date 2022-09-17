import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] cArr = new char[5][15];
		
		for(int i=0;i<5;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				cArr[i][j] = str.charAt(j);
			}
		}
		
		for(int j=0;j<15;j++) {
			for(int i=0;i<5;i++) {
				if(cArr[i][j] ==  '\u0000')
					continue;
				sb.append(cArr[i][j]);
			}
		}
		
		System.out.println(sb);
	}
}