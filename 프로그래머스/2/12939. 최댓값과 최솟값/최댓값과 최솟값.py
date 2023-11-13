def solution(s):
    list = s.split()
    list = [int(item) for item in list]
    list.sort()
    return f"{list[0]} {list[-1]}"