import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			String functions = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			String inputLine = br.readLine(); 
			
			String[] list = inputLine.substring(1, inputLine.length() - 1).split(",");
			
			boolean flag = true; // true : 정방향 ,false : 역방향
			
			int front = 0;
			int rear = 0;
			
			for(int i=0;i<functions.length();i++) {
				flag = functions.charAt(i) == 'R' ? !flag : flag;
				front += functions.charAt(i) == 'D' && flag ? 1 : 0;
				rear += functions.charAt(i) == 'D' && !flag ? 1 : 0;
			}
			
			if(front+rear > n) {
				sb.append("error").append('\n');
				continue;
			}
			
			sb.append("[");
			
			if(flag) {
				for(int i=front;i< list.length - rear;i++) {
					sb.append(list[i]).append(',');
				}
			}else {
				for(int i=list.length - rear -1; i >= front; i--) {
					sb.append(list[i]).append(',');
				}				
			}
			
			if(sb.charAt(sb.length()-1) == ',')
				sb.deleteCharAt(sb.length() - 1);
			
			sb.append(']').append('\n');
		}
		
		System.out.println(sb);
	}
}
