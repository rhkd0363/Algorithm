import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>(){
           @Override
            public int compare(String prev, String next){
                
                String[] prevArr = prev.split("[0-9]+");
                String[] nextArr = next.split("[0-9]+");
                
                int prevNumber = 0;
                int nextNumber = 0;
                
                for(int i=prevArr[0].length();i<prev.length();i++){
                    if(prev.charAt(i) > '9' || prev.charAt(i) < '0'){
                        prevNumber = Integer.parseInt( prev.substring(prevArr[0].length(), i) );
                        break;
                    }
                    
                    if(prev.length()-1 == i){
                        prevNumber = Integer.parseInt( prev.substring(prevArr[0].length()) );
                    }
                }
                
                for(int i=nextArr[0].length();i<next.length();i++){
                    if(next.charAt(i) > '9' || next.charAt(i) < '0'){
                        nextNumber = Integer.parseInt( next.substring(nextArr[0].length(), i) );
                        break;
                    }
                    
                    
                    if(next.length()-1 == i){
                        nextNumber = Integer.parseInt( next.substring(nextArr[0].length()) );
                    }
                }
            
                
                String prevHead = prevArr[0].toUpperCase();
                String nextHead = nextArr[0].toUpperCase();
                
                if(prevHead.equals(nextHead)){
                    if(prevNumber == nextNumber){
                        return 0;
                    }
                    
                    return prevNumber - nextNumber;
                }
                
                return prevHead.compareTo(nextHead);
                
            }
        });
        
        return files;
    }
}