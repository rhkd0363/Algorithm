function solution(s){
    return [...s.toUpperCase()].reduce((acc, curr) => acc + (curr === 'P' ? 1 : curr === 'Y'? -1 : 0) , 0) === 0 ? true : false;
}