import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		int[] arr = new int[N];
		int[] cnt = new int[8001];
		int maxCnt = 0;
		int maxSub = 0;
		int maxidx = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			cnt[arr[i]+4000]++;
			sum += arr[i];
			if(maxCnt<=cnt[arr[i]+4000]) {
				maxSub = maxCnt;
				maxCnt = cnt[arr[i]+4000];
				maxidx = arr[i];
			}
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(sum/N)).append('\n'); //산술평균
		sb.append(arr[N/2]).append('\n');//중앙값
		if(maxCnt == maxSub) {
			for(int i = 0,count = 0;i<8001;i++) {
				if(cnt[i] == maxCnt) {
					count++;					
				}
				if(count == 2) {
					maxidx = i-4000;
					break;
				}	
			}
		}
		sb.append(maxidx).append('\n');//최빈값
		sb.append(arr[N-1]-arr[0]);
		System.out.println(sb);
		
	}

}