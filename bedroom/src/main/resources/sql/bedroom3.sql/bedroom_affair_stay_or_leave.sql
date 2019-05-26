-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bedroom
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
-- Table structure for table `affair_stay_or_leave`
--

DROP TABLE IF EXISTS `affair_stay_or_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affair_stay_or_leave` (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事务主键',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生账号',
  `start_time` datetime DEFAULT NULL COMMENT '离校/留校起止时间',
  `end_time` datetime DEFAULT NULL COMMENT '离校/留校终止时间',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核意见',
  `affair_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '(''0''-待审核,''1''-审核通过,''2''-审核拒绝)',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `sta_lev` char(1) DEFAULT NULL COMMENT '离校或者留校标识',
  PRIMARY KEY (`affair_id`) USING BTREE,
  KEY `stu_account` (`stu_account`) USING BTREE,
  CONSTRAINT `affair_stay_or_leave_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生留校或者离校申请事务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affair_stay_or_leave`
--

LOCK TABLES `affair_stay_or_leave` WRITE;
/*!40000 ALTER TABLE `affair_stay_or_leave` DISABLE KEYS */;
INSERT INTO `affair_stay_or_leave` VALUES (1,'5120151001','2016-01-28 12:00:00','2016-02-27 00:00:00','回家过年',NULL,'0','2016-01-26 12:00:00',NULL,'0'),(4,'5120151001','2019-05-21 08:00:34','2019-05-21 09:00:34','3241',NULL,'0','2019-05-21 17:23:47',NULL,'1'),(5,'5120151001','2019-05-16 08:00:25','2019-05-16 09:00:25','3241',NULL,'0','2019-05-21 17:24:29',NULL,'1'),(6,'5120151001','2016-01-28 12:00:00','2016-02-27 00:00:00','回家过年',NULL,'0','2016-01-26 12:00:00',NULL,'0'),(7,'5120151001','2016-01-28 12:00:00','2016-02-27 00:00:00','回家过年',NULL,'0','2016-01-26 12:00:00',NULL,'0'),(8,'5120151001','2019-05-01 11:01:20','2019-05-09 11:01:20','吃烧烤',NULL,'0','2019-05-21 17:34:20',NULL,'0'),(9,'5120151001','2019-04-30 11:11:43','2019-05-01 11:01:43','山东省地方',NULL,'0','2019-05-21 17:42:53',NULL,'1'),(10,'5120151001','2019-05-07 11:11:33','2019-05-22 11:11:33','积极',NULL,'0','2019-05-21 23:26:33',NULL,'0'),(11,'5120151001','2019-05-14 08:00:09','2026-06-16 09:00:09','毕业',NULL,'0','2019-05-26 22:52:09',NULL,'0');
/*!40000 ALTER TABLE `affair_stay_or_leave` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-26 22:56:08
