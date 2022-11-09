import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] list = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] list2 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

		String a = sc.nextLine();
		long num = 0;
		switch (a) {
		case "black":
			num += list[0] * 10;
			break;
		case "brown":
			num += list[1] * 10;
			break;
		case "red":
			num += list[2] * 10;
			break;
		case "orange":
			num += list[3] * 10;
			break;
		case "yellow":
			num += list[4] * 10;
			break;
		case "green":
			num += list[5] * 10;
			break;
		case "blue":
			num += list[6] * 10;
			break;
		case "violet":
			num += list[7] * 10;
			break;
		case "grey":
			num += list[8] * 10;
			break;
		case "white":
			num += list[9] * 10;
			break;
		}
		String b = sc.nextLine();
		switch (b) {
		case "black":
			num += list[0];
			break;
		case "brown":
			num += list[1];
			break;
		case "red":
			num += list[2];
			break;
		case "orange":
			num += list[3];
			break;
		case "yellow":
			num += list[4];
			break;
		case "green":
			num += list[5];
			break;
		case "blue":
			num += list[6];
			break;
		case "violet":
			num += list[7];
			break;
		case "grey":
			num += list[8];
			break;
		case "white":
			num += list[9];
			break;
		}
		String c = sc.nextLine();
		switch (c) {
		case "black":
			num *= list2[0];
			break;
		case "brown":
			num *= list2[1];
			break;
		case "red":
			num *= list2[2];
			break;
		case "orange":
			num *= list2[3];
			break;
		case "yellow":
			num *= list2[4];
			break;
		case "green":
			num *= list2[5];
			break;
		case "blue":
			num *= list2[6];
			break;
		case "violet":
			num *= list2[7];
			break;
		case "grey":
			num *= list2[8];
			break;
		case "white":
			num *= list2[9];
			break;
		}

		System.out.println(num);
	}
}
