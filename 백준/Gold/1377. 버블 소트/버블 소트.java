import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Bubble[] arr = new Bubble[N+1];
		
		for (int i = 1; i < N+1; i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = new Bubble(i,tmp);
		}
		
		Arrays.sort(arr, 1, N+1);
		
		int max =0;
		for(int i =1;i<N+1;i++) {
			max = Math.max(max, arr[i].index-i);
		}
		
		System.out.println(max+1);
	}
}
class Bubble implements Comparable<Bubble>{
	int index;
	int value;
	public Bubble(int index,int value) {
		this.index = index;
		this.value = value;
	}
	
	@Override
	public int compareTo(Bubble o) {
		return this.value - o.value;
	}
	
}
