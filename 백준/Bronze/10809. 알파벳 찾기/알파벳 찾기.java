import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] arr = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		for(int i=0;i<str.length();i++) {
			if(arr[str.charAt(i)-97] == -1) arr[str.charAt(i)-97] = i;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");			
		}
	}
}
