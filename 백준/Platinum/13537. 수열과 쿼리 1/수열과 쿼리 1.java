import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] Tree;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        values = new int[N + 1];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++)
            values[i + 1] = Integer.parseInt(input[i]);

        Tree = new ArrayList[N * 4];

        setTree(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int range_s = Integer.parseInt(input[0]);
            int range_e = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            sb.append(getResult(1, 1, N, k, range_s, range_e)).append('\n');
        }

        System.out.println(sb);
    }

    static List<Integer> setTree(int node, int start, int end) {
        if (start == end) {
            Tree[node] = new ArrayList<>();
            Tree[node].add(values[start]);
            return Tree[node];
        }

        Tree[node] = new ArrayList<>();

        int mid = (start + end) / 2;
        List<Integer> left = setTree(node * 2, start, mid);
        List<Integer> right = setTree(node * 2 + 1, mid + 1, end);

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

    static int getResult(int node, int start, int end, int k, int range_s, int range_e) {
        if (range_e < start || range_s > end)
            return 0;

        if (range_s <= start && end <= range_e) {
            return Tree[node].size() - 1 - binarySearch(Tree[node], k);
        }

        int mid = (start + end) / 2;

        return getResult(node * 2, start, mid, k, range_s, range_e) + getResult(node * 2 + 1, mid + 1, end, k, range_s, range_e);
    }

    static int binarySearch(List<Integer> list, int k) {
        int start = 0;
        int end = list.size() - 1;
        int mid = (start + end) / 2;

        while (true) {
            if (start > end) {
                if (list.get(mid) > k) {
                    mid--;
                }
                break;
            }
            //만약 찾는 값이 중앙 값보다 작다면 왼쪽을 검색
            if (list.get(mid) > k) {
                //중앙값은 이미 검사했으니 중앙 이전 값을 종료 인덱스에 넣어준다 end=mid-1
                end = mid - 1;
                mid = (start + end) / 2;
            }
            //만약 찾는 값이 중앙 값보다 크다면 오른쪽 검색
            else if (list.get(mid) <= k) {
                //중앙값은 이미 검사했으니 중앙 다음 값을 시작인덱스에 넣어준다 str=mid+1
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }

        return mid;
    }
}
