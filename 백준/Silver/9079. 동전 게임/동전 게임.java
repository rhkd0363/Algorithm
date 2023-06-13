import java.io.*;
import java.util.*;

// H는 앞면, T 는 뒷면
public class Main {
	static String data;
	static int result;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// TC 수
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			data = "";

			for (int i = 0; i < 3; i++) {
				String inputLine = br.readLine();
				for(int j=0;j<inputLine.length();j+=2 )
					data += inputLine.charAt(j);
			}
			
			result = -1;

			DFS(0, 0);
			
			System.out.println(result);
		}
	}

	static int[][] seq = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
			{ 2, 4, 6 } };

	// 횟수, 순서
	static void DFS(int cnt, int pos) {
		if (data.equals("TTTTTTTTT") || data.equals("FFFFFFFFF")) {
			if(result == -1)
				result = cnt;
			else
				result = Math.min(result, cnt);
			return;
		}

		// 다 뒤집자..
		for (int i = pos; i < 8; i++) {
			reverse(i);
			
			DFS(cnt+1, i+1);
			
			reverse(i);
		}
	}
	
	static void reverse(int pos) {
		for(int j=0;j<3;j++) {
			if(data.charAt(seq[pos][j]) == 'T') {
				data = data.substring(0,seq[pos][j])+ "F" + data.substring(seq[pos][j]+1);
			}else {
				data = data.substring(0,seq[pos][j])+ "T" + data.substring(seq[pos][j]+1);
			}
		}
	}
}