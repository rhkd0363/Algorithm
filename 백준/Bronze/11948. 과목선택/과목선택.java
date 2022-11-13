import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = 0;
		int b = 0;
		int c = 100; 
		
		for(int i=0;i<4;i++) {
			int x = Integer.parseInt(br.readLine());		
			a += x;		
			c = Math.min(c, x); 
		}	
		b = Integer.parseInt(br.readLine());	
		b = Math.max(b, Integer.parseInt(br.readLine()));	
		System.out.println(a-c+b);
	}
}