create database studentdb;
use studentdb;

create table studenttab(
id int primary KEY AUTO_INCREMENT,
stuname varchar(20),
stucourses varchar(30),
stufee int
)

select * from studenttab;
