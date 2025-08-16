def interestingPattern(num):
    if num == 0 or num > 26:
        print("Invalid input...")
        return
    
    resultArr = []
    for i in range(1, num + 1):
        tempArr = []
        startPos = num - i
        for j in range(i):
            currChar = chr(ord('A') + startPos + j)
            tempArr.append(currChar)
        
        resultArr.append(tempArr)

    return resultArr

num = (int)(input("Enter the number: "))

result = interestingPattern(num=num)

print(result)