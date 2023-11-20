CREATE DATABASE IF NOT EXISTS DatamotionMall;

USE DatamotionMall;

CREATE TABLE Categories (
                            CategoryID		INT	auto_increment,
                            CategoryName	varchar(50),

                            CONSTRAINT pk_Categories PRIMARY KEY(CategoryID)
);

CREATE TABLE Products (
                          ProductID	INT	auto_increment,
                          CategoryID	INT,
                          ModelNumber	nvarchar(10),
                          ModelName	nvarchar(120),
                          ProductImage	nvarchar(30),
                          UnitCost	decimal(15),
                          Description	text,

                          CONSTRAINT pk_Products PRIMARY KEY(ProductID),
                          CONSTRAINT fk_Products_Categories FOREIGN KEY(CategoryID) REFERENCES Categories(CategoryID)
);

CREATE TABLE Customers (
                           CustomerID	int auto_increment,
                           Name	varchar(10),
                           EmailAddress varchar(100)	UNIQUE,
                           Password	varchar(12),

                           CONSTRAINT pk_Customer PRIMARY KEY(CustomerID)
);

CREATE TABLE Reviews (
                         ReviewID	int auto_increment,
                         ProductID	int,
                         CustomerID	int,
                         Rating		int,
                         Comments	text,

                         CONSTRAINT pk_ReviewID PRIMARY KEY(ReviewID),
                         CONSTRAINT fk_Review_Products FOREIGN KEY(ProductID) REFERENCES Products(ProductID),
                         CONSTRAINT fk_Review_Customer FOREIGN KEY(CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Orders (
                        OrderID		int auto_increment,
                        CustomerID	int,
                        OrderDate	Datetime,
                        ShipDate	Datetime,

                        CONSTRAINT pk_Orders PRIMARY KEY(OrderID),
                        CONSTRAINT fk_Orders_CustomerID FOREIGN KEY(CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE OrderDetails (
                              OrderID		int,
                              ProductID	int,
                              Quantity	int,
                              UnitCost	decimal(15),

                              CONSTRAINT pk_OrderDetails PRIMARY KEY(OrderID, ProductID),
                              CONSTRAINT fk_OrderDetails_Orders FOREIGN KEY(OrderID) REFERENCES Orders(OrderID),
                              CONSTRAINT fk_OrderDetails_Products FOREIGN KEY(ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE ShoppingCart (
                              RecordID	int	auto_increment,
                              CartID		nvarchar(150),
                              Quantity	int,
                              ProductID	int,
                              DateCreateed	Datetime DEFAULT NOW(),

                              CONSTRAINT pk_RecordID PRIMARY KEY(RecordID),
                              CONSTRAINT fk_cart_ProductID FOREIGN KEY(ProductID) REFERENCES Products(ProductID)
);



#1: 식품, 2: 의류, 3: 생필품, 4: 차량용품, 5: 주방용품
INSERT INTO Categories (CategoryName) VALUES ('식품'), ('의류'), ('차량용품'), ('주방용품'), ('주류');

INSERT INTO Products (CategoryID, ModelNumber, ModelName, ProductImage, UnitCost, Description) VALUES
                                                                                                   (1, '식품모델번호1', '식품모델이름', '식품사진', 1000, '식품설명1'),
                                                                                                   (1, '식품모델번호2', '식품모델이름', '식품사진', 2000, '식품설명2'),
                                                                                                   (1, '식품모델번호3', '식품모델이름', '식품사진', 3000, '식품설명3'),
                                                                                                   (1, '식품모델번호4', '식품모델이름', '식품사진', 450, '식품설명4'),
                                                                                                   (1, '식품모델번호5', '식품모델이름', '식품사진', 300, '식품설명5'),
                                                                                                   (1, '식품모델번호6', '식품모델이름', '식품사진', 700, '식품설명6'),
                                                                                                   (1, '식품모델번호7', '식품모델이름', '식품사진', 100, '식품설명7'),
                                                                                                   (1, '식품모델번호8', '식품모델이름', '식품사진', 210, '식품설명8'),
                                                                                                   (1, '식품모델번호9', '식품모델이름', '식품사진', 350, '식품설명9'),
                                                                                                   (1, '식품모델번호10', '식품모델이름', '식품사진', 610, '식품설명10'),
                                                                                                   (1, '식품모델번호11', '식품모델이름', '식품사진', 110, '식품설명11'),
                                                                                                   (1, '식품모델번호12', '식품모델이름', '식품사진', 1260, '식품설명12'),
                                                                                                   (1, '식품모델번호13', '식품모델이름', '식품사진', 1230, '식품설명13'),
                                                                                                   (1, '식품모델번호14', '식품모델이름', '식품사진', 270, '식품설명14'),
                                                                                                   (1, '식품모델번호15', '식품모델이름', '식품사진', 800, '식품설명15'),
                                                                                                   (1, '식품모델번호16', '식품모델이름', '식품사진', 1290, '식품설명16'),
                                                                                                   (1, '식품모델번호17', '식품모델이름', '식품사진', 6200, '식품설명17'),
                                                                                                   (1, '식품모델번호18', '식품모델이름', '식품사진', 12490, '식품설명18'),
                                                                                                   (1, '식품모델번호19', '식품모델이름', '식품사진', 1620, '식품설명19'),
                                                                                                   (1, '식품모델번호20', '식품모델이름', '식품사진', 7190, '식품설명20'),
                                                                                                   (1, '식품모델번호21', '식품모델이름', '식품사진', 13250, '식품설명21'),
                                                                                                   (1, '식품모델번호22', '식품모델이름', '식품사진', 360, '식품설명22'),
                                                                                                   (1, '식품모델번호23', '식품모델이름', '식품사진', 700, '식품설명23'),
                                                                                                   (1, '식품모델번호24', '식품모델이름', '식품사진', 820, '식품설명24'),
                                                                                                   (1, '식품모델번호25', '식품모델이름', '식품사진', 1250, '식품설명25'),
                                                                                                   (1, '식품모델번호26', '식품모델이름', '식품사진', 6820, '식품설명26'),
                                                                                                   (1, '식품모델번호27', '식품모델이름', '식품사진', 3690, '식품설명27'),
                                                                                                   (1, '식품모델번호28', '식품모델이름', '식품사진', 100, '식품설명28'),
                                                                                                   (1, '식품모델번호29', '식품모델이름', '식품사진', 5020, '식품설명29'),
                                                                                                   (1, '식품모델번호30', '식품모델이름', '식품사진', 100, '식품설명30'),
                                                                                                   (1, '식품모델번호31', '식품모델이름', '식품사진', 12690, '식품설명31'),
                                                                                                   (1, '식품모델번호32', '식품모델이름', '식품사진', 1000000000000, '식품설명32'),
                                                                                                   (1, '식품모델번호33', '식품모델이름', '식품사진', 9000000000000, '식품설명33'),
                                                                                                   (1, '식품모델번호34', '식품모델이름', '식품사진', 8999999999990, '식품설명34'),
                                                                                                   (1, '식품모델번호35', '식품모델이름', '식품사진', 19290, '식품설명35'),
                                                                                                   (1, '식품모델번호36', '식품모델이름', '식품사진', 1920, '식품설명36'),
                                                                                                   (1, '식품모델번호37', '식품모델이름', '식품사진', 100000, '식품설명37'),
                                                                                                   (1, '식품모델번호38', '식품모델이름', '식품사진', 10020, '식품설명38'),
                                                                                                   (1, '식품모델번호39', '식품모델이름', '식품사진', 10350, '식품설명39'),
                                                                                                   (1, '식품모델번호40', '식품모델이름', '식품사진', 2500, '식품설명40'),
                                                                                                   (1, '식품모델번호41', '식품모델이름', '식품사진', 347000, '식품설명41'),
                                                                                                   (1, '식품모델번호42', '식품모델이름', '식품사진', 1250, '식품설명42'),
                                                                                                   (1, '식품모델번호43', '식품모델이름', '식품사진', 2500, '식품설명43'),
                                                                                                   (1, '식품모델번호44', '식품모델이름', '식품사진', 4600, '식품설명44'),
                                                                                                   (1, '식품모델번호45', '식품모델이름', '식품사진', 370, '식품설명45'),
                                                                                                   (1, '식품모델번호46', '식품모델이름', '식품사진', 12520, '식품설명46'),
                                                                                                   (1, '식품모델번호47', '식품모델이름', '식품사진', 16260, '식품설명47'),
                                                                                                   (1, '식품모델번호48', '식품모델이름', '식품사진', 13580, '식품설명48'),
                                                                                                   (1, '식품모델번호49', '식품모델이름', '식품사진', 11250, '식품설명49'),
                                                                                                   (1, '식품모델번호50', '식품모델이름', '식품사진', 1460, '식품설명50'),
                                                                                                   (1, '식품모델번호51', '식품모델이름', '식품사진', 1460, '식품설명51'),
                                                                                                   (1, '식품모델번호52', '식품모델이름', '식품사진', 1460, '식품설명52'),
                                                                                                   (1, '식품모델번호53', '식품모델이름', '식품사진', 1460, '식품설명53'),
                                                                                                   (1, '식품모델번호54', '식품모델이름', '식품사진', 1460, '식품설명54'),
                                                                                                   (1, '식품모델번호55', '식품모델이름', '식품사진', 3290, '식품설명55'),
                                                                                                   (1, '식품모델번호56', '식품모델이름', '식품사진', 520, '식품설명56'),
                                                                                                   (1, '식품모델번호57', '식품모델이름', '식품사진', 1460, '식품설명57'),
                                                                                                   (1, '식품모델번호58', '식품모델이름', '식품사진', 1800, '식품설명58'),
                                                                                                   (1, '식품모델번호59', '식품모델이름', '식품사진', 1460, '식품설명59'),
                                                                                                   (1, '식품모델번호60', '식품모델이름', '식품사진', 1460, '식품설명50'),
                                                                                                   (2, '의류모델번호1', '의류모델이름', '의류사진', 12600, '의류설명1'),
                                                                                                   (2, '의류모델번호2', '의류모델이름', '의류사진', 25000, '의류설명2'),
                                                                                                   (2, '의류모델번호3', '의류모델이름', '의류사진', 23000, '의류설명3'),
                                                                                                   (2, '의류모델번호4', '의류모델이름', '의류사진', 43700, '의류설명4'),
                                                                                                   (2, '의류모델번호5', '의류모델이름', '의류사진', 124990, '의류설명5'),
                                                                                                   (2, '의류모델번호6', '의류모델이름', '의류사진', 362350, '의류설명6'),
                                                                                                   (2, '의류모델번호7', '의류모델이름', '의류사진', 125880, '의류설명7'),
                                                                                                   (2, '의류모델번호8', '의류모델이름', '의류사진', 100000, '의류설명8'),
                                                                                                   (2, '의류모델번호9', '의류모델이름', '의류사진', 23000, '의류설명9'),
                                                                                                   (2, '의류모델번호10', '의류모델이름', '의류사진', 125990, '의류설명10'),
                                                                                                   (3, '생필품모델번호1', '생필품모델이름', '생필품사진', 10590, '생필품설명1'),
                                                                                                   (3, '생필품모델번호2', '생필품모델이름', '생필품사진', 6230, '생필품설명2'),
                                                                                                   (3, '생필품모델번호3', '생필품모델이름', '생필품사진', 2300, '생필품설명3'),
                                                                                                   (3, '생필품모델번호4', '생필품모델이름', '생필품사진', 12560, '생필품설명4'),
                                                                                                   (3, '생필품모델번호5', '생필품모델이름', '생필품사진', 7360, '생필품설명5'),
                                                                                                   (3, '생필품모델번호6', '생필품모델이름', '생필품사진', 360, '생필품설명6'),
                                                                                                   (3, '생필품모델번호7', '생필품모델이름', '생필품사진', 1200, '생필품설명7'),
                                                                                                   (3, '생필품모델번호8', '생필품모델이름', '생필품사진', 2360, '생필품설명8'),
                                                                                                   (3, '생필품모델번호9', '생필품모델이름', '생필품사진', 3700, '생필품설명9'),
                                                                                                   (3, '생필품모델번호10', '생필품모델이름', '생필품사진', 23000, '생필품설명10'),
                                                                                                   (4, '차량용품모델번호1', '차량용품모델이름', '차량용품사진', 26000, '차량용품설명1'),
                                                                                                   (4, '차량용품모델번호2', '차량용품모델이름', '차량용품사진', 3700, '차량용품설명2'),
                                                                                                   (4, '차량용품모델번호3', '차량용품모델이름', '차량용품사진', 12500, '차량용품설명3'),
                                                                                                   (4, '차량용품모델번호4', '차량용품모델이름', '차량용품사진', 73460, '차량용품설명4'),
                                                                                                   (4, '차량용품모델번호5', '차량용품모델이름', '차량용품사진', 2000, '차량용품설명5'),
                                                                                                   (4, '차량용품모델번호6', '차량용품모델이름', '차량용품사진', 62000, '차량용품설명6'),
                                                                                                   (4, '차량용품모델번호7', '차량용품모델이름', '차량용품사진', 1250, '차량용품설명7'),
                                                                                                   (4, '차량용품모델번호8', '차량용품모델이름', '차량용품사진', 42000, '차량용품설명8'),
                                                                                                   (4, '차량용품모델번호9', '차량용품모델이름', '차량용품사진', 12500, '차량용품설명9'),
                                                                                                   (4, '차량용품모델번호10', '차량용품모델이름', '차량용품사진', 4730, '차량용품설명10'),
                                                                                                   (5, '주방용품모델번호1', '주방용품모델이름', '주방용품사진', 13350, '주방용품설명1'),
                                                                                                   (5, '주방용품모델번호2', '주방용품모델이름', '주방용품사진', 6200, '주방용품설명2'),
                                                                                                   (5, '주방용품모델번호3', '주방용품모델이름', '주방용품사진', 2600, '주방용품설명3'),
                                                                                                   (5, '주방용품모델번호4', '주방용품모델이름', '주방용품사진', 1250, '주방용품설명4'),
                                                                                                   (5, '주방용품모델번호5', '주방용품모델이름', '주방용품사진', 730, '주방용품설명5'),
                                                                                                   (5, '주방용품모델번호6', '주방용품모델이름', '주방용품사진', 3600, '주방용품설명6'),
                                                                                                   (5, '주방용품모델번호7', '주방용품모델이름', '주방용품사진', 60000, '주방용품설명7'),
                                                                                                   (5, '주방용품모델번호8', '주방용품모델이름', '주방용품사진', 62000, '주방용품설명8'),
                                                                                                   (5, '주방용품모델번호9', '주방용품모델이름', '주방용품사진', 62250, '주방용품설명9'),
                                                                                                   (5, '주방용품모델번호10', '주방용품모델이름', '주방용품사진', 2360, '주방용품설명10');

# Customer 테이블에 데이터 삽입
INSERT INTO Customers (Name, EmailAddress, Password) VALUES
('Customer1', 'email1.nhnacademy.com', 'password1'),
('Customer2', 'email2.nhnacademy.com', 'password2'),
('Customer3', 'email3.nhnacademy.com', 'password3'),
('Customer4', 'email4.nhnacademy.com', 'password4'),
('Customer5', 'email5.nhnacademy.com', 'password5'),
('Customer6', 'email6.nhnacademy.com', 'password6'),
('Customer7', 'email7.nhnacademy.com', 'password7'),
('Customer8', 'email8.nhnacademy.com', 'password8'),
('Customer9', 'email9.nhnacademy.com', 'password9'),
('Customer10', 'email10.nhnacademy.com', 'password10'),
('Customer11', 'email11.nhnacademy.com', 'password11'),
('Customer12', 'email12.nhnacademy.com', 'password12'),
('Customer13', 'email13.nhnacademy.com', 'password13'),
('Customer14', 'email14.nhnacademy.com', 'password14'),
('Customer15', 'email15.nhnacademy.com', 'password15'),
('Customer16', 'email16.nhnacademy.com', 'password16'),
('Customer17', 'email17.nhnacademy.com', 'password17'),
('Customer18', 'email18.nhnacademy.com', 'password18'),
('Customer19', 'email19.nhnacademy.com', 'password19'),
('Customer20', 'email20.nhnacademy.com', 'password20'),
('Customer21', 'email21.nhnacademy.com', 'password21'),
('Customer22', 'email22.nhnacademy.com', 'password22'),
('Customer23', 'email23.nhnacademy.com', 'password23'),
('Customer24', 'email24.nhnacademy.com', 'password24'),
('Customer25', 'email25.nhnacademy.com', 'password25'),
('Customer26', 'email26.nhnacademy.com', 'password26'),
('Customer27', 'email27.nhnacademy.com', 'password27'),
('Customer28', 'email28.nhnacademy.com', 'password28'),
('Customer29', 'email29.nhnacademy.com', 'password29'),
('Customer30', 'email30.nhnacademy.com', 'password30'),
('Customer31', 'email31.nhnacademy.com', 'password31'),
('Customer32', 'email32.nhnacademy.com', 'password32'),
('Customer33', 'email33.nhnacademy.com', 'password33'),
('Customer34', 'email34.nhnacademy.com', 'password34'),
('Customer35', 'email35.nhnacademy.com', 'password35'),
('Customer36', 'email36.nhnacademy.com', 'password36'),
('Customer37', 'email37.nhnacademy.com', 'password37'),
('Customer38', 'email38.nhnacademy.com', 'password38'),
('Customer39', 'email39.nhnacademy.com', 'password39'),
('Customer40', 'email40.nhnacademy.com', 'password40'),
('Customer41', 'email41.nhnacademy.com', 'password41'),
('Customer42', 'email42.nhnacademy.com', 'password42'),
('Customer43', 'email43.nhnacademy.com', 'password43'),
('Customer44', 'email44.nhnacademy.com', 'password44'),
('Customer45', 'email45.nhnacademy.com', 'password45'),
('Customer46', 'email46.nhnacademy.com', 'password46'),
('Customer47', 'email47.nhnacademy.com', 'password47'),
('Customer48', 'email48.nhnacademy.com', 'password48'),
('Customer49', 'email49.nhnacademy.com', 'password49'),
('Customer50', 'email50.nhnacademy.com', 'password50');

SELECT * FROM Categories;
SELECT * FROM Products;
SELECT * FROM Customers;