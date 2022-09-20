import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> ls = new HashSet<>();
		List<String> ss = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			ls.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();

		String str;
		for(int j=0;j<M;j++) {
			str = br.readLine();
			if (ls.contains(str)) {
					ss.add(str);
			}
		}

		Collections.sort(ss);
		
		sb.append(ss.size()).append('\n');
		
		for(int i=0;i<ss.size();i++)
			sb.append(ss.get(i)).append('\n');
		
		System.out.print(sb);
	}
}