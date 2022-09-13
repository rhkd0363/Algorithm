import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int[] arr;
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		selectSort();
	}
	
	static void selectSort() {
		for(int i = N-1;i>0;i--) {
			int maxValue = arr[i];
			int maxIndex = -1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j] > maxValue) {
					maxValue = arr[j];
					maxIndex = j;
				}
			}
			if(maxValue > arr[i]) {
				arr[maxIndex] = arr[i];
				arr[i] = maxValue;
				count++;
			}
			if(count == K) {
				System.out.println(arr[maxIndex]+" "+arr[i]);
				return;
			}
		}
		System.out.println("-1");
	}
}
