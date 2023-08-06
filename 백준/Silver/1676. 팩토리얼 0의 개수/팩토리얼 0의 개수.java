import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0) {
                int num = i;
                while (num != 0 && num % 5 == 0) {
                    num /= 5;
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}