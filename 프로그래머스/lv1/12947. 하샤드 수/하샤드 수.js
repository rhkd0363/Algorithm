function solution(x) {
    let num = 0;
    let ans = x;
    
    while(x > 0){
        num += x % 10;
        x = parseInt(x/10);
    }
    
    return ans % num === 0 ? true : false;
}