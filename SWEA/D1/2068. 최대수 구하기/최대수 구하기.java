import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		int[] Data = {0,0,0,0,0,0,0,0,0,0};
		for(int i = 1; i<Tc+1;i++) {
			for (int j =0;j<10;j++) {
				Data[j] = sc.nextInt();
			}
			int MD = Data[0];
			for(int K =1; K<10; K++) {
				if(MD<Data[K])
					MD = Data[K];
			}
			System.out.println("#"+i+" "+MD);
		}
		
		}	
}
