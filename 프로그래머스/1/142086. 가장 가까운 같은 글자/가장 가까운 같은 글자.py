def solution(s):
    answer = []
    dict = {}
    
    for i, c in enumerate(s) :
        if c in dict:
            answer.append(i - dict[c])
        else:
            answer.append(-1)
        dict[c] = i
    
    return answer