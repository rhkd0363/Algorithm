import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        List<Integer>[] Tree = new ArrayList[N * 4];
        setTree(Tree, arr, 1, 1, N);

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] res = getNumber(Tree, 1, 1, N, start, end);

            sb.append(res[0] + " " + res[1]).append('\n');
        }
        System.out.println(sb);
    }

    static List<Integer> setTree(List<Integer>[] Tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            Tree[node] = new ArrayList<>();
            Tree[node].add(arr[start]);
            return Tree[node];
        }
        Tree[node] = new ArrayList<>();

        int mid = (start + end) / 2;

        List<Integer> left = setTree(Tree, arr, node * 2, start, mid);
        List<Integer> right = setTree(Tree, arr, node * 2 + 1, mid + 1, end);

        int leftP = 0;
        int rightP = 0;

        while (leftP < left.size() && rightP < right.size()) {
            if (left.get(leftP) <= right.get(rightP)) {
                Tree[node].add(left.get(leftP));
                leftP++;
            } else {
                Tree[node].add(right.get(rightP));
                rightP++;
            }
        }

        if (leftP == left.size()) {
            while (rightP < right.size()) {
                Tree[node].add(right.get(rightP));
                rightP++;
            }
        }

        if (rightP == right.size()) {
            while (leftP < left.size()) {
                Tree[node].add(left.get(leftP));
                leftP++;
            }
        }

        return Tree[node];
    }


    static int[] getNumber(List<Integer>[] Tree, int node, int start, int end, int min, int max) {
        int[] result = new int[2];
        if (end < min || max < start) {
            result[0] = 1000000001;
            result[1] = -1;
            return result;
        }

        if (min <= start && end <= max) {
            result[0] = Tree[node].get(0);
            result[1] = Tree[node].get(Tree[node].size() - 1);
            return result;
        }

        int mid = (start + end) / 2;

        int[] left = getNumber(Tree, node * 2, start, mid, min, max);
        int[] right = getNumber(Tree, node * 2 + 1, mid + 1, end, min, max);

        result[0] = Math.min(left[0], right[0]);
        result[1] = Math.max(left[1], right[1]);

        return result;
    }
}