import java.io.*;
import java.util.*;

public class Main {
	static class Coin implements Comparable<Coin> {
		int value;
		int count;

		public Coin(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Coin c) {
			return this.value - c.value;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		List<Coin> coinList = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());

			coinList.add(new Coin(value, count));
		}

		int[][] arr = new int[k + 1][T + 1];

		for (int i = 0; i < coinList.size(); i++) {
			Coin coin = coinList.get(i);

			for (int j = 1; j <= coin.count; j++) {
				if(coin.value * j > T)
					continue;
				arr[i][coin.value * j]++;
			}
		}

		for (int i = 0; i < coinList.size()-1; i++) {
			Coin coin = coinList.get(i+1);

			for (int j = 1; j <= T; j++) {
				arr[i+1][j] += arr[i][j];
				for(int z=1; z<= coin.count;z++) {
					if(j + coin.value * z > T)
						continue;
					arr[i+1][j + coin.value * z] += arr[i][j];
				}
			}
		}
		
		System.out.println(arr[k-1][T]);

	}

}