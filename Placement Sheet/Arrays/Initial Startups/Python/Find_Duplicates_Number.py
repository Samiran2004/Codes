from collections import defaultdict

hashmap = defaultdict(int)

def findDuplicatesBruteForce(arr):
    if(len(arr) == 0):
        return
    
    for i in range(0, len(arr)-2):
        currData = arr[i]

        for j in range(i+1, len(arr)-1):
            if(currData == arr[j]):
                return currData
    
    return -1

def findDuplicates(arr):
    if(len(arr) == 0):
        return
    
    for i in range(0, len(arr) - 1):
        data = arr[i]
        hashmap[data] += 1

        if(hashmap[data] > 1):
            return data
    
    return -1
    

arr = []
size = (int)(input("Enter the size of the array: "))

for i in range(0, size):
    data = (int)(input("Enter the data: "))
    arr.append(data)

print(arr)

bruteforce_result = findDuplicatesBruteForce(arr=arr)
print(bruteforce_result)

result = findDuplicates(arr=arr)
print(result)