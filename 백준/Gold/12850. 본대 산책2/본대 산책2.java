import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());

        long[][] result = divideConquer(D);

        System.out.println(result[0][0]);

    }

    static long[][] setMap() {
        return new long[][]{{0, 1, 1, 0, 0, 0, 0, 0}, //정보
                {1, 0, 1, 1, 0, 0, 0, 0}, //전산
                {1, 1, 0, 1, 1, 0, 0, 0}, //미래
                {0, 1, 1, 0, 1, 1, 0, 0}, //신양
                {0, 0, 1, 1, 0, 1, 1, 0}, //한경
                {0, 0, 0, 1, 1, 0, 0, 1}, //진리
                {0, 0, 0, 0, 1, 0, 0, 1}, //형남
                {0, 0, 0, 0, 0, 1, 1, 0} //학생
        };
    }

    static long[][] cal(long[][] result, long[][] map) {
        long[][] tempResult = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    tempResult[i][j] = (tempResult[i][j] + (result[i][k] * map[k][j]) % 1_000_000_007) % 1_000_000_007;
                }
            }
        }

        return tempResult;
    }

    static long[][] divideConquer(int count){
        if(count == 1)
            return setMap();

        if(count % 2 == 0){
            long[][] map = divideConquer(count/2);
            return cal(map, map);
        }else{
            long[][] mapA = divideConquer(count/2);
            long[][] mapB = divideConquer(count/2+1);
            return cal(mapA,mapB);
        }
    }
}


