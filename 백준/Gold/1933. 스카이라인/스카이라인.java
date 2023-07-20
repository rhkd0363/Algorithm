import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static class Building implements Comparable<Building> {
		int start, height, end;

		public Building(int start, int height, int end) {
			this.start = start;
			this.height = height;
			this.end = end;
		}

		@Override
		public int compareTo(Building o) {
			if (this.start == o.start)
				return this.end - o.end;

			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

    	PriorityQueue<Building> pq = new PriorityQueue<>();

		TreeMap<Integer, int[]> map = new TreeMap<>();

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map.put(start, new int[] { map.get(start) != null ? Math.max(map.get(start)[0], height) : height, map.get(start) != null ? Math.max(map.get(start)[1], height) : height});
			map.put(end, new int[] {map.get(end) != null ? Math.max(map.get(end)[0], 0) : 0, map.get(end) != null ? Math.max(map.get(end)[1], height) : height});
			
			pq.add(new Building(start, height,end));
		}
		
		ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
		
		int memo = 0;
		
		while(!pq.isEmpty()) {
			Building curr = pq.poll();
			
			int startIdx = keySet.indexOf(curr.start);
			
			if(startIdx == -1)
				startIdx = memo;
			
			memo = startIdx;
			
			int endIdx = keySet.indexOf(curr.end);
			
			for(int i = startIdx + 1; i <= endIdx; i++) {
				int index = keySet.get(i);
				
				if(i == endIdx){
					if(map.get(index)[0] == curr.height) {
						map.remove(index);
						keySet.remove(i);
					}
					break;
				}
				
				if(map.get(index) == null || map.get(index)[0] == -1)
					continue;
				
				if(map.get(index)[0] <= curr.height) {					
					if(map.get(index)[1] > curr.height)
						map.put(index, new int[] {curr.height, map.get(index)[1]});
					else {
						map.remove(index);
						keySet.remove(i--);
						endIdx--;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int d : map.keySet()) {
			sb.append(d+" "+map.get(d)[0]+" ");
		}
		
		sb.delete(sb.length()-1, sb.length());

		System.out.print(sb);
		
	}
}