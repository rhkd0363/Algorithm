import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<K;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0)
				stack.add(num);
			else
				stack.pop();
		}
		
		//2^31-1보다 작거나 같은 정수
		int ans = 0;
		
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		
		System.out.println(ans);
	}

}
