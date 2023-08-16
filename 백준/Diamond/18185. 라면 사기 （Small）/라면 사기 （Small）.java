import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+2];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;

        for(int i=0;i<N;i++){
//            if( i == N - 2){
//                int two = Math.min(arr[i],arr[i+1]);
//                result += two * 5;
//                arr[i] -= two;
//                arr[i + 1] -= two;
//
//                result += arr[i] * 3;
//                arr[i] = 0;
//            }else

            if(arr[i+1] > arr[i+2]){
                int two = Math.min(arr[i],arr[i+1] - arr[i+2]);
                result += two * 5;
                arr[i] -= two;
                arr[i + 1] -= two;

                int three = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                result += three * 7;
                arr[i] -= three;
                arr[i + 1] -= three;
                arr[i + 2] -= three;

                result+= arr[i] * 3;
                arr[i] = 0;
            }else {
                int three = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                result += three * 7;
                arr[i] -= three;
                arr[i + 1] -= three;
                arr[i + 2] -= three;

                int two = Math.min(arr[i], arr[i + 1]);
                result += two * 5;
                arr[i] -= two;
                arr[i + 1] -= two;

                result += arr[i] * 3;
                arr[i] = 0;
            }
        }

        System.out.println(result);
    }
}
