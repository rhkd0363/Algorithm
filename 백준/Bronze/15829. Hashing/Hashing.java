import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long result = 0;
        long num = 1;
        for (int i = 0; i < N; i++) {
            result += ((input.charAt(i) - 96) * num) % 1234567891;
            num = (num * 31) % 1234567891;
        }

        System.out.println(result);
    }
}