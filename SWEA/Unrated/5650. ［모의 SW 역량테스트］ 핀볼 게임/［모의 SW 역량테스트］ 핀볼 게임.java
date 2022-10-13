import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
/*
 * 핀볼은 벽을 만나면 반대 방향으로 돌아온다.
 * 장애물의 수직 수평면을 만나도 반대 방향으로 돌아온다.
 * 장애물의 경사면을 만나면 직각으로 방향이 바뀐다.
 * 
 * 핀볼이 웜홀에 빠지면 동일한 숫자를 가진 다른 반대편 웜홀로 빠져 나오게 되며 진행방향은 그대로 유지된다.
 * (웜홀은 반드시 쌍으로 주어지며, 입력에서는 6 이상 10 이하의 숫자로 표시된다.)
 * 
 * 핀볼이 블랙홀을 만나면, 핀볼이 사라지게 되어 게임은 끝나게 된다.
 * 
 * 게임은 핀볼이 출발 위치로 돌아오거나, 블랙홀에 빠질 때 끝나게 되며, 점수는 벽이나 블록에 부딪힌 횟수가 된다. 
 * (웜홀을 통과하는 것은 점수에 포함되지 않는다.)
 * 
 * 게임판 위에서 출발 위치와 진행 방향을 임의로 선정가능 할 때,
 * 게임에서 얻을 수 있는 점수의 최댓값을 구하여라!
 */
 
public class Solution {
    static int[][] map;
    static List<int[]>[] wormhole;
    static int N, M, R, C, L;
 
    // 현재위치에서 이전위치의 값을 빼서 온 방향을 확인하고, 해당하는 방향으로 보내주자 (상하좌우 순서)
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
     
    // 올라간다. 내려간다. 왼쪽으로 간다. 오른쪽으로 간다.
    static int[][] dir = { { 1, 3, 0, 2 }, { 3, 0, 1, 2 }, { 2, 0, 3, 1 }, { 1, 2, 3, 0 }, { 1, 0, 3, 2 } };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            map = new int[N][N];
 
            wormhole = new ArrayList[11]; // 웜홀 위치 담아줄 공간
 
            for (int i = 6; i <= 10; i++)
                wormhole[i] = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    switch (map[i][j]) {
                    case 6:
                        wormhole[6].add(new int[] { i, j });
                        break;
                    case 7:
                        wormhole[7].add(new int[] { i, j });
                        break;
                    case 8:
                        wormhole[8].add(new int[] { i, j });
                        break;
                    case 9:
                        wormhole[9].add(new int[] { i, j });
                        break;
                    case 10:
                        wormhole[10].add(new int[] { i, j });
                        break;
                    }
                }
            }
 
            int maxScore = 0;
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0)
                        for (int k = 0; k < 4; k++) { // 상 하 좌 우 순서
                            maxScore = Math.max(maxScore, getScore(i, j, k));
                        }
                }
            }
             
            sb.append('#').append(t).append(' ').append(maxScore).append('\n');
        }
        System.out.println(sb);
    }
 
     
    static int getScore(int r, int c, int next) {
        int endR = r;
        int endC = c;
        int res = 0;
 
        while (true) {
            int nr = r + dr[next];
            int nc = c + dc[next];
 
            r = nr;
            c = nc;
             
            if (nr >= N) { // 경계에 부딪힐 때 방향 전환
                next = 0;
                res++;
                continue;
            } else if (nr < 0) {
                next = 1;
                res++;
                continue;
            } else if (nc >= N) {
                next = 2;
                res++;
                continue;
            } else if (nc < 0) {
                next = 3;
                res++;
                continue;
            }
 
            if (map[nr][nc] == -1 || (nr == endR && nc == endC)) { //블랙홀이나 시작지점 만나면 종료
                break;
            }
             
             
            switch(map[nr][nc]) {
            case 1: //현재 내 방향에 따른 다음 방향
                res++;
                next = dir[0][next];
                r = nr;
                c = nc;
                break;
            case 2:
                res++;
                next = dir[1][next];
                r = nr;
                c = nc;
                break;
            case 3:
                res++;
                next = dir[2][next];
                r = nr;
                c = nc;
                break;
            case 4:
                res++;
                next = dir[3][next];
                r = nr;
                c = nc;
                break;
            case 5:
                res++;
                next = dir[4][next];
                r = nr;
                c = nc;
                break;
                 
            case 6:  //웜홀 만날 때
                if(wormhole[6].get(0)[0] == nr && wormhole[6].get(0)[1] == nc) { 
                    r = wormhole[6].get(1)[0];
                    c = wormhole[6].get(1)[1];
                }else {
                    r = wormhole[6].get(0)[0];
                    c = wormhole[6].get(0)[1];
                }
                break;
            case 7:
                if(wormhole[7].get(0)[0] == nr && wormhole[7].get(0)[1] == nc) { 
                    r = wormhole[7].get(1)[0];
                    c = wormhole[7].get(1)[1];
                }else {
                    r = wormhole[7].get(0)[0];
                    c = wormhole[7].get(0)[1];
                }
                break;
            case 8:
                if(wormhole[8].get(0)[0] == nr && wormhole[8].get(0)[1] == nc) { 
                    r = wormhole[8].get(1)[0];
                    c = wormhole[8].get(1)[1];
                }else {
                    r = wormhole[8].get(0)[0];
                    c = wormhole[8].get(0)[1];
                }
                break;
            case 9:
                if(wormhole[9].get(0)[0] == nr && wormhole[9].get(0)[1] == nc) { 
                    r = wormhole[9].get(1)[0];
                    c = wormhole[9].get(1)[1];
                }else {
                    r = wormhole[9].get(0)[0];
                    c = wormhole[9].get(0)[1];
                }
                break;
            case 10:
                if(wormhole[10].get(0)[0] == nr && wormhole[10].get(0)[1] == nc) { 
                    r = wormhole[10].get(1)[0];
                    c = wormhole[10].get(1)[1];
                }else {
                    r = wormhole[10].get(0)[0];
                    c = wormhole[10].get(0)[1];
                }
                break;
            }
 
        }
 
        return res;
    }
}