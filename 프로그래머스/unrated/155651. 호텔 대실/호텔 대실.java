import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int answer = 0;
        
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] a, String[] b){
                
                return a[1].compareTo(b[1]);
            }
        });
        
        loop : for(int i=0;i<book_time.length;i++){
            String[] time = book_time[i][0].split(":");
            int startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            time = book_time[i][1].split(":");
            int endTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) + 10;
            
            int count = 1;
            
            for(int j= i+1; j<book_time.length;j++){
                time = book_time[j][0].split(":");
                int nextStart = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                
                time = book_time[j][1].split(":");
                int nextEnd = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                
                if(startTime <= nextStart && nextStart < endTime){
                    count++;
                    continue;
                }
                
                if(startTime >= nextStart && endTime <= nextEnd){
                    count++;
                    continue;
                }
                
                if(startTime <= nextEnd && nextEnd < endTime){
                    count++;
                    continue;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}