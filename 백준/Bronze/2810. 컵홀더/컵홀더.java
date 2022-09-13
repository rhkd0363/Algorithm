import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//컵 홀더에 컵을 꽂을 수 있는 최대 사람 수를 구하라.
//S는 일반좌석, L은 커플석 L은 항상 두개씩 쌍으로 주어진다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//좌석 수
		int n = Integer.parseInt(br.readLine());
		//좌석정보
		String str = br.readLine();
		
		int cnt = 1;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'L') i++;
			cnt++;
		}
		
		if(cnt>n) cnt = n;
		System.out.println(cnt);
	}
}