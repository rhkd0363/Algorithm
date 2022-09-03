import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//1과 자기자신으로만 나눠져야함.
		fo:for(int i=0;i<N;i++) {
			int number = Integer.parseInt(st.nextToken());
			if(number == 1)
				continue fo;
			for(int j=2;j<=Math.sqrt(number);j++) {
				if(number%j == 0) {
					continue fo;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}