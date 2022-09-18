import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		w_pos: while(true) {
			String password = br.readLine();
			
			if(password.equals("end"))
				break;
			
			if(password.contains("a") || password.contains("e") ||
					password.contains("i") || password.contains("o")
					|| password.contains("u")) {
				for(int i=0;i<password.length()-1;i++) {
					if(password.charAt(i)==password.charAt(i+1) && password.charAt(i) != 'e' && password.charAt(i) !='o') {
						sb.append("<"+password+"> is not acceptable.").append('\n');
						continue w_pos;
					}
					if(i != password.length()-2 &&
							(password.charAt(i) =='a' || password.charAt(i) =='e' || password.charAt(i) =='i' ||
							password.charAt(i) =='o' || password.charAt(i) =='u') &&
							(password.charAt(i+1) =='a' || password.charAt(i+1) =='e' || password.charAt(i+1) =='i' ||
							password.charAt(i+1) =='o' || password.charAt(i+1) =='u') &&
							(password.charAt(i+2) =='a' || password.charAt(i+2) =='e' || password.charAt(i+2) =='i' ||
							password.charAt(i+2) =='o' || password.charAt(i+2) =='u')
							) {
						sb.append("<"+password+"> is not acceptable.").append('\n');
						continue w_pos;
					}
					else if(i != password.length()-2 &&
							(password.charAt(i) !='a' && password.charAt(i) !='e' && password.charAt(i) !='i' &&
							password.charAt(i) !='o' && password.charAt(i) !='u') &&
							(password.charAt(i+1) !='a' && password.charAt(i+1) !='e' && password.charAt(i+1) !='i' &&
							password.charAt(i+1) !='o' && password.charAt(i+1) !='u') &&
							(password.charAt(i+2) !='a' && password.charAt(i+2) !='e' && password.charAt(i+2) !='i' &&
							password.charAt(i+2) !='o' && password.charAt(i+2) !='u')
							) {
						sb.append("<"+password+"> is not acceptable.").append('\n');
						continue w_pos;
					}
				}
				sb.append("<"+password+"> is acceptable.").append('\n');
			}else {
				sb.append("<"+password+"> is not acceptable.").append('\n');
			}
		}
		
		System.out.println(sb);
	}
}