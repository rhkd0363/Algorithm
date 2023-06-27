import java.io.*;
import java.util.*;

public class Main {
	static Set<String> result;
	static Stack<Integer> stack;
	static List<int[]> bracketList;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		stack = new Stack<>();
		bracketList = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(')
				stack.add(i);
			if (input.charAt(i) == ')') {
				bracketList.add(new int[] {stack.pop(), i});
			}
		}
		
		result = new HashSet<>();
		
		DFS(0,0,input.toCharArray());
		
		StringBuilder sb = new StringBuilder();
		
		List<String> answer = new ArrayList<>(result);
		
				Collections.sort(answer);
		
		for(String str : answer)
			sb.append(str).append('\n');
		
		System.out.println(sb);
	}

	static void DFS(int idx, int cnt, char[] str) {
		if (idx == bracketList.size())
			return;
		
		for(int i=idx;i<bracketList.size();i++) {
			str[bracketList.get(i)[0]] = ' ';
			str[bracketList.get(i)[1]] = ' ';

			result.add(new String(str).replaceAll(" ", ""));
			
			DFS(i + 1, cnt  + 1 , str);
			
			str[bracketList.get(i)[0]] = '(';
			str[bracketList.get(i)[1]] = ')';
		}
	}
}
