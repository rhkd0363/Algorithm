import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] answer = new int[2];
        for(int i=1;i<=number;i++) {
            answer[0] += i;
            answer[1] += Math.pow(i, 3);
        }
        System.out.println(answer[0]+"\n"+answer[0] * answer[0]+"\n"+answer[1]);
    }
}