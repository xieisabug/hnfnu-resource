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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_pictures`
--

LOCK TABLES `f_pictures` WRITE;
/*!40000 ALTER TABLE `f_pictures` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5019 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_user_operate`
--

LOCK TABLES `l_user_operate` WRITE;
/*!40000 ALTER TABLE `l_user_operate` DISABLE KEYS */;
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
  `groupId` int(11) NOT NULL COMMENT '所属分组id',
  `ord` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`),
  KEY `category_group_fk_idx` (`groupId`),
  CONSTRAINT `category_group_fk` FOREIGN KEY (`groupId`) REFERENCES `r_group` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_category`
--

LOCK TABLES `r_category` WRITE;
/*!40000 ALTER TABLE `r_category` DISABLE KEYS */;
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
  `imageUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gradeId_idx` (`gradeId`),
  KEY `fk_course_subject_idx` (`subjectId`),
  CONSTRAINT `fk_course_grade` FOREIGN KEY (`gradeId`) REFERENCES `r_grade` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_subject` FOREIGN KEY (`subjectId`) REFERENCES `r_subject` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_course`
--

LOCK TABLES `r_course` WRITE;
/*!40000 ALTER TABLE `r_course` DISABLE KEYS */;
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
  `groupId` int(11) NOT NULL COMMENT '分组id',
  `isDisplay` int(11) DEFAULT '0',
  `remark` text,
  PRIMARY KEY (`id`),
  KEY `grade_group_fk_idx` (`groupId`),
  CONSTRAINT `grade_group_fk` FOREIGN KEY (`groupId`) REFERENCES `r_group` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_grade`
--

LOCK TABLES `r_grade` WRITE;
/*!40000 ALTER TABLE `r_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_group`
--

DROP TABLE IF EXISTS `r_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `name` varchar(100) NOT NULL COMMENT '分组名字',
  `style` int(11) DEFAULT NULL COMMENT '分组前台样式',
  `isDisplay` int(11) NOT NULL COMMENT '是否显示在主界面',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='分组表，一个组代表一个栏目。比如大学，小学。';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_group`
--

LOCK TABLES `r_group` WRITE;
/*!40000 ALTER TABLE `r_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_group` ENABLE KEYS */;
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
  `fileSize` float(7,2) DEFAULT NULL COMMENT '文件大小',
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
  `createUserName` varchar(45) DEFAULT NULL COMMENT '创建者名字',
  PRIMARY KEY (`id`),
  KEY `fk_source_course_idx` (`courseId`),
  CONSTRAINT `fk_source_course` FOREIGN KEY (`courseId`) REFERENCES `r_course` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source`
--

LOCK TABLES `r_source` WRITE;
/*!40000 ALTER TABLE `r_source` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='资源和类别的挂接表，一个资源有多个类别。一个类别也可以属于多个资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source_category_join`
--

LOCK TABLES `r_source_category_join` WRITE;
/*!40000 ALTER TABLE `r_source_category_join` DISABLE KEYS */;
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
  `createId` int(11) NOT NULL COMMENT '评论的作者id，用于链接评论人员的信息',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`),
  KEY `fk_source_com_idx` (`sourceId`),
  CONSTRAINT `fk_source_com` FOREIGN KEY (`sourceId`) REFERENCES `r_source` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='资源评价表';
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
  `isDisplay` int(11) DEFAULT '0',
  `imageUrl` text COMMENT '课程图片',
  `groupId` int(11) NOT NULL COMMENT '分组id',
  PRIMARY KEY (`id`),
  KEY `subject_group_fk_idx` (`groupId`),
  CONSTRAINT `subject_group_fk` FOREIGN KEY (`groupId`) REFERENCES `r_group` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='科目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_subject`
--

LOCK TABLES `r_subject` WRITE;
/*!40000 ALTER TABLE `r_subject` DISABLE KEYS */;
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
  `outlink` text COMMENT '外部链接,只有在是外链的时候才不为空。',
  `isOutlink` int(11) NOT NULL DEFAULT '0' COMMENT '是否是外链，0否1是',
  `description` text NOT NULL COMMENT '专题简介',
  `createUserId` int(11) NOT NULL COMMENT '专题作者',
  `remark` text COMMENT '备注',
  `templateId` int(11) DEFAULT '1' COMMENT '专题样式模板id，不选时默认为1',
  `isDisplay` int(11) NOT NULL DEFAULT '0',
  `keyWords` text,
  `createDate` datetime DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  `viewTimes` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='专题资源\n专题的图片链接，外链地址，\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic`
--

LOCK TABLES `r_topic` WRITE;
/*!40000 ALTER TABLE `r_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_topic` ENABLE KEYS */;
UNLOCK TABLES;

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
  `fileSize` float(7,2) DEFAULT NULL COMMENT '文件大小',
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic_source`
--

LOCK TABLES `r_topic_source` WRITE;
/*!40000 ALTER TABLE `r_topic_source` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `fk_topic_source_idx` (`subtitleId`),
  KEY `fk_source_idx` (`sourceId`),
  CONSTRAINT `fk_source` FOREIGN KEY (`sourceId`) REFERENCES `r_source` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_subtitle` FOREIGN KEY (`subtitleId`) REFERENCES `r_topic_subtitle` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='专题资源挂接表';
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
  `isAuto` int(11) DEFAULT '0' COMMENT '是否是系统自动添加，0否1是',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_tc_idx` (`topicId`),
  CONSTRAINT `fk_tc` FOREIGN KEY (`topicId`) REFERENCES `r_topic` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='专题的二级标题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic_subtitle`
--

LOCK TABLES `r_topic_subtitle` WRITE;
/*!40000 ALTER TABLE `r_topic_subtitle` DISABLE KEYS */;
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
  `name` varchar(50) NOT NULL COMMENT '功能的缩写字母，要大写',
  `remark` varchar(50) NOT NULL COMMENT '功能的中文名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `remark_UNIQUE` (`remark`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_function`
--

LOCK TABLES `s_function` WRITE;
/*!40000 ALTER TABLE `s_function` DISABLE KEYS */;
INSERT INTO `s_function` VALUES (1,'add','新增'),(2,'delete','删除'),(3,'modify','修改'),(4,'query','查询'),(5,'refresh','刷新'),(6,'join','挂接'),(7,'modify_pwd','修改密码'),(8,'sort','排序'),(9,'modify_many','批量修改'),(10,'add_many','批量增加'),(11,'super_query','超级浏览权限'),(12,'add_subtitle','增加二级标题'),(13,'upload','上传资源'),(14,'query_subtitle','查看二级标题'),(15,'manyManage','批量操作'),(16,'query_group_source','查看分组资源');
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
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_menu`
--

LOCK TABLES `s_menu` WRITE;
/*!40000 ALTER TABLE `s_menu` DISABLE KEYS */;
INSERT INTO `s_menu` VALUES (40,-1,'用户管理','','',''),(41,-1,'资源库系统','','',''),(45,-1,'在线备课','','',''),(47,40,'角色管理','App/System/Role/RoleManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(48,40,'用户管理','App/System/User/UserManage.html','1;2;3;6;7;10;15','./App/Lib/icons/32X32/product_169.gif'),(51,41,'学科管理','App/Resources/Subject/SubjectManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(52,41,'年级管理','App/Resources/Grade/GradeManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(53,41,'类别管理','App/Resources/Category/CategoryManage.html','1;2;3;8','./App/Lib/icons/32X32/product_169.gif'),(54,41,'课程管理','App/Resources/Course/CourseManage.html','1;2;3;4;5','./App/Lib/icons/32X32/product_169.gif'),(55,41,'资源管理','App/Resources/Source/SourceManage.html','1;2;3;5;11;16','./App/Lib/icons/32X32/product_169.gif'),(56,-1,'专题系统','','',''),(57,56,'专题管理','App/Resources/Topic/TopicManage.html','1;2;3;6;12;13;14','./App/Lib/icons/32X32/product_169.gif'),(61,-1,'网站管理','','',''),(62,61,'页面生成','App/Website/Page/PageManage.html','5','./App/Lib/icons/32X32/product_169.gif'),(63,40,'学生管理','App/System/Student/StudentManage.html','1;2;3;10;15','./App/Lib/icons/32X32/product_169.gif'),(65,61,'新闻管理','App/Website/News/NewsManage.html','1;2;3;5','./App/Lib/icons/32X32/product_169.gif'),(66,61,'轮播图片管理','App/Website/Pictures/PicturesManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(67,41,'分组管理','App/Resources/Group/GroupManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role`
--

LOCK TABLES `s_role` WRITE;
/*!40000 ALTER TABLE `s_role` DISABLE KEYS */;
INSERT INTO `s_role` VALUES (4,'管理员',NULL,'','超级管理员'),(21,'老师',28,'开发者',''),(22,'测试员',6,'管理员','');
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
) ENGINE=InnoDB AUTO_INCREMENT=687 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role_menu_join`
--

LOCK TABLES `s_role_menu_join` WRITE;
/*!40000 ALTER TABLE `s_role_menu_join` DISABLE KEYS */;
INSERT INTO `s_role_menu_join` VALUES (631,21,55,'1;2;3;5;16'),(663,22,47,'1;2;3;6'),(664,22,48,'1;2;3;6;7;10;15'),(666,22,51,'1;2;3'),(667,22,52,'1;2;3'),(668,22,53,'1;2;3;8'),(669,22,54,'1;2;3;4;5'),(670,22,57,'1;2;3;6;12;13;14'),(671,22,65,'1;2;3;5'),(672,22,66,'1;2;3'),(673,22,67,'1;2;3'),(674,4,47,'1;2;3;6'),(675,4,48,'1;2;3;6;7;10;15'),(676,4,51,'1;2;3'),(677,4,52,'1;2;3'),(678,4,53,'1;2;3;8'),(679,4,54,'1;2;3;4;5'),(680,4,55,'1;2;3;5;11;16'),(681,4,57,'1;2;3;6;12;13;14'),(682,4,62,'5'),(683,4,63,'1;2;3;10;15'),(684,4,65,'1;2;3;5'),(685,4,66,'1;2;3'),(686,4,67,'1;2;3');
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
  `password` varchar(32) NOT NULL,
  `name` varchar(10) NOT NULL COMMENT '名字',
  `number` varchar(20) NOT NULL COMMENT '学号',
  `department` varchar(50) NOT NULL COMMENT '系部',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `entranceTime` varchar(20) NOT NULL COMMENT '入学年份',
  `balance` int(11) DEFAULT '0' COMMENT '充值余额，默认为0',
  `telephone` varchar(15) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `remark` text,
  `icon` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_student`
--

LOCK TABLES `s_student` WRITE;
/*!40000 ALTER TABLE `s_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_student` ENABLE KEYS */;
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
  `password` varchar(32) NOT NULL COMMENT '密码',
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
  `icon` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `idcard_UNIQUE` (`idcard`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (6,'admin','E10ADC3949BA59ABBE56E057F20F883E','管理员','1232324','0','678768','787',NULL,'2013-10-07','8678',123,'2013-11-30','2014-01-02',NULL,NULL,'default.png');
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
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_role_join`
--

LOCK TABLES `s_user_role_join` WRITE;
/*!40000 ALTER TABLE `s_user_role_join` DISABLE KEYS */;
INSERT INTO `s_user_role_join` VALUES (86,6,4);
/*!40000 ALTER TABLE `s_user_role_join` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_category_group`
--

DROP TABLE IF EXISTS `v_category_group`;
/*!50001 DROP VIEW IF EXISTS `v_category_group`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_category_group` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `groupId` tinyint NOT NULL,
  `groupName` tinyint NOT NULL,
  `ord` tinyint NOT NULL,
  `remark` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `groupId` tinyint NOT NULL,
  `groupName` tinyint NOT NULL,
  `subjectId` tinyint NOT NULL,
  `subjectName` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_grade_group`
--

DROP TABLE IF EXISTS `v_grade_group`;
/*!50001 DROP VIEW IF EXISTS `v_grade_group`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_grade_group` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `groupId` tinyint NOT NULL,
  `isDisplay` tinyint NOT NULL,
  `groupName` tinyint NOT NULL,
  `remark` tinyint NOT NULL
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
  `gradeRemark` tinyint NOT NULL,
  `subjectId` tinyint NOT NULL,
  `subjectName` tinyint NOT NULL,
  `subjectRemark` tinyint NOT NULL,
  `subjectImageUrl` tinyint NOT NULL,
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
  `groupId` tinyint NOT NULL,
  `groupName` tinyint NOT NULL,
  `categoryIdList` tinyint NOT NULL,
  `categoryNameList` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_source_comment`
--

DROP TABLE IF EXISTS `v_source_comment`;
/*!50001 DROP VIEW IF EXISTS `v_source_comment`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_source_comment` (
  `id` tinyint NOT NULL,
  `sourceId` tinyint NOT NULL,
  `parentId` tinyint NOT NULL,
  `content` tinyint NOT NULL,
  `createId` tinyint NOT NULL,
  `createDate` tinyint NOT NULL,
  `createName` tinyint NOT NULL,
  `createIcon` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_subject_group`
--

DROP TABLE IF EXISTS `v_subject_group`;
/*!50001 DROP VIEW IF EXISTS `v_subject_group`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_subject_group` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `imageUrl` tinyint NOT NULL,
  `isDisplay` tinyint NOT NULL,
  `groupId` tinyint NOT NULL,
  `groupName` tinyint NOT NULL,
  `remark` tinyint NOT NULL
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
  `topicId` tinyint NOT NULL,
  `topicName` tinyint NOT NULL,
  `isDisplay` tinyint NOT NULL,
  `topicDescription` tinyint NOT NULL,
  `topicCreateUserId` tinyint NOT NULL,
  `topicKeyWords` tinyint NOT NULL,
  `lastUpdateDate` tinyint NOT NULL,
  `topicViewTimes` tinyint NOT NULL,
  `topicCreateDate` tinyint NOT NULL,
  `remark` tinyint NOT NULL,
  `subtitleId` tinyint NOT NULL,
  `subtitle` tinyint NOT NULL,
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
  `createUserId` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_topic_subtitle_source`
--

DROP TABLE IF EXISTS `v_topic_subtitle_source`;
/*!50001 DROP VIEW IF EXISTS `v_topic_subtitle_source`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_topic_subtitle_source` (
  `id` tinyint NOT NULL,
  `topicId` tinyint NOT NULL,
  `topicName` tinyint NOT NULL,
  `isDisplay` tinyint NOT NULL,
  `topicDescription` tinyint NOT NULL,
  `topicCreateUserId` tinyint NOT NULL,
  `topicKeyWords` tinyint NOT NULL,
  `lastUpdateDate` tinyint NOT NULL,
  `topicViewTimes` tinyint NOT NULL,
  `topicCreateDate` tinyint NOT NULL,
  `remark` tinyint NOT NULL,
  `subtitleId` tinyint NOT NULL,
  `subtitleName` tinyint NOT NULL,
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
  `createUserId` tinyint NOT NULL
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
-- Dumping events for database 'hnfnuzyw'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `e_user_habit` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`%`*/ /*!50106 EVENT `e_user_habit` ON SCHEDULE EVERY 1 HOUR STARTS '2013-12-02 13:55:46' ON COMPLETION PRESERVE ENABLE DO call user_habit() */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'hnfnuzyw'
--
/*!50003 DROP PROCEDURE IF EXISTS `user_habit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `user_habit`()
BEGIN
	DECLARE no_more INT(1) DEFAULT 0;
	DECLARE tmp_menuId INT(11);
	DECLARE tmp_count INT(11);
	DECLARE tmp_id INT(11);
	DECLARE cur_user_count CURSOR FOR
		SELECT s_user.id userId,menuId,COUNT(0) num FROM l_user_operate,s_user 
			WHERE userId = s_user.id GROUP BY userId,menuId ;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET no_more = 1;
	
	OPEN cur_user_count;
	REPEAT 
		
		FETCH cur_user_count INTO tmp_id,tmp_menuId,tmp_count;

		IF NOT no_more
		THEN
			INSERT INTO s_user_habit(userId,menuId,times) 
				VALUES(tmp_id,tmp_menuId,tmp_count) ON DUPLICATE KEY 
					UPDATE times = times+tmp_count;
			SELECT tmp_id,tmp_menuId,tmp_count;
		END IF;

	UNTIL no_more END REPEAT;
	CLOSE cur_user_count;
	
	delete from l_user_operate WHERE 1=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_category_group`
--

/*!50001 DROP TABLE IF EXISTS `v_category_group`*/;
/*!50001 DROP VIEW IF EXISTS `v_category_group`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_category_group` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`groupId` AS `groupId`,`t2`.`name` AS `groupName`,`t1`.`ord` AS `ord`,`t1`.`remark` AS `remark` from (`r_category` `t1` join `r_group` `t2` on((`t1`.`groupId` = `t2`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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
/*!50001 VIEW `v_chart_user_count` AS select count(0) AS `num`,month(`s_user`.`createDate`) AS `month` from `s_user` where (`s_user`.`createDate` between (now() + interval -(8) month) and now()) group by month(`s_user`.`createDate`) order by `s_user`.`createDate` */;
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
/*!50001 VIEW `v_course_grade_subject` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`gradeId` AS `gradeId`,`t1`.`remark` AS `remark`,`t3`.`name` AS `gradeName`,`t3`.`groupId` AS `groupId`,`t4`.`name` AS `groupName`,`t1`.`subjectId` AS `subjectId`,`t2`.`name` AS `subjectName` from (((`r_course` `t1` join `r_subject` `t2` on((`t1`.`subjectId` = `t2`.`id`))) join `r_grade` `t3` on((`t1`.`gradeId` = `t3`.`id`))) join `r_group` `t4` on((`t3`.`groupId` = `t4`.`id`))) order by `t1`.`gradeId`,`t1`.`subjectId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_grade_group`
--

/*!50001 DROP TABLE IF EXISTS `v_grade_group`*/;
/*!50001 DROP VIEW IF EXISTS `v_grade_group`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_grade_group` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`groupId` AS `groupId`,`t1`.`isDisplay` AS `isDisplay`,`t2`.`name` AS `groupName`,`t1`.`remark` AS `remark` from (`r_grade` `t1` join `r_group` `t2` on((`t1`.`groupId` = `t2`.`id`))) */;
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
/*!50001 VIEW `v_source` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`courseId` AS `courseId`,`t2`.`name` AS `courseName`,`t3`.`id` AS `gradeId`,`t3`.`name` AS `gradeName`,`t3`.`remark` AS `gradeRemark`,`t4`.`id` AS `subjectId`,`t4`.`name` AS `subjectName`,`t4`.`remark` AS `subjectRemark`,`t4`.`imageUrl` AS `subjectImageUrl`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `author`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `description`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t1`.`createUserName` AS `createUserName`,`t8`.`id` AS `groupId`,`t8`.`name` AS `groupName`,group_concat(`t7`.`id` order by `t7`.`ord` ASC separator ',') AS `categoryIdList`,group_concat(`t7`.`name` order by `t7`.`ord` ASC separator ',') AS `categoryNameList` from ((((((`r_source` `t1` join `r_course` `t2` on((`t1`.`courseId` = `t2`.`id`))) join `r_grade` `t3` on((`t2`.`gradeId` = `t3`.`id`))) join `r_subject` `t4` on((`t2`.`subjectId` = `t4`.`id`))) join `r_source_category_join` `t6` on((`t1`.`id` = `t6`.`sourceId`))) join `r_category` `t7` on((`t7`.`id` = `t6`.`categoryId`))) join `r_group` `t8` on((`t8`.`id` = `t3`.`groupId`))) group by `t6`.`sourceId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_source_comment`
--

/*!50001 DROP TABLE IF EXISTS `v_source_comment`*/;
/*!50001 DROP VIEW IF EXISTS `v_source_comment`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_source_comment` AS select `t1`.`id` AS `id`,`t1`.`sourceId` AS `sourceId`,`t1`.`parentId` AS `parentId`,`t1`.`content` AS `content`,`t1`.`createId` AS `createId`,`t1`.`createDate` AS `createDate`,`t2`.`name` AS `createName`,`t2`.`icon` AS `createIcon` from (`r_source_comment` `t1` join `s_user` `t2` on((`t2`.`id` = `t1`.`createId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_subject_group`
--

/*!50001 DROP TABLE IF EXISTS `v_subject_group`*/;
/*!50001 DROP VIEW IF EXISTS `v_subject_group`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_subject_group` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`imageUrl` AS `imageUrl`,`t1`.`isDisplay` AS `isDisplay`,`t1`.`groupId` AS `groupId`,`t2`.`name` AS `groupName`,`t1`.`remark` AS `remark` from (`r_subject` `t1` join `r_group` `t2` on((`t1`.`groupId` = `t2`.`id`))) */;
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
/*!50001 VIEW `v_topic_source` AS select `t3`.`id` AS `id`,`t2`.`id` AS `topicId`,`t2`.`name` AS `topicName`,`t2`.`isDisplay` AS `isDisplay`,`t2`.`description` AS `topicDescription`,`t2`.`createUserId` AS `topicCreateUserId`,`t2`.`keyWords` AS `topicKeyWords`,`t2`.`lastUpdateDate` AS `lastUpdateDate`,`t2`.`viewTimes` AS `topicViewTimes`,`t2`.`createDate` AS `topicCreateDate`,`t2`.`remark` AS `remark`,`t4`.`id` AS `subtitleId`,`t4`.`subtitle` AS `subtitle`,`t1`.`id` AS `sourceId`,`t1`.`name` AS `sourceName`,`t1`.`courseId` AS `courseId`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `sourceAuthor`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `sourceDescription`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId` from (((`r_topic_source_join` `t3` join `r_source` `t1` on((`t3`.`sourceId` = `t1`.`id`))) join `r_topic_subtitle` `t4` on((`t3`.`subtitleId` = `t4`.`id`))) join `r_topic` `t2` on((`t4`.`topicId` = `t2`.`id`))) */;
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
/*!50001 VIEW `v_topic_subtitle_source` AS select `t1`.`id` AS `id`,`t3`.`id` AS `topicId`,`t3`.`name` AS `topicName`,`t3`.`isDisplay` AS `isDisplay`,`t3`.`description` AS `topicDescription`,`t3`.`createUserId` AS `topicCreateUserId`,`t3`.`keyWords` AS `topicKeyWords`,`t3`.`lastUpdateDate` AS `lastUpdateDate`,`t3`.`viewTimes` AS `topicViewTimes`,`t3`.`createDate` AS `topicCreateDate`,`t3`.`remark` AS `remark`,`t2`.`id` AS `subtitleId`,`t2`.`subtitle` AS `subtitleName`,`t1`.`name` AS `sourceName`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `sourceAuthor`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `sourceDescription`,`t1`.`createDate` AS `createDate`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId` from ((`r_topic_source` `t1` join `r_topic_subtitle` `t2` on((`t1`.`topicSubtitleId` = `t2`.`id`))) join `r_topic` `t3` on((`t2`.`topicId` = `t3`.`id`))) */;
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

-- Dump completed on 2014-01-06 19:26:48
