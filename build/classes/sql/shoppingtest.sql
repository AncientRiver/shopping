/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : shoppingtest

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-06-21 11:01:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` double(10,2) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `seller` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '3231', '1321.00', '313', '313');
INSERT INTO `goods` VALUES ('2', '321', '42.00', '2', '44');
INSERT INTO `goods` VALUES ('3', '321', '42.00', '2', '44');
INSERT INTO `goods` VALUES ('4', '231', '4123.00', '7.png', '111');
INSERT INTO `goods` VALUES ('5', '小虫子', '2143.00', '', '111');
INSERT INTO `goods` VALUES ('6', '小虫子的自慰棒', '2322.00', 'u=3713312077,1216729544&fm=23&gp=0.jpg', '123456');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `seller` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('5', '231', '', '111', '2017年06月21日 10:33');
INSERT INTO `record` VALUES ('6', '231', '', '111', '2017年06月21日 10:33');
INSERT INTO `record` VALUES ('7', '小虫子', '111', '111', '2017年06月21日 10:54');
INSERT INTO `record` VALUES ('8', '小虫子', '111', '111', '2017年06月21日 10:56');
INSERT INTO `record` VALUES ('9', '小虫子', '', '111', '2017年06月21日 10:56');
INSERT INTO `record` VALUES ('10', '231', '111', '111', '2017年06月21日 10:56');
INSERT INTO `record` VALUES ('11', '小虫子的自慰棒', '123456', '123456', '2017年06月21日 11:00');
INSERT INTO `record` VALUES ('12', '231', '123456', '111', '2017年06月21日 11:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', '12', '4');
INSERT INTO `user` VALUES ('111', '111', '吴彦祖');
INSERT INTO `user` VALUES ('123456', '123456', '小虫子');
INSERT INTO `user` VALUES ('33', '', '起小点');
INSERT INTO `user` VALUES ('54321', '241', '小');
