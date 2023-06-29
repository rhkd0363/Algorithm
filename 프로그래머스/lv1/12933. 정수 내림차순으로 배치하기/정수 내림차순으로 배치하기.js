function solution(n) {
    
    return +(n+'').split('').sort((a,b)=> b-a).reduce((acc,curr)=> acc+(curr+""));
}