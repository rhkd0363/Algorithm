import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			double avg =0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				avg += arr[j];
			}
			avg = avg/N;
			int count = 0;
			for(int j =0; j<N;j++) {
				if(arr[j] > avg) count++;
			}
			double result = (double)count/N * 100;
			System.out.printf("%.3f%%\n",result);
		}

	}
}
