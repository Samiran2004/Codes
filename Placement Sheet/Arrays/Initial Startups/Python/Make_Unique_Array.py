def minIncrementForUnique(arr):
    try:
        arr.sort()
        count = 0
        for i in range(1, len(arr)):
            if arr[i] <= arr[i - 1]:
                count += arr[i - 1] - arr[i] + 1
                arr[i] = arr[i - 1] + 1
        
        return count
    
    except Exception as e:
        print(f"Error: {e}")

size = int(input("Enter the size of the array: "))
arr = []

for i in range(0, size):
    data = int(input("Enter the data: "))
    arr.append(data)

print(minIncrementForUnique(arr=arr))