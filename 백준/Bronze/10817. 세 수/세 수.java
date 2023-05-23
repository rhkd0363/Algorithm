import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input= Stream.of(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
		Arrays.sort(input);
		System.out.println(input[1]);
   }
}