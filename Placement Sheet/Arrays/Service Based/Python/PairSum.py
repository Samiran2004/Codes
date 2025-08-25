def pair_sum(arr, s):
    if arr is None or len(arr) == 0:
        return []

    result_arr = []

    for i in range(0, len(arr) - 1):
        for j in range(i + 1, len(arr)):
            if arr[i] + arr[j] == s:
                result_arr.append([arr[i], arr[j]])

    for pair in result_arr:
        pair.sort()

    result_arr.sort(key=lambda x: (x[0], x[1]))
    return result_arr

arr = []
size = int(input("Enter the size of the array: "))

for i in range(size):
    data = int(input("Enter data: "))
    arr.append(data)

key = int(input("Enter the key: "))

result = pair_sum(arr, key)

print(result)