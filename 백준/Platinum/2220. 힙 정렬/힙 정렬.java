import java.io.*;

public class Main {
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		//값이 추가될 때마다 1과 위치 바꾼후 정렬시킨다.
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = i;
			arr[i-1] = arr[i];
			arr[i] = 1;
			swap(i-1);
		}

		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
	}

	
	static void swap(int i) {
		int pos = i;
		//부모인덱스와 비교하여 값이 크면 위치 변경시켜줌
		while (pos / 2 >= 1) {
			int pValue = arr[pos / 2];
			int pPos = pos / 2;

			if (arr[pos]<pValue) break;
			
			arr[pPos] = arr[pos];
			arr[pos] = pValue;

			pos = pPos;
		}
	}
}
