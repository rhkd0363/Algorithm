import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static String numberList;
    static int answer;
    static HashSet<Integer> list;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        list = new HashSet<>();
        numberList = numbers;
        answer = 0;
        
        for(int i=0;i<numberList.length();i++)
            DFS(0,i);
        
        return list.size();
    }
    
    static void DFS(int number, int idx){
        if(visited[idx])
            return;
        
        visited[idx] = true;
        number += numberList.charAt(idx) - '0';
        if(number >= 2)
            getPrime(number);
        for(int i=0;i<numberList.length();i++){
            DFS(number*10, i);  
        }
        visited[idx] = false;
    }
    
    static void getPrime(int number){
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i == 0)
                return;
        }    
        list.add(number);
    }   
}