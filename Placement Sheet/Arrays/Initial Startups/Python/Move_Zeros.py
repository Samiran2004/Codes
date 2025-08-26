# moveZerosBruteForce

def moveZerosBruteForce(arr):
    if arr is None or len(arr) == 0:
        return
    non_zero_arr = []
    zero_arr = []

    for i in arr:
        if i != 0:
            non_zero_arr.append(i)
        if i == 0:
            zero_arr.append(i)

    non_zero_arr.extend(zero_arr)

    return non_zero_arr

# Optimal...
def moveZeros(arr):
    if arr is None or len(arr) == 0:
        return

    index = 0
    for i in range(0, len(arr)):
        if arr[i] != 0:
            arr[index] = arr[i]
            index += 1

    while index < len(arr):
        arr[index] = 0
        index += 1

size = int(input("Enter the size of the array: "))
arr = []

for i in range(0, size):
    data = int(input("Enter the element: "))
    arr.append(data)

print("Original Array: ", arr)

# arr = moveZerosBruteForce(arr)
moveZeros(arr)

print("Modified Array: ", arr)
