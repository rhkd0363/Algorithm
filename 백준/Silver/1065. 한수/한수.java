import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int sum=0;
		for (int i = 1; i <= N; i++) {
			if(func(i)) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	static boolean func(int number) {
		if(number < 100) return true;
		
		int _1 = number%10;
		int _10 = number%100/10;
		int _100 = number/100;

		if(_1 - _10 == _10 - _100) return true;
		
		return false;
	}
}