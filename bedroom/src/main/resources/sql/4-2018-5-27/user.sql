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

 Date: 27/05/2019 16:08:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `user_level` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份(\'0\'-学生,\'1\'-教师,\'2\'-管理员)',
  PRIMARY KEY (`user_account`) USING BTREE,
  INDEX `bedroom_id`(`bedroom_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`bedroom_id`) REFERENCES `bedroom` (`bedroom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5120151001', '杨川', '123456', '天涯', '男', 18, '18281592358', '理学院', '2015', '2019-05-01 09:34:17', 2, '0');
INSERT INTO `user` VALUES ('5120153185', '李思呈', '123456', '老幺', '男', 18, '18683664090', '理学院', '2015', '2019-05-22 13:01:00', 1, '0');
INSERT INTO `user` VALUES ('5120155527', '滕云飞', '000000', '论坛', '男', 18, '18281689896', '理学院', '2015', '2019-05-21 12:17:00', 3, '0');
INSERT INTO `user` VALUES ('918918', '川川', '123456', '测试管理员', '男', 18, '18281592358', '理学院', '2015', '2019-05-01 16:01:18', NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
