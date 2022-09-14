import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 중위 표기식 => 후위 표기식 : A*(B+C)-D/E => ABC+*DE/-
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 피연산자 개수
		int N = Integer.parseInt(br.readLine());
		// 피연산자 값을 담을 배열 선언
		double[] dArr = new double[N];		
		// 후위 표기식을 입력 받아 문자 배열로 변환
		char[] operChk = br.readLine().toCharArray();
		// 피연산자 값을 배열에 입력 받음
		for(int i=0;i<N;i++) {
			dArr[i] = Double.parseDouble(br.readLine());
		}
		// 후위 표기식 계산을 위한 스택 선언
		Stack<Double> stack = new Stack<>();

		// 피 연산자 일 때는 스택에 넣고, 연산자가 나오면 피 연산자 2개를 꺼내 연산 후 스택에 다시  넣음
		for (int i = 0; i < operChk.length; i++) {
			// 스택에서 꺼낸 피 연산자의 연산 순서를 위한 변수 front, back 선언
			Double front;
			Double back;
			// 스위치 문을 통해 연산자일 경우 연산. 피 연산자일 경우 dArr배열에서 값을 찾아 스택에 넣어줌
			switch (operChk[i]) {
			case '*':
				back = stack.pop();
				front = stack.pop();
				stack.push(front * back);
				break;
			case '+':
				back = stack.pop();
				front = stack.pop();
				stack.push(front + back);
				break;
			case '-':
				back = stack.pop();
				front = stack.pop();
				stack.push(front - back);
				break;
			case '/':
				back = stack.pop();
				front = stack.pop();
				stack.push(front / back);
				break;
			default:
				stack.push(dArr[operChk[i]-'A']);
				break;
			}
		}
		//소수점 둘째 자리까지 출력
		System.out.printf("%.2f",stack.pop());
	}
}
