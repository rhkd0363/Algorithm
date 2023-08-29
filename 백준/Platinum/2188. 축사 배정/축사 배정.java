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
        boolean[] check = new boolean[M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=1;j<=num;j++){
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            Arrays.fill(check,false);
            if(DFS(check, adjList, barn, i))
                cnt++;
        }

        System.out.println(cnt);
    }

    static boolean DFS(boolean[] check,List<Integer>[] adjList,int[] barn, int number){
        for(int i : adjList[number]){
            if(check[i])
                continue;

            check[i] = true;

            if(barn[i] == 0 || DFS(check, adjList, barn, barn[i])){
                barn[i] = number;
                return true;
            }
        }
        return false;
    }
}