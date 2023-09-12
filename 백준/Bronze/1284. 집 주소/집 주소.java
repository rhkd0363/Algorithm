import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        while(!(input = br.readLine()).equals("0")){
            int res = 1;
            for(int i=0;i<input.length();i++){
                switch (input.charAt(i)){
                    case '0':
                        res+=5;
                        break;
                    case '1':
                        res+=3;
                        break;
                    default:
                        res += 4;
                }
            }
            sb.append(res).append('\n');
        }
            System.out.println(sb);
    }
}