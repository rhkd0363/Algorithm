import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int[] arr = new int[9];
		int sum =0;
		for(int i =0; i< 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum +=arr[i];
		}
		Arrays.sort(arr);
		//sum=40 2개합쳐 40인거만 찾으면댐
		sum -= 100;
		
		fo: for(int i=0; i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(arr[i]+arr[j] == sum) {
					for(int k=0;k<9;k++) {
						if(k == i|| k == j) continue;
						System.out.println(arr[k]);
					}
					break fo;
				}
			}
		}
	}
}