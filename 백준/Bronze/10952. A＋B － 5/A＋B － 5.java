import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int Tc = sc.nextInt();
//		int[] Tc
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		while(a+b!=0){
			System.out.println(a+b);
			a = sc.nextInt();
			b = sc.nextInt();
		}
	}
}
