import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Array implements Comparable<Array> {
		int x;
		int y;

		public Array(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Array o) {
			if (this.y == o.y)
				return this.x - o.x;
			return this.y - o.y;
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N  = Integer.parseInt(br.readLine());
		
		Array[] arr = new Array[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Array(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i].x+" "+arr[i].y).append('\n');
		}
		
		System.out.println(sb);
	}
}