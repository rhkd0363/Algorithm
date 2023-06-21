import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            char[] bit = ("0" + Long.toBinaryString(numbers[i])).toCharArray();
            
            int index = bit.length-1;
            
            for(int j=bit.length-1;j>=0;j--){
                if(bit[j] == '0'){
                    index = j;
                    bit[j] = '1';
                    break;
                }
            }
            
            for(int j=index+1;j < bit.length;j++){
                if(bit[j] == '1'){
                    bit[j] = '0';
                    break;
                }
            }
            
            for(int j=0;j<bit.length;j++){
                answer[i] += (bit[j]-'0') * Math.pow(2, bit.length - 1 - j);
            }
        }
        
        return answer;
    }
}