import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 중위 표기식 => 후위 표기식 : A*(B+C)-D/E => ABC+*DE/-
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 중위표기식 입력 받음
		String str = br.readLine();
		// 연산자를 담아줄 스택 선언
		Stack<Character> stack = new Stack<>();

		// 입력 받은 중위 표기식에서 괄호 또는 연산자가 나오면 스택에 값을 출력하거나, 스택에 넣어줌
		// 피 연산자일 시 출력에 넣어줌
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			// 여는 괄호일 시 스택에 담아준다.
			case '(':
				stack.push(str.charAt(i));
				break;
			// 닫는 괄호면 여는 괄호가 나올 때까지 스택에서 꺼내 출력, 마지막에 여는 괄호는 출력하지 않고 제거
			case ')':
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			// 곱하기, 나누기면 스택에 값이 있는지 확인하고 *,/ 라면 출력 후, 스택에 값을 넣어준다.
			case '*': case '/':
				if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
					sb.append(stack.pop());
				stack.push(str.charAt(i));
				break;
			// 더하기 빼기는 스택에 값이 있는지 확인하고, 여는 괄호가 아닐 때까지 값을 출력한다. 그 후 스택에 값을 넣는다.
			case '+': case '-':
				while (!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.push(str.charAt(i));
				break;
			// 피 연산자는 바로 출력
			default:
				sb.append(str.charAt(i));
				break;
			}
		}
		// 마지막에 스택에 남은 값을 전부 출력
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
