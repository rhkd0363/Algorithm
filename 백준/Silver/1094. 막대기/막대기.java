import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 64) {
            System.out.println(1);
            return;
        }
        int stick = 64;
        int sum = 0;
        int answer = 0;

        while(sum != N){
            stick /= 2;
            if(stick + sum > N)
                continue;
            sum += stick;
            answer++;
        }

        System.out.println(answer);
    }
}