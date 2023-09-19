import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Set<String>[] A = new HashSet[26];

        for (int i = 0; i < 26; i++)
            A[i] = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            A[line.charAt(0) - 'a'].add(line);
        }

        boolean[] visited = new boolean[S.length()];
        for(int i=S.length()-1;i>=0;i--){
            check(S,A,visited, i);
        }

        System.out.println(visited[0] ? 1 : 0);
    }

    static void check(String S, Set<String>[] A, boolean[] visited, int idx) {
        char c = S.charAt(idx);

        loop:
        for (String subSentence : A[c - 'a']) {
            if(idx + subSentence.length() > S.length())
                continue;

            for (int j = 0; j < subSentence.length(); j++) {
                if (S.charAt(idx + j) != subSentence.charAt(j))
                    continue loop;
            }

            if(idx + subSentence.length() == S.length() || visited[idx + subSentence.length()]){
                visited[idx] = true;
            }
        }
    }
}