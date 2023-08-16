import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!union(start, end, parent)) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }

    static boolean union(int start, int end, int[] parent) {
        int startRoot = find(start, parent);
        int endRoot = find(end, parent);
        if (startRoot == endRoot) return false;
        parent[endRoot] = startRoot;
        return true;
    }

    static int find(int num, int[] parent) {
        if (num == parent[num]) return num;
        return parent[num] = find(parent[num], parent);
    }
}