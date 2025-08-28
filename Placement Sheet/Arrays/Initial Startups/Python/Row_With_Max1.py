def rowAndMaximumOnes(mat):
    index = 1
    max = 0
    for i in range(0, len(mat)):
        val = 0
        for j in range(0, len(mat[i])):
            if mat[i][j] == 1:
                val += 1

        if val > max:
            index = i
            max = val

    return [index, max]

mat = [[0, 0], [1, 1], [0, 0]]
result = rowAndMaximumOnes(mat=mat)
print(result)
