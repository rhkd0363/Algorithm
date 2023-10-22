function solution(s) {
    let answer = [0,0];
    
    while(s !== "1"){
        let count = 0;
        
        s.split("").forEach((num) =>{
            if(num == 0)
                count++;
        })
        
        answer[0]++;
        answer[1] += count;
        s = (s.length - count).toString(2);
    }
    
    return answer;
}