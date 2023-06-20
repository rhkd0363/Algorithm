import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Double> map = new HashMap<>();

		String input;
		double count = 0.0;

		while ((input = br.readLine()) != null) {
//			while (!(input = br.readLine()).equals("null")) {
			count++;
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 1.0);
			}
		}

		Object[] keySet = map.keySet().toArray();

		Arrays.sort(keySet);

		StringBuilder sb = new StringBuilder();

		for (Object key : keySet) {
//			sb.append(key).append(' ').append(Math.round(map.get(key) / count * 1000000)/10000.0).append('\n');
			sb.append(key).append(' ').append(String.format("%.4f", map.get(key) / count *100)).append('\n');
		}

		System.out.println(sb);
	}
}