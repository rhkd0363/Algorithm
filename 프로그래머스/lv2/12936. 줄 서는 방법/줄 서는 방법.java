class Solution {
    public int[] solution(int n, long k) {
        
        long[] memo = new long[n+1];
        
        if(n == 1){
            return new int[]{1};
        }
        
        if(n == 2){
            if(k ==  1)
                return new int[]{1,2};
            return new int[]{2,1};
        }
        
        
        memo[1] = 0;
        memo[2] = 1;
        
        for(int i=3;i<n+1;i++){
            memo[i] = memo[i-1] * (i-1);

        }
        
        boolean[] visited = new boolean[n+1];
        
        int[] answer = new int[n];
        
        for(int i=n;i>=3;i--){
            long a = k / memo[i];
            long b = k % memo[i];
            
            k = b;
            
            if(k == 0){
                k = memo[i];
            }
            
            if(b == 0)
                a--;
            int count = 0;
            
            for(int j=1;j<=n;j++){
                
                if(visited[j])
                    continue;
                
                if(count == a){
                    answer[n - i] = j;
                    visited[j] = true;
                    break;    
                }
                count++;
            }
        }
        
        if(k % 2 == 0){
            for(int i=1;i<=n;i++){
                if(visited[i])
                    continue;
                if(answer[n-1] == 0){
                    answer[n-1] = i;
                }else{
                    answer[n-2] = i;
                }
            }
        }else{
            for(int i=1;i<=n;i++){
                if(visited[i])
                    continue;
                if(answer[n-2] == 0){
                    answer[n-2] = i;
                }else{
                    answer[n-1] = i;
                }
            }
        }
        
        return answer;
    }
}