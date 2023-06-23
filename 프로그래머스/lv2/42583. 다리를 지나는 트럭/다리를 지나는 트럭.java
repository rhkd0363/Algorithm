import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalWeight = 0; // 다리 위의 트럭들의 총 무게의 합
        int time = 0; // 소요되는 최소 시간
        
        Queue<int[]> queue = new LinkedList<>(); // 다리를 건너고 있는 트럭 정보를 담은 큐 (트럭정보 [무게, 진행거리])
        
        for(int i=0;i<truck_weights.length;i++){ // 반복문 시작
            while(true){ // 해당 인덱스 번째의 트럭이 다리에 진입할때까지 반복한다.
                int size = queue.size(); 
                for(int j=0;j<size;j++){ // 큐에 들어 있는 트럭들의 진행거리를 1씩 증가시킨다.
                    int[] curr = queue.poll(); // 큐에서 트럭 정보를 꺼낸다,

                    if(curr[1] == bridge_length){ // 트럭의 진행거리가 다리의 길이와 같다 -> 다리를 다 건넜다.
                        totalWeight -= curr[0]; // 트럭 총 무게에서 빠져나간 트럭의 무게를 빼준다.
                        continue;
                    }
                    curr[1]++; // 트럭 진행거리 1 증가
                    queue.add(curr); // 진행거리가 증가된 트럭을 다시 큐에 넣어준다.
                }

                time++; // 소요시간 증가
                
                if(totalWeight + truck_weights[i] <= weight){ // 트럭이 다리에 진입할 수 있다면
                    queue.add(new int[]{truck_weights[i], 1}); // 큐에 트럭 정보를 넣어주고
                    totalWeight += truck_weights[i]; // 전체 무게에 진입한 트럭무게를 더해준다.
                    break;
                }
            }
        }
        
        time += bridge_length; // 마지막으로 올라간 트럭이 다리를 빠져나가는 시간을 더해준다.
        
        return time;
    }
}