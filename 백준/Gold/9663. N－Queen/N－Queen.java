import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] choice;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		result = 0;

		choice = new int[N + 1];

		DFS(1);

		System.out.println(result);
	}

	static void DFS(int line) {
		if (line == N + 1) {
			result++;
			return;
		}

		loop: for (int i = 1; i <= N; i++) {
			for (int j = 1; j < line; j++) {
				if (choice[j] == i || choice[j] + line - j == i || choice[j] - (line - j) == i) {
					continue loop;
				}
			}
			choice[line] = i;

			DFS(line + 1);
		}

	}
}
