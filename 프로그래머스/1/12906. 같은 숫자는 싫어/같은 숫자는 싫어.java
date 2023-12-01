import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> list = new ArrayList();
        
        int prev = -1;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(prev != num) list.add(num);
            prev = num;
        }

        return list;
    }
}