class Car:
    total_car = 0
    def __init__(self, userbrand, usermodel):
        self.__brand = userbrand
        self.__model = usermodel
        Car.total_car += 1

    def get_brand(self):
        return self.__brand + " !"
    
    def set_brand(self, new_brand_name):
        self.__brand = new_brand_name

    def full_name(self):
        return f"{self.__brand} {self.__model}"
    
    def fuel_type(self):
        return "Petrol or Diesel."
    
    # Static method...
    @staticmethod
    def general_description():
        return "Cars are meand of transport."
    
    # Make read only model
    @property
    def model(self):
        return self.__model
    

class ElectricCar(Car):
    def __init__(self, brand, model, battery_size):
        super().__init__(brand, model)
        self.battery_size = battery_size
    
    def fuel_type(self):
        return "Electric charge."



# my_tesla = ElectricCar("Tesla", "Model S", "85kWH")
# print(my_tesla.model)
# print(my_tesla.__brand)
# print(my_tesla.full_name())
# print(my_tesla.get_brand())
# print(my_tesla.fuel_type())

# safari = Car("Tata", "Safari")
# print(safari.fuel_type())

# print(Car.total_car)

# my_car = Car("Toyota", "Corolla")
# print(my_car.brand)
# print(my_car.model)
# print(my_car.full_name())

# my_new_car = Car("Tata", "Safari")
# print(my_new_car.brand)
# print(my_new_car.model)
# print(my_new_car.full_name())

# my_car = Car("Tata", "Safari")
# # print(my_car.general_description())
# print(Car.general_description())

# print(isinstance(my_car, Car))
# print(isinstance(my_car, ElectricCar))

class Battery:
    def battery_info(self):
        return "This is battery."

class Engine:
    def engine_info(self):
        return "This is engine."

class ElectricCarV2(Battery, Engine, Car):
    pass

my_tesla_v2 = ElectricCarV2("Tesla", "Model v2")

print(my_tesla_v2.engine_info())
print(my_tesla_v2.battery_info())