import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		
		int[] val = new int[X+1];
		val[1] = 1;
		
		for(int i=2;i<=X;i++) {
			val[i] = val[i-1]+1;
			//2로나누어떨어지면
			if(i%2 == 0) {
				val[i] = Math.min(val[i], val[i/2]+1);
			}
			//3로나누어떨어지면
			if(i%3 == 0) {
				val[i] = Math.min(val[i], val[i/3]+1);
			}
		}
		
		System.out.println(val[X]-1);
		
	}

}
