import java.util.Scanner;

public class  Solution {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tn = sc.nextInt();
		
		for (int i =1;i<Tn+1;i++) {
			int num = 0;
			for (int j=0;j<10;j++) {
				num = num + sc.nextInt();
			}
			double sum = num/10.0;
			System.out.printf("#%d %.0f\n",i,sum);
		}
	}
}
