import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Gimbabman implements Comparable<Gimbabman>{
		int height;
		int count;
		
		public Gimbabman(int height, int count) {
			this.height = height;
			this.count = count;
		}
		
		@Override
		public int compareTo(Main.Gimbabman o) {
			
			if(o.count ==  this.count) {
				return o.height - this.height;
			}
			
			return this.count - o.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N 개의 계단을 K번 만에 오를 수 있는가5
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean flag = false;
		
		PriorityQueue<Gimbabman> queue = new PriorityQueue<>();
		
		queue.add(new Gimbabman(0, 0));
		
		boolean visited[] = new boolean[N+1]; 
		
		while(!queue.isEmpty()) {
			Gimbabman curr = queue.poll();
			
			if(curr.height > N || curr.count > K || visited[curr.height])
				continue;
			
			visited[curr.height] = true;
			
			if(curr.height == N && curr.count <= K) {
				flag = true;
				break;
			}
			
			
			queue.add(new Gimbabman(curr.height + 1, curr.count+1));
			queue.add(new Gimbabman(curr.height + (int)(curr.height / 2), curr.count+1));
			
		}
		
		System.out.println(flag? "minigimbob" : "water");
   }
}