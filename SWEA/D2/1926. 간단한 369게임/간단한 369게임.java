import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			for (int j = i; j != 0;) {
				arr.add(j % 10);
				j = j / 10;
			}
			if (arr.contains(3) || arr.contains(6) || arr.contains(9)) {
				for (int j = 0; j < arr.size(); j++) {
					if (arr.get(j) == 3 || arr.get(j) == 6 || arr.get(j) == 9) {
						System.out.print("-");
					}
				}
			} else {
				for (int j = arr.size()-1; j>=0; j--) {
					System.out.printf("%d",arr.get(j));
				}
			}
			System.out.print(" ");
			arr.clear();
		}
	}
}
