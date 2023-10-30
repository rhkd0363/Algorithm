import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] cArr = new char[N];
        boolean[] check = new boolean[26];
        int currIdx = 0;
        boolean flag = false;

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            currIdx = (currIdx + Integer.parseInt(st.nextToken())) % N;
            char c = st.nextToken().charAt(0);

            if (cArr[currIdx] == '\u0000'){
                if (check[c-'A']) {
                    flag = true;
                    break;
                }
                check[c-'A'] = true;
                cArr[currIdx] = c;
            }
            else{
                if(cArr[currIdx] != c) {
                    flag = true;
                    break;
                }
            }
        }

        getAnswer(sb, cArr, currIdx, 0);
        getAnswer(sb, cArr, N-1, currIdx + 1);

        System.out.println(flag ? '!' : sb);
    }

    static void getAnswer(StringBuilder sb, char[] cArr, int start, int end){
        for(int i=start;i>=end;i--){
            if(cArr[i] == '\u0000')
                sb.append('?');
            else
                sb.append(cArr[i]);
        }
    }
}