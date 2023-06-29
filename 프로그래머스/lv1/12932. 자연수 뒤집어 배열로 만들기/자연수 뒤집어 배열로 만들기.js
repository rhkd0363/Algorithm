function solution(n) {
    return [...(n+"")].reverse().map((char) => parseInt(char))
}