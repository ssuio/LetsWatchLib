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
-- Table structure for table `r16060038playlist`
--

DROP TABLE IF EXISTS `r16060038playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r16060038playlist` (
  `number` int(11) NOT NULL,
  `videoId` varchar(45) DEFAULT NULL,
  `videoTitle` varchar(100) DEFAULT NULL,
  `videoTime` varchar(45) DEFAULT NULL,
  `videoImg` varchar(100) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r16060038playlist`
--

LOCK TABLES `r16060038playlist` WRITE;
/*!40000 ALTER TABLE `r16060038playlist` DISABLE KEYS */;
INSERT INTO `r16060038playlist` VALUES (1,'tFoUuFq3vHw','Five Little Ducks | Plus Lots More Children\'s Songs | 74 Minutes Compilation from LittleBabyBum!','2014-10-24T13:56:22.000Z','https://i.ytimg.com/vi/tFoUuFq3vHw/default.jpg','1466252681715'),(2,'65MVD0p48m4','6 Hour Donald Duck Marathon Ultimate Collection 2','2014-12-14T21:49:23.000Z','https://i.ytimg.com/vi/65MVD0p48m4/default.jpg','1466252681715'),(3,'5IhmAI0jgSg','Five Little Ducks and Many More Numbers Songs | Number Nursery Rhymes Collection by ChuChu TV','2014-11-27T12:18:37.000Z','https://i.ytimg.com/vi/5IhmAI0jgSg/default.jpg','1466252681715'),(4,'kVjQRopw7HI','[ HD ]Donald Duck Cartoons - Donald Duck Cartoons Full Episodes & Chip And Dale','2015-10-12T18:01:18.000Z','https://i.ytimg.com/vi/kVjQRopw7HI/default.jpg','1466252681715');
/*!40000 ALTER TABLE `r16060038playlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-19 18:24:57
