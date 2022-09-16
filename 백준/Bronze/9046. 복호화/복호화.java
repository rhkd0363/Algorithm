import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {
			String str = br.readLine();
			int[] alpha = new int[26];
			int max = 0;
			char result = 'a';
			int maxCnt = 1;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != ' ') {
					alpha[str.charAt(i)-'a']++;
					if(max < alpha[str.charAt(i)-'a']) {
						max = alpha[str.charAt(i)-'a'];
						result = str.charAt(i);
						maxCnt = 1;
					}else if(max == alpha[str.charAt(i)-'a']) {
						maxCnt++;
					}
				}
			}
			
			if(maxCnt != 1) {
				System.out.println("?");
			}else {
				System.out.println(result);
			}
			
		}
		
	}
}