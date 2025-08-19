import math

def lcmSum(n: int):
    if n == 0:
        return n
    
    sum: int = 0

    for i in range(1, n+1):
        sum += lcm(i, n)

    return math.ceil(sum)
    
def gcd(u: int, v: int):
    if(u == 0):
        return v
    return gcd(v % u, u)

def lcm(u: int, v: int):
    return (u // gcd(u, v)) * v

num = (int)(input("Enter the number: "))

print(lcmSum(num))