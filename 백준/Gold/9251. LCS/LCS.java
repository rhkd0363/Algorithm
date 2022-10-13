import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstStr = br.readLine();
		String secondStr = br.readLine();
		
		int[][] lcs = new int[firstStr.length()+1][secondStr.length()+1];
		
		for(int i=1;i<firstStr.length()+1;i++) {
			for(int j=1;j<secondStr.length()+1;j++) {
				if(firstStr.charAt(i-1) != secondStr.charAt(j-1)) {
					lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
				}else {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
			}
		}
		
		System.out.println(lcs[firstStr.length()][secondStr.length()]);
	}
}
