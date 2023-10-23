import java.io.*;
import java.util.*;

public class Main {
    static long[] bit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        initBitCount();

        long ans = getBitCount(b) - getBitCount(a - 1);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static long getBitCount(long x) {
        long ans = x & 1;

        for (int i = 54; i > 0; i--) {
            if ((x & (1L << i)) > 0L) {
                ans += bit[i - 1] + (x - (1L << i) + 1);
                x -= (1L << i);
            }
        }
        return ans;
    }

    static void initBitCount() {
        bit = new long[55];
        bit[0] = 1;
        for (int i = 1; i < 55; i++) {
            bit[i] = 2 * bit[i - 1] + (1L << i);
        }
    }
}