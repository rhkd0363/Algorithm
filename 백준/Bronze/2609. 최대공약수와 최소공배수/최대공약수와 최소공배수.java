import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int resultA = 0;
        for (int i = (int) Math.sqrt(a * b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                resultA = i;
                break;
            }
        }
        System.out.println(resultA);
        System.out.println(a * b / resultA);
    }
}

