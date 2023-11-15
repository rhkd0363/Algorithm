function solution(a, b) {
    let answer = 0
    for(let idx = 0; idx < a.length; idx++){
        answer += a[idx] * b[idx]
    }
    return answer;
}