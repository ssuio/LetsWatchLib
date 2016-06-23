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
-- Table structure for table `r16060042playlist`
--

DROP TABLE IF EXISTS `r16060042playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r16060042playlist` (
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
-- Dumping data for table `r16060042playlist`
--

LOCK TABLES `r16060042playlist` WRITE;
/*!40000 ALTER TABLE `r16060042playlist` DISABLE KEYS */;
INSERT INTO `r16060042playlist` VALUES (1,'dAZ2LkJ7XxM','神奇寶貝001 神奇寶貝‧就決定是你了','2015-12-11T11:36:07.000Z','https://i.ytimg.com/vi/dAZ2LkJ7XxM/default.jpg','1466331834215'),(2,'2UOAF7rxOWM','神奇寶貝 Pokemon XY&Z 122集 尋找小碎鑽！黏美露龍與咚咚鼠!! 簡體中文','2016-06-09T23:52:15.000Z','https://i.ytimg.com/vi/2UOAF7rxOWM/default.jpg','1466331834215'),(3,'QlOiUnnXnZk','神奇寶貝 Pokemon XY&Z 121集 小智-甲賀忍蛙VS超級暴雪王！發動巨大水手裏劍!! 簡體字幕','2016-06-03T10:46:09.000Z','https://i.ytimg.com/vi/QlOiUnnXnZk/default.jpg','1466331834215'),(4,'VvJYYJI9TZ8','下周停播!!神奇寶貝 Pokemon XY&Z 123集 爆熱的機巧慶典!! 簡體中文','2016-06-17T10:40:30.000Z','https://i.ytimg.com/vi/VvJYYJI9TZ8/default.jpg','1466331834215'),(5,'NwqYOLQF_z0','Huge Domino Screenlink! Dynamic Domino & TheDominoEffect','2015-07-31T20:43:54.000Z','https://i.ytimg.com/vi/NwqYOLQF_z0/default.jpg','1466331834215'),(6,'n4NemMQvskc','Jahresrückblick des CCC 2015 [32c3]','2015-12-30T17:12:59.000Z','https://i.ytimg.com/vi/n4NemMQvskc/default.jpg','1466331834215');
/*!40000 ALTER TABLE `r16060042playlist` ENABLE KEYS */;
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
