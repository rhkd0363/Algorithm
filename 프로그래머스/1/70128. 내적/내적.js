function solution(a, b) {
    let answer = a.reduce((sum, num, idx)=>{
        return sum += num * b[idx]
    }, 0)
    
    return answer;
}