import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        while(first != 0 && second != 0){
            if(first > second)
                System.out.println("Yes");
            else
                System.out.println("No");
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
        }
    }
}