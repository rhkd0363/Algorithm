import java.io.*;
import java.util.*;

public class Main {
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr_2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr_2[i] = Integer.parseInt(st.nextToken());
        answer = false;
        check(arr,arr_2);

        quickSort(arr, arr_2, 0, arr.length - 1);

        System.out.println(answer ? 1 : 0);

    }

    static void quickSort(int[] arr, int[] arr_2, int left, int right) {
        if (answer)
            return;
        if (left < right) {
            int pivot = partition(arr, arr_2, left, right);
            // 피봇은 파티션을 통해 이미 정렬되어 반환되므로 pivot -1, pivot +1을 인자로 넘겨준다.
            quickSort(arr, arr_2, left, pivot - 1);
            quickSort(arr, arr_2, pivot + 1, right);
        }

    }

    static int partition(int[] arr, int[] arr_2, int left, int right) {
        // 피봇을 선택한다.
        int pivot = arr[left];
        int L = left + 1, R = right;

        // L 과 R 이 서로 교차가 일어날때 까지 반복
        while (L <= R) {
            // L 이 R 보다 작고, L위치의 값이 피봇보다 큰 값을 찾을 때까지 L을 증가시킨다.
            while (L <= R && arr[L] <= pivot)
                L++;
            // 반대로 R위치의 값은 피봇보다 작거나 같을때까지 감소한다.
            while (arr[R] > pivot)
                R--;
            // 반복문을 실행한 결과 L 과 R 이 교차되지 않았다면, L의 위치의 값이 R의 위치의 값보다
            // 작은 값이므로 서로의 값을 바꿔준다.
            if (L < R) {
                swap(arr, L, R);
                check(arr, arr_2);

                if (answer)
                    return R;
            }
        }

        swap(arr, left, R);
        check(arr, arr_2);
        return R;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void check(int[] arr, int[] arr_2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr_2[i]) {
                answer = false;
                return;
            }
        }
        answer = true;
    }
}