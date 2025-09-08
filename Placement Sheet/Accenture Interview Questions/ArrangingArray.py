def arrangingArray(arr: list):
    n = len(arr)
    arr.sort()
    countOnes = arr.count(1)

    if countOnes + 2 == n and arr[n - 1] == 3 and arr[n - 2] == 2:
        return arr
    arr[countOnes:] = reversed(arr[countOnes:])
    return arr

size = int(input("Enter the size of the array: "))
arr = []
for i in range(0, size):
    data = int(input("Enter data: "))
    arr.append(data)

print("Before: ", arr)
arrangingArray(arr)
print("After: ", arr)
