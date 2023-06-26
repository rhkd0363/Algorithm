class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            int length = checkString(i, s.length(), s); 
            answer = Math.min(answer, length);
        }
        
        return answer;
    }
    
    static int checkString(int num, int length, String str){
        int count = 1;
        int result = 0;
        
        for(int i = num;i<=length - num; i+=num){
                String prev = str.substring(i-num,i);
                String curr = str.substring(i,i+num);
                
                if(prev.equals(curr)){
                    count++;
                }else{
                    if(count != 1)
                        result += calcDigit(count);
                    count = 1;
                    result += num;
                }
            }
        
       if(count != 1)
            result += calcDigit(count);
        
        result += num + (length % num);
      
        return result;
    }
    
    static int calcDigit(int number){
        for(int i = 3; i >= 0; i--){
            if(number / Math.pow(10, i) >= 1)
                return i+1;
        }
        return 0;
    }
}