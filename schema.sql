create database company;

use company;

drop table if exists department;

create table department (
id int not null auto_increment,
name varchar(30),
head_of_department varchar(30),
primary key (id)
);

drop table if exists employee;

create table employee (
id int not null auto_increment,
first_name varchar(20),
last_name varchar(20),
joining_date date,
salary int,
city varchar(20),
phone_number varchar(20),
department_id int,
primary key (id),
foreign key (department_id) references department (id)
);

