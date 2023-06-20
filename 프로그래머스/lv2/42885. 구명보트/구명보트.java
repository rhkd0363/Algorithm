import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length -1;
        
        Arrays.sort(people);
        
        int answer = 0;
        
        while(true){
            if(start == end){
                answer++;
                break;
            }
            
            if(start > end)
                break;
            
            while(end > start && limit < people[end] + people[start]){
                end--;
                answer++;
            }
            
            int sum = people[end];
            
            while(end > start && limit >= sum + people[start]){
                sum += people[start];
                start++;
            }
            
            end--;
            answer++;
        }
        
        return answer;
    }
}