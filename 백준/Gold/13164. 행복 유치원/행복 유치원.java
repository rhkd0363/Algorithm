import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] diff = new int[N-1];
		
		for(int i=0;i<N-1;i++) {
			diff[i] = arr[i+1]-arr[i];
		}
		
		//sort 후 앞에서부터 N-K개를 더하면 된다.
		Arrays.sort(diff);
		
		long ans = 0L;
		
		for(int i=0;i<N-K;i++) {
			ans += diff[i];
		}
		
		System.out.println(ans);
	}
}
//1 3 5 6 10
// 2 2 1 4 (1개 조 9원 2개조 5원 3개조 3원 4개조 1= 1원)