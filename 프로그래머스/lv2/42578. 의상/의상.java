import java.io.*;
import java.util.*;

class Solution {
    static int result, listSize;
    static Map<String, Integer> map;
    static ArrayList<String> keyList;
    
    public int solution(String[][] clothes) {
        
        map = new HashMap<>();
        keyList = new ArrayList<>();
        
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }else{
                map.put(clothes[i][1],1);
                keyList.add(clothes[i][1]);
            }
        }
        
        result = 0;
        
        for(int i=0;i<keyList.size();i++)
            combination(i+1, map.get(keyList.get(i)));
        
        return result;
    }
    
    static void combination(int idx, int cnt){
        
        for(int i=idx;i<keyList.size();i++){
            String keyName = keyList.get(i);
            
            combination(i+1, map.get(keyName) * cnt);
        }
        
        result += cnt;
    }
}
               