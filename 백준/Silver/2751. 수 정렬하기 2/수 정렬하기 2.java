import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 카운팅정렬
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (min > arr[i])
				min = arr[i];
			if (max < arr[i])
				max = arr[i];
		}
		
		int[] count = new int[max - min + 1];
		
		for (int i = 0; i < N; i++) {
			count[arr[i] - min]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = N - 1; i >= 0; i--) {
			temp[--count[arr[i]-min]] = arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(temp[i]+"\n");
		}
		System.out.print(sb);
	}
}