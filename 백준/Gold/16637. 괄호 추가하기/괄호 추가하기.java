import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int ans;
	static List<Character> oper;
	static List<Integer> number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		oper = new ArrayList<>();
		number = new ArrayList<>();

		String input = br.readLine();

		for (int i = 0; i < N; i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				oper.add(c);
				continue;
			}
			number.add(c - '0');
		}
		ans = Integer.MIN_VALUE;
		
		dfs(number.get(0), 0);

		System.out.println(ans);

	}

	static int calc(char oper, int a, int b) {
		switch (oper) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return -1;
	}

	static void dfs(int result, int idx) {
		if (idx >= oper.size()) {
			ans = Math.max(ans, result);
			return;
		}

		dfs(calc(oper.get(idx), result, number.get(idx + 1)), idx + 1);// 괄호없이

		if (idx < oper.size() - 1) {
			dfs(calc(oper.get(idx), result, calc(oper.get(idx + 1), number.get(idx + 1), number.get(idx + 2))), idx + 2);
		}

	}
}
