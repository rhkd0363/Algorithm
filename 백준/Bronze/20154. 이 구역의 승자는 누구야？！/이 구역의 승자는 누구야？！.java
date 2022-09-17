import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] stroke = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		
		String alpha = br.readLine();
		
		int resNum = 0;
		
		for(int i=0;i<alpha.length();i++) {
			resNum += stroke[alpha.charAt(i)-'A'];
		}
		
		if((resNum%10)%2 ==1)
			System.out.println("I'm a winner!");
		else
			System.out.println("You're the winner?");
	}
}