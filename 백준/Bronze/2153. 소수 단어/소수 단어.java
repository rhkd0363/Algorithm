import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c > 'Z') {
                sum += c - 96;
            } else {
                sum += c - 64 + 26;
            }
        }
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                flag = true;
                break;
            }
        }
        System.out.println(!flag ? "It is a prime word." : "It is not a prime word.");
    }
}