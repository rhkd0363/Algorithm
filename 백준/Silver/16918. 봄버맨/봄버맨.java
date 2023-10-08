import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        char[][] answer = new char[R][C];
        for(int i=0;i<R;i++) {
            map[i] = br.readLine().toCharArray();
            answer[i] = map[i].clone();
        }
        int[][] dxdy = {{-1,0},{1,0},{0,0},{0,-1},{0,1}};
        if(N % 2 ==0){
            fill(answer, R, C);
        }else{
            for(int i=2;i<=N;i++){
                if(i % 2 == 0)
                    fill(answer,R,C);
                else{
                    boom(answer, map, dxdy, R, C);
                    for(int j=0;j<R;j++)
                        map[j] = answer[j].clone();
                }
            }
        }
        for(char[] row : answer){
            for(char c : row){
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void boom(char[][] answer, char[][] map, int[][] dxdy, int R, int C){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'O'){
                    for(int k=0;k<dxdy.length;k++){
                        int nx = i + dxdy[k][0];
                        int ny = j + dxdy[k][1];
                        if(nx < 0 || ny <0 || nx >= R || ny >= C)
                            continue;
                        answer[nx][ny] = '.';
                    }
                }
            }
        }
    }

    static void fill(char[][] answer,int R, int C){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                answer[i][j] = 'O';
            }
        }
    }
}