n = int(input())
li = list(map(int, input().split()))
match = list(map(int, input().split()))

for i in range(n - 1, 0, -1):
    if li == match:
        break
    idx = li.index(max(li[:i + 1]))
    if idx != i:
        li[idx], li[i] = li[i], li[idx]

print(1 if li == match else 0)