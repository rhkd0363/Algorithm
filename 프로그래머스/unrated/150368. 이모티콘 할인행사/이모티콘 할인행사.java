import java.util.*;

class Solution {
    static int[][] discounts, userList;
    static int[] answer;
    static int[] price;
        
    public int[] solution(int[][] users, int[] emoticons) {
        
        price = new int[users.length];
        userList = users;
        answer = new int[2];
        discounts = new int[emoticons.length][5];
        
        for(int i=0;i<emoticons.length;i++){
            for(int j=1;j<=4;j++){
                discounts[i][j] = emoticons[i] * (10 - j) / 10;
            }
        }
        
        DFS(0);
        
        
        return answer;
    }
    
    static void DFS(int idx){
        if(idx == discounts.length){
            int plusCount = 0;
            int totalPrice = 0;
            
            for(int i=0;i<price.length;i++){
                if(price[i] >= userList[i][1])
                    plusCount++;
                else
                    totalPrice += price[i];
            }
            
            
            if(answer[0] == plusCount){
                answer[1] = Math.max(answer[1], totalPrice);
            }
            
            if(answer[0] < plusCount){
                answer[0] = plusCount;
                answer[1] = totalPrice;
            }
            
            return;
        }
        
        
        for(int i=1;i<=4;i++){
            for(int j=0;j<userList.length;j++){
                if(userList[j][0] <= i * 10){
                    price[j] += discounts[idx][i];
                }
            }
            
            DFS(idx + 1);
            
            for(int j=0;j<userList.length;j++){
                if(userList[j][0] <= i * 10){
                    price[j] -= discounts[idx][i];
                }
            }
        }
        
    }
}

