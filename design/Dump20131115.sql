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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='新闻管理类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_news`
--

LOCK TABLES `f_news` WRITE;
/*!40000 ALTER TABLE `f_news` DISABLE KEYS */;
INSERT INTO `f_news` VALUES (6,'专家谈国安委：负责人应是国家最高领导人','<p><strong style=\"color: rgb(37, 37, 37); font-family: 宋体, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><p><em style=\"display: inline-block; height: 400px; vertical-align: middle;\"></em><img src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317375.jpg\" id=\"photo40023\" style=\"vertical-align: middle; border: 0px; max-width: 100%; max-height: 100%; zoom: 1; display: inline; opacity: 1;\"/></p><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JQPG00AN0001\" hidefocus=\"true\" class=\"nph_btn_pphoto\" id=\"photoPrev40023\" target=\"_self\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; width: 295px; height: 400px; outline: none; cursor: url(http://img2.cache.netease.com/utf8/gallery/img/cursor_left.cur), auto;\"></a></p><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JSDN00AN0001\" hidefocus=\"true\" class=\"nph_btn_nphoto\" id=\"photoNext40023\" target=\"_self\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; width: 295px; height: 400px; outline: none; cursor: url(http://img2.cache.netease.com/utf8/gallery/img/cursor_right.cur), auto;\"></a></p><p><span id=\"photoType40023\" class=\"nph_set_cur\" style=\"font-size: 14px; font-style: italic; font-family: geprgia, Georgia, sans-serif; padding: 10px 25px; float: left; color: rgb(77, 77, 77);\"><span class=\"nph_c_lh\" id=\"photoIndex40023\" style=\"font-size: 36px; color: rgb(204, 27, 27);\">1</span>/13</span></p><p style=\"; ; ; line-height: 21px; color: rgb(136, 136, 136);\">11月11日，习近平、李克强、张德江、俞正声、刘云山、王岐山、张高丽等在主席台上。 新华社记者 兰红光 摄</p><ul class=\"nph_list_thumb list-paddingleft-2\" id=\"thumb40023\" style=\"list-style-type: none;\"><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DHVT1AS00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 0px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out; border-top-style: none; border-bottom-width: 5px; border-bottom-style: solid; border-bottom-color: rgb(204, 27, 27);\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317843.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JSDN00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317890.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DHVT3ES00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317906.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JN8C00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317937.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JPVS00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317953.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JPHE00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346317984.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JP5000AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318000.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JOBN00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318234.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JNVJ00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318265.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JT4R00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318281.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JSOQ00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318296.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JRL100AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346318328.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li><li><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl#p=9DI0JQPG00AN0001\" hidefocus=\"true\" style=\"color: rgb(136, 136, 136); text-decoration: none; display: block; margin: 5px auto auto; width: 100px; height: 75px; outline: none; transition: all 0.2s ease-out; -webkit-transition: all 0.2s ease-out;\"><img data-id=\"40023\" src=\"/hnfnuzyw/ueditor/jsp/upload/1384346319093.jpg\" alt=\"\" style=\"vertical-align: top; border: 0px; display: block; margin: auto; width: 100px; height: 75px;\"/></a></p></li></ul><p><a href=\"http://news.163.com/13/1113/07/9DHVJ85R0001124J.html?hl\" hidefocus=\"true\" class=\"nph_btn_scrl\" id=\"bar40023\" style=\"color: rgb(136, 136, 136); text-decoration: none; position: absolute; display: block; width: 226.92307692307693px; outline: none; cursor: default;\"><strong class=\"nph_btn_lt\" style=\"float: left; margin-right: -3px; width: 3px; height: 9px; background-image: url(http://img1.cache.netease.com/cnews/img/gallery13/wz/img/scrl-btn-bg.png); font-size: 0px; background-position: 0px 0px; background-repeat: no-repeat no-repeat;\"></strong><strong class=\"nph_btn_rt\" style=\"float: right; margin-left: -3px; width: 3px; height: 9px; background-image: url(http://img1.cache.netease.com/cnews/img/gallery13/wz/img/scrl-btn-bg.png); font-size: 0px; background-position: -10px 0px; background-repeat: no-repeat no-repeat;\"></strong><span class=\"nph_btn_bd\" style=\"float: left; width: 226.921875px; min-height: 1px;\"><span style=\"display: block; height: 9px; margin: 0px 3px; background-image: url(http://img1.cache.netease.com/cnews/img/gallery13/wz/img/scrl-btn-bg.png); font-size: 0px; background-position: 0px -20px; background-repeat: repeat no-repeat;\"></span></span></a></p><p>&nbsp;|&nbsp;&nbsp;<a href=\"http://yuetu.163.com/?f=ArticlePhoto#news\" class=\"cBlue\" style=\"color: rgb(15, 107, 153); text-decoration: none;\"><img src=\"/hnfnuzyw/ueditor/jsp/null\" style=\"vertical-align: middle; border: 0px;\"/></a></p><p><span class=\"cBlue\" style=\"color: rgb(15, 107, 153);\">分享到<span class=\"nph-poplist-arr\" style=\"position: absolute; z-index: 10; border-color: transparent transparent rgb(136, 136, 136); border-style: dashed dashed solid; border-width: 0px 5px 5px; font-size: 0px; height: 0px; width: 0px; line-height: 0; -webkit-transition: all 0.25s ease 0s; transition: all 0.25s ease 0s; top: 4px; right: 5px;\"></span></span></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p><a href=\"http://news.163.com/photo/?f=ArticlePcenter\" class=\"cBlue\" style=\"color: rgb(15, 107, 153); text-decoration: none;\">新闻图片中心</a>&nbsp;&nbsp;|&nbsp;</p></li><li><p>&nbsp;</p></li><li><p><a href=\"http://news.163.com/photoview/00AN0001/40023.html?f=ArticlePview\" class=\"nph_icon_pset\" style=\"color: rgb(15, 107, 153); text-decoration: none;\">查看图集</a>&nbsp;&nbsp;|&nbsp;</p></li></ul><img src=\"/hnfnuzyw/ueditor/jsp/upload/1384346319109.gif\" width=\"0\" height=\"0\" border=\"0\" style=\"vertical-align: top; border: 0px;\"/></strong></p><p style=\"; ; ; text-indent: 2em;\"><br/></p><p style=\"; ; ; text-indent: 2em;\"><strong>国家安全</strong></p><p style=\"; ; ; text-indent: 2em;\">创新社会治理，必须着眼于维护最广大人民根本利益，最大限度增加和谐因素，增强社会发展活力，提高社会治理水平，维护国家安全，确保人民安居乐业、社会安定有序。要改进社会治理方式，激发社会组织活力，创新有效预防和化解社会矛盾体制，健全公共安全体系。设立国家安全委员会，完善国家安全体制和国家安全战略，确保国家安全。</p><p style=\"; ; ; text-indent: 2em;\"><strong>解读</strong></p><p style=\"; ; ; text-indent: 2em;\"><br/></p><p style=\"; ; ; text-indent: 2em;\"><strong>国家安全协调层级提高</strong></p><p style=\"; ; ; text-indent: 2em;\"><br/></p><p style=\"; ; ; text-indent: 2em;\"><strong>为何要设立国家安全委员会？</strong></p><p style=\"; ; ; text-indent: 2em;\">中国现代国际关系研究院反恐怖研究中心主任李伟在接受北京青年报记者采访时说，成立国家安全委员会，是为了应对今后可能不断增多的事关国家安全利益的重大突发事件。对于完善国家安全体制而言，这是一个重大举措。</p><p style=\"; ; ; text-indent: 2em;\">近年来，学界有不少声音认为中国面临的国际环境错综复杂，应该组建国家安全委员会。</p><p style=\"; ; ; text-indent: 2em;\">李伟认为，决定成立国家安全委员会，除了和国际形势的变化有关，更重要的是着眼于今后可能的和潜在的不确定事件，可以说是出于“防患于未然”的考虑。作为一个对涉及国家安全的重大突发事件和危机进行应对与管理的最高决策机构，这符合现代化国家的需求。</p><p style=\"; ; ; text-indent: 2em;\"><br/></p><p><iframe src=\"http://g.163.com/r?site=netease&amp;affiliate=news&amp;cat=article&amp;type=logo300x250&amp;location=13\" width=\"300\" height=\"250\" frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\"></iframe></p><p style=\"; ; ; text-indent: 2em;\"><strong>国家安全委员会将扮演什么角色？</strong></p><p style=\"; ; ; text-indent: 2em;\">李伟认为，国家安全委员会首先要为国家安全与国家利益制定长远的战略，也就是进行顶层规划。与此同时，面对当前国际环境下的传统安全和非传统安全问题，要为应对这两方面的突发事件发挥决策性作用。国家安全委员会将为中国今后的长治久安发挥决定性作用。</p><p style=\"; ; ; text-indent: 2em;\">传统安全问题一般指与国家间军事行为有关的冲突，涉及国家领土主权安全等问题。非传统安全问题是指除军事、政治和外交冲突以外的对主权国家构成威胁的因素，一般包括经济安全、金融安全、生态环境安全、恐怖主义、海盗等。</p><p><br/></p>','2013-11-13',6,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `f_pictures`
--

LOCK TABLES `f_pictures` WRITE;
/*!40000 ALTER TABLE `f_pictures` DISABLE KEYS */;
INSERT INTO `f_pictures` VALUES (1,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201311151749310QQ截图20131109205928.png','asdfs',0,'2013-11-15',6,'开发者','sdf'),(2,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201311151750390QQ截图20131109205928.png','dfgdfgdfgfdg',0,'2013-11-15',6,'开发者','fgfg');
/*!40000 ALTER TABLE `f_pictures` ENABLE KEYS */;
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
INSERT INTO `r_category` VALUES (6,'单词听写',0,''),(7,'识别生字',0,'sdfsr'),(8,'朗读材料',7,''),(9,'图画演示',1,'');
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
  `quality` varchar(50) DEFAULT NULL COMMENT '质量等级',
  `price` double DEFAULT '0' COMMENT '价格',
  `viewTimes` int(11) DEFAULT '0' COMMENT '访问次数',
  `useTimes` int(11) DEFAULT '0' COMMENT '下载或者使用次数',
  `url` varchar(255) NOT NULL,
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_source_course_idx` (`courseId`),
  CONSTRAINT `fk_source_course` FOREIGN KEY (`courseId`) REFERENCES `r_course` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source`
--

LOCK TABLES `r_source` WRITE;
/*!40000 ALTER TABLE `r_source` DISABLE KEYS */;
INSERT INTO `r_source` VALUES (16,'电热锅人',18,'电热锅人','动画','pdf','','10813415','','','','2013-10-20 17:21:54','0',NULL,0,0,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310201721387HeadFirstJava2.pdf',6),(19,'asdas',15,'asdas','','dll','','4055504','','','','2013-10-23 11:51:19','0',NULL,0,1,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231151179pdf.dll',6),(20,'阿迪四川省',16,'阿迪四川省','','dll','','2099664','','','','2013-10-23 11:56:12','0',NULL,0,1,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231156003npchrome_frame.dll',6),(22,'sfsd',9,'sfsd','','nexe','','5705472','','','','2013-10-23 19:22:49','0',NULL,0,7,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310231922364nacl_irt_x86_32.nexe',6),(23,'科研处科研经费报账发票说明',10,'科研处科研经费报账发票说明','','doc','','23552','','','','2013-10-26 12:18:06','0',NULL,0,40,12,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261217383科研处科研经费报账发票说明.doc',6),(24,'苏打水',9,'苏打水','','txt','','2341','','','','2013-10-26 19:51:37','0',NULL,0,0,0,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261951365利用struts2-convention-plugin注解配置文件下载.txt',6),(25,'水电费而非太热',9,'水电费而非太热','','txt','','2341','','','','2013-10-26 19:51:54','0',NULL,0,1,2,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261951463利用struts2-convention-plugin注解配置文件下载.txt',6),(26,'水电费水电费水电费是的',9,'水电费水电费水电费是的','','txt','','2341','','','','2013-10-26 19:52:10','0',NULL,0,1,1,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\201310261952018利用struts2-convention-plugin注解配置文件下载.txt',6),(27,'excel',25,'excel','','xls','','7680','','','','2013-11-08 14:34:58','0',NULL,100,2,1,'F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\uploads\\20131108143439511.xls',6);
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
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='资源和类别的挂接表，一个资源有多个类别。一个类别也可以属于多个资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_source_category_join`
--

LOCK TABLES `r_source_category_join` WRITE;
/*!40000 ALTER TABLE `r_source_category_join` DISABLE KEYS */;
INSERT INTO `r_source_category_join` VALUES (67,19,6),(68,19,7),(69,19,8),(70,19,9),(115,20,6),(116,20,7),(117,20,8),(118,16,7),(119,16,6),(120,16,8),(122,22,6),(123,22,7),(124,22,8),(125,23,6),(126,23,7),(127,23,8),(128,23,9),(129,24,6),(130,24,7),(131,24,8),(132,24,9),(133,25,6),(134,25,7),(135,25,8),(136,25,9),(137,26,6),(138,26,7),(139,26,8),(140,26,9),(141,27,6);
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
  `description` text NOT NULL COMMENT '专题简介',
  `author` varchar(45) NOT NULL COMMENT '专题作者',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='专题资源\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_topic`
--

LOCK TABLES `r_topic` WRITE;
/*!40000 ALTER TABLE `r_topic` DISABLE KEYS */;
INSERT INTO `r_topic` VALUES (5,'是非得失','第三方','1问2','深入固定收入');
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
-- Table structure for table `r_topic_source_join`
--

DROP TABLE IF EXISTS `r_topic_source_join`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_topic_source_join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicId` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_topic_source_idx` (`topicId`),
  KEY `fk_source_idx` (`sourceId`),
  CONSTRAINT `fk_source` FOREIGN KEY (`sourceId`) REFERENCES `r_source` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_topic` FOREIGN KEY (`topicId`) REFERENCES `r_topic` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_function`
--

LOCK TABLES `s_function` WRITE;
/*!40000 ALTER TABLE `s_function` DISABLE KEYS */;
INSERT INTO `s_function` VALUES (1,'add','新增'),(2,'delete','删除'),(3,'modify','修改'),(4,'query','查询'),(5,'refresh','刷新'),(6,'join','挂接'),(7,'modify_pwd','修改密码'),(8,'sort','排序'),(9,'modify_many','批量修改'),(10,'add_many','批量增加');
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
INSERT INTO `s_menu` VALUES (40,-1,'用户管理','','',''),(41,-1,'资源库系统','','',''),(45,-1,'在线备课','','',''),(46,61,'菜单管理','App/System/Menu/MenuManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(47,40,'角色管理','App/System/Role/RoleManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(48,40,'用户管理','App/System/User/UserManage.html','1;2;3;6;7','./App/Lib/icons/32X32/product_169.gif'),(49,61,'功能管理','App/System/Function/FunctionManage.html','1;3','./App/Lib/icons/32X32/product_169.gif'),(51,41,'学科管理','App/Resources/Subject/SubjectManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(52,41,'年级管理','App/Resources/Grade/GradeManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif'),(53,41,'类别管理','App/Resources/Category/CategoryManage.html','1;2;3;8','./App/Lib/icons/32X32/product_169.gif'),(54,41,'课程管理','App/Resources/Course/CourseManage.html','1;2;3;4;5','./App/Lib/icons/32X32/product_169.gif'),(55,41,'资源管理','App/Resources/Source/SourceManage.html','1;2;3;5','./App/Lib/icons/32X32/product_169.gif'),(56,-1,'专题系统','','',''),(57,41,'专题管理','App/Resources/Topic/TopicManage.html','1;2;3;6','./App/Lib/icons/32X32/product_169.gif'),(61,-1,'网站管理','','',''),(62,61,'页面生成','App/Website/Page/PageManage.html','5','./App/Lib/icons/32X32/product_169.gif'),(63,40,'学生管理','App/System/Student/StudentManage.html','1;2;3;9;10','./App/Lib/icons/32X32/product_169.gif'),(65,61,'新闻管理','App/Website/News/NewsManage.html','1;2;3;5','./App/Lib/icons/32X32/product_169.gif'),(66,61,'轮播图片管理','App/Website/Pictures/PicturesManage.html','1;2;3','./App/Lib/icons/32X32/product_169.gif');
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
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_role_menu_join`
--

LOCK TABLES `s_role_menu_join` WRITE;
/*!40000 ALTER TABLE `s_role_menu_join` DISABLE KEYS */;
INSERT INTO `s_role_menu_join` VALUES (222,5,51,'1;2;3'),(223,5,52,'1;2;3'),(224,5,53,'1;2;3;8'),(225,5,54,'1;2;3;4'),(226,5,55,'1;2;3'),(227,5,57,'1;2;3;6'),(228,6,62,'5'),(229,7,46,'1;3'),(230,7,47,'1;2;3;6'),(231,7,48,'1;2;3;6;7'),(278,18,46,'1;3'),(279,18,47,'1;2;3;6'),(280,18,48,'1;2;3;6;7'),(281,18,49,'1;3'),(283,18,51,'1;2;3'),(284,18,52,'1;2;3'),(285,18,53,'1;2;3;8'),(286,18,54,'1;2;3;4;5'),(287,18,55,'1;2;3;5'),(393,4,46,'1;2;3'),(394,4,47,'1;3;6'),(395,4,48,'1;2;3;6;7'),(396,4,49,'1;3'),(397,4,51,'1;2;3'),(398,4,52,'1;2;3'),(399,4,53,'1;2;3;8'),(400,4,54,'1;2;3;4;5'),(401,4,55,'1;2;3;5'),(402,4,57,'1;2;3;6'),(403,4,62,'5'),(404,4,63,'1;2;3;9;10'),(405,4,65,'1;2;3;5'),(406,4,66,'1;2;3');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_student`
--

LOCK TABLES `s_student` WRITE;
/*!40000 ALTER TABLE `s_student` DISABLE KEYS */;
INSERT INTO `s_student` VALUES (31,'1234567','123456','aa','1234567','数学系','信息与计算科学','2010',123456889,'13245654',NULL,NULL),(32,'1234568','123456','bb123','1234568','信工系','计算机科学与技术','2010',133456778,'13546454',NULL,'');
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
  `birth` date DEFAULT NULL COMMENT '生日',
  `department` varchar(40) NOT NULL COMMENT '部门',
  `balance` int(11) DEFAULT '0',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `latestLoginDate` date DEFAULT NULL COMMENT '最后登录时间',
  `setting` varchar(500) DEFAULT NULL COMMENT '设置（用于涉及用户个人的设置）',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (6,'admin','123456','开发者','430221199103101234','0','646208563','15575841234','2013-07-09','信息资源部',100,NULL,NULL,NULL,'ewt'),(8,'我叫测试','123456','sjakdjksa','430221199103102526','0','646208563','15575847475','2013-08-07','sdhs',0,NULL,NULL,NULL,''),(9,'测试用户1号','123456','开发者','123456789123456789','0','646208563','11111111111','2013-10-14','公管中心',0,NULL,NULL,NULL,''),(10,'测试用户2号','123456','开发者','123456789987456123','0','123456','1234567898877','2013-10-01','信息资源',0,NULL,NULL,NULL,''),(11,'我会告诉你所有的密码都是123456','123456','开发者','123456789987456123','1','23434','12343235','2013-10-01','俺的沙发',0,NULL,NULL,NULL,'23423'),(12,'asdasdasdasdas','111111','awd','12322435','0','1231231','12312312312','2013-10-07','12312321',0,NULL,NULL,NULL,''),(13,'abc','abc','abc','123','','','123',NULL,'abc',0,NULL,NULL,NULL,'');
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
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`userId`),
  KEY `fk_role_idx` (`roleId`),
  CONSTRAINT `fk_role2` FOREIGN KEY (`roleId`) REFERENCES `s_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `s_user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user_role_join`
--

LOCK TABLES `s_user_role_join` WRITE;
/*!40000 ALTER TABLE `s_user_role_join` DISABLE KEYS */;
INSERT INTO `s_user_role_join` VALUES (59,6,4),(69,8,4),(70,9,6),(72,9,8),(73,9,9),(74,10,4),(75,10,5),(76,10,6),(77,10,7),(78,10,8),(79,10,9),(82,11,6),(83,11,7),(84,11,8),(85,11,9),(88,13,4);
/*!40000 ALTER TABLE `s_user_role_join` ENABLE KEYS */;
UNLOCK TABLES;

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
  `quality` tinyint NOT NULL,
  `price` tinyint NOT NULL,
  `viewTimes` tinyint NOT NULL,
  `useTimes` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `createUserId` tinyint NOT NULL,
  `topicId` tinyint NOT NULL,
  `topicName` tinyint NOT NULL,
  `topicDescription` tinyint NOT NULL,
  `topicAuthor` tinyint NOT NULL,
  `remark` tinyint NOT NULL
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
/*!50001 VIEW `v_source` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`courseId` AS `courseId`,`t2`.`name` AS `courseName`,`t3`.`id` AS `gradeId`,`t3`.`name` AS `gradeName`,`t4`.`id` AS `subjectId`,`t4`.`name` AS `subjectName`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `author`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `description`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`quality` AS `quality`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t5`.`name` AS `createUserName`,group_concat(`t7`.`id` order by `t7`.`ord` ASC separator ',') AS `categoryIdList`,group_concat(`t7`.`name` order by `t7`.`ord` ASC separator ',') AS `categoryNameList` from ((((((`r_source` `t1` join `r_course` `t2` on((`t1`.`courseId` = `t2`.`id`))) join `r_grade` `t3` on((`t2`.`gradeId` = `t3`.`id`))) join `r_subject` `t4` on((`t2`.`subjectId` = `t4`.`id`))) join `s_user` `t5` on((`t1`.`createUserId` = `t5`.`id`))) join `r_source_category_join` `t6` on((`t1`.`id` = `t6`.`sourceId`))) join `r_category` `t7` on((`t7`.`id` = `t6`.`categoryId`))) group by `t6`.`sourceId` */;
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
/*!50001 VIEW `v_topic_source` AS select `t3`.`id` AS `id`,`t1`.`id` AS `sourceId`,`t1`.`name` AS `sourceName`,`t1`.`courseId` AS `courseId`,`t1`.`keyWords` AS `keyWords`,`t1`.`mediaType` AS `mediaType`,`t1`.`mediaFormat` AS `mediaFormat`,`t1`.`playTime` AS `playTime`,`t1`.`fileSize` AS `fileSize`,`t1`.`author` AS `sourceAuthor`,`t1`.`publisher` AS `publisher`,`t1`.`description` AS `sourceDescription`,`t1`.`createDate` AS `createDate`,`t1`.`approvalStatus` AS `approvalStatus`,`t1`.`quality` AS `quality`,`t1`.`price` AS `price`,`t1`.`viewTimes` AS `viewTimes`,`t1`.`useTimes` AS `useTimes`,`t1`.`url` AS `url`,`t1`.`createUserId` AS `createUserId`,`t2`.`id` AS `topicId`,`t2`.`name` AS `topicName`,`t2`.`description` AS `topicDescription`,`t2`.`author` AS `topicAuthor`,`t2`.`remark` AS `remark` from ((`r_topic_source_join` `t3` join `r_topic` `t2` on((`t3`.`topicId` = `t2`.`id`))) join `r_source` `t1` on((`t3`.`sourceId` = `t1`.`id`))) */;
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

-- Dump completed on 2013-11-15 17:53:19
