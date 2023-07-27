import java.util.*;
import java.io.*;

public class Main {
    static int n, num;
    static int[] arr;
    static List<Integer> res;
    static boolean[] c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        c = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        res = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            c[i] = true;
            num = i;
            dfs(i);
            c[i] = false;
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        sb.append(res.size()).append('\n');
        for (int x : res) {
            sb.append(x+1).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int i) {
        if (arr[i] == num) res.add(num);

        if (!c[arr[i]]) {
            c[arr[i]] = true;
            dfs(arr[i]);
            c[arr[i]] = false;
        }
    }
}