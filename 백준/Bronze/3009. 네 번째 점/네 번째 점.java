import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int nx = Integer.parseInt(st.nextToken());
        int ny = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int lx = Integer.parseInt(st.nextToken());
        int ly = Integer.parseInt(st.nextToken());
        
        if (x == nx) System.out.print(lx + " ");
        else if (x == lx) System.out.print(nx + " ");
        else System.out.print(x + " ");
        if (y == ny) System.out.print(ly);
        else if (y == ly) System.out.print(ny);
        else System.out.print(y);
    }
}