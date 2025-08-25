# Question 1: Class for complex numbers...
"""
Create a Python class named "ComplexNumber" tp represent complex numbers

Theory:
    A complex number is a number that comprises a real part and an imaginary part
    It is typically written in the form a + bi, where 'a' is the real part,
    and 'b' is the imaginary part, and 'i' is the imaginary unit.

Operations:
1. Addition (+)
2. Substraction (-)
3. Multiplication (*)
4. Division (/)
5. Comparison (==, !==)
"""

class ComplexNumber:
    def __init__(self, real=0.0, img=0.0):
        self.real = real
        self.img = img

    def __str__(self):
        if self.real == 0:
            return f"{self.img}i"
        elif self.img < 0:
            s = f"{self.real} {self.img}i"
            return s
        else:
            return f"{self.real} + {self.img}i"

    def __add__(self, arg2):
        resultReal = 0
        resultImg = 0

        resultReal = self.real + arg2.real
        resultImg = self.img + arg2.img

        ans = ComplexNumber(resultReal, resultImg)

        return ans

    def conjugate(self):
        self.img = self.img*-1
        if self.real == 0:
            return f"{self.img}i"
        elif self.img < 0:
            s = f"{self.real} {self.img}i"
            return s
        else:
            return f"{self.real} + {self.img}i"

cn1 = ComplexNumber(3, 4)
cn2 = ComplexNumber(4, 5)

# print(cn1.real)
# print(cn1.img)
# print(cn1)
# cn1.conjugate()

print(cn1 + cn2)