/*
 Navicat Premium Data Transfer

 Source Server         : newmysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : bedroom

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 21/05/2019 18:40:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for affair_stay_or_leave
-- ----------------------------
DROP TABLE IF EXISTS `affair_stay_or_leave`;
CREATE TABLE `affair_stay_or_leave`  (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事务主键',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生账号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '离校/留校起止时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '离校/留校终止时间',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `affair_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(\'0\'-待审核,\'1\'-审核通过,\'2\'-审核拒绝)',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `sta_lev` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0-离校;1-留校',
  PRIMARY KEY (`affair_id`) USING BTREE,
  INDEX `stu_account`(`stu_account`) USING BTREE,
  CONSTRAINT `affair_stay_or_leave_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生留校或者离校申请事务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of affair_stay_or_leave
-- ----------------------------
INSERT INTO `affair_stay_or_leave` VALUES (1, '5120151001', '2016-01-28 12:00:00', '2016-02-27 00:00:00', '回家过年', NULL, '0', '2016-01-26 12:00:00', NULL, '0');
INSERT INTO `affair_stay_or_leave` VALUES (4, '5120151001', '2019-05-21 08:00:34', '2019-05-21 09:00:34', '3241', NULL, '0', '2019-05-21 17:23:47', NULL, '1');
INSERT INTO `affair_stay_or_leave` VALUES (5, '5120151001', '2019-05-16 08:00:25', '2019-05-16 09:00:25', '3241', NULL, '0', '2019-05-21 17:24:29', NULL, '1');
INSERT INTO `affair_stay_or_leave` VALUES (6, '5120151001', '2016-01-28 12:00:00', '2016-02-27 00:00:00', '回家过年', NULL, '0', '2016-01-26 12:00:00', NULL, '0');
INSERT INTO `affair_stay_or_leave` VALUES (7, '5120151001', '2016-01-28 12:00:00', '2016-02-27 00:00:00', '回家过年', NULL, '0', '2016-01-26 12:00:00', NULL, '0');
INSERT INTO `affair_stay_or_leave` VALUES (8, '5120151001', '2019-05-01 11:01:20', '2019-05-09 11:01:20', '吃烧烤', NULL, '0', '2019-05-21 17:34:20', NULL, '0');
INSERT INTO `affair_stay_or_leave` VALUES (9, '5120151001', '2019-04-30 11:11:43', '2019-05-01 11:01:43', '山东省地方', NULL, '0', '2019-05-21 17:42:53', NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
