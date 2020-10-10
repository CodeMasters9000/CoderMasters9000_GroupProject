USE master;
GO
IF DB_ID (N'RestaurantApp_90') IS NOT NULL
DROP DATABASE RestaurantApp_90;
GO
CREATE DATABASE RestaurantApp_90;
GO
USE RestaurantApp_90;

CREATE TABLE restaurant
(restaurantID VARCHAR(3) NOT NULL,
name VARCHAR(50) NOT NULL,
tables VARCHAR(50) NOT NULL);

CREATE TABLE server
(serverID VARCHAR(3) NOT NULL,
 serverName VARCHAR(25) NOT NULL,
 assignedTables VARCHAR(25), /* String seperated by commas, for exampl '002, 001, 003, 004' */
 phoneNumber VARCHAR(10),
 isHost BIT,
 password VARCHAR(256), /*plaintext for now*/
 PRIMARY KEY (serverid));

CREATE TABLE menuItems
(itemID VARCHAR(2) NOT NULL,
name VARCHAR(50) NOT NULL,
cost FLOAT(10) NOT NULL
PRIMARY KEY(itemID));

CREATE TABLE reservation
( reservationID VARCHAR(3) NOT NULL,
  noOfPeople VARCHAR(3) NOT NULL,
  email VARCHAR(25) NOT NULL,
  name VARCHAR(25) NOT NULL,
  PRIMARY KEY(reservationID)
   );

CREATE TABLE bill
(billID VARCHAR(6) NOT NULL,
reservationID VARCHAR(3) NOT NULL,
serverID VARCHAR(3) NOT NULL,
itemsOrdered VARCHAR(50), /* String seperated by commas, for exampl '002, 001, 003, 004' */
itemsComped VARCHAR(25), /* String seperated by commas, for exampl '002, 001, 003, 004' */
subTotal FLOAT(10),
tip FLOAT(10),
Total AS subTotal + tip,
isPaid BIT,
seatTime DATETIME,
leaveTime DATETIME,
PRIMARY KEY(billID),
FOREIGN KEY(reservationID) REFERENCES reservation(reservationID),
FOREIGN KEY(serverID) REFERENCES server(serverID));

CREATE TABLE tables
( tableID VARCHAR(3) NOT NULL,
   reservationID VARCHAR(3),
   serverID VARCHAR(3),
   billID VARCHAR(6),
   seats VARCHAR(2), 
   reservationTime DATETIME,
   availableTime DATETIME, /*Time when table will be open, tables reserved for 90 minutes initially, increased by 10 mins as needed*/
   isAvailable BIT,
 PRIMARY KEY (tableID),
 FOREIGN KEY(reservationID) REFERENCES reservation(reservationID),
 FOREIGN KEY(serverID) REFERENCES server(serverID),
 FOREIGN KEY(billID) REFERENCES bill(billID));

INSERT INTO restaurant
VALUES('000', 'WcWonalds', '10');

INSERT INTO server 
VALUES('000', 'Jacky', NULL, '1234567890', 0, 'Jacky');
INSERT INTO server 
VALUES('001', 'Parham', NULL, '1234567890', 0, 'Parham');
INSERT INTO server 
VALUES('002', 'Reshma', NULL, '1234567890', 0, 'Reshma');
INSERT INTO server 
VALUES('003', 'HOST', NULL, '1234567890', 1, 'HOST');


INSERT INTO tables
VALUES('000', NULL, NULL, NULL, '5', NULL, NULL, 1);
INSERT INTO tables
VALUES('001', NULL, NULL, NULL, '1', NULL, NULL, 1);
INSERT INTO tables
VALUES('002', NULL, NULL, NULL, '2', NULL, NULL, 1);
INSERT INTO tables
VALUES('003', NULL, NULL, NULL, '5', NULL, NULL, 1);
INSERT INTO tables
VALUES('004', NULL, NULL, NULL, '8', NULL, NULL, 1);
INSERT INTO tables
VALUES('005', NULL, NULL, NULL, '2', NULL, NULL, 1);
INSERT INTO tables
VALUES('006', NULL, NULL, NULL, '4', NULL, NULL, 1);
INSERT INTO tables
VALUES('007', NULL, NULL, NULL, '10', NULL, NULL, 1);
INSERT INTO tables
VALUES('008', NULL, NULL, NULL, '3', NULL, NULL, 1);
INSERT INTO tables
VALUES('009', NULL, NULL, NULL, '3', NULL, NULL, 1);


INSERT INTO menuItems
VALUES('00', 'Chicken WcWuffin', '2.99');
INSERT INTO menuItems
VALUES('01', 'WcCoffee', '5.99');
INSERT INTO menuItems
VALUES('02', 'Turkey WcWrap', '4.99');
INSERT INTO menuItems
VALUES('03', 'Grand Wac', '9.99');
INSERT INTO menuItems
VALUES('04', 'Grand Wac Bacon', '10.99');
INSERT INTO menuItems
VALUES('05', 'Double Grand Wac', '11.99');
INSERT INTO menuItems
VALUES('06', 'Fries M', '3.99');
INSERT INTO menuItems
VALUES('07', 'Fries S', '2.99');
INSERT INTO menuItems
VALUES('08', 'Fries L', '4.99');
INSERT INTO menuItems
VALUES('09', 'WcFlurry', '2.99');
INSERT INTO menuItems
VALUES('10', 'WcBLT', '10.99');
