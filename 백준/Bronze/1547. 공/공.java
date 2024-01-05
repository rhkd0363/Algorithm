import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        int[] ball = new int[4];
        ball[1] = 1;

        for(int i=0;i<m;i++){
             st = new StringTokenizer(br.readLine());
             int left = Integer.parseInt(st.nextToken());
             int right = Integer.parseInt(st.nextToken());

             int temp = ball[left];
             ball[left] = ball[right];
             ball[right] = temp;
        }

        for(int i=1;i<4;i++){
            if(ball[i] == 1)
                System.out.println(i);
        }
    }
}