def printStar(num: int):
    if num == 0:
        return
    
    # Upper part...
    for i in range((num // 2) + 1):
        for j in range(num // 2, i ,- 1):
            print(' ', end='')
        for k in range(2 * i + 1):
            print('*', end='')
        print()
    
    # Lower part...
    for i in range((num // 2) - 1, -1, -1):
        for j in range(num // 2, i, -1):
            print(' ', end='')
        for k in range(2 * i + 1):
            print('*', end='')
        print()

num = (int)(input("Enter the number: "))
printStar(num=num)