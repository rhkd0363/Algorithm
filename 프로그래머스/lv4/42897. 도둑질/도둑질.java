class Solution {
    public int solution(int[] money) {
        
        int[] dp_1 = new int[money.length];
        int[] dp_2 = new int[money.length];
        
        dp_1[0] = money[0];
        dp_1[1] = money[1];
        dp_1[2] = money[0]+money[2];
        
        dp_2[1] = money[1];
        dp_2[2] = money[2];
        
        for(int i=3;i<money.length;i++){
            dp_1[i] = Math.max(dp_1[i-2]+money[i], dp_1[i-3]+money[i]);
            dp_2[i] = Math.max(dp_2[i-2]+money[i], dp_2[i-3]+money[i]);
        }
        
        int answer = Math.max(Math.max(dp_1[dp_1.length-2],dp_1[dp_1.length-3]),Math.max(dp_2[dp_2.length-1],dp_2[dp_2.length-2]));
        return answer;
    }
}