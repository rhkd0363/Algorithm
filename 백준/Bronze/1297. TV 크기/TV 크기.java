import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double value = Math.pow(D,2) / (Math.pow(H,2) + Math.pow(W,2));

        int height = (int)Math.sqrt(value * Math.pow(H,2));
        int width = (int)Math.sqrt(value * Math.pow(W,2));

        System.out.println(height +" "+width);
    }
}