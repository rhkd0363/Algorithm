def solution(s):
    answer = []
    checked = [-1 for i in range(0,26)]
    
    for idx, c in enumerate(s) :
        num = ord(c) - 97
        answer.append(checked[num] if checked[num] == -1 else idx - checked[num])
        checked[num] = idx
    
    return answer