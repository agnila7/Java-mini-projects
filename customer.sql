create database customerdB;
use customerdB;

create table customerlist(
id int primary key auto_increment,
customername varchar(20),
products varchar(30),
price int
)

select * from customerlist;