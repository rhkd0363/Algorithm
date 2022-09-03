import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//메시지의 총 글자
		int N = str.length();
		//R<=C, R*C=N인 R과 C를 고른다. 여러개일 경우 R이 큰 값을 선택한다.
		int R = 1;
		int C = N;
		for(int i=1;i<=N;i++) {
			for(int j=N;j>=i;j--) {
				if(i*j==N) {
					R = i;
					C = j;
				}
			}
		}
		//정인이가 이미 암호화해서 준걸 해독하는 것.....
		char[][] arr = new char[R][C];
		int k = 0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				arr[j][i] = str.charAt(k++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int j=0;j<R;j++) {
			for(int i=0;i<C;i++) {
				sb.append(arr[j][i]);
			}
		}
		System.out.println(sb);
	}
}