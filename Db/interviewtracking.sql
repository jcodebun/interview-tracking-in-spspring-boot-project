CREATE DATABASE  IF NOT EXISTS `interviewtackingview` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `interviewtackingview`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: interviewtackingview
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `feedback` varchar(755) DEFAULT NULL,
  `interview_id` bigint DEFAULT NULL,
  `email` varchar(755) DEFAULT NULL,
  `feedback_by` varchar(755) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (5,'ddgs',5,'ciwo@mailinator.com','Jorden Wagner'),(6,'fgfdgfd dfgfdgd dfgdfg',6,'ciwo@mailinator.com','Keegan');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduleinterview`
--

DROP TABLE IF EXISTS `scheduleinterview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scheduleinterview` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(755) DEFAULT NULL,
  `email` varchar(755) DEFAULT NULL,
  `first_name` varchar(755) DEFAULT NULL,
  `last_name` varchar(755) DEFAULT NULL,
  `phone_number` varchar(755) DEFAULT NULL,
  `schedule_with` varchar(755) DEFAULT NULL,
  `time` varchar(755) DEFAULT NULL,
  `userid` varchar(755) DEFAULT NULL,
  `schedule_with_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduleinterview`
--

LOCK TABLES `scheduleinterview` WRITE;
/*!40000 ALTER TABLE `scheduleinterview` DISABLE KEYS */;
INSERT INTO `scheduleinterview` VALUES (5,'2023-06-30','fdggfd@gmail.com','fgfdg','ffg','8585855869','Keegan','20:37','5',3),(6,'2023-06-28','ciwo@mailinator.com','Jorden','Wagner','+1 (916) 956-3081','Keegan','18:19','4',3),(7,'2023-06-29','ciwo@mailinator.com','Jorden','Wagner','+1 (916) 956-3081','Aretha','18:19','4',2);
/*!40000 ALTER TABLE `scheduleinterview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(755) DEFAULT NULL,
  `first_name` varchar(755) DEFAULT NULL,
  `gender` varchar(755) DEFAULT NULL,
  `last_name` varchar(755) DEFAULT NULL,
  `password` varchar(755) DEFAULT NULL,
  `phone_number` varchar(755) DEFAULT NULL,
  `user_role` varchar(755) DEFAULT NULL,
  `experince` varchar(755) DEFAULT NULL,
  `qualification` varchar(755) DEFAULT NULL,
  `skill` varchar(755) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2010-07-22','Admin@gmail.com','Admin','Male','Admin','Pa$$w0rd!','+1 (124) 258-4696','Admin','2 Year','MCA','JAVA, SPring'),(2,'2010-07-15','tujyf@mailinator.com','Aretha','Male','Burt','Pa$$w0rd!','+1 (502) 911-1287','HR','5','Btech','C, C++'),(3,'2015-11-19','rydosif@mailinator.com','Keegan','Female','Espinoza','Pa$$w0rd!','+1 (589) 299-1468','Tech','4','khk','khk'),(4,'1984-05-17','ciwo@mailinator.com','Jorden','Male','Wagner','Pa$$w0rd!','+1 (916) 956-3081','User','4','jgkh khk','khkkh'),(5,'2018-06-05','fdggfd@gmail.com','fgfdg','Male','ffg','Demo@123','8585855869','User','2 Year','MCA','C# and .net');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-01  9:51:50
