import java.util.*;

class Solution {
    static int[][] discounts, userList;
    static int[] answer;
    static int[] price;
        
    public int[] solution(int[][] users, int[] emoticons) {
        userList = users;
        answer = new int[2];
        price = new int[users.length]; // 각각 사람의 구매 누적 금액
        discounts = new int[emoticons.length][5]; // 10 ~ 40 % 까지 할인율이 적용된 이모티콘 금액 배열
        
        for(int i=0;i<emoticons.length;i++){ // 반복문을 통해 discounts 배열에 할인율이 적용된 값을 넣어준다. 
            for(int j=1;j<=4;j++){
                discounts[i][j] = emoticons[i] * (10 - j) / 10;
            }
        }
        
        DFS(0); // DFS 시작
        
        return answer;
    }
    
    static void DFS(int idx){
        if(idx == discounts.length){ // 모든 이모티콘을 확인했다면(idx가 이모티콘 배열의 길이가 되었다면)
            int plusCount = 0;
            int totalPrice = 0;
            
            for(int i=0;i<price.length;i++){ // 반복문을 통해 이모티콘 플러스 가입자인지 파악
                if(price[i] >= userList[i][1]) // 가입자에 해당하면 plusCount 증가, 아니면 totalPrice 증가
                    plusCount++;
                else
                    totalPrice += price[i];
            }
            
            
            if(answer[0] == plusCount){ // 가입자 수가 최대인지
                answer[1] = Math.max(answer[1], totalPrice);
            }
            
            if(answer[0] < plusCount){ // 가입자 수가 같다면 금액이 최대인지 확인
                answer[0] = plusCount;
                answer[1] = totalPrice;
            }
            
            return;
        }
        
        
        for(int i=1;i<=4;i++){ // 할인율 10 -> 40 % 까지 증가하며 DFS 진행
            for(int j=0;j<userList.length;j++){ // 사용자의 기준에 충족되면 금액 누적시키고 DFS
                if(userList[j][0] <= i * 10){
                    price[j] += discounts[idx][i];
                }
            }
            
            DFS(idx + 1);
            
            for(int j=0;j<userList.length;j++){ // 다음 할인율 기준 적용을 위해 누적금액에서 다시 빼준다.
                if(userList[j][0] <= i * 10){
                    price[j] -= discounts[idx][i];
                }
            }
        }
        
    }
}

