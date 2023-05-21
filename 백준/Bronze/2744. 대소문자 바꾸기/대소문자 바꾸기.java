import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		for(int i=0;i<input.length();i++) {
			if(Character.isUpperCase( input.charAt(i)) ){
				System.out.print(String.valueOf(input.charAt(i)).toLowerCase());
			}
			else {
				System.out.print(String.valueOf(input.charAt(i)).toUpperCase());		
			}
		}
   }
}