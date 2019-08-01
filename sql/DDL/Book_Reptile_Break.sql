/*
 Navicat MySQL Data Transfer

 Source Server         : Refactor
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : refactor

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 08/05/2019 01:51:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Book_Reptile_Break
-- ----------------------------
DROP TABLE IF EXISTS `Book_Reptile_Break`;
CREATE TABLE `Book_Reptile_Break`  (
  `book_id` int(11) NOT NULL,
  `break_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  INDEX `book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
