import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] check;
		int count = 0;
		out : for(int i=0;i<N;i++) {
			check = new boolean[26];
			String str = br.readLine();
			check[str.charAt(0)-97] = true;
			for(int j=1;j<str.length();j++) {
				//앞이랑 다르고 이미 true 일 경우
				if(str.charAt(j) != str.charAt(j-1)&& check[str.charAt(j)-97] == true)
					continue out;
				check[str.charAt(j)-97] = true;
			}
			count++;
		}
		
		System.out.println(count);
	}
}


