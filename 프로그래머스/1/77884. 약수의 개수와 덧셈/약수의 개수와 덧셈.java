class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] memo = new int[right+1];
        for(int i=1;i<=right;i++){
            for(int j=i;j<=right;j++){
                if(j % i == 0){
                    memo[j]++;
                }
            }
            if(i >= left){
                answer += memo[i] % 2 == 0 ? i : -i;    
            }
        }
        
        return answer;
    }
}