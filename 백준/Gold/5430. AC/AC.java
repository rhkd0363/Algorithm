import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		testcase: for (int t = 0; t < T; t++) {
			String command = br.readLine();
			int length = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<>();

			String arr = br.readLine();

			if (length != 0) {
				int idx = 1;
				// 맨앞뒤 괄호를 빼고진행
				for (int i = 1; i < arr.length() - 1; i++) {
					if (arr.charAt(i) == ',') {
						list.add(Integer.parseInt(arr.substring(idx, i)));
						idx = i + 1;
					}
				}
				list.add(Integer.parseInt(arr.substring(idx, arr.length() - 1)));
			}

			boolean check = true;

			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R')
					check = !check;
				if (command.charAt(i) == 'D') {
					if (list.size() == 0) {
						sb.append("error").append('\n');
						continue testcase;
					}
					if (check)
						list.remove(0);
					else
						list.remove(list.size() - 1);
				}
			}

			sb.append('[');
			if (check) {
				for (int i = 0; i < list.size()-1; i++) {
					sb.append(list.get(i));
					sb.append(',');
				}
				if (list.size() != 0)
					sb.append(list.get(list.size()-1));
			} else {
				for (int i = list.size() - 1; i > 0; i--) {
					sb.append(list.get(i));
					sb.append(',');
				}
				if (list.size() != 0)
					sb.append(list.get(0));
			}
			sb.append(']').append('\n');
		}
		System.out.println(sb);
	}
}