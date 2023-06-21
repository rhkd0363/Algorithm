import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        int max = numbers.length-1;

        for(int i=numbers.length-1;i>=0;i--){
            if(numbers[i] >= numbers[max]){
                max = i;
                answer[i] = -1;
            }
            for(int j=i;j<=max;j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }
                if(numbers[i] < answer[j]){
                    answer[i] = answer[j];
                    break;
                }
            }
        }

        return answer;
    }
}