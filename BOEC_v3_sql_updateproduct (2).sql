-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: oebcv2
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accountcustomer`
--

DROP TABLE IF EXISTS `accountcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accountcustomer` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountcustomer`
--

LOCK TABLES `accountcustomer` WRITE;
/*!40000 ALTER TABLE `accountcustomer` DISABLE KEYS */;
INSERT INTO `accountcustomer` VALUES (1,'hailongluu','1');
/*!40000 ALTER TABLE `accountcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accountemployee`
--

DROP TABLE IF EXISTS `accountemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accountemployee` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `EmployeeID` int(10) NOT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKAccountEmp989522` (`EmployeeID`),
  CONSTRAINT `FKAccountEmp989522` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountemployee`
--

LOCK TABLES `accountemployee` WRITE;
/*!40000 ALTER TABLE `accountemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `accountemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresscustomer`
--

DROP TABLE IF EXISTS `addresscustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addresscustomer` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `City` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresscustomer`
--

LOCK TABLES `addresscustomer` WRITE;
/*!40000 ALTER TABLE `addresscustomer` DISABLE KEYS */;
INSERT INTO `addresscustomer` VALUES (1,'Hanoi','Hoang Mai','Dinh Cong');
/*!40000 ALTER TABLE `addresscustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addressemployee`
--

DROP TABLE IF EXISTS `addressemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addressemployee` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `EmployeeID` int(10) NOT NULL,
  `City` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKAddressEmp387242` (`EmployeeID`),
  CONSTRAINT `FKAddressEmp387242` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addressemployee`
--

LOCK TABLES `addressemployee` WRITE;
/*!40000 ALTER TABLE `addressemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `addressemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ShipperEmployeeID` int(10) NOT NULL,
  `Shipper` int(10) DEFAULT NULL,
  `ShippingMethood` varchar(255) DEFAULT NULL,
  `IdOrder` int(10) DEFAULT NULL,
  `Paymentmethod` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKBill139624` (`ShipperEmployeeID`),
  CONSTRAINT `FKBill139624` FOREIGN KEY (`ShipperEmployeeID`) REFERENCES `shipper` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `Author` varchar(255) DEFAULT NULL,
  `ProductIdproduct` varchar(255) NOT NULL,
  `Category` varchar(45) DEFAULT NULL,
  `NumOfPage` int(10) DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  KEY `publisher id_idx` (`publisherId`),
  CONSTRAINT `FKBook682578` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`),
  CONSTRAINT `publisher id` FOREIGN KEY (`publisherId`) REFERENCES `publisher` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('Michael Bungay Stanier','B0001','Bussiness',285,NULL),('Hilary Davidson','B0002','Psychological',450,NULL),('Suzy Krause','B0003','Humor',211,NULL),('Natasha Scripture','B0004','Travel',234,NULL),('Paulo Coelho','B0005','Lifeskill',123,NULL),('Camille Eide','B0006','Novel',233,NULL),('Collins','B0007','EngLearning',333,NULL),('Richie Hahn','B0008','EngLearning',212,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `OrderID` int(10) DEFAULT NULL,
  `TotalPrice` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_product`
--

DROP TABLE IF EXISTS `cart_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart_product` (
  `CartID` int(10) NOT NULL,
  `ProductId` varchar(255) NOT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCart_Produ251192` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_product`
--

LOCK TABLES `cart_product` WRITE;
/*!40000 ALTER TABLE `cart_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chip`
--

DROP TABLE IF EXISTS `chip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chip` (
  `Frequency` varchar(255) DEFAULT NULL,
  `ProductId` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`),
  CONSTRAINT `FKChip551105` FOREIGN KEY (`ProductId`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chip`
--

LOCK TABLES `chip` WRITE;
/*!40000 ALTER TABLE `chip` DISABLE KEYS */;
/*!40000 ALTER TABLE `chip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothes`
--

DROP TABLE IF EXISTS `clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clothes` (
  `Category` int(10) DEFAULT NULL,
  `ProductIdproduct` varchar(255) NOT NULL,
  `Size` int(10) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKClothes859659` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothes`
--

LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;
INSERT INTO `clothes` VALUES (NULL,'E0001',NULL,NULL),(NULL,'E0002',NULL,NULL),(NULL,'E0003',NULL,NULL),(NULL,'E0004',NULL,NULL),(NULL,'E0005',NULL,NULL),(NULL,'E0006',NULL,NULL),(NULL,'E0007',NULL,NULL),(NULL,'E0008',NULL,NULL);
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothescategory`
--

DROP TABLE IF EXISTS `clothescategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clothescategory` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothescategory`
--

LOCK TABLES `clothescategory` WRITE;
/*!40000 ALTER TABLE `clothescategory` DISABLE KEYS */;
INSERT INTO `clothescategory` VALUES (1);
/*!40000 ALTER TABLE `clothescategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Account` int(10) DEFAULT NULL,
  `Name` int(10) DEFAULT NULL,
  `Address` int(10) DEFAULT NULL,
  `Idnumber` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `cus - add_idx` (`Address`),
  KEY `cus - acc_idx` (`Account`),
  KEY `cus - name_idx` (`Name`),
  CONSTRAINT `cus - acc` FOREIGN KEY (`Account`) REFERENCES `accountcustomer` (`ID`),
  CONSTRAINT `cus - add` FOREIGN KEY (`Address`) REFERENCES `addresscustomer` (`ID`),
  CONSTRAINT `cus - name` FOREIGN KEY (`Name`) REFERENCES `fullnamecustomer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,1,1,1,'123456','1234567','hailongluu@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desktop`
--

DROP TABLE IF EXISTS `desktop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `desktop` (
  `ProductIdproduct` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKDesktop397778` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desktop`
--

LOCK TABLES `desktop` WRITE;
/*!40000 ALTER TABLE `desktop` DISABLE KEYS */;
/*!40000 ALTER TABLE `desktop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disk`
--

DROP TABLE IF EXISTS `disk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `disk` (
  `Kind` varchar(255) DEFAULT NULL,
  `Capacity` varchar(255) DEFAULT NULL,
  `ProductId` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`),
  CONSTRAINT `FKDisk520048` FOREIGN KEY (`ProductId`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disk`
--

LOCK TABLES `disk` WRITE;
/*!40000 ALTER TABLE `disk` DISABLE KEYS */;
/*!40000 ALTER TABLE `disk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electronics`
--

DROP TABLE IF EXISTS `electronics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `electronics` (
  `Chip` varchar(255) DEFAULT NULL,
  `Ram` varchar(255) DEFAULT NULL,
  `Disk` varchar(255) DEFAULT NULL,
  `Screen` varchar(255) DEFAULT NULL,
  `ProductIdproduct` varchar(255) NOT NULL,
  `Specification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKElectronic506975` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electronics`
--

LOCK TABLES `electronics` WRITE;
/*!40000 ALTER TABLE `electronics` DISABLE KEYS */;
INSERT INTO `electronics` VALUES (NULL,NULL,NULL,NULL,'C0001',NULL),(NULL,NULL,NULL,NULL,'C0002',NULL),(NULL,NULL,NULL,NULL,'C0003',NULL),(NULL,NULL,NULL,NULL,'C0004',NULL),(NULL,NULL,NULL,NULL,'C0005',NULL),(NULL,NULL,NULL,NULL,'C0006',NULL),(NULL,NULL,NULL,NULL,'C0007',NULL),(NULL,NULL,NULL,NULL,'C0008',NULL);
/*!40000 ALTER TABLE `electronics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Account` int(10) DEFAULT NULL,
  `Name` int(10) DEFAULT NULL,
  `Address` int(10) DEFAULT NULL,
  `Idnumber` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fullnamecustomer`
--

DROP TABLE IF EXISTS `fullnamecustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fullnamecustomer` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(255) DEFAULT NULL,
  `Middlename` varchar(255) DEFAULT NULL,
  `Lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fullnamecustomer`
--

LOCK TABLES `fullnamecustomer` WRITE;
/*!40000 ALTER TABLE `fullnamecustomer` DISABLE KEYS */;
INSERT INTO `fullnamecustomer` VALUES (1,'Luu','Hai','Long');
/*!40000 ALTER TABLE `fullnamecustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fullnameemployee`
--

DROP TABLE IF EXISTS `fullnameemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fullnameemployee` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `EmployeeID` int(10) NOT NULL,
  `Firstname` varchar(255) DEFAULT NULL,
  `Middlename` varchar(255) DEFAULT NULL,
  `Lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFullNameEm983866` (`EmployeeID`),
  CONSTRAINT `FKFullNameEm983866` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fullnameemployee`
--

LOCK TABLES `fullnameemployee` WRITE;
/*!40000 ALTER TABLE `fullnameemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `fullnameemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hat`
--

DROP TABLE IF EXISTS `hat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hat` (
  `ProductIdproduct` varchar(255) NOT NULL,
  `HatSpecification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKHat678466` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hat`
--

LOCK TABLES `hat` WRITE;
/*!40000 ALTER TABLE `hat` DISABLE KEYS */;
/*!40000 ALTER TABLE `hat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `laptop` (
  `ProductIdproduct` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKLaptop485463` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manager` (
  `EmployeeID` int(10) NOT NULL,
  `Position` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  CONSTRAINT `FKManager562231` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `SellerEmployeeID` int(10) NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `BillID` int(10) NOT NULL,
  `Cart` int(10) DEFAULT NULL,
  `IdCustomer` int(10) NOT NULL,
  `DateCreated` date DEFAULT NULL,
  `OrderStatus` varchar(255) DEFAULT NULL,
  `ShippingStatus` varchar(255) DEFAULT NULL,
  `ShippingAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKOrder556711` (`CustomerID`),
  KEY `FKOrder468296` (`SellerEmployeeID`),
  CONSTRAINT `FKOrder468296` FOREIGN KEY (`SellerEmployeeID`) REFERENCES `seller` (`EmployeeID`),
  CONSTRAINT `FKOrder556711` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pant`
--

DROP TABLE IF EXISTS `pant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pant` (
  `ProductIdproduct` varchar(255) NOT NULL,
  `ParnSpecification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKPant86177` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pant`
--

LOCK TABLES `pant` WRITE;
/*!40000 ALTER TABLE `pant` DISABLE KEYS */;
/*!40000 ALTER TABLE `pant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `Id` varchar(255) NOT NULL,
  `Brand` varchar(255) DEFAULT NULL,
  `Price` bigint(20) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `ImageLink` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('B0001','',160000,100,'img/book/book1.jpg','The Coaching Habit'),('B0002',NULL,230000,100,'img/book/book2.jpg','One Small Sacrifice'),('B0003',NULL,10000,100,'img/book/book3.jpg','Valencia and Valentine'),('B0004',NULL,223000,100,'img/book/book4.jpg','Man Fast: A Memoir'),('B0005',NULL,120000,100,'img/book/book5.jpg','The Alchemist'),('B0006',NULL,234000,100,'img/book/book6.jpg','Like a Love Song'),('B0007',NULL,115000,100,'img/book/book7.jpg','Collins Easy Learning English Conversation'),('B0008',NULL,120000,100,'img/book/book8.jpg','TOEFL IBT - Writing A1'),('C0001',NULL,64990000,100,'img/elec/elec1.jpg','MacBook Pro 15 Touch Bar 2018 Core i7/512GB'),('C0002',NULL,47990000,100,'img/elec/elec2.jpg','MacBook Pro 13 Touch Bar 2018 Core i7/512GB'),('C0003',NULL,56000000,100,'img/elec/elec3.jpg','MacBook Pro 15 Touch Bar 2018 Core i7/256GB'),('C0004',NULL,27990000,100,'img/elec/elec4.jpg','Apple Macbook Air 2018 Core i5/ 8GB/ 128GB'),('C0005',NULL,32490000,100,'img/elec/elec5.jpg','Apple Macbook Air 2018 Core i5/ 8GB/ 256GB'),('C0006',NULL,27990000,100,'img/elec/elec6.jpg','iPhone XS Max 64GB'),('C0007',NULL,7250000,100,'img/elec/elec7.jpg','iPad WiFi 32GB New 2018'),('C0008',NULL,11990000,100,'img/elec/elec8.jpg','Samsung Galaxy S9 Plus'),('E0001',NULL,1250000,100,'img/clother/clo1.jpg','Clarks Men\'s Tilden Walk Oxford'),('E0002',NULL,340000,100,'img/clother/clo2.jpg','Essentials Men\'s Regular-Fit Quick-Dry Golf Polo Shirt'),('E0003',NULL,250000,100,'img/clother/clo3.jpg','Dockers Men\'s Classic Fit Perfect Short D3'),('E0004',NULL,250000,100,'img/clother/clo4.jpg','Essentials Men\'s Classic-Fit Cargo Short'),('E0005',NULL,900000,100,'img/clother/clo5.jpg','Hanes Men\'s ComfortFlex Waistband Boxer Brief'),('E0006',NULL,600000,100,'img/clother/clo6.jpg','Men\'s Midweight Sleeve Logo Hooded Sweatshirt'),('E0007',NULL,650000,100,'img/clother/clo7.jpg','Mens Slim Fit Long Sleeve Lightweight Zip-up Hoodie with Kanga Pocket'),('E0008',NULL,750000,100,'img/clother/clo8.jpg','London Fog Men\'s Auburn Zip-Front Golf Jacket');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `publisher` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'Kindle','USA','091111');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ram`
--

DROP TABLE IF EXISTS `ram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ram` (
  `Bus` varchar(255) DEFAULT NULL,
  `ProductId` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`),
  CONSTRAINT `FKRAM569521` FOREIGN KEY (`ProductId`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ram`
--

LOCK TABLES `ram` WRITE;
/*!40000 ALTER TABLE `ram` DISABLE KEYS */;
/*!40000 ALTER TABLE `ram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen`
--

DROP TABLE IF EXISTS `screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `screen` (
  `Resolution` varchar(255) DEFAULT NULL,
  `Rgb` varchar(255) DEFAULT NULL,
  `ProductId` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`),
  CONSTRAINT `FKScreen496643` FOREIGN KEY (`ProductId`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen`
--

LOCK TABLES `screen` WRITE;
/*!40000 ALTER TABLE `screen` DISABLE KEYS */;
/*!40000 ALTER TABLE `screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seller` (
  `EmployeeID` int(10) NOT NULL,
  `Position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  CONSTRAINT `FKSeller468206` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shipper` (
  `EmployeeID` int(10) NOT NULL,
  `Transportation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  CONSTRAINT `FKShipper111377` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shirt`
--

DROP TABLE IF EXISTS `shirt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shirt` (
  `ProductIdproduct` varchar(255) NOT NULL,
  `ShirtSpecification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKShirt510297` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shirt`
--

LOCK TABLES `shirt` WRITE;
/*!40000 ALTER TABLE `shirt` DISABLE KEYS */;
/*!40000 ALTER TABLE `shirt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoes` (
  `ProductIdproduct` varchar(255) NOT NULL,
  `ShoesSpecificationn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKShoes504935` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes`
--

LOCK TABLES `shoes` WRITE;
/*!40000 ALTER TABLE `shoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smartphone`
--

DROP TABLE IF EXISTS `smartphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `smartphone` (
  `ProductIdproduct` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductIdproduct`),
  CONSTRAINT `FKSmartPhone971020` FOREIGN KEY (`ProductIdproduct`) REFERENCES `product` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smartphone`
--

LOCK TABLES `smartphone` WRITE;
/*!40000 ALTER TABLE `smartphone` DISABLE KEYS */;
/*!40000 ALTER TABLE `smartphone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-15 16:26:25
