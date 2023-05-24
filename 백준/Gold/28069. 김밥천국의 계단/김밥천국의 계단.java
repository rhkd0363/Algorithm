import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Gimbabman{
		int height;
		int count;
		
		public Gimbabman(int height, int count) {
			this.height = height;
			this.count = count;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N 개의 계단을 K번 만에 오를 수 있는가
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean flag = false;
		
		Queue<Gimbabman> queue = new LinkedList<>();
		
		boolean visited[] = new boolean[N+1];
		
		queue.add(new Gimbabman(0, 0));
		
		while(!queue.isEmpty()) {
			Gimbabman curr = queue.poll();
			
			if(curr.height == N && curr.count <= K) {
				flag = true;
				break;
			}
			
			if(curr.height > N || curr.count > K || visited[curr.height])
				continue;
			
			visited[curr.height] = true;
			
			queue.add(new Gimbabman(curr.height + 1, curr.count+1));
			queue.add(new Gimbabman(curr.height + (int)(curr.height / 2), curr.count+1));
			
		}
		
		System.out.println(flag? "minigimbob" : "water");
   }
}