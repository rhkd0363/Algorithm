import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N+1];

		int[] count = new int[N+1];
		int[] order = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			int max = 0;
			int idx = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && count[j] > max) {
					max = count[j];
					idx = j;
				}
			}
			count[i] = max + 1;
			order[i] = idx;
		}
		
		int max = 0;
		int idx = 0;

		for (int i = 0; i <= N; i++) {
			if(count[i] > max) {
				max = count[i];
				idx = i;
			}
		}
		
		sb.append(max).append('\n');
		
		List<Integer> list = new ArrayList<>();
		
		list.add(arr[idx]);
		
		while(order[idx] != 0) {
			list.add(arr[order[idx]]);
			idx = order[idx];
		}

		Collections.sort(list);
	
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i)).append(' ');
		
		System.out.println(sb);
	}
}