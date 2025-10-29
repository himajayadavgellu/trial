create database normalizationdb;
use normalizationdb;
create table studentdata (
    studentid int,
    studentname varchar(50),
    course varchar(50),
    instructor varchar(50)
);
insert into studentdata values
(1, 'alice', 'dbms', 'prof. rao'),
(2, 'bob', 'oop', 'prof. singh'),
(3, 'alice', 'oop', 'prof. singh');
select* from studentdata;
create table student1nf (
    studentid int,
    studentname varchar(50),
    course varchar(50),
    instructor varchar(50)
);
insert into student1nf values
(1, 'alice', 'dbms', 'prof. rao'),
(1, 'alice', 'oop', 'prof. singh'),
(2, 'bob', 'oop', 'prof. singh');
select* from student1nf;
create table students2nf (
    studentid int primary key,
    studentname varchar(50)
);
create table enrollment2nf (
    studentid int,
    courseid int,
    foreign key (studentid) references students2nf(studentid),
    foreign key (courseid) references courses2nf(courseid)
);
insert into students2nf values
(1, 'alice'),
(2, 'bob');
select* from students2nf;
insert into courses2nf values
(1, 'dbms'),
(2, 'oop');
select * from courses2nf;
insert into enrollment2nf values
(1, 1),
(1, 2),
(2, 2);
select * from enrollment2nf;
create table departments3nf (
    deptid int primary key,
    deptname varchar(50)
);
create table students3nf (
    studentid int primary key,
    studentname varchar(50),
    deptid int,
    foreign key (deptid) references departments3nf(deptid)
);
insert into departments3nf values
(1, 'cse'),
(2, 'ece');
select * from departments3nf;
insert into students3nf values
(1, 'alice', 1),
(2, 'bob', 2);
select* from students3nf;
create table coursesbcnf (
    courseid int primary key,
    coursename varchar(50)
);
create table instructorsbcnf (
    instructorid int primary key,
    instructorname varchar(50),
    courseid int,
    foreign key (courseid) references coursesbcnf(courseid)
);
insert into coursesbcnf values
(1, 'dbms'),
(2, 'oop');
select * from courses2nf;
insert into instructorsbcnf values
(1, 'prof. rao', 1),
(2, 'prof. singh', 2),
(3, 'prof. sharma', 1);
select * from  instructorsbcnf;

