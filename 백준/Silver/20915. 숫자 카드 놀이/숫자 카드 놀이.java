import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int arr[] = new int[10];
			
			String input = br.readLine();

			for (int i = 0; i < input.length(); i++) {
				int index = input.charAt(i) - 48 == 6 || input.charAt(i) - 48 == 9 ? 9 : input.charAt(i) - 48;
				arr[index]++;
			}

			long fNum = 0;
			long sNum = 0;

			for (int i = 9; i >= 0; i--) {
				while (arr[i] != 0) {
					arr[i]--;

					if (fNum >= sNum) {
						sNum = sNum * 10 + i;
					} else {
						fNum = fNum * 10 + i;
					}
				}
			}
			result.append(fNum * sNum).append("\n");
		}
		System.out.println(result);
	}
}
