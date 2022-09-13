import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 스택으로 사용할 ArrayList 선언
	static ArrayList<Integer> stack = new ArrayList<>();
	// 스택의 top 선언
	static int top = -1;
	static StringBuilder SB = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 명령의 수 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			// switch문을 통해 명령 실행
			switch (st.nextToken()){
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "top":
				top();
				SB.append('\n');
				break;
			case "size":
				size();
				SB.append('\n');
				break;
			case "empty":
				empty();
				SB.append('\n');
				break;
			case "pop":
				pop();
				SB.append('\n');
				break;
			}
		}
		System.out.print(SB);
	}
	
	static void push(int X) {
		stack.add(++top, X);
	}
	
	static void pop() {
		if(top == -1) {
			SB.append(-1);
			return;
		}
		SB.append(stack.remove(top--));
	}
	
	static void size() {
		SB.append(top+1);
	}
	
	static void empty() {
		if(top == -1)
			SB.append(1);
		else
			SB.append(0);
	}
	
	static void top() {
		if(top == -1) {
			SB.append(-1);
			return;
		}
		SB.append(stack.get(top));
	}
}