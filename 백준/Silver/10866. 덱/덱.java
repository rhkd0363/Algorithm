import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	// 배열로 덱 선언
	static int[] deque;
	static int front, back, size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 명령의 수 입력
		int N = Integer.parseInt(br.readLine());
		// 배열의 크기 => 명령의 수(N)*2 -1, 시작배열 => N-1
		deque = new int[N * 2 - 1];
		front = N - 1;
		back = N - 1;
		size = 0;
		for (int i = 0; i < N; i++) {
			// 명령을 입력 받고 해당하는 case에서 처리
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				pop_front();
				SB.append('\n');
				break;
			case "pop_back":
				pop_back();
				SB.append('\n');
				break;
			case "size":
				SB.append(size).append('\n');
				break;
			case "empty":
				empty();
				SB.append('\n');
				break;
			case "front":
				front();
				SB.append('\n');
				break;
			case "back":
				back();
				SB.append('\n');
				break;
			}
		}
		System.out.print(SB);
	}

	static void push_front(int X) {
		if (size == 0) {
			deque[front] = X;
		} else {
			deque[--front] = X;
		}
		size++;
	}

	static void push_back(int X) {
		if (size == 0) {
			deque[back] = X;
		} else {
			deque[++back] = X;
		}
		size++;
	}

	static void pop_front() {
		if (size == 0) {
			SB.append(-1);
			return;
		}
		if (front == back) {
			SB.append(deque[front]);
		} else {
			SB.append(deque[front++]);
		}
		size--;
	}

	static void pop_back() {
		if (size == 0) {
			SB.append(-1);
			return;
		}
		if (front == back) {
			SB.append(deque[back]);
		} else {
			SB.append(deque[back--]);
		}
		size--;
	}

	static void empty() {
		if (size == 0) {
			SB.append(1);
		} else {
			SB.append(0);
		}
	}

	static void front() {
		if (size == 0) {
			SB.append(-1);
			return;
		}
		SB.append(deque[front]);
	}

	static void back() {
		if (size == 0) {
			SB.append(-1);
			return;
		}
		SB.append(deque[back]);
	}
}