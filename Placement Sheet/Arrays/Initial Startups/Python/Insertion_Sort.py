def insertionSort(arr):
    if(len(arr) == 0):
        return
    
    for i in range(1, len(arr)):
        temp = arr[i]

        j = i - 1

        while(j >= 0 and arr[j] > temp):
            arr[j + 1] = arr[j]
            j -= 1
        
        arr[j + 1] = temp

arr = []
size = (int)(input("Enter the size of the array: "))

for i in range(0, size):
    data = (int)(input("Enter the data: "))
    arr.append(data)

print(arr)

insertionSort(arr=arr)
print(arr)