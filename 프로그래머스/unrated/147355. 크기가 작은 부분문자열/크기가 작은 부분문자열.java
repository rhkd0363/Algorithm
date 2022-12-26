class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0;i<=t.length()-p.length();i++){
            int cnt = 0;
            for(int j=i;j<i+p.length();j++){ 
                if(t.charAt(j) == p.charAt(cnt)){
                    if(j != i+p.length()-1){
                        cnt++;
                        continue;
                    }
                    answer++;
                }
                if(t.charAt(j) < p.charAt(cnt))
                    answer++;
                break;
            }
        }
        
        return answer;
    }
}