import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputLine.charAt(j) - '0';
                if(map[i][j] == 1)
                    answer = 1;
            }
        }

        int[][] dxdy = {{-1,0},{0,-1},{-1,-1}};



        for(int i=1;i<n;i++){
            loop : for(int j=1;j<m;j++){
                if(map[i][j] == 0)
                    continue;
                int min = 987654321;
                for(int k=0;k<3;k++){
                    int nx = i+dxdy[k][0];
                    int ny = j+dxdy[k][1];

                    if(map[nx][ny] == 0)
                        continue loop;

                    min = Math.min(min, map[nx][ny]);
                }
                map[i][j] = min+1;
                answer = Math.max(answer,map[i][j]);
            }
        }

        System.out.println(answer*answer);
    }
}
