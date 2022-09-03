count = int(input())
num =list(map(int, input().split()))

num.sort()
mid_num = (count//2)
print(num[mid_num])