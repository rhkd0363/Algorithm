import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		arr[0] = 1;
		int i=0;
		int cnt = 0;
		while(true) {
			if(arr[i] == M) break;
			//시계
			if(arr[i]%2 == 1) {
				i = (i+L)%N;
				arr[i]++;
			}
			//반시계
			else {
				i = i-L;
				for(;i<0;)
					i = N+i;
				arr[i]++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
