import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();

		h += p / 60;
		m += p % 60;

		if (m > 59) {
			m = m - 60;
			h = h + 1;
		}

		if (h > 23) {
			h = h - 24;
		}
		System.out.println(h + " " + m);
		sc.close();
	}
}