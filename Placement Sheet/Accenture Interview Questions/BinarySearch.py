def search(arr, target)-> int:
    if(len(arr) == 0):
        return -1
    
    arr.sort()

    start = 0
    end = len(arr) - 1

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == target:
            return mid
        
        if target > arr[mid]:
            start = mid + 1
        
        if target <= arr[mid]:
            end = mid - 1
    
    return -1

size = (int)(input("Enter the size of the array: "))
arr = []

for i in range(size):
    data = (int)(input("Enter the data: "))
    arr.append(data)

target = (int)(input("Enter the target element: "))

result = search(arr=arr, target=target)
print(result)