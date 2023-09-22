import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int answer = 50;
        for(int i=0;i<=B.length()-A.length();i++){
            int count = 0;
            for(int j=0;j<A.length();j++)
                if(A.charAt(j) != B.charAt(i+j))
                    count++;
            answer = Math.min(answer,count);
        }
        System.out.println(answer);
    }
}