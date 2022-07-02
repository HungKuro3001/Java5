create database TestPV
go
USE TestPV
go

create table Customers(
	CustomersID int primary key,
	CustomerName nvarchar(255),
	Sex BIT,
	Country nvarchar(255)
);

insert into Customers values (1,N'Hùng',1,N'Việt Nam')
insert into Customers values (2,N'Sỹ',0,N'Trung Quốc')
insert into Customers values (3,N'Sỹ',0,N'Trung Quốc')
insert into Customers values (4,N'Sỹ',0,N'Trung Quốc')
insert into Customers values (5,N'Sỹ',0,N'Trung Quốc')
insert into Customers values (6,N'Sỹ',0,N'Trung Quốc')
insert into Customers values (7,N'Sỹ',0,N'Trung Quốc')

Select Country,count(sex)  from Customers where sex = 0 group by Country having count(sex)>5


