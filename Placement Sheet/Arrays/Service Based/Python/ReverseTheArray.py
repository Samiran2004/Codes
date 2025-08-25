def reverseTheArray(arr, m):
    if arr is None or len(arr) == 0 or len(arr) <= m:
        return

    start = m + 1
    end = len(arr) - 1

    while start <= end:
        temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        start += 1
        end -= 1

size = int(input("Enter the size of the array: "))
arr = []

for i in range(size):
    data = int(input("Enter the data: "))
    arr.append(data)

ps = int(input("Enter the position: "))

print("..........Original Array..........")
print(arr)

print("..........Reversed Array..........")
reverseTheArray(arr, ps)
print(arr)