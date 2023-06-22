// 시간초과난다.. 재귀로 했을때랑 아래처럼 했을때의 차이가 뭘까..

import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        Map<Long, Long> map = new HashMap<>();
        
        for(int i=0;i<room_number.length;i++){
            if(!map.containsKey(room_number[i])){
                map.put(room_number[i], room_number[i]+1);                
                continue;
            }
            
            long number = map.get(room_number[i]);
            
            while(true){
                if(!map.containsKey(number)){
                    room_number[i] = number;
                    map.put(number, number + 1);
                    break;
                }
                
                map.put(number, map.get(number) + 1);                
                number = map.get(number) - 1;
            }
        }
        
        return room_number;
    }
}
