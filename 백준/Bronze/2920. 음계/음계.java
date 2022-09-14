import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] cArr = br.readLine().split(" ");
		
		switch (cArr[0]){
		case "1":
			for(int i=0;i<8;i++) {
				if(Integer.parseInt(cArr[i]) != i+1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			break;
		case "8":
			for(int i=8;i>0;i--) {
				if(Integer.parseInt(cArr[8-i]) != i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
			break;
		}
	}
}
