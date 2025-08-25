class Student:
    def __init__(self, name, roll_number, percentage):
        self.name = name
        self.roll_number = roll_number
        self.percentage = percentage

    def say_hello(self):
        print(f"Hello {self.name}, How are you!")

    def study(self):
        print("I'm studying...")
        self.play()

    def play(self):
        print("Study well, Now going to play!")


student1 = Student("Samiran", 42, 63.43)

student1.say_hello()
print(student1.roll_number)
print(student1.percentage)
student1.study()

# print(id(student1))

student2 = Student("Goku", 20, 50)

student2.say_hello()
print(student2.roll_number)
print(student2.percentage)
student2.play()