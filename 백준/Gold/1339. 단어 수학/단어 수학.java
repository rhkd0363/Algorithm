import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 단어의 개수
		
		int arr[] = new int[26];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			
			for(int j=input.length()-1;j>=0;j--) {
				arr[input.charAt(j)-'A'] += Math.pow(10, input.length()-j-1);
			}
			
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		int num = 9;
		
		for(int i=25;i>15;i--)
			result += arr[i] * num--;
		
		System.out.println(result);
	}
}