T_input = int(input())

for N in range(1,T_input+1):
    N_input = int(input())
    result = ''
    for K in range(N_input):
        Alpha = list(map(str, input().split()))
        result = result + (Alpha[0] * int(Alpha[1]))
    
    print(f'#{N}')
    for C in range(0,len(result)):
        if (C+1)%10 == 0:
            print(result[C])
        elif C == (len(result)-1):
            print(result[C])
        else:
            print(result[C],end='')