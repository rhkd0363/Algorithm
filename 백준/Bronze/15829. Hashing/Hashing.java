import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long result = 0;
        for(int i=0;i<N;i++){
            result += (input.charAt(i) - 96) * (Math.pow(31,i) % 1234567891) % 1234567891;
            result %= 1234567891;
        }
        System.out.println(result);
    }
}