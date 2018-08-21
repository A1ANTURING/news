/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : db_news

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-08-21 16:50:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `userIP` varchar(30) DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `newsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `newsId` (`newsId`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`newsId`) REFERENCES `t_news` (`newsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_link`
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(20) DEFAULT NULL,
  `linkUrl` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_link
-- ----------------------------
INSERT INTO `t_link` VALUES ('2', '百度', 'http://www.baidu.com', null, '1');
INSERT INTO `t_link` VALUES ('3', 'CSDN', 'http://www.csdn.com', null, '3');
INSERT INTO `t_link` VALUES ('18', '胡腾', 'https://www.ht.com', '920059779@qq.com', '1');

-- ----------------------------
-- Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  `author` varchar(20) DEFAULT NULL,
  `isHead` int(11) DEFAULT NULL,
  `isImage` int(11) DEFAULT NULL,
  `imageName` varchar(30) DEFAULT NULL,
  `isHot` int(11) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `click` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsId`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `t_news_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_newstype` (`newsTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('52', '娱乐新闻1', '娱乐新闻1', '胡腾', '0', '1', '20140313084123.jpg', '1', '2014-03-13', '5', '1');
INSERT INTO `t_news` VALUES ('53', '娱乐新闻2', '娱乐新闻2', '胡腾', '0', '0', null, '1', '2014-03-13', '1', '1');
INSERT INTO `t_news` VALUES ('64', '娱乐新闻3', '娱乐新闻3', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '1');
INSERT INTO `t_news` VALUES ('65', '娱乐新闻4', '娱乐新闻4', '胡腾', '0', '0', null, '0', '2014-03-13', '1', '1');
INSERT INTO `t_news` VALUES ('66', '娱乐新闻5', '娱乐新闻5', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '1');
INSERT INTO `t_news` VALUES ('67', '娱乐新闻6', '娱乐新闻6', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '1');
INSERT INTO `t_news` VALUES ('68', '娱乐新闻7', '娱乐新闻7', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '1');
INSERT INTO `t_news` VALUES ('69', '娱乐新闻8', '娱乐新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '1');
INSERT INTO `t_news` VALUES ('71', '政治新闻2', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '3', '2');
INSERT INTO `t_news` VALUES ('72', '政治新闻3', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '2');
INSERT INTO `t_news` VALUES ('73', '政治新闻4', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '2', '2');
INSERT INTO `t_news` VALUES ('74', '政治新闻5', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '1', '2');
INSERT INTO `t_news` VALUES ('75', '政治新闻6', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '2');
INSERT INTO `t_news` VALUES ('76', '政治新闻7', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '2');
INSERT INTO `t_news` VALUES ('77', '政治新闻8', '政治新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '2');
INSERT INTO `t_news` VALUES ('78', '经济新闻1', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '3', '3');
INSERT INTO `t_news` VALUES ('79', '经济新闻3', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '2', '3');
INSERT INTO `t_news` VALUES ('80', '经济新闻3', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('81', '经济新闻4', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('82', '经济新闻5', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('83', '经济新闻6', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('84', '经济新闻7', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('85', '经济新闻8', '经济新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '3');
INSERT INTO `t_news` VALUES ('86', '文化新闻1', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('87', '文化新闻4', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('88', '文化新闻4', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('89', '文化新闻4', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '1', '4');
INSERT INTO `t_news` VALUES ('90', '文化新闻5', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '1', '4');
INSERT INTO `t_news` VALUES ('91', '文化新闻6', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('92', '文化新闻7', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('93', '文化新闻8', '文化新闻8', '胡腾', '0', '0', null, '0', '2014-03-13', '0', '4');
INSERT INTO `t_news` VALUES ('112', '这是一个新新闻', '<p>啊啊啊啊啊啊啊啊啊啊</p>', '胡腾', '0', '0', '', '0', '2018-08-02', '8', '1');

-- ----------------------------
-- Table structure for `t_newstype`
-- ----------------------------
DROP TABLE IF EXISTS `t_newstype`;
CREATE TABLE `t_newstype` (
  `newsTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`newsTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_newstype
-- ----------------------------
INSERT INTO `t_newstype` VALUES ('1', '娱乐新闻');
INSERT INTO `t_newstype` VALUES ('2', '政治新闻');
INSERT INTO `t_newstype` VALUES ('3', '经济新闻');
INSERT INTO `t_newstype` VALUES ('4', '文化新闻');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
