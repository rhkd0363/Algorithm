import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 0;
		int count = 0;
		
		while(true) {
			num++;
			// num이 666을 포함할 때마다 count++
			if((num+"").contains("666")) {
				count++;
                // count가 N과 같으면 num을 출력
				if(N == count)
					break;
			}
		}
		
		System.out.println(num);	
	}
}