import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int idx =0;
		int maxValue = Integer.MIN_VALUE;
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>maxValue) {
				maxValue = arr[i];
				idx = i+1;
			}
		}
		
		System.out.println(maxValue+"\n"+idx);
	}
}