import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalWeight = 0;
        int time = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<truck_weights.length;i++){
            while(true){
                int size = queue.size();
                for(int j=0;j<size;j++){
                    int[] curr = queue.poll();

                    if(curr[1] == bridge_length){
                        totalWeight -= curr[0];
                        continue;
                    }
                    curr[1]++;
                    queue.add(curr);
                }

                time++;
                
                if(totalWeight + truck_weights[i] <= weight){
                    queue.add(new int[]{truck_weights[i], 1});
                    totalWeight += truck_weights[i];
                    break;
                }
            }
        }
        
        time += bridge_length;
        
        return time;
    }
}