import java.io.*;
import java.util.*;

class Solution {
    static int[][] drdc = {{0,1},{1,0},{1,1}};;
    static char[][] newBoard;
    static int answer;
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        newBoard = new char[m][n];
        
        for(int i=0;i<m;i++)
            newBoard[i] = board[i].toCharArray();
        
        checkBlock(m, n);
        
        return answer;
    }
    
    static void checkBlock(int m, int n){
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<m-1;i++){
            loop : for(int j=0;j<n-1;j++){
                if(newBoard[i][j] == '.')
                    continue;
                
                for(int k=0;k<3;k++){
                    int nr = i + drdc[k][0];
                    int nc = j + drdc[k][1];
                    
                    if(newBoard[i][j] != newBoard[nr][nc])
                        continue loop;
                }
                
                set.add(i+" "+j);
                
                for(int k=0;k<3;k++){
                    int nr = i + drdc[k][0];
                    int nc = j + drdc[k][1];
                    
                    set.add(nr+" "+nc);
                }
            }
        }
        
        if(set.size() == 0)
            return;
        
        answer += set.size();
        
        for(String pos : set){
            String[] temp = pos.split(" ");
            newBoard[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = '.';
        }
        
        moveBlock(m, n);
    }
    
    static void moveBlock(int m, int n){
        
        for(int i=n-1;i>=0;i--){
            String str = "";
            for(int j=m-1;j>=0;j--){
                if(newBoard[j][i] != '.'){
                    str += newBoard[j][i];
                }
            }
            
            int k = 0;
            for(int j=m-1;j >= m - str.length();j--){
                newBoard[j][i] = str.charAt(k++);
            }
            
            for(int j=m-str.length()-1; j >=0; j--){
                newBoard[j][i] = '.';
            }
        }
        
        checkBlock(m, n);
    }
}