import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] student = new int[N];

		for (int i = 0; i < N; i++)
			student[i] = sc.nextInt();

		int B = sc.nextInt();
		int C = sc.nextInt();

		long ans = 0;

		for (int i = 0; i < N; i++) {
			if (student[i] > B) {
				int res = student[i] - B;
				if (res % C != 0)
					ans += res / C + 2;
				else
					ans += res / C + 1;
				continue;
			}
			ans++;
		}
		
		System.out.println(ans);
	}
}
