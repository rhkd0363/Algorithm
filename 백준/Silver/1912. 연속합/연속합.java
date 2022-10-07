import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		max = num[0];
		
		for (int i = 1; i < n; i++) {
			if (num[i] < num[i - 1] + num[i])
				num[i] = num[i - 1] + num[i];
			if (max < num[i])
				max = num[i];
		}

		System.out.println(max);
	}
}