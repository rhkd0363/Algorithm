import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] primeArr = new boolean[10001];
		int count =0;
		fo: for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)// 나머지가 0이 되면 첫번째 반복문 continue
					continue fo;
			}
			primeArr[i] = true;
			count++;
		}
		
		int[] arr = new int[count];
		
		for (int i = 2,j=0; i <= 10000; i++) {
			if(primeArr[i]) {
				arr[j] = i;
				j++;
			}
		}
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int lPrime = 0, gPrime = 0;
			int diffNum = Integer.MAX_VALUE;			
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					if (arr[i]+arr[j] == N && arr[j] - arr[i] < diffNum) {
						diffNum = arr[j] - arr[i];
						lPrime = arr[i];
						gPrime = arr[j];
					}
					else if (arr[i] + arr[j] > N) {
						break;
					}
				} 
			} 
			
			System.out.println(lPrime + " " + gPrime);
		}
	}
}