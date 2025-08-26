"""
Problem statement
You have been given an integer array/list 'ARR' of size 'N'.
Write a solution to check if it could become non-decreasing by modifying at most 1 element.

We define an array as non-decreasing, if ARR[i] <= ARR[i + 1] holds for every i (0-based) such that (0 <= i <= N - 2).
"""

"""
Sample Input 1 :
2
3
8 4 6
3
8 4 2
Sample Output 1 :
true
false
Explanation to Sample Input 1 :
For Test Case 1 we can have a possible non-decreasing array : 2 4 6
Where only the element at index 0 has been modified.

For Test Case 2 there is no possible way to make the array non-decreasing by modifying at most 1 element.
Sample Input 2 :
2
6
-2 7 -1 0 1 2
5
-10 10 0 10 3
Sample Output 2 :
true
false
Explanation to Sample Input 2 :
For Test Case 1 we can have a possible non-decreasing array : -2 -2 -1 0 1 2
Where only the element at index 1 has been modified

For Test Case 2 there is no possible way to make the array non-decreasing by modifying at most 1 element.

"""
"""
Link: https://www.naukri.com/code360/problems/non-decreasing-array_699920
"""
def isPossible(arr):
    if arr is None or len(arr) == 0:
        return False

    changed = False

    for i in range(0, len(arr) - 1):
        if arr[i] <= arr[i + 1]:
            continue
        if changed:
            return False
        if (i == 0 or arr[i+1] >= arr[i - 1]):
            arr[i] = arr[i + 1]
        else:
            arr[i + 1] = arr[i]
        changed = True
    return True

size = int(input("Enter the size of the array: "))
arr = []
for i in range(0, size):
    data = int(input("Enter the data: "))
    arr.append(data)

print(isPossible(arr=arr))




















