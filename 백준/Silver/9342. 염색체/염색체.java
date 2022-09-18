import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		fo : for (int n = 0; n < N; n++) {
			char[] cArr = br.readLine().toCharArray();

			if (cArr[0] =='A' || cArr[0] =='B' || cArr[0] =='C' ||
					cArr[0] =='D' || cArr[0] =='E' || cArr[0] =='F') {
				for (int i = 1; i < cArr.length - 1; i++) {
					if (cArr[i - 1] == cArr[i])
						continue;
					else if (i == 1 && cArr[i - 1] != 'A' && cArr[i] == 'A')
						continue;
					else if (cArr[i - 1] == 'A' && cArr[i] == 'F')
						continue;
					else if (cArr[i - 1] == 'F' && cArr[i] == 'C')
						continue;
					else {
						sb.append("Good").append('\n');
						continue fo;
					}
				}
				if(cArr[cArr.length-2] == 'F' && cArr[cArr.length-1] =='C') {
					sb.append("Infected!").append('\n');
				}
				else if(cArr[cArr.length-2] == 'C'
						&& (cArr[cArr.length-1] =='A' || cArr[cArr.length-1] =='B' || cArr[cArr.length-1] =='C' ||
								cArr[cArr.length-1] =='D' || cArr[cArr.length-1] =='E' || cArr[cArr.length-1] =='F')) {
					sb.append("Infected!").append('\n');
				}
				else {
					sb.append("Good").append('\n');
				}
			}
			else {
				sb.append("Good").append('\n');
			}			
		}
		System.out.println(sb);
	}
}