import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		fo : for(int i=M;i<=N;i++) {
			if(i==1)
				continue fo;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j == 0)
					continue fo;
			}
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}
}
