function solution(x) {
    let sum = 0;
    let num = x;
    
    while(x > 0){
        sum += x % 10;
        x = parseInt(x/10);
    }
    
    return num % sum === 0 ? true : false;
}