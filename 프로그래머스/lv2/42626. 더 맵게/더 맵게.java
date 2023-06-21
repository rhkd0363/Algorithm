import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        Arrays.sort(scoville);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int type = 0;
        int answer = 0;
        
        for(int i=0;i<scoville.length;i++){
            if(scoville[i] < K){
                pq.add(scoville[i]);
            }else{
                type++;
            }
        }
        
        
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                if(type != 0)
                    answer++;
                break;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            
            answer++;
            
            if(a+b*2 < K){
                pq.add(a+b*2);
            }else{
                type++;
            }
        }
        
        if(type == 0)
            return -1;
        
        return answer;
    }
}