import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int posA = A.length - 1;
        int posB = B.length - 1;
        
        int answer = 0;
        
        while(true){
            if(posA == -1 || posB == -1){
                break;
            }
            
            if(A[posA] < B[posB]){
                posA--;
                posB--;
                answer++;
            }
            else{
                posA--;
            }
        }
        
        return answer;
    }
}