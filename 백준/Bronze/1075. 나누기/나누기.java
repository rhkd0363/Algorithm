import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        N -= N % 100;

        for(int i=0;i<100;i++){
            if(N % F  == 0){
                System.out.println((N / 10) % 10+""+N%10);
                break;
            }
            N++;
        }
    }
}