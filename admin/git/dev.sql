/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50702
Source Host           : localhost:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50702
File Encoding         : 65001

Date: 2015-01-17 01:06:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorities`;
CREATE TABLE `sys_authorities` (
  `AUTHORITY_ID` varchar(32) NOT NULL,
  `AUTHORITY_MARK` varchar(255) DEFAULT NULL,
  `AUTHORITY_NAME` varchar(55) NOT NULL,
  `AUTHORITY_DESC` varchar(255) DEFAULT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  `ENABLED` char(1) DEFAULT NULL,
  `IS_SYS` char(1) DEFAULT NULL,
  `MODULE_ID` varchar(32) DEFAULT NULL,
  KEY `AUTHORITY_ID` (`AUTHORITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authorities
-- ----------------------------

-- ----------------------------
-- Table structure for sys_authorities_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorities_resources`;
CREATE TABLE `sys_authorities_resources` (
  `ID` varchar(32) NOT NULL,
  `RESOURCE_ID` varchar(32) NOT NULL,
  `AUTHORITY_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_AUTH_REFERENCE_SYS_AUTH` (`AUTHORITY_ID`),
  KEY `FK_SYS_AUTH_REFERENCE_SYS_RESO` (`RESOURCE_ID`),
  CONSTRAINT `FK_SYS_AUTH_REFERENCE_SYS_AUTH` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `sys_authorities` (`AUTHORITY_ID`),
  CONSTRAINT `FK_SYS_AUTH_REFERENCE_SYS_RESO` FOREIGN KEY (`RESOURCE_ID`) REFERENCES `sys_resources` (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authorities_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_modules
-- ----------------------------
DROP TABLE IF EXISTS `sys_modules`;
CREATE TABLE `sys_modules` (
  `MODULE_ID` varchar(32) NOT NULL,
  `MODULE_NAME` varchar(55) NOT NULL,
  `MODULE_DESC` varchar(255) DEFAULT NULL,
  `MODULE_TYPE` varchar(55) DEFAULT NULL,
  `PARENT` varchar(55) DEFAULT NULL,
  `MODULE_URL` varchar(255) DEFAULT NULL,
  `LEVEL` varchar(55) DEFAULT NULL,
  `LEAF` varchar(55) DEFAULT NULL,
  `APPLICATION` varchar(255) DEFAULT NULL,
  `CONTROLLER` varchar(255) DEFAULT NULL,
  `ENABLED` char(1) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_modules
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `RESOURCE_ID` varchar(32) NOT NULL,
  `RESOURCE_TYPE` varchar(55) DEFAULT NULL,
  `RESOURCE_NAME` varchar(255) DEFAULT NULL,
  `RESOURCE_DESC` varchar(255) DEFAULT NULL,
  `RESOURCE_PATH` varchar(255) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `ENABLED` char(1) DEFAULT NULL,
  `IS_SYS` char(1) DEFAULT NULL,
  `MODULE_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`RESOURCE_ID`),
  KEY `FK_SYS_RESO_REFERENCE_SYS_MODU` (`MODULE_ID`),
  CONSTRAINT `FK_SYS_RESO_REFERENCE_SYS_MODU` FOREIGN KEY (`MODULE_ID`) REFERENCES `sys_modules` (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(55) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `ENABLED` char(1) DEFAULT NULL COMMENT '是否可用',
  `IS_SYS` char(1) DEFAULT NULL COMMENT '是否系统权限',
  `MODULE_ID` varchar(32) DEFAULT NULL COMMENT '模块ID',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('818181ec4ad85c9a014ad85c9ad60000', '登录用户', '登录用户', '1', '0', null);
INSERT INTO `sys_roles` VALUES ('818181ec4ad85da7014ad85da78b0000', '系统管理员', '系统管理员', '1', '1', null);
INSERT INTO `sys_roles` VALUES ('818181ec4ad85ebd014ad85ebd2b0000', '普通用户', '普通用户', '1', '0', null);

-- ----------------------------
-- Table structure for sys_roles_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_authorities`;
CREATE TABLE `sys_roles_authorities` (
  `ID` varchar(32) NOT NULL,
  `AUTHORITY_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_ROLE_REFERENCE_SYS_ROLE` (`ROLE_ID`),
  KEY `FK_SYS_ROLE_REFERENCE_SYS_AUTH` (`AUTHORITY_ID`),
  CONSTRAINT `FK_SYS_ROLE_REFERENCE_SYS_AUTH` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `sys_authorities` (`AUTHORITY_ID`),
  CONSTRAINT `FK_SYS_ROLE_REFERENCE_SYS_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_authorities
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles_moudles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_moudles`;
CREATE TABLE `sys_roles_moudles` (
  `ID` varchar(32) NOT NULL,
  `MODULE_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_ROLE_REFERENCE_SYS_MODU` (`MODULE_ID`),
  KEY `FK_SYS_ROLE_REFERENCE_SYS_ROLE2` (`ROLE_ID`),
  CONSTRAINT `FK_SYS_ROLE_REFERENCE_SYS_MODU` FOREIGN KEY (`MODULE_ID`) REFERENCES `sys_modules` (`MODULE_ID`),
  CONSTRAINT `FK_SYS_ROLE_REFERENCE_SYS_ROLE2` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_moudles
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `USERNAME` varchar(55) NOT NULL COMMENT '用户名',
  `NAME` varchar(55) DEFAULT NULL COMMENT '真实姓名',
  `PASSWORD` varchar(55) NOT NULL COMMENT '密码',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `LAST_LOGIN_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `DEADLINE` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `LOGIN_IP` varchar(100) DEFAULT NULL COMMENT '最后登录IP地址',
  `DEPARTMENT_ID` varchar(32) DEFAULT NULL COMMENT '部门ID',
  `DEPARTMENT_NAME` varchar(55) DEFAULT NULL COMMENT '部门名称',
  `ENABLED` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用',
  `ACCOUNT_NON_EXPIRED` char(1) DEFAULT NULL COMMENT '用户是否过期',
  `ACCOUNT_NON_LOCKED` char(1) DEFAULT NULL COMMENT '用户是否锁定',
  `CREDENTIALS_NON_EXPIRED` char(1) DEFAULT '' COMMENT '用户证书是否有效',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('818181ec4ad457c6014ad457c6dc0000', 'admin', '管理员', '21232f297a57a5a743894a0e4a801fc3', '2015-01-10 22:55:30', '2015-01-10 22:55:30', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_users` VALUES ('818181ec4ad46274014ad46274080000', 'abc', '管理员', '900150983cd24fb0d6963f7d28e17f72', '2015-01-10 23:07:10', '2015-01-10 23:07:10', null, null, null, null, '1', null, null, null);

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) NOT NULL,
  KEY `FK_SYS_USER_REFERENCE_SYS_ROLE` (`ROLE_ID`),
  KEY `FK_SYS_USER_REFERENCE_SYS_USER` (`USER_ID`),
  CONSTRAINT `FK_SYS_USER_REFERENCE_SYS_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`),
  CONSTRAINT `FK_SYS_USER_REFERENCE_SYS_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('818181ec4ad8be3d014ad8be3d190000', '818181ec4ad85c9a014ad85c9ad60000', '818181ec4ad46274014ad46274080000');
