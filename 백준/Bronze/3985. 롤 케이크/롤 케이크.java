import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//롤 케익 길이
		int L = Integer.parseInt(br.readLine());
		//롤 케익 배열
		int[] arr = new int[L+1];
		//방청객 수
		int N = Integer.parseInt(br.readLine());
		int[] pArr = new int[N+1];
		//가장 많은 조각 길이
		int max = 0;
		int f_num = 0;
		int s_num = 0;
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//시작 길이
			int str = Integer.parseInt(st.nextToken());
			//종료 길이
			int end = Integer.parseInt(st.nextToken());
			//기대되는 사람 구하기
			if(max < end-str) {
				max = end - str;
				f_num = i;
			}
			for(int j=str;j<=end;j++) {
				if(arr[j] == 0) {
					arr[j] = i;
					pArr[i]++;
				}
			}
		}
		max = 0;
		for(int i=1;i<pArr.length;i++) {
			if(max<pArr[i]) {
				max = pArr[i];
				s_num = i;
			}
		}
		System.out.println(f_num+"\n"+s_num);
	}
}