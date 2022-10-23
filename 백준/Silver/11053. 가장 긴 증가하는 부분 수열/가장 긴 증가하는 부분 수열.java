import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] ans = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i] && max < ans[j]) {
					max = ans[j];
				}
			}
			ans[i] = max+1;
		}
		
		Arrays.sort(ans);
		
		System.out.println(ans[N-1]);
		
	}
}