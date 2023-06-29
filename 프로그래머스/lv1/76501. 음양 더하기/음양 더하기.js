function solution(absolutes, signs) {
    return absolutes.reduce((acc,curr,idx) => acc += signs[idx] ? curr : -curr, 0)
}