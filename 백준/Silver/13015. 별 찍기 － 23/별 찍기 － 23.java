import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			star(i);
		}
		for (int i = N - 2; i >= 0; i--) {
			star(i);
		}
		
		System.out.print(sb);
	}
	
	static void star(int i) {
		for (int j = 0; j < i; j++) {
			sb.append(' ');
		}

		if (i == 0) {
			for (int j = 0; j < N; j++) {
				sb.append("*");
			}
		} else {
			sb.append("*");
			for(int j=0;j<N-2;j++) {
				sb.append(" ");
			}
			sb.append("*");

		}
		for (int j = 0; j < 1 + (N * 2 - 4) - (i * 2); j++) {
			sb.append(" ");
		}
		if (i != N - 1) {
			if (i == 0) {
				for (int j = 0; j < N; j++) {
					sb.append("*");
				}
			} else {
				sb.append("*");
				for(int j=0;j<N-2;j++) {
					sb.append(" ");
				}
				sb.append("*");
			}
		} else {
			for(int j=0;j<N-2;j++) {
				sb.append(" ");
			}
			sb.append("*");
		}

		sb.append('\n');
	}
}
