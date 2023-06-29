function solution(k, tangerine) {
    tangerine.sort((a,b)=>a-b)
    
    let numofTangerine = [];
    let index = 0;
    tangerine.forEach((val, i)=>{
        if(val !== tangerine[index]){
            numofTangerine.push(i-index)
            index = i
        }
    })
                      
    numofTangerine.push(tangerine.length - index)
 
    let sum = 0;
    
    let answer=0;
    
    numofTangerine.sort((a,b)=>b-a)
    
    for(let i = 0; i < numofTangerine.length;){    
        sum += numofTangerine[i++]
        if(sum >= k){
            answer = i
            break;
        }
    }
    
    return answer;
}