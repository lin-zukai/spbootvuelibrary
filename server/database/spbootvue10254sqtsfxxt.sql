/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : spbootvue10254sqtsfxxt

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2022-04-30 22:17:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '帐号',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `guihuan`
-- ----------------------------
DROP TABLE IF EXISTS `guihuan`;
CREATE TABLE `guihuan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jieyueid` int(10) unsigned NOT NULL COMMENT '借阅id',
  `tushuxinxiid` int(10) unsigned NOT NULL COMMENT '图书信息id',
  `tushubianhao` varchar(50) NOT NULL COMMENT '图书编号',
  `tushumingcheng` varchar(255) NOT NULL COMMENT '图书名称',
  `tushufenlei` int(10) unsigned NOT NULL COMMENT '图书分类',
  `tushujia` varchar(50) NOT NULL COMMENT '图书架',
  `faburen` varchar(50) NOT NULL COMMENT '发布人',
  `jieyueren` varchar(50) NOT NULL COMMENT '借阅人',
  `shijiguihuanshijian` varchar(25) NOT NULL COMMENT '实际归还时间',
  `beizhu` text NOT NULL COMMENT '备注',
  `huanshuren` varchar(50) NOT NULL COMMENT '还书人',
  PRIMARY KEY (`id`),
  KEY `guihuan_jieyueid_index` (`jieyueid`),
  KEY `guihuan_tushuxinxiid_index` (`tushuxinxiid`),
  KEY `guihuan_tushufenlei_index` (`tushufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='归还';

-- ----------------------------
-- Records of guihuan
-- ----------------------------
INSERT INTO `guihuan` VALUES ('1', '2', '0', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '333', '444', '2022-02-22 17:15:14', '备注', '444');
INSERT INTO `guihuan` VALUES ('2', '1', '0', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '444', '2022-02-22 17:16:06', '备注', '444');
INSERT INTO `guihuan` VALUES ('3', '3', '0', '2102201944264', '我愿乘风破浪', '6', '电子图书架', '222', '111', '2022-02-22 17:23:42', '备注备注', '111');
INSERT INTO `guihuan` VALUES ('4', '7', '0', '2102202013200', '当你又忙又美', '6', '电子图书架', '222', '111', '2022-02-22 17:30:09', '备注', '111');
INSERT INTO `guihuan` VALUES ('5', '6', '0', '2102202009262', '小猫当当', '3', '电子图书架', '222', '111', '2022-02-22 17:30:12', '备注', '111');
INSERT INTO `guihuan` VALUES ('6', '5', '0', '2102202008222', '互链网', '4', '电子图书架', '333', '111', '2022-02-22 17:30:14', '备注', '111');
INSERT INTO `guihuan` VALUES ('7', '4', '0', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '333', '111', '2022-02-22 17:30:16', '备注', '111');
INSERT INTO `guihuan` VALUES ('8', '8', '0', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '222', '2022-02-22 17:32:27', '备注', '222');
INSERT INTO `guihuan` VALUES ('9', '9', '0', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '333', '222', '2022-02-22 17:32:30', '备注', '222');
INSERT INTO `guihuan` VALUES ('10', '10', '0', '2102202016061', '外贸高手', '6', '社区活动室图书架', '111', '222', '2022-02-22 17:32:32', '备注', '222');
INSERT INTO `guihuan` VALUES ('11', '11', '0', '2102202008222', '互链网', '4', '电子图书架', '333', '222', '2022-02-22 17:32:34', '备注', '222');
INSERT INTO `guihuan` VALUES ('12', '16', '0', '2102202012304', '谁动了我的奶酪', '3', '电子图书架', '222', '333', '2022-02-22 17:34:10', '备注', '333');
INSERT INTO `guihuan` VALUES ('13', '15', '0', '022216598686', '红楼梦', '1', '电子图书架', '444', '333', '2022-02-22 17:34:14', '备注', '333');
INSERT INTO `guihuan` VALUES ('14', '14', '0', '2102202009262', '小猫当当', '3', '电子图书架', '222', '333', '2022-02-22 17:34:16', '备注', '333');
INSERT INTO `guihuan` VALUES ('15', '13', '0', '2102201944264', '我愿乘风破浪', '6', '电子图书架', '222', '333', '2022-02-22 17:34:19', '备注', '333');
INSERT INTO `guihuan` VALUES ('16', '12', '0', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '333', '2022-02-22 17:34:21', '备注', '333');
INSERT INTO `guihuan` VALUES ('17', '17', '0', '022218527839', '免费书', '5', '社区活动室图书架', '555', '111', '2022-02-22 18:55:25', '备注', '111');
INSERT INTO `guihuan` VALUES ('18', '18', '0', '022218516981', '西游记', '1', '社区活动室图书架', '555', '111', '2022-02-22 18:55:30', '备注', '111');

-- ----------------------------
-- Table structure for `jieyue`
-- ----------------------------
DROP TABLE IF EXISTS `jieyue`;
CREATE TABLE `jieyue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tushuxinxiid` int(10) unsigned NOT NULL COMMENT '图书信息id',
  `tushubianhao` varchar(50) NOT NULL COMMENT '图书编号',
  `tushumingcheng` varchar(255) NOT NULL COMMENT '图书名称',
  `tushufenlei` int(10) unsigned NOT NULL COMMENT '图书分类',
  `tushujia` varchar(50) NOT NULL COMMENT '图书架',
  `meitianjiage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '每天价格',
  `faburen` varchar(50) NOT NULL COMMENT '发布人',
  `jieyuebianhao` varchar(50) NOT NULL COMMENT '借阅编号',
  `jieyueshijian` varchar(25) NOT NULL COMMENT '借阅时间',
  `guihuanshijian` varchar(25) NOT NULL COMMENT '归还时间',
  `jieyuetianshu` int(11) NOT NULL DEFAULT '0' COMMENT '借阅天数',
  `jieyuejine` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '借阅金额',
  `jieyuezhuangtai` varchar(50) NOT NULL COMMENT '借阅状态',
  `jieyueren` varchar(50) NOT NULL COMMENT '借阅人',
  `iszf` varchar(10) NOT NULL DEFAULT '否' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  KEY `jieyue_tushuxinxiid_index` (`tushuxinxiid`),
  KEY `jieyue_tushufenlei_index` (`tushufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='借阅';

-- ----------------------------
-- Records of jieyue
-- ----------------------------
INSERT INTO `jieyue` VALUES ('1', '2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '1.00', '111', '022216595006', '2022-02-22 16:59:05', '2022-02-26 16:59:05', '5', '5.00', '已归还', '444', '是');
INSERT INTO `jieyue` VALUES ('2', '3', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '0.00', '333', '022217063999', '2022-02-22 17:06:07', '2022-02-28 17:06:07', '7', '0.00', '已归还', '444', '否');
INSERT INTO `jieyue` VALUES ('3', '1', '2102201944264', '我愿乘风破浪', '6', '电子图书架', '1.00', '222', '022217199811', '2022-02-22 17:19:23', '2022-02-28 17:19:23', '7', '7.00', '已归还', '111', '是');
INSERT INTO `jieyue` VALUES ('4', '3', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '0.00', '333', '022217294766', '2022-02-22 17:29:04', '2022-02-24 17:29:04', '3', '0.00', '已归还', '111', '否');
INSERT INTO `jieyue` VALUES ('5', '5', '2102202008222', '互链网', '4', '电子图书架', '1.00', '333', '022217298587', '2022-02-22 17:29:18', '2022-02-25 17:29:18', '4', '4.00', '已归还', '111', '是');
INSERT INTO `jieyue` VALUES ('6', '6', '2102202009262', '小猫当当', '3', '电子图书架', '0.00', '222', '022217297832', '2022-02-22 17:29:33', '2022-02-26 17:29:33', '5', '0.00', '已归还', '111', '否');
INSERT INTO `jieyue` VALUES ('7', '9', '2102202013200', '当你又忙又美', '6', '电子图书架', '1.00', '222', '022217295606', '2022-02-22 17:29:44', '2022-03-09 17:29:44', '16', '16.00', '已归还', '111', '是');
INSERT INTO `jieyue` VALUES ('8', '2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '1.00', '111', '022217308651', '2022-02-22 17:30:52', '2022-02-25 17:30:52', '4', '4.00', '已归还', '222', '是');
INSERT INTO `jieyue` VALUES ('9', '3', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '0.00', '333', '022217312981', '2022-02-22 17:31:08', '2022-03-08 17:31:08', '15', '0.00', '已归还', '222', '否');
INSERT INTO `jieyue` VALUES ('10', '12', '2102202016061', '外贸高手', '6', '社区活动室图书架', '1.00', '111', '022217318708', '2022-02-22 17:31:41', '2022-03-25 17:31:41', '32', '32.00', '已归还', '222', '是');
INSERT INTO `jieyue` VALUES ('11', '5', '2102202008222', '互链网', '4', '电子图书架', '1.00', '333', '022217323665', '2022-02-22 17:32:07', '2022-02-28 17:32:07', '7', '7.00', '已归还', '222', '是');
INSERT INTO `jieyue` VALUES ('12', '2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '1.00', '111', '022217331825', '2022-02-22 17:33:02', '2022-03-09 17:33:02', '16', '16.00', '已归还', '333', '是');
INSERT INTO `jieyue` VALUES ('13', '1', '2102201944264', '我愿乘风破浪', '6', '电子图书架', '1.00', '222', '022217338584', '2022-02-22 17:33:14', '2022-03-12 17:33:14', '19', '19.00', '已归还', '333', '是');
INSERT INTO `jieyue` VALUES ('14', '6', '2102202009262', '小猫当当', '3', '电子图书架', '0.00', '222', '022217331322', '2022-02-22 17:33:27', '2022-02-23 17:33:27', '2', '0.00', '已归还', '333', '否');
INSERT INTO `jieyue` VALUES ('15', '13', '022216598686', '红楼梦', '1', '电子图书架', '0.00', '444', '022217333404', '2022-02-22 17:33:38', '2022-02-24 17:33:38', '3', '0.00', '已归还', '333', '否');
INSERT INTO `jieyue` VALUES ('16', '8', '2102202012304', '谁动了我的奶酪', '3', '电子图书架', '1.00', '222', '022217338522', '2022-02-22 17:33:47', '2022-02-27 17:33:47', '6', '6.00', '已归还', '333', '是');
INSERT INTO `jieyue` VALUES ('17', '15', '022218527839', '免费书', '5', '社区活动室图书架', '0.00', '555', '022218548607', '2022-02-22 18:54:26', '2022-02-28 18:54:26', '7', '0.00', '已归还', '111', '否');
INSERT INTO `jieyue` VALUES ('18', '14', '022218516981', '西游记', '1', '社区活动室图书架', '2.00', '555', '022218542207', '2022-02-22 18:54:46', '2022-03-17 18:54:46', '24', '48.00', '已归还', '111', '是');

-- ----------------------------
-- Table structure for `jubao`
-- ----------------------------
DROP TABLE IF EXISTS `jubao`;
CREATE TABLE `jubao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tushuxinxiid` int(10) unsigned NOT NULL COMMENT '图书信息id',
  `tushubianhao` varchar(50) NOT NULL COMMENT '图书编号',
  `tushumingcheng` varchar(255) NOT NULL COMMENT '图书名称',
  `tushufenlei` int(10) unsigned NOT NULL COMMENT '图书分类',
  `tushujia` varchar(50) NOT NULL COMMENT '图书架',
  `faburen` varchar(50) NOT NULL COMMENT '发布人',
  `jubaoneirong` text NOT NULL COMMENT '举报内容',
  `jubaoren` varchar(50) NOT NULL COMMENT '举报人',
  `jubaozhuangtai` varchar(50) NOT NULL COMMENT '举报状态',
  PRIMARY KEY (`id`),
  KEY `jubao_tushuxinxiid_index` (`tushuxinxiid`),
  KEY `jubao_tushufenlei_index` (`tushufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='举报';

-- ----------------------------
-- Records of jubao
-- ----------------------------
INSERT INTO `jubao` VALUES ('1', '2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '举报内容', '444', '已处理');
INSERT INTO `jubao` VALUES ('2', '2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '举报内容举报内容', '111', '已处理');

-- ----------------------------
-- Table structure for `jubaochuli`
-- ----------------------------
DROP TABLE IF EXISTS `jubaochuli`;
CREATE TABLE `jubaochuli` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jubaoid` int(10) unsigned NOT NULL COMMENT '举报id',
  `tushuxinxiid` int(10) unsigned NOT NULL COMMENT '图书信息id',
  `tushubianhao` varchar(50) NOT NULL COMMENT '图书编号',
  `tushumingcheng` varchar(255) NOT NULL COMMENT '图书名称',
  `tushufenlei` int(10) unsigned NOT NULL COMMENT '图书分类',
  `tushujia` varchar(50) NOT NULL COMMENT '图书架',
  `faburen` varchar(50) NOT NULL COMMENT '发布人',
  `jubaoren` varchar(50) NOT NULL COMMENT '举报人',
  `chulibeizhu` text NOT NULL COMMENT '处理备注',
  `chuliren` varchar(50) NOT NULL COMMENT '处理人',
  PRIMARY KEY (`id`),
  KEY `jubaochuli_jubaoid_index` (`jubaoid`),
  KEY `jubaochuli_tushuxinxiid_index` (`tushuxinxiid`),
  KEY `jubaochuli_tushufenlei_index` (`tushufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='举报处理';

-- ----------------------------
-- Records of jubaochuli
-- ----------------------------
INSERT INTO `jubaochuli` VALUES ('1', '1', '0', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '444', '处理备注处理备注', 'admin');
INSERT INTO `jubaochuli` VALUES ('2', '2', '0', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '111', '111', '处理备注处理备注', 'admin');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `lianxidianhua` varchar(50) NOT NULL COMMENT '联系电话',
  `liuyanneirong` text NOT NULL COMMENT '留言内容',
  `liuyanren` varchar(50) NOT NULL COMMENT '留言人',
  `huifuneirong` text NOT NULL COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='留言板';

-- ----------------------------
-- Records of liuyanban
-- ----------------------------
INSERT INTO `liuyanban` VALUES ('1', '大大', '12345679810', '留言内容', '111', '收到');
INSERT INTO `liuyanban` VALUES ('2', '111', '11111111111', '留言内容', '111', '回复内容回复内容回复内容回复内容');

-- ----------------------------
-- Table structure for `lunbotu`
-- ----------------------------
DROP TABLE IF EXISTS `lunbotu`;
CREATE TABLE `lunbotu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `image` varchar(255) NOT NULL COMMENT '图片',
  `url` varchar(255) NOT NULL COMMENT '连接地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='轮播图';

-- ----------------------------
-- Records of lunbotu
-- ----------------------------
INSERT INTO `lunbotu` VALUES ('1', '1', '/upload/20220222/5a309dc7-b8af-4834-9684-9d7457e5b6d7.png', '#');
INSERT INTO `lunbotu` VALUES ('2', '2', '/upload/20220222/6cae419a-d34b-4937-8d1a-a71aa148e717.png', '#');
INSERT INTO `lunbotu` VALUES ('3', '3', '/upload/20220222/43a30cf0-02c9-495e-a414-d2da683b0dfe.png', '#');

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `biao` varchar(50) NOT NULL COMMENT '表',
  `biaoid` int(11) NOT NULL DEFAULT '0' COMMENT '表id',
  `biaoti` varchar(255) NOT NULL COMMENT '标题',
  `pingfen` varchar(255) NOT NULL COMMENT '评分',
  `pinglunneirong` text NOT NULL COMMENT '评论内容',
  `pinglunren` varchar(50) NOT NULL COMMENT '评论人',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='评论';

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES ('1', 'tushuxinxi', '2', '维京时代与英格兰', '5', '撒旦打撒', '444', '2022-02-22 16:58:05');
INSERT INTO `pinglun` VALUES ('2', 'tushuxinxi', '1', '我愿乘风破浪', '3', '啊实打实打算', '111', '2022-02-22 17:20:53');
INSERT INTO `pinglun` VALUES ('3', 'tushuxinxi', '15', '免费书', '5', '可以哦', '111', '2022-02-22 18:57:08');

-- ----------------------------
-- Table structure for `tushufenlei`
-- ----------------------------
DROP TABLE IF EXISTS `tushufenlei`;
CREATE TABLE `tushufenlei` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fenleimingcheng` varchar(255) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='图书分类';

-- ----------------------------
-- Records of tushufenlei
-- ----------------------------
INSERT INTO `tushufenlei` VALUES ('1', '历史文化');
INSERT INTO `tushufenlei` VALUES ('2', '军事政治');
INSERT INTO `tushufenlei` VALUES ('3', '儿童教育');
INSERT INTO `tushufenlei` VALUES ('4', '科技生活');
INSERT INTO `tushufenlei` VALUES ('5', '小说文艺');
INSERT INTO `tushufenlei` VALUES ('6', '励志经管');

-- ----------------------------
-- Table structure for `tushuguanliyuan`
-- ----------------------------
DROP TABLE IF EXISTS `tushuguanliyuan`;
CREATE TABLE `tushuguanliyuan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) NOT NULL COMMENT '账号',
  `mima` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(10) NOT NULL COMMENT '性别',
  `lianxifangshi` varchar(50) NOT NULL COMMENT '联系方式',
  `youxiang` varchar(50) NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='图书管理员';

-- ----------------------------
-- Records of tushuguanliyuan
-- ----------------------------
INSERT INTO `tushuguanliyuan` VALUES ('1', '999', '999', '999', '男', '15728678569', '4156465@qq.com');

-- ----------------------------
-- Table structure for `tushuxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `tushuxinxi`;
CREATE TABLE `tushuxinxi` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tushubianhao` varchar(50) NOT NULL COMMENT '图书编号',
  `tushumingcheng` varchar(255) NOT NULL COMMENT '图书名称',
  `tushufenlei` int(10) unsigned NOT NULL COMMENT '图书分类',
  `tushujia` varchar(50) NOT NULL COMMENT '图书架',
  `tupian` varchar(255) NOT NULL COMMENT '图片',
  `shipin` varchar(255) NOT NULL COMMENT '视频',
  `zuozhe` varchar(50) NOT NULL COMMENT '作者',
  `chubanshe` varchar(50) NOT NULL COMMENT '出版社',
  `jieyueyupeijin` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '借阅预赔金',
  `meitianjiage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '每天价格',
  `jieyuecishu` int(11) NOT NULL DEFAULT '0' COMMENT '借阅次数',
  `faburen` varchar(50) NOT NULL COMMENT '发布人',
  `tushuzhuangtai` varchar(50) NOT NULL COMMENT '图书状态',
  `tushuxiangqing` longtext NOT NULL COMMENT '图书详情',
  `issh` varchar(10) NOT NULL DEFAULT '否' COMMENT '是否审核',
  PRIMARY KEY (`id`),
  KEY `tushuxinxi_tushufenlei_index` (`tushufenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='图书信息';

-- ----------------------------
-- Records of tushuxinxi
-- ----------------------------
INSERT INTO `tushuxinxi` VALUES ('1', '2102201944264', '我愿乘风破浪', '6', '电子图书架', '/upload/20220222/433a926f-936f-4ee7-b3de-0c541e983797.png', '/upload/20220222/e879c9f3-0888-48b4-b135-802e273d14f0.mp4', '老舍', '上海出版社', '60.00', '1.00', '4', '222', '可借阅', '<h2><span class=\"head_title_name\" title=\"限量赠送价值129元气质提升专享课，先到先得！2020新世代生活美学，&ldquo;手执烟火以谋生，心怀诗意以谋爱&rdquo;！畅销书作者梁爽、灼见主编刘书彤、思想聚焦创始人吴雁温情推荐！&nbsp;&nbsp;\">限量赠送价值129元气质提升专享课，先到先得！2020新世代生活美学，&ldquo;手执烟火以谋生，心怀诗意以谋爱&rdquo;！畅销书作者梁爽、灼见主编刘书彤、思想聚焦创始人吴雁温情推荐！</span><img src=\"http://img55.ddimg.cn/99999990245186175.jpg\" /></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('2', '2102202004301', '维京时代与英格兰', '5', '电子图书架', '/upload/20220222/84524b4c-95a9-4092-a442-f50051865285.png', '/upload/20220222/e01efc83-c06d-4bf7-922c-dc3c26d88506.mp4', '老舍', '上海出版社', '30.00', '1.00', '8', '111', '可借阅', '<h2><span class=\"head_title_name\" title=\"颠覆维京海盗旧有形象，从神话和传说中发掘海面下隐藏的历史。 牛津大学博士埃莉诺&middot;帕克为您解读另类&ldquo;维京传奇&rdquo;。&nbsp;世间好书皆有温度,社科5折封顶,点击进入！&nbsp;\">颠覆维京海盗旧有形象，从神话和传说中发掘海面下隐藏的历史。 牛津大学博士埃莉诺&middot;帕克为您解读另类&ldquo;维京传奇&rdquo;。</span><img src=\"upload/f1ff3f097b2d3048432d1a695fd9fb08.png\" /></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('3', '2102202005414', '超快速提升Photoshop设计力', '4', '社区活动室图书架', '/upload/20220222/f336cb28-5227-47f9-aef4-2264b1ae3f58.png', '/upload/20220222/9bc58c81-2992-49b8-80e3-29d65f69c70c.mp4', '老舍', '北京出版社', '50.00', '0.00', '4', '333', '可借阅', '<h2><span class=\"head_title_name\" style=\"margin: 0px; padding: 0px; color: #323232;\" title=\"每个PSer都需要知道的87个关于选区的秘密，教你3秒钟高效做图！&nbsp;过年不打烊，科技图书，五折封顶&gt;&nbsp;\">每个PSer都需要知道的87个关于选区的秘密，教你3秒钟高效做图！</span></h2>\n<h2><span class=\"head_title_name\" style=\"margin: 0px; padding: 0px; color: #323232;\" title=\"每个PSer都需要知道的87个关于选区的秘密，教你3秒钟高效做图！&nbsp;过年不打烊，科技图书，五折封顶&gt;&nbsp;\">每个PSer都需要知道的87个关于选区的秘密，教你3秒钟高效做图！</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('4', '2102202007084', '西方博弈往事', '2', '社区活动室图书架', '/upload/20220222/7351ab96-c48c-498d-87e0-61ca26db99c8.png', '/upload/20220222/586efa30-0585-41cc-aaef-3bebbaf0bc08.mp4', 'DD', '上海出版社', '50.00', '0.00', '0', '333', '可借阅', '<h2><span class=\"head_title_name\" title=\"深入简出的讲述了公元1500年以来西方世界的经济军事冲突；用独特的视角还原真实西方的热血与残酷、辉煌与荒诞、文明与杀戮&hellip;&hellip;西方的发展史就是一部博弈史&nbsp;世间好书皆有温度,社科5折封顶,点击进入！&nbsp;\">深入简出的讲述了公元1500年以来西方世界的经济军事冲突；用独特的视角还原真实西方的热血与残酷、辉煌与荒诞、文明与杀戮&hellip;&hellip;西方的发展史就是一部博弈史</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('5', '2102202008222', '互链网', '4', '电子图书架', '/upload/20220222/472a9fd7-e36d-49eb-97c3-b95798122063.png', '/upload/20220222/b51b89f4-ff62-4553-a11d-5c07bfdf2305.mp4', '李四', '北京出版社', '50.00', '1.00', '2', '333', '可借阅', '<h2><span class=\"head_title_name\" style=\"margin: 0px; padding: 0px; color: #323232;\" title=\"互链网已经开始重塑世界 产业、科技、社会大洗牌时代来临 人类将从企业大组织结构时代向个人价值小单元结构时代过渡 新旧世界交替之际，我们将如何抉择？ 宋志平、俞敏洪、王文京、刘世英 联合推荐&nbsp;过年不打烊，科技图书，五折封顶&gt;&nbsp;\">互链网已经开始重塑世界 产业、科技、社会大洗牌时代来临 人类将从企业大组织结构时代向个人价值小单元结构时代过渡 新旧世界交替之际，我们将如何抉择？ 宋志平、俞敏洪、王文京、刘世英 联合推荐</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('6', '2102202009262', '小猫当当', '3', '电子图书架', '/upload/20220222/9897d4b0-d617-4e10-9135-dfd42ce8b834.png', '/upload/20220222/2e021031-157c-4ad1-bc7d-336f4d1303f4.mp4', '老舍', '上海出版社', '40.00', '0.00', '2', '222', '可借阅', '<h2><span class=\"head_title_name\" title=\"这只俏皮可爱、元气满满的小猫，就是孩子的真实缩影！畅销45年，日本销量达3300万册！10个贴近生活的故事，呵护孩子纯真的天性，自然养育好性格、好习惯。作家马伯庸、绘本妈妈海桐推荐（爱心树童书）&nbsp;&nbsp;\">这只俏皮可爱、元气满满的小猫，就是孩子的真实缩影！畅销45年，日本销量达3300万册！10个贴近生活的故事，呵护孩子纯真的天性，自然养育好性格、好习惯。作家马伯庸、绘本妈妈海桐推荐</span></h2>\n<p>&nbsp;</p>', '是');
INSERT INTO `tushuxinxi` VALUES ('7', '2102202011261', '丝绸之路', '5', '电子图书架', '/upload/20220222/ec171930-d2ec-4121-9dcd-a109b01d5be9.png', '/upload/20220222/ef6915b8-ecfd-4183-9a45-f8a0b6c34e79.mp4', '老舍', '北京出版社', '50.00', '1.00', '0', '222', '可借阅', '<h2><span class=\"head_title_name\" title=\"第十二届文津奖推荐图书！央视10分钟重磅推荐！《人民日报》4度推荐！新浪年度十大好书！牛津大学教授揭示&ldquo;一带一路&rdquo;倡议逻辑！第十二届文津图书奖推荐书目！豆瓣2016年度十大历史好书！读客熊猫君出品&nbsp;世间好书皆有温度,社科5折封顶,点击进入！&nbsp;\">第十二届文津奖推荐图书！央视10分钟重磅推荐！《人民日报》4度推荐！新浪年度十大好书！牛津大学教授揭示&ldquo;一带一路&rdquo;倡议逻辑！第十二届文津图书奖推荐书目！豆瓣2016年度十大历史好书</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('8', '2102202012304', '谁动了我的奶酪', '3', '电子图书架', '/upload/20220222/559effc6-6337-4683-b609-4ed840798b85.png', '/upload/20220222/e66556c2-9801-42a4-9aea-bec9afb7b1e5.mp4', '克斯利', '墨西哥出版', '30.00', '1.00', '1', '222', '可借阅', '<h2><span class=\"head_title_name\" title=\"应对黑天鹅事件的破局之法，每一个人一生都要学会的应变智慧。&ldquo;奶酪&rdquo;之父斯宾塞遗作，一个走出困境的绝妙方法。&nbsp;&nbsp;\">应对黑天鹅事件的破局之法，每一个人一生都要学会的应变智慧。&ldquo;奶酪&rdquo;之父斯宾塞遗作，一个走出困境的绝妙方法。</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('9', '2102202013200', '当你又忙又美', '6', '电子图书架', '/upload/20220222/29bea44f-d747-41a6-856f-becf974af862.png', '/upload/20220222/e146647a-736b-44ad-bf5c-564851f0ec81.mp4', '老舍', '北京出版社', '30.00', '1.00', '1', '222', '可借阅', '<h2><span class=\"head_title_name\" title=\"&ldquo;又忙又美&rdquo;是激励百万读者的自律小天后梁爽开给所有女性的一剂良方。忙，修炼一种离开谁都能活得更精彩的能力；美，懂得欣赏自己、享受生活，敢于追求漂亮的人生。&nbsp;&nbsp;\">&ldquo;又忙又美&rdquo;是激励百万读者的自律小天后梁爽开给所有女性的一剂良方。忙，修炼一种离开谁都能活得更精彩的能力；美，懂得欣赏自己、享受生活，敢于追求漂亮的人生。</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('10', '2102202014092', '活出心花怒放的人生', '2', '社区活动室图书架', '/upload/20220222/1ab2692a-0b3f-43fe-99bf-aa37e6db92bc.png', '/upload/20220222/35791a1f-2d76-416c-91e1-5071eee9bb96.mp4', '老舍', '上海出版', '50.00', '1.00', '0', '111', '可借阅', '<h2><span class=\"head_title_name\" title=\"中国积极心理学发起人、清华心理学系主任彭凯平全新力作 直击工作、爱情、婚姻、人际、亲子等人生课题 樊登、李善友、津巴多、塞利格曼推荐阅读&nbsp;&nbsp;\">中国积极心理学发起人、清华心理学系主任彭凯平全新力作 直击工作、爱情、婚姻、人际、亲子等人生课题 樊登、李善友、津巴多、塞利格曼推荐阅读</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('11', '2102202015060', '硬核原始人', '1', '电子图书架', '/upload/20220222/71250cc8-da80-449f-bdce-2495ea8f28b1.png', '/upload/20220222/bd2eef5b-ad4e-48ff-b307-e56cc22b8293.mp4', '老舍', '北京出版', '30.00', '1.00', '0', '111', '可借阅', '<h2><span class=\"head_title_name\" title=\"一场跨越多学科、纵贯700万年的人类寻根之旅，超200幅全彩插图和资料照片，多维呈现国内外新鲜考古资讯和人类学前沿研究成果，轻松读懂&ldquo;疯狂原始人&rdquo;从野蛮到文明的硬核之路&nbsp;世间好书皆有温度,社科5折封顶,点击进入！&nbsp;\">一场跨越多学科、纵贯700万年的人类寻根之旅，超200幅全彩插图和资料照片，多维呈现国内外新鲜考古资讯和人类学前沿研究成果，轻松读懂&ldquo;疯狂原始人&rdquo;从野蛮到文明的硬核之路</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('12', '2102202016061', '外贸高手', '6', '社区活动室图书架', '/upload/20220222/e98cf67f-cdda-4305-bd3a-af06e6cd9a62.png', '/upload/20220222/71209b44-f2f9-48db-8088-0ed9c2cf3efb.mp4', '张三', '上海出版', '30.00', '1.00', '1', '111', '可借阅', '<h2><span class=\"head_title_name\" title=\"一场跨越多学科、纵贯700万年的人类寻根之旅，超200幅全彩插图和资料照片，多维呈现国内外新鲜考古资讯和人类学前沿研究成果，轻松读懂&ldquo;疯狂原始人&rdquo;从野蛮到文明的硬核之路&nbsp;世间好书皆有温度,社科5折封顶,点击进入！&nbsp;\">一场跨越多学科、纵贯700万年的人类寻根之旅，超200幅全彩插图和资料照片，多维呈现国内外新鲜考古资讯和人类学前沿研究成果，轻松读懂&ldquo;疯狂原始人&rdquo;从野蛮到文明的硬核之路</span></h2>', '是');
INSERT INTO `tushuxinxi` VALUES ('13', '022216598686', '红楼梦', '1', '电子图书架', '/upload/20220222/3471de18-8b00-4602-aa10-61946c6ed6c0.png', '/upload/20220222/38e733d6-7d46-44b3-a65d-ffcce5088b51.mp4', 'DD', 'XXXX出版社', '50.00', '0.00', '1', '444', '可借阅', '<p>图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情</p>', '是');
INSERT INTO `tushuxinxi` VALUES ('14', '022218516981', '西游记', '1', '社区活动室图书架', '/upload/20220222/076c5ee1-d7a6-4187-83c0-edd8a2ec47eb.png', '/upload/20220222/96f1c17b-4f7d-4643-8910-ce94cf664f94.mp4', '唐僧', 'XXXX出版社', '60.00', '2.00', '1', '555', '可借阅', '<p>图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情</p>', '是');
INSERT INTO `tushuxinxi` VALUES ('15', '022218527839', '免费书', '5', '社区活动室图书架', '/upload/20220222/55cf4f88-3e08-4308-a8d3-3f5353f00f43.png', '/upload/20220222/2613dd9d-6e42-4fe2-ab5c-0b9d7055cf93.mp4', '作者', '出版社', '12.00', '0.00', '1', '555', '可借阅', '<p>图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情图书详情</p>', '是');

-- ----------------------------
-- Table structure for `yonghu`
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) NOT NULL COMMENT '账号',
  `mima` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(10) NOT NULL COMMENT '性别',
  `shouji` varchar(50) NOT NULL COMMENT '手机',
  `youxiang` varchar(50) NOT NULL COMMENT '邮箱',
  `shenfenzheng` varchar(50) NOT NULL COMMENT '身份证',
  `touxiang` varchar(255) NOT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES ('1', '111', '111', '大大', '男', '13456789101', '5646@qq.com', '456465465464644646', '/upload/20220222/7ffc6822-9461-4b8d-bdb0-18b865a28895.png');
INSERT INTO `yonghu` VALUES ('2', '222', '222', '小小', '女', '12346546777', '654654@qq.com', '456465456464646464', '/upload/20220222/a5c1f218-24f4-4072-ae8c-92ad81cdd2fb.png');
INSERT INTO `yonghu` VALUES ('3', '333', '333', '张三', '男', '15646464444', '654654@qq.com', '564654646464646464', '/upload/20220222/1e36f48b-3b63-4cc4-ad14-0f88d585ce3d.png');
INSERT INTO `yonghu` VALUES ('4', '444', '444', '李四', '女', '16456464444', '56465@qq.com', '564654646464646466', '/upload/20220222/ce1f720b-4f71-48a2-b403-241e2c390aae.png');
INSERT INTO `yonghu` VALUES ('5', '555', '555', '老5', '男', '12345674894', '5645646@qq.com', '456464654654646464', '/upload/20220222/478b2f7a-6ba1-4e2d-9e58-8cbd16a487b7.png');
