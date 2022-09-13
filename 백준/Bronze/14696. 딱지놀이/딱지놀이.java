import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		//별 4 동글 3 네모 2 세모 1
		for(int n=0;n<N;n++) {
			int[] a = new int[5];
			int[] b = new int[5];
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			for(int i=0;i<I;i++) {
				a[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			for(int i=0;i<I;i++) {
				b[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int i=4;i>=1;i--) {
				if(a[i]>b[i]) {
					System.out.println("A");
					break;
				}
				else if(a[i]<b[i]) {
					System.out.println("B");
					break;
				}
				if(i==1) {
					System.out.println("D");
				}
			}
			
		}
	}
}