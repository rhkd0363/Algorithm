def solution(n):
    answer = 0
    left = 1
    sum = 0
    for right in range(1,n+1) :
        sum += right
        
        while (sum > n):
            sum -= left
            left += 1
            
        if(sum == n):
            answer += 1
            
    return answer