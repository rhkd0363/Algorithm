import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String s = "";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) != '0' && str.charAt(i) != '1' &&str.charAt(i) != '2' &&str.charAt(i) != '3' &&str.charAt(i) != '4' &&str.charAt(i) != '5' &&str.charAt(i) != '6' &&str.charAt(i) != '7' &&str.charAt(i) != '8' &&str.charAt(i) != '9')
				s +=str.charAt(i);
		}
		
		if(s.contains(br.readLine())){
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}