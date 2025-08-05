def bubbleSort(arr):
    if len(arr) == 0:
        return
    
    for i in range(0, len(arr) - 1):
        for j in range(0, len(arr) - 1):
            if(arr[j] > arr[j+1]):
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp; 

arr = []

size = (int)(input("Enter the size of the array: "))

for i in range(0, size):
    data = (int)(input("Enter the data: "))
    arr.append(data)

print(arr)
bubbleSort(arr)
print(arr)