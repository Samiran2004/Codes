def checkSymmetricMatrixBruteForce(arr):
    try:
        row = len(arr)
        column = len(arr[0])
        newMatrix = [list(row) for row in zip(*arr)]

        for i in range(row):
            for j in range(column):
                if arr[i][j] != newMatrix[i][j]:
                    return False
        return True

    except Exception as e:
        print(f"Error: {e}")

def checkSymmetricMatrix(arr):
    try:
        n = len(arr)
        # Ensure matrix is square
        for row in arr:
            if len(row) != n:
                return False
        # Compare arr[i][j] with arr[j][i]
        for i in range(n):
            for j in range(i + 1, n):
                if arr[i][j] != arr[j][i]:
                    return False
        return True
    except Exception as e:
        print(f"Error: {e}")


arr = [[1, 2, 3],
            [2, 4, 5],
                [3, 5, 8]]
print(checkSymmetricMatrixBruteForce(arr=arr))
print(checkSymmetricMatrix(arr=arr))