import java.io.*;
import java.util.*;

public class Main {
	static class Item implements Comparable<Item> {
		int index;
		int value;

		public Item(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public int compareTo(Item o) {
			if (this.value == o.value)
				return this.index - o.index;
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Item[] items = new Item[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<Item> set = new TreeSet<>();

		for (int i = 1; i <= N; i++) {
			items[i] = new Item(i, Integer.parseInt(st.nextToken()));
			set.add(items[i]);
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			if (Integer.parseInt(st.nextToken()) == 2) {
				sb.append(set.first().index).append('\n');
			} else {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				set.remove(items[idx]);
				items[idx].value = value;
				set.add(items[idx]);
			}
		}

		System.out.println(sb);
	}
}