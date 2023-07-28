function solution(babbling) {
    let answer = 0;
    
    ["aya","ye","woo","ma"].forEach((word)=>{
        babbling = babbling.map((babble)=>{
            return babble.replace(word, ' ')
        })
    })
    
    babbling.forEach((i)=>{
        if(i.replace(/ /g, '') == '')
            answer++
    })
    
    return answer
}