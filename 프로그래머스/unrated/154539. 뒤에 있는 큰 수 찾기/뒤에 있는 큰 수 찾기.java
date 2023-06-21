import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
               int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for(int i=1;i<numbers.length;i++){
            int size = stack.size();

            for(int j=0;j<size;j++){
                int index = stack.pop();

                if(numbers[index] < numbers[i]){
                    answer[index] = numbers[i];
                }else{
                    stack.push(index);
                    break;
                }
            }
            stack.push(i);
        }

        return answer;
    }
}