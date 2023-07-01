function solution(storey) {
    let queue = [{storey : storey, count : 0}]
    let answer = 987654321
    
    while(queue.length > 0){
        let curr = queue.shift()
        let num = curr.storey % 10
        
        if(curr.storey == 0){
            answer = Math.min(answer, curr.count)
            continue;
        }
        
        if(num > 5){
            queue.push({storey: parseInt(curr.storey/10) + 1, count : curr.count + 10 - num})
        }else if (num < 5){
            queue.push({storey: parseInt(curr.storey/10), count : curr.count + num})
        }else{
            queue.push({storey: parseInt(curr.storey/10) + 1, count : curr.count + 10 - num})
            queue.push({storey: parseInt(curr.storey/10), count : curr.count + num})
        }
    }
    
    return answer
}