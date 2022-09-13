import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];

		for (int i = 0; i < 3; i++) {
			arr[sc.nextInt()]++;
		}
		for (int i = 0, max = 0; i < 7; i++) {
			if (arr[i] == 3) {
				System.out.println(10000 + i * 1000);
				break;
			} else if (arr[i] == 2) {
				System.out.println(1000 + i * 100);
				break;
			} else if (arr[i] == 1) {
				max = i;
			}
			if (i == 6) {
				System.out.println(max*100);
			}
		}

	}
}