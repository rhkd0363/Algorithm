import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max =0;
		int min =0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) max =arr[i];
			else if(arr[i]<min) min = arr[i];
		}
		countSort(arr,max,min,N);
	}
	
	static void countSort(int[] arr,int max,int min,int N) {
		StringBuilder sb = new StringBuilder();
		int[] temp = new int[N];
		int[] count = new int[max-min+1];
		
		for(int i=0;i<N;i++) {
			count[arr[i]-min]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		for(int i=N-1;i>=0;i--) {
			temp[--count[arr[i]-min]] = arr[i];
		}
		
		for(int i=0;i<temp.length;i++) {
			sb.append(temp[i]+"\n");
		}
		
		System.out.println(sb);
	}
}

