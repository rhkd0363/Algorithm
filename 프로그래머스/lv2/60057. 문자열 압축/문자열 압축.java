class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
        // for(int i=1;i<2;i++){
            int length = s.length();
            int count = 1;
            for(int j=i;j<=s.length() - i; j+=i){
                String prev = s.substring(j-i,j);
                String curr = s.substring(j,j+i);
                
                if(prev.equals(curr)){
                    count++;
                    length -= i;
                }else{
                    if(count != 1)
                        length += count/1000 >= 1 ? 4 : count/100 >= 1 ? 3 : count/10 >= 1? 2 : 1;
                    count = 1;
                }
            }
           if(count != 1)
                length += count/1000 >= 1 ? 4 : count/100 >= 1 ? 3 : count/10 >= 1? 2 : 1;
            answer = Math.min(answer, length);
        }
        
        return answer;
    }
}