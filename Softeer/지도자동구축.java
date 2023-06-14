import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 4;
        int line = 2;

        for(int i=1; i <= N;i++){
            line += Math.pow(2,i-1);
        }

        System.out.println((int)Math.pow(line,2));
    }
}
