import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();
		
		if(m-45<0) {
			m = m+60-45;
			if(h !=0) {
				h = h - 1;				
			}else {
				h = 23;
			}
		}else {
			m = m-45;
		}
		System.out.println(h+" "+m);
		sc.close();
	}
}