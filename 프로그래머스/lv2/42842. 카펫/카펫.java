class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
         for(int column=1;column<=Math.sqrt(yellow);column++){
             if(yellow % column == 0){
                int row = yellow / column;
                 
                 if(row * 2 + column * 2 + 4 == brown){
                     answer =  new int[]{row+2,column+2};
                     break;
                 }
             }
         }
        return answer;
                 
    }
}