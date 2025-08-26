def rotate(nums: list, k: int):
    if nums is None or len(nums) == 0:
        return
    rotatedArr = [0] * len(nums)
    for i in range(0, len(nums)):
        rotatedArr[(i + k) % len(nums)] = nums[i]

    for i in range(0, len(nums)):
        nums[i] = rotatedArr[i]

size = int(input("Enter the size of the array: "))
arr = []
for i in range(0, size):
    data = int(input("Enter data: "))
    arr.append(data)
k = int(input("Enter the value of K: "))
print("Original Array: ", arr)
rotate(arr, k=k)
print("Rotated Array: ", arr)
