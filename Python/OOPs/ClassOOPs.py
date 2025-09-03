class Student:
    numberOfStudents = 0
    __schoolName = "DHHS"
    def __init__(self, name, roll_number, percentage):
        self.name = name
        self.roll_number = roll_number
        self.__percentage = percentage
        Student.numberOfStudents += 1

    def say_hello(self):
        print(f"Hello {self.name}, How are you!")

    def study(self):
        print("I'm studying...")
        self.play()

    def play(self):
        print("Study well, Now going to play!")

    # Getter...
    def getMarks(self):
        return self.__percentage

    # Setter...
    def setMarks(self, newMarks):
        self.__percentage = newMarks

    @staticmethod
    def getSchoolName():
        return Student.__schoolName

    def setNewScholName(self, newSchoolName, passCode):
        if passCode == self.__auth():
            Student.__schoolName = newSchoolName
        else:
            print("Error...")

    def __auth(self):
        return "0000"


student1 = Student("Samiran", 42, 63.43)

# student1.say_hello()
# print(student1.roll_number)
# print(student1.percentage)
# student1.study()

# print(id(student1))

student2 = Student("Goku", 20, 50)

# student2.say_hello()
# print(student2.roll_number)
# print(student2.percentage)
# student2.play()
#
# print(student2.numberOfStudents)


"""
    Encapsulation
"""
print(student1.getMarks())
student1.setMarks(33.6)
print(student1.getMarks())

print(student1.getSchoolName())
student1.setNewScholName("KTPP", "0000")
print(student1.getSchoolName())