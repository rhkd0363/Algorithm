import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int start;
	static int end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			String str = br.readLine();

			start = 0;
			end = str.length() - 1;
			
			if(palindrome(str))
				sb.append(0).append('\n');
			else
				if(pseudoPalindrome(str, start, end))
					sb.append(1).append('\n');
				else
					sb.append(2).append('\n');
		}
		
		System.out.print(sb);
		
	}
    // 회문검사
	static boolean palindrome(String str) {
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
    // 유사회문검사
	static boolean pseudoPalindrome(String str, int start, int end) {
		int res = 0;

		int _start = start + 1;
		int _end = end;
		while (_start <= _end) {
			if (str.charAt(_start) != str.charAt(_end)) {
				res++;
				break;
			}
			_start++;
			_end--;
		}

		int start_ = start;
		int end_ = end - 1;
		while (start_ <= end_) {
			if (str.charAt(start_) != str.charAt(end_)) {
				res++;
				break;
			}
			start_++;
			end_--;
		}

		if (res == 2)
			return false;
		else
			return true;
	}
}