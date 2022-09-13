import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken().toUpperCase();
		int[] arr = new int[26];
		
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)-65]++;
		}
		int max = 0;
		int idx = 0;
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				idx = i;
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(max == arr[i]) cnt++;
		}
		if(cnt>1) System.out.println("?");
		else{
			System.out.println((char)(idx+65));
		}
	}
}
