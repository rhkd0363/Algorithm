import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[31];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < 31; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j] * arr[i - 1 - j];
            }
            arr[i] = sum;
        }
        int input;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            System.out.println(arr[input]);
        }
    }
}