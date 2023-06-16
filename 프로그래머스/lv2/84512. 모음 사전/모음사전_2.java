class Solution {
    static int answer;
    static int answerValue;
    
    public int solution(String word) {
        answer = 0;
        answerValue = 0;
        
        for(int i=0;i<word.length();i++){
            int val = 0;
            switch (word.charAt(i)) {
                case 'A':
                    val = 1;
                    break;  
                case 'E':
                    val = 2;
                    break;
                case 'I':
                    val = 3;
                    break;
                case 'O':
                    val = 4;
                    break;
                case 'U':
                    val = 5;
                    break;
            }
            answerValue += val * (int)Math.pow(10,i);
        }
        
        DFS(0, 0);
        
        return answer;
    }
    
    static boolean DFS(int idx, int value){
        if(value == answerValue)
            return true;
        
        answer++;
        
        if(idx == 5)
            return false;
        
        
        for(int i=1;i<=5;i++){
           if(DFS(idx+1, value + i * (int)Math.pow(10, idx))){
               return true;
           }
        }
        
        return false;
    }
}
