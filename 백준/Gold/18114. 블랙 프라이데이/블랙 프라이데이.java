import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 상품 수
        int C = Integer.parseInt(st.nextToken()); // 원하는 무게
        int[] weights = new int[N]; // 상품 무게 배열

        st = new StringTokenizer(br.readLine()); //상품 무게들을 입력
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken()); // 상품 무게를 할당
            if (weights[i] == C) { // 만약! 상품 무게와 원하는 무게가 같다면
                System.out.println(1); //딩동댕
                return; //끝
            }
        }

        Arrays.sort(weights); // 이진탐색을 위해 정렬때립니다.

        int maxIdx = binarySearch(weights, 0, N - 1, C, false); //이진탐색을 통해서 maxIdx 를 구해서 범위를 좁혀줍니다.

        for (int i = 0, j = maxIdx; i < j; ) {
            int sum = weights[i] + weights[j];

            if (sum == C) {
                System.out.println(1);
                return;
            } else if (sum > C)
                j--;
            else {
                int idx = binarySearch(weights, i + 1, j - 1, C - sum, true);
                if (idx > i && idx < j && C - sum == weights[idx]) {
                    System.out.println(1);
                    return;
                }
                i++;
            }
        }

        System.out.println(0);
    }

    static int binarySearch(int[] w, int start, int end, int num, boolean check) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (check && w[mid] == num)
                return mid;

            if (w[mid] >= num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
