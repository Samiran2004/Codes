def getNumberOfBlocks(height):
    if len(height) == 0:
        return 0
    compareArr = height.copy()
    compareArr = sorted(compareArr)
    count = 0

    for i in range(0, len(height)):
        if compareArr[i] != height[i]:
            count = count + 1
    
    return count

arr = []
size = (int)(input("Enter the size of the array: "))

for i in range(size):
    data = (int)(input("Enter the data: "))
    arr.append(data)

result = getNumberOfBlocks(arr)
print(result)