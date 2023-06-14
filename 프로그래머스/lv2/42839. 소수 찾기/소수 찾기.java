import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static String numberList;
    static int answer;
    static HashSet<Integer> list;
    
    public int solution(String numbers) {
        answer = 0;
        
        numberList = numbers;
        
        visited = new boolean[numberList.length()];
        
        list = new HashSet<>();
        
        for(int i=0;i<numberList.length();i++)
            DFS(0,i);
        
        return list.size();
    }
    
    static void DFS(int number, int idx){
        if(visited[idx])
            return;
        
        visited[idx] = true;
        
        number += numberList.charAt(idx) - '0';
        
        getPrime(number);
        
        for(int i=0;i<numberList.length();i++){
            DFS(number*10, i);  
        }
        
        visited[idx] = false;
    }
    
    static void getPrime(int number){
        if(number < 2) return;
        
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i == 0)
                return;
        }
        
        list.add(number);
    }   
}