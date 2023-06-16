class Solution {
    static int answer;
    static String answerWord;
    
    public int solution(String word) {
        answer = 0;
        answerWord = word;
        
        DFS(0, "");
        
        return answer;
    }
    
    static boolean DFS(int idx, String word){
        if(word.equals(answerWord))
            return true;
        
        answer++;
        
        if(idx == 5)
            return false;
        
        
        for(int i=0;i<5;i++){
            switch (i){
                case 0:
                    if(DFS(idx+1, word+"A"))
                        return true;
                    break;
                case 1:
                    if(DFS(idx+1, word+"E"))
                        return true;
                    break;
                case 2:
                    if(DFS(idx+1, word+"I"))
                        return true;
                    break;
                case 3:
                    if(DFS(idx+1, word+"O"))
                        return true;
                    break;
                case 4:
                    if(DFS(idx+1, word+"U"))
                        return true;
                    break;
            }
        }
        
        return false;
    }
}