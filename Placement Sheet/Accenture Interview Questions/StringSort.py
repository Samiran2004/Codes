def sortString(str: str):
    if len(str) == 0:
        return ""
    
    sortedStr = ''.join(sorted(str))
    return sortedStr

str = (str)(input("Enter the string: "))

print(f"Unsorted string: {str}")

print(f"Sorted string: {sortString(str=str)}")