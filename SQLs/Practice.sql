CREATE TABLE Employee (
	id INT PRIMARY KEY NOT NULL auto_increment,
    fname VARCHAR(20),
    lname VARCHAR(20),
    Age INT,
    emailId VARCHAR(30) UNIQUE,
    PhoneNo INT unique,
    City VARCHAR(256)
);

INSERT INTO Employee
(fname, lname, Age, emailId, PhoneNo, City) values
("Aman", "Proto", 32, "aman@gmail.com", 898, "Delhi"),
("Yagya", "Narayan", 44, "yagya@gmail.com", 222, "Palam"),
("Rahul", "BD", 22, "rahul@gmail.com", 444, "Kolkata"),
("Jatin", "Hermit", 32, "jatin@gmail.com", 666, "Raipur"),
("PK", "Pandey", 21, "pk@gmail.com", 555, "Jaipur");

SELECT * FROM Employee;

CREATE TABLE Client (
	id INT PRIMARY KEY NOT NULL,
    first_name VARCHAR(256),
    last_name VARCHAR(256),
    age INT,
    emailId VARCHAR(256) UNIQUE, 
    PhoneNo INT UNIQUE,
    City VARCHAR(50),
    empId INT,
    FOREIGN KEY (empId)
		REFERENCES Employee(id)
        ON DELETE CASCADE
);

INSERT INTO Client
(id, first_name, last_name, age, emailId, PhoneNo, City, empId)
VALUES
(1, "Mac", "Rogers", 47, "mac@gmail.com", 333, "Kolkata", 3),
(2, "Max", "Poirer", 27, "max@gmail.com", 222, "Kolkata", 3),
(3, "Peter", "Jain", 24, "peter@gmail.com", 111, "Delhi", 1),
(4, "Sushant", "Aggarwal", 23, "sushant@gmail.com", 45454, "Hyderabad", 5),
(5, "Pratap", "Singh", 36, "pratap@gmail.com", 77767, "Mumbai", 2);

SELECT * FROM Client;

CREATE TABLE Project (
	id INT PRIMARY KEY NOT NULL auto_increment,
    empId INT,
    name VARCHAR(2),
    startdate DATE,
    clientId INT NOT NULL,
    FOREIGN KEY (empId)
		REFERENCES Employee(id)
        ON DELETE CASCADE,
	
    FOREIGN KEY (clientId)
		REFERENCES Client(id)
        ON DELETE CASCADE
);

INSERT INTO Project
(empId, name, startdate, clientId)
VALUES
(1, "A", "2021-04-21", 3),
(2, "B", "2021-03-12", 1),
(3, "C", "2021-01-16", 5),
(3, "D", "2021-04-27", 2),
(5, "E", "2021-05-01", 4);

SELECT * FROM Project;

SELECT * FROM Project;
SELECT * FROM Employee;
SELECT * FROM Client;

-- INNER JOIN
SELECT e.fname, e.lname, p.id, p.name FROM Employee as e
INNER JOIN Project as p
ON e.id = p.empId;

-- Fetch out all the employee ID's, and their contact details who have been working from Jaipur with the clients name working in Hydrabad.

SELECT e.id, e.emailId, e.PhoneNo, e.City, c.first_name, c.last_name, c.City FROM Employee as e
INNER JOIN Client as c
ON e.id = c.empId
WHERE e.City = 'Jaipur' AND c.City = 'Hyderabad';

-- LEFT JOIN
-- Fetch out each project allocated to each employee
SELECT * FROM Employee as e
LEFT JOIN Project as p
ON e.id = p.empId;

-- RIGHT JOIN
-- Fetch out all the projects along with the employee's name and their respective allocated email id
SELECT e.fname, e.lname, e.emailId, p.* FROM Employee as e
RIGHT JOIN Project as p
ON e.id = p.empId;


-- SET
CREATE TABLE Dept1 (
	id INT PRIMARY KEY,
    name VARCHAR(20),
    role VARCHAR(256)
);

INSERT INTO Dept1
(id, name, role) values
(1, 'A', 'engineer'),
(2, 'B', 'salesman'),
(3, 'C', 'manager'),
(4, 'D', 'salesman'),
(5, 'E', 'engineer');

SELECT * FROM Dept1;

CREATE TABLE Dept2 (
	id INT PRIMARY KEY,
    name VARCHAR(20),
    role VARCHAR(256)
);

INSERT INTO Dept2
(id, name, role) values
(3, 'C', 'manager'),
(6, 'F', 'marketing'),
(7, 'G', 'salesman');

SELECT * FROM Dept2;

-- List out all the employees in the company
SELECT * FROM Dept1
UNION
SELECT * FROM Dept2;

-- List out all the employees in all departments who work as salesman
SELECT * FROM Dept1 WHERE role = 'salesman'
UNION
SELECT * FROM Dept2 WHERE role = 'salesman';

-- List out all employees who work for both department
SELECT * FROM Dept1
INNER JOIN Dept2
using(id);

-- List out all the employees working in department1 but not in department2
SELECT Dept1.* FROM Dept1
LEFT JOIN Dept2 using(id)
WHERE Dept2.id = null;