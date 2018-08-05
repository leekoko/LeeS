/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : lees

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-08-06 00:01:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collectioncontent
-- ----------------------------
DROP TABLE IF EXISTS `collectioncontent`;
CREATE TABLE `collectioncontent` (
  `ID` varchar(255) NOT NULL,
  `parentId` int(11) DEFAULT NULL COMMENT '外键id',
  `imgUrl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `intro` varchar(255) DEFAULT NULL COMMENT '介绍文字',
  `pageUrl` varchar(255) DEFAULT NULL COMMENT '页面链接',
  `clickDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最近点击的时间',
  `delFlag` int(11) DEFAULT NULL COMMENT '删除标识   0正常  1删除',
  `tsm1` varchar(255) DEFAULT NULL,
  `tsm2` varchar(255) DEFAULT NULL,
  `tsm3` varchar(255) DEFAULT NULL,
  `tsm4` varchar(255) DEFAULT NULL,
  `tsm5` varchar(255) DEFAULT NULL,
  `tsm6` varchar(255) DEFAULT NULL,
  `createDate` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collectioncontent
-- ----------------------------
INSERT INTO `collectioncontent` VALUES ('049cc111-df9a-41f4-be23-1b664bd48f2d', '15', 'images\\20180805105417.png', '清华大学开源软件平台', '清华自己组织的开源项目', 'https://tuna.moe/', '2018-08-05 23:17:10', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('16cf2076-0b5e-416c-acb9-dbd7ef42f8e7', '12', 'images\\20180805105913.png', 'IBM 中文技术网站', '难度比较高的视频', 'https://developer.ibm.com/cn/', '2018-08-05 22:59:27', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('18a6ede7-61f3-4d30-bc78-62f25071c3c2', '15', 'images\\20180805110001.png', 'JPress', 'Wordpress的Java代替版', 'https://www.oschina.net/p/jpress', '2018-08-05 23:00:14', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('1e3756ee-9087-42fb-8167-2b3c3481c75f', '13', 'images\\20180805100908.png', '在线翻墙', '', 'https://www.uzer.me/z/apps', '2018-08-05 22:09:10', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('294538a6-5892-4d41-b9da-262001075ba7', '11', 'images\\20180805111232.png', 'Kattle国内镜像', '迁移数据库专用', 'http://mirror.bit.edu.cn/pentaho/Data%20Integration/', '2018-08-05 23:12:45', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('2c278cd1-6dac-47a2-ad6b-6701492f5e2d', '13', 'images\\20180805110634.png', '优酷去广告研究', '搭建视频博客的时候需要用到', 'http://www.meilizhuo.com/', '2018-08-05 23:06:36', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('456b8bd3-e270-42ee-9af0-568037432141', '13', 'images\\20180805111110.png', '代理ip购买', 'Conder群推荐，用来搭建翻墙服务器', 'http://www.daxiangdaili.com/', '2018-08-05 23:11:41', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('51e2db2f-e41f-4d6f-a166-fe2beb0f0fce', '14', 'images\\20180805110147.png', '壁纸网站', '很不错的壁纸网站，高清', 'https://www.pexels.com/search/desktop%20wallpaper/', '2018-08-05 23:02:09', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('52ba87c5-5695-4b1a-9f02-fd42bc67cc53', '13', 'images\\20180805105649.png', 'SpringBoot文档', '英文文档，可以学习英语', 'https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/', '2018-08-05 22:57:22', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('59007434-d866-4172-a6fc-7b35df71ec07', '12', 'images\\20180805101022.png', 'npm仓库管理', '国外类似于github的网站', 'https://www.npmjs.com/', '2018-08-05 22:10:30', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('655b5d9f-e9a4-4b4c-a159-955dc2518ab6', '12', 'images\\20180805110804.png', '小文Blog', '技术博客，有关于wordpress的', 'https://www.qcgzxw.cn/', '2018-08-05 23:08:23', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('6cba0525-f252-4822-b75f-87dfdda51f53', '14', 'images\\20180805101203.png', '小书屋', 'kindle大量的书籍', 'http://mebook.cc/', '2018-08-05 22:44:12', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('73f75d81-1452-4a4b-a8fa-f518c4dc0aee', '13', 'images\\20180805100739.png', '刷流量网站', '', 'http://www.shuaip.net/', '2018-08-05 22:07:50', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('7503c22a-4c11-4f92-80a7-2255deaeea6e', '12', 'images\\20180805104855.png', '优达学城', '高手介绍的 机器学习 网站', 'https://cn.udacity.com/', '2018-08-05 22:49:45', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('81b88627-a98b-40c6-b0f3-214e084e207c', '13', 'images\\20180805110915.png', 'youtube视频下载，需要翻墙', '下载youtube的视频', 'https://www.clipconverter.cc/', '2018-08-05 23:10:10', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('8deb5d84-b9f5-49e4-a59f-f9947b9a72fa', '11', 'images\\20180805100450.png', '程序员小工具', '各种小公具', 'https://tool.lu/', '2018-08-05 22:05:27', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('9ac54ed9-72c1-42f1-92ec-efa943912347', '12', 'images\\20180805105813.png', '自学it吧', '大量自学资源', 'http://www.zxit8.com/forum.php', '2018-08-05 22:58:30', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('a05ca8e8-641d-48cb-a838-8de794d95d45', '12', 'images\\20180805110417.png', '黑客派', '不少高质量的黑客文章', 'https://hacpai.com/', '2018-08-05 23:04:45', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('b0695dc9-a534-411f-a345-289ef1768621', '12', 'images\\20180805100329.png', 'itellyou系统下载', '比较纯正的window系统，比较全。', 'https://msdn.itellyou.cn/', '2018-08-05 22:04:11', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('c47b8be5-7dfb-4d51-8f3f-5b0041ef726a', '13', 'images\\20180805104701.png', '流程图设计process', '邮箱/qq  6lyb，流程图设计', 'https://www.processon.com/diagrams', '2018-08-05 22:47:49', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('c5c6c8f5-d818-4344-9d08-55819a2713b8', '12', 'images\\20180805105525.png', 'jive设计模式', 'java设计模式，面向对象的网站', 'https://www.jdon.com/designpatterns/', '2018-08-05 22:56:00', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('dfcdcba8-cd39-483e-8424-5bbf194ffbdf', '12', 'images\\20180805101409.png', '阳志平的网志', '关于很多有用的技巧，看一下别人都在用什么。', 'http://www.yangzhiping.com/tech/gollum.html', '2018-08-05 22:49:47', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectioncontent` VALUES ('fb773cdd-8158-4b04-86b6-e170bb1ca0e1', '14', 'images\\20180805105149.png', 'leetcode在线算法编程网站', '很多算法的地方', 'https://leetcode.com/problems/game-of-life/description/', '2018-08-05 22:52:04', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for collectiontype
-- ----------------------------
DROP TABLE IF EXISTS `collectiontype`;
CREATE TABLE `collectiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) DEFAULT NULL COMMENT '大类别名称',
  `delflag` int(11) DEFAULT NULL COMMENT '删除标识   0正常  1删除',
  `tsm1` varchar(255) DEFAULT NULL,
  `tsm2` varchar(255) DEFAULT NULL,
  `tsm3` varchar(255) DEFAULT NULL,
  `tsm4` varchar(255) DEFAULT NULL,
  `tsm5` varchar(255) DEFAULT NULL,
  `tsm6` varchar(255) DEFAULT NULL,
  `createDate` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collectiontype
-- ----------------------------
INSERT INTO `collectiontype` VALUES ('11', '工作', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectiontype` VALUES ('12', '业余学习', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectiontype` VALUES ('13', '计算机工具', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectiontype` VALUES ('14', '业余爱好', null, null, null, null, null, null, null, null, null);
INSERT INTO `collectiontype` VALUES ('15', '开源资源', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for onlinecontent
-- ----------------------------
DROP TABLE IF EXISTS `onlinecontent`;
CREATE TABLE `onlinecontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '内容',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `tsm1` varchar(255) DEFAULT NULL,
  `tsm2` varchar(255) DEFAULT NULL,
  `tsm3` varchar(255) DEFAULT NULL,
  `tsm4` varchar(255) DEFAULT NULL,
  `tsm5` varchar(255) DEFAULT NULL,
  `tsm6` varchar(255) DEFAULT NULL,
  `tsm7` varchar(255) DEFAULT NULL,
  `tsm8` varchar(255) DEFAULT NULL,
  `tsm9` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of onlinecontent
-- ----------------------------
