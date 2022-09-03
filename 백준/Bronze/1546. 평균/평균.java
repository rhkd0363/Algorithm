import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[Integer.parseInt(br.readLine())];
		int N = arr.length;
		int M =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>M) M = arr[i];
		}
		double result = 0;
		for(int i=0;i<N;i++) {
			result += (double)arr[i]/M*100;
		}

		System.out.print(result/N);
	}
}
