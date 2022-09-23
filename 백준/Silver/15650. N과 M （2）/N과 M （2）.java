import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int N, M;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		
		perm(0,0);
		
		System.out.println(SB);
	}
	
	static void perm(int idx, int sidx) {
		if(sidx == M) {
			for(int i=0;i<N;i++) {
				if(check[i])
					SB.append(i+1).append(' ');
			}
			SB.append('\n');
			return;
		}
		else if(idx >= N) {
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(!check[i]) {
				check[i] = true;
				perm(i+1,sidx+1);
				check[i] = false;
			}
		}
		
	}
}
