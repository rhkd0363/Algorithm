function solution(s){
    let count = 0;
    [...s.toUpperCase()].forEach((char) => count += char === 'P' ? 1 : char === 'Y' ? -1 : 0)
    return count === 0 ? true : false;
}