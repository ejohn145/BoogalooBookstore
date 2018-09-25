CREATE DATABASE  IF NOT EXISTS `boogaloo_bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `boogaloo_bookstore`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: boogaloo_bookstore
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `adbadfb_books`
--

DROP TABLE IF EXISTS `adbadfb_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adbadfb_books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN-13` varchar(45) DEFAULT NULL,
  `book_name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `units_on_hand` int(11) DEFAULT NULL,
  `unit_price` decimal(5,2) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adbadfb_books`
--

LOCK TABLES `adbadfb_books` WRITE;
/*!40000 ALTER TABLE `adbadfb_books` DISABLE KEYS */;
INSERT INTO `adbadfb_books` VALUES (1,'978-0-316-12908-4','Leviathan Wakes','James S. A. Corey','Orbit Books','2011-06-15',100,011.55),(2,'978-1-84149-990-1','Caliban\'s War','James S. A. Corey','Orbit Books','2012-06-26',99,011.55),(3,'978-0-316-12907-7','Abaddon\'s Gate','James S. A. Corey','Orbit Books','2013-06-04',98,011.55);
/*!40000 ALTER TABLE `adbadfb_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asdfaser_users`
--

DROP TABLE IF EXISTS `asdfaser_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asdfaser_users` (
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `delivery_address` varchar(45) DEFAULT NULL,
  `delivery_city` varchar(45) DEFAULT NULL,
  `delivery_state` varchar(2) DEFAULT NULL,
  `delivery_zip` int(5) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asdfaser_users`
--

LOCK TABLES `asdfaser_users` WRITE;
/*!40000 ALTER TABLE `asdfaser_users` DISABLE KEYS */;
INSERT INTO `asdfaser_users` VALUES ('e','e','e',4,'e','e',NULL,NULL,NULL,NULL),(NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL),('eee','eee','eee',9,NULL,NULL,NULL,NULL,NULL,NULL),('ee','ee','ee',10,NULL,NULL,NULL,NULL,NULL,NULL),('ejohn145','ejohn145@students.kennesaw.edu','aaa',11,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `asdfaser_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-25 15:55:42
