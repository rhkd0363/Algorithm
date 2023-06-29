function solution(n) {
    let binaryN = n.toString(2).match(/1/g).length
    
    while(true){
        if(binaryN === (++n).toString(2).match(/1/g).length){
            return n;
        }
    }
}
