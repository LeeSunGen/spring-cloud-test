/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50721
Source Host           : 47.75.85.48:3306
Source Database       : spring-cloud-test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-16 15:32:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户ID',
  `account_balance` bigint(20) DEFAULT '0' COMMENT '账户余额(单位:分)',
  `create_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='账户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '-600', 'system', '2018-11-15 14:05:08', 'system', '2018-11-15 19:38:57');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` bigint(20) NOT NULL DEFAULT '0' COMMENT '价格(单位:分)',
  `count` int(11) NOT NULL DEFAULT '1' COMMENT '商品数量',
  `create_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', 'apple', '100', '9', 'system', '2018-11-15 15:32:56', 'system', '2018-11-15 15:32:56');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '所属用户ID',
  `commodity_id` bigint(20) DEFAULT NULL COMMENT '所属商品Id',
  `purchaes_count` int(11) DEFAULT NULL COMMENT '购买数量',
  `pay_status` int(11) DEFAULT '0' COMMENT '支付状态: 0-等待支付 1-已经支付',
  `create_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('2', '1', '1', '1', '1', 'system', '2018-11-15 15:44:34', 'system', '2018-11-15 15:44:34');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `trans_id` varchar(256) NOT NULL COMMENT '交易流水号',
  `order_id` bigint(20) NOT NULL COMMENT '所属订单',
  `charge_amount` bigint(20) DEFAULT NULL COMMENT '支付金额(单位:分)',
  `create_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_person` varchar(64) NOT NULL DEFAULT 'system' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='支付表';

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '840ecb03-357f-42ec-811f-82e53092980c', '2', '100', 'system', '2018-11-15 16:46:10', 'system', '2018-11-15 16:46:10');
