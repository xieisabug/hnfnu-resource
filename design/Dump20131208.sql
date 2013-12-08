CREATE DATABASE  IF NOT EXISTS `hnfnuzyw` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hnfnuzyw`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: 125.221.193.205    Database: hnfnuzyw
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
-- Table structure for table `f_news`
--

DROP TABLE IF EXISTS `f_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `f_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '正文',
  `date` date DEFAULT NULL COMMENT '日期',
  `createUserId` int(11) NOT NULL COMMENT '创建者用户id',
  `priority` int(11) DEFAULT NULL COMMENT '优先级，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='新闻管理类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_news`
--

LOCK TABLES `f_news` WRITE;
/*!40000 ALTER TABLE `f_news` DISABLE KEYS */;
INSERT INTO `f_news` VALUES (16,'2','<p style=\"line-height: 16px;\"><img src=\"/hnfnuzyw/ueditor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a href=\"/hnfnuzyw/ueditor/jsp/upload/20131124/25091385294761984.docx\">2013.11.08_资源管理系统修改意见.docx</a></p><p><br/></p>','2013-11-24',0,NULL),(17,'sdfsd','<p>dfgdgdf</p>','2013-11-24',6,NULL);
/*!40000 ALTER TABLE `f_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `f_pictures`
--

DROP TABLE IF EXISTS `f_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `f_pictures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` varchar(100) NOT NULL COMMENT '图片的路径',
  `link` varchar(100) NOT NULL COMMENT '点击图片的链接',
  `display` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `createUserId` int(11) DEFAULT NULL COMMENT '创建人id',
  `createUserName` varchar(45) DEFAULT NULL COMMENT '创建人名字',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_pictures`
--

LOCK TABLES `f_pictures` WRITE;
/*!40000 ALTER TABLE `f_pictures` DISABLE KEYS */;
INSERT INTO `f_pictures` VALUES (12,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719475571.jpg','http://www.baidu.com',1,'2013-11-17',6,'管理员',''),(13,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719481912.jpg','http://www.baidu.com',1,'2013-11-17',6,'管理员','2'),(14,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719485623.jpg','http://www.baidu.com/',1,'2013-11-17',6,'管理员','3'),(15,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719491574.jpg','http://www.baidu.com/',1,'2013-11-17',6,'管理员','4'),(16,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719505345.jpg','http://www.baidu.com/',1,'2013-11-17',6,'管理员','5'),(17,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719510311.jpg','http://www.baidu.com/',1,'2013-11-17',6,'管理员','6'),(18,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\2013111719514532.jpg','http://www.baidu.com/',1,'2013-11-17',6,'管理员','7');
/*!40000 ALTER TABLE `f_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `l_user_operate`
--

DROP TABLE IF EXISTS `l_user_operate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `l_user_operate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=546 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_user_operate`
--

LOCK TABLES `l_user_operate` WRITE;
/*!40000 ALTER TABLE `l_user_operate` DISABLE KEYS */;
INSERT INTO `l_user_operate` VALUES (1,6,48),(2,6,48),(3,6,47),(4,6,46),(5,6,48),(6,6,48),(7,6,47),(8,6,47),(9,6,48),(10,6,47),(11,6,47),(12,6,46),(13,6,48),(14,6,48),(15,6,47),(16,6,46),(17,6,48),(18,6,47),(19,6,63),(20,6,46),(21,6,48),(22,6,63),(23,6,47),(24,6,46),(25,6,48),(26,6,47),(27,6,47),(28,6,46),(29,6,48),(30,6,63),(31,6,47),(32,6,46),(33,6,48),(34,6,48),(35,6,47),(36,6,46),(37,6,48),(38,6,47),(39,6,51),(40,6,46),(41,6,48),(42,6,47),(43,6,47),(44,6,46),(45,6,47),(46,6,48),(47,6,48),(48,6,47),(49,6,46),(50,6,48),(51,6,48),(52,6,47),(53,6,46),(54,6,48),(55,6,47),(56,6,47),(57,6,46),(58,6,48),(59,6,47),(60,6,46),(61,6,55),(62,6,48),(63,6,48),(64,6,47),(65,6,46),(66,6,48),(67,6,47),(68,6,46),(69,6,47),(70,6,48),(71,6,48),(72,6,47),(73,6,46),(74,6,48),(75,6,47),(76,6,48),(77,6,46),(78,6,48),(79,6,47),(80,6,46),(81,6,55),(82,6,48),(83,6,47),(84,6,46),(85,6,48),(86,6,47),(87,6,46),(88,6,48),(89,6,48),(90,6,47),(91,6,47),(92,6,46),(93,6,65),(94,6,66),(95,6,48),(96,6,47),(97,6,47),(98,6,46),(99,6,47),(100,6,49),(101,6,47),(102,6,48),(103,6,47),(104,6,46),(105,6,48),(106,6,47),(107,6,46),(108,6,48),(109,6,48),(110,6,47),(111,6,46),(112,6,63),(113,6,49),(114,6,48),(115,6,48),(116,6,47),(117,6,46),(118,6,48),(119,6,47),(120,6,46),(121,6,46),(122,6,48),(123,6,47),(124,6,46),(125,6,55),(126,6,53),(127,6,55),(128,6,55),(129,6,55),(130,6,66),(131,6,55),(132,6,55),(133,6,55),(134,6,55),(135,6,55),(136,6,48),(137,6,47),(138,6,46),(139,6,55),(140,6,55),(141,6,55),(142,6,55),(143,6,55),(144,6,55),(145,6,55),(146,6,55),(147,6,53),(148,6,48),(149,6,47),(150,6,46),(151,6,55),(152,6,55),(153,6,55),(154,6,55),(155,6,48),(156,6,47),(157,6,46),(158,6,55),(159,6,55),(160,6,55),(161,6,55),(162,6,55),(163,6,55),(164,6,48),(165,6,47),(166,6,46),(167,6,65),(168,6,48),(169,6,47),(170,6,46),(171,6,55),(172,6,55),(173,6,55),(174,6,55),(175,6,48),(176,6,47),(177,6,46),(178,6,55),(179,6,55),(180,6,55),(181,6,55),(182,6,48),(183,6,47),(184,6,46),(185,6,55),(186,6,55),(187,6,55),(188,6,55),(189,6,55),(190,6,55),(191,6,55),(192,6,55),(193,6,55),(194,6,48),(195,6,57),(196,6,47),(197,6,46),(198,6,57),(199,6,55),(200,6,55),(201,6,48),(202,6,57),(203,6,47),(204,6,46),(205,6,57),(206,6,48),(207,6,47),(208,6,46),(209,6,48),(210,6,57),(211,6,47),(212,6,46),(213,6,48),(214,6,57),(215,6,47),(216,6,46),(217,6,48),(218,6,57),(219,6,47),(220,6,46),(221,6,48),(222,6,57),(223,6,47),(224,6,46),(225,6,48),(226,6,57),(227,6,47),(228,6,46),(229,6,48),(230,6,57),(231,6,47),(232,6,46),(233,6,48),(234,6,47),(235,6,57),(236,6,46),(237,6,48),(238,6,57),(239,6,47),(240,6,46),(241,6,55),(242,6,57),(243,6,55),(244,6,55),(245,6,55),(246,6,55),(247,6,55),(248,6,55),(249,6,57),(250,6,55),(251,6,55),(252,6,55),(253,6,55),(254,6,48),(255,6,57),(256,6,47),(257,6,46),(258,6,48),(259,6,57),(260,6,47),(261,6,46),(262,6,48),(263,6,57),(264,6,47),(265,6,46),(266,6,57),(267,6,48),(268,6,47),(269,6,46),(270,6,48),(271,6,57),(272,6,47),(273,6,46),(274,6,57),(275,6,48),(276,6,47),(277,6,46),(278,6,48),(279,6,47),(280,6,57),(281,6,46),(282,6,48),(283,6,57),(284,6,47),(285,6,46),(286,6,48),(287,6,57),(288,6,47),(289,6,46),(290,6,57),(291,6,48),(292,6,47),(293,6,46),(294,6,48),(295,6,57),(296,6,47),(297,6,46),(298,6,48),(299,6,57),(300,6,47),(301,6,46),(302,6,57),(303,6,48),(304,6,47),(305,6,46),(306,6,48),(307,6,57),(308,6,47),(309,6,46),(310,6,48),(311,6,47),(312,6,46),(313,6,57),(314,6,57),(315,6,48),(316,6,47),(317,6,46),(318,6,48),(319,6,57),(320,6,47),(321,6,46),(322,6,48),(323,6,57),(324,6,47),(325,6,46),(326,6,48),(327,6,47),(328,6,46),(329,6,55),(330,6,53),(331,6,48),(332,6,57),(333,6,47),(334,6,57),(335,6,46),(336,6,48),(337,6,57),(338,6,47),(339,6,57),(340,6,46),(341,6,57),(342,6,55),(343,6,55),(344,6,55),(345,6,55),(346,6,57),(347,6,55),(348,6,57),(349,6,57),(350,6,57),(351,6,57),(352,6,57),(353,6,57),(354,6,57),(355,6,55),(356,6,55),(357,6,55),(358,6,57),(359,6,55),(360,6,57),(361,6,57),(362,6,48),(363,6,57),(364,6,47),(365,6,57),(366,6,46),(367,6,57),(368,6,57),(369,6,57),(370,6,57),(371,6,57),(372,6,57),(373,6,48),(374,6,57),(375,6,47),(376,6,57),(377,6,46),(378,6,57),(379,6,57),(380,6,48),(381,6,57),(382,6,47),(383,6,46),(384,6,57),(385,6,48),(386,6,57),(387,6,47),(388,6,57),(389,6,46),(390,6,48),(391,6,57),(392,6,47),(393,6,57),(394,6,46),(395,6,48),(396,6,47),(397,6,57),(398,6,46),(399,6,57),(400,6,48),(401,6,57),(402,6,47),(403,6,57),(404,6,46),(405,6,48),(406,6,47),(407,6,46),(408,6,57),(409,6,57),(410,6,48),(411,6,57),(412,6,47),(413,6,57),(414,6,46),(415,6,57),(416,6,57),(417,6,48),(418,6,57),(419,6,47),(420,6,57),(421,6,46),(422,6,57),(423,6,57),(424,6,57),(425,6,57),(426,6,48),(427,6,57),(428,6,47),(429,6,46),(430,6,48),(431,6,57),(432,6,47),(433,6,46),(434,6,66),(435,6,66),(436,6,66),(437,6,66),(438,6,66),(439,6,66),(440,6,66),(441,6,66),(442,6,48),(443,6,57),(444,6,47),(445,6,46),(446,6,48),(447,6,47),(448,6,46),(449,6,55),(450,6,53),(451,6,57),(452,6,48),(453,6,47),(454,6,46),(455,6,57),(456,6,48),(457,6,47),(458,6,46),(459,6,48),(460,6,47),(461,6,46),(462,6,57),(463,6,48),(464,6,57),(465,6,47),(466,6,46),(467,6,48),(468,6,57),(469,6,47),(470,6,46),(471,6,48),(472,6,57),(473,6,47),(474,6,46),(475,6,48),(476,6,57),(477,6,47),(478,6,46),(479,6,48),(480,6,57),(481,6,47),(482,6,46),(483,6,48),(484,6,57),(485,6,47),(486,6,46),(487,6,57),(488,6,48),(489,6,57),(490,6,47),(491,6,46),(492,6,57),(493,6,57),(494,6,48),(495,6,57),(496,6,47),(497,6,46),(498,6,48),(499,6,57),(500,6,47),(501,6,46),(502,6,48),(503,6,57),(504,6,47),(505,6,46),(506,6,48),(507,6,57),(508,6,47),(509,6,46),(510,6,48),(511,6,57),(512,6,47),(513,6,46),(514,6,48),(515,6,47),(516,6,46),(517,6,55),(518,6,48),(519,6,57),(520,6,47),(521,6,46),(522,6,48),(523,6,57),(524,6,47),(525,6,46),(526,6,48),(527,6,57),(528,6,47),(529,6,46),(530,6,48),(531,6,47),(532,6,57),(533,6,46),(534,6,48),(535,6,57),(536,6,47),(537,6,46),(538,6,48),(539,6,57),(540,6,47),(541,6,46),(542,6,48),(543,6,57),(544,6,47),(545,6,46);
/*!40000 ALTER TABLE `l_user_operate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_category`
--

DROP TABLE IF EXISTS `r_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '类别名称',
  `ord` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_category`
--

LOCK TABLES `r_category` WRITE;
/*!40000 ALTER TABLE `r_category` DISABLE KEYS */;
INSERT INTO `r_category` VALUES (6,'单词听写',1,''),(7,'识别生字',2,'sdfsr'),(8,'朗读材料',4,''),(9,'图画演示',3,'');
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
  PRIMARY KEY (`id`),
  KEY `gradeId_idx` (`gradeId`),
  KEY `fk_course_subject_idx` (`subjectId`),
  CONSTRAINT `fk_course_grade` FOREIGN KEY (`gradeId`) REFERENCES `r_grade` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_subject` FOREIGN KEY (`subjectId`) REFERENCES `r_subject` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_course`
--

LOCK TABLES `r_course` WRITE;
/*!40000 ALTER TABLE `r_course` DISABLE KEYS */;
INSERT INTO `r_course` VALUES (9,'第二章 乘除法',8,2,''),(10,'第三章 约分',9,2,'efwe'),(13,'第四课 虎门销烟',9,3,''),(15,'jkasjdkas',12,5,''),(16,'efggedrg',13,8,''),(17,'日光灯如果',12,7,'是的范德萨'),(18,'阿斯顿发送到',14,6,''),(19,'随碟附送',15,9,''),(20,'sefsdfwsd',9,4,'sdfs'),(21,'as',15,9,''),(22,'sdfsad',9,4,''),(23,'wewqewe',12,3,''),(24,'临时',1,2,'测试用'),(25,'abc',1,2,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_grade`
--

LOCK TABLES `r_grade` WRITE;
/*!40000 ALTER TABLE `r_grade` DISABLE KEYS */;
INSERT INTO `r_grade` VALUES (1,'一年级','243234'),(8,'二年级',''),(9,'三年级','二手房是的'),(10,'四年级','所答非所问'),(11,'五年级','fdgd'),(12,'六年级','546456'),(13,'七年级','2433245'),(14,'八年级',''),(15,'九年级','');
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
  `price` double DEFAULT '0' COMMENT '价格',
  `viewTimes` int(11) DEFAULT '0' COMMENT '访问次数',
  `useTimes` int(11) DEFAULT '0' COMMENT '下载或者使用次数',
  `url` varchar(255) NOT NULL,
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_source_course_idx` (`courseId`),
  CONSTRAINT `fk_source_course` FOREIGN KEY (`courseId`) REFERENCES `r_course` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source`
--

LOCK TABLES `r_source` WRITE;
/*!40000 ALTER TABLE `r_source` DISABLE KEYS */;
INSERT INTO `r_source` VALUES (16,'电热锅人',18,'电热锅人','动画','pdf','','10813415','','','','2013-10-20 17:21:54','0',0,0,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310201721387HeadFirstJava2.pdf',6),(19,'asdas',15,'asdas','','dll','','4055504','','','','2013-10-23 11:51:19','0',0,1,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231151179pdf.dll',6),(20,'阿迪四川省',16,'阿迪四川省','','dll','','2099664','','','','2013-10-23 11:56:12','0',0,1,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231156003npchrome_frame.dll',6),(22,'sfsd',9,'sfsd','','nexe','','5705472','','','','2013-10-23 19:22:49','0',0,7,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231922364nacl_irt_x86_32.nexe',6),(23,'科研处科研经费报账发票说明',10,'科研处科研经费报账发票说明','','doc','','23552','','','','2013-10-26 12:18:06','0',0,40,12,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261217383科研处科研经费报账发票说明.doc',6),(24,'苏打水',9,'苏打水','','txt','','2341','','','','2013-10-26 19:51:37','0',0,11,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261951365利用struts2-convention-plugin注解配置文件下载.txt',6),(25,'水电费而非太热',9,'水电费而非太热','','txt','','2341','','','','2013-10-26 19:51:54','0',0,1,2,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261951463利用struts2-convention-plugin注解配置文件下载.txt',6),(26,'水电费水电费水电费是的',9,'水电费水电费水电费是的','','txt','','2341','','','','2013-10-26 19:52:10','0',0,1,1,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261952018利用struts2-convention-plugin注解配置文件下载.txt',6),(27,'excel',25,'excel','','xls','','7680','','','','2013-11-08 14:34:58','0',100,5,1,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\20131108143439511.xls',6),(28,'测试用户只看的见自己的资源',24,'测试用户只看的见自己的资源','文档','xls','','7680','','','','2013-11-24 15:24:53','0',0,0,0,'E:\\WebWorkspace\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\20131124152435111.xls',21),(29,'测试用户上传后树的刷新',13,'测试用户上传后树的刷新','文档','xls','','7680','','','','2013-11-24 15:28:31','0',0,0,0,'E:\\WebWorkspace\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\20131124152803611.xls',21),(30,'测试预览',13,'测试预览','视频','mp4','','128335773','','','','2013-11-24 19:10:21','0',0,16,6,'E:\\WebWorkspace\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201311241909381test.mp4',6);
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
  PRIMARY KEY (`id`),
  KEY `fk_sourceId_idx` (`sourceId`),
  KEY `fk_categoryId_idx` (`categoryId`),
  CONSTRAINT `fk_categoryId` FOREIGN KEY (`categoryId`) REFERENCES `r_category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_sourceId` FOREIGN KEY (`sourceId`) REFERENCES `r_source` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COMMENT='资源和类别的挂接表，一个资源有多个类别。一个类别也可以属于多个资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source_category_join`
--

LOCK TABLES `r_source_category_join` WRITE;
/*!40000 ALTER TABLE `r_source_category_join` DISABLE KEYS */;
INSERT INTO `r_source_category_join` VALUES (67,19,6),(68,19,7),(69,19,8),(70,19,9),(115,20,6),(116,20,7),(117,20,8),(118,16,7),(119,16,6),(120,16,8),(122,22,6),(123,22,7),(124,22,8),(125,23,6),(126,23,7),(127,23,8),(128,23,9),(129,24,6),(130,24,7),(131,24,8),(132,24,9),(133,25,6),(134,25,7),(135,25,8),(136,25,9),(137,26,6),(138,26,7),(139,26,8),(140,26,9),(141,27,6),(142,28,6),(143,29,8),(144,30,9);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='科目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_subject`
--

LOCK TABLES `r_subject` WRITE;
/*!40000 ALTER TABLE `r_subject` DISABLE KEYS */;
INSERT INTO `r_subject` VALUES (2,'数学',''),(3,'历史',''),(4,'自然',''),(5,'英语','六级'),(6,'大学英语','asda'),(7,'应用数学',''),(8,'大学物理',''),(9,'数据库','');
/*!40000 ALTER TABLE `r_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_topic`
--

DROP TABLE IF EXISTS `r_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '专题名称',
  `imageUrl` text,
  `description` text NOT NULL COMMENT '专题简介',
  `author` varchar(45) NOT NULL COMMENT '专题作者',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='专题资源\n专题的图片链接，外链地址，\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic`
--

LOCK TABLES `r_topic` WRITE;
/*!40000 ALTER TABLE `r_topic` DISABLE KEYS */;
INSERT INTO `r_topic` VALUES (1,'1',NULL,'2','3','4'),(2,'三笔字',NULL,'水电费·','阿斯达1',''),(3,'美术',NULL,'sdfs','风格大方',''),(6,'123',NULL,'1231','123','1231'),(7,'梵蒂冈的','F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\topic\\2013120815141412013111719475571.jpg','23123','12312','12312');
/*!40000 ALTER TABLE `r_topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `r_topic_BDEL` BEFORE DELETE ON r_topic FOR EACH ROW
BEGIN
	DELETE FROM r_topic_source_join WHERE r_topic_source_join.topicId = old.id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `r_topic_source`
--

DROP TABLE IF EXISTS `r_topic_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_topic_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicSubtitleId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `keyWords` text NOT NULL,
  `mediaType` varchar(45) DEFAULT NULL COMMENT '媒体类型，如：文本，ppt，视频等',
  `mediaFormat` varchar(45) DEFAULT NULL COMMENT '媒体格式，如：jpg，mp4等',
  `playTime` varchar(20) DEFAULT NULL COMMENT '播放时间，只有视频拥有这个属性',
  `fileSize` varchar(50) DEFAULT NULL COMMENT '文件大小',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `publisher` text COMMENT '出版社',
  `description` text COMMENT '描述',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `price` double DEFAULT NULL COMMENT '价格',
  `viewTimes` int(11) DEFAULT '0' COMMENT '访问次数',
  `useTimes` int(11) DEFAULT '0' COMMENT '下载或者使用次数',
  `url` varchar(255) NOT NULL,
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_sub_idx` (`topicSubtitleId`),
  CONSTRAINT `pk_sub` FOREIGN KEY (`topicSubtitleId`) REFERENCES `r_topic_subtitle` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic_source`
--

LOCK TABLES `r_topic_source` WRITE;
/*!40000 ALTER TABLE `r_topic_source` DISABLE KEYS */;
INSERT INTO `r_topic_source` VALUES (1,2,'色发送到','','','js','','240196','','','',NULL,0,NULL,NULL,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\topic\\201312081221345jquery-2.0.0.js',NULL);
/*!40000 ALTER TABLE `r_topic_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_topic_source_join`
--

DROP TABLE IF EXISTS `r_topic_source_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_topic_source_join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subtitleId` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  `topicId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_topic_source_idx` (`subtitleId`),
  KEY `fk_source_idx` (`sourceId`),
  CONSTRAINT `fk_source` FOREIGN KEY (`sourceId`) REFERENCES `r_source` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_subtitle` FOREIGN KEY (`subtitleId`) REFERENCES `r_topic_subtitle` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题资源挂接表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic_source_join`
--

LOCK TABLES `r_topic_source_join` WRITE;
/*!40000 ALTER TABLE `r_topic_source_join` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_topic_source_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_topic_subtitle`
--

DROP TABLE IF EXISTS `r_topic_subtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_topic_subtitle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicId` int(11) NOT NULL COMMENT '专题id',
  `subtitle` varchar(45) NOT NULL COMMENT '二级标题',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_tc_idx` (`topicId`),
  CONSTRAINT `fk_tc` FOREIGN KEY (`topicId`) REFERENCES `r_topic` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='专题的二级标题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic_subtitle`
--

LOCK TABLES `r_topic_subtitle` WRITE;
/*!40000 ALTER TABLE `r_topic_subtitle` DISABLE KEYS */;
INSERT INTO `r_topic_subtitle` VALUES (1,2,'钢笔字',''),(2,2,'粉笔字',''),(3,2,'毛笔字',''),(4,2,'213','');
/*!40000 ALTER TABLE `r_topic_subtitle` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_function`
--

LOCK TABLES `s_function` WRITE;
/*!40000 ALTER TABLE `s_function` DISABLE KEYS */;
INSERT INTO `s_function` VALUES (1,'add','新增'),(2,'delete','删除'),(3,'modify','修改'),(4,'query','查询'),(5,'refresh','刷新'),(6,'join','挂接'),(7,'modify_pwd','修改密码'),(8,'sort','排序'),(9,'modify_many','批量修改'),(10,'add_many','批量增加'),(11,'super_query','超级浏览权限'),(12,'add_subtitle','增加二级标题'),(13,'upload','上传资源');
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
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_menu`
--

LOCK TABLES `s_menu` WRITE;
/*!40000 ALTER TABLE `s_menu` DISABLE KEYS */;
INSERT INTO `s_menu` VALUES (40,-1,'用户管理','','',''),(41,-1,'资源库系统','','',''),(45,-1,'在线备课','','',''),(46,61,'菜单管理','App/System/Menu/MenuManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(47,40,'角色管理','App/System/Role/RoleManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(48,40,'用户管理','App/System/User/UserManage.html','1;2;3;6;7;9','./App/Lib/icons/32X32/product_169.gif'),(49,61,'功能管理','App/System/Function/FunctionManage.html','1;3','./App/Lib/icons/32X32/product_169.gif'),(51,41,'学科管理','App/Resources/Subject/SubjectManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(52,41,'年级管理','App/Resources/Grade/GradeManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(53,41,'类别管理','App/Resources/Category/CategoryManage.html','1;2;3;8','./App/Lib/icons/32X32/product_169.gif'),(54,41,'课程管理','App/Resources/Course/CourseManage.html','1;2;3;4;5','./App/Lib/icons/32X32/product_169.gif'),(55,41,'资源管理','App/Resources/Source/SourceManage.html','1;2;3;5;11','./App/Lib/icons/32X32/product_169.gif'),(56,-1,'专题系统','','',''),(57,41,'专题管理','App/Resources/Topic/TopicManage.html','1;2;3;6;12;13','./App/Lib/icons/32X32/product_169.gif'),(61,-1,'网站管理','','',''),(62,61,'页面生成','App/Website/Page/PageManage.html','5','./App/Lib/icons/32X32/product_169.gif'),(63,40,'学生管理','App/System/Student/StudentManage.html','1;2;3;9;10','./App/Lib/icons/32X32/product_169.gif'),(65,61,'新闻管理','App/Website/News/NewsManage.html','1;2;3;5','./App/Lib/icons/32X32/product_169.gif'),(66,61,'轮播图片管理','App/Website/Pictures/PicturesManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif');
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
  `createUserName` varchar(45) DEFAULT NULL,
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role`
--

LOCK TABLES `s_role` WRITE;
/*!40000 ALTER TABLE `s_role` DISABLE KEYS */;
INSERT INTO `s_role` VALUES (4,'管理员',NULL,'','超级管理员'),(5,'资源录入员',6,NULL,''),(6,'静态页面生成员',NULL,'匡静','asdas'),(7,'测试角色1号',6,'开发者',''),(8,'测试角色2号',NULL,NULL,''),(9,'测试角色3号',6,'开发者',''),(18,'管理员',6,'开发者','');
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
  PRIMARY KEY (`id`),
  KEY `fk_role_idx` (`roleId`),
  KEY `fk_menu_idx` (`menuId`),
  CONSTRAINT `fk_menu` FOREIGN KEY (`menuId`) REFERENCES `s_menu` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_role` FOREIGN KEY (`roleId`) REFERENCES `s_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role_menu_join`
--

LOCK TABLES `s_role_menu_join` WRITE;
/*!40000 ALTER TABLE `s_role_menu_join` DISABLE KEYS */;
INSERT INTO `s_role_menu_join` VALUES (228,6,62,'5'),(229,7,46,'1;3'),(230,7,47,'1;2;3;6'),(231,7,48,'1;2;3;6;7'),(421,18,46,'1;3'),(422,18,47,'1;2;3;6'),(423,18,48,'1;2;3;6;7;10'),(424,18,49,'1;3'),(425,18,51,'1;2;3'),(426,18,52,'1;2;3'),(427,18,53,'1;2;3;8'),(428,18,54,'1;2;3;4;5'),(429,18,55,'1;2;3;5'),(486,5,55,'1;2;3;5'),(515,4,46,'1;2;3'),(516,4,47,'1;2;3;6'),(517,4,48,'1;2;3;6;7;9'),(518,4,49,'1;3'),(519,4,51,'1;2;3'),(520,4,52,'1;2;3'),(521,4,53,'1;2;3;8'),(522,4,54,'1;2;3;4;5'),(523,4,55,'1;2;3;5;11'),(524,4,57,'1;2;3;6;12;13'),(525,4,62,'5'),(526,4,63,'1;2;3;9;10'),(527,4,65,'1;2;3;5'),(528,4,66,'1;2;3');
/*!40000 ALTER TABLE `s_role_menu_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_student`
--

DROP TABLE IF EXISTS `s_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL COMMENT '名字',
  `number` varchar(20) NOT NULL COMMENT '学号',
  `department` varchar(50) NOT NULL COMMENT '系部',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `entranceTime` varchar(20) NOT NULL COMMENT '入学年份',
  `balance` int(11) DEFAULT '0' COMMENT '充值余额，默认为0',
  `telephone` varchar(15) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_student`
--

LOCK TABLES `s_student` WRITE;
/*!40000 ALTER TABLE `s_student` DISABLE KEYS */;
INSERT INTO `s_student` VALUES (39,'1234567','123456','aa','1234567','数学系','信息与计算科学','2010',100,'13245654','2013-11-24',NULL),(40,'1234568','123456','bb','1234568','信工系','计算机科学与技术','2010',100,'13546454','2013-11-24',NULL),(41,'1234569','123456','cc','1234569','叫可惜','应用数学','2011',100,'45454545','2013-11-24',NULL);
/*!40000 ALTER TABLE `s_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_teacher`
--

DROP TABLE IF EXISTS `s_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户登录名字',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `idcard` varchar(45) NOT NULL COMMENT '身份证',
  `qq` varchar(15) NOT NULL,
  `telephone` varchar(15) NOT NULL COMMENT '手机号码',
  `department` varchar(40) NOT NULL COMMENT '系部或部门',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `createUserId` int(11) DEFAULT NULL COMMENT '创建人id',
  `balance` int(11) DEFAULT '0' COMMENT '资源币',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='特殊角色老师。';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_teacher`
--

LOCK TABLES `s_teacher` WRITE;
/*!40000 ALTER TABLE `s_teacher` DISABLE KEYS */;
INSERT INTO `s_teacher` VALUES (1,'123','123','123','123','123','123','123',NULL,NULL,0,'');
/*!40000 ALTER TABLE `s_teacher` ENABLE KEYS */;
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
  `email` varchar(45) DEFAULT NULL,
  `birth` date DEFAULT NULL COMMENT '生日',
  `department` varchar(40) NOT NULL COMMENT '部门',
  `balance` int(11) DEFAULT '0',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `latestLoginDate` date DEFAULT NULL COMMENT '最后登录时间',
  `setting` varchar(500) DEFAULT NULL COMMENT '设置（用于涉及用户个人的设置）',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `idcard_UNIQUE` (`idcard`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (6,'admin','123456','管理员','1232324','0','678768','787',NULL,'2013-10-07','8678',0,'2013-11-30','2013-12-08',NULL,NULL),(8,'我叫测试','123456','sjakdjksa','430221199103102526','0','646208563','15575847475',NULL,'2013-08-07','sdhs',0,'2013-11-30',NULL,NULL,''),(9,'测试用户1号','2','开发者','123456789123456789','0','646208563','11111111111',NULL,'2013-10-14','公管中心',0,'2013-05-30',NULL,NULL,''),(11,'我会告诉你所有的密码都是123456','123456','开发者','123456789987456123','1','23434','12343235',NULL,'2013-10-01','俺的沙发',0,'2013-06-30',NULL,NULL,'23423'),(12,'asdasdasdasdas','111111','awd','12322435','0','1231231','12312312312',NULL,'2013-10-07','12312321',0,'2013-07-30',NULL,NULL,''),(18,'asfg','2','tf','4324','0','23423','2342','23423','2013-11-18','342',0,'2013-08-30','2013-12-02',NULL,'234234'),(19,'asasdasd','123','aesdf','sdfsadf','0','asdfsd','asdfsa','asdfsa','2013-11-05','asfsad',0,'2013-09-30',NULL,NULL,'asdfsd'),(20,'2131231231','123','123','rfe','0','234234','23423','23423','2013-11-04','12312',0,'2013-09-30',NULL,NULL,'23423'),(21,'2','2','2','2','1','2','2','2','2013-11-05','2',0,'2013-10-30',NULL,NULL,'2'),(23,'admin2','123','dsgd','sdfsd','0','sdfsd','sdfsd','sdfs','2013-11-13','sdfsd',0,'2013-10-30',NULL,NULL,'sdfsd');
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user_habit`
--

DROP TABLE IF EXISTS `s_user_habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_user_habit` (
  `userId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  `times` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户喜好表，用于推荐系统';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_habit`
--

LOCK TABLES `s_user_habit` WRITE;
/*!40000 ALTER TABLE `s_user_habit` DISABLE KEYS */;
INSERT INTO `s_user_habit` VALUES (6,47,15),(6,48,20);
/*!40000 ALTER TABLE `s_user_habit` ENABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`userId`),
  KEY `fk_role_idx` (`roleId`),
  CONSTRAINT `fk_role2` FOREIGN KEY (`roleId`) REFERENCES `s_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `s_user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_role_join`
--

LOCK TABLES `s_user_role_join` WRITE;
/*!40000 ALTER TABLE `s_user_role_join` DISABLE KEYS */;
INSERT INTO `s_user_role_join` VALUES (69,8,4),(70,9,6),(72,9,8),(73,9,9),(82,11,6),(83,11,7),(84,11,8),(85,11,9),(86,6,4),(90,18,5),(91,21,5);
/*!40000 ALTER TABLE `s_user_role_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_chart_category_count`
--

DROP TABLE IF EXISTS `v_chart_category_count`;
/*!50001 DROP VIEW IF EXISTS `v_chart_category_count`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_chart_category_count` (
  `name` tinyint NOT NULL,
  `num` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_chart_grade_count`
--

DROP TABLE IF EXISTS `v_chart_grade_count`;
/*!50001 DROP VIEW IF EXISTS `v_chart_grade_count`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_chart_grade_count` (
  `name` tinyint NOT NULL,
  `num` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_chart_subject_count`
--

DROP TABLE IF EXISTS `v_chart_subject_count`;
/*!50001 DROP VIEW IF EXISTS `v_chart_subject_count`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_chart_subject_count` (
  `name` tinyint NOT NULL,
  `num` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_chart_top_user_source`
--

DROP TABLE IF EXISTS `v_chart_top_user_source`;
/*!50001 DROP VIEW IF EXISTS `v_chart_top_user_source`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_chart_top_user_source` (
  `name` tinyint NOT NULL,
  `num` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_chart_user_count`
--

DROP TABLE IF EXISTS `v_chart_user_count`;
/*!50001 DROP VIEW IF EXISTS `v_chart_user_count`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_chart_user_count` (
  `num` tinyint NOT NULL,
  `month` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_course_grade_subject`
--

DROP TABLE IF EXISTS `v_course_grade_subject`;
/*!50001 DROP VIEW IF EXISTS `v_course_grade_subject`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_course_grade_subject` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `gradeId` tinyint NOT NULL,
  `remark` tinyint NOT NULL,
  `gradeName` tinyint NOT NULL,
  `subjectId` tinyint NOT NULL,
  `subjectName` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_menu_menu`
--

DROP TABLE IF EXISTS `v_menu_menu`;
/*!50001 DROP VIEW IF EXISTS `v_menu_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_menu_menu` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `functionIdList` tinyint NOT NULL,
  `icon` tinyint NOT NULL,
  `parentId` tinyint NOT NULL,
  `parentName` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
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
-- Temporary table structure for view `v_topic_source`
--

DROP TABLE IF EXISTS `v_topic_source`;
/*!50001 DROP VIEW IF EXISTS `v_topic_source`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_topic_source` (
  `id` tinyint NOT NULL,
  `sourceId` tinyint NOT NULL,
  `sourceName` tinyint NOT NULL,
  `courseId` tinyint NOT NULL,
  `keyWords` tinyint NOT NULL,
  `mediaType` tinyint NOT NULL,
  `mediaFormat` tinyint NOT NULL,
  `playTime` tinyint NOT NULL,
  `fileSize` tinyint NOT NULL,
  `sourceAuthor` tinyint NOT NULL,
  `publisher` tinyint NOT NULL,
  `sourceDescription` tinyint NOT NULL,
  `createDate` tinyint NOT NULL,
  `approvalStatus` tinyint NOT NULL,
  `price` tinyint NOT NULL,
  `viewTimes` tinyint NOT NULL,
  `useTimes` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `createUserId` tinyint NOT NULL,
  `topicId` tinyint NOT NULL,
  `subtitleId` tinyint NOT NULL,
  `topicName` tinyint NOT NULL,
  `topicDescription` tinyint NOT NULL,
  `topicAuthor` tinyint NOT NULL,
  `remark` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `v_topic_subtiltle_source`
--

DROP TABLE IF EXISTS `v_topic_subtiltle_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `v_topic_subtiltle_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `createUserId` int(11) DEFAULT NULL,
  `fileSize` varchar(255) DEFAULT NULL,
  `keyWords` varchar(255) DEFAULT NULL,
  `mediaFormat` varchar(255) DEFAULT NULL,
  `mediaType` varchar(255) DEFAULT NULL,
  `playTime` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sourceAuthor` varchar(255) DEFAULT NULL,
  `sourceDescription` varchar(255) DEFAULT NULL,
  `sourceName` varchar(255) DEFAULT NULL,
  `subtitleId` int(11) DEFAULT NULL,
  `subtitleName` varchar(255) DEFAULT NULL,
  `topicAuthor` varchar(255) DEFAULT NULL,
  `topicDescription` varchar(255) DEFAULT NULL,
  `topicId` int(11) DEFAULT NULL,
  `topicName` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `useTimes` int(11) DEFAULT NULL,
  `viewTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `v_topic_subtiltle_source`
--

LOCK TABLES `v_topic_subtiltle_source` WRITE;
/*!40000 ALTER TABLE `v_topic_subtiltle_source` DISABLE KEYS */;
/*!40000 ALTER TABLE `v_topic_subtiltle_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_topic_subtitle_source`
--

DROP TABLE IF EXISTS `v_topic_subtitle_source`;
/*!50001 DROP VIEW IF EXISTS `v_topic_subtitle_source`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_topic_subtitle_source` (
  `id` tinyint NOT NULL,
  `sourceName` tinyint NOT NULL,
  `keyWords` tinyint NOT NULL,
  `mediaType` tinyint NOT NULL,
  `mediaFormat` tinyint NOT NULL,
  `playTime` tinyint NOT NULL,
  `fileSize` tinyint NOT NULL,
  `sourceAuthor` tinyint NOT NULL,
  `publisher` tinyint NOT NULL,
  `sourceDescription` tinyint NOT NULL,
  `createDate` tinyint NOT NULL,
  `price` tinyint NOT NULL,
  `viewTimes` tinyint NOT NULL,
  `useTimes` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `createUserId` tinyint NOT NULL,
  `topicId` tinyint NOT NULL,
  `subtitleId` tinyint NOT NULL,
  `subtitleName` tinyint NOT NULL,
  `topicName` tinyint NOT NULL,
  `topicDescription` tinyint NOT NULL,
  `topicAuthor` tinyint NOT NULL,
  `remark` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_user_habit`
--

DROP TABLE IF EXISTS `v_user_habit`;
/*!50001 DROP VIEW IF EXISTS `v_user_habit`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_user_habit` (
  `id` tinyint NOT NULL,
  `menuId` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `url` tinyint NOT NULL
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
-- Temporary table structure for view `v_user_role_menu`
--

DROP TABLE IF EXISTS `v_user_role_menu`;
/*!50001 DROP VIEW IF EXISTS `v_user_role_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_user_role_menu` (
  `roleId` tinyint NOT NULL,
  `menuId` tinyint NOT NULL,
  `functionIdList` tinyint NOT NULL,
  `userId` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_chart_category_count`
--

/*!50001 DROP TABLE IF EXISTS `v_chart_category_count`*/;
/*!50001 DROP VIEW IF EXISTS `v_chart_category_count`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_chart_category_count` AS select `r_category`.`name` AS `name`,count(0) AS `num` from (`r_source_category_join` join `r_category`) where (`r_category`.`id` = `r_source_category_join`.`categoryId`) group by `r_source_category_join`.`categoryId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_chart_grade_count`
--

/*!50001 DROP TABLE IF EXISTS `v_chart_grade_count`*/;
/*!50001 DROP VIEW IF EXISTS `v_chart_grade_count`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_chart_grade_count` AS select `t2`.`name` AS `name`,count(0) AS `num` from ((`r_source` `t1` join `r_grade` `t2`) join `r_course` `t3`) where ((`t1`.`courseId` = `t3`.`id`) and (`t3`.`gradeId` = `t2`.`id`)) group by `t2`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_chart_subject_count`
--

/*!50001 DROP TABLE IF EXISTS `v_chart_subject_count`*/;
/*!50001 DROP VIEW IF EXISTS `v_chart_subject_count`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_chart_subject_count` AS select `t2`.`name` AS `name`,count(0) AS `num` from ((`r_source` `t1` join `r_subject` `t2`) join `r_course` `t3`) where ((`t1`.`courseId` = `t3`.`id`) and (`t3`.`subjectId` = `t2`.`id`)) group by `t2`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_chart_top_user_source`
--

/*!50001 DROP TABLE IF EXISTS `v_chart_top_user_source`*/;
/*!50001 DROP VIEW IF EXISTS `v_chart_top_user_source`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_chart_top_user_source` AS select `s_user`.`name` AS `name`,count(0) AS `num` from (`r_source` join `s_user`) where (`s_user`.`id` = `r_source`.`createUserId`) group by `r_source`.`createUserId` limit 0,8 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_chart_user_count`
--

/*!50001 DROP TABLE IF EXISTS `v_chart_user_count`*/;
/*!50001 DROP VIEW IF EXISTS `v_chart_user_count`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_chart_user_count` AS select count(0) AS `num`,month(`s_user`.`createDate`) AS `month` from `s_user` where (month(`s_user`.`createDate`) between month((now() + interval -(8) month)) and month(now())) group by month(`s_user`.`createDate`) order by month(`s_user`.`createDate`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_course_grade_subject`
--

/*!50001 DROP TABLE IF EXISTS `v_course_grade_subject`*/;
/*!50001 DROP VIEW IF EXISTS `v_course_grade_subject`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_course_grade_subject` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`gradeId` AS `gradeId`,`t1`.`remark` AS `remark`,`t3`.`name` AS `gradeName`,`t1`.`subjectId` AS `subjectId`,`t2`.`name` AS `subjectName` from ((`r_course` `t1` join `r_subject` `t2` on((`t1`.`subjectId` = `t2`.`id`))) join `r_grade` `t3` on((`t1`.`gradeId` = `t3`.`id`))) order by `t1`.`gradeId`,`t1`.`subjectId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_menu_menu`
--

/*!50001 DROP TABLE IF EXISTS `v_menu_menu`*/;
/*!50001 DROP VIEW IF EXISTS `v_menu_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_menu_menu` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`url` AS `url`,`t1`.`functionIdList` AS `functionIdList`,`t1`.`icon` AS `icon`,`t1`.`parentId` AS `parentId`,`t2`.`name` AS `parentName` from (`s_menu` `t1` join `s_menu` `t2` on((`t2`.`id` = `t1`.`parentId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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
/*!50001 VIEW `v_source` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`courseId` AS `courseId`,`t2`.`name` AS `courseName`,`t3`.`id` AS `gradeId`,`t3`.`name` AS `gradeName`,`t4`.`id` AS `subjectId`,`t4`.`name` AS `subjectName`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `author`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `description`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t5`.`name` AS `createUserName`,group_concat(`t7`.`id` order by `t7`.`ord` ASC separator ',') AS `categoryIdList`,group_concat(`t7`.`name` order by `t7`.`ord` ASC separator ',') AS `categoryNameList` from ((((((`r_source` `t1` join `r_course` `t2` on((`t1`.`courseId` = `t2`.`id`))) join `r_grade` `t3` on((`t2`.`gradeId` = `t3`.`id`))) join `r_subject` `t4` on((`t2`.`subjectId` = `t4`.`id`))) join `s_user` `t5` on((`t1`.`createUserId` = `t5`.`id`))) join `r_source_category_join` `t6` on((`t1`.`id` = `t6`.`sourceId`))) join `r_category` `t7` on((`t7`.`id` = `t6`.`categoryId`))) group by `t6`.`sourceId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_topic_source`
--

/*!50001 DROP TABLE IF EXISTS `v_topic_source`*/;
/*!50001 DROP VIEW IF EXISTS `v_topic_source`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_topic_source` AS select `t3`.`id` AS `id`,`t1`.`id` AS `sourceId`,`t1`.`name` AS `sourceName`,`t1`.`courseId` AS `courseId`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `sourceAuthor`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `sourceDescription`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t2`.`id` AS `topicId`,`t4`.`id` AS `subtitleId`,`t2`.`name` AS `topicName`,`t2`.`description` AS `topicDescription`,`t2`.`author` AS `topicAuthor`,`t2`.`remark` AS `remark` from (((`r_topic_source_join` `t3` join `r_source` `t1` on((`t3`.`sourceId` = `t1`.`id`))) join `r_topic_subtitle` `t4` on((`t3`.`subtitleId` = `t4`.`id`))) join `r_topic` `t2` on((`t4`.`topicId` = `t2`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_topic_subtitle_source`
--

/*!50001 DROP TABLE IF EXISTS `v_topic_subtitle_source`*/;
/*!50001 DROP VIEW IF EXISTS `v_topic_subtitle_source`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_topic_subtitle_source` AS select `t3`.`id` AS `id`,`t1`.`name` AS `sourceName`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `sourceAuthor`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `sourceDescription`,`t1`.`createDate` AS `createDate`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t3`.`id` AS `topicId`,`t2`.`id` AS `subtitleId`,`t2`.`subtitle` AS `subtitleName`,`t3`.`name` AS `topicName`,`t3`.`description` AS `topicDescription`,`t3`.`author` AS `topicAuthor`,`t3`.`remark` AS `remark` from ((`r_topic_source` `t1` join `r_topic_subtitle` `t2` on((`t1`.`topicSubtitleId` = `t2`.`id`))) join `r_topic` `t3` on((`t2`.`topicId` = `t2`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_user_habit`
--

/*!50001 DROP TABLE IF EXISTS `v_user_habit`*/;
/*!50001 DROP VIEW IF EXISTS `v_user_habit`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_habit` AS select `u`.`id` AS `id`,`m`.`id` AS `menuId`,`m`.`name` AS `name`,`m`.`url` AS `url` from ((`s_user_habit` `uh` join `s_user` `u`) join `s_menu` `m`) where ((`uh`.`userId` = `u`.`id`) and (`uh`.`menuId` = `m`.`id`) and (`uh`.`times` > 10)) order by `uh`.`times` limit 0,6 */;
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

--
-- Final view structure for view `v_user_role_menu`
--

/*!50001 DROP TABLE IF EXISTS `v_user_role_menu`*/;
/*!50001 DROP VIEW IF EXISTS `v_user_role_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_role_menu` AS select `t2`.`id` AS `roleId`,`t1`.`menuId` AS `menuId`,`t1`.`functionIdList` AS `functionIdList`,`t5`.`id` AS `userId` from (((`s_role_menu_join` `t1` join `s_role` `t2` on((`t1`.`roleId` = `t2`.`id`))) join `s_user_role_join` `t4` on((`t2`.`id` = `t4`.`roleId`))) join `s_user` `t5` on((`t4`.`userId` = `t5`.`id`))) */;
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

-- Dump completed on 2013-12-08 17:46:43
