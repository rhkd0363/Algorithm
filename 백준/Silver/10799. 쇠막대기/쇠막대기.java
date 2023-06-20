import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;	// 결과로 출력할 변수
		int cnt = 0; // 쌓여있는 막대기 수를 담을 변수
		// 괄호 문자 입력
		String str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			// 괄호 종류에 따라 처리
			switch (str.charAt(i)) {
			case '(':
				if(str.charAt(i+1) == ')') { //레이저인 경우 => 쌓인 막대의 수 만큼 잘린 쇠막대기 수 증가
					i++;
					result+=cnt;
				} else { // 막대의 끝인 경우 쌓인 수가 줄고 잘린 쇠막대수 증가
					cnt++;
				}
				break;
			case ')': //레이저가 아닌 경우 => 쌓인 막대의 수가 줄고 잘린 쇠막대기 조각 수 증가
				result++;
				cnt--;
				break;
			}
		}
		//결과 출력
		System.out.println(result);
	}
}