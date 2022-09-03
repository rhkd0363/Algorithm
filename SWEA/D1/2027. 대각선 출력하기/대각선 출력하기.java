
public class  Solution {
	 public static void main(String[] args) {
		char[] a = {'+','+','+','+','+'};
		
		for(int i = 0;i<5;i++) {
			a[i] = '#';
			System.out.println(a);
			a[i] = '+';
		}
	}
}
