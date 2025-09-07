class User:
    def __init__(self, name, mobile_number, address=""):
        if address == "":
            self.C1(name, mobile_number)
        else:
            self.C2(name, mobile_number, address)

    def C1(self, name, mobile_number):
        self.name = name
        self.mobile_number = mobile_number

    def C2(self, name, mobile_number, address):
        self.name = name
        self.mobile_number = mobile_number
        self.address = address

obj = User("Samiran", 7211009990)
print(obj)
