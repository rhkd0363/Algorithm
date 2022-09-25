import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int[] arr;
	static boolean[] check;
	static int N, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		check = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if(nextPerm())
			for(int i=0;i<N;i++)
				SB.append(arr[i]).append(' ');
		else {
			SB.append(-1);
		}
		System.out.println(SB);
	}
	
	private static boolean nextPerm() {
	    int i = arr.length-1;
	    while(i > 0 && arr[i-1] >= arr[i]) i--;
	    if(i <= 0) return false;

	    int j = arr.length-1;

	    while(arr[j] <= arr[i-1]) j--;

	    swap(i-1, j);
	    j = arr.length - 1;
	    while(i < j) {
	        swap(i, j);
	        i++;
	        j--;
	    }
	    return true;
	}

	private static void swap(int index1, int index2) {
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	}
}
