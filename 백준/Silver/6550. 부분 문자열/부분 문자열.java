import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			boolean check = true;
			String str = br.readLine();
			if(str == null) break;
			
			st = new StringTokenizer(str);
			
			String s = st.nextToken();
			String t = st.nextToken();
			
			int pos = 0;
			first:for(int i=0;i<s.length();i++) {
				for(int j=pos;j<=t.length()-(s.length()-i);j++) {
					if(s.charAt(i) == t.charAt(j)) {
						pos = j+1;
						continue first;
					}
				}
				check = false;
				break;
			}
			
			if(check) {
				sb.append("Yes").append('\n');
			}
			else {
				sb.append("No").append('\n');
			}
		}
		
		System.out.print(sb);
	}
}