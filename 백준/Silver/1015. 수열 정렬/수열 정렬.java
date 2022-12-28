import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] iArr = new int[N];
		boolean[] checked = new boolean[1001]; 
				
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			iArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N];
		
		for(int i=0;i<N;i++) {
			if(checked[iArr[i]]) {
				for(int j=0;j<i;j++) {
					if(iArr[j] <= iArr[i])
						result[i]++;
				}
				for(int j=i;j<N;j++) {
					if(iArr[j] < iArr[i])
						result[i]++;
				}
			}else {
				checked[iArr[i]] = true;
				for(int j=0;j<N;j++) {
					if(iArr[j] < iArr[i])
						result[i]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int res : result) {
			sb.append(res).append(' ');
		}
		
		System.out.print(sb);
	}
}