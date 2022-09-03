import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			for(int k=0;k<K;k++) {
				int N = sc.nextInt();
				if(N!=0) {
					stack.push(N);
					sum +=N;
					continue;
				}
				try {
					sum -= stack.pop();
				} catch (Exception e) {
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}

