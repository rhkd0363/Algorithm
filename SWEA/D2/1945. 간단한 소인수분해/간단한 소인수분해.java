import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();
		
		for (int i = 1;i<=tn;i++) {
			int tc = sc.nextInt();
			int a = 0;
			int b = 0; 
			int c = 0;
			int d = 0;
			int e = 0;
			
			while(tc%2 ==0) {tc = tc/2;a++;}
			while(tc%3 ==0) {tc = tc/3;b++;}
			while(tc%5 ==0) {tc = tc/5;c++;}
			while(tc%7 ==0) {tc = tc/7;d++;}
			while(tc%11 ==0) {tc = tc/11;e++;}
			
			System.out.printf("#%d %d %d %d %d %d\n",i,a,b,c,d,e);
		}
	}
}
