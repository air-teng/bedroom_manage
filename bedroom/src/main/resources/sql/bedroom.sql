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

 Date: 21/05/2019 11:21:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for affair_change
-- ----------------------------
DROP TABLE IF EXISTS `affair_change`;
CREATE TABLE `affair_change`  (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事务id,自增',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生账号',
  `cur_bedroom_id` int(11) NULL DEFAULT NULL COMMENT '当前的寝室id',
  `target_bedroom_id` int(11) NULL DEFAULT NULL COMMENT '目标寝室id',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复意见',
  `affair_status` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(\'0\'-待审核,\'1\'-审核通过,\'2\'-审核拒绝)',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`affair_id`) USING BTREE,
  INDEX `stu_account`(`stu_account`) USING BTREE,
  INDEX `cur_bedroom_id`(`cur_bedroom_id`) USING BTREE,
  INDEX `target_bedroom_id`(`target_bedroom_id`) USING BTREE,
  CONSTRAINT `affair_change_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `affair_change_ibfk_2` FOREIGN KEY (`cur_bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `affair_change_ibfk_3` FOREIGN KEY (`target_bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生寝室交换事务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for affair_late_back
-- ----------------------------
DROP TABLE IF EXISTS `affair_late_back`;
CREATE TABLE `affair_late_back`  (
  `affair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `stu_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生账号',
  `back_time` datetime(0) NULL DEFAULT NULL COMMENT '回校时间',
  `apply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `reply_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复意见',
  `affair_status` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(\'0\'-待审核,\'1\'-审核通过,\'2\'-审核拒绝)',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`affair_id`) USING BTREE,
  INDEX `stu_account`(`stu_account`) USING BTREE,
  CONSTRAINT `affair_late_back_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生晚归申请事务表' ROW_FORMAT = Dynamic;

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
  `affair_status` char(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(\'0\'-待审核,\'1\'-审核通过,\'2\'-审核拒绝)',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`affair_id`) USING BTREE,
  INDEX `stu_account`(`stu_account`) USING BTREE,
  CONSTRAINT `affair_stay_or_leave_ibfk_1` FOREIGN KEY (`stu_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生留校或者离校申请事务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bedroom
-- ----------------------------
DROP TABLE IF EXISTS `bedroom`;
CREATE TABLE `bedroom`  (
  `bedroom_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '寝室id',
  `building_id` int(11) NULL DEFAULT NULL COMMENT '楼栋id',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元',
  `bedroom_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寝室号',
  PRIMARY KEY (`bedroom_id`) USING BTREE,
  INDEX `building_id`(`building_id`) USING BTREE,
  CONSTRAINT `bedroom_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '寝室号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `building_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '楼栋id',
  `building_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼栋代码',
  `building_floors` int(255) NULL DEFAULT NULL COMMENT '楼栋层数',
  `manager_accounts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理人account(多个管理人之间用\",\"连接)',
  PRIMARY KEY (`building_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '寝室楼栋' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for college_manager
-- ----------------------------
DROP TABLE IF EXISTS `college_manager`;
CREATE TABLE `college_manager`  (
  `college_id` int(11) NOT NULL COMMENT '学院id',
  `counselor_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '辅导员id',
  `grade_level` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '哪一届',
  `permission_level` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '权限级别(默认为\'0\',表示辅导员)',
  PRIMARY KEY (`college_id`, `counselor_account`) USING BTREE,
  INDEX `counselor_account`(`counselor_account`) USING BTREE,
  CONSTRAINT `college_manager_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `college_manager_ibfk_2` FOREIGN KEY (`counselor_account`) REFERENCES `user` (`user_account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学院管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名(真名)',
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_nickname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `user_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `user_college_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名字',
  `grade_level` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '哪一届',
  `user_foundtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `bedroom_id` int(11) NULL DEFAULT NULL COMMENT '宿舍id',
  `user_level` char(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份(\'0\'-学生,\'1\'-教师,\'2\'-管理员)',
  PRIMARY KEY (`user_account`) USING BTREE,
  INDEX `bedroom_id`(`bedroom_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5120151001', '杨川', '123456', '天涯', '男', 18, NULL, '理学院', NULL, '2019-05-01 09:34:17', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
