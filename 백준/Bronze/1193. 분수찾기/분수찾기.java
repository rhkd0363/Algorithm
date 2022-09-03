import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int value = Integer.parseInt(br.readLine());
		int line = 1;
		int num = 1;
		out : while(true) {
			for(int i=0;i<line;i++) {
				if(num == value) {
					if(line%2 == 1) {
						System.out.println((line-i)+"/"+(1+i));
					}
					else {
						System.out.println((1+i)+"/"+(line-i));
					}
					break out;
				}
				num++;
			}
			line++;
		}
		
	}
}