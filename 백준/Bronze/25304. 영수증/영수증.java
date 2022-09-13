import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		int count = sc.nextInt();
		int sum = 0;
		
		for(int i=0;i<count;i++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			sum += price * cnt;
		}
		if(total == sum)System.out.println("Yes");
		else System.out.println("No");
	}
}