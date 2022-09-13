import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	// ArrayList => 시간초과, 배열로 큐 선언
	static int[] queue;
	static int front = -1;
	static int back = -1;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 명령의 수 입력
		int N = Integer.parseInt(br.readLine());
		// N크기로 큐 배열 생성
		queue = new int[N];
		for (int i = 0; i < N; i++) {
			// 명령을 입력 받고 해당하는 case에서 처리
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				pop();
				SB.append('\n');
				break;
			case "size":
				SB.append(size).append('\n');
				break;
			case "empty":
				if (size == 0)
					SB.append(1);
				else
					SB.append(0);
				SB.append('\n');
				break;
			case "front":
				if (size == 0) {
					SB.append(-1);
				} else {
					SB.append(queue[front]);
				}
				SB.append('\n');
				break;
			case "back":
				if (size == 0) {
					SB.append(-1);
				} else {
					SB.append(queue[back]);
				}
				SB.append('\n');
				break;
			}
		}
		System.out.print(SB);
	}

	static void push(int X) {
		if (size == 0) {
			queue[++front] = X;
			back = front;
		} else {
			queue[++back] = X;
		}
		size++;
	}

	static void pop() {
		if (size == 0) {
			SB.append(-1);
			return;
		}
		SB.append(queue[front++]);
		size--;
	}
}