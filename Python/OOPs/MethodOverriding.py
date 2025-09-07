class Animal:
    def __init__(self):
        pass
    def sound(self):
        return "Animal Sounds..."

class Dog(Animal):
    def __init__(self):
        pass

    def sound(self):
        return "Dog's Bark..."

obj = Animal()
print(obj.sound())

obj = Dog()
print(obj.sound())
