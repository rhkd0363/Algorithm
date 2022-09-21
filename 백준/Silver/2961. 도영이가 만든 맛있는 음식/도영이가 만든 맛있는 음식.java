import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sour,bitter;
	static boolean check[];
	static int N;
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 재료의 수
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		check = new boolean[N];
		res = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		getDiff(0,0);
		
		System.out.println(res);
	}
	
	static void getDiff(int idx,int cnt) {
		if(idx == N) {
			if(cnt == 0) return;
//			System.out.println(Arrays.toString(check));
			int sValue = 1;
			int bValue = 0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					// 선택된 재료로 계산~~
					sValue *= sour[i];
					bValue += bitter[i];
				}
			}
			res = Math.min(res,Math.abs(sValue-bValue));
			return;
		}
		
		check[idx] = true;
		getDiff(idx+1,cnt+1);
		check[idx] = false;
		getDiff(idx+1,cnt);
	}
	
	
}