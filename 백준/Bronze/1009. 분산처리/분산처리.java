import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ans = 1;
			for(int i=0;i<b;i++) {
				ans = (ans * a) %10;
			}
			
			if(ans == 0)
				sb.append(10).append('\n');
			else
				sb.append(ans%10).append('\n');
		}
		System.out.println(sb);
	}
}