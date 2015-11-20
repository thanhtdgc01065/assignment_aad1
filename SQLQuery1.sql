USE master
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name='AssignmentAAD1')
DROP DATABASE AssignmentAAD1
GO

CREATE DATABASE AssignmentAAD1
GO

USE AssignmentAAD1
GO

CREATE TABLE [Order]
(
OrderID INT PRIMARY KEY,
CusName NVARCHAR(50),
CusAdd NVARCHAR(100),
CusTel VARCHAR(10),
CusEmail VARCHAR(50)
)
GO

CREATE TABLE [Product]
(
ProductID INT PRIMARY KEY,
ProductName NVARCHAR(50),
ProductPrice MONEY,
IsDeleted BIT
)
GO

CREATE TABLE [OrderDetail]
(
OrderID INT,
--CONSTRAINT FK_Order_OrderDetail FOREIGN KEY (OrderID) REFERENCES [Order](OrderID),
ProductID INT,
--CONSTRAINT FK_Product_OrderDetail FOREIGN KEY (ProductID) REFERENCES [Product](ProductID),
Quantity INT
--Total MONEY
)
GO

--SELECT * FROM [Product] WHERE ProductName LIKE '%toshiba%'

INSERT INTO [Product](ProductID,ProductName,ProductPrice,IsDeleted) VALUES
(1,N'Laptop DELL Inspiron 3558 P47F001-TI34500',500,0),
(2,N'Laptop ASUS E502MA-XX0004D',800,0),
(3,N'Laptop Lenovo ThinkPad T440p-20AWA16JVN',900,0),
(4,N'Laptop Apple Macbook Air 2015 MJVE2ZP-A 128GB SSD',1000,0),
(5,N'Laptop Lenovo G4080 80E400QFVN',1100,0),
(6,N'Laptop DELL Inspiron 3558-C5I33103',1200,0),
(7,N'Laptop Lenovo ThinkPad T440s-20ARA1E2VN',1300,0),
(8,N'Laptop Asus G750JZ-T4181D',1400,0),
(9,N'Laptop Lenovo ThinkPad X1 Carbon 2-20A8A00XVN',1500,0),
(10,N'Laptop Dell Inspiron-17-7737-MNWWF3-Touch',1600,0)
GO

INSERT INTO [Order](OrderID,CusName,CusAdd,CusTel,CusEmail) VALUES
(1000,N'Barack Obama',N'New York, USA','0963214568','barackobama@gmail.com'),
(1001,N'Hilary Clinton',N'Indiana, USA','0362147651','hilaryclinton@gmail.com'),
(1002,N'David Cameron',N'London, UK','0912632147','davidcameron@gmail.com'),
(1003,N'Gray Tech',N'Atlanta, USA','0921112930','jamesgordon@gmail.com'),
(1004,N'Lary Page',N'Massachusetts, USA','0923654741','larypage@gmail.com')

INSERT INTO [OrderDetail](OrderID,ProductID,Quantity) VALUES
(1000,8,2),
(1000,4,1),
(1001,1,1),
(1002,4,1),
(1003,3,1),
(1004,6,1)

SELECT * FROM [Product] WHERE IsDeleted=0
SELECT * FROM [Order]
SELECT * FROM [OrderDetail]

--GET ALL ORDER INFO
SELECT [OrderDetail].OrderID,[Order].CusName,[Order].CusTel,[Order].CusEmail,[Product].ProductName,[Product].ProductPrice,[OrderDetail].Quantity,[Product].ProductPrice*[OrderDetail].Quantity AS Total
FROM [Product] INNER JOIN [OrderDetail] ON [Product].ProductID=[OrderDetail].ProductID
INNER JOIN [Order] ON [OrderDetail].OrderID=[Order].OrderID
--GROUP BY [OrderDetail].OrderID,[Order].CusName
ORDER BY [OrderDetail].OrderID

--GET ALL ORDER ITEM
SELECT [Product].ProductName,[Product].ProductPrice,[OrderDetail].Quantity,[Product].ProductPrice*[OrderDetail].Quantity AS Total
FROM [Product] INNER JOIN [OrderDetail] ON [Product].ProductID=[OrderDetail].ProductID
INNER JOIN [Order] ON [OrderDetail].OrderID=[Order].OrderID
WHERE [OrderDetail].OrderID=1000 AND [Product].IsDeleted=0
ORDER BY [Product].ProductName

UPDATE [Product] SET ProductName='',ProductPrice='' WHERE ProductID=1

UPDATE [Product] SET IsDeleted=1 WHERE ProductID=2

DELETE FROM [Product] WHERE ProductID=1

UPDATE [OrderDetail] SET Quantity=2 WHERE OrderID=1000 AND ProductID=4

--MAKE A NEW ORDER
INSERT INTO [Order](OrderID,CusName,CusAdd,CusTel,CusEmail) VALUES
(1005,N'Thanh Tran',N'Ha Noi, VN','0998887777','thanhtran@gmail.com')
INSERT INTO [OrderDetail](OrderID,ProductID,Quantity) VALUES
(1005,10,1)

--UPDATE ORDER TABLE
UPDATE [Order] SET CusName='',CusAdd='',CusTel='',CusEmail='' WHERE OrderID=1000