import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            check = new boolean[N];
            res = Integer.MAX_VALUE;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            getFoodValue(0,0);

            sb.append("#"+t+" "+res).append('\n');

        }

        System.out.println(sb);
    }

    static int res;

    static void getFoodValue(int idx,int sel) {
        if(sel == N/2) {
            int sum = 0;
            int sum_ =0;
            for(int i=0;i<N-1;i++) {
                for(int j=i+1;j<N;j++) {
                    if(check[i] && check[j])
                        sum += arr[i][j]+arr[j][i];
                    else if(!check[i] && !check[j])
                        sum_ += (arr[i][j]+arr[j][i]);

                }
            }
            sum = Math.abs(sum - sum_);
            res = Math.min(res, sum);

            return;
        }else if(idx == N)
        	return;

	        check[idx] = true;
	        getFoodValue(idx+1,sel+1);
	        check[idx] = false;
	        getFoodValue(idx+1,sel);
    }
}