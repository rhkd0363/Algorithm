import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] grade = {"D0","C-","C0","C+","B-","B0","B-","A-","A0","A+"};
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt()-1;
			List<Integer> a = new ArrayList<>();
			for(int j =0;j<N;j++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int hom = sc.nextInt();
				a.add(mid*35 + fin*45 + hom*20);
			}
			int k_score = a.get(K);
			a.sort(null);
			System.out.format("#%d %s\n", i, grade[a.indexOf(k_score)*10/N]);
		}
	}
}