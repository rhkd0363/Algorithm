import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine()); 
		int B = Integer.parseInt(br.readLine()); 
		int C = Integer.parseInt(br.readLine()); 
		
		int res = A*B*C;
		
		int[] arr = new int[10];
		
		while(res != 0) {
			arr[res%10]++;
			res = res/10;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<10;i++)
			sb.append(arr[i]).append('\n');
		
		System.out.print(sb);
	}
}
