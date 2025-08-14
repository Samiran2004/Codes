def sumOfEvenOdd(num: int):
    if num == 0:
        return [0, 0]
    
    arr = []
    evenArr = []
    oddArr = []

    # inerate every elements...
    tempNum = num
    while tempNum > 0:
        digit = tempNum % 10

        if(digit % 2 == 0):
            evenArr.append(digit)
        else:
            oddArr.append(digit)
        
        tempNum = tempNum // 10
    
    # Calculate sum for even array...
    evenSum = 0
    for i in evenArr:
        evenSum = evenSum + i
    
    # Calculate sum for odd array...
    oddSum = 0
    for i in oddArr:
        oddSum = oddSum + i
    
    arr.append(evenSum)
    arr.append(oddSum)

    return arr
    
num = (int)(input("Enter the number: "))

result = sumOfEvenOdd(num=num)
print(result)