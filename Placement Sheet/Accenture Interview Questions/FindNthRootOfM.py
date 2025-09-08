def findNthRoot(n: int, m: int) -> int:
    start = 1
    end = m
    while start <= end:
        mid = (start + end) // 2
        power = pow(mid, n)
        if power == m:
            return mid
        if power > m:
            end = mid - 1
        else:
            start = mid + 1
    return -1

n = int(input("Enter the value of n: "))
m = int(input("Enter the value of M: "))
print(findNthRoot(n, m))
