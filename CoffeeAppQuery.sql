use HALO

create table tbCoffee(
ID_Coffee int IDENTITY (6251,1) primary key,
Name varchar(200) not null ,
Coffee_Type varchar (200) ,
Price bigint ,
Expired date NULL 
);

select * from tbCoffee

create table tbCustomer(
ID_Customer int IDENTITY (1,1) primary key,
Phone_Number varchar(120) not null,
Customer_Name varchar(200) not null ,
Date_Of_Entry date NULL
);

create table tbTransaction(
ID_Transaction int IDENTITY (123456,1) primary key,
ID_Customer varchar(200) not null,
Customer_Name varchar(200) not null,
Coffee_Name varchar(120) not null,
Coffee_Price int not null,
Qty int,
Total_Price int,
Date_Of_Purchase date null
);

select * from tbCustomer



create table Transaction(
