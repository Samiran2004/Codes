def intersectionOfTwoSortedArray(arr1, arr2):
    resultArr = []
    map = {}

    # Check if either array is empty...
    if(len(arr1) == 0 or len(arr2) == 0):
        return resultArr
    
    # Count the frequency of elements in arr2...
    for element in arr2:
        map[element] = map.get(element, 0)+1
    
    print(map)

    # Find intersection elements...
    for element in arr1:
        print(element)
        if(map.get(element, 0) > 0):
            resultArr.append(element)
            map[element] = map[element] - 1
    
    return resultArr

arr1 = []
arr2 = []

size1 = (int)(input("Enter the size of the 1st array: "))

for i in range(0, size1):
    data = (int)(input("Enter the data: "))
    arr1.append(data)

size2 = (int)(input("Enter the size of the 2nd array: "))

for i in range(0, size2):
    data = (int)(input("Enter the data: "))
    arr2.append(data)

print("Array1: ", arr1)
print("Array2: ", arr2)

result = intersectionOfTwoSortedArray(arr1=arr1, arr2=arr2)
print("Result: ", result)