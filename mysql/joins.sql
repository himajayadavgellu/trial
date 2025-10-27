JOINS: INNER, OUTER, RIGHT, LEFT, SELF, CROSS.

CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);
INSERT INTO Departments VALUES
(10, 'CSE'),
(20, 'ECE'),
(30, 'MECH'),
(40, 'IT'),
(50, 'CIVIL');

create table Stu(
stu_id int primary key,
stu_name varchar(50),
dept_id int,
foreign key(dept_id) references departments(dept_id));

INSERT INTO Stu (stu_id, stu_name, dept_id)
VALUES
    (1, 'Riya', 10),
    (2, 'Arjun', 20),
    (3, 'Sneha', 30),
    (4, 'Karan', NULL),
    (5, 'Meena', 10);
    
select * from stu;
select * from departments;

SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
INNER JOIN Departments d
ON s.dept_id = d.dept_id;

SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
LEFT JOIN Departments d
ON s.dept_id = d.dept_id;

SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
RIGHT JOIN Departments d
ON s.dept_id = d.dept_id;

SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
CROSS JOIN Departments d;

SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
LEFT JOIN Departments d
ON s.dept_id = d.dept_id
UNION 
SELECT s.stu_id, s.stu_name, d.dept_name
FROM Stu s
RIGHT JOIN Departments d
ON s.dept_id = d.dept_id;
