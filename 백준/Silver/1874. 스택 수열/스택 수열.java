import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder SB = new StringBuilder();
		// 스택 만들어 줌
		Stack<Integer> stack = new Stack<>();
		// N 입력
		int N = Integer.parseInt(br.readLine());
		// 스택에 push된 값 담아줄 변수
		int pos = 0;
		
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			// num이 pos보다 크다면 stack에 push
			if (num > pos) {
				for ( ; pos < num; pos++) {
					stack.push(pos + 1);
					SB.append('+').append('\n');
				}
			}
			// num이 stack의 출력 값과 같다면 pop, 아니라면 NO출력하고 리턴해서 종료
			if (num == stack.peek()) {
				stack.pop();
				SB.append('-').append('\n');
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(SB);
	}
}