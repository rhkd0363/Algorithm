import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjListL = new ArrayList[N+1];
        List<Integer>[] adjListH = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            adjListL[i] = new ArrayList<>();
            adjListH[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            adjListL[l].add(h);
            adjListH[h].add(l);
        }

        int val = (N+1)/2;

        int answer = 0;
        boolean[] visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            Arrays.fill(visited,false);
            if(getCount(adjListH,visited, i) >= val) {
                answer++;
                continue;
            }
            Arrays.fill(visited,false);
            if (getCount(adjListL, visited, i) >= val)
                answer++;
        }

        System.out.println(answer);
    }

    static int getCount(List<Integer>[] list,boolean[] visited, int num){
        int count = 0;

        visited[num] = true;
        for(int i : list[num]){
            if(visited[i]) continue;
            visited[i] = true;
            count++;
            count += getCount(list,visited, i);
        }

        return count;
    }
}