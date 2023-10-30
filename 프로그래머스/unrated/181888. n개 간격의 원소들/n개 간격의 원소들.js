function solution(num_list, n) {
    const answer = num_list.filter((num,index)=>{
        return index % n == 0;
    })
    return answer;
}