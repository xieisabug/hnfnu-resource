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
-- Table structure for table `r_category`
--

DROP TABLE IF EXISTS `r_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '类别名称',
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_category`
--

LOCK TABLES `r_category` WRITE;
/*!40000 ALTER TABLE `r_category` DISABLE KEYS */;
INSERT INTO `r_category` VALUES (1,'文章朗读',''),(2,'动画演示','');
/*!40000 ALTER TABLE `r_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_course`
--

DROP TABLE IF EXISTS `r_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(80) NOT NULL COMMENT '课程名称',
  `gradeId` int(11) NOT NULL COMMENT '课程所在年级的id',
  `subjectId` int(11) NOT NULL COMMENT '课程所在科目的id',
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_course`
--

LOCK TABLES `r_course` WRITE;
/*!40000 ALTER TABLE `r_course` DISABLE KEYS */;
INSERT INTO `r_course` VALUES (1,'第一课 小妈妈找蝌蚪',1,1,'sdjk');
/*!40000 ALTER TABLE `r_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_grade`
--

DROP TABLE IF EXISTS `r_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '年级名称',
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_grade`
--

LOCK TABLES `r_grade` WRITE;
/*!40000 ALTER TABLE `r_grade` DISABLE KEYS */;
INSERT INTO `r_grade` VALUES (1,'一年级','243234'),(2,'二年级','dfsdfsad'),(3,'三年级','fgdf');
/*!40000 ALTER TABLE `r_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_source`
--

DROP TABLE IF EXISTS `r_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '资源名称',
  `courseId` int(11) NOT NULL COMMENT '属于的课程的id',
  `keyWords` text COMMENT '关键字列表，用"；"分隔',
  `mediaType` varchar(45) DEFAULT NULL COMMENT '媒体类型，如：文本，ppt，视频等',
  `mediaFormat` varchar(45) DEFAULT NULL COMMENT '媒体格式，如：jpg，mp4等',
  `playTime` varchar(20) DEFAULT NULL COMMENT '播放时间，只有视频拥有这个属性',
  `fileSize` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `publisher` text COMMENT '出版社',
  `description` text COMMENT '描述',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `approvalStatus` varchar(45) DEFAULT '0' COMMENT '审核状态',
  `quality` varchar(50) DEFAULT NULL COMMENT '质量等级',
  `price` double DEFAULT '0' COMMENT '价格',
  `viewTimes` int(11) DEFAULT '0' COMMENT '访问次数',
  `useTimes` int(11) DEFAULT '0' COMMENT '下载或者使用次数',
  `url` varchar(255) NOT NULL,
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source`
--

LOCK TABLES `r_source` WRITE;
/*!40000 ALTER TABLE `r_source` DISABLE KEYS */;
INSERT INTO `r_source` VALUES (1,'大大王找小小王',2,'大大王','MP4','MP4','12:00','123M','小小王','大大王','xiaoxoa','2013-07-12 00:00:00','1','好',12,1,2,'ghthy',6),(2,'小小王',1,'ads','','','','0','','','','2013-07-14 00:00:00',NULL,NULL,0,NULL,NULL,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Jellyfish.jpg',6),(3,'胖胖喜欢笨笨',2,'sd','drftg','rthy','yt','0','jkyt','frt','uiol','2013-07-14 22:35:34','0',NULL,0,NULL,0,'',6),(4,'你好啊',1,'sdf','sdfs','ae','','0','','','','2013-07-15 15:30:23','0',NULL,0,NULL,0,'',6),(5,'你好呀',1,'sgd','','','','0','','','','2013-07-15 15:35:28','0',NULL,0,NULL,0,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Tulips.jpg',6),(6,'小静静',1,'小静','','','','0','','','','2013-07-15 15:40:03','0',NULL,0,NULL,0,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Koala.jpg',6),(7,'嗯，怎么还要测试',1,'df','','','','0','','','','2013-07-15 15:42:39','0',NULL,0,NULL,0,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Koala.jpg',6),(8,'胖胖煮煮',1,'sdf','sdfsa','yu','io','0','yu','tu','y','2013-07-15 15:49:29','0',NULL,0,NULL,0,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Jellyfish.jpg',6),(9,'最后一次测试',1,'adsfa','ytt','uy','yu','0','tuy','yi','ui','2013-07-15 15:54:47','0',NULL,0,NULL,0,'D:\\yingyongruanjian\\apache-tomcat-7.0.37\\webapps\\hnfnuzyw\\uploads\\Chrysanthemum.jpg',6);
/*!40000 ALTER TABLE `r_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_source_category_join`
--

DROP TABLE IF EXISTS `r_source_category_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_source_category_join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourceId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='资源和类别的挂接表，一个资源有多个类别。一个类别也可以属于多个资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source_category_join`
--

LOCK TABLES `r_source_category_join` WRITE;
/*!40000 ALTER TABLE `r_source_category_join` DISABLE KEYS */;
INSERT INTO `r_source_category_join` VALUES (1,9,1),(2,9,2);
/*!40000 ALTER TABLE `r_source_category_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_source_comment`
--

DROP TABLE IF EXISTS `r_source_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_source_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sourceId` int(11) NOT NULL COMMENT '所评价的资源的Id',
  `parentId` int(11) NOT NULL DEFAULT '0' COMMENT '评价的父评价id，0则表示此条为最顶评论',
  `content` text COMMENT '评论的内容',
  `authorId` int(11) NOT NULL COMMENT '评论的作者id，用于链接评论人员的信息',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source_comment`
--

LOCK TABLES `r_source_comment` WRITE;
/*!40000 ALTER TABLE `r_source_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_source_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_subject`
--

DROP TABLE IF EXISTS `r_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '科目名称',
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='科目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_subject`
--

LOCK TABLES `r_subject` WRITE;
/*!40000 ALTER TABLE `r_subject` DISABLE KEYS */;
INSERT INTO `r_subject` VALUES (1,'语文','sdfwse'),(3,'数学',''),(4,'历史',''),(5,'自然','');
/*!40000 ALTER TABLE `r_subject` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_function`
--

LOCK TABLES `s_function` WRITE;
/*!40000 ALTER TABLE `s_function` DISABLE KEYS */;
INSERT INTO `s_function` VALUES (1,'A','新增'),(2,'D','删除'),(3,'U','修改'),(4,'Q','查询'),(5,'R','刷新'),(6,'J','挂接'),(9,'k','测试');
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_menu`
--

LOCK TABLES `s_menu` WRITE;
/*!40000 ALTER TABLE `s_menu` DISABLE KEYS */;
INSERT INTO `s_menu` VALUES (40,-1,'管理系统','','',''),(41,-1,'资源库系统','','',''),(44,-1,'专题管理','','',''),(45,-1,'在线备课','','',''),(46,40,'菜单管理','App/System/Menu/MenuManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(47,40,'角色管理','App/System/Role/RoleManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(48,40,'用户管理','App/System/User/UserManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(49,40,'功能管理','App/System/Function/FunctionManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(50,40,'参数管理','App/System/Parameter/ParameterManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(51,41,'学科管理','App/Resources/Subject/SubjectManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(52,41,'年级管理','App/Resources/Grade/GradeManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(53,41,'类别管理','App/Resources/Category/CategoryManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(54,41,'课程管理','App/Resources/Course/CourseManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(55,41,'资源管理','App/Resources/Source/SourceManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role`
--

LOCK TABLES `s_role` WRITE;
/*!40000 ALTER TABLE `s_role` DISABLE KEYS */;
INSERT INTO `s_role` VALUES (1,'教师',1,NULL),(2,'学生',1,NULL),(3,'录入员',1,NULL),(4,'管理员',NULL,'sdgd');
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role_menu_join`
--

LOCK TABLES `s_role_menu_join` WRITE;
/*!40000 ALTER TABLE `s_role_menu_join` DISABLE KEYS */;
INSERT INTO `s_role_menu_join` VALUES (29,1,46,'1;2;3'),(30,1,47,'1;2;3;6'),(31,2,47,'1;2;3;6'),(32,3,49,'1;2;3'),(63,4,46,'1;2;3'),(64,4,47,'1;2;3;6'),(65,4,48,'1;2;3;6'),(66,4,49,'1;2;3'),(67,4,50,'1;2;3'),(68,4,51,'1;2;3'),(69,4,52,'1;2;3'),(70,4,53,'1;2;3'),(71,4,54,'1;2;3'),(72,4,55,'1;2;3');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (5,'123','123','123','123','1','','123123','2013-06-14','123',NULL,NULL,NULL,''),(6,'admin','123456','匡静','430221199103102928','0','23423434','15575847473','2013-07-09','信息资源部',NULL,NULL,NULL,'ewt');
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_role_join`
--

LOCK TABLES `s_user_role_join` WRITE;
/*!40000 ALTER TABLE `s_user_role_join` DISABLE KEYS */;
INSERT INTO `s_user_role_join` VALUES (40,5,1),(41,6,4);
/*!40000 ALTER TABLE `s_user_role_join` ENABLE KEYS */;
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
  `parentName` tinyint NOT NULL,
  `menuName` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `functionIdList` tinyint NOT NULL,
  `icon` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_source`
--

DROP TABLE IF EXISTS `v_source`;
/*!50001 DROP VIEW IF EXISTS `v_source`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_source` (
  `sourceId` tinyint NOT NULL,
  `sourceName` tinyint NOT NULL,
  `courseId` tinyint NOT NULL,
  `courseName` tinyint NOT NULL,
  `gradeId` tinyint NOT NULL,
  `gradeName` tinyint NOT NULL,
  `subjectId` tinyint NOT NULL,
  `subjectName` tinyint NOT NULL,
  `keyWords` tinyint NOT NULL,
  `mediaType` tinyint NOT NULL,
  `mediaFormat` tinyint NOT NULL,
  `playTime` tinyint NOT NULL,
  `fileSize` tinyint NOT NULL,
  `author` tinyint NOT NULL,
  `publisher` tinyint NOT NULL,
  `description` tinyint NOT NULL,
  `createDate` tinyint NOT NULL,
  `approvalStatus` tinyint NOT NULL,
  `quality` tinyint NOT NULL,
  `price` tinyint NOT NULL,
  `viewTimes` tinyint NOT NULL,
  `useTimes` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `createUserId` tinyint NOT NULL,
  `createUserName` tinyint NOT NULL,
  `categoryIdList` tinyint NOT NULL,
  `categoryNameList` tinyint NOT NULL
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
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_role_menu` AS select `t2`.`id` AS `roleId`,`t2`.`name` AS `roleName`,`t3`.`id` AS `menuId`,`t3`.`parentId` AS `parentId`,`t4`.`name` AS `parentName`,`t3`.`name` AS `menuName`,`t3`.`url` AS `url`,`t1`.`functionIdList` AS `functionIdList`,`t3`.`icon` AS `icon` from (((`s_role_menu_join` `t1` join `s_role` `t2` on((`t1`.`roleId` = `t2`.`id`))) join `s_menu` `t3` on((`t1`.`menuId` = `t3`.`id`))) join `s_menu` `t4` on((`t3`.`parentId` = `t4`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_source`
--

/*!50001 DROP TABLE IF EXISTS `v_source`*/;
/*!50001 DROP VIEW IF EXISTS `v_source`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_source` AS select `t1`.`id` AS `sourceId`,`t1`.`name` AS `sourceName`,`t1`.`courseId` AS `courseId`,`t2`.`name` AS `courseName`,`t3`.`id` AS `gradeId`,`t3`.`name` AS `gradeName`,`t4`.`id` AS `subjectId`,`t4`.`name` AS `subjectName`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `author`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `description`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`quality` AS `quality`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t5`.`name` AS `createUserName`,group_concat(`t7`.`id` separator ',') AS `categoryIdList`,group_concat(`t7`.`name` separator ',') AS `categoryNameList` from ((((((`r_source` `t1` join `r_course` `t2` on((`t1`.`courseId` = `t2`.`id`))) join `r_grade` `t3` on((`t2`.`gradeId` = `t3`.`id`))) join `r_subject` `t4` on((`t2`.`subjectId` = `t4`.`id`))) join `s_user` `t5` on((`t1`.`createUserId` = `t5`.`id`))) join `r_source_category_join` `t6` on((`t1`.`id` = `t6`.`sourceId`))) join `r_category` `t7` on((`t7`.`id` = `t6`.`categoryId`))) */;
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
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
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

-- Dump completed on 2013-07-15 22:53:15
