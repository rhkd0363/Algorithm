import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<int[]> list = new ArrayList<>();
		Stack<int[]> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {i, x-r});
			list.add(new int[] {i, x+r});
		}
		
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					flag = true;
				return o1[1] - o2[1];
			}
		});
		
		if(flag) {
			System.out.println("NO");
			return;
		}
			
		for(int i=0;i<list.size();i++) {
			if(stack.isEmpty())
				stack.add(list.get(i));
			else {
				if(stack.peek()[0] == list.get(i)[0])
					stack.pop();
				else
					stack.add(list.get(i));
			}
		}
		
		System.out.println(stack.isEmpty() ? "YES" : "NO");
	}
}