import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new ArrayList[N+1];

        for(int i=1;i<=N;i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] barn = new int[M+1];
        boolean[][] check = new boolean[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=1;j<=num;j++){
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(DFS(check, adjList, barn, i, i))
                cnt++;
        }

        System.out.println(cnt);
    }

    static boolean DFS(boolean[][] check,List<Integer>[] adjList,int[] barn, int number, int curr){
        for(int i : adjList[curr]){
            if(check[number][i])
                continue;

            check[number][i] = true;

            if(barn[i] == 0 || DFS(check, adjList, barn, number, barn[i])){
                barn[i] = curr;
                return true;
            }
        }
        return false;
    }
}