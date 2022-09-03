import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '<') {
				while(str.charAt(i)!='>') {
					sb.append(str.charAt(i));
					i++;
				}
				sb.append(str.charAt(i));
			}
			else {
				while(i<str.length()&&str.charAt(i)!=' '&&str.charAt(i)!='<') {
					stack.push(str.charAt(i));
					i++;
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());					
				}
				if(i<str.length()&&str.charAt(i)==' ')
					sb.append(str.charAt(i));
				else if(i<str.length()&&str.charAt(i)=='<')
					i--;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}