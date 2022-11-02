import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		
		while ((str = br.readLine()) != null) {
			int x = Integer.parseInt(str) * 10000000;

			int n = Integer.parseInt(br.readLine());

			List<Integer> lego = new ArrayList<>();

			// 구멍 크기보다 크거나 같으면 필요없음
			for (int i = 0; i < n; i++) {
				int block = Integer.parseInt(br.readLine());
				if (block < x) {
					lego.add(block);
				}
			}

			// 정렬
			Collections.sort(lego);

			int left = 0;
			int right = lego.size()-1;

			int resL = -1;
			int resR = -1;

			while (left < right) {
				// 구멍크기랑 같다면
				if (lego.get(left) + lego.get(right) == x) {
					resL = lego.get(left);
					resR = lego.get(right);
					break;
				}
				// 구멍크기보다 크다면
				else if (lego.get(left) + lego.get(right) > x) {
					right--;
				}
				// 구멍크기보다 작다면
				else {
					left++;
				}
				
			}
			
			if(resL == -1) {
				sb.append("danger").append('\n');
			}else {
				sb.append("yes "+resL+" "+resR).append('\n');
			}
			
			str = null;

		}
		
		System.out.println(sb);
	}
}