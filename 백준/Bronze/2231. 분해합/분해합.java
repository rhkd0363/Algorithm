import java.io.*;

public class Main {
	static StringBuilder SB = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 6;

		while (true) {
			if (N / (int)Math.pow(10, num) != 0) {
				break;
			}
			num--;
		}
		// 범위
		int range = (num * 9) + (int) (N / Math.pow(10, num));

		int a = N - range;

		int tmp = 0;
		boolean chk = false;
		while (a < N) {
			tmp = a;
			int b = a;
			for (int i = num; i >= 0; i--) {
				tmp += (int) b / Math.pow(10, i);
				b %= Math.pow(10, i);
			}
			if(tmp == N) {
				chk = true;
				break;
			}
			a++;
		}
		if(chk)
			System.out.println(a);
		else
			System.out.println(0);
	}
}