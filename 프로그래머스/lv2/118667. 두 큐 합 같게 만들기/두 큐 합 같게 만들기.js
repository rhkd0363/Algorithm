function solution(queue1, queue2) {
    let sum_1 = queue1.reduce((acc,curr)=>acc+curr,0)
    let sum_2 = queue2.reduce((acc,curr)=>acc+curr,0)
    let total_sum = sum_1 + sum_2
    
    if(sum_1 === sum_2)
        return 0
    
    if(total_sum % 2 === 1)
        return -1
    
    let answer = 0
    
    let size = queue1.length * 3
    
    let queue = queue1
    queue1 = [...queue1,...queue2]
    queue2 = [...queue2,...queue]
    let idx1 = 0;
    let idx2 = 0;
    
    while(answer < size){
        if(sum_1 == sum_2)
            break
        
        if( sum_1 > sum_2 ){
            sum_2 += queue1[idx1]
            sum_1 -= queue1[idx1++]
        }else{
            sum_1 += queue2[idx2]
            sum_2 -= queue2[idx2++]
        }
        answer++;
    }
    
    return answer === size ? -1 : answer
    
}