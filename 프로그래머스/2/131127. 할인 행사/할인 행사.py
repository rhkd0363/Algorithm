def solution(want, number, discount):
    dict = {}
    answer = 0
    total_count = 0
    for i in range(0, len(want)):
        dict[want[i]] = number[i]
        total_count += number[i]
    
    left = 0
    count = 0
    check = 0
    for item in discount:
        if count == total_count :
            count-=1
            if discount[left] in dict:
                if dict[discount[left]] >= 0:
                    check -= 1
                dict[discount[left]] += 1
            left+=1
        
        if item in dict:
            if dict[item] > 0:
                check +=1
            dict[item] -= 1
        count+=1
        if check == total_count:
            answer +=1
    return answer