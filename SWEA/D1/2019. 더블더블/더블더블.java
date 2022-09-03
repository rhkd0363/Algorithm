import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int num = sc.nextInt();
        int i = 0;
		for (int j=0;j<num+1;j++) {
			i = Math(i,j);
			System.out.format("%d ", i);		
		}
	}

	private static int Math(int a,int b) {
		if (a==0||b==0)
			a = 1;
		else
			a = a * 2;
		return a;
	}
}
