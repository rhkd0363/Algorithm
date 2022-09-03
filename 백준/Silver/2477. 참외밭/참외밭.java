import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int 참외 = Integer.parseInt(br.readLine());

		int[] 방향 = new int[6];
		int[] 길이 = new int[6];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			방향[i] = Integer.parseInt(st.nextToken());
			길이[i] = Integer.parseInt(st.nextToken());
		}
		int 가로 = 0;
		int 세로 = 0;
		for (int i = 0; i < 6; i++) {
			if (방향[i] == 1 || 방향[i] == 2) {
				if (길이[i] > 가로)
					가로 = 길이[i];
			}
			if (방향[i] == 3 || 방향[i] == 4) {
				if (길이[i] > 세로)
					세로 = 길이[i];
			}
		}
		int 전체면적 = 가로*세로;
		// 전이랑 후랑 방향이 같으면 그거로 계산 후 뺄것.
		int 공백면적 = 1;
		for (int i = 0; i < 6; i++) {
			if (방향[(6 + i - 1) % 6] == 방향[(6 + i + 1) % 6])
				공백면적 *= 길이[i];
		}
		
		System.out.println((전체면적 - 공백면적) * 참외);
	}
}
