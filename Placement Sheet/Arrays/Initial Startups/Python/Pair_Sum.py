# Brute-Force
def pairSumBruteForce(arr, target):
    if arr is None or len(arr) == 0:
        return -1

    count = 0
    for i in range(0, len(arr) - 1):
        for j in range(i + 1, len(arr)):
            if arr[i] + arr [j] == target:
                count += 1
    if count == 0:
        return -1
    else:
        return count

# Optimal...
def pairSum(arr, target):
    if arr is None or len(arr) == 0:
        return -1

    map = {}
    count = 0

    for i in range(0, len(arr)):
        complement = target - arr[i]
        if complement in map:
            count += map[complement]
        map[arr[i]] = map.get(arr[i], 0) + 1

    return -1 if count == 0 else count

size = int(input("Enter the size of the array: "))
arr = []
for i in range(0, size):
    data = int(input("Enter the data: "))
    arr.append(data)

target = int(input("Enter the target element: "))

result = pairSumBruteForce(arr=arr, target=target)
