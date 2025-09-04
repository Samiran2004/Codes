# Inheritance

class User:
    def __init__(self, name, id, age, passCode):
        self.name = name
        self.id = id
        self.age = age
        self.passCode = passCode

    def login(self):
        print("P Logged in.")
    def _logout(self):
        print("P Logged out.")

class Student(User):
    def __init__(self, marks, rollnumber, name, id, age, passCode):
        self.marks = marks
        self.rollnumber = rollnumber
        super().__init__(name=name, id=id, age=age, passCode=passCode)

    def login(self):
        print("OTP Send...")
        super().login()

    def play(self):
        print("Playing.")
        self._logout()

s1 = Student(90, 123, "Samiran", 1, 21, 0000)
s1.login()
s1.play()
print(s1.name)
