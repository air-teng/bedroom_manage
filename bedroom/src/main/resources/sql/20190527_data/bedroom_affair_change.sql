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
-- Table structure for table `affair_change`
--

DROP TABLE IF EXISTS `affair_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affair_change` (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事务id,自增',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生账号',
  `cur_bedroom_id` int(11) DEFAULT NULL COMMENT '当前的寝室id',
  `target_bedroom_id` int(11) DEFAULT NULL COMMENT '目标寝室id',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复意见',
  `affair_status` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '(''0''-待审核,''1''-审核通过,''2''-审核拒绝)',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`affair_id`) USING BTREE,
  KEY `stu_account` (`stu_account`) USING BTREE,
  KEY `cur_bedroom_id` (`cur_bedroom_id`) USING BTREE,
  KEY `target_bedroom_id` (`target_bedroom_id`) USING BTREE,
  CONSTRAINT `affair_change_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `affair_change_ibfk_2` FOREIGN KEY (`cur_bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `affair_change_ibfk_3` FOREIGN KEY (`target_bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生寝室交换事务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affair_change`
--

LOCK TABLES `affair_change` WRITE;
/*!40000 ALTER TABLE `affair_change` DISABLE KEYS */;
INSERT INTO `affair_change` VALUES (6,'5120155527',3,4,'ee eee','同意','1','2019-05-27 12:58:28','2019-05-27 22:44:33'),(8,'5120155527',3,4,'测试','测试','2','2019-05-27 13:22:11','2019-05-27 22:44:12'),(9,'5120155527',3,4,'431','原因没有说清楚','2','2019-05-27 13:27:50','2019-05-27 21:34:48'),(10,'5120155527',3,4,'324123','同意','1','2019-05-27 14:16:41','2019-05-27 21:27:16'),(11,'5120155527',3,4,'5432','同意','1','2019-05-27 14:23:30','2019-05-27 21:32:14');
/*!40000 ALTER TABLE `affair_change` ENABLE KEYS */;
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
