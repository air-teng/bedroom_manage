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
-- Table structure for table `affair_late_back`
--

DROP TABLE IF EXISTS `affair_late_back`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affair_late_back` (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生账号',
  `back_time` datetime DEFAULT NULL COMMENT '回校时间',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复意见',
  `affair_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '(''0''-待审核,''1''-审核通过,''2''-审核拒绝)',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`affair_id`) USING BTREE,
  KEY `stu_account` (`stu_account`) USING BTREE,
  CONSTRAINT `affair_late_back_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生晚归申请事务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affair_late_back`
--

LOCK TABLES `affair_late_back` WRITE;
/*!40000 ALTER TABLE `affair_late_back` DISABLE KEYS */;
INSERT INTO `affair_late_back` VALUES (2,'5120155527','2019-05-22 01:00:06','聚会',NULL,'0','2019-05-21 23:19:06',NULL),(3,'5120153185','2019-05-23 02:00:37','修改论文','同意','1','2019-05-22 13:04:37','2019-05-27 22:42:33'),(4,'5120155527','2019-05-24 00:00:30','我愿意啥时候回啥时候回','过于霸道，打回','2','2019-05-27 14:03:30','2019-05-27 22:42:21'),(5,'5120155527','2019-05-28 08:00:09','3134','把原因说清楚','2','2019-05-27 14:11:10','2019-05-27 22:41:58'),(6,'5120155527','2019-05-29 16:00:39','而我却若','在正常时间段内，不需要申请晚归','2','2019-05-27 14:13:39','2019-05-27 22:41:30'),(9,'5120155527','2019-05-30 01:00:32','1234321','同意','1','2019-05-27 14:42:32','2019-05-27 22:41:00');
/*!40000 ALTER TABLE `affair_late_back` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-27 22:45:58
