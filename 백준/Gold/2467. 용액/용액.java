import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int value = Integer.MAX_VALUE;
		int[] items = new int[2];

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int sum = arr[start] + arr[end];
			if (value > Math.abs(sum)) {
				value = Math.abs(sum);
				items[0] = arr[start];
				items[1] = arr[end];
			}

			if (0 == sum) {
				break;
			} else if (0 < sum) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(items[0] + " " + items[1]);
	}
}