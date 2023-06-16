class Solution {
    static int answer;
    static String answerWord;
    static char[] vowels = {'A','E','I','O','U'};
    
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
           if(DFS(idx+1, word+vowels[i])){
               return true;
           }
        }
        
        return false;
    }
}