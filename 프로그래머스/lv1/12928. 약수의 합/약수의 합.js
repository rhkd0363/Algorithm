function solution(n) {
    var answer = 0;
    
    let i = 0;
    
    while(i++ < n){
        answer += n % i === 0 ? i : 0;
    }
    
    return answer;
}