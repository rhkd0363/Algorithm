import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		LinkedList<Integer> list = new LinkedList<>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int index = 0;

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		sb.append("<");
		while (!list.isEmpty()) {
			index = (index + k - 1) % list.size();
			sb.append(list.remove(index) + ", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(">");

		System.out.println(sb);
	}
}