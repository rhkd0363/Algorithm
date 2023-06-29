function solution(n)
{
    let answer = (n+"").split("").reduce((acc,curr,idx) => acc + parseInt(curr), 0)

    return answer;
}