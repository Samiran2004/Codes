class User:  # Single Inheritance...
    def __init__(self):
        print("User Constructor called...")
        self.website = "www.flipkart.com" # Public
        self._field = "ecommerce" # Protected...
        self.__duration = "12 months" # Private...
        self.__name = "Flipkart user"

    def login(self):
        print("logged in...")

    def logout(self):
        print("logged out...")

class Buyer(User):
    def __init__(self):
        print("Buyer Constructor called...")
        super().__init__()
        self.name = "Samiran Samanta"
        self.website = "www.amazon.in"
        self.__name = "Buyer"


    def login(self):
        super().logout()
        print("Mentor logged in")
        print(self._field)
        # print(self.__duration)

# b1 = Buyer()
# print(b1.name)
# print(b1.website)
# b1.login()

class Grandfather:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def show_details(self):
        return f"Name: {self.name}, Age: {self.age}"

    def speak(self):
        return "Grandfather speaks..."

class Child1(Grandfather):
    def __init__(self, name, age, hobby):
        super().__init__(name, age)
        self.hobby = hobby

    def showHobby(self):
        return f"Hobby: {self.hobby}"

    def speak(self):
        return f"Child1 Speaks..."

class Child2(Grandfather):
    def __init__(self, name, age, favorite_food):
        super().__init__(name=name, age=age)
        self.favorite_food = favorite_food

    def showFavFood(self):
        return f"Favorite food: {self.favorite_food}"

    def speak(self):
        return "Child2 speaks..."







