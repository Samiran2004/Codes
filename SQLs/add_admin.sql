create table admin_users(
id int primary key auto_increment not null unique,
name varchar(100),
email varchar(100),
gender enum('Male', 'Female', 'Others'),
date_of_birth date,
salary int
);

insert into admin_users(name, email, gender, date_of_birth, salary)
values
('Samiran Samanta', 'samiran@gmail.com', 'Male', '2004-06-30', 60000),
('Aarav Sharma', 'aarav.sharma@example.com', 'Male', '1995-11-12', 75000),
('Priya Patel', 'priya.patel@example.com', 'Female', '1998-03-25', 82000),
('Rohan Gupta', 'rohan.g@example.com', 'Male', '1992-08-05', 90000),
('Sneha Desai', 'sneha.desai@example.com', 'Female', '1990-12-18', 105000),
('Vikram Singh', 'vikram.singh@example.com', 'Male', '1988-04-10', 110000),
('Ananya Reddy', 'ananya.reddy@example.com', 'Female', '1999-07-22', 68000),
('Kabir Das', 'kabir.das@example.com', 'Male', '1996-01-30', 78000),
('Meera Joshi', 'meera.joshi@example.com', 'Female', '1994-09-14', 85000),
('Arjun Nair', 'arjun.nair@example.com', 'Male', '1991-05-20', 95000),
('Neha Verma', 'neha.verma@example.com', 'Female', '1989-10-08', 115000);

select * from admin_users;