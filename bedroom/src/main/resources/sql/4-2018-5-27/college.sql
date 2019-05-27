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

 Date: 27/05/2019 16:09:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `college_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '学院创建时间',
  `introduction` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院介绍',
  PRIMARY KEY (`college_id`) USING BTREE,
  INDEX `college_name`(`college_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '理学院', '2019-05-01 15:47:38', '数学院');
INSERT INTO `college` VALUES (2, '信息工程学院', '2019-05-01 15:48:56', '信息工程学院');
INSERT INTO `college` VALUES (3, '材料科学与工程学院', '2019-05-01 15:49:25', '1');
INSERT INTO `college` VALUES (4, '制造科学与工程学院', '2019-05-01 15:50:06', '1');
INSERT INTO `college` VALUES (5, '土木工程与建筑学院', '2019-05-01 15:50:35', '1');
INSERT INTO `college` VALUES (6, '生命科学与工程学院', '2019-05-01 15:50:47', '1');
INSERT INTO `college` VALUES (7, '计算机科学与技术学院', '2019-05-01 15:50:57', '1');
INSERT INTO `college` VALUES (8, '国防科技学院', '2019-05-01 15:51:08', '1');
INSERT INTO `college` VALUES (9, '经济管理学院', '2019-05-01 15:51:20', '1');
INSERT INTO `college` VALUES (10, '法学院', '2019-05-01 15:51:29', '1');
INSERT INTO `college` VALUES (11, '文学与艺术学院', '2019-05-01 15:51:41', '1');
INSERT INTO `college` VALUES (12, '外国语学院', '2019-05-01 15:51:50', '1');
INSERT INTO `college` VALUES (13, '马克思主义学院', '2019-05-01 15:52:01', '1');
INSERT INTO `college` VALUES (14, '体育学科部', '2019-05-01 15:52:10', '1');
INSERT INTO `college` VALUES (15, '应用技术学院', '2019-05-01 15:52:19', '1');

SET FOREIGN_KEY_CHECKS = 1;
