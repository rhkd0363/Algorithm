import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];

		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			sum += num;
			if (num % 2 == 1)
				cnt++;
		}

		if (sum % 3 == 0 && cnt <= sum / 3)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}