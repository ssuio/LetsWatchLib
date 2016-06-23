-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: lw
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` varchar(45) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `wCoin` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `epaper` tinyint(4) DEFAULT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `roomId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('95225','eeilsa','eeeilsa@gmail.com',NULL,NULL,0,NULL,'\0',0,NULL,NULL,0,NULL),('M1111178','Karl','karl@hotmail.com','Abcd1234',NULL,0,NULL,'\0',0,NULL,NULL,0,'R16060030'),('1234','Mark','mark@gmail.com','Abcd12345','2015-08-11',100,'0978111222','M',1,'I am handsome!',18,0,'R16060030'),('M00000019','Ssuio','xssuio@gmail.com','Abcd1234',NULL,5000,NULL,'\0',0,NULL,NULL,0,'R16060028'),('M00000002','Ssuio','xssuiox@gmail.com','Abcd1234',NULL,5000,NULL,'\0',0,NULL,NULL,0,'R16060028'),('M16060018','xxsss','xxsss@gmail.com','Abcd1234',NULL,5000,NULL,'\0',0,NULL,NULL,0,'R16060030');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-12 20:14:31
