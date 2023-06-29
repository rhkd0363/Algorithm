function solution(n) {
    return (n+"").split('').reverse().map((char) => parseInt(char))
}