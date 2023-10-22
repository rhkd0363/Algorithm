class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            String removeZeroString = s.replaceAll("0","");
            answer[0]++;
            answer[1] += s.length() - removeZeroString.length();
            s = Integer.toBinaryString(removeZeroString.length());
        }
        
        return answer;
    }
}