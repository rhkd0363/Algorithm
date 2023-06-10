import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i=N/2+1;i>0;i--) {
			int sum = 0;
			for(int j=i;j>0;j--) {
				sum += j;
				
				if(sum == N) {
					result++;
					break;
				}
				if(sum > N) {
					break;
				}
			}			
			if(sum < N) {
				break;
			}
		}
		
		if(N < 3)
			System.out.println(result);
		else
			System.out.println(result+1);
		
		
	}
}