a = int(input())
b = c = 0
while a != 0:
    a, b = divmod(a,10)
    c += b
        
print(c)