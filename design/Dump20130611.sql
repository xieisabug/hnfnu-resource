CREATE DATABASE  IF NOT EXISTS `hnfnuzyw` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hnfnuzyw`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: hnfnuzyw
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `s_function`
--

DROP TABLE IF EXISTS `s_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '功能的缩写字母，要大写',
  `remark` varchar(20) NOT NULL COMMENT '功能的中文名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `remark_UNIQUE` (`remark`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_function`
--

LOCK TABLES `s_function` WRITE;
/*!40000 ALTER TABLE `s_function` DISABLE KEYS */;
INSERT INTO `s_function` VALUES (1,'A','新增'),(2,'D','删除'),(3,'U','修改'),(4,'Q','查询'),(5,'R','刷新'),(6,'J','挂接');
/*!40000 ALTER TABLE `s_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_menu`
--

DROP TABLE IF EXISTS `s_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT '-1' COMMENT '父菜单的id，如果是-1， 则表示当前为最高级菜单',
  `name` varchar(30) NOT NULL COMMENT '菜单的名字',
  `url` varchar(50) DEFAULT NULL COMMENT '菜单点击后调用的链接',
  `functionIdList` varchar(100) DEFAULT NULL COMMENT '菜单所拥有的功能的id列表，用‘，’分割',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单的图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_menu`
--

LOCK TABLES `s_menu` WRITE;
/*!40000 ALTER TABLE `s_menu` DISABLE KEYS */;
INSERT INTO `s_menu` VALUES (40,-1,'管理系统','','',''),(41,-1,'资源系统','','',''),(44,-1,'专题管理','','',''),(45,-1,'在线备课','','',''),(46,40,'菜单管理','App/System/Menu/MenuManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(47,40,'角色管理','App/System/Role/RoleManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(48,40,'用户管理','App/System/User/UserManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(49,40,'功能管理','App/System/Function/FunctionManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(50,40,'参数管理','App/System/Parameter/ParameterManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif');
/*!40000 ALTER TABLE `s_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_parameter`
--

DROP TABLE IF EXISTS `s_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '参数的名称',
  `value` varchar(20) NOT NULL COMMENT '参数的值',
  `type` varchar(20) NOT NULL COMMENT '参数的类型',
  `remark` text COMMENT '参数备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_parameter`
--

LOCK TABLES `s_parameter` WRITE;
/*!40000 ALTER TABLE `s_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_role`
--

DROP TABLE IF EXISTS `s_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `createUserId` int(11) DEFAULT NULL COMMENT '创建用户id',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role`
--

LOCK TABLES `s_role` WRITE;
/*!40000 ALTER TABLE `s_role` DISABLE KEYS */;
INSERT INTO `s_role` VALUES (1,'教师',1,NULL),(2,'学生',1,NULL),(3,'录入员',1,NULL);
/*!40000 ALTER TABLE `s_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_role_menu_join`
--

DROP TABLE IF EXISTS `s_role_menu_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_role_menu_join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  `functionIdList` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role_menu_join`
--

LOCK TABLES `s_role_menu_join` WRITE;
/*!40000 ALTER TABLE `s_role_menu_join` DISABLE KEYS */;
INSERT INTO `s_role_menu_join` VALUES (17,2,46,'1;2;3'),(18,2,47,'1;2;3;6'),(19,1,46,'1;2'),(20,1,47,'1;2;3;6'),(21,1,48,'1;2;3;6'),(22,1,49,'1;2;3'),(23,1,50,'1;2;3');
/*!40000 ALTER TABLE `s_role_menu_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user`
--

DROP TABLE IF EXISTS `s_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `idcard` varchar(18) NOT NULL COMMENT '身份证',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `qq` varchar(15) DEFAULT NULL COMMENT 'QQ',
  `telephone` varchar(15) DEFAULT NULL COMMENT '电话',
  `birth` date DEFAULT NULL COMMENT '生日',
  `department` varchar(40) NOT NULL COMMENT '部门',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `latestLoginDate` date DEFAULT NULL COMMENT '最后登录时间',
  `setting` varchar(500) DEFAULT NULL COMMENT '设置（用于涉及用户个人的设置）',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (5,'123','123','123','123','1','','123123','2013-06-14','123',NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_role_join`
--

DROP TABLE IF EXISTS `s_user_role_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_role_join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_role_join`
--

LOCK TABLES `s_user_role_join` WRITE;
/*!40000 ALTER TABLE `s_user_role_join` DISABLE KEYS */;
INSERT INTO `s_user_role_join` VALUES (38,5,1),(39,5,2);
/*!40000 ALTER TABLE `s_user_role_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_role_menu`
--

DROP TABLE IF EXISTS `v_role_menu`;
/*!50001 DROP VIEW IF EXISTS `v_role_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_role_menu` (
  `roleId` tinyint NOT NULL,
  `roleName` tinyint NOT NULL,
  `menuId` tinyint NOT NULL,
  `parentId` tinyint NOT NULL,
  `menuName` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `functionIdList` tinyint NOT NULL,
  `icon` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_user_role`
--

DROP TABLE IF EXISTS `v_user_role`;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_user_role` (
  `userId` tinyint NOT NULL,
  `username` tinyint NOT NULL,
  `password` tinyint NOT NULL,
  `realname` tinyint NOT NULL,
  `idcard` tinyint NOT NULL,
  `sex` tinyint NOT NULL,
  `qq` tinyint NOT NULL,
  `telephone` tinyint NOT NULL,
  `birth` tinyint NOT NULL,
  `department` tinyint NOT NULL,
  `roleId` tinyint NOT NULL,
  `rolename` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_role_menu`
--

/*!50001 DROP TABLE IF EXISTS `v_role_menu`*/;
/*!50001 DROP VIEW IF EXISTS `v_role_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_role_menu` AS select `t2`.`id` AS `roleId`,`t2`.`name` AS `roleName`,`t3`.`id` AS `menuId`,`t3`.`parentId` AS `parentId`,`t3`.`name` AS `menuName`,`t3`.`url` AS `url`,`t1`.`functionIdList` AS `functionIdList`,`t3`.`icon` AS `icon` from ((`s_role_menu_join` `t1` join `s_role` `t2` on((`t1`.`roleId` = `t2`.`id`))) join `s_menu` `t3` on((`t1`.`menuId` = `t3`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_user_role`
--

/*!50001 DROP TABLE IF EXISTS `v_user_role`*/;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_role` AS select `s_user`.`id` AS `userId`,`s_user`.`username` AS `username`,`s_user`.`password` AS `password`,`s_user`.`name` AS `realname`,`s_user`.`idcard` AS `idcard`,`s_user`.`sex` AS `sex`,`s_user`.`qq` AS `qq`,`s_user`.`telephone` AS `telephone`,`s_user`.`birth` AS `birth`,`s_user`.`department` AS `department`,`s_role`.`id` AS `roleId`,`s_role`.`name` AS `rolename` from ((`s_user` join `s_role`) join `s_user_role_join`) where ((`s_user`.`id` = `s_user_role_join`.`userId`) and (`s_role`.`id` = `s_user_role_join`.`roleId`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-11 16:35:16
