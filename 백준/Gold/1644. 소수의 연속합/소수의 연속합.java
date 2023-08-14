import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        List<Integer> primeList = new ArrayList<>();
        for(int i=2;i<=N;i++){
            if(check[i])
                continue;
            primeList.add(i);
            for(int j=i+i;j<=N;j+=i){
                check[j] = true;
            }
        }
        primeList.add(987654321);
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        while (start <= end && end < primeList.size()) {
            if(sum < N){
                sum += primeList.get(end);
                end++;
            }else if(sum > N){
                sum -= primeList.get(start);
                start++;
            }else{
                answer++;
                sum += primeList.get(end);
                end++;
            }
        }
        System.out.println(answer);
    }
}