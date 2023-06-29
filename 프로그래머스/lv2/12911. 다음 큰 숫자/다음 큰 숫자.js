function solution(n) {
    let binaryN = n.toString(2).replaceAll('0','')
    
    while(true){
        if(binaryN === (++n).toString(2).replaceAll('0','')){
            return n;
        }
    }
}
