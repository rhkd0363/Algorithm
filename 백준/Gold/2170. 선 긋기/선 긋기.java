import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0])
					return a[1] - b[1];
				return a[0] - b[0];
			}
		});
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int dotA = Integer.parseInt(st.nextToken());
			int dotB = Integer.parseInt(st.nextToken());
			
			pq.add(dotA < dotB ? new int[] {dotA, dotB} : new int[] {dotB, dotA});
		}
		
		int length = 0;
		
		int start = -1_000_000_001, end = -1_000_000_001;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(end < curr[0]) {
				length += end - start;
				start = curr[0];
				end = curr[1];
			}else {
				end = Math.max(end, curr[1]);
			}
		}
		
		length += end - start;
		
		System.out.println(length);
	}
}