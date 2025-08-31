import sys

def find_second_larget_elm(arr):
    if arr is None and len(arr) == 0:
        return -1
    # arr.sort()
    # # print(arr)
    # return arr[len(arr) - 2]

    # Better Approach...
    if arr is None or len(arr) < 2:
        print("Error...")
    else:
        largestElm = -sys.maxsize - 1
        scLargestElm = -sys.maxsize - 1
        for i in range(0, len(arr)):
            if arr[i] > largestElm:
                scLargestElm = largestElm
                largestElm = arr[i]
            elif arr[i] > scLargestElm and arr[i] != largestElm:
                scLargestElm = arr[i]

        if scLargestElm == -sys.maxsize - 1:
            return -1

    return scLargestElm

arr = [1, 2, 3, 35, 34]
print(arr)
print(find_second_larget_elm(arr=arr))
