function solution(arr, divisor) {
    let answer = arr.filter(val => val % divisor === 0 ? val : null).sort((a,b)=>a-b)
    return answer.length !== 0 ? answer : [-1]
}