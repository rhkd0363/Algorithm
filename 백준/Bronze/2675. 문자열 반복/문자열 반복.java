import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int j=0;j<str.length();j++) {
				for(int k=0;k<r;k++)
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}
}
