def calculateTotalSalary(basic: int, grade: str):
    if basic == 0:
        return 0
    
    allowance = 0
    if grade == 'A' or grade.upper() == 'A':
        allowance = 1700
    elif grade == 'B' or grade.upper() == 'B':
        allowance = 1500
    else:
        allowance = 1300
    
    hra = round(basic * 0.20)
    da = round(basic * 0.50)
    pf = round(basic * 0.11)

    totalSalary = basic + hra + da + allowance - pf
    return totalSalary

basic = (int)(input("Enter the basic salary: "))
grade = (str)(input("Enter the grade: "))

print(f"Total salary: {calculateTotalSalary(basic=basic, grade=grade)}")