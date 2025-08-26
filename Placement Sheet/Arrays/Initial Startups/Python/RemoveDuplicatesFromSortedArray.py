def removeDuplicates(arr) -> int:
    count = 1
    for i in range(1, len(arr) - 1):
        if arr[i - 1] != arr[i]:
            arr[count] = arr[i]
            count += 1

    return count

size = int(input("Enter the size of the array: "))
arr = []
print("..........Please Enter Data In Sorted Order..........")
for i in range(0, size):
    data = int(input("Enter the data: "))
    arr.append(data)

print("Original Array: ", arr)
count = int(removeDuplicates(arr=arr))
for i in range(0, count):
    print(arr[i], end=" ")

