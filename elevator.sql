/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : localhost:3306
 Source Schema         : elevator

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 17/12/2018 19:59:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for eleinfo
-- ----------------------------
DROP TABLE IF EXISTS `eleinfo`;
CREATE TABLE `eleinfo`  (
  `eleid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eletype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `elecreatedate` date NULL DEFAULT NULL,
  `elerange` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eleaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `elelastmtdate` date NULL DEFAULT NULL,
  UNIQUE INDEX `eleid`(`eleid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eleinfo
-- ----------------------------
INSERT INTO `eleinfo` VALUES ('1', 'DT-1#-1', '2006-01-01', '滨江区', '杭州市滨江区火炬大道跟滨文路交叉口', '2018-12-17');
INSERT INTO `eleinfo` VALUES ('10', 'DT-5#-1', '2002-01-02', '滨江区', '杭州市滨江区东信大道', '2018-04-05');
INSERT INTO `eleinfo` VALUES ('11', 'WXDT-5#-2', '2001-07-10', '拱墅区', '杭州市拱墅区上塘路拱北小区', '2018-12-17');
INSERT INTO `eleinfo` VALUES ('12', 'DT-6#-1', '2001-07-10', '拱墅区', '杭州市拱墅区上塘路拱北小区', '2018-04-15');
INSERT INTO `eleinfo` VALUES ('13', 'WXDT-6#-2', '2001-07-10', '拱墅区', '杭州市拱墅区上塘路拱北小区', '2018-04-29');
INSERT INTO `eleinfo` VALUES ('14', 'DT-7#-1', '2001-07-10', '拱墅区', '杭州市拱墅区上塘路拱北小区', '2018-04-20');
INSERT INTO `eleinfo` VALUES ('15', 'WXDT-7#-2', '2006-06-01', '拱墅区', '杭州市拱墅区莫干山路110号', '2018-04-29');
INSERT INTO `eleinfo` VALUES ('16', 'DT-8#-1', '1999-01-01', '拱墅区', '杭州市拱墅区湖墅南路356号	', '2018-04-06');
INSERT INTO `eleinfo` VALUES ('17', 'WXDT-8#-2', '1998-07-23', '拱墅区', '拱墅区莫干山路102号', '2018-04-29');
INSERT INTO `eleinfo` VALUES ('18', 'DT-9#-1', '2006-05-12', '拱墅区', '杭州市拱墅区教工路590号', '2018-04-30');
INSERT INTO `eleinfo` VALUES ('19', 'WXDT-9#-2', '2007-08-09', '拱墅区', '杭州市拱墅区莫干山路789号', '2018-04-28');
INSERT INTO `eleinfo` VALUES ('2', 'WXDT-1#-2', '2006-01-01', '滨江区', '杭州市滨江区火炬大道跟滨文路交叉口', '2018-12-12');
INSERT INTO `eleinfo` VALUES ('20', 'DT-10#-1', '2007-08-09', '拱墅区', '杭州市拱墅区莫干山路789号', '2018-04-05');
INSERT INTO `eleinfo` VALUES ('21', 'WXDT-10#-2', '2007-08-09', '拱墅区', '杭州市拱墅区莫干山路789号', '2018-04-05');
INSERT INTO `eleinfo` VALUES ('22', 'DT-11#-1', '2007-08-09', '拱墅区', '杭州市拱墅区莫干山路789号', '2018-03-30');
INSERT INTO `eleinfo` VALUES ('23', 'WXDT-11#-2', '2007-08-09', '拱墅区', '杭州市拱墅区莫干山路789号', '2018-05-09');
INSERT INTO `eleinfo` VALUES ('24', 'DT-12#-1', '2007-01-01', '拱墅区', '登云路427号	', '2018-05-17');
INSERT INTO `eleinfo` VALUES ('25', 'WXDT-12#-2', '2009-01-01', '拱墅区', '杭州市拱墅区阮家桥丰登街165号	', '2018-05-30');
INSERT INTO `eleinfo` VALUES ('26', 'WDT-13#', '2004-12-09', '拱墅区', '杭州市拱墅区登云路315号', '2018-06-01');
INSERT INTO `eleinfo` VALUES ('27', 'GPM-III', '2004-12-09', '拱墅区', '杭州市拱墅区登云路315号', '2018-05-02');
INSERT INTO `eleinfo` VALUES ('28', 'HOPE-II', '2004-12-09', '拱墅区', '杭州市拱墅区登云路315号', '2018-05-06');
INSERT INTO `eleinfo` VALUES ('29', 'ELENESSA', '2008-06-02', '拱墅区', '杭州市拱墅区和睦路与大关路口', '2018-05-20');
INSERT INTO `eleinfo` VALUES ('3', 'DT-2#-1', '2010-01-01', '滨江区', '滨江区江南大道3688号', '2018-12-13');
INSERT INTO `eleinfo` VALUES ('30', 'NexWay', '2002-01-01', '拱墅区', '杭州市拱墅区密渡桥路19号	', '2018-05-26');
INSERT INTO `eleinfo` VALUES ('31', 'NexWay-S', '2002-02-01', '拱墅区', '杭州拱墅区德胜路385号	', '2018-05-30');
INSERT INTO `eleinfo` VALUES ('32', 'GPS-III-KX2S', '2009-01-01', '拱墅区', '杭州市拱墅区丽水路276号', '2018-05-09');
INSERT INTO `eleinfo` VALUES ('33', 'GPS-III-CX7S', '2004-10-14', '拱墅区', '杭州市拱墅区丰潭路', '2018-05-18');
INSERT INTO `eleinfo` VALUES ('34', 'ELE-NZ10S', '2004-05-19', '拱墅区', '古墩路', '2018-05-05');
INSERT INTO `eleinfo` VALUES ('35', 'ELE-NZ30S', '2010-10-01', '江干区', '江干区清江路122号	', '2018-05-27');
INSERT INTO `eleinfo` VALUES ('36', 'ELE-NZ31S', '2010-01-01', '江干区', '江干区天城路秋涛北路', '2018-05-01');
INSERT INTO `eleinfo` VALUES ('37', 'HIVF', '2010-01-01', '江干区', '杭州市江干区新塘路58号', '2018-05-05');
INSERT INTO `eleinfo` VALUES ('38', 'HYF', '2012-04-01', '江干区', '江干区钱江路与江锦路交叉口', '2018-05-12');
INSERT INTO `eleinfo` VALUES ('39', 'SC200', '2011-04-01', '江干区', '江干区钱江路与江锦路交叉口', '2018-05-12');
INSERT INTO `eleinfo` VALUES ('4', 'WXDT-2#-2', '2001-02-15', '滨江区', '杭州市滨江区滨安路1358号', '2018-04-16');
INSERT INTO `eleinfo` VALUES ('40', 'LEHY', '2006-01-23', '江干区', '江干区池塘庙公交车停车站边', '2018-05-15');
INSERT INTO `eleinfo` VALUES ('41', 'SCD200GZ', '1994-07-23', '江干区', '杭州市江干区秋涛北路178号', '2018-05-26');
INSERT INTO `eleinfo` VALUES ('42', 'SD-BS', '2008-02-03', '江干区', '江干区石桥路198号（与德胜路交界处）', '2018-05-24');
INSERT INTO `eleinfo` VALUES ('43', 'SC200TD', '2002-05-01', '江干区', '杭州市江干区凤起东路60号', '2018-05-04');
INSERT INTO `eleinfo` VALUES ('44', 'THJ-3000', '2011-01-01', '江干区', '江干区三新路景芳路', '2018-05-19');
INSERT INTO `eleinfo` VALUES ('45', 'THJ-3000', '2010-12-01', '江干区', '江干区三新路景御路', '2018-05-25');
INSERT INTO `eleinfo` VALUES ('46', 'HOPE-IIG', '2007-11-01', '江干区', '杭州市江干区景昙路三新家园西区	', '2018-05-17');
INSERT INTO `eleinfo` VALUES ('47', 'SCD200', '2002-05-21', '江干区', '杭州市江干区景昙路', '2018-05-03');
INSERT INTO `eleinfo` VALUES ('48', 'NexWay-S', '2009-01-01', '江干区', '江干区景昙路	', '2018-05-18');
INSERT INTO `eleinfo` VALUES ('49', 'GPS-III-KX2S', '2007-10-01', '江干区', '杭州市江干区富春路889号	', '2018-05-05');
INSERT INTO `eleinfo` VALUES ('5', 'DT-3#-1', '2000-05-09', '滨江区', '杭州市滨江区创业路1号', '2018-04-21');
INSERT INTO `eleinfo` VALUES ('50', 'GPS-III-CX7S', '2007-09-23', '江干区', '江干区钱潮路10号', '2018-05-23');
INSERT INTO `eleinfo` VALUES ('51', 'ELE-NZ10S', '2010-01-01', '江干区', '江干区昙花庵路58号', '2018-05-22');
INSERT INTO `eleinfo` VALUES ('52', 'ELE-NZ30S', '2010-01-01', '江干区', '江干区凤起东路新塘路交界', '2018-05-07');
INSERT INTO `eleinfo` VALUES ('53', 'ELE-NZ31S', '2005-01-01', '江干区', '凯旋路258号', '2018-05-09');
INSERT INTO `eleinfo` VALUES ('54', 'HIVF', '2008-06-02', '江干区', '杭州市江干区凯旋路258号', '2018-05-21');
INSERT INTO `eleinfo` VALUES ('55', 'HYF', '2004-01-01', '上城区', '上城区西湖大道198号', '2018-05-21');
INSERT INTO `eleinfo` VALUES ('56', 'NexWay', '2004-01-01', '上城区', '上城区西湖大道198号	', '2018-05-31');
INSERT INTO `eleinfo` VALUES ('57', 'GPM-III', '2002-04-14', '上城区', '杭州市上城区近江住宅区', '2018-05-31');
INSERT INTO `eleinfo` VALUES ('58', 'SCD2002TD', '2002-02-14', '上城区', '上城区近江住宅区', '2018-05-21');
INSERT INTO `eleinfo` VALUES ('59', 'NexWay', '2000-11-12', '上城区', '杭州市上城区紫金观巷26号', '2018-05-03');
INSERT INTO `eleinfo` VALUES ('6', 'WDT-3#-2', '2006-01-01', '滨江区', '杭州市滨江区文涛路5003号', '2018-04-08');
INSERT INTO `eleinfo` VALUES ('60', 'SCD2002', '2011-01-01', '上城区', '上城区钱江路与望江东路交界处', '2018-05-10');
INSERT INTO `eleinfo` VALUES ('61', 'NexWay', '2011-01-01', '上城区', '上城区汽车南站东宝路', '2018-05-13');
INSERT INTO `eleinfo` VALUES ('62', 'SCD2002TD', '2006-06-01', '上城区', '杭州市延安南路9号', '2018-05-06');
INSERT INTO `eleinfo` VALUES ('63', 'HIVF', '2006-06-01', '上城区', '杭州市延安南路9号', '2018-05-28');
INSERT INTO `eleinfo` VALUES ('64', 'HYF', '2001-01-01', '上城区', '杭州市上城区江城路889号', '2018-05-30');
INSERT INTO `eleinfo` VALUES ('65', 'SC200TD', '2003-03-14', '上城区', '上城区富春江路10号', '2018-05-28');
INSERT INTO `eleinfo` VALUES ('66', 'THJ-3000', '2003-03-14', '上城区', '上城区富春江路10号', '2018-05-07');
INSERT INTO `eleinfo` VALUES ('67', 'SC200TD', '1995-10-23', '上城区', '杭州市上城区惠民路22号', '2018-05-03');
INSERT INTO `eleinfo` VALUES ('68', 'HOPE-IIG', '1998-10-05', '西湖区', '杭州西湖区保俶路117号', '2018-05-28');
INSERT INTO `eleinfo` VALUES ('69', 'HYF', '2002-01-11', '西湖区', '西湖区天目山路51—53号	', '2018-05-11');
INSERT INTO `eleinfo` VALUES ('7', 'WDT-4#-1', '2006-06-02', '滨江区', '杭州市滨江区江南大道4777号', '2018-04-14');
INSERT INTO `eleinfo` VALUES ('70', 'SC200TD', '2009-01-01', '西湖区', '古墩路与申花路交界处浙大紫荆港', '2018-05-03');
INSERT INTO `eleinfo` VALUES ('71', 'THJ-3000', '2009-01-01', '西湖区', '古墩路与申花路交界处浙大紫荆港', '2018-05-04');
INSERT INTO `eleinfo` VALUES ('72', 'SC200', '2009-01-01', '西湖区', '古墩路与申花路交界处浙大紫荆港', '2018-05-17');
INSERT INTO `eleinfo` VALUES ('73', 'LEHY', '2003-01-01', '西湖区', '西湖区莫干山路501号', '2018-05-09');
INSERT INTO `eleinfo` VALUES ('74', 'SCD200GZ', '1996-01-01', '西湖区', '西湖区文三路465-467号', '2018-05-10');
INSERT INTO `eleinfo` VALUES ('75', 'SD-BS', '1993-01-01', '西湖区', '浙江省杭州市西湖区学院路130号	', '2018-05-22');
INSERT INTO `eleinfo` VALUES ('76', 'SC200TD', '2007-08-31', '西湖区', '西湖区益乐路与文一西路交叉口', '2018-05-21');
INSERT INTO `eleinfo` VALUES ('77', 'THJ-3000', '2007-12-01', '西湖区', '西湖区保淑北路12号', '2018-05-06');
INSERT INTO `eleinfo` VALUES ('78', 'GPM-III', '2002-01-01', '西湖区', '杭州市西湖区文三路508', '2018-05-13');
INSERT INTO `eleinfo` VALUES ('79', 'HOPE-IIG', '2000-12-13', '西湖区', '杭州市西湖区文三路', '2018-05-23');
INSERT INTO `eleinfo` VALUES ('8', 'WDT-4#-2', '2009-01-01', '滨江区', '滨江区东信大道1222号', '2018-04-20');
INSERT INTO `eleinfo` VALUES ('80', 'SCD200', '2002-01-01', '西湖区', '杭州市西湖区文三路498', '2018-05-24');
INSERT INTO `eleinfo` VALUES ('81', 'NexWay-S', '2002-01-01', '西湖区', '杭州市西湖区文三路498', '2018-05-22');
INSERT INTO `eleinfo` VALUES ('82', 'GPS-III-KX2S', '2007-03-20', '西湖区', '杭州市西湖区教工路197号', '2018-05-12');
INSERT INTO `eleinfo` VALUES ('83', 'GPS-III-CX7S', '2002-11-02', '西湖区', '杭州西湖区五云3路', '2018-05-10');
INSERT INTO `eleinfo` VALUES ('84', 'WXDT-10#-2', '2011-02-01', '下城区', '回龙路与杭波路交叉处', '2018-05-01');
INSERT INTO `eleinfo` VALUES ('85', 'DT-11#-1', '2005-01-01', '下城区', '下城区东新路1026号', '2018-05-13');
INSERT INTO `eleinfo` VALUES ('86', 'WXDT-11#-2', '2005-01-01', '下城区', '永清路与永潮街交叉', '2018-06-01');
INSERT INTO `eleinfo` VALUES ('87', 'DT-12#-1', '2005-01-01', '下城区', '下城区竹清路', '2018-05-23');
INSERT INTO `eleinfo` VALUES ('88', 'WXDT-12#-2', '2005-01-01', '下城区', '下城区永清路25号', '2018-05-29');
INSERT INTO `eleinfo` VALUES ('89', 'WDT-13#', '2005-01-01', '下城区', '下城区竹清路', '2018-05-12');
INSERT INTO `eleinfo` VALUES ('9', 'XDT-4#-3', '2005-08-09', '滨江区', '杭州市滨江区江南大道3688号', '2018-04-03');
INSERT INTO `eleinfo` VALUES ('90', 'GPM-III', '2005-01-01', '下城区', '下城区东新路永清路交叉', '2018-05-06');
INSERT INTO `eleinfo` VALUES ('91', 'HOPE-II', '2007-11-10', '下城区', '杭州市下城区刀茅巷17号', '2018-05-23');
INSERT INTO `eleinfo` VALUES ('92', 'ELENESSA', '2005-10-01', '下城区', '杭州市下城区庆春路136号', '2018-05-09');
INSERT INTO `eleinfo` VALUES ('93', 'NexWay', '2006-01-01', '下城区', '下城区东健康路27号	', '2018-05-21');
INSERT INTO `eleinfo` VALUES ('94', 'NexWay-S', '2004-01-01', '下城区', '杭州市香积寺路162号', '2018-05-30');
INSERT INTO `eleinfo` VALUES ('95', 'GPS-III-KX2S', '1999-09-01', '下城区', '杭州市下城区河东路91号朝晖七小区1号楼', '2018-05-20');
INSERT INTO `eleinfo` VALUES ('96', 'SC200TD', '1995-01-01', '下城区', '下城区延安路593号', '2018-05-05');
INSERT INTO `eleinfo` VALUES ('97', 'THJ-3000', '2008-02-01', '下城区', '杭州下城区白石路368号', '2018-05-24');
INSERT INTO `eleinfo` VALUES ('98', 'HOPE-II', '2006-12-01', '下城区', '杭州下城区白石路368号', '2018-05-22');
INSERT INTO `eleinfo` VALUES ('99', 'HOPE-IIG', '2008-02-01', '下城区', '杭州下城区白石路368号', '2018-05-19');

-- ----------------------------
-- Table structure for eleruninfo
-- ----------------------------
DROP TABLE IF EXISTS `eleruninfo`;
CREATE TABLE `eleruninfo`  (
  `eleid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eleisrunning` tinyint(255) NULL DEFAULT NULL,
  `elerunningtime` int(255) NULL DEFAULT NULL,
  `eleerrormsg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  UNIQUE INDEX `eleid`(`eleid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eleruninfo
-- ----------------------------
INSERT INTO `eleruninfo` VALUES ('1', 0, 0, '电梯故障');
INSERT INTO `eleruninfo` VALUES ('2', 1, 120, NULL);
INSERT INTO `eleruninfo` VALUES ('3', 1, 96, NULL);
INSERT INTO `eleruninfo` VALUES ('4', 1, 5880, NULL);
INSERT INTO `eleruninfo` VALUES ('5', 1, 5760, NULL);
INSERT INTO `eleruninfo` VALUES ('6', 1, 6072, NULL);
INSERT INTO `eleruninfo` VALUES ('7', 1, 5928, NULL);
INSERT INTO `eleruninfo` VALUES ('8', 1, 5784, NULL);
INSERT INTO `eleruninfo` VALUES ('9', 1, 6192, NULL);
INSERT INTO `eleruninfo` VALUES ('10', 1, 6144, NULL);
INSERT INTO `eleruninfo` VALUES ('11', 0, 0, '断电');
INSERT INTO `eleruninfo` VALUES ('12', 1, 5904, NULL);
INSERT INTO `eleruninfo` VALUES ('13', 1, 5568, NULL);
INSERT INTO `eleruninfo` VALUES ('14', 1, 5784, NULL);
INSERT INTO `eleruninfo` VALUES ('15', 1, 5568, NULL);
INSERT INTO `eleruninfo` VALUES ('16', 1, 6120, NULL);
INSERT INTO `eleruninfo` VALUES ('17', 1, 5568, NULL);
INSERT INTO `eleruninfo` VALUES ('18', 1, 5544, NULL);
INSERT INTO `eleruninfo` VALUES ('19', 1, 5592, NULL);
INSERT INTO `eleruninfo` VALUES ('20', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('21', 1, 6144, NULL);
INSERT INTO `eleruninfo` VALUES ('22', 1, 6288, NULL);
INSERT INTO `eleruninfo` VALUES ('23', 0, 0, '断电');
INSERT INTO `eleruninfo` VALUES ('24', 1, 5136, NULL);
INSERT INTO `eleruninfo` VALUES ('25', 1, 4824, NULL);
INSERT INTO `eleruninfo` VALUES ('26', 1, 4776, NULL);
INSERT INTO `eleruninfo` VALUES ('27', 1, 5496, NULL);
INSERT INTO `eleruninfo` VALUES ('28', 1, 5400, NULL);
INSERT INTO `eleruninfo` VALUES ('29', 0, 0, '未知错误，待检查');
INSERT INTO `eleruninfo` VALUES ('30', 1, 4920, NULL);
INSERT INTO `eleruninfo` VALUES ('31', 1, 4824, NULL);
INSERT INTO `eleruninfo` VALUES ('32', 1, 5328, NULL);
INSERT INTO `eleruninfo` VALUES ('33', 1, 5112, NULL);
INSERT INTO `eleruninfo` VALUES ('34', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('35', 1, 4896, NULL);
INSERT INTO `eleruninfo` VALUES ('36', 1, 5520, NULL);
INSERT INTO `eleruninfo` VALUES ('37', 1, 5424, NULL);
INSERT INTO `eleruninfo` VALUES ('38', 1, 5256, NULL);
INSERT INTO `eleruninfo` VALUES ('39', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('40', 1, 5184, NULL);
INSERT INTO `eleruninfo` VALUES ('41', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('42', 1, 4968, NULL);
INSERT INTO `eleruninfo` VALUES ('43', 0, 0, '电路故障');
INSERT INTO `eleruninfo` VALUES ('44', 1, 5088, NULL);
INSERT INTO `eleruninfo` VALUES ('45', 1, 4944, NULL);
INSERT INTO `eleruninfo` VALUES ('46', 1, 5136, NULL);
INSERT INTO `eleruninfo` VALUES ('47', 1, 5472, NULL);
INSERT INTO `eleruninfo` VALUES ('48', 1, 5112, NULL);
INSERT INTO `eleruninfo` VALUES ('49', 1, 5424, NULL);
INSERT INTO `eleruninfo` VALUES ('50', 1, 4992, NULL);
INSERT INTO `eleruninfo` VALUES ('51', 1, 5016, NULL);
INSERT INTO `eleruninfo` VALUES ('52', 1, 5376, NULL);
INSERT INTO `eleruninfo` VALUES ('53', 1, 5328, NULL);
INSERT INTO `eleruninfo` VALUES ('54', 1, 5040, NULL);
INSERT INTO `eleruninfo` VALUES ('55', 1, 5040, NULL);
INSERT INTO `eleruninfo` VALUES ('56', 1, 4800, NULL);
INSERT INTO `eleruninfo` VALUES ('57', 1, 4800, NULL);
INSERT INTO `eleruninfo` VALUES ('58', 1, 5040, NULL);
INSERT INTO `eleruninfo` VALUES ('59', 1, 5472, NULL);
INSERT INTO `eleruninfo` VALUES ('60', 1, 5304, NULL);
INSERT INTO `eleruninfo` VALUES ('61', 1, 5232, NULL);
INSERT INTO `eleruninfo` VALUES ('62', 1, 5400, NULL);
INSERT INTO `eleruninfo` VALUES ('63', 0, 0, '未知错误，待检查');
INSERT INTO `eleruninfo` VALUES ('64', 1, 4824, NULL);
INSERT INTO `eleruninfo` VALUES ('65', 0, 0, '断电');
INSERT INTO `eleruninfo` VALUES ('66', 0, 0, '未知错误，待检查');
INSERT INTO `eleruninfo` VALUES ('67', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('68', 1, 4872, NULL);
INSERT INTO `eleruninfo` VALUES ('69', 1, 5280, NULL);
INSERT INTO `eleruninfo` VALUES ('70', 0, 0, '更换配件');
INSERT INTO `eleruninfo` VALUES ('71', 1, 5448, NULL);
INSERT INTO `eleruninfo` VALUES ('72', 0, 0, NULL);
INSERT INTO `eleruninfo` VALUES ('73', 1, 5328, '断电');
INSERT INTO `eleruninfo` VALUES ('74', 1, 5304, NULL);
INSERT INTO `eleruninfo` VALUES ('75', 1, 5016, NULL);
INSERT INTO `eleruninfo` VALUES ('76', 1, 5040, NULL);
INSERT INTO `eleruninfo` VALUES ('77', 0, 0, '正在维检');
INSERT INTO `eleruninfo` VALUES ('78', 1, 5232, NULL);
INSERT INTO `eleruninfo` VALUES ('79', 0, 0, '未知错误，待检查');
INSERT INTO `eleruninfo` VALUES ('80', 1, 4968, NULL);
INSERT INTO `eleruninfo` VALUES ('81', 1, 5016, NULL);
INSERT INTO `eleruninfo` VALUES ('82', 1, 5256, NULL);
INSERT INTO `eleruninfo` VALUES ('83', 1, 5304, NULL);
INSERT INTO `eleruninfo` VALUES ('84', 1, 5520, NULL);
INSERT INTO `eleruninfo` VALUES ('85', 1, 5232, NULL);
INSERT INTO `eleruninfo` VALUES ('86', 1, 4776, NULL);
INSERT INTO `eleruninfo` VALUES ('87', 1, 4992, NULL);
INSERT INTO `eleruninfo` VALUES ('88', 1, 4848, NULL);
INSERT INTO `eleruninfo` VALUES ('89', 1, 5256, NULL);
INSERT INTO `eleruninfo` VALUES ('90', 1, 5400, NULL);
INSERT INTO `eleruninfo` VALUES ('91', 1, 4992, NULL);
INSERT INTO `eleruninfo` VALUES ('92', 1, 5328, NULL);
INSERT INTO `eleruninfo` VALUES ('93', 1, 5040, NULL);
INSERT INTO `eleruninfo` VALUES ('94', 1, 4824, NULL);
INSERT INTO `eleruninfo` VALUES ('95', 1, 5064, NULL);
INSERT INTO `eleruninfo` VALUES ('96', 1, 5424, NULL);
INSERT INTO `eleruninfo` VALUES ('97', 1, 4968, NULL);
INSERT INTO `eleruninfo` VALUES ('98', 1, 5016, NULL);
INSERT INTO `eleruninfo` VALUES ('99', 1, 5088, NULL);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `useradmin` tinyint(255) NULL DEFAULT NULL,
  `userrange` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `useronline` tinyint(255) NULL DEFAULT NULL,
  UNIQUE INDEX `userid`(`userid`) USING BTREE,
  INDEX `useradmin`(`useradmin`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '邓成礼', 1, '滨江区', 1);
INSERT INTO `userinfo` VALUES ('2', '秦德海', 1, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('3', '薛恺乐', 1, '上城区', 0);
INSERT INTO `userinfo` VALUES ('4', '冯学林', 1, '江干区', 1);
INSERT INTO `userinfo` VALUES ('5', '薛奇迈', 1, '西湖区', 0);
INSERT INTO `userinfo` VALUES ('6', '彭元良', 0, '下城区', 0);
INSERT INTO `userinfo` VALUES ('7', '沈刚洁', 0, '西湖区', 0);
INSERT INTO `userinfo` VALUES ('8', '熊建章', 0, '下城区', 1);
INSERT INTO `userinfo` VALUES ('9', '李翰学', 0, '江干区', 1);
INSERT INTO `userinfo` VALUES ('10', '蒋明诚', 0, '西湖区', 1);
INSERT INTO `userinfo` VALUES ('11', '王敏达', 0, '上城区', 0);
INSERT INTO `userinfo` VALUES ('12', '郭鸿轩', 0, '上城区', 1);
INSERT INTO `userinfo` VALUES ('13', '廖高雅', 0, '江干区', 1);
INSERT INTO `userinfo` VALUES ('14', '邹宏旷', 0, '下城区', 0);
INSERT INTO `userinfo` VALUES ('15', '夏子昂', 0, '江干区', 1);
INSERT INTO `userinfo` VALUES ('16', '顾修筠', 0, '拱墅区', 1);
INSERT INTO `userinfo` VALUES ('17', '邓奇水', 0, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('18', '冯永嘉', 0, '上城区', 1);
INSERT INTO `userinfo` VALUES ('19', '石飞翮', 0, '江干区', 1);
INSERT INTO `userinfo` VALUES ('20', '杨成业', 0, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('21', '孙文轩', 0, '上城区', 0);
INSERT INTO `userinfo` VALUES ('22', '曾嘉平', 0, '拱墅区', 1);
INSERT INTO `userinfo` VALUES ('23', '许睿明', 0, '上城区', 0);
INSERT INTO `userinfo` VALUES ('24', '魏飞宇', 0, '上城区', 0);
INSERT INTO `userinfo` VALUES ('25', '苏浩邈', 0, '下城区', 0);
INSERT INTO `userinfo` VALUES ('26', '金鸿波', 0, '上城区', 0);
INSERT INTO `userinfo` VALUES ('27', '曾天干', 0, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('28', '陈彭湃', 0, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('29', '孔乐安', 0, '江干区', 0);
INSERT INTO `userinfo` VALUES ('30', '顾元基', 0, '下城区', 1);
INSERT INTO `userinfo` VALUES ('31', '龚兴安', 0, '拱墅区', 1);
INSERT INTO `userinfo` VALUES ('32', '何彭越', 0, '拱墅区', 0);
INSERT INTO `userinfo` VALUES ('33', '余英纵', 0, '下城区', 0);
INSERT INTO `userinfo` VALUES ('34', '孙华藏', 0, '滨江区', 0);
INSERT INTO `userinfo` VALUES ('35', '魏凯歌', 0, '拱墅区', 1);
INSERT INTO `userinfo` VALUES ('36', '郝彬炳', 0, '滨江区', 1);
INSERT INTO `userinfo` VALUES ('37', '余学义', 0, '滨江区', 0);
INSERT INTO `userinfo` VALUES ('38', '邹彭湃', 0, '西湖区', 0);
INSERT INTO `userinfo` VALUES ('39', '袁鸿志', 0, '下城区', 1);
INSERT INTO `userinfo` VALUES ('40', '谢嘉慕', 0, '滨江区', 0);
INSERT INTO `userinfo` VALUES ('007', '007', 1, 'America', 1);

-- ----------------------------
-- Table structure for userlogininfo
-- ----------------------------
DROP TABLE IF EXISTS `userlogininfo`;
CREATE TABLE `userlogininfo`  (
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userpwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `useradmin` tinyint(255) NULL DEFAULT NULL,
  UNIQUE INDEX `userid`(`userid`) USING BTREE,
  INDEX `useradmin`(`useradmin`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userlogininfo
-- ----------------------------
INSERT INTO `userlogininfo` VALUES ('1', '000000', 1);
INSERT INTO `userlogininfo` VALUES ('2', '417672', 1);
INSERT INTO `userlogininfo` VALUES ('3', '584842', 1);
INSERT INTO `userlogininfo` VALUES ('4', '828256', 1);
INSERT INTO `userlogininfo` VALUES ('5', '112473', 0);
INSERT INTO `userlogininfo` VALUES ('6', '408128', 0);
INSERT INTO `userlogininfo` VALUES ('7', '162279', 0);
INSERT INTO `userlogininfo` VALUES ('8', '970071', 0);
INSERT INTO `userlogininfo` VALUES ('9', '621799', 0);
INSERT INTO `userlogininfo` VALUES ('10', '000000', 0);
INSERT INTO `userlogininfo` VALUES ('11', '308136', 0);
INSERT INTO `userlogininfo` VALUES ('12', '763594', 0);
INSERT INTO `userlogininfo` VALUES ('13', '231555', 0);
INSERT INTO `userlogininfo` VALUES ('14', '826846', 0);
INSERT INTO `userlogininfo` VALUES ('15', '242956', 0);
INSERT INTO `userlogininfo` VALUES ('16', '115175', 0);
INSERT INTO `userlogininfo` VALUES ('17', '449006', 0);
INSERT INTO `userlogininfo` VALUES ('18', '975066', 0);
INSERT INTO `userlogininfo` VALUES ('19', '932009', 0);
INSERT INTO `userlogininfo` VALUES ('20', '352572', 0);
INSERT INTO `userlogininfo` VALUES ('21', '856749', 0);
INSERT INTO `userlogininfo` VALUES ('22', '189299', 0);
INSERT INTO `userlogininfo` VALUES ('23', '422109', 0);
INSERT INTO `userlogininfo` VALUES ('24', '698182', 0);
INSERT INTO `userlogininfo` VALUES ('25', '599748', 0);
INSERT INTO `userlogininfo` VALUES ('26', '902410', 0);
INSERT INTO `userlogininfo` VALUES ('27', '841650', 0);
INSERT INTO `userlogininfo` VALUES ('28', '277161', 0);
INSERT INTO `userlogininfo` VALUES ('29', '585527', 0);
INSERT INTO `userlogininfo` VALUES ('30', '782815', 0);
INSERT INTO `userlogininfo` VALUES ('31', '405351', 0);
INSERT INTO `userlogininfo` VALUES ('32', '552091', 0);
INSERT INTO `userlogininfo` VALUES ('33', '608744', 0);
INSERT INTO `userlogininfo` VALUES ('34', '813743', 0);
INSERT INTO `userlogininfo` VALUES ('35', '538635', 0);
INSERT INTO `userlogininfo` VALUES ('36', '213469', 0);
INSERT INTO `userlogininfo` VALUES ('37', '694917', 0);
INSERT INTO `userlogininfo` VALUES ('38', '242379', 0);
INSERT INTO `userlogininfo` VALUES ('39', '521791', 0);
INSERT INTO `userlogininfo` VALUES ('40', '671886', 0);
INSERT INTO `userlogininfo` VALUES ('007', 'America', 1);

SET FOREIGN_KEY_CHECKS = 1;
