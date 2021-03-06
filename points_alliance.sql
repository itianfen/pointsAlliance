/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : points_alliance

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-08-20 16:45:33
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `TITLE`            varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文章标题',
    `INTRODUCTION`     varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文章介绍',
    `CONTENT`          longtext COLLATE utf8mb4_unicode_ci     NOT NULL COMMENT '文章内容',
    `IMG_URL`          varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文章介绍附图',
    `COMPANY_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '盟主ID',
    `CATEGORY_TYPE`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '文章类别 1文案 2软文 3晒单 4资讯',
    `CATEGORY_NAME`    varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别名称',
    `DELETED`          int(1)                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article`
VALUES ('210e05db23b14097ae3dad05064e18c6', '2020-08-12 11:51:52', '超级管理员', '999', '999', '2020-08-18 18:37:00',
        '超级管理员', '积分兑换市场的现状与未来', '积分兑换市场的现状与未来',
        '<p><blockquote>“ 积分兑换现金 ” &nbsp;很多人看好这个行业，并切实赚到了钱，然而仍有一小部分人对积分兑换将来的发展存在担心。综合信用卡及积分兑换行业多年的工作经验，笔者认为，信用卡积分的价值或许会降低，兑换限制可能会越来越多，但积分兑换仍会是一个长期存在并蓬勃发展的行业。</blockquote><br><br><br>积分是银行给用户刷卡的奖励，但积分的价值由银行根据其预算、宣传预期、活动力度等多方面因素来决定的，银行的预算高、想达到较好的宣传效果，其积分价值就高，相反则低。<br><br>从银行的角度来说，其发放的积分必然有一部分会被兑换、有一部分会被过期清零。当被兑换的部分超过银行的预算，银行就会降低积分价值。近年来，线上线下的积分兑换行业出现并迅速火爆，这必将成为银行主动降低积分价值、设定积分兑换限制的原因。<br><br><br><br><br>   <br>中国信用卡的历史不过30年而已，信用卡积分的历史则更短，且目前看来，积分制度是非常合理且运行稳定的，因此，信用卡积分制度在出现大的、革命性的变动之前不会消逝，信用卡积分兑换市场也将会长期存在。<br><br>另外，随着积分兑换行业的不断发展，用户对积分的认识会更深入，积分兑换的需求也会越来越旺盛，这无疑对整个行业的发展都是利好消息。<br><br>总之，对积分兑换的用户而言，积分的价值有可能会越来越低，应该尽快兑换，而对于积分兑换的代理而言，积分兑换将会是一个长期存在并能蓬勃发展的行业，可以放心加入并尽快在市场发展前期获得先发优势。</p>',
        'uploads/2020/8/18/35e6633714304b29843fb329e3f45791.jpg', '999', '2', '软文', '0', null, null, null, null, null);
INSERT INTO `article`
VALUES ('27d2831a24094f65a7ca69e10cc9663b', '2020-08-20 10:12:01', '超级管理员', '999', '999', '2020-08-20 13:40:43',
        '超级管理员', '信用卡之2583法则', '信用卡之2583法则',
        '<p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">其实所谓的</font>“<font face=\"Calibri\">2583</font><font face=\"宋体\">原则”是信用卡持有者总结的日常使用规则，是为了防止危险用卡、被封空，争取尽快提额而总结的惯性规律。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">“<font face=\"Calibri\">2583</font><font face=\"宋体\">”原则的具体意义</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">“<font face=\"Calibri\">2</font><font face=\"宋体\">”其实是指单笔消费金额不超过信用卡额度的</font><font face=\"Calibri\">20%</font><font face=\"宋体\">。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">如果信用卡持卡人连续出现大额消费，会引起银行的注意，容易被银行加强风控监测。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">“<font face=\"Calibri\">5</font><font face=\"宋体\">”其实是指单日消费金额不超过信用卡额度的</font><font face=\"Calibri\">50%</font><font face=\"宋体\">。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">这个道理和上面一样。如果用户经常在一天内消费的金额高于可用额度的</font>50%<font face=\"宋体\">，那么银行就很有可能怀疑用户在进行信用卡套现。银行会对其信用卡进行风控，影响持卡人的正常消费。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">“<font face=\"Calibri\">8</font><font face=\"宋体\">”其实是指单月消费金额不超过信用卡固定额度的</font><font face=\"Calibri\">80%</font><font face=\"宋体\">。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">这又是为什么呢？难道银行不应该喜欢消费金额高的用户吗？</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">难道不是花的越多，银行越认为你需要资金，给你提额吗？</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">其实不然当用户大量的消耗信用额度时，银行会认为用户短期内需要资金支持，但银行同样可能会认为用户短时间没有足够的还款能力，尤其是短期内的还款能力和资产均达不到银行的预期要求。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">这种情况下，银行还可能为了控制自身承受风险而给持卡人降额哦</font>~<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\">”3“<font face=\"宋体\">其实是指单月消费金额不得低于信用卡固定额度的</font><font face=\"Calibri\">30%</font><font face=\"宋体\">。</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">如果用户刷卡金额太少，或者是长时间不刷卡，对银行的贡献很小，银行赚不到利润的同时还会认为你其实并不需要这么多的额度。</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">这样不仅会影响你申请提额的成功率，持续数月还会大概率的被银行降额。</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">除了上述的</font>”2583<font face=\"宋体\">原则</font><font face=\"Calibri\">“</font><font face=\"宋体\">以外，持卡人也不要经常在固定的时间、固定的地点进行消费。</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p><p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\nmargin-top:72.0000pt;\nmargin-bottom:72.0000pt;\nmargin-left:90.0000pt;\nmargin-right:90.0000pt;\nsize:595.3000pt 841.9000pt;\nlayout-grid:15.6000pt;\n}\ndiv.Section0{page:Section0;}</style></p><p class=\"MsoNormal\"><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">在刷卡消费时，不要以大额整数刷卡。比如</font>2000<font face=\"宋体\">、</font><font face=\"Calibri\">3500</font><font face=\"宋体\">等，这些行为都可能让银行将你列为</font><font face=\"Calibri\">”</font><font face=\"宋体\">危险名单</font><font face=\"Calibri\">“</font><font face=\"宋体\">中哦</font><font face=\"Calibri\">~</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></p>',
        'uploads/2020/8/20/5d1fed72cc4e48cc8ccb525a7cc49fe1.jpg', '999', '2', '软文', '1', null, null, null, null, null);
INSERT INTO `article`
VALUES ('2ab256ad881d4ed98c261ab08f543051', '2020-08-20 10:10:03', '超级管理员', '999', '999', '2020-08-20 10:10:03',
        '超级管理员', '获取信用卡积分的四大方法！', '获取信用卡积分的四大方法！',
        '<p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">信用卡积分是用卡人盈利的重要途径之一，用卡务必抓住每一分。获取信用卡积分的三大途径：</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">01 &nbsp;<font face=\"宋体\">刷卡消费获取积分 </font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">&nbsp;&nbsp;&nbsp;<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">一般情况下，除了招商银行是消费</font>20<font face=\"宋体\">元积</font><font face=\"Calibri\">1</font><font face=\"宋体\">积分，其他银行的信用卡均是消费</font><font face=\"Calibri\">1</font><font face=\"宋体\">元就会给</font><font face=\"Calibri\">1</font><font face=\"宋体\">个积分（这也是招商积分价值高的原因）所以想要积分多就要多刷卡。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">但是由于每个银行积分规则不同，所以在刷卡过程中也是要特别注意</font>“<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;background:rgb(255,255,0);mso-highlight:rgb(255,255,0);\"=\"\"><font face=\"宋体\" style=\"background-color: rgb(238, 236, 224); color: rgb(249, 150, 59);\">商户类型</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><span style=\"color: rgb(249, 150, 59);\">”</span><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">、</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">商户类型分为</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;background:rgb(255,255,0);mso-highlight:rgb(255,255,0);\"=\"\"><font face=\"宋体\" style=\"font-weight: bold; color: rgb(249, 150, 59);\">标准类</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;background:rgb(255,255,0);mso-highlight:rgb(255,255,0);\"=\"\"><span style=\"font-weight: bold; color: rgb(249, 150, 59);\">(<font face=\"宋体\">一般类）、优惠类、减免类。</font></span><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;background:rgb(255,255,0);mso-highlight:rgb(255,255,0);\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">标准类：餐饮、住宿、娱乐、百货、珠宝</font>......<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">优惠类：超市、加油、家电</font>......<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">减免类：非营利性医疗机构、非营利性教育机构、非营利性慈善及社会福利机构</font>.....<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;<span style=\"font-weight: bold;\"></span></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;><span style=\"font-size: 12px; font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, Arial, sans-serif;\"></span></p><p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\n}\ndiv.Section0{page:Section0;}</style></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">一般情况在标准类和优惠类商户消费会有积分、减免类商户消费再多也是没有积分的，具体的详细规则见下图</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/20/49feec7c5909461aadb19ecb0a274df5.jpg\" style=\"font-size: 12px; font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, Arial, sans-serif; max-width: 100%;\"><span style=\"font-size: 10.5pt;\">02</span></p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\n}\ndiv.Section0{page:Section0;}</style><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">生日月多倍积分</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">银行会针对持卡人的生日月做出消费多给积分的活动，多则</font>10<font face=\"宋体\">倍少则也双倍，所以再生日月一定要多刷卡。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/20/afa1b90711364a36a8daec5a3f325ed9.jpg\" style=\"font-size: 12px; font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, Arial, sans-serif; max-width: 100%;\"><span style=\"font-size: 10.5pt;\">03</span></p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\nmargin-top:72.0000pt;\nmargin-bottom:72.0000pt;\nmargin-left:90.0000pt;\nmargin-right:90.0000pt;\nsize:595.3000pt 841.9000pt;\nlayout-grid:15.6000pt;\n}\ndiv.Section0{page:Section0;}</style><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">特殊卡种多倍积分</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">每个银行都会出多倍积分的卡种我们称为特殊卡种，特殊卡种的积分会有</font>1.5<font face=\"宋体\">倍积分的，也有</font><font face=\"Calibri\">2</font><font face=\"宋体\">倍</font><font face=\"Calibri\">3</font><font face=\"宋体\">倍的</font><font face=\"Calibri\">.....</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">具体自己是不是多倍卡种可致电银行客服咨询也可咨询申请多倍积分卡种来使用</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">04<spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">银行活动</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">每个银行都会定期出各种消费额外赠送积分的活动，比如招商经常出云闪付消费赠送</font>5<font face=\"宋体\">倍积分，中国银行经常出微信支付宝消费得</font><font face=\"Calibri\">10</font><font face=\"宋体\">倍积分。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">可关注银行发出的通知在银行活动的时候针对活动多消费。</font><spanyes\';font-family:calibri;mso-fareast-font-family:宋体; mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:10.5000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:calibri;mso-fareast-font-family:宋体;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p>',
        'uploads/2020/8/20/22425c12efbb4bf399f49cc1eee6d7de.jpg', '999', '2', '软文', '0', null, null, null, null, null);
INSERT INTO `article`
VALUES ('4eabddbb7e214b24a8e5fd7e232ce1d3', '2020-08-06 15:46:37', '超级管理员', '9999', '999', '2020-08-19 12:20:43',
        '超级管理员', '积分难道会蒸发，为什么兑换要趁早？', '积分难道会蒸发，为什么兑换要趁早？',
        '<p>很多信用卡持卡人虽然认识到积分兑换的重要性，但基于各种理由一直拖延兑换积分，直到某一天突然发现大量积分已经过期。</p><p><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/19/b4fe1c00723042fa996e2e4f7f024bd9.jpg\" style=\"max-width:100%;\"><br></p><p>为了守卫自己的积分财产，要尽快兑换！</p><p>01<br>积分过期<br>一般信用卡积分都是会过期的，即使部分银行的积分在卡片有效期内不会过期，卡片的有效期也不过5年或6年而已。</p><p><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/19/1c039f4038ef437dbac544c67530460c.jpg\" style=\"max-width:100%;\">&nbsp;<br></p><p>02<br>积分贬值<br>刚接触积分的人，可能会觉得积分的价值非常低，一万积分也只能兑换十几块，甚至几块钱，然而即使是这样低的价值也还一直在贬值。之前很少人了解积分的价值，兑换积分的人是极少数，物以稀为贵，所以积分价值还是很可观的。但是，银行组织的各种活动，签到送积分、抽奖送积分、消费达标送积分、活动达标瓜分积分等等，大量赠送的积分都稀释了积分的价值。</p><p><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/19/543086a7036245cba901602185b106ad.jpg\" style=\"max-width:100%;\"><br></p><p>03<br>兑换限量<br>积分本就是银行送给客户的消费奖励，银行正是看中了绝大多数客户并未意识到积分的价值，白白让积分过期，于是这份奖励就成了空头支票。但是，随着积分兑换的人越来越多，积分兑换的限制也越来越多，限制积分兑换的总额、限制积分兑换的次数等等。据此可以推断，类似的限制在将来只会越来越多、越来越苛刻。<img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/19/291d2da3e50f4326ab0b4646427a7fef.jpg\" style=\"max-width: 100%;\"></p><p>无论是过期、贬值还是兑换限量，在用户意识到积分的价值后，这都是不愿看到的，因此，有花堪折直须折，莫待无花空折枝，积分兑换要趁早！</p>',
        'uploads/2020/8/19/2d5afd23ba3f4f929d3fe45c1d505948.jpg', '9999', '2', '软文', '0', null, null, null, null, null);
INSERT INTO `article`
VALUES ('5d9e959d016c462ca1d4037594ae27f5', '2020-08-12 11:51:11', '超级管理员', '999', '999', '2020-08-12 11:52:15',
        '超级管理员', '大蛇丸无无', '阿斯达', '<p>阿斯达2奥德赛</p>', 'uploads/2020/8/12/2d21b7958d004769a47440c5b174c337.jpeg', '999',
        '1', '文案', '1', null, null, null, null, null);
INSERT INTO `article`
VALUES ('5f940c71e6e348f3b63a6221200e030e', '2020-08-12 11:51:30', '超级管理员', '999', '999', '2020-08-18 15:44:04',
        '超级管理员', '积分兑换与信用卡提额有关系吗？', '积分兑换与信用卡提额有关系吗？\n',
        '<p>在久益积分同盟平台积分兑换业务不断拓展的过程中，久益客服发现，部分用户对积分兑换是否会对信用卡的使用产生不好的影响存疑。<br><br>虽然是极少数用户的疑问，但我们在此认真统一认真回答——积分兑换跟信用卡的使用没有关系，不会影响信用卡额度的提升或降低。<br><br><br>首先<br><br><br><br>信用卡积分的本质是银行对用户刷卡的奖励，其目的是鼓励用户多刷卡，因此，使用或兑换积分是用户本应拥有的权益，并不是窃取了银行或其他组织、个人的权益，完全可以放心大胆地使用兑换积分。<br><br>通过很多银行举办的积分兑换有奖励的活动，或银行不断提醒积分会过期需及时兑换的公告等，我们可以看出银行不但不排斥用户进行积分兑换，甚至是鼓励的，获得了用户的好感，才能提高用户的刷卡量。<br><br><br>另外<br>信用卡额度调整跟用户的用卡习惯、征信、资产状况等多方面因素有关，跟积分兑换无关。<br><br>以用卡习惯为例，对支付行业有了解的用户或许知道，信用卡并不是刷所有行业都是有积分的，珠宝、餐饮、住宿等一般都是有积分的，因为银行能够通过用户的刷卡赚取利润，而医院、学校、税务等行业刷卡是没积分，因为银行无法从这些公益组织中获利，所以，用户多在有积分的餐饮、住宿等行业刷卡才有利于提额。同理，用户征信良好，能够及时还款，或资产状况良好，有较高的还款能力，这都有利于信用卡提额。<br><br>唯独积分兑换，银行不会因为用户进行了积分兑换而降额，也不会因为用户没有进行积分兑换而提额。<br><br><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/18/407d134ac1df438bbdf674dfae11a2b6.jpg\" style=\"max-width:100%;\"><br>总之，积分兑换是用户对自己正当权益的合理使用，与卡片额度的提降没有关系，好享兑用户可以放心大胆进行积分兑换，不等积分过期白白被清零，我的积分我做主！<br><br></p>',
        'uploads/2020/8/18/7a573d9f0fb4445b830698d4a30d46e9.jpg', '999', '2', '软文', '0', null, null, null, null, null);
INSERT INTO `article`
VALUES ('cab95f31df764947aed0f15dca8aa539', '2020-08-12 19:04:24', '超级管理员', '999', '999', '2020-08-18 17:47:30',
        '超级管理员', '宜收藏，各银行积分查询方法！', '各银行信用卡积分查询方法',
        '<p>无论是打电话还是发短信，都必须用信用卡预留手机号操作。<br><br>【工行】： ①编辑“CXJF#卡号＃短信银行密码”发送至95588<br>②拨打4006695588-身份证号＃－卡号后4位－1-5-5-电话银行密码<br><br>【农行】： 发送“CCJFKH”至1069095599查询客户级积分余额，发送“CCJFZH#卡号后四位”至1069095599查询账户级积分余额。<br><br>【中行】： ①发送17#卡号后4位到95566<br>②通过中国银行缤纷生活手机APP客户端，中国银行信用卡官方微信公众号（BOC-CARD)中国银行手机银行等查询。<br><br>【建行】：编辑“CXJF”发送至95533<br><br>【交行】： ①编辑“CC积分＃卡号后四位”发送至95559 <br>②拨打4008009888-卡号后4位＃－查询密码－5-1<br><br>【招商】： 编辑“＃JF”移动发送至1065795555 电信联通发送至95555<br><br>【光大】： 编辑“积分”发送至95595 <br><br>【广发】：发送403卡号后4位到95508<br><br>【平安】：拨打“95511”转2转8转9人工查询。<br><br>【华夏】：拨打华夏客服热线4006695577根据语音提示查询<br><br>【邮政】：① 编辑“JFCX#信用卡后四位”发送至95580<br>②拨打4008895580<br><br>【浦发】：编辑“JFCX+空格＋卡号后四位”发送至95528<br><br>【中信】： 编辑“JF+卡号后四位”发送至106980095558 <br><br>【兴业】：用在兴业银行登记的最新手机号码，编写短信＂30XXXX\"(XXXX为卡号后四位）发送95561<br><br>【民生】：编辑短信“JFXXXX(X为卡号后四位）”， 发送至106902895568进行查询。<br><br>【北京】：拨打4006601169-身份加油证号＃－查询密码＃－5告知客服查询积分<br><br>除了短信和电话，也可以直接关注各银行微信公众号或银行APP查询！</p>',
        'uploads/2020/8/18/35ab6f0dad3745f58b93dae26f345e8d.jpg', '999', '2', '软文', '0', null, null, null, null, null);
INSERT INTO `article`
VALUES ('e0e6f11c479f4d66a2fd571497e8c738', '2020-08-12 16:19:31', '超级管理员', '999', '999', '2020-08-18 18:07:46',
        '超级管理员', '怎样使用信用卡才安全？', '怎样使用信用卡才安全？',
        '<p>1<br><br>妥善保管密码<br>谨慎保管好卡号、密码、卡片验证码、短信验证码，不告诉他人。<br><br>2<br><br>不让他人代操作<br><br>无论是登录网银还是积分兑换，都由持卡人本人独立操作，不让任何他人帮忙代操作。<br><br>3<br><br>密码设置要安全<br><br>不要使用生日或身份证号等信息设置密码，不要将身份证和信用卡放在一起，以防丢失或被盗威胁财产安全。<br><br>4<br><br>刷卡要留心<br><br>刷卡时，卡不离眼，保持卡片在视线范围内。<br><br>5<br><br>正确利用小票<br><br>信用卡消费，刷卡完成签字前，要核验小票上的刷卡金额，以及银行卡号是否做了星号加密处理。不随意丢弃小票。<br><br></p>',
        'uploads/2020/8/18/b02a716d1ab6497b8af8bed8c2f5d101.jpg', '999', '2', '软文', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`
(
    `ID`                varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`      datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`           varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`  datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`      varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `ICON_PATH`         varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行图标',
    `NAME`              varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行名称',
    `SERVICE_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '客服ID',
    `SERVICE_NAME`      varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客服姓名',
    `SERVICE_IMAGE`     varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客服二维码',
    `SERVICE_NUMBER`    varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客服微信号',
    `ORDER_ID`          int(10)                                 NOT NULL DEFAULT '500000' COMMENT '排序号',
    `PHONE_QUERY_POINT` varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '电话查积分',
    `SMS_QUERY_POINT`   varchar(255) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '短信查积分',
    `DELETED`           int(1)                                           DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '用作查询积分电话配置',
    `SPARE2`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '用作查询积分电话配置(短信)',
    `SPARE3`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='银行表';

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank`
VALUES ('040ceda7e667431b8757006a40694d56', '2020-07-24 16:56:31', '超级管理员', '1', '999', '2020-08-18 19:27:59', '超级管理员',
        'uploads/2020/7/24/4a5bf251e8bc402c9d02f77e42b49a61.png', '成都银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10016', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('05108021e5204bcbae28d03d7903e2a5', '2020-07-24 14:32:18', '超级管理员', '1', '999', '2020-08-19 18:15:35', '超级管理员',
        'uploads/2020/7/24/15d629d353dc4c62be426abafd49236e.png', '农业银行', 'b1458891a58844c9b40d6e877b729516', '积分客服4',
        'uploads/2020/8/19/3be0afe52d244ddb929d75146aa9b329.jpg', 'wxid_bt1m3kdqp4d812', '2', '打客服电话95599',
        '编辑短信（CCJFKH)#卡号后四位发送至1069095599', '0', '95599', '1069095599', '', '', '');
INSERT INTO `bank`
VALUES ('06ef9cc25b17475d92439c3ca4516c6b', '2020-07-24 16:53:48', '超级管理员', '1', '999', '2020-08-19 18:42:18', '超级管理员',
        'uploads/2020/7/24/2a45553d19404b2b8e28fcc5d6518ab6.png', '光大银行', '53ec0ba6465a424f8c788850b47e7f20', '积分客服9',
        'uploads/2020/8/19/705185934b8740b5912ebfa9021cc1a7.jpg', 'YiYi-2015-2-17', '14', '打客服电话95595',
        '编辑短信（积分）发送至95595', '0', '95595', '95595', '', '', '');
INSERT INTO `bank`
VALUES ('08bcbac3e2424f82868fa0558c9e4161', '2020-08-19 15:25:03', '超级管理员', '999', '999', '2020-08-19 15:25:07',
        '超级管理员', 'uploads/2020/8/19/da5793abc2b347ddaec941f640d84e1b.jpg', '北京银行', 'de16d3364fe24778b20761d4e7f7676c',
        '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '22', '10', '11', '0',
        '10', '11', null, null, null);
INSERT INTO `bank`
VALUES ('1010712df3494c9d984caf261a22359b', '2020-08-19 15:45:31', '超级管理员', '999', '999', '2020-08-19 15:45:47',
        '超级管理员', 'uploads/2020/8/19/fa16919f343a488cb92ff674f6dfdee5.jpg', '12', 'b1458891a58844c9b40d6e877b729516',
        '积分客服4', 'uploads/2020/8/19/3be0afe52d244ddb929d75146aa9b329.jpg', 'wxid_bt1m3kdqp4d812', '112123', '21', '123',
        '1', '10', '12412', null, null, null);
INSERT INTO `bank`
VALUES ('11d603f69d7044cf87883067ef8bbf6e', '2020-07-24 17:00:15', '超级管理员', '1', '999', '2020-08-19 18:43:26', '超级管理员',
        'uploads/2020/7/24/90dd7fa5e7e64799b033d725251b11b3.png', '华夏银行', '01edf69bb1be4b5ea7b861065ca0b4ca', '积分客服5',
        'uploads/2020/8/19/c198e260708a4822ab62ae689f9e461f.jpg', 'wxid_zl144vv78etq22', '15', '打客服电话4006695577', '',
        '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('1eab3ce5c94846cda43c6beddc92dd96', '2020-07-24 14:37:41', '超级管理员', '1', '999', '2020-08-19 18:19:32', '超级管理员',
        'uploads/2020/7/24/27b2fc9b98154a3d99da13055fb5200d.png', '中信银行', '01edf69bb1be4b5ea7b861065ca0b4ca', '积分客服5',
        'uploads/2020/8/19/c198e260708a4822ab62ae689f9e461f.jpg', 'wxid_zl144vv78etq22', '7', '打客服电话95558',
        '编辑短信（JF+卡号后四位）发送至106980095558', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('26b185e524014c4bafeb12be51f771aa', '2020-07-24 16:58:33', '超级管理员', '1', '999', '2020-08-18 19:27:51', '超级管理员',
        'uploads/2020/7/24/b918f1d2841d4215b208de68304d7197.png', '浙江农信', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10019', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('31628391ca9e4604891d29a8942af177', '2020-07-24 16:54:25', '超级管理员', '1', '999', '2020-08-19 18:16:05', '超级管理员',
        'uploads/2020/7/24/606794859f914815a311ec9d58ebbdfc.png', '交通银行', '8358acfbc9bc44e2ace451667f4ab683', '积分客服2',
        'uploads/2020/8/19/30385d850d654e10bbf757afa80be9b5.jpg', 'balaxiaoxiannv000', '5', '打客服电话95559', '', '0',
        '95559', '', '', '', '');
INSERT INTO `bank`
VALUES ('44af41cf7fdf4a7f95033a4866361679', '2020-07-24 16:59:14', '超级管理员', '1', '999', '2020-08-18 19:27:48', '超级管理员',
        'uploads/2020/7/24/acb3bb16419e4300874a4caed7051351.png', '宁夏银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10020', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('483a19947bbf4f128e83bd0a70337d10', '2020-07-24 14:33:42', '超级管理员', '1', '999', '2020-08-19 18:15:49', '超级管理员',
        'uploads/2020/7/24/1b2473a07c584345b07b6c2f1abe08fb.png', '工商银行', 'a5af7f5071be4e428c5d42a18f37f6d2', '积分客服8',
        'uploads/2020/8/19/dbd982cfd8a34613a7fc4349ebb188ce.png', 'wxid_z2ttdhslqrgz12', '4', '打客服电话95559',
        '编辑短信（CXJF#卡号后四位#短信银行密码发送至95588', '0', '95559', '95588', '', '', '');
INSERT INTO `bank`
VALUES ('48d3c4f2fc404750a130d7a42e8c045b', '2020-07-24 14:34:19', '超级管理员', '1', '999', '2020-08-19 18:17:22', '超级管理员',
        'uploads/2020/7/24/7b6025477ad2486592b107bd4d3f873b.png', '邮政银行', '53ec0ba6465a424f8c788850b47e7f20', '积分客服9',
        'uploads/2020/8/19/705185934b8740b5912ebfa9021cc1a7.jpg', 'YiYi-2015-2-17', '6', '打信用卡专线4008895580', '', '0',
        '4008895580', '', '', '', '');
INSERT INTO `bank`
VALUES ('4cb8f791e5d24a88920ae6d1df2cbada', '2020-08-19 15:27:25', '超级管理员', '999', '999', '2020-08-19 15:27:31',
        '超级管理员', 'uploads/2020/8/19/1ce55e19314948dc8743c07dbc3cd4a6.jpeg', '内蒙古银行', 'de16d3364fe24778b20761d4e7f7676c',
        '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '24', '10', '1', '0',
        '11', '1', null, null, null);
INSERT INTO `bank`
VALUES ('550139d0de114ac880517bddc3f80a68', '2020-07-24 17:02:33', '超级管理员', '1', '999', '2020-08-19 15:08:48', '超级管理员',
        'uploads/2020/7/24/6b43e1ec31994e209e5a071afd091128.png', '中国国际航空', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '17', '', '', '0', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('552f73fa2e14408caf6ab9825efa7c60', '2020-08-19 15:26:18', '超级管理员', '999', '999', '2020-08-19 15:26:24',
        '超级管理员', 'uploads/2020/8/19/02e5639675124382bd9a355372fadb7e.jpg', '哈尔滨银行', 'de16d3364fe24778b20761d4e7f7676c',
        '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '23', '10', '01', '0',
        '101', '010', null, null, null);
INSERT INTO `bank`
VALUES ('56e848a8cff7455681678b2eca45be17', '2020-07-24 16:57:00', '超级管理员', '1', '999', '2020-08-18 19:28:07', '超级管理员',
        'uploads/2020/7/24/6747d9f726e44c0fbb33a44459364706.png', '云南农信', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10017', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('5869b200f3c94bcd98f63388a748d206', '2020-08-19 15:20:22', '超级管理员', '999', '999', '2020-08-19 18:46:22',
        '超级管理员', 'uploads/2020/8/19/8775d7f4b2934b8cbc562c213518496e.jpg', '香格里拉白金卡',
        'de16d3364fe24778b20761d4e7f7676c', '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg',
        'wxid_5y6kgse6uv2i22', '21', '打香格里拉客服电话4001205900转换积分', '', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('66a16bfb73c04f139d5d0134304d26b8', '2020-07-24 17:02:10', '超级管理员', '1', '999', '2020-08-18 19:27:37', '超级管理员',
        'uploads/2020/7/24/91038bf3064b4d17827e93b7da418a56.png', '徽商银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10025', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('69f5fa90adde49f89261b2be1fffeed3', '2020-07-24 17:03:12', '超级管理员', '1', '999', '2020-08-19 12:23:57', '超级管理员',
        'uploads/2020/7/24/a31366ba5ed54d4bbdd2753d59c24b26.png', '东方航空', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '18', '', '', '0', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('6d5c3c73ff324d44a813bd89c485969e', '2020-07-24 16:53:15', '超级管理员', '1', '999', '2020-08-19 18:41:23', '超级管理员',
        'uploads/2020/7/24/77d4dfd663d945db80e776fc738bcec1.png', '民生银行', '53ec0ba6465a424f8c788850b47e7f20', '积分客服9',
        'uploads/2020/8/19/705185934b8740b5912ebfa9021cc1a7.jpg', 'YiYi-2015-2-17', '13', '打客服电话95568',
        '编辑短信（JF+卡号后四位）发送至106902895568', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('700882743e254cc59537f9849dfbfe43', '2020-07-23 16:25:41', '超级管理员', '1', '999', '2020-08-19 18:15:39', '超级管理员',
        'uploads/2020/7/24/396010fbebdd49aca48d78d4ff44f66f.png', '建设银行', 'de16d3364fe24778b20761d4e7f7676c', '积分客服1',
        'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '3', '拨打电话 95533 >1>1',
        '发送短信 \"CXJF\"至 95533', '0', '95533', '95533', '', '', '');
INSERT INTO `bank`
VALUES ('81148c1388794f94a23e70427c8c3ef1', '2020-07-24 14:45:17', '超级管理员', '1', '999', '2020-08-19 18:34:32', '超级管理员',
        'uploads/2020/7/24/2950fd5726794ef797c2ff05fec27681.png', '浦发银行', 'b1458891a58844c9b40d6e877b729516', '积分客服4',
        'uploads/2020/8/19/3be0afe52d244ddb929d75146aa9b329.jpg', 'wxid_bt1m3kdqp4d812', '10', '打客服电话95528',
        '编辑短信（JFCX+卡号后四位）发送至95528', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('932c1622e0364adfb3701278f5ee1091', '2020-07-24 14:29:41', '超级管理员', '1', '999', '2020-08-19 17:35:09', '超级管理员',
        'uploads/2020/7/24/1e8ade57bdbd4d5591371db9f47d463b.png', '中国银行', 'de16d3364fe24778b20761d4e7f7676c', '积分客服1',
        'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '1', '打客服电话95566',
        '编辑短信17#卡号后四位发送到号码95566', '0', '95566', '95566', '', '', '');
INSERT INTO `bank`
VALUES ('98ff6dbfb6984c95a2dde2c5f298290f', '2020-07-24 16:57:46', '超级管理员', '1', '999', '2020-08-18 19:27:55', '超级管理员',
        'uploads/2020/7/24/1e2c97d87b9e48899eb54c32228473b4.png', '天津银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10018', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('99d93cee3bcc4f359a812916d51549e2', '2020-07-24 16:52:08', '超级管理员', '1', '999', '2020-08-19 18:39:26', '超级管理员',
        'uploads/2020/7/24/1051c2d08fbc4d43b8ef1a5cdedb464f.png', '兴业银行', '8358acfbc9bc44e2ace451667f4ab683', '积分客服2',
        'uploads/2020/8/19/30385d850d654e10bbf757afa80be9b5.jpg', 'balaxiaoxiannv000', '12', '打客服电话95561',
        '编辑短信（30卡号后四位）发送至95561', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('9abfa6fdc89142cb894d49499635e900', '2020-07-24 17:00:40', '超级管理员', '1', '999', '2020-08-18 19:27:45', '超级管理员',
        'uploads/2020/7/24/33536809c86d460a988eabd95db9a3b2.png', '贵阳银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10022', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('9afad8f16d7b4f9f9342266319c7de89', '2020-07-24 14:45:57', '超级管理员', '1', '999', '2020-08-19 18:38:08', '超级管理员',
        'uploads/2020/7/24/9634a6bc03244401967f225aa32c5f5c.png', '招商银行', 'a5af7f5071be4e428c5d42a18f37f6d2', '积分客服8',
        'uploads/2020/8/19/dbd982cfd8a34613a7fc4349ebb188ce.png', 'wxid_z2ttdhslqrgz12', '11', '打客服电话95555',
        '编辑短信#XF发送至95555', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('a208456d5c8c42afbdd0116b20c14693', '2020-07-24 17:01:05', '超级管理员', '1', '999', '2020-08-18 19:27:42', '超级管理员',
        'uploads/2020/7/24/7f5f81546f2240c99f09f635c36b99eb.png', '内蒙古银行', '83204135d69842fbb7e9139df7492981', '小度',
        'uploads/dd8e1d04dc1d482983b2ce08735be65c.png', '321654', '10023', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('ab9a13a45da24d8e8bc07ec4dd807dab', '2020-07-24 17:03:36', '超级管理员', '1', '999', '2020-08-19 17:20:12', '超级管理员',
        'uploads/2020/7/24/389dc7a5c4e14ea391e14a896edbbbb1.png', '南方航空联名卡', 'de16d3364fe24778b20761d4e7f7676c',
        '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '19', '10', '01', '0',
        '101', '01', '', '', '');
INSERT INTO `bank`
VALUES ('b3947bdc45f0458d89e6cc6c9a9b6a11', '2020-08-20 16:40:02', '超级管理员', '999', '999', '2020-08-20 16:40:02',
        '超级管理员', 'uploads/2020/8/20/26521c521cca4b8ab4f5406255cc28cd.jpg', '建设银行车主卡',
        '01edf69bb1be4b5ea7b861065ca0b4ca', '积分客服5', 'uploads/2020/8/19/c198e260708a4822ab62ae689f9e461f.jpg',
        'wxid_zl144vv78etq22', '500000', '打客服电话95533', '编辑(CXJF）发送至95533', '0', '', '', null, null, null);
INSERT INTO `bank`
VALUES ('c21d6650649c4cd9b5f9a614dd1fd14e', '2020-07-24 14:43:49', '超级管理员', '1', '999', '2020-08-19 15:28:17', '超级管理员',
        'uploads/2020/7/24/3d80255f6211444a95f0db0652d317ca.png', '中原银行', '83204135d69842fbb7e9139df7492981', '小度',
        'uploads/dd8e1d04dc1d482983b2ce08735be65c.png', '321654', '16', '', '', '0', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('c78f271c0c89456a92f74fce069c78cc', '2020-07-24 17:02:52', '超级管理员', '1', '999', '2020-08-19 18:21:38', '超级管理员',
        'uploads/2020/7/24/a12a7be9c88448548504369e92c419b7.png', '平安银行', 'de16d3364fe24778b20761d4e7f7676c', '积分客服1',
        'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '8', '打客服电话95511', '', '0', '',
        '', '', '', '');
INSERT INTO `bank`
VALUES ('d5525116100d42adae819db0303ee4a2', '2020-08-19 15:23:03', '超级管理员', '999', '999', '2020-08-19 15:23:09',
        '超级管理员', 'uploads/2020/8/19/fcb4a3108612488c8243677f96eaad82.jpg', '30家地方银行',
        'de16d3364fe24778b20761d4e7f7676c', '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg',
        'wxid_5y6kgse6uv2i22', '22', '1', '1', '0', '11', '1', null, null, null);
INSERT INTO `bank`
VALUES ('d80e5ed6e2814dc09146506b5a043062', '2020-07-24 14:44:42', '超级管理员', '1', '999', '2020-08-19 18:32:13', '超级管理员',
        'uploads/2020/7/24/099f1d1387a145479e7978929d36f86d.png', '广发银行', 'b1458891a58844c9b40d6e877b729516', '积分客服4',
        'uploads/2020/8/19/3be0afe52d244ddb929d75146aa9b329.jpg', 'wxid_bt1m3kdqp4d812', '9', '打客服电话4008308003',
        '编辑短信（403卡号后四位）发送至95508', '0', '', '', '', '', '');
INSERT INTO `bank`
VALUES ('d993c7f30bbb41119f5689d851c2ff29', '2020-07-24 16:55:10', '超级管理员', '1', '999', '2020-08-18 19:28:02', '超级管理员',
        'uploads/2020/7/24/d394800c27c940be966e7c7c964282a1.png', '北京银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10015', '', '', '1', null, null, null, null, null);
INSERT INTO `bank`
VALUES ('f897ffcb10284e07b37192767d4eb986', '2020-07-24 17:01:41', '超级管理员', '1', '999', '2020-08-19 10:27:31', '超级管理员',
        'uploads/2020/7/24/cf29ecdf356c4f439596c4b54910a428.png', '黄河银行', 'efcf6b5a7a3c4d1fbb66953c84507f7b', '小爱同学',
        'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '10024', '', '', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for capital_detail
-- ----------------------------
DROP TABLE IF EXISTS `capital_detail`;
CREATE TABLE `capital_detail`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `USER_ID`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
    `CAPITAL_TYPE`     int(1)                                  NOT NULL COMMENT '流水类型 1直推会员升级收益 2间推会员升级收益 3积分兑换 4会员积分兑换直接推荐 5会员积分兑换间接推荐 6盟主永久收益 7盟主差价收益 8盟主团队奖 9盟主同级兑换奖 10第一次推荐盟主直接奖励 11盟主二次升级奖励 12会员升级 13盟主升级 14每日签到 15提现',
    `POINTS_DETAIL`    decimal(20, 4)                          NOT NULL COMMENT '积分变动',
    `MONEY_DETAIL`     decimal(20, 2)                          NOT NULL COMMENT '金钱变动',
    `ORDER_ID`         varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所关联的订单',
    `CAPITAL_CONTENT`  varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流水详细说明',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='资金明细表 流水表';

-- ----------------------------
-- Records of capital_detail
-- ----------------------------
INSERT INTO `capital_detail`
VALUES ('0344000d904441bca1d1f75a3fed7843', '2020-08-13 15:21:13', 'kqxxauwt', '353457a7339544238fdb0f98282c92de',
        '353457a7339544238fdb0f98282c92de', '2020-08-13 15:21:13', 'kqxxauwt', '353457a7339544238fdb0f98282c92de', '14',
        '0.0000', '0.01', '9b6a3b05bcb44bf39396c4e532b5bb2f', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('09de50b212c846198e48385487bbb79b', '2020-08-20 13:15:00', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 13:15:00',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '14', '0.0000', '0.01',
        'f4706ee965fe42338c8c210893b373a7', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('17c916fd58d44ffb8b74bb067769abcb', '2020-08-20 10:59:07', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-20 10:59:07', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169', '14',
        '0.0000', '0.01', '9ab0eb0a76b746bf9b2d2b1eadc3a842', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('1d8d8ab6491843ffbf7623c2addb5d8a', '2020-08-18 16:59:36', 'gawsnnql', '1dc7465884d84eaaad84ac9849792520',
        '1dc7465884d84eaaad84ac9849792520', '2020-08-18 16:59:36', 'gawsnnql', '1dc7465884d84eaaad84ac9849792520', '14',
        '0.0000', '0.01', '1e27c88f0a544dc6b01006b20304e37c', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('2d782e8ba3cb4225b67ae583590c902b', '2020-08-20 14:58:35', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 14:58:35',
        '信用卡积分变现、 pos机免费', '380d1b09a4cc41da8908721c4c715286', '8', '0.0000', '0.00',
        'ff7edf8ce19744059a818ab992b07ab2', '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主团队奖收益 获得收益：0.00元 0积分', '0',
        null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('2f57615b566547629ab8f645b2d98953', '2020-08-13 14:28:59', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-13 14:28:59', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '3',
        '-100000.0000', '100.00', '4bdc90a29be4487abdc5dcefbdb6c2e1',
        '姓名：? ID:cd269fa995b5484d8c13fd85ae62df2b通过：会员直接兑换 获得收益：100.00元 0积分', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('3c3ab77f704b4890bdfee19e2a17c4b1', '2020-08-18 17:29:11', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-18 17:29:11', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169', '14',
        '0.0000', '0.02', 'd6dfd20db3f44f73bbb467b1c184f914', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('482ed282faf84b7184649b9a68d1b158', '2020-08-19 13:10:58', '瑋梦', '94b30333e881498db1c0061a4065f050',
        '94b30333e881498db1c0061a4065f050', '2020-08-19 13:10:58', '瑋梦', '94b30333e881498db1c0061a4065f050', '14',
        '0.0000', '0.02', '4317b0a1263d4e85a959cf9345bbfd5d', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('49e445dd5097411cb8b47c5aecb1fd6d', '2020-08-18 17:23:02', 'xiwwljmi', '94b30333e881498db1c0061a4065f050',
        '94b30333e881498db1c0061a4065f050', '2020-08-18 17:23:02', 'xiwwljmi', '94b30333e881498db1c0061a4065f050', '14',
        '0.0000', '0.01', '4bf4885da1bd41ca9f83bc7c8794563f', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('4c923dee0a834512981325a1c5ed765b', '2020-08-17 10:56:51', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-17 10:56:51', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169', '14',
        '0.0000', '0.02', 'a864c5e768614c1b839f5100a28533c4', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('65b6142890f3439785147deacb683d4b', '2020-08-18 17:18:02', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-18 17:18:02', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '14',
        '0.0000', '0.02', '77d107ead05045b294e7b52949b0d26c', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('6bfa1bf7726c4b10a6393ec50fbc2359', '2020-08-14 10:58:17', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-14 10:58:17', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '14',
        '0.0000', '0.02', '2b97fe0065f84cdaa5f812cb02d38b48', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('6ff637038d034cc4ad45db75e4390593', '2020-08-20 14:58:35', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 14:58:35',
        '信用卡积分变现、 pos机免费', '04a3b853256f46a8bf43b534488d3169', '4', '0.0000', '0.00',
        'ff7edf8ce19744059a818ab992b07ab2', '姓名：积分兑现-蔺先生 ID:04a3b853256f46a8bf43b534488d3169通过：会员直接推荐 获得收益：0.00元 0积分',
        '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('70ac9421e63c49599b23852fc755c25c', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '6',
        '0.0000', '5.00', '035ebbdde4ef4f4995059da8890c4e26',
        '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主永久收益 获得收益：5.00元 0积分', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('727ff481a50f4718b66df1e8322db909', '2020-08-18 17:56:43', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-18 17:56:43',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '14', '0.0000', '0.02',
        '99c3d82398854516a98025f21b3dc2cc', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('7c6e875479944dbab7015089b61faff3', '2020-08-13 15:01:00', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 15:01:00', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '14',
        '0.0000', '0.01', '7f8d0c35b6064ec2b6c03b4ef3d01eb4', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('870fa055a726498d828c9aebcc47487a', '2020-08-18 16:45:26', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-18 16:45:26',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '14', '0.0000', '0.02',
        'cde1bb11adac4d58ac9f8b72bcd7feed', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('982915a586c84226a6367c38564bed71', '2020-08-18 17:57:02', '?  ʚ AN. ɞ', '1dc7465884d84eaaad84ac9849792520',
        '1dc7465884d84eaaad84ac9849792520', '2020-08-18 17:57:02', '?  ʚ AN. ɞ', '1dc7465884d84eaaad84ac9849792520',
        '14', '0.0000', '0.01', 'da2617d23a8548f4abb36be4ba24066e', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('a1ca3c3046bd454399c6ac8633facba6', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '8',
        '0.0000', '0.10', '035ebbdde4ef4f4995059da8890c4e26',
        '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主团队奖收益 获得收益：0.10元 0积分', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('af07118f3744446da77e352dae28a202', '2020-08-19 09:48:58', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-19 09:48:58',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '14', '0.0000', '0.01',
        'c9e1d19870ee4745bc5413300932d887', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('b9aab90861604249be14143b56a5d059', '2020-08-13 15:02:16', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 15:02:16', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '15',
        '0.0000', '5.00', 'a8847b8fce5840368edb76bdc080ebc2', 'withdraw', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('c0ac3cfd23e643cb8f6dfd2cc75683ab', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '7',
        '0.0000', '5.00', '035ebbdde4ef4f4995059da8890c4e26',
        '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主差价收益 获得收益：5.00元 0积分', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('cf75508be0e24c5586cb1df9152bed75', '2020-08-18 17:51:45', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-18 17:51:45', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '14',
        '0.0000', '0.01', '6ba2d45ed3ef4f93b4116021273c9a20', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('e2a8cb47a1a24718a6d4bb73faf4d0d2', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 14:53:23', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '3',
        '-100000.0000', '145.00', '035ebbdde4ef4f4995059da8890c4e26',
        '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主直接兑换 获得收益：145.00元 0积分', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('e44d4310f1ec4bcd9a0b61d471d2ad43', '2020-08-13 14:26:10', 'nqexcqdm', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-13 14:26:10', 'nqexcqdm', 'cd269fa995b5484d8c13fd85ae62df2b', '14',
        '0.0000', '0.02', '0dab0a4b313c4da59acc9bf7c8364210', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('ee79768e9110496184dca858178ca417', '2020-08-19 18:11:14', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-19 18:11:14', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '14',
        '0.0000', '0.01', 'b837a6c833ca4e74ba9d48b8f135dddc', '签到增加流水', '0', null, null, null, null, null);
INSERT INTO `capital_detail`
VALUES ('f283d82a9d864dcdab375edf160f04c6', '2020-08-20 14:58:35', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 14:58:35',
        '信用卡积分变现、 pos机免费', '380d1b09a4cc41da8908721c4c715286', '6', '0.0000', '0.00',
        'ff7edf8ce19744059a818ab992b07ab2', '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主永久收益 获得收益：0.00元 0积分', '0',
        null, null, null, null, null);

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`
(
    `ID`                           varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`                 datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`                      varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`                   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`             datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`                 varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `NAME`                         varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
    `MEMBER_NORMAL`                decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '普通会员价格(元/万积分)',
    `MEMBER_GOLD`                  decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '黄金会员价格(元/万积分)',
    `MEMBER_DIAMOND`               decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '钻石会员价格(元/万积分)',
    `SERVICE`                      int(5)                                  NOT NULL DEFAULT '0' COMMENT '客服 0虚拟 1实物',
    `ODDS`                         varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '优势',
    `LIMIT_LINE`                   decimal(20, 2)                          NOT NULL DEFAULT '10000.00' COMMENT '启兑单位',
    `EXCHANGE_TYPE`                int(10)                                 NOT NULL COMMENT '兑换限制: 0不限制 1次/天 2 次/月 3 次/年 4 次/人',
    `EXCHANGE_COUNT`               int(10)                                          DEFAULT NULL COMMENT '限制次数',
    `DETAIL_CONTENT`               longtext COLLATE utf8mb4_unicode_ci COMMENT '兑换步骤详情',
    `COMPANY_ID`                   varchar(50) COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '盟主ID',
    `BANK_NAME`                    varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行名称',
    `BANK_ID`                      varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行ID',
    `PHONE_QUERY_POINT`            varchar(500) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '电话查积分',
    `SMS_QUERY_POINT`              varchar(500) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '短信查积分',
    `PLATFORM_FLOOR_PRICE`         decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '平台底价',
    `NORMAL_COMPANY_FLOOR_PRICE`   decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '初级盟主底价',
    `ADVANCED_COMPANY_FLOOR_PRICE` decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '高级盟主底价',
    `SUPER_COMPANY_FLOOR_PRICE`    decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '特级盟主底价',
    `DELETED`                      int(1)                                           DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`                       varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'cardId',
    `SPARE2`                       varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`                       varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`                       varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`                       varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='银行卡';

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card`
VALUES ('03a867c311844ffdba9b33895aa1bee3', '2020-08-19 10:28:57', '超级管理员', '999', '999', '2020-08-19 12:22:17',
        '超级管理员', '1', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>', '999', '广发银行',
        'd80e5ed6e2814dc09146506b5a043062', '', '', '1.00', '1.00', '1.00', '1.00', '1',
        '9790e16472044139af72372a81398ca1', null, null, null, null);
INSERT INTO `card`
VALUES ('14c37ec17c9541638d37a5a9b5c3f87e', '2020-08-18 19:39:14', '超级管理员', '999', '999', '2020-08-20 15:37:29',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p class=\"MsoNormal\"><b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';color:rgb(255,0,0);=\"\" font-weight:bold;font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">平安银行</font>5.1<font face=\"宋体\">万起兑</font></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">：登陆手机号</font>+<font face=\"宋体\">登录密码</font><font face=\"Calibri\">+</font><font face=\"宋体\">支付密码</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">25<font face=\"宋体\">万以下平安口袋银行 &nbsp;</font><font face=\"Calibri\">25</font><font face=\"宋体\">万以上壹钱包口袋银行买家乐福</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">30.50.100<font face=\"宋体\">面值</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">【壹钱包】如不显示积分，积分激活请戳</font> http://t.cn/RlxBj20 <font face=\"宋体\">，根据页面提示进行操作。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">下载登录进壹钱包后搜索沃尔玛，购买</font>100.200.500.1000<font face=\"宋体\">面值电子卡</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">一定要勾选使用积分抵扣！收到短信复制内容给我换钱。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\n}\ndiv.Section0{page:Section0;}</style></p><p class=\"MsoNormal\"><b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';color:rgb(192,0,0);=\"\" font-weight:bold;font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></b></p>',
        '999', '平安银行', 'c78f271c0c89456a92f74fce069c78cc', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'de1caa5a56954694b393944564bc67d0', null, null, null, null);
INSERT INTO `card`
VALUES ('17e3f863a1ee46fea1d0b3bea5331486', '2020-08-18 16:51:29', '超级管理员', '999', '999', '2020-08-20 15:36:54',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '110', '110000.00', '0', null,
        '<p>【邮政储蓄银行兑换流程】 手机先下载邮储信用卡APP，注册绑定信用卡以后，点击左下方“精选”—“积分兑购”—搜索栏搜索“肯德基”，兑换肯德基20元券，2万积分一张。 注意：单笔单个手机号单笔最多10张，再次购买更换手机号<br></p><p>邮政星巴克30元，2张  3.21W<br>邮政肯德基50元，2张  5W<br>邮政肯德基30元，2张  3W<br>邮政肯德基20元，2张  2W <br>邮政必胜客30元，2张  3.18w<br>滴滴快车      ，2张  3W</p>',
        '999', '邮政银行', '48d3c4f2fc404750a130d7a42e8c045b', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'ed2e79075a874bc1849decf78b5f7f23', '', '', '', '');
INSERT INTO `card`
VALUES ('1b5776ee04cf46609b3ed973bb706a59', '2020-08-18 16:44:13', '超级管理员', '999', '999', '2020-08-20 15:36:49',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '1257', '10000.00', '0', null,
        '<h1>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 【交通银行操作流程】<br></h1><h5>买单吧首页定位上海---首页点积分美食---附近美食---搜“必胜客”---随便点一家店进去---选择85购100元券（别的不要选）---点立即购买（每张券5.66万积分）---根据积分增加数量点继续---点亮使用积分确定支付----截图订单二维码给客服结算<br><p>必胜客（89购100=5.93W）（93购100=6.2）限购两张<br>肯德基(43购50=2.86W)、（17购20=1.13W）限购两张</p></h5><h3>星巴克1.9w一张，限购五张</h3>',
        '380d1b09a4cc41da8908721c4c715286', '交通银行', '31628391ca9e4604891d29a8942af177', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', 'a7db5a0fdf4c4493b12a2e88b89e6993', '', '', '', '');
INSERT INTO `card`
VALUES ('20c2ace8dc7f4d748999e26bf0561823', '2020-08-18 16:27:27', '超级管理员', '999', '999', '2020-08-20 15:36:45',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '123', '100000.00', '0', null,
        '<p>华夏打电话更改地址 （95577）跟客服说在上海出差 帮忙改下地址  兑换个礼品<br>地址：上海市松江区中山街道香川路1021号（客户名字）五金店微              客户名字   客户手机号    邮政编码:200000&nbsp;</p>',
        '380d1b09a4cc41da8908721c4c715286', '华夏银行', '11d603f69d7044cf87883067ef8bbf6e', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', '3d1d56793a984057b11bb302ff8e81da', '', '', '', '');
INSERT INTO `card`
VALUES ('219b2bc4c013443bae798f8c99cb1ef1', '2020-08-20 14:21:06', '超级管理员', '999', '999', '2020-08-20 16:36:43',
        '超级管理员', 'TP5620', '7.00', '8.00', '9.00', '1', '秒结', '71000.00', '2', '1',
        '<p>建行资料：<br>信用卡号+手机号+身份证后4位，配合收码即可。</p>', '999', '建设银行', '700882743e254cc59537f9849dfbfe43', '', '', '10.00',
        '10.00', '10.00', '10.00', '0', '044574b653244999b769ac323010ddb2', '', '', '', '');
INSERT INTO `card`
VALUES ('2a439e9ba128477b95598bda90e4f254', '2020-08-18 16:32:10', '超级管理员', '999', '999', '2020-08-20 15:36:47',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '122', '10.00', '0', null,
        '<p>中信让客户打客服电话  说在上海出差呢  积兑个礼品   把地址念给客服  让客服帮忙修改下<br>地址：上海市松江区中山街道茸树路1116号（客户名字）美容店微              客户名字   客户手机号    邮政编码:000000&nbsp;</p>',
        '380d1b09a4cc41da8908721c4c715286', '中信银行', '1eab3ce5c94846cda43c6beddc92dd96', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', '329e7722c8774d34841e5830f39fc050', null, null, null, null);
INSERT INTO `card`
VALUES ('34b20c11a0264899a3ee622d22db7f73', '2020-08-13 09:22:07', '超级管理员', '999', '999', '2020-08-20 15:36:41',
        '超级管理员', '券码', '100.00', '120.00', '3.30', '0', '123', '100000.00', '0', null, '<p>发农业信用卡卡号给客服，接收验证码即可。</p>',
        '380d1b09a4cc41da8908721c4c715286', '农业银行', '05108021e5204bcbae28d03d7903e2a5', '', '', '3.80', '3.40', '3.50',
        '3.60', '1', 'b71e98689473455eb26eb74af435a111', '', '', '', '');
INSERT INTO `card`
VALUES ('3be5db7f7a5342b085c495031c157a6a', '2020-08-18 19:21:43', '超级管理员', '999', '999', '2020-08-20 15:37:25',
        '超级管理员', '里程', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p>兴业资料：<br>身份证号+名字+卡正面+好兴动登录帐号+登录密码<br>发资料给客服，配合收码即可。</p>', '999', '兴业银行', '99d93cee3bcc4f359a812916d51549e2',
        '', '', '10.00', '10.00', '10.00', '10.00', '1', '762c55b5c7884822b8ca9c2bec505d13', '', '', '', '');
INSERT INTO `card`
VALUES ('3ccbf6785c3a49198b436c2b0a267d2c', '2020-08-18 19:41:32', '超级管理员', '999', '999', '2020-08-20 15:37:33',
        '超级管理员', '里程', '10.00', '10.00', '10.00', '0', '11411', '100000.00', '0', null,
        '<p>广发南航资料：<br>客户先下载南方航空，注册实名认证，开通钱包密码。 <br>注意： 开通钱包密码  需要开通两次才能彻底开通哦<br>南航登陆手机号+南航登录密码+钱包密码+身份证号+卡反正面+卡密码。<br></p>',
        '380d1b09a4cc41da8908721c4c715286', '广发银行', 'd80e5ed6e2814dc09146506b5a043062', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', 'a552c36995504b9ca4109f64eb8fe339', null, null, null, null);
INSERT INTO `card`
VALUES ('44e0695bf3ae4b9c8efeb5f6b41e8c2c', '2020-08-18 16:27:27', '超级管理员', '999', '999', '2020-08-20 15:36:45',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '123', '100000.00', '0', null,
        '<p>华夏打电话更改地址 （95577）跟客服说在上海出差 帮忙改下地址  兑换个礼品<br>地址：上海市松江区中山街道香川路1021号（客户名字）五金店微              客户名字   客户手机号    邮政编码:200000&nbsp;</p>',
        '999', '华夏银行', '11d603f69d7044cf87883067ef8bbf6e', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '3d1d56793a984057b11bb302ff8e81da', '', '', '', '');
INSERT INTO `card`
VALUES ('48a015b6ddc24f2bb2a674b8d91cc391', '2020-08-18 18:56:50', '超级管理员', '999', '999', '2020-08-20 15:37:14',
        '超级管理员', 'SKG', '10.00', '10.00', '10.00', '1', '000', '100000.00', '0', null,
        '<p>民生资料：<br>信用卡号+查询密码+卡密码，配合收码即可</p>', '380d1b09a4cc41da8908721c4c715286', '民生银行',
        '6d5c3c73ff324d44a813bd89c485969e', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'd4e796997d8d4b6fbc013a39d7c041ad', null, null, null, null);
INSERT INTO `card`
VALUES ('50f61c22eb6e4f1380aa75460b66acc5', '2020-08-18 19:00:48', '超级管理员', '999', '999', '2020-08-20 15:37:20',
        '超级管理员', '苏宁', '10.00', '10.00', '10.00', '0', '1111', '100000.00', '0', null,
        '<p>浦发银行流程：登陆普大喜奔-左上角搜索-积分易兑-点积分易兑-点商超-买苏宁/盒马/屈臣氏<br>买完返回我的订单里面截图发给客服即可。</p>',
        '380d1b09a4cc41da8908721c4c715286', '浦发银行', '81148c1388794f94a23e70427c8c3ef1', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', '8cb242e99c5a44e084ecd54104763c0f', '', '', '', '');
INSERT INTO `card`
VALUES ('5b57caafa88e4dfc89572c606c8738a4', '2020-08-18 18:55:35', '超级管理员', '999', '999', '2020-08-20 15:37:12',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p>下载东方航空，注册实名认证，并开通钱包。<br>发东航登陆手机号+登陆密码+钱包密码给客服即可</p>', '999', '东方航空', '69f5fa90adde49f89261b2be1fffeed3', '',
        '', '10.00', '10.00', '10.00', '10.00', '1', '32cdee22133c40acb1ee6ec549e6a8ab', null, null, null, null);
INSERT INTO `card`
VALUES ('5d9d993b61a8476a9e70f293c27216ab', '2020-08-18 18:58:22', '超级管理员', '999', '999', '2020-08-20 15:37:18',
        '超级管理员', '5620', '10.00', '10.00', '10.00', '1', '1011', '100000.00', '0', null,
        '<p>【建设银行流程】建设信用卡卡号+手机号＋身份证号后4位，配合收码即可</p>', '380d1b09a4cc41da8908721c4c715286', '建设银行',
        '700882743e254cc59537f9849dfbfe43', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '32afe29ea3bf4603a6b618798773633e', '', '', '', '');
INSERT INTO `card`
VALUES ('656d5f5964774a3c852b8a4959fbe427', '2020-08-18 18:55:35', '超级管理员', '999', '999', '2020-08-20 15:37:12',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p>下载东方航空，注册实名认证，并开通钱包。<br>发东航登陆手机号+登陆密码+钱包密码给客服即可</p>', '380d1b09a4cc41da8908721c4c715286', '东方航空',
        '69f5fa90adde49f89261b2be1fffeed3', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '32cdee22133c40acb1ee6ec549e6a8ab', null, null, null, null);
INSERT INTO `card`
VALUES ('6a7832e1b53048f7a7fa6a777e81b153', '2020-08-18 19:10:26', '超级管理员', '999', '999', '2020-08-20 15:37:23',
        '超级管理员', '券', '10.00', '10.00', '10.00', '0', '111', '100000.00', '0', null,
        '<p>中国银行资料：<br>缤纷生活手机号＋登录密码＋支付密码，一个验证码即可。</p>', '999', '中国银行', '932c1622e0364adfb3701278f5ee1091', '', '',
        '10.00', '10.00', '10.00', '10.00', '1', 'be3401396aae499a87db210796e32dd1', '', '', '', '');
INSERT INTO `card`
VALUES ('7bb15c40e7904bb98fa7c4dfac75c823', '2020-08-19 10:27:02', '超级管理员', '999', '999', '2020-08-19 10:27:22',
        '超级管理员', '1', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>',
        '380d1b09a4cc41da8908721c4c715286', '黄河银行', 'f897ffcb10284e07b37192767d4eb986', '', '', '1.00', '1.00', '1.00',
        '1.00', '1', 'c2d58d2bc0614dfaa27af4adbbfc92a1', null, null, null, null);
INSERT INTO `card`
VALUES ('83b22edfde724939a25dbfa30121e7fc', '2020-08-18 19:00:48', '超级管理员', '999', '999', '2020-08-20 15:37:20',
        '超级管理员', '苏宁', '10.00', '10.00', '10.00', '0', '1111', '100000.00', '0', null,
        '<p>浦发银行流程：登陆普大喜奔-左上角搜索-积分易兑-点积分易兑-点商超-买苏宁/盒马/屈臣氏<br>买完返回我的订单里面截图发给客服即可。</p>', '999', '浦发银行',
        '81148c1388794f94a23e70427c8c3ef1', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '8cb242e99c5a44e084ecd54104763c0f', '', '', '', '');
INSERT INTO `card`
VALUES ('8d1f66b7fc1b49fa88c072b3d9bfde6a', '2020-08-18 19:24:45', '超级管理员', '999', '999', '2020-08-20 15:37:27',
        '超级管理员', '星巴克', '10.00', '10.00', '10.00', '0', '11111', '10000.00', '0', null,
        '<p>招商银行资料：掌上生活登陆手机号+登陆密码+支付密码<br>发给客服，配合收码消分即可。</p>', '380d1b09a4cc41da8908721c4c715286', '招商银行',
        '9afad8f16d7b4f9f9342266319c7de89', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'b1c33ab55af64ba289793868ff07bf6a', '', '', '', '');
INSERT INTO `card`
VALUES ('9127ed0bc41545bbac2a6687c054013b', '2020-08-18 19:10:26', '超级管理员', '999', '999', '2020-08-20 15:37:23',
        '超级管理员', '券', '10.00', '10.00', '10.00', '0', '111', '100000.00', '0', null,
        '<p>中国银行资料：<br>缤纷生活手机号＋登录密码＋支付密码，一个验证码即可。</p>', '380d1b09a4cc41da8908721c4c715286', '中国银行',
        '932c1622e0364adfb3701278f5ee1091', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'be3401396aae499a87db210796e32dd1', '', '', '', '');
INSERT INTO `card`
VALUES ('99b18247f130424c922dd74945c516db', '2020-08-18 16:51:29', '超级管理员', '999', '999', '2020-08-20 15:36:54',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '110', '110000.00', '0', null,
        '<p>【邮政储蓄银行兑换流程】 手机先下载邮储信用卡APP，注册绑定信用卡以后，点击左下方“精选”—“积分兑购”—搜索栏搜索“肯德基”，兑换肯德基20元券，2万积分一张。 注意：单笔单个手机号单笔最多10张，再次购买更换手机号<br></p><p>邮政星巴克30元，2张  3.21W<br>邮政肯德基50元，2张  5W<br>邮政肯德基30元，2张  3W<br>邮政肯德基20元，2张  2W <br>邮政必胜客30元，2张  3.18w<br>滴滴快车      ，2张  3W</p>',
        '380d1b09a4cc41da8908721c4c715286', '邮政银行', '48d3c4f2fc404750a130d7a42e8c045b', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', 'ed2e79075a874bc1849decf78b5f7f23', '', '', '', '');
INSERT INTO `card`
VALUES ('9d32f870582c4c0db63c697e3cb7898b', '2020-08-13 09:22:07', '超级管理员', '999', '999', '2020-08-20 15:36:41',
        '超级管理员', '券码', '100.00', '120.00', '3.30', '0', '123', '100000.00', '0', null, '<p>发农业信用卡卡号给客服，接收验证码即可。</p>',
        '999', '农业银行', '05108021e5204bcbae28d03d7903e2a5', '', '', '3.80', '3.40', '3.50', '3.60', '1',
        'b71e98689473455eb26eb74af435a111', '', '', '', '');
INSERT INTO `card`
VALUES ('a63e462681ab4b4eaff21a5af587d3dd', '2020-08-18 19:24:45', '超级管理员', '999', '999', '2020-08-20 15:37:27',
        '超级管理员', '星巴克', '10.00', '10.00', '10.00', '0', '11111', '10000.00', '0', null,
        '<p>招商银行资料：掌上生活登陆手机号+登陆密码+支付密码<br>发给客服，配合收码消分即可。</p>', '999', '招商银行', '9afad8f16d7b4f9f9342266319c7de89', '',
        '', '10.00', '10.00', '10.00', '10.00', '1', 'b1c33ab55af64ba289793868ff07bf6a', '', '', '', '');
INSERT INTO `card`
VALUES ('a6699086a0f249788b79bd452c792fd7', '2020-08-19 10:20:23', '超级管理员', '999', '999', '2020-08-19 10:20:45',
        '超级管理员', '123', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>', '999', '黄河银行',
        'f897ffcb10284e07b37192767d4eb986', '', '', '1.00', '1.00', '1.00', '1.00', '1',
        '5307b49194014679b9cbe15dc3105940', null, null, null, null);
INSERT INTO `card`
VALUES ('a8149ab1c7e04886b625f031d019cccd', '2020-08-18 16:48:22', '超级管理员', '999', '999', '2020-08-20 15:36:51',
        '超级管理员', '扫码', '10.00', '10.00', '10.00', '0', '10212', '100000.00', '0', null,
        '<p>【工商银行流程】首先下载工银融e联添加信用卡后，扫下方二维码，积分数×15=支付金额，积分支付成功后截图发给客服即可<br><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/18/fb1a3e31f33d46438d527e74fc6a8a12.jpg\" style=\"max-width:100%;\"><br></p>',
        '380d1b09a4cc41da8908721c4c715286', '工商银行', '483a19947bbf4f128e83bd0a70337d10', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', 'a87364e5db264b83a74458f49ad81c12', '', '', '', '');
INSERT INTO `card`
VALUES ('a83ff995e9b14f2684a6732b21d2ca03', '2020-08-18 16:48:22', '超级管理员', '999', '999', '2020-08-20 15:36:51',
        '超级管理员', '扫码', '10.00', '10.00', '10.00', '0', '10212', '100000.00', '0', null,
        '<p>【工商银行流程】首先下载工银融e联添加信用卡后，扫下方二维码，积分数×15=支付金额，积分支付成功后截图发给客服即可<br><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/18/fb1a3e31f33d46438d527e74fc6a8a12.jpg\" style=\"max-width:100%;\"><br></p>',
        '999', '工商银行', '483a19947bbf4f128e83bd0a70337d10', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'a87364e5db264b83a74458f49ad81c12', '', '', '', '');
INSERT INTO `card`
VALUES ('a9e96097ace34b17afbd3d512eaad5ef', '2020-08-20 16:36:32', '超级管理员', '999', '999', '2020-08-20 16:36:32',
        '超级管理员', '券码', '14.00', '15.00', '16.00', '0', '秒结', '54000.00', '2', '2', '<p>建行资料：<br>信用卡号+手机号，配合收码即可。</p>',
        '380d1b09a4cc41da8908721c4c715286', '建设银行', '700882743e254cc59537f9849dfbfe43', '', '', '10.00', '10.00',
        '10.00', '10.00', '0', '6206f29a09b04b599c425ed4516dda91', '', '', '', '');
INSERT INTO `card`
VALUES ('abecef9baaa54f7d90fe21128b896b64', '2020-08-18 16:24:34', '超级管理员', '999', '999', '2020-08-20 15:36:43',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '123', '100000.00', '0', null,
        '<p>发光大信用卡卡号或身份证证号给客服，接收验证码即可。</p>', '999', '光大银行', '06ef9cc25b17475d92439c3ca4516c6b', '', '', '10.00',
        '10.00', '10.00', '10.00', '1', '227cc24e8dce4e4e81f28d6ac1a1b1ef', '', '', '', '');
INSERT INTO `card`
VALUES ('b36968b6815349e38b99455376846327', '2020-08-18 19:46:51', '超级管理员', '999', '999', '2020-08-18 19:46:57',
        '超级管理员', '去哪吗', '10.00', '10.00', '10.00', '0', '01112', '10000.00', '0', null, '<p>204242</p>', '999', '广发银行',
        'd80e5ed6e2814dc09146506b5a043062', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '347f9f8dac2847649b8fe7dc34d95cfb', '', '', '', '');
INSERT INTO `card`
VALUES ('bcf2b7b3b3c542bd955981304029bb26', '2020-08-19 10:20:23', '超级管理员', '999', '999', '2020-08-19 10:20:45',
        '超级管理员', '123', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>',
        '380d1b09a4cc41da8908721c4c715286', '黄河银行', 'f897ffcb10284e07b37192767d4eb986', '', '', '1.00', '1.00', '1.00',
        '1.00', '1', '5307b49194014679b9cbe15dc3105940', null, null, null, null);
INSERT INTO `card`
VALUES ('bd2c3fa9ea1e4ea58d943a82fc27da1e', '2020-08-18 18:53:37', '超级管理员', '999', '999', '2020-08-20 15:36:57',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '1111', '100000.00', '0', null,
        '<p>国航联名卡资料：<br>身份证正面+卡正面+手机号，发资料给客服，配合收码即可</p>', '999', '中国国际航空', '550139d0de114ac880517bddc3f80a68', '', '',
        '10.00', '10.00', '10.00', '10.00', '1', 'c802a9a9236e4eddbc172925d87911ba', null, null, null, null);
INSERT INTO `card`
VALUES ('c246e20a89974aa09ecfcdbbe9a67522', '2020-08-18 16:32:10', '超级管理员', '999', '999', '2020-08-20 15:36:47',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '122', '10.00', '0', null,
        '<p>中信让客户打客服电话  说在上海出差呢  积兑个礼品   把地址念给客服  让客服帮忙修改下<br>地址：上海市松江区中山街道茸树路1116号（客户名字）美容店微              客户名字   客户手机号    邮政编码:000000&nbsp;</p>',
        '999', '中信银行', '1eab3ce5c94846cda43c6beddc92dd96', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '329e7722c8774d34841e5830f39fc050', null, null, null, null);
INSERT INTO `card`
VALUES ('c6378785685c4fdeac951ae80eac6754', '2020-08-18 16:24:34', '超级管理员', '999', '999', '2020-08-20 15:36:43',
        '超级管理员', '百货', '10.00', '10.00', '10.00', '1', '123', '100000.00', '0', null,
        '<p>发光大信用卡卡号或身份证证号给客服，接收验证码即可。</p>', '380d1b09a4cc41da8908721c4c715286', '光大银行',
        '06ef9cc25b17475d92439c3ca4516c6b', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '227cc24e8dce4e4e81f28d6ac1a1b1ef', '', '', '', '');
INSERT INTO `card`
VALUES ('c82df29df56e41fabbecbf4fe4e59900', '2020-08-19 10:27:02', '超级管理员', '999', '999', '2020-08-19 10:27:22',
        '超级管理员', '1', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>', '999', '黄河银行',
        'f897ffcb10284e07b37192767d4eb986', '', '', '1.00', '1.00', '1.00', '1.00', '1',
        'c2d58d2bc0614dfaa27af4adbbfc92a1', null, null, null, null);
INSERT INTO `card`
VALUES ('cb4da95c605544b6981933bc096bda9d', '2020-08-18 18:53:37', '超级管理员', '999', '999', '2020-08-20 15:36:57',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '1111', '100000.00', '0', null,
        '<p>国航联名卡资料：<br>身份证正面+卡正面+手机号，发资料给客服，配合收码即可</p>', '380d1b09a4cc41da8908721c4c715286', '中国国际航空',
        '550139d0de114ac880517bddc3f80a68', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'c802a9a9236e4eddbc172925d87911ba', null, null, null, null);
INSERT INTO `card`
VALUES ('d23fd9babc5a41fb832261eac7fc1206', '2020-08-20 14:21:06', '超级管理员', '999', '999', '2020-08-20 16:36:43',
        '超级管理员', 'TP5620', '7.00', '8.00', '9.00', '1', '秒结', '71000.00', '2', '1',
        '<p>建行资料：<br>信用卡号+手机号+身份证后4位，配合收码即可。</p>', '380d1b09a4cc41da8908721c4c715286', '建设银行',
        '700882743e254cc59537f9849dfbfe43', '', '', '10.00', '10.00', '10.00', '10.00', '0',
        '044574b653244999b769ac323010ddb2', '', '', '', '');
INSERT INTO `card`
VALUES ('dff7b5986a2442bb8cf0fc1e12bb4b73', '2020-08-18 16:44:13', '超级管理员', '999', '999', '2020-08-20 15:36:49',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '1257', '10000.00', '0', null,
        '<h1>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 【交通银行操作流程】<br></h1><h5>买单吧首页定位上海---首页点积分美食---附近美食---搜“必胜客”---随便点一家店进去---选择85购100元券（别的不要选）---点立即购买（每张券5.66万积分）---根据积分增加数量点继续---点亮使用积分确定支付----截图订单二维码给客服结算<br><p>必胜客（89购100=5.93W）（93购100=6.2）限购两张<br>肯德基(43购50=2.86W)、（17购20=1.13W）限购两张</p></h5><h3>星巴克1.9w一张，限购五张</h3>',
        '999', '交通银行', '31628391ca9e4604891d29a8942af177', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'a7db5a0fdf4c4493b12a2e88b89e6993', '', '', '', '');
INSERT INTO `card`
VALUES ('e5a2bb6f570148ea9287c3f8011d3712', '2020-08-18 19:46:51', '超级管理员', '999', '999', '2020-08-18 19:46:57',
        '超级管理员', '去哪吗', '10.00', '10.00', '10.00', '0', '01112', '10000.00', '0', null, '<p>204242</p>',
        '380d1b09a4cc41da8908721c4c715286', '广发银行', 'd80e5ed6e2814dc09146506b5a043062', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', '347f9f8dac2847649b8fe7dc34d95cfb', '', '', '', '');
INSERT INTO `card`
VALUES ('e821a11cdee04f6d8e5f0b469652c8af', '2020-08-18 19:41:32', '超级管理员', '999', '999', '2020-08-20 15:37:33',
        '超级管理员', '里程', '10.00', '10.00', '10.00', '0', '11411', '100000.00', '0', null,
        '<p>广发南航资料：<br>客户先下载南方航空，注册实名认证，开通钱包密码。 <br>注意： 开通钱包密码  需要开通两次才能彻底开通哦<br>南航登陆手机号+南航登录密码+钱包密码+身份证号+卡反正面+卡密码。<br></p>',
        '999', '广发银行', 'd80e5ed6e2814dc09146506b5a043062', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        'a552c36995504b9ca4109f64eb8fe339', null, null, null, null);
INSERT INTO `card`
VALUES ('eb4f47fb87684264a2129eeac7f51110', '2020-08-18 19:21:43', '超级管理员', '999', '999', '2020-08-20 15:37:25',
        '超级管理员', '里程', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p>兴业资料：<br>身份证号+名字+卡正面+好兴动登录帐号+登录密码<br>发资料给客服，配合收码即可。</p>', '380d1b09a4cc41da8908721c4c715286', '兴业银行',
        '99d93cee3bcc4f359a812916d51549e2', '', '', '10.00', '10.00', '10.00', '10.00', '1',
        '762c55b5c7884822b8ca9c2bec505d13', '', '', '', '');
INSERT INTO `card`
VALUES ('ee040bc7cdd64228bfe7df04833b2bd0', '2020-08-19 10:28:57', '超级管理员', '999', '999', '2020-08-19 12:22:17',
        '超级管理员', '1', '1.00', '1.00', '1.00', '0', '1', '1.00', '0', null, '<p>1</p>',
        '380d1b09a4cc41da8908721c4c715286', '广发银行', 'd80e5ed6e2814dc09146506b5a043062', '', '', '1.00', '1.00', '1.00',
        '1.00', '1', '9790e16472044139af72372a81398ca1', null, null, null, null);
INSERT INTO `card`
VALUES ('efe3e93f8f8a450e99563f8d92b2a571', '2020-08-18 18:58:22', '超级管理员', '999', '999', '2020-08-20 15:37:18',
        '超级管理员', '5620', '10.00', '10.00', '10.00', '1', '1011', '100000.00', '0', null,
        '<p>【建设银行流程】建设信用卡卡号+手机号＋身份证号后4位，配合收码即可</p>', '999', '建设银行', '700882743e254cc59537f9849dfbfe43', '', '', '10.00',
        '10.00', '10.00', '10.00', '1', '32afe29ea3bf4603a6b618798773633e', '', '', '', '');
INSERT INTO `card`
VALUES ('f7daac4874b045dd9da37b04d52a51ce', '2020-08-18 19:39:14', '超级管理员', '999', '999', '2020-08-20 15:37:29',
        '超级管理员', '券码', '10.00', '10.00', '10.00', '0', '11111', '100000.00', '0', null,
        '<p class=\"MsoNormal\"><b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';color:rgb(255,0,0);=\"\" font-weight:bold;font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">平安银行</font>5.1<font face=\"宋体\">万起兑</font></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">：登陆手机号</font>+<font face=\"宋体\">登录密码</font><font face=\"Calibri\">+</font><font face=\"宋体\">支付密码</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">25<font face=\"宋体\">万以下平安口袋银行 &nbsp;</font><font face=\"Calibri\">25</font><font face=\"宋体\">万以上壹钱包口袋银行买家乐福</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\">30.50.100<font face=\"宋体\">面值</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">【壹钱包】如不显示积分，积分激活请戳</font> http://t.cn/RlxBj20 <font face=\"宋体\">，根据页面提示进行操作。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">下载登录进壹钱包后搜索沃尔玛，购买</font>100.200.500.1000<font face=\"宋体\">面值电子卡</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p class=\"MsoNormal\"><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><font face=\"宋体\">一定要勾选使用积分抵扣！收到短信复制内容给我换钱。</font><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';font-size:12.0000pt;=\"\" mso-font-kerning:1.0000pt;\"=\"\"><o:p></o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></p><p><!--[if gte mso 9]><xml><w:LatentStyles DefLockedState=\"false\"  DefUnhideWhenUsed=\"true\"  DefSemiHidden=\"true\"  DefQFormat=\"false\"  DefPriority=\"99\"  LatentStyleCount=\"260\" >\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"heading 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toc 9\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footer\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"index heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"caption\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of figures\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"envelope return\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"footnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"line number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"page number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote reference\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"endnote text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"table of authorities\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"macro\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"toa heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Bullet 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Number 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Title\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Closing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Default Paragraph Font\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Continue 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Message Header\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Subtitle\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Salutation\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Date\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text First Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Note Heading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Body Text Indent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Block Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Hyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"FollowedHyperlink\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Strong\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Emphasis\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Document Map\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Plain Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"E-mail Signature\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal (Web)\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Acronym\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Address\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Cite\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Code\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Definition\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Keyboard\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Preformatted\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Sample\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Typewriter\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"HTML Variable\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Normal Table\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"annotation subject\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / a / i\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"1 / 1.1 / 1.1.1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Article / Section\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Simple 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Classic 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Colorful 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Columns 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 7\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table List 8\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table 3D effects 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Contemporary\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Elegant\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Professional\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Subtle 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Web 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Balloon Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Table Theme\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Placeholder Text\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"No Spacing\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"List Paragraph\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Intense Quote\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 1\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 2\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 3\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 4\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 5\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Light Grid Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Shading 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium List 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 1 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 2 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Medium Grid 3 Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Dark List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Shading Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful List Accent 6\" ></w:LsdException>\n<w:LsdException Locked=\"false\"  Priority=\"99\"  SemiHidden=\"false\"  Name=\"Colorful Grid Accent 6\" ></w:LsdException>\n</w:LatentStyles></xml><![endif]--><style>\n@font-face{\nfont-family:\"Times New Roman\";\n}\n\n@font-face{\nfont-family:\"宋体\";\n}\n\n@font-face{\nfont-family:\"Calibri\";\n}\n\np.MsoNormal{\nmso-style-name:正文;\nmso-style-parent:\"\";\nmargin:0pt;\nmargin-bottom:.0001pt;\nmso-pagination:none;\ntext-align:justify;\ntext-justify:inter-ideograph;\nfont-family:Calibri;\nmso-fareast-font-family:宋体;\nmso-bidi-font-family:\'Times New Roman\';\nfont-size:10.5000pt;\nmso-font-kerning:1.0000pt;\n}\n\nspan.msoIns{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:underline;\ntext-underline:single;\ncolor:blue;\n}\n\nspan.msoDel{\nmso-style-type:export-only;\nmso-style-name:\"\";\ntext-decoration:line-through;\ncolor:red;\n}\n@page{mso-page-border-surround-header:no;\n	mso-page-border-surround-footer:no;}@page Section0{\n}\ndiv.Section0{page:Section0;}</style></p><p class=\"MsoNormal\"><b><spanyes\';font-family:宋体;mso-ascii-font-family:calibri; mso-hansi-font-family:calibri;mso-bidi-font-family:\'times=\"\" new=\"\" roman\';color:rgb(192,0,0);=\"\" font-weight:bold;font-size:12.0000pt;mso-font-kerning:1.0000pt;\"=\"\"><o:p>&nbsp;</o:p></spanyes\';font-family:宋体;mso-ascii-font-family:calibri;></b></p>',
        '380d1b09a4cc41da8908721c4c715286', '平安银行', 'c78f271c0c89456a92f74fce069c78cc', '', '', '10.00', '10.00',
        '10.00', '10.00', '1', 'de1caa5a56954694b393944564bc67d0', null, null, null, null);
INSERT INTO `card`
VALUES ('fac2c194cb894fa283c04cf9e5445b48', '2020-08-18 18:56:50', '超级管理员', '999', '999', '2020-08-20 15:37:14',
        '超级管理员', 'SKG', '10.00', '10.00', '10.00', '1', '000', '100000.00', '0', null,
        '<p>民生资料：<br>信用卡号+查询密码+卡密码，配合收码即可</p>', '999', '民生银行', '6d5c3c73ff324d44a813bd89c485969e', '', '', '10.00',
        '10.00', '10.00', '10.00', '1', 'd4e796997d8d4b6fbc013a39d7c041ad', null, null, null, null);
INSERT INTO `card`
VALUES ('fb1c7e81d4a643fc8c88c51b68c5ea45', '2020-08-20 16:36:32', '超级管理员', '999', '999', '2020-08-20 16:36:32',
        '超级管理员', '券码', '14.00', '15.00', '16.00', '0', '秒结', '54000.00', '2', '2', '<p>建行资料：<br>信用卡号+手机号，配合收码即可。</p>',
        '999', '建设银行', '700882743e254cc59537f9849dfbfe43', '', '', '10.00', '10.00', '10.00', '10.00', '0',
        '6206f29a09b04b599c425ed4516dda91', '', '', '', '');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `NAME`             varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名字',
    `COMPANY_ID`       varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '盟主ID',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='目录表';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category`
VALUES ('1', '2020-07-28 16:35:43', '1', '1', '1', '2020-07-28 16:35:43', '1', '文案', ' ', '1', '1', null, null, null,
        null);
INSERT INTO `category`
VALUES ('156c776cdac64107add2a8513f30a817', '2020-08-12 12:00:32', '超级管理员', '999', '999', '2020-08-12 12:00:51',
        '超级管理员', '阿斯达阿斯达', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('1d89abbfd29747bba9a55596e3419e37', '2020-08-12 11:42:00', '超级管理员', '999', '999', '2020-08-15 09:32:35',
        '超级管理员', '阿斯达多群', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('2', '2020-07-28 16:35:44', '1', '1', '1', '2020-07-28 16:35:44', '1', '软文', ' ', '1', '1', '', '', '', '');
INSERT INTO `category`
VALUES ('280d7821242b4ef4ad17f851ec780d28', '2020-07-31 16:22:52', 'L', 'af41b1d421f145c4b5979a5962d2cb53', '999',
        '2020-07-31 17:18:06', '超级管理员', '软文', 'af41b1d421f145c4b5979a5962d2cb53', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('3', '2020-07-28 16:35:45', '1', '1', '1', '2020-07-28 16:35:45', '1', '晒单', ' ', '1', '1', '', '', '', '');
INSERT INTO `category`
VALUES ('358c110291cb43d6bd1617585dadfe1f', '2020-07-31 17:08:34', '超级管理员', '999', '999', '2020-07-31 17:18:04',
        '超级管理员', '阿嫂', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('37a95218ff194d3f92b10a2c2b501082', '2020-07-31 17:18:41', '超级管理员', '999', '999', '2020-07-31 17:18:41',
        '超级管理员', '测试', '999', '0', null, null, null, null, null);
INSERT INTO `category`
VALUES ('3af60ac9b2b14a59b1e2b606859b5464', '2020-08-12 12:00:27', '超级管理员', '999', '999', '2020-08-15 09:32:35',
        '超级管理员', '恶趣味群', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('4', '2020-07-28 16:35:46', '1', '1', '1', '2020-07-28 16:35:46', '1', '资讯', ' ', '1', '1', '', '', '', '');
INSERT INTO `category`
VALUES ('5', '2020-07-28 16:35:47', '1', '1', '1', '2020-07-28 16:35:47', '1', '视频', ' ', '1', '1', '', '', '', '');
INSERT INTO `category`
VALUES ('58ab952dc35e4e1c95e7d03c19f60437', '2020-08-12 19:03:17', '超级管理员', '999', '999', '2020-08-12 19:03:28',
        '超级管理员', 'Asdasd', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('7f8d41c4e5f843beaa461506ce997921', '2020-08-12 11:59:23', '超级管理员', '999', '999', '2020-08-12 11:59:59',
        '超级管理员', '萨达十大', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('8fe0d4f23ce7423b888cca10659c5e04', '2020-08-12 12:00:24', '超级管理员', '999', '999', '2020-08-12 12:01:22',
        '超级管理员', '大萨达多多多', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('9df39bd2527e4f95b3b25e63e2d7dd5b', '2020-08-12 16:18:56', '超级管理员', '999', '999', '2020-08-12 16:19:11',
        '超级管理员', '打撒 打撒', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('b8c1edbe2e8e494ea158163ab07e449b', '2020-08-12 11:42:07', '超级管理员', '999', '999', '2020-08-12 11:43:31',
        '超级管理员', '奥术大师多', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('c2d0a202800841dca3c36d10b7cc2cac', '2020-08-06 11:24:13', '超级管理员', '9999', '999', '2020-08-15 09:32:35',
        '超级管理员', '大萨达撒', '9999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('c3f36194e58646efbd4832dea2acfce0', '2020-08-12 11:41:53', '超级管理员', '999', '999', '2020-08-12 11:43:31',
        '超级管理员', '无色大所', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('edc8a155a2b54391b29299fbebf1690f', '2020-08-06 11:24:22', '超级管理员', '9999', '999', '2020-08-15 09:32:35',
        '超级管理员', '测试少时诵诗书所苏所所多多多多多多多度多多', '9999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('f3ef3de3183149f2af9888c21dddc33e', '2020-08-12 12:01:28', '超级管理员', '999', '999', '2020-08-15 09:32:35',
        '超级管理员', '大萨达', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('faa52b2309f440c1999cf0abc526298e', '2020-08-12 11:59:26', '超级管理员', '999', '999', '2020-08-12 12:01:22',
        '超级管理员', '大萨达萨达', '999', '1', null, null, null, null, null);
INSERT INTO `category`
VALUES ('fef4c7799c9041cab3de311f7c98cbc6', '2020-08-12 16:33:14', '超级管理员', '999', '999', '2020-08-15 09:32:35',
        '超级管理员', '打算打打', '999', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for customer_service
-- ----------------------------
DROP TABLE IF EXISTS `customer_service`;
CREATE TABLE `customer_service`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `SERVICE_NAME`     varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服姓名',
    `SERVICE_IMAGE`    varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客服二维码',
    `SERVICE_NUMBER`   varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客服微信号',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='客服表';

-- ----------------------------
-- Records of customer_service
-- ----------------------------
INSERT INTO `customer_service`
VALUES ('01edf69bb1be4b5ea7b861065ca0b4ca', '2020-08-19 12:36:41', '超级管理员', '999', '999', '2020-08-19 12:36:41',
        '超级管理员', '积分客服5', 'uploads/2020/8/19/c198e260708a4822ab62ae689f9e461f.jpg', 'wxid_zl144vv78etq22', '0', null,
        null, null, null, null);
INSERT INTO `customer_service`
VALUES ('06feb4c1258c491580057f89d8de9b6c', '2020-08-12 11:39:21', '超级管理员', '999', '999', '2020-08-19 12:31:02',
        '超级管理员', '大大蔷薇', 'uploads/2020/8/12/ad251fe9d8ba4c7fba0b003fbb504e63.jpeg', 'sdfdsdf', '1', null, null, null,
        null, null);
INSERT INTO `customer_service`
VALUES ('419ca5e130214bfaa8ec93937039f7dd', '2020-08-12 11:38:47', '超级管理员', '999', '999', '2020-08-12 11:39:34',
        '超级管理员', '小艾艾', 'uploads/2020/8/12/a2cd2121b2cc4b8882caf254e32772ea.jpeg', 'asdweq', '1', null, null, null,
        null, null);
INSERT INTO `customer_service`
VALUES ('53ec0ba6465a424f8c788850b47e7f20', '2020-08-19 12:39:09', '超级管理员', '999', '999', '2020-08-19 12:39:09',
        '超级管理员', '积分客服9', 'uploads/2020/8/19/705185934b8740b5912ebfa9021cc1a7.jpg', 'YiYi-2015-2-17', '0', null, null,
        null, null, null);
INSERT INTO `customer_service`
VALUES ('62f8a49b192747f482921885c7dad55d', '2020-08-12 11:38:12', '超级管理员', '999', '999', '2020-08-19 12:31:04',
        '超级管理员', '大声公', 'uploads/2020/8/12/aec2cdf2d5e942b7900a9c55c745c5bf.jpeg', '阿诗丹顿多无', '1', null, null, null,
        null, null);
INSERT INTO `customer_service`
VALUES ('83204135d69842fbb7e9139df7492981', '2020-07-23 18:01:05', '超级管理员N', '1', '999', '2020-08-19 12:31:07', '超级管理员',
        '小度', 'uploads/dd8e1d04dc1d482983b2ce08735be65c.png', '321654', '1', null, null, null, null, null);
INSERT INTO `customer_service`
VALUES ('8358acfbc9bc44e2ace451667f4ab683', '2020-08-19 12:34:05', '超级管理员', '999', '999', '2020-08-19 12:34:05',
        '超级管理员', '积分客服2', 'uploads/2020/8/19/30385d850d654e10bbf757afa80be9b5.jpg', 'balaxiaoxiannv000', '0', null,
        null, null, null, null);
INSERT INTO `customer_service`
VALUES ('a5af7f5071be4e428c5d42a18f37f6d2', '2020-08-19 12:38:35', '超级管理员', '999', '999', '2020-08-19 12:38:35',
        '超级管理员', '积分客服8', 'uploads/2020/8/19/dbd982cfd8a34613a7fc4349ebb188ce.png', 'wxid_z2ttdhslqrgz12', '0', null,
        null, null, null, null);
INSERT INTO `customer_service`
VALUES ('ae9467cddfa94ed68758dd74f859e5a8', '2020-07-23 18:07:39', '超级管理员', '1', '1', '2020-07-30 18:12:19', '超级管理员',
        'asdfafd', 'uploads/2020/7/23/8d8a2a5850e4498ba067bbeabd5cd45c.jpg', 'asdf11', '1', null, null, null, null,
        null);
INSERT INTO `customer_service`
VALUES ('b1458891a58844c9b40d6e877b729516', '2020-08-19 12:35:16', '超级管理员', '999', '999', '2020-08-19 12:35:16',
        '超级管理员', '积分客服4', 'uploads/2020/8/19/3be0afe52d244ddb929d75146aa9b329.jpg', 'wxid_bt1m3kdqp4d812', '0', null,
        null, null, null, null);
INSERT INTO `customer_service`
VALUES ('bec1db9d5b074404ba3e2d94691a1f68', '2020-08-06 11:48:41', '超级管理员', '9999', '9999', '2020-08-06 11:48:45',
        '超级管理员', '请问', 'uploads/2020/8/6/b496f0cbb36341589b5165bde8960eb8.png', '请问', '1', null, null, null, null,
        null);
INSERT INTO `customer_service`
VALUES ('dcfd0c7c60134f8883a93046dc2f7830', '2020-08-06 14:17:56', '超级管理员', '999', '999', '2020-08-19 12:31:06',
        '超级管理员', 'xwq', 'uploads/2020/8/6/8668176bec06400aa1eac54707edb084.jpg', 'dqw', '1', null, null, null, null,
        null);
INSERT INTO `customer_service`
VALUES ('de16d3364fe24778b20761d4e7f7676c', '2020-08-19 12:31:47', '超级管理员', '999', '999', '2020-08-19 12:31:47',
        '超级管理员', '积分客服1', 'uploads/2020/8/19/9759e21869174f77afa50fde70f43510.jpg', 'wxid_5y6kgse6uv2i22', '0', null,
        null, null, null, null);
INSERT INTO `customer_service`
VALUES ('e45f3f49a1b0452aa2a90fd15f182bd0', '2020-08-12 19:01:05', '超级管理员', '999', '999', '2020-08-12 19:01:36',
        '超级管理员', '氨水烧伤所', 'uploads/2020/8/12/797066560fce4f708f27a7e303326d70.jpeg', '1231asd', '1', null, null, null,
        null, null);
INSERT INTO `customer_service`
VALUES ('e5b9b208731e4d95a13e87f06a0fd1b1', '2020-08-17 15:08:56', '超级管理员', '999', '999', '2020-08-19 12:30:58',
        '超级管理员', '积分客服', 'uploads/2020/8/17/d58714e698a34383b7d42137d35e8750.jpg', 'YiYi-2015-2-17', '1', null, null,
        null, null, null);
INSERT INTO `customer_service`
VALUES ('e656cb2dc4174f00b442c14f28bb352d', '2020-08-12 16:17:58', '超级管理员', '999', '999', '2020-08-12 16:18:08',
        '超级管理员', '打撒', 'uploads/2020/8/12/4dac9271eaa6443c9682f1a3550a73bf.jpeg', '123', '1', null, null, null, null,
        null);
INSERT INTO `customer_service`
VALUES ('efcf6b5a7a3c4d1fbb66953c84507f7b', '2020-07-23 17:21:25', '超级管理员N', '1', '999', '2020-08-19 12:31:09', '超级管理员',
        '小爱同学', 'uploads/2d3c7ac1bf7a480095ad7171f082f2a6.jpg', 'Z_S12138', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for frame_table
-- ----------------------------
DROP TABLE IF EXISTS `frame_table`;
CREATE TABLE `frame_table`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of frame_table
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `NAME`             varchar(255) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '名称',
    `ICON`             varchar(500) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '图片',
    `REWARD`           decimal(20, 2)                           DEFAULT NULL COMMENT '奖励金',
    `TYPE`             int(1)                                   DEFAULT NULL COMMENT '类型 0借款产品 1信用卡产品',
    `RATE_MONTH`       decimal(20, 2)                           DEFAULT NULL COMMENT '月利率',
    `DATE_LIMIT_MAX`   int(10)                                  DEFAULT NULL COMMENT '借贷周期(最高)',
    `DATE_LIMIT_MIN`   int(10)                                  DEFAULT NULL COMMENT '借贷周期(最低)',
    `RATE_SUCCESS`     decimal(20, 2)                           DEFAULT NULL COMMENT '通过率',
    `APPLY_COUNT`      int(10)                                  DEFAULT NULL COMMENT '已申请人数(虚拟)',
    `NEED_DATA`        varchar(255) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '需要资料',
    `APPLY_CONDITION`  longtext COLLATE utf8mb4_unicode_ci COMMENT '申请条件',
    `MAX_LOAN_CARD`    int(10)                                  DEFAULT NULL COMMENT '信用卡借款额度',
    `MAX_LOAN`         int(10)                                  DEFAULT NULL COMMENT '最高额度',
    `TARGET_LINK`      varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '目标链接',
    `CARD_IMAGE`       varchar(500) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '信用卡图片',
    `DELETED`          int(1)                                   DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods`
VALUES ('0387e56f3f5b48cfad3054078b498077', '2020-08-12 11:24:14', '超级管理员', '999', '999', '2020-08-12 11:24:14',
        '超级管理员', '转转卡', 'uploads/2020/8/12/bfeeac403891495c97795cef73cbc569.jpeg', '20.00', '1', '0.55', '12', '1',
        '0.89', '2321', '身份证', '<p>身份证</p>', '50000', '200000', 'http://www.baidu.com',
        'uploads/2020/8/12/cce69d06b8c3472b8079c8c23317275e.jpeg', '0', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('1', '2020-07-30 09:25:32', '超级管理员', '1', '999', '2020-08-04 14:47:15', '超级管理员', '银行卡',
        'uploads/2020/8/4/a46c4afe30034a6d921209accb04a8e5.jpeg', '100.00', '1', '0.55', '12', '1', '0.89', '1',
        '1、身份证',
        '<p>1.年满18周岁</p><p>2.有独立还款能力</p><p>3.有稳定收入<br><img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/4/ba071e3531c849bdb2de90542b889b15.jpeg\" style=\"max-width:100%;\"><br></p>',
        '50000', '200000', 'http://www.baidu.com', 'uploads/2020/8/4/8f59add96d654d128e0b873247d201b7.jpeg', '0', null,
        null, null, null, null);
INSERT INTO `goods`
VALUES ('1bc2ddb2603e4ae39142956b06c16f88', '2020-08-12 11:26:21', '超级管理员', '999', '999', '2020-08-12 11:26:21',
        '超级管理员', '啥都有卡', 'uploads/2020/8/12/2444ccf436aa469f99c68657f53e1c6e.jpeg', '50.00', '1', '0.55', '12', '1',
        '0.89', '213', '身份证', '<p>身份证1</p>', '50000', '200000', 'http://www.baidu.com',
        'uploads/2020/8/12/8a65cec77de842faa9ccc8b2487db815.jpeg', '0', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('26185d0422934acca8bf0dbe903571c0', '2020-08-12 11:19:56', '超级管理员', '999', '999', '2020-08-12 11:21:25',
        '超级管理员', '打撒', 'uploads/2020/8/12/f220e2bd057a41b9be0b10afb79d8a37.png', '1322.00', '1', null, null, null, null,
        '222222', '身份信息', '<p>撒大大</p>', null, null, 'qweqe', 'uploads/2020/8/12/f42e27d031f74c4ba06c11efd5b6e367.png',
        '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('26f0136fe93447369e916e8d5d7eb263', '2020-08-12 11:37:38', '超级管理员', '999', '999', '2020-08-12 11:37:38',
        '超级管理员', '法师', 'uploads/2020/8/12/0e9be291cb064c439912120ec09568c5.jpeg', '123.00', '0', '1.00', '12', '1',
        '45.00', '1231', '身份证', '<p>身份证</p>', '1200', '12000', 'http://www.baidu.com', '', '0', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('32f283a8243e4941b7b5270ac2269e30', '2020-08-12 11:25:16', '超级管理员', '999', '999', '2020-08-12 11:25:16',
        '超级管理员', '摇人卡', 'uploads/2020/8/12/2de97f9ef20b4174867be893a58c8a2d.jpeg', '30.00', '1', '0.55', '12', '1',
        '0.89', '222', '身份证', '<p>身份证百度&nbsp;&nbsp;&nbsp;&nbsp;</p>', '50000', '200000', 'http://www.baidu.com',
        'uploads/2020/8/12/c595aa4f642a46139d49d21c59f9ef17.jpeg', '0', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('4d613c65b842486fbdfcfe616f9ff45c', '2020-08-12 18:59:32', '超级管理员', '999', '999', '2020-08-12 18:59:48',
        '超级管理员', '请问', 'uploads/2020/8/12/b4041349477a4e39bb171d8d45d37baa.jpeg', '2312.00', '1', null, null, null,
        null, '123', '1231', '<p>123</p>', null, null, '123', 'uploads/2020/8/12/c3faa40ed27b4a26a6caa6af91ebc22e.jpeg',
        '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('5e76f9f847914075847007167ff07719', '2020-08-12 16:17:40', '超级管理员', '999', '999', '2020-08-12 16:17:43',
        '超级管理员', '打撒', 'uploads/2020/8/12/1e447f290b5b4c6fa82e452f08671c58.jpeg', '123.00', '0', '123.00', '312',
        '12312', '123.00', '3123', '12312', '<p>123</p>', '312', '312', '312', '', '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('63ed67f77de940b0a0b938a48ef1dd5b', '2020-08-06 11:47:06', '超级管理员', '9999', '9999', '2020-08-06 11:47:09',
        '超级管理员', '大萨达撒', 'uploads/2020/8/6/4b53df22db67445681e708878844a671.png', '11.00', '1', '0.55', '12', '1',
        '0.89', '223', '恶趣味群二', '<p>啊飒飒啊2</p>', '50000', '200000', 'http://www.baidu.com',
        'uploads/2020/8/6/cb502cd7f7af44fb925e973821f00cf4.png', '1', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('9fa7be2944c14b7f8e75315ce5b0bb95', '2020-08-12 11:33:19', '超级管理员', '999', '999', '2020-08-12 19:00:48',
        '超级管理员', '请问', 'uploads/2020/8/12/5937606731ec48309cf587e57ca6c757.jpeg', '121.00', '0', '5.00', '36', '1',
        '89.00', '123', '身份证', '<p>身份证</p>', '5000', '500000', 'http://www.baidu.com', '', '1', null, null, null, null,
        null);
INSERT INTO `goods`
VALUES ('a07e5426fc5d4cf4ae11976d5dfcd9bb', '2020-08-12 11:20:44', '超级管理员', '999', '999', '2020-08-12 11:21:25',
        '超级管理员', '阿斯达', 'uploads/2020/8/12/4f8378b63c8f40fbbb436feb96ec66fd.png', '1111.00', '1', null, null, null,
        null, '323', '大声', '<p>阿斯达</p>', null, null, '阿斯达', 'uploads/2020/8/12/e7759000702f42fab840248a4b7ab363.png',
        '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('a6251aff1ce740748241d7b70deb65ca', '2020-08-04 12:06:23', '超级管理员', '999', '999', '2020-08-04 14:47:11',
        '超级管理员', '桃花卡', 'uploads/2020/8/4/c818b32ce8f543028d321f328526a5be.jpeg', '20.00', '1', '0.55', '12', '1',
        '0.89', '0', '身份证', '<p>sadf sadf s</p><p>asdf&nbsp;</p><p>sad</p><p>f asd</p><p>f s</p><p>adf sdaf&nbsp;</p>',
        '50000', '200000', 'http://www.baidu.com', 'uploads/2020/8/4/a67ff3cee69f441e99f7e3694027324f.jpeg', '0', '',
        '', '', '', '');
INSERT INTO `goods`
VALUES ('b464206cd58c4832bc70c71384b4cfa7', '2020-08-12 11:27:15', '超级管理员', '999', '999', '2020-08-12 11:37:45',
        '超级管理员', '打撒', 'uploads/2020/8/12/eba644ba5b1f46b8a17d8cc14998fb4a.jpeg', '123.00', '0', '12.00', '12', '1',
        '12.00', '232', '打撒', '<p>身份证&nbsp;&nbsp;&nbsp;&nbsp;</p>', '1212121', '15454555', 'http://www.baidu.com', '',
        '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('b4dcc886b58e48d9813c733c904fee6d', '2020-08-12 11:21:09', '超级管理员', '999', '999', '2020-08-12 11:21:25',
        '超级管理员', '气味儿', 'uploads/2020/8/12/d8865b8567da4402a886997b9e0ec385.png', '1222.00', '1', null, null, null,
        null, '121313', '大声道', '<p>阿斯达</p>', null, null, '大声', 'uploads/2020/8/12/ee1b7006149c499db690d8e6d61e64b4.png',
        '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('b6da3842d8b348479c3d275ada3ae52f', '2020-08-12 11:28:18', '超级管理员', '999', '999', '2020-08-12 11:28:18',
        '超级管理员', '第二个', 'uploads/2020/8/12/e4487cf053e24c41b939c3fb65f4eb18.jpeg', '1252.00', '0', '1.00', '11', '1',
        '90.00', '1551', '身份证', '<p>身份证&nbsp;&nbsp;&nbsp;&nbsp;</p>', '5000', '200000', 'http://www.baidu.com', '', '0',
        '', '', '', '', '');
INSERT INTO `goods`
VALUES ('b8acbb131c174b4b86dd2252aeb132ad', '2020-08-04 15:39:47', '超级管理员', '999', '999', '2020-08-04 15:39:47',
        '超级管理员', '小额贷', 'uploads/2020/8/4/fdb3a3eaff804f44ae0c32b7a6f3e3ee.jpeg', '200.00', '0', '0.60', '20', '2',
        '80.00', '12384', '身份证',
        '<p>asdf asdf sadf asdf asdf asdf<img src=\"https://jf.jiangxingnet.com/pa/uploads/2020/8/4/f80d3cc4ddd14e92929d64542bd5b614.jpeg\" style=\"max-width: 100%;\"></p><p>&nbsp;asdf asdfklj ;lakdsf asdf&nbsp;</p>',
        '50000', '50000', 'https://www.baidu.com', '', '0', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('beb3b99c015a4da8b566f7ac7de18832', '2020-08-12 19:00:23', '超级管理员', '999', '999', '2020-08-12 19:00:43',
        '超级管理员', '请问', 'uploads/2020/8/12/deffd68f9ab64d5ebf1839bc49f48b0e.jpeg', '123.00', '0', '123.00', '123', '123',
        '123.00', '123', '123', '<p>123</p>', '123', '123', '213', '', '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('c4547d01c345451cad283dd2e7a831df', '2020-08-12 16:17:14', '超级管理员', '999', '999', '2020-08-12 16:17:17',
        '超级管理员', '萨达', 'uploads/2020/8/12/57a6014144b74a38bfce4c03aecb8344.jpeg', '123.00', '1', null, null, null, null,
        '231', '123', '<p>大大萨达请问大所&nbsp; &nbsp; as</p>', null, null, '全额翁',
        'uploads/2020/8/12/53f20dc5ad3b4ea8a2172460024697f8.jpeg', '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('c7aebb69494749d681cf78c17c730eb7', '2020-08-06 14:22:49', '超级管理员', '9999', '9999', '2020-08-06 14:22:54',
        '超级管理员', 'q', 'uploads/2020/8/6/7948d5ee4dce41f2b897ba35ff9a6afb.png', '1.00', '0', '1.00', '12', '1', '98.00',
        '1233', 'qwe', '<p>sdada</p>', '1', '1200', 'http://www.baidu.com', '', '1', null, null, null, null, null);
INSERT INTO `goods`
VALUES ('e580e92e394c418289da1c05937eb9da', '2020-08-06 11:48:15', '超级管理员', '9999', '9999', '2020-08-06 11:48:15',
        '超级管理员', '请问', 'uploads/2020/8/6/3179d9e0796f4fef948bd6746f73bac7.png', '11.00', '0', '2.00', '12', '1',
        '98.00', '122121', '身份证', '<p>身份证</p>', '2000', '50000', 'http://www.baidu.com', '', '0', null, null, null,
        null, null);
INSERT INTO `goods`
VALUES ('e812bbe101c94b44adc397092213828e', '2020-08-06 11:46:03', '超级管理员', '9999', '999', '2020-08-12 11:26:28',
        '超级管理员', '花旗', 'uploads/2020/8/6/8b526d148422475ea32b40c66ae6505f.png', '200.00', '1', '0.55', '12', '1',
        '0.89', '1500', '1、身份证；2、手机号', '<p>十个人以为 大萨达</p>', '50000', '200000', 'http://www.baidu.com',
        'uploads/2020/8/6/60f7ecf346d140258f5afa43eadccaa5.png', '1', '', '', '', '', '');
INSERT INTO `goods`
VALUES ('f0347c227a44413caaa7e8ac353f975b', '2020-08-12 16:02:21', '超级管理员', '999', '999', '2020-08-12 16:02:27',
        '超级管理员', '打', 'uploads/2020/8/12/9fe6c928bfb94bf082c7d0d8fc43d42e.jpeg', '12.00', '0', '45454.00', '454545',
        '45454', '45454.00', '5454454', '54', '<p>554545455</p>', '4545454', '54545454', '4545454', '', '1', null, null,
        null, null, null);

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order`
(
    `ID`                   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`         datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`              varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`           varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`     datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`         varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `USER_ID`              varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
    `USER_NAME`            varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
    `USER_PHONE`           varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户手机号',
    `APPLY_NAME`           varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请人姓名',
    `APPLY_PHONE`          varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请人手机号',
    `APPLY_ID_CARD_NUMBER` varchar(18) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '申请人身份证号',
    `AUDIT_STATE`          int(1)                                  NOT NULL COMMENT '审核状态 1申请中 2申请成功',
    `AUDIT_CONTENT`        varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核详细说明',
    `GOODS_ID`             varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡ID',
    `GOODS_NAME`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡名字',
    `GOODS_IMG`            varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡图片',
    `REWARD`               decimal(20, 2)                          DEFAULT NULL COMMENT '奖励金',
    `ODER_DETAIL`          longtext COLLATE utf8mb4_unicode_ci COMMENT '订单备注',
    `DELETED`              int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`               varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`               varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`               varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`               varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`               varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='订单表';

-- ----------------------------
-- Records of goods_order
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `LAST_UPDATE_TIME` datetime                                NOT NULL,
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
    `ORDER_ID`         int(10)                                 NOT NULL DEFAULT '50000' COMMENT '排序号',
    `NAME`             varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
    `ACTION`           varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '跳转页面',
    `PARENT_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '-1' COMMENT '父ID',
    `ICON`             varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '菜单图标',
    `NOTE`             varchar(2000) COLLATE utf8mb4_unicode_ci         DEFAULT NULL COMMENT '备注',
    `COMPONENT`        varchar(500) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '路由路径',
    `DELETED`          int(1)                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu`
VALUES ('04fc342e927547739b5d3fb91d115f03', '2020-07-20 17:38:47', '超级管理员N', '1', '1', '2020-07-21 10:26:39', '超级管理员N',
        '50000', '银行管理', '', '-1', '', '', '', '1', null, null, null, null, null);
INSERT INTO `menu`
VALUES ('06bd8714d19d477aa7bfe6ddd3dbc5d1', '2020-08-04 18:29:47', '超级管理员', '999', '999', '2020-08-04 18:56:41',
        '超级管理员', '50000', '海报管理', '/poster', '-1', '_poster-full', '', 'poster/poster', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('0ff7b9d2aa3b4f799892325cc1d17543', '2020-08-03 17:18:55', '超级管理员', '999', '999', '2020-08-03 17:18:55',
        '超级管理员', '50000', '兑换商品', '/card', '2ebcdd162a334822805f15906cfd9aed', '', '', 'card/card', '0', null, null,
        null, null, null);
INSERT INTO `menu`
VALUES ('1001', '2020-06-28 12:07:46', '超级管理员', '1', '1', '2020-07-21 10:25:48', '超级管理员N', '60000', '系统设置', '', '-1',
        '_set-full', '', '', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('1002', '2020-06-28 12:07:46', '超级管理员', '1', '1', '2020-06-30 14:14:33', '超级管理员', '50000', '菜单管理', '/menu',
        '1001', '', '', 'sys-setting/menu/index', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('1003', '2020-06-28 12:10:52', '超级管理员', '1', '1', '2020-06-29 11:31:19', '超级管理员', '50000', '角色管理', '/role',
        '1001', '', '', 'sys-setting/role/index', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('1004', '2020-06-28 12:12:45', '超级管理员', '1', '1', '2020-06-30 14:09:24', '超级管理员', '50000', '账号管理', '/staff',
        '1001', '', '', 'sys-setting/staff/index', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('1e1a54669648445c867b1107808f4907', '2020-07-27 17:25:49', '超级管理员', '1', '1', '2020-07-28 09:44:26', '超级管理员',
        '50000', '文章管理', '/article', 'ce1b6b85e9ba4b02b56ded588c0a8773', '', '', 'article/article', '0', '', '', '', '',
        '');
INSERT INTO `menu`
VALUES ('2b0732e8152448f8969382acc2e5829f', '2020-08-04 15:46:46', '超级管理员', '999', '999', '2020-08-04 15:49:14',
        '超级管理员', '50000', '用户管理', '', '-1', '_person-full', '', '', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('2e4de7eac5f44a25b78d495cfaf1be66', '2020-08-06 14:29:10', '超级管理员', '9999', '9999', '2020-08-06 14:31:39',
        '超级管理员', '50000', '测试改个菜单', '/poster', '-1', '	 _poster-full', '', 'poster/poster', '1', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('2ebcdd162a334822805f15906cfd9aed', '2020-07-24 18:37:09', '超级管理员', '1', '999', '2020-08-04 09:47:38', '超级管理员',
        '50000', '商品管理', '', '-1', '_card-full', '', '', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('3001', '2020-06-28 12:07:46', '超级管理员', '1', '999', '2020-08-07 17:11:17', '超级管理员', '60000', '盟主系统设置', '', '-1',
        'md-settings', '', '', '1', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('356b60de5cc84370a69112149ae407d2', '2020-08-05 15:02:27', '超级管理员', '999', '999', '2020-08-05 15:02:38',
        '超级管理员', '50002', '参数设置', '/systemSet', '1001', '', '', 'sys-setting/cashBack/systemSet', '0', '', '', '', '',
        '');
INSERT INTO `menu`
VALUES ('3704447e17e44a4ab012f28b1998ceee', '2020-08-04 16:54:53', '超级管理员', '999', '999', '2020-08-04 16:54:53',
        '超级管理员', '40009', '充值订单', '/orderMember', 'f2894f31837f4f5490e399cab9b16502', '', '', 'order/orderMember', '0',
        null, null, null, null, null);
INSERT INTO `menu`
VALUES ('388d69e884de4ba9a6378dfa522de9f8', '2020-08-05 14:13:13', '超级管理员', '999', '999', '2020-08-05 14:13:20',
        '超级管理员', '50001', '公告设置', '/notice', '1001', '', '', 'notice/notice', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('4b0d65c7fe334aeb97db20ccdbe627a0', '2020-07-21 11:09:25', '超级管理员N', '1', '1', '2020-07-21 11:10:16', '超级管理员N',
        '50000', '12312', '', 'f1c1f818a62d414e98fb31ae4504eccf', '', '', '', '1', null, null, null, null, null);
INSERT INTO `menu`
VALUES ('5912d5176f4e4b139d7e08694d2e5ecb', '2020-07-27 17:25:20', '超级管理员', '1', '1', '2020-07-28 09:49:25', '超级管理员',
        '40000', '类型管理', '/category', 'ce1b6b85e9ba4b02b56ded588c0a8773', '', '', 'article/category', '0', '', '', '',
        '', '');
INSERT INTO `menu`
VALUES ('6d82e8ad25004edf9dfb132963003ace', '2020-08-04 16:56:34', '超级管理员', '999', '999', '2020-08-04 16:56:34',
        '超级管理员', '50000', '兑换订单', '/orderForm', 'f2894f31837f4f5490e399cab9b16502', '', '', 'order/orderForm', '0',
        null, null, null, null, null);
INSERT INTO `menu`
VALUES ('7f0c0cb3ff834b84a358bae951faa198', '2020-08-09 14:48:13', '超级管理员', '999', '999', '2020-08-09 14:54:03',
        '超级管理员', '50008', '规则设置', '/rule', '1001', '', '', 'sys-setting/rule/rule', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('928dd6f9351144bd8b0659cec81abfc1', '2020-08-04 15:47:40', '超级管理员', '999', '999', '2020-08-04 15:47:40',
        '超级管理员', '50000', '盟主管理', '/agent', '2b0732e8152448f8969382acc2e5829f', '', '', 'user/agent', '0', null, null,
        null, null, null);
INSERT INTO `menu`
VALUES ('94257ca409984008b3b58a4b5d2141bb', '2020-07-23 17:03:20', '超级管理员N', '1', '1', '2020-07-23 17:10:10', '超级管理员N',
        '50000', '客服管理', '/customerService', '-1', '_service-full', '', 'customerService/customerService', '0', '', '',
        '', '', '');
INSERT INTO `menu`
VALUES ('9777dd1fe30e41f5980beb7885c23eb5', '2020-08-06 09:29:31', '超级管理员', '999', '999', '2020-08-06 09:29:31',
        '超级管理员', '50010', '返佣区订单', '/goodsOrder', 'f2894f31837f4f5490e399cab9b16502', '', '', 'order/goodsOrder', '0',
        null, null, null, null, null);
INSERT INTO `menu`
VALUES ('b1ef7c424cb846e4841b83df9c700d6c', '2020-08-12 18:01:00', '超级管理员', '999', '999', '2020-08-12 18:01:17',
        '超级管理员', '50000', '盟主调价', '/company_card', '-1', '_card-full', '', 'card/company_card', '0', '', '', '', '',
        '');
INSERT INTO `menu`
VALUES ('b8c50a94fd8b45c28f1da391e32e78b2', '2020-07-27 17:27:02', '超级管理员', '1', '1', '2020-07-27 17:30:06', '超级管理员',
        '50000', '轮播管理', '/swiper', '-1', '_swiper-full', '', 'swiper/swiper', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('c7377b4b32704997858ebf00add4dd6c', '2020-07-21 11:07:46', '超级管理员N', '1', '1', '2020-07-21 11:10:14', '超级管理员N',
        '50000', '123123', '/bank', 'f1c1f818a62d414e98fb31ae4504eccf', '', '', 'bank/bank', '1', null, null, null,
        null, null);
INSERT INTO `menu`
VALUES ('c84bfc90ce7e4541ad5e379cf9aeb353', '2020-08-13 12:22:46', '超级管理员', '999', '999', '2020-08-13 12:22:46',
        '超级管理员', '50020', '提现订单', '/getMoneyOrder', 'f2894f31837f4f5490e399cab9b16502', '', '', 'order/getMoneyOrder',
        '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('ce1b6b85e9ba4b02b56ded588c0a8773', '2020-07-27 17:24:47', '超级管理员', '1', '1', '2020-07-27 17:30:11', '超级管理员',
        '50000', '资讯文章', '', '-1', '_article-full', '', '', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('d0dcabd9be184dafb7dafbe1d7979868', '2020-08-03 18:45:49', '超级管理员', '999', '999', '2020-08-03 18:45:59',
        '超级管理员', '50001', '信用卡', '/goods_card', '2ebcdd162a334822805f15906cfd9aed', '', '', 'card/goods_card', '0', '',
        '', '', '', '');
INSERT INTO `menu`
VALUES ('df392783c25448fcbd03e6ebc2637cfd', '2020-08-04 15:47:24', '超级管理员', '999', '999', '2020-08-04 15:47:48',
        '超级管理员', '49999', '会员管理', '/member', '2b0732e8152448f8969382acc2e5829f', '', '', 'user/member', '0', '', '', '',
        '', '');
INSERT INTO `menu`
VALUES ('e6bbd322d2934334bb5d8d47059e8a27', '2020-08-04 14:32:14', '超级管理员', '999', '999', '2020-08-04 14:34:22',
        '超级管理员', '50002', '信贷商品', '/goods_money', '2ebcdd162a334822805f15906cfd9aed', '', '', 'card/goods_money', '0',
        '', '', '', '', '');
INSERT INTO `menu`
VALUES ('f1c1f818a62d414e98fb31ae4504eccf', '2020-07-21 10:26:34', '超级管理员N', '1', '1', '2020-07-21 11:10:24', '超级管理员N',
        '50000', '银行管理', '/bank', '-1', '_bank-full', '', 'bank/bank', '0', '', '', '', '', '');
INSERT INTO `menu`
VALUES ('f2894f31837f4f5490e399cab9b16502', '2020-08-04 16:53:08', '超级管理员', '999', '999', '2020-08-04 16:54:26',
        '超级管理员', '50009', '订单管理', '', '-1', '_order-full', '', '', '0', '', '', '', '', '');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `COMPANY_ID`       varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '盟主ID',
    `CONTENT`          varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告内容',
    `START_TIME`       datetime                                NOT NULL COMMENT '开始时间',
    `END_TIME`         datetime                                NOT NULL COMMENT '结束时间',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0 滚动 1弹窗',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='公告表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice`
VALUES ('1', '2020-07-20 14:16:31', '1', '1', '999', '2020-08-05 14:14:43', '超级管理员', '999', '这是3条公告内容',
        '2020-08-05 00:00:00', '2020-08-31 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('2', '2020-07-20 14:17:01', '2', '2', '999', '2020-08-05 14:14:31', '超级管理员', '999', '这是2条公告内容',
        '2020-08-05 00:00:00', '2020-08-31 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('3', '2020-07-20 14:18:50', '3', '3', '999', '2020-08-05 14:14:04', '超级管理员', '999', '这是一条公告内容',
        '2020-08-19 00:06:04', '2020-08-31 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('676d5d09d8704d509d4668a8f1a646af', '2020-08-12 15:09:26', '超级管理员', '999', '999', '2020-08-12 15:09:26',
        '超级管理员', '999', '新增公告1', '2020-08-12 00:00:00', '2020-08-19 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('788a19545ad14f5ea132def7131a3dc4', '2020-08-12 15:10:13', '超级管理员', '999', '999', '2020-08-12 15:11:04',
        '超级管理员', '999', '大大萨达', '2020-08-01 00:00:00', '2020-08-27 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('8396b3a308de4bb4b957517b47f3824b', '2020-08-12 15:10:01', '超级管理员', '999', '999', '2020-08-12 15:10:01',
        '超级管理员', '999', '新增公告2', '2020-08-13 00:00:00', '2020-08-20 00:00:00', '0', '0', null, null, null, null);
INSERT INTO `notice`
VALUES ('f57ed7253bce4bd39fccca36a9dfcf99', '2020-08-12 15:10:46', '超级管理员', '999', '999', '2020-08-19 17:11:56',
        '超级管理员', '999', '新增公告3', '2020-08-12 00:00:00', '2020-08-27 00:00:00', '0', '1', '', '', '', '');

-- ----------------------------
-- Table structure for notice_tan
-- ----------------------------
DROP TABLE IF EXISTS `notice_tan`;
CREATE TABLE `notice_tan`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `USER_ID`          varchar(50) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '用户ID',
    `NOTICE_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '公告ID',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice_tan
-- ----------------------------
INSERT INTO `notice_tan`
VALUES ('13000dbfea094546a605260c5594339a', '2020-08-20 12:06:20', '瑋梦', '94b30333e881498db1c0061a4065f050',
        '94b30333e881498db1c0061a4065f050', '2020-08-20 12:06:20', '瑋梦', '0', null, null, null, null, null,
        '94b30333e881498db1c0061a4065f050', 'f57ed7253bce4bd39fccca36a9dfcf99');
INSERT INTO `notice_tan`
VALUES ('13d00804503a4fa28b1df8a9c0a6f60d', '2020-08-19 17:58:51', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-19 17:58:51',
        '信用卡积分变现、 pos机免费', '0', null, null, null, null, null, 'fd64688534a144e48c84a281ec17c98b',
        'f57ed7253bce4bd39fccca36a9dfcf99');
INSERT INTO `notice_tan`
VALUES ('5e4521eaa6c84f2d998e57af010a0e97', '2020-08-20 14:22:35', 'xvmpmvcv', 'ee52c0f89e7547ddafdf80af5d0eeb76',
        'ee52c0f89e7547ddafdf80af5d0eeb76', '2020-08-20 14:22:35', 'xvmpmvcv', '0', null, null, null, null, null,
        'ee52c0f89e7547ddafdf80af5d0eeb76', 'f57ed7253bce4bd39fccca36a9dfcf99');
INSERT INTO `notice_tan`
VALUES ('690399474a4848d580ec507522e18dd7', '2020-08-20 13:44:13', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-20 13:44:13', '积分兑现-蔺先生', '0', null, null, null, null, null,
        '04a3b853256f46a8bf43b534488d3169', 'f57ed7253bce4bd39fccca36a9dfcf99');
INSERT INTO `notice_tan`
VALUES ('b81d55014b0047f5ae199bbfa53bfb3f', '2020-08-19 17:59:41', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-19 17:59:41', '?', '0', null, null, null, null, null,
        'cd269fa995b5484d8c13fd85ae62df2b', 'f57ed7253bce4bd39fccca36a9dfcf99');
INSERT INTO `notice_tan`
VALUES ('cb49aff424c54b3bb4c9602ce0c4de40', '2020-08-20 15:49:21', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-20 15:49:21', '赵家三少', '0', null, null, null, null, null,
        '380d1b09a4cc41da8908721c4c715286', 'f57ed7253bce4bd39fccca36a9dfcf99');

-- ----------------------------
-- Table structure for order_form
-- ----------------------------
DROP TABLE IF EXISTS `order_form`;
CREATE TABLE `order_form`
(
    `ID`                varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`      datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`           varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`  datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`      varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `USER_ID`           varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
    `USER_NAME`         varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
    `USER_PHONE`        varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户手机号',
    `SPEND_POINT`       decimal(20, 4)                          DEFAULT NULL COMMENT '花费积分',
    `AUDIT_STATE`       int(1)                                  NOT NULL COMMENT '审核状态 1待审核 2审核中 3审核成功 4审核失败',
    `AUDIT_CONTENT`     varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核详细说明',
    `BANK_ID`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行ID',
    `BANK_NAME`         varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行名称',
    `BANK_IMG`          varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行图片',
    `CARD_ID`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡ID',
    `CARD_NAME`         varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '银行卡名字',
    `ITEM_TYPE`         int(1)                                  DEFAULT NULL COMMENT '兑换物品类型 1虚拟 2实物',
    `ITEM_CONTENT`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物品具体内容，卡券密码或实物名称',
    `GET_MONEY`         decimal(20, 2)                          DEFAULT NULL COMMENT '获得金钱',
    `UNIT_PRICE`        decimal(10, 2)                          DEFAULT NULL COMMENT '兑换时 物品单价 /元万分',
    `SERVICE_ID`        varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服ID',
    `SERVICE_NAME`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服名字',
    `SERVICE_NUMBER`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服微信号',
    `SERVICE_IMG`       varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客服二维码',
    `ODER_DETAIL`       longtext COLLATE utf8mb4_unicode_ci COMMENT '订单具体牵扯受益人',
    `WX_PAYMENT_ID`     varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信订单ID',
    `WX_PAYMENT_AMOUNT` decimal(20, 2)                          DEFAULT NULL COMMENT '微信支付金额',
    `DELETED`           int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `ORDER_TYPE`        int(1)                                  DEFAULT NULL COMMENT '订单类型 1兑换积分 2会员充值 4会员提现',
    `SPARE2`            varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`            varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`            varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`            varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='订单表';

-- ----------------------------
-- Records of order_form
-- ----------------------------
INSERT INTO `order_form`
VALUES ('035ebbdde4ef4f4995059da8890c4e26', '2020-08-13 14:53:09', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 14:53:09', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '赵家三少',
        '13639633474', '100000.0000', '3', null, '040ceda7e667431b8757006a40694d56', '成都银行',
        'uploads/2020/7/24/4a5bf251e8bc402c9d02f77e42b49a61.png', '34b20c11a0264899a3ee622d22db7f73', 'qwe1', '0',
        'qwe1', '145.00', '145.00', null, null, null, null,
        '姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主直接兑换 获得收益：145.00元 0积分\n姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主永久收益 获得收益：5.00元 0积分\n姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主差价收益 获得收益：5.00元 0积分\n姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主团队奖收益 获得收益：0.10元 0积分\n',
        null, null, '0', '1', null, null, null, null);
INSERT INTO `order_form`
VALUES ('2767f97d865445b8bfee6dddc1278182', '2020-08-17 11:09:56', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-17 11:09:56', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        'nfceexbw', '15936200010', null, '0', 'moneyUpgrade', null, null, null, null, null, null, null, null, null,
        null, null, null, null, '', null, '188.00', '0', '2', null, null, null, null);
INSERT INTO `order_form`
VALUES ('48b6cdaab589420bae5bd16d1ed2780f', '2020-08-18 16:46:39', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-18 16:46:39',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '信用卡积分变现、 pos机免费', '15324801333', null, '0',
        'moneyUpgrade', null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, '88.00',
        '0', '2', null, null, null, null);
INSERT INTO `order_form`
VALUES ('49497722a8c845668f7f544d0f64ac56', '2020-08-17 10:55:53', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-17 10:55:53', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        'nfceexbw', '15936200010', null, '0', 'moneyUpgrade', null, null, null, null, null, null, null, null, null,
        null, null, null, null, '', null, '188.00', '0', '2', null, null, null, null);
INSERT INTO `order_form`
VALUES ('4b5db707f7fe4e5bb9abfd3d7cf1dccf', '2020-08-20 15:16:54', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 15:16:54',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '信用卡积分变现、 pos机免费', '15324801333', null, '2', '', null,
        null, null, null, null, null, null, '10.00', null, null, null, null, null, '', null, null, '0', '4', null, null,
        null, null);
INSERT INTO `order_form`
VALUES ('4bdc90a29be4487abdc5dcefbdb6c2e1', '2020-08-13 14:28:44', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-13 14:28:44', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '?',
        '15670004181', '100000.0000', '3', null, '040ceda7e667431b8757006a40694d56', '成都银行',
        'uploads/2020/7/24/4a5bf251e8bc402c9d02f77e42b49a61.png', '9d32f870582c4c0db63c697e3cb7898b', 'qwe', '0', 'qwe',
        '100.00', '100.00', null, null, null, null,
        '姓名：? ID:cd269fa995b5484d8c13fd85ae62df2b通过：会员直接兑换 获得收益：100.00元 0积分\n', null, null, '0', '1', null, null, null,
        null);
INSERT INTO `order_form`
VALUES ('4fc5660aa6b249ff93a4e7a919295c00', '2020-08-18 16:41:16', 'xiwwljmi', '94b30333e881498db1c0061a4065f050',
        '94b30333e881498db1c0061a4065f050', '2020-08-18 16:41:16', 'xiwwljmi', '94b30333e881498db1c0061a4065f050',
        'xiwwljmi', '18595896673', '100000.0000', '2', null, '06ef9cc25b17475d92439c3ca4516c6b', '光大银行',
        'uploads/2020/7/24/2a45553d19404b2b8e28fcc5d6518ab6.png', 'c6378785685c4fdeac951ae80eac6754', '百货', '1', '百货',
        null, null, null, null, null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `order_form`
VALUES ('65683c8f0139410296213ab05bc39b55', '2020-08-17 10:56:00', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-17 10:56:00', 'nfceexbw', '04a3b853256f46a8bf43b534488d3169',
        'nfceexbw', '15936200010', null, '0', 'moneyUpgrade', null, null, null, null, null, null, null, null, null,
        null, null, null, null, '', null, '598.00', '0', '3', null, null, null, null);
INSERT INTO `order_form`
VALUES ('700d184b92bc4437b1bda49cd3b46fff', '2020-08-13 15:04:09', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '999',
        '2020-08-13 15:04:37', '超级管理员', '380d1b09a4cc41da8908721c4c715286', '赵家三少', '13639633474', '100000.0000', '4',
        '失败', '040ceda7e667431b8757006a40694d56', '成都银行', 'uploads/2020/7/24/4a5bf251e8bc402c9d02f77e42b49a61.png',
        '34b20c11a0264899a3ee622d22db7f73', 'qwe1', '0', 'qwe1', null, null, null, null, null, null, '', null, null,
        '0', '1', null, null, null, null);
INSERT INTO `order_form`
VALUES ('a31a3a5a57984f899d59b3e739c00c37', '2020-08-13 14:29:26', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-13 14:29:26', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '?',
        '15670004181', null, '4', '没钱', null, null, null, null, null, null, null, '100.02', null, null, null, null,
        null, '', null, null, '0', '4', null, null, null, null);
INSERT INTO `order_form`
VALUES ('a389ae67466e4fcebac9b6997bb3c319', '2020-08-13 15:04:12', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 15:04:12', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '赵家三少',
        '13639633474', '100000.0000', '2', null, '040ceda7e667431b8757006a40694d56', '成都银行',
        'uploads/2020/7/24/4a5bf251e8bc402c9d02f77e42b49a61.png', '34b20c11a0264899a3ee622d22db7f73', 'qwe1', '0',
        'qwe1', null, null, null, null, null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `order_form`
VALUES ('a8847b8fce5840368edb76bdc080ebc2', '2020-08-13 15:01:12', '赵家三少', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '2020-08-13 15:01:12', '赵家三少', '380d1b09a4cc41da8908721c4c715286', '赵家三少',
        '13639633474', null, '3', '', null, null, null, null, null, null, null, '5.00', null, null, null, null, null,
        '', null, null, '0', '4', null, null, null, null);
INSERT INTO `order_form`
VALUES ('bca3910071ae444e9b5bfe1c73aab301', '2020-08-19 15:35:13', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-19 15:35:13',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '信用卡积分变现、 pos机免费', '15324801333', null, '0',
        'moneyUpgrade', null, null, null, null, null, null, null, null, null, null, null, null, null, '', null,
        '5288.00', '0', '3', null, null, null, null);
INSERT INTO `order_form`
VALUES ('cd9963cefe144d2dbe7a52252660253f', '2020-08-17 14:03:37', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-17 14:03:37', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '积分兑现-蔺先生', '15936200010', null, '0', 'moneyUpgrade', null, null, null, null, null, null, null, null, null,
        null, null, null, null, '', null, '5288.00', '0', '3', null, null, null, null);
INSERT INTO `order_form`
VALUES ('ff7edf8ce19744059a818ab992b07ab2', '2020-08-19 12:40:35', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-19 12:40:35',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '信用卡积分变现、 pos机免费', '15324801333', '100000.0000', '3',
        null, '932c1622e0364adfb3701278f5ee1091', '中国银行', 'uploads/2020/7/24/1e8ade57bdbd4d5591371db9f47d463b.png',
        '9127ed0bc41545bbac2a6687c054013b', '券', '0', '券', '10.00', '10.00', null, null, null, null,
        '姓名：积分兑现-蔺先生 ID:04a3b853256f46a8bf43b534488d3169通过：会员直接推荐 获得收益：0.00元 0积分\n姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主永久收益 获得收益：0.00元 0积分\n姓名：赵家三少 ID:380d1b09a4cc41da8908721c4c715286通过：盟主团队奖收益 获得收益：0.00元 0积分\n',
        null, null, '0', '1', null, null, null, null);

-- ----------------------------
-- Table structure for poster
-- ----------------------------
DROP TABLE IF EXISTS `poster`;
CREATE TABLE `poster`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `POSTER_NAME`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '海报名称',
    `POSTER_IMG`       varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='海报管理表';

-- ----------------------------
-- Records of poster
-- ----------------------------
INSERT INTO `poster`
VALUES ('0a672684c5e448649ef4c10780e4decd', '2020-08-12 11:05:27', '超级管理员', '999', '999', '2020-08-12 11:05:30',
        '超级管理员', '打撒', 'uploads/2020/8/12/4c995c344e154346a8c7b953a7dce0b2.jpg', '1', '', '', '', '', '');
INSERT INTO `poster`
VALUES ('111', '2020-08-04 18:23:31', '11', '11', '999', '2020-08-12 13:35:18', '超级管理员', 'asdfasdf',
        'uploads/2020/7/30/d2a25cf39cf24165ae8cd7b8aacf5ce4.jpeg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('115f0ac93385448ab95e5029f89b347e', '2020-08-06 14:40:48', '超级管理员', '9999', '999', '2020-08-12 09:58:34',
        '超级管理员', '大萨达', 'uploads/2020/8/6/f2c62568ab9042449aacc3204283b3ff.png', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('222', '2020-08-04 18:23:31', '11', '11', '999', '2020-08-12 09:58:34', '超级管理员', '测试2',
        'uploads/2020/7/30/d2a25cf39cf24165ae8cd7b8aacf5ce4.jpeg', '1', '', '', '', '', '');
INSERT INTO `poster`
VALUES ('2eed2e9f5f034cf7874efded2c769998', '2020-08-12 18:50:56', '超级管理员', '999', '999', '2020-08-12 18:51:05',
        '超级管理员', 'dadas', 'uploads/2020/8/12/ee881c84fb3e4328aaef9340a43c2f73.jpeg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('61b66e1f74e343809e1de5e017c25995', '2020-08-12 09:58:51', '超级管理员', '999', '999', '2020-08-12 09:58:51',
        '超级管理员', '海报二', 'uploads/2020/8/12/d67063d0e2334c3da00e4eae4679abd0.jpg', '0', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('9bb8dea2d4884e62b851a0d3c4ec8bb8', '2020-08-12 11:03:31', '超级管理员', '999', '999', '2020-08-14 15:12:09',
        '超级管理员', '海报六', 'uploads/2020/8/12/ee37441606d840df8cd4128a5379c154.jpg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('9d21f57b5ba4457fbdac9f66cfd3c9f3', '2020-08-12 15:55:43', '超级管理员', '999', '999', '2020-08-14 15:12:09',
        '超级管理员', '打撒', 'uploads/2020/8/12/128634b7c4b74106b5195804f898017a.jpeg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('9d88f28787bd4575919ffd1fe605514d', '2020-08-12 13:43:17', '超级管理员', '999', '999', '2020-08-12 15:54:45',
        '超级管理员', 'fas', 'uploads/2020/8/12/f5441a67241748a4a45634decc017394.png', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('a63e7c8ebff04ba8b7e305b9b06e470c', '2020-08-04 18:50:58', '超级管理员', '999', '999', '2020-08-12 09:58:34',
        '超级管理员', '撒旦艾丹', 'uploads/2020/8/6/8264986e9e4e4b419f31193f4e1a91b3.jpeg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('a812d0406ccf40adb05f0fcc5c3b9dab', '2020-08-12 09:59:07', '超级管理员', '999', '999', '2020-08-12 09:59:07',
        '超级管理员', '海报四', 'uploads/2020/8/12/83822e9010124e4096b6da6edec128a5.jpg', '0', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('ccdf4141cf9f4eb18a31b1904d376bef', '2020-08-12 11:04:53', '超级管理员', '999', '999', '2020-08-12 11:05:02',
        '超级管理员', '大萨达', 'uploads/2020/8/12/47f0146ba7f6434c8d2a94ef1efc1f7c.png', '1', '', '', '', '', '');
INSERT INTO `poster`
VALUES ('da69a5a3f26e437498bdad5596d1ab9b', '2020-08-12 15:55:16', '超级管理员', '999', '999', '2020-08-14 15:12:09',
        '超级管理员', '阿斯达', 'uploads/2020/8/12/d806b2147059423fa3087c8f03c1e8d2.jpeg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('db12c40e73d44397bb6e7fe858079e8a', '2020-08-12 13:34:59', '超级管理员', '999', '999', '2020-08-12 13:35:18',
        '超级管理员', 'asdf ', 'uploads/2020/8/12/eb178d90b3d04ae6a51d537ddb918a13.png', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('dfe207f41cf84649b27de19ac11fc842', '2020-08-12 09:58:43', '超级管理员', '999', '999', '2020-08-12 09:58:43',
        '超级管理员', '海报一', 'uploads/2020/8/12/88cfe2970bfb4fa9a95ebbe1ef4acd8b.jpg', '0', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('e5c22993db2444cdb29b5d837fd2f30d', '2020-08-12 11:03:52', '超级管理员', '999', '999', '2020-08-14 15:12:09',
        '超级管理员', '海报五', 'uploads/2020/8/12/41b57d2139a2440b8ab47d3930b28847.jpg', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('e6bf7675499a49ab8cb79455f1a8b66d', '2020-08-12 13:39:39', '超级管理员', '999', '999', '2020-08-12 15:54:45',
        '超级管理员', 'asf ', 'uploads/2020/8/12/86e4bfe2966f4d07b1d1c5989a9c6536.png', '1', null, null, null, null, null);
INSERT INTO `poster`
VALUES ('f10a5c4200a04d44ba9e71df8bbc112b', '2020-08-12 11:04:39', '超级管理员', '999', '999', '2020-08-14 15:12:09',
        '超级管理员', '海报七1', 'uploads/2020/8/12/7ad9cc25f43a47efa1a7a452f3722fb3.jpg', '1', '', '', '', '', '');
INSERT INTO `poster`
VALUES ('fb0afd980c304f09a2d9e1d59d41d7bb', '2020-08-12 09:59:00', '超级管理员', '999', '999', '2020-08-12 09:59:00',
        '超级管理员', '海报三', 'uploads/2020/8/12/0adc53555d43463cad91d1e174d03190.jpg', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `LAST_UPDATE_TIME` datetime                                NOT NULL,
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
    `NAME`             varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
    `NOTE`             varchar(2000) COLLATE utf8mb4_unicode_ci         DEFAULT NULL COMMENT '角色描述',
    `DELETED`          int(1)                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role`
VALUES ('1', '2020-06-23 16:12:35', '超级管理员', '1', '1', '2020-06-29 17:56:48', '超级管理员', '超级管理员', '最高权限管理员', '0', null,
        null, null, null, null);
INSERT INTO `role`
VALUES ('2', '2020-06-23 16:12:35', '超级管理员', '1', '1', '2020-06-23 16:12:35', '超级管理员', '会员', '会员', '0', null, null,
        null, null, null);
INSERT INTO `role`
VALUES ('2b84fbd6fe3744bf8278b4630080221e', '2020-08-12 19:09:49', '超级管理员', '999', '999', '2020-08-12 19:09:52',
        '超级管理员', 'a', 'a', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('3', '2020-06-23 16:12:35', '超级管理员', '1', '1', '2020-06-23 16:12:35', '超级管理员', '盟主', '盟主', '0', null, null,
        null, null, null);
INSERT INTO `role`
VALUES ('475cb44adcad4118bef75115a5c7e843', '2020-08-12 17:54:53', '超级管理员', '999', '999', '2020-08-12 17:54:56',
        '超级管理员', '艾丹啊', '艾丹', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('6a444c5320404ab7abe33597f33ded54', '2020-08-14 15:19:19', '超级管理员', '999', '999', '2020-08-14 15:19:19',
        '超级管理员', '后台管理员', '拥有较高的后台管理权限', '0', null, null, null, null, null);
INSERT INTO `role`
VALUES ('74b5dc0262e6458994aa761b1d91d021', '2020-08-12 17:53:17', '超级管理员', '999', '999', '2020-08-12 17:53:21',
        '超级管理员', 'DSAF ASD', 'FASD FA', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('86267a275c2d4d8cb039f606f88e1b0f', '2020-08-12 19:09:35', '超级管理员', '999', '999', '2020-08-12 19:09:46',
        '超级管理员', 'ad', 'ad', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('8a5901a7b4bf425aa25ef6c1926bce18', '2020-08-06 11:19:14', '超级管理员', '999', '999', '2020-08-14 14:09:55',
        '超级管理员', '测试员', '用于测试', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('d6f363a4695e4db48fd8d9dcb35cbfe2', '2020-08-12 19:11:54', '超级管理员', '999', '999', '2020-08-12 19:12:00',
        '超级管理员', 'dsd', 'asd', '1', null, null, null, null, null);
INSERT INTO `role`
VALUES ('d8de8662ca4348fba54292dd2e3b3d3a', '2020-08-14 14:10:16', '超级管理员', '999', '999', '2020-08-14 14:10:16',
        '超级管理员', '客服人员', '用于给客户审核订单、打款', '0', null, null, null, null, null);
INSERT INTO `role`
VALUES ('dacfa80e7c644419a68727423b65a82b', '2020-08-14 15:16:02', '超级管理员', '999', '999', '2020-08-14 15:16:02',
        '超级管理员', '商品管理员', '管理各种商品调价', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `LAST_UPDATE_TIME` datetime                                NOT NULL,
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
    `MENU_ID`          varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `ROLE_ID`          varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL,
    `DELETED`          int(1)                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='角色菜单对应表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu`
VALUES ('0022543808db4c9fa1c33aa2bde678e0', '2020-08-14 15:16:08', '超级管理员', '999', '999', '2020-08-14 15:16:08',
        '超级管理员', '0ff7b9d2aa3b4f799892325cc1d17543', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('004d1b78b7fe48809fd99fff63eb8cf2', '2020-08-06 09:29:38', '超级管理员', '999', '999', '2020-08-06 09:29:38',
        '超级管理员', '9777dd1fe30e41f5980beb7885c23eb5', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('034ecc3181514233a33216b1ca3afa93', '2020-08-14 15:16:08', '超级管理员', '999', '999', '2020-08-14 15:16:08',
        '超级管理员', '2ebcdd162a334822805f15906cfd9aed', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('1', '2020-06-28 12:14:57', '1', '1', '1', '2020-06-28 12:14:57', '1', '1001', '1', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('20563eb3ec7448e6971bc34b211d7161', '2020-08-14 15:16:08', '超级管理员', '999', '999', '2020-08-14 15:16:08',
        '超级管理员', 'd0dcabd9be184dafb7dafbe1d7979868', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('220df9025e3e4c28b20f66f4abac6e89', '2020-08-14 15:16:20', '超级管理员', '999', '999', '2020-08-14 15:16:20',
        '超级管理员', '94257ca409984008b3b58a4b5d2141bb', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('2233f2f8d3924009b5df7d7eb31c05cd', '2020-07-27 17:27:14', '超级管理员', '1', '1', '2020-07-27 17:27:14', '超级管理员',
        '1e1a54669648445c867b1107808f4907', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('2241facc6d2040e4a349fdc71032b16d', '2020-08-07 17:11:50', '超级管理员', '999', '999', '2020-08-07 17:11:50',
        '超级管理员', '5912d5176f4e4b139d7e08694d2e5ecb', '3', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('27827a2590624ad885a0872fb11052cf', '2020-08-14 15:16:15', '超级管理员', '999', '999', '2020-08-14 15:16:15',
        '超级管理员', 'b8c50a94fd8b45c28f1da391e32e78b2', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('3', '2020-06-28 12:14:57', '1', '1', '1', '2020-06-28 12:14:57', '1', '1003', '1', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('3222f4c821114cbf9220d4b91de7aa89', '2020-08-14 15:16:10', '超级管理员', '999', '999', '2020-08-14 15:16:10',
        '超级管理员', 'ce1b6b85e9ba4b02b56ded588c0a8773', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('34f84ae729cc469ea9cd9b5b6ef9f5cc', '2020-08-14 15:19:32', '超级管理员', '999', '999', '2020-08-14 15:19:32',
        '超级管理员', 'f1c1f818a62d414e98fb31ae4504eccf', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('368ff231045e485983381dd2cbfa3c85', '2020-08-04 16:56:44', '超级管理员', '999', '999', '2020-08-04 16:56:44',
        '超级管理员', '6d82e8ad25004edf9dfb132963003ace', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('3eae3442131d446bb7ff88d7019ca6e4', '2020-08-05 14:13:25', '超级管理员', '999', '999', '2020-08-05 14:13:25',
        '超级管理员', '388d69e884de4ba9a6378dfa522de9f8', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('403b1c9d9cb94a8392d085956d19cab3', '2020-07-27 17:27:12', '超级管理员', '1', '1', '2020-07-27 17:27:12', '超级管理员',
        'b8c50a94fd8b45c28f1da391e32e78b2', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('4d09ea919bb84c5a925e5af92a52ceb5', '2020-08-14 15:14:59', '超级管理员', '999', '999', '2020-08-14 15:14:59',
        '超级管理员', 'c84bfc90ce7e4541ad5e379cf9aeb353', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('5', '2020-06-28 12:14:57', '1', '1', '1', '2020-06-28 12:14:57', '1', '1004', '1', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('509f935fe817427d85c493ad870f33fe', '2020-08-04 16:55:12', '超级管理员', '999', '999', '2020-08-04 16:55:12',
        '超级管理员', '3704447e17e44a4ab012f28b1998ceee', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('52eaa314b95f4526aadb5e998354013a', '2020-08-14 15:19:31', '超级管理员', '999', '999', '2020-08-14 15:19:31',
        '超级管理员', '1e1a54669648445c867b1107808f4907', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('546b6cd66fe74f079856457bf97c7296', '2020-08-05 15:02:52', '超级管理员', '999', '999', '2020-08-05 15:02:52',
        '超级管理员', '356b60de5cc84370a69112149ae407d2', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('5b017ffda6674ddca6ff070aa2b6c8c5', '2020-08-14 15:20:14', '超级管理员', '999', '999', '2020-08-14 15:20:14',
        '超级管理员', 'f1c1f818a62d414e98fb31ae4504eccf', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('6177d984059b4a649925b44527d7d59f', '2020-08-14 15:14:46', '超级管理员', '999', '999', '2020-08-14 15:14:46',
        '超级管理员', '2b0732e8152448f8969382acc2e5829f', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('62edea446eda41ab9f3aa7e569a6c1e5', '2020-07-27 17:27:14', '超级管理员', '1', '1', '2020-07-27 17:27:14', '超级管理员',
        '5912d5176f4e4b139d7e08694d2e5ecb', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('6a50425340894aef8c2ebb2e610f5831', '2020-08-14 15:19:44', '超级管理员', '999', '999', '2020-08-14 15:19:44',
        '超级管理员', '388d69e884de4ba9a6378dfa522de9f8', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('6d78061bd5d24c14b5c8c0794f23dabc', '2020-08-07 17:11:50', '超级管理员', '999', '999', '2020-08-07 17:11:50',
        '超级管理员', '1e1a54669648445c867b1107808f4907', '3', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('7a4523c21afb4be5b2f6f685868c4cef', '2020-07-21 11:09:12', '超级管理员N', '1', '1', '2020-07-21 11:09:12', '超级管理员N',
        'f1c1f818a62d414e98fb31ae4504eccf', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('7a83c0dd696a47e395d336071ad0bef8', '2020-07-24 18:37:13', '超级管理员', '1', '1', '2020-07-24 18:37:13', '超级管理员',
        '2ebcdd162a334822805f15906cfd9aed', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('7bf51b0f98bb4b6e8982e872fba45583', '2020-08-09 14:48:19', '超级管理员', '999', '999', '2020-08-09 14:48:19',
        '超级管理员', '7f0c0cb3ff834b84a358bae951faa198', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('85693369718649838e9aa007cd593309', '2020-08-12 18:01:53', '超级管理员', '999', '999', '2020-08-12 18:01:53',
        '超级管理员', 'b1ef7c424cb846e4841b83df9c700d6c', '3', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('88f0654bc0dd4ef78beb38a836f85d88', '2020-08-14 15:19:34', '超级管理员', '999', '999', '2020-08-14 15:19:34',
        '超级管理员', '9777dd1fe30e41f5980beb7885c23eb5', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('99699e6f7dd94d7ea33687472b1167bb', '2020-08-14 15:19:32', '超级管理员', '999', '999', '2020-08-14 15:19:32',
        '超级管理员', '3704447e17e44a4ab012f28b1998ceee', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('99f1bbe20b074dab9bd1713fa2025f72', '2020-08-14 15:16:09', '超级管理员', '999', '999', '2020-08-14 15:16:09',
        '超级管理员', 'e6bbd322d2934334bb5d8d47059e8a27', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('9ca536ca2f6b4d96b99de12a389673a5', '2020-08-14 15:19:28', '超级管理员', '999', '999', '2020-08-14 15:19:28',
        '超级管理员', '94257ca409984008b3b58a4b5d2141bb', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('9fa52c9a5e9a4e8a84b644f2013bf17d', '2020-08-14 15:19:26', '超级管理员', '999', '999', '2020-08-14 15:19:26',
        '超级管理员', 'd0dcabd9be184dafb7dafbe1d7979868', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('9fbc95bda6974cc29a2dc6c5068847eb', '2020-08-14 15:19:23', '超级管理员', '999', '999', '2020-08-14 15:19:23',
        '超级管理员', '2b0732e8152448f8969382acc2e5829f', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('a4c77facfbee465f9d6178ba4b3f6c58', '2020-08-14 15:19:33', '超级管理员', '999', '999', '2020-08-14 15:19:33',
        '超级管理员', '6d82e8ad25004edf9dfb132963003ace', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('a4d4b833603e4099894efd49097dfb4c', '2020-08-04 15:47:57', '超级管理员', '999', '999', '2020-08-04 15:47:57',
        '超级管理员', '2b0732e8152448f8969382acc2e5829f', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('a70b596a7834458e851d586120dd8370', '2020-08-14 15:14:56', '超级管理员', '999', '999', '2020-08-14 15:14:56',
        '超级管理员', '3704447e17e44a4ab012f28b1998ceee', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('a99bf2bb793c49588f86484c26ed2b77', '2020-08-14 15:16:13', '超级管理员', '999', '999', '2020-08-14 15:16:13',
        '超级管理员', '1e1a54669648445c867b1107808f4907', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('abb7ca13ec3e4ee6aa1d9ce0919d0544', '2020-08-14 15:14:48', '超级管理员', '999', '999', '2020-08-14 15:14:48',
        '超级管理员', '928dd6f9351144bd8b0659cec81abfc1', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('ac7c222e7d96453b8d1f9d9656e3ef18', '2020-08-13 12:33:08', '超级管理员', '999', '999', '2020-08-13 12:33:08',
        '超级管理员', 'c84bfc90ce7e4541ad5e379cf9aeb353', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('ad728b8ce3a641d3aa1678394481fd50', '2020-08-07 17:11:49', '超级管理员', '999', '999', '2020-08-07 17:11:49',
        '超级管理员', 'ce1b6b85e9ba4b02b56ded588c0a8773', '3', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('adfdf3aa84124270ba2148477cad5221', '2020-08-14 15:19:24', '超级管理员', '999', '999', '2020-08-14 15:19:24',
        '超级管理员', 'df392783c25448fcbd03e6ebc2637cfd', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('b259713da90b4c9b8e47448808798770', '2020-08-14 15:19:38', '超级管理员', '999', '999', '2020-08-14 15:19:38',
        '超级管理员', '7f0c0cb3ff834b84a358bae951faa198', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('bb448f6708e341cf85fb24225ad214d3', '2020-08-14 15:19:25', '超级管理员', '999', '999', '2020-08-14 15:19:25',
        '超级管理员', '2ebcdd162a334822805f15906cfd9aed', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('bcea0b93d2c94027b11933fa75f949cf', '2020-08-04 15:48:00', '超级管理员', '999', '999', '2020-08-04 15:48:00',
        '超级管理员', 'df392783c25448fcbd03e6ebc2637cfd', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('bcfd908e5f664a45a85eaf4e67b854b5', '2020-08-04 15:47:59', '超级管理员', '999', '999', '2020-08-04 15:47:59',
        '超级管理员', '928dd6f9351144bd8b0659cec81abfc1', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('c079899983c041108ff1ee88e3198026', '2020-08-14 15:19:27', '超级管理员', '999', '999', '2020-08-14 15:19:27',
        '超级管理员', 'e6bbd322d2934334bb5d8d47059e8a27', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('c0ee1051c4724e219abf2add52a02bcd', '2020-08-14 15:19:36', '超级管理员', '999', '999', '2020-08-14 15:19:36',
        '超级管理员', '1001', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('c1d6b69a98c74105965cf9f744d3a0b5', '2020-08-14 15:16:11', '超级管理员', '999', '999', '2020-08-14 15:16:11',
        '超级管理员', '5912d5176f4e4b139d7e08694d2e5ecb', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('c6884ee297bb440f8a6367d5ff729da0', '2020-08-03 18:46:13', '超级管理员', '999', '999', '2020-08-03 18:46:13',
        '超级管理员', 'd0dcabd9be184dafb7dafbe1d7979868', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('c9b4de2157064e3f8f3befff02df16b4', '2020-08-14 15:19:24', '超级管理员', '999', '999', '2020-08-14 15:19:24',
        '超级管理员', '928dd6f9351144bd8b0659cec81abfc1', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('cb4331d649964d2a8675d76d716301e6', '2020-07-27 17:27:13', '超级管理员', '1', '1', '2020-07-27 17:27:13', '超级管理员',
        'ce1b6b85e9ba4b02b56ded588c0a8773', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('ccaf22cc1fe64812906d6e24e28fe98d', '2020-08-14 15:19:32', '超级管理员', '999', '999', '2020-08-14 15:19:32',
        '超级管理员', 'f2894f31837f4f5490e399cab9b16502', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('ccf4b37987854ce7b156dd716a60dd84', '2020-08-14 15:14:56', '超级管理员', '999', '999', '2020-08-14 15:14:56',
        '超级管理员', 'f2894f31837f4f5490e399cab9b16502', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('cfca2f19ab8b48c9acf15d53ad13893b', '2020-07-23 17:08:51', '超级管理员N', '1', '1', '2020-07-23 17:08:51', '超级管理员N',
        '94257ca409984008b3b58a4b5d2141bb', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('d36dedebd263443781cdcbcac126dfa5', '2020-08-03 18:46:13', '超级管理员', '999', '999', '2020-08-03 18:46:13',
        '超级管理员', '0ff7b9d2aa3b4f799892325cc1d17543', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('d4ca1628275b48af8ff193c3eff48c18', '2020-08-14 15:14:58', '超级管理员', '999', '999', '2020-08-14 15:14:58',
        '超级管理员', '9777dd1fe30e41f5980beb7885c23eb5', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('d5f81f3f928c446e8a395b70e91b85e5', '2020-08-14 15:19:39', '超级管理员', '999', '999', '2020-08-14 15:19:39',
        '超级管理员', '356b60de5cc84370a69112149ae407d2', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('d75acd17befa4280ac88aa8e09275873', '2020-08-14 15:19:23', '超级管理员', '999', '999', '2020-08-14 15:19:23',
        '超级管理员', '06bd8714d19d477aa7bfe6ddd3dbc5d1', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('d8ed1c391f0d44ad824573bb5f5b8761', '2020-08-04 14:32:44', '超级管理员', '999', '999', '2020-08-04 14:32:44',
        '超级管理员', 'e6bbd322d2934334bb5d8d47059e8a27', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('d9e618cde0f147b5930c35415b441073', '2020-08-14 15:19:31', '超级管理员', '999', '999', '2020-08-14 15:19:31',
        '超级管理员', '5912d5176f4e4b139d7e08694d2e5ecb', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('dab19e7ffa94443cb33def1f52bc2b2a', '2020-08-07 17:11:48', '超级管理员', '999', '999', '2020-08-07 17:11:48',
        '超级管理员', 'b8c50a94fd8b45c28f1da391e32e78b2', '3', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('de7617777d834ba7bb0c3898ec8e61b7', '2020-08-04 18:29:52', '超级管理员', '999', '999', '2020-08-04 18:29:52',
        '超级管理员', '06bd8714d19d477aa7bfe6ddd3dbc5d1', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('de7cd0fac9ed42cb862d52bfa1e9bcff', '2020-08-04 16:53:51', '超级管理员', '999', '999', '2020-08-04 16:53:51',
        '超级管理员', 'f2894f31837f4f5490e399cab9b16502', '1', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('e11404010a84483ba439f79ece086e21', '2020-08-14 15:19:34', '超级管理员', '999', '999', '2020-08-14 15:19:34',
        '超级管理员', 'c84bfc90ce7e4541ad5e379cf9aeb353', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('e41fd2981ac94266b6014d564423bd6c', '2020-08-14 15:19:25', '超级管理员', '999', '999', '2020-08-14 15:19:25',
        '超级管理员', '0ff7b9d2aa3b4f799892325cc1d17543', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('e8936a9fc6074346a4e3165950053549', '2020-08-14 15:14:57', '超级管理员', '999', '999', '2020-08-14 15:14:57',
        '超级管理员', '6d82e8ad25004edf9dfb132963003ace', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('eac2d58cbf6142f8b07c968c4ab50c63', '2020-08-14 15:19:30', '超级管理员', '999', '999', '2020-08-14 15:19:30',
        '超级管理员', 'b8c50a94fd8b45c28f1da391e32e78b2', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('efabf2dd038d402084ab91219d249394', '2020-08-14 15:16:32', '超级管理员', '999', '999', '2020-08-14 15:16:32',
        '超级管理员', '1001', 'dacfa80e7c644419a68727423b65a82b', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('f0f45701cd6d4b178779ed2a94b4859c', '2020-08-14 15:19:46', '超级管理员', '999', '999', '2020-08-14 15:19:46',
        '超级管理员', '1004', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null, null);
INSERT INTO `role_menu`
VALUES ('f807b370b6a74bbba602291bf47a4ebe', '2020-08-14 15:14:47', '超级管理员', '999', '999', '2020-08-14 15:14:47',
        '超级管理员', 'df392783c25448fcbd03e6ebc2637cfd', 'd8de8662ca4348fba54292dd2e3b3d3a', '0', null, null, null, null,
        null);
INSERT INTO `role_menu`
VALUES ('fe477039d82240558b54320a17013169', '2020-08-14 15:19:30', '超级管理员', '999', '999', '2020-08-14 15:19:30',
        '超级管理员', 'ce1b6b85e9ba4b02b56ded588c0a8773', '6a444c5320404ab7abe33597f33ded54', '0', null, null, null, null,
        null);

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `CONTENT`          longtext COLLATE utf8mb4_unicode_ci     NOT NULL COMMENT '规则内容',
    `TYPE`             int(10)                                 NOT NULL COMMENT '规则类型 0 1 2 3 4 5 6 7 8 9 10 ',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='规则表';

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule`
VALUES ('50cce9ca86ba4558bdcb4b7f346ea51a', '2020-08-09 15:03:34', '超级管理员', '999', '999', '2020-08-20 16:29:59',
        '超级管理员',
        '<p></p><h5>盟主权益<span style=\"font-size: 12px;\"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span style=\"font-weight: normal;\">&nbsp;初级盟主直推会员奖5%，初级盟主间推会员奖5%；初级盟主同级兑换奖25%；初级盟主收益比50%；初级盟主团队奖1%；初级盟主二次升级奖励70%。</span></span></h5><h5><span style=\"font-weight: normal;\"><span style=\"font-size: 12px;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span>&nbsp; <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"font-size: 12px;\">高级盟主直推会员奖60%，高级盟主间推会员奖5%；高级盟主同级兑换奖15%；高级盟主收益比70%；高级盟主团队奖1.5%；高级盟主二次升级奖励70%。</span></span></h5><h5><span style=\"font-weight: 400;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span>&nbsp;<br><span style=\"font-size: 12px; font-weight: normal;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;特级盟主直推会员奖70%，特级盟主间推会员奖5%，特级盟主同级兑换奖5%；特级盟主收益比90%；特级盟主团队奖2%；</span></h5>',
        '2', '0', null, null, null, null, null);
INSERT INTO `rule`
VALUES ('5d610f962db14b5088a78c9bcd96a0ef', '2020-08-09 15:03:37', '超级管理员', '999', '999', '2020-08-20 15:14:13',
        '超级管理员',
        '<p>盟主政策：初级盟主价格598元，高级盟主价格2588元；特级盟主5288元。<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;推荐初级盟主奖励98元，推荐高级盟主奖励988元；推荐特级盟主奖励2588元。</p>',
        '3', '0', null, null, null, null, null);
INSERT INTO `rule`
VALUES ('748840bddbc347faa02c5d7c5ef69aac', '2020-08-09 15:03:31', '超级管理员', '999', '9999', '2020-08-10 14:21:37',
        '超级管理员', '<p>隐私政策说明111</p>', '0', '0', null, null, null, null, null);
INSERT INTO `rule`
VALUES ('af67b9c8b86842f29340c8b9355ecefb', '2020-08-09 15:03:40', '超级管理员', '999', '9999', '2020-08-10 12:01:55',
        '超级管理员',
        '<p>矮点发骚廖劲锋拉斯考级费聊啊扫;lfkjals;djflkas觉得;flkasjd;l</p><p><img src=\"http://localhost:8080/pa/uploads/2020/8/9/c2caf18b55824954aaaef05727743625.jpg\" style=\"max-width:100%;\"><br>aklsdj asjdf ;lkasd;lkjf ;lksadl;kfj ahbvcx&nbsp;</p>',
        '4', '0', null, null, null, null, null);
INSERT INTO `rule`
VALUES ('f4d26ee611694f10b798dc8c2c1b623a', '2020-08-09 15:03:26', '超级管理员', '999', '999', '2020-08-20 15:17:52',
        '超级管理员',
        '<p></p><h1>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 会员权益</h1>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 普通会员兑换直推奖2%，普通会员兑换间接奖1%。<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 黄金会员兑换直推奖2%，黄金会员兑换间推奖1%；黄金会员升级间推奖20%。<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 钻石会员兑换直推奖2%，钻石会员兑换间推奖1%；钻石会员升级直推奖50%；钻石会员升级间推奖20%。&nbsp;&nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 黄金会员价格88元，钻石会员188元。<p></p>',
        '1', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for send_sms
-- ----------------------------
DROP TABLE IF EXISTS `send_sms`;
CREATE TABLE `send_sms`
(
    `id`           varchar(32) NOT NULL COMMENT '短信验证码表',
    `phone`        varchar(11)                      DEFAULT NULL COMMENT '手机号',
    `code`         varchar(6) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '验证码',
    `state`        varchar(1)                       DEFAULT NULL COMMENT '状态1登录2注册3修改登录密码4修改交易密码5设置交易密码6申请成为队长7申请成为经理8申请成为代驾司机9app登陆',
    `end_time`     varchar(255)                     DEFAULT NULL COMMENT '过期时间',
    `created_time` timestamp   NULL                 DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='短信验证码表';

-- ----------------------------
-- Records of send_sms
-- ----------------------------
INSERT INTO `send_sms`
VALUES ('097d81a29bb54546bf3683454f01d480', '13663739801', '7186', '1', '2020-08-17 11:11:59', '2020-08-17 11:07:00');
INSERT INTO `send_sms`
VALUES ('0c0d469684dc48888c4cfdcda7634286', '15936200010', '6981', '1', '2020-08-17 10:42:37', '2020-08-17 10:37:38');
INSERT INTO `send_sms`
VALUES ('26a4ef1d9c85429b81112281c9d7c51c', '13721484116', '3060', '1', '2020-08-18 17:02:51', '2020-08-18 16:57:51');
INSERT INTO `send_sms`
VALUES ('417c35389ea04c12950a5c59757bde4c', '17638911245', '6154', '1', '2020-08-18 14:46:44', '2020-08-18 14:41:45');
INSERT INTO `send_sms`
VALUES ('4506de05b0c34ba09d4b9990304bf7ec', '17596562668', '2935', '1', '2020-08-20 14:26:34', '2020-08-20 14:21:35');
INSERT INTO `send_sms`
VALUES ('4a3540d3d5714f6abf0130b8ecdb739a', '13393743013', '3506', '1', '2020-08-18 10:29:37', '2020-08-18 10:24:37');
INSERT INTO `send_sms`
VALUES ('5acee2af970b4252bea008d6f4db1cdc', '18595896670', '6837', '1', '2020-08-18 17:07:16', '2020-08-18 17:02:16');
INSERT INTO `send_sms`
VALUES ('6073fae8acfb45938784a81699fbba71', '18595896673', '1004', '1', '2020-08-18 16:44:31', '2020-08-18 16:39:31');
INSERT INTO `send_sms`
VALUES ('6102afe8bc6e45e8a7d1b27de5b53b22', '17638911245', '2011', '1', '2020-08-18 15:00:19', '2020-08-18 14:55:20');
INSERT INTO `send_sms`
VALUES ('73a001b9568d40b9b575a85eae39b08f', '15738589102', '7685', '1', '2020-08-18 17:25:22', '2020-08-18 17:20:22');
INSERT INTO `send_sms`
VALUES ('7658fd2b1b274ba182802d87b91a40ae', '15324801333', '7287', '1', '2020-08-17 11:42:21', '2020-08-17 11:37:21');
INSERT INTO `send_sms`
VALUES ('7f037c672b9a4962894cfdcd74a5faf8', '12345678912', '1234', '1', '2020-08-15 15:13:25', '2020-08-13 15:08:26');
INSERT INTO `send_sms`
VALUES ('85169e618aa54d16a0d37a640ee31314', '17596562668', '8476', '2', '2020-08-20 14:23:47', '2020-08-20 14:18:47');
INSERT INTO `send_sms`
VALUES ('85af01e2df184dab995f7b0841f0d0db', '17638911245', '1562', '1', '2020-08-18 14:33:02', '2020-08-18 14:28:03');
INSERT INTO `send_sms`
VALUES ('861385bcb3b04a8fbd51d61d9ebeaf2b', '15290840512', '4451', '1', '2020-08-18 16:50:25', '2020-08-18 16:45:26');
INSERT INTO `send_sms`
VALUES ('863f03b01cba48cbbef5f4f17712e5a5', '15936200010', '9692', '1', '2020-08-17 11:06:30', '2020-08-17 11:01:31');
INSERT INTO `send_sms`
VALUES ('8a26e77fa07a456bb6aa3c2b810d3184', '15138012555', '7565', '1', '2020-08-17 18:06:45', '2020-08-17 18:01:45');
INSERT INTO `send_sms`
VALUES ('8dbcad3becb04624bb95d3ea91af37ac', '17596562668', '8069', '1', '2020-08-18 19:18:18', '2020-08-18 19:13:18');
INSERT INTO `send_sms`
VALUES ('9bd61f30dc3a46019d4637e9d5edf875', '15231657111', '9097', '1', '2020-08-17 11:07:36', '2020-08-17 11:02:36');
INSERT INTO `send_sms`
VALUES ('9f4aca02169640ee9f7a0d234c05ac5c', '13721484116', '3357', '1', '2020-08-18 14:50:17', '2020-08-18 14:45:17');
INSERT INTO `send_sms`
VALUES ('aae012e5b6aa4a68a34ea43cb3551176', '15290840512', '5517', '1', '2020-08-18 16:56:35', '2020-08-18 16:51:36');
INSERT INTO `send_sms`
VALUES ('bc7d733dd9f5469baf3cf0df68ba1c43', '15670004181', '4093', '1', '2020-08-17 18:07:06', '2020-08-17 18:02:07');
INSERT INTO `send_sms`
VALUES ('c2a14ced629540ee9201d0429026df81', '17638911245', '4470', '1', '2020-08-18 16:05:14', '2020-08-18 16:00:14');
INSERT INTO `send_sms`
VALUES ('c37a335914d8427881aa1b20bb0c6537', '18810519983', '3912', '1', '2020-08-18 17:03:16', '2020-08-18 16:58:17');
INSERT INTO `send_sms`
VALUES ('d2344536e8284325bfe091ea21e8b747', '17638911245', '3665', '1', '2020-08-18 14:57:24', '2020-08-18 14:52:24');
INSERT INTO `send_sms`
VALUES ('d48b823bbc9f4669a7440b25c47bd468', '17638911245', '3423', '1', '2020-08-18 15:09:12', '2020-08-18 15:04:12');
INSERT INTO `send_sms`
VALUES ('d5f050e34e944ef4b147de26234024e7', '15690637060', '9372', '1', '2020-08-18 17:09:09', '2020-08-18 17:04:09');
INSERT INTO `send_sms`
VALUES ('ebe0738989274d2f9e9d81cabb785ccb', '15670004185', '5157', '1', '2020-08-18 17:24:07', '2020-08-18 17:19:07');
INSERT INTO `send_sms`
VALUES ('fb8385cfbec04280bfa48c3ec5041522', '17638911245', '6144', '1', '2020-08-18 14:40:41', '2020-08-18 14:35:42');

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `USER_ID`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `GET_MONEY`        decimal(20, 2)                          DEFAULT NULL COMMENT '获取收益',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='签到表';

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign`
VALUES ('4317b0a1263d4e85a959cf9345bbfd5d', '2020-08-19 13:10:58', '瑋梦', '94b30333e881498db1c0061a4065f050',
        '94b30333e881498db1c0061a4065f050', '2020-08-19 13:10:58', '瑋梦', '94b30333e881498db1c0061a4065f050', '0', null,
        null, null, null, null, '0.02');
INSERT INTO `sign`
VALUES ('6ba2d45ed3ef4f93b4116021273c9a20', '2020-08-18 17:51:45', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-18 17:51:45', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '0', null,
        null, null, null, null, '0.01');
INSERT INTO `sign`
VALUES ('99c3d82398854516a98025f21b3dc2cc', '2020-08-18 17:56:42', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-18 17:56:42',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '0', null, null, null, null, null, '0.02');
INSERT INTO `sign`
VALUES ('9ab0eb0a76b746bf9b2d2b1eadc3a842', '2020-08-20 10:59:06', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169',
        '04a3b853256f46a8bf43b534488d3169', '2020-08-20 10:59:06', '积分兑现-蔺先生', '04a3b853256f46a8bf43b534488d3169', '0',
        null, null, null, null, null, '0.01');
INSERT INTO `sign`
VALUES ('b837a6c833ca4e74ba9d48b8f135dddc', '2020-08-19 18:11:14', '?', 'cd269fa995b5484d8c13fd85ae62df2b',
        'cd269fa995b5484d8c13fd85ae62df2b', '2020-08-19 18:11:14', '?', 'cd269fa995b5484d8c13fd85ae62df2b', '0', null,
        null, null, null, null, '0.01');
INSERT INTO `sign`
VALUES ('c9e1d19870ee4745bc5413300932d887', '2020-08-19 09:48:57', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-19 09:48:57',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '0', null, null, null, null, null, '0.01');
INSERT INTO `sign`
VALUES ('da2617d23a8548f4abb36be4ba24066e', '2020-08-18 17:57:01', '?  ʚ AN. ɞ', '1dc7465884d84eaaad84ac9849792520',
        '1dc7465884d84eaaad84ac9849792520', '2020-08-18 17:57:01', '?  ʚ AN. ɞ', '1dc7465884d84eaaad84ac9849792520',
        '0', null, null, null, null, null, '0.01');
INSERT INTO `sign`
VALUES ('f4706ee965fe42338c8c210893b373a7', '2020-08-20 13:15:00', '信用卡积分变现、 pos机免费',
        'fd64688534a144e48c84a281ec17c98b', 'fd64688534a144e48c84a281ec17c98b', '2020-08-20 13:15:00',
        '信用卡积分变现、 pos机免费', 'fd64688534a144e48c84a281ec17c98b', '0', null, null, null, null, null, '0.01');

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`
(
    `ID`               varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`     datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`          varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME` datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`     varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `IMAGE_PATH`       varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
    `LINK_URL`         varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'UTL连接 (备用字段先不显示)',
    `COMPANY_ID`       varchar(50) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '盟主ID',
    `DELETED`          int(1)                                  DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE2`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE3`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`           varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='轮播图';

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper`
VALUES ('03922409c8154cf989f7bf8dd645179f', '2020-08-12 16:18:26', '超级管理员', '999', '999', '2020-08-12 16:18:48',
        '超级管理员', 'uploads/2020/8/12/b6368f3baa0b4b35959d6b5591ea746b.jpeg', '大萨达', '999', '1', null, null, null, null,
        null);
INSERT INTO `swiper`
VALUES ('1d185eb3a7a3415f9bdb3cdf38d2fb87', '2020-07-16 09:34:04', 'admin', '001', '1', '2020-07-27 17:36:24', '超级管理员',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg', '2', '1', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('4e7a11c4f7ce4f1a84e3720d710192f5', '2020-07-28 09:29:26', '超级管理员', '1', '999', '2020-08-05 10:31:44', '超级管理员',
        'uploads/2020/8/5/f5ce0b96d46b4382ab3a2e2cca41bc9f.jpeg', 'https://www.baidu.com', null, '0', null, null, null,
        null, null);
INSERT INTO `swiper`
VALUES ('532e8d13f4c748e28acbaf8a0787eff9', '2020-07-30 18:10:12', '超级管理员', '1', '999', '2020-08-12 11:40:36', '超级管理员',
        'uploads/2020/8/5/4871ae4b396249b7969ad2d961e62f4d.jpeg', '', null, '1', null, null, null, null, null);
INSERT INTO `swiper`
VALUES ('554d5522fb32483cb94a3c4e70150e4d', '2020-07-15 11:56:16', '超级管理员N', '1', '999', '2020-08-05 10:31:52', '超级管理员',
        'uploads/2020/8/5/317c997018b84d649eeb42008a89d129.jpeg',
        'https://wstl.mrlegou.com/public/uploads/15898503520599f6ef949988ed31e370193efbb9f4074.jpg', '999', '0', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('5af27355618d4a359aabad98087e526e', '2020-07-28 09:31:13', '超级管理员', '1', '1', '2020-07-30 18:10:02', '超级管理员',
        'uploads/2020/7/28/d86d5a831f294c05bac0aaca5e271652.jpeg', '', null, '1', null, null, null, null, null);
INSERT INTO `swiper`
VALUES ('5c930fb50b0c4a5a82147996cacfc22a', '2020-08-12 11:40:15', '超级管理员', '999', '999', '2020-08-12 11:40:15',
        '超级管理员', 'uploads/2020/8/12/52af1a5a5bfc4921a2ac0abd23aaf201.jpeg', 'https://www.baidu.com', '999', '0', '', '',
        '', '', '');
INSERT INTO `swiper`
VALUES ('5e7f6c67424a415da40352fab9c52564', '2020-07-28 09:27:32', '超级管理员', '1', '1', '2020-07-28 09:27:35', '超级管理员',
        '', '', null, '1', null, null, null, null, null);
INSERT INTO `swiper`
VALUES ('91c6b45c493e49ffac58097eaea0329b', '2020-07-16 16:02:24', '超级管理员N', '1', '1', '2020-07-27 17:36:24', '超级管理员',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg', '1', '1', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('a799a1869d1e4c13b91126277f8c1d78', '2020-07-16 17:54:36', '超级管理员N', '1', '1', '2020-07-27 17:36:20', '超级管理员',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg', '1', '1', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('db1bdc8a0ffe4309882128adc40a0da6', '2020-08-12 11:40:28', '超级管理员', '999', '999', '2020-08-12 11:40:28',
        '超级管理员', 'uploads/2020/8/12/94367f091919416cb4d8ad436ed9b4bc.jpeg', 'https://www.baidu.com', '999', '0', '', '',
        '', '', '');
INSERT INTO `swiper`
VALUES ('df15ccfc126b4750b4440e14f1c5f8b9', '2020-08-06 15:27:44', '超级管理员', '999', '999', '2020-08-06 15:27:56',
        '超级管理员', 'uploads/2020/8/6/4592e2111c4440cfbbd03d0df9fa7318.jpg', 'dqwdq', '999', '1', null, null, null, null,
        null);
INSERT INTO `swiper`
VALUES ('e546271e573a417381e55a2a0502974f', '2020-08-12 11:41:10', '超级管理员', '999', '999', '2020-08-12 19:02:10',
        '超级管理员', 'uploads/2020/8/12/7db81a2c72ee4827b364c1e89b400148.jpeg', '22水水水水', '999', '0', '', '', '', '', '');
INSERT INTO `swiper`
VALUES ('f4a70d53d6704f0f8ce8e1b53c31d024', '2020-08-12 19:01:52', '超级管理员', '999', '999', '2020-08-12 19:01:59',
        '超级管理员', 'uploads/2020/8/12/516e4b7239a641beb06c812b9cb4d2f6.jpeg', '123', '999', '1', '', '', '', '', '');
INSERT INTO `swiper`
VALUES ('f4d94f87f20a496ba34bd4d714c612ae', '2020-08-06 14:43:55', '超级管理员', '9999', '9999', '2020-08-06 14:45:52',
        '超级管理员', 'uploads/2020/8/6/97f01ef9e3564b698d6dc7e666a47244.png', '大萨达', '9999', '1', null, null, null, null,
        null);
INSERT INTO `swiper`
VALUES ('f76ce63d399a43569fe182facbaf6911', '2020-07-15 11:56:03', '超级管理员N', '1', '1', '2020-07-27 17:36:24', '超级管理员',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg', '1', '1', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('f84714ea137b42c396b93d1d65060e63', '2020-07-17 09:36:06', '超级管理员N', '1', '1', '2020-07-27 17:36:18', '超级管理员',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg',
        'https://wstl.mrlegou.com/public/uploads/15898503394808d674edd9652c3b970226bd05cd12423.jpg', '1', '1', null,
        null, null, null, null);
INSERT INTO `swiper`
VALUES ('ffc35ab60ddc431e8bac6e8a54a0b984', '2020-08-12 11:40:02', '超级管理员', '999', '999', '2020-08-12 11:40:02',
        '超级管理员', 'uploads/2020/8/12/8fe31ef12008434681badfb97d084562.jpeg', 'https://www.baidu.com', '999', '0', '', '',
        '', '', '');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `ID`                varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`      datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`           varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`        varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`  datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`      varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `NAME`              varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '姓名',
    `PHONE`             varchar(20) COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '手机号',
    `ACCOUNT`           varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '登录账号',
    `PASSWORD`          varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '登录密码',
    `USER_STATE`        int(10)                                 NOT NULL DEFAULT '1' COMMENT '用户状态 1可用 0锁定',
    `ROLE_ID`           varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '角色ID',
    `ROLE_NAME`         varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称(随角色名称修改而修改）',
    `PARENT_ID`         varchar(50) COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '上级ID',
    `COMPANY_ID`        varchar(50) COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '盟主ID',
    `MEMBER_LEVEL`      int(10)                                 NOT NULL DEFAULT '1' COMMENT '会员等级 1 普通 2 黄金 3钻石',
    `COMPANY_LEVEL`     int(10)                                          DEFAULT NULL COMMENT '盟主等级 1初级 2高级 3特级',
    `BALANCE`           decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '会员余额',
    `CUMULATIVE_PROFIT` decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '累计收益',
    `CUMULATIVE_POINT`  decimal(20, 4)                          NOT NULL DEFAULT '0.0000' COMMENT '累计兑换积分 万为单位',
    `DELETED`           int(1)                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `OPEN_ID`           varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '微信ID',
    `INVITE_CODE`       varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '推荐码',
    `HEAD_URL`          varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '用户头像',
    `SPARE4`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`            varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `id` (`ID`) USING BTREE,
    UNIQUE KEY `ACCOUNT` (`ACCOUNT`) USING BTREE,
    UNIQUE KEY `INVITE_CODE` (`INVITE_CODE`) USING BTREE,
    UNIQUE KEY `PHONE` (`PHONE`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES ('04a3b853256f46a8bf43b534488d3169', '2020-08-17 10:38:06', 'register', 'register', 'register',
        '2020-08-17 10:38:06', 'register', '积分兑现-蔺先生', '15936200010', '15936200010',
        '762b924d3bd0e1272f7dca22ce4036fce0b3aa26', '1', '2', '会员', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.05', '0.05', '0.0000', '0', 'o-Ociwd3_7pbMZo-T-uoNpGMbVwo',
        '764996', 'head/3d419fcf28ae422da4c9fe0529efae77.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('1dc7465884d84eaaad84ac9849792520', '2020-08-18 16:58:06', 'register', 'register', 'register',
        '2020-08-18 16:58:06', 'register', '?  ʚ AN. ɞ', '13721484116', '13721484116',
        '1730216f919e87c80799013186dfbe0a28f01736', '1', '2', '会员', 'fd64688534a144e48c84a281ec17c98b',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.02', '0.02', '0.0000', '0', 'o-Ociwfo1LvIwvOFr3AaBzW2UpoE',
        '975890', 'head/e7361ad25df04668a7bf8088d00ea462.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('353457a7339544238fdb0f98282c92de', '2020-08-13 15:10:35', 'register', 'register', '999', '2020-08-17 12:38:25',
        '超级管理员', 'kqxxauwt', '12345678912', '12345678912', '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '2', '会员',
        '380d1b09a4cc41da8908721c4c715286', '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.01', '0.01', '0.0000', '0',
        '', '750919', '', null, null);
INSERT INTO `sys_user`
VALUES ('380d1b09a4cc41da8908721c4c715286', '2020-08-13 09:30:18', 'register', 'register', '999', '2020-08-20 14:29:18',
        '超级管理员', '赵家三少', '13639633474', '13639633474', '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '3', '盟主',
        'cd269fa995b5484d8c13fd85ae62df2b', '', '3', '3', '150.11', '155.11', '1.0000', '0',
        'o-OciwRNWwW4XkFckIu-_Bdbh0x8', '873752', 'head/788be52e6cfc4d84b2138db1ae082a1c.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('5cb24285ed674ea28973fae7419cf20b', '2020-08-18 17:03:01', 'register', 'register', 'register',
        '2020-08-18 17:03:01', 'register', 'laiyzkmb', '18595896670', '18595896670',
        'f1a7c3982f7a12b4b87483f241c634c809b8f4ff', '1', '2', '会员', '94b30333e881498db1c0061a4065f050',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '105083', '', null, null);
INSERT INTO `sys_user`
VALUES ('7024c6b4aa974d33abfde7db40eca256', '2020-08-18 17:20:50', 'register', 'register', 'register',
        '2020-08-18 17:20:50', 'register', 'wgkvqrpw', '15738589102', '15738589102',
        '689bc780ec7f4052e6b408ab0b837d95bd16f5dd', '1', '2', '会员', '94b30333e881498db1c0061a4065f050',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '695547', '', null, null);
INSERT INTO `sys_user`
VALUES ('7bc2126457b049899bbc24a96fa78e4a', '2020-08-18 10:25:10', 'register', 'register', 'register',
        '2020-08-18 10:25:10', 'register', 'vysadocg', '13393743013', '13393743013',
        '6c3807736b5a73a01166fb05a42f5add89afdbd5', '1', '2', '会员', '04a3b853256f46a8bf43b534488d3169',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '952792', '', null, null);
INSERT INTO `sys_user`
VALUES ('8827c45928ad4e6dac0470db1cf23486', '2020-08-17 11:03:16', 'register', 'register', 'register',
        '2020-08-17 11:03:16', 'register', 'vdnckidx', '15231657111', '15231657111',
        'b7f126a08845563ca5a34a61d9217e32e2d3d231', '1', '2', '会员', '04a3b853256f46a8bf43b534488d3169',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '661413', '', null, null);
INSERT INTO `sys_user`
VALUES ('94b30333e881498db1c0061a4065f050', '2020-08-18 16:40:26', 'register', 'register', 'register',
        '2020-08-18 16:40:26', 'register', '瑋梦', '18595896673', '18595896673',
        '689bc780ec7f4052e6b408ab0b837d95bd16f5dd', '1', '2', '会员', '04a3b853256f46a8bf43b534488d3169',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.03', '0.03', '0.0000', '0', 'o-OciwSgrAm-yPL-ywzfMGtp0Dcg',
        '337587', 'head/1048ee2442f249659629d8c4e876a7b3.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('999', '2020-06-23 16:13:30', '超级管理员', '1', '1', '2020-07-25 09:08:07', '超级管理员12', '超级管理员', '132',
        'administrator', 'fa9b6e4d986dfc22d4b8a57ea4809cf715dbd596', '1', '1', '超级管理员', '', '999', '3', '3', '0.00',
        '0.00', '0.0000', '0', null, '123456', 'head/fb45f01edaef437aa3a0c0b378586e5d.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('ade666b07508412995156acba490cbd9', '2020-08-18 16:51:45', 'register', 'register', 'register',
        '2020-08-18 16:51:45', 'register', 'mwdifhnv', '15290840512', '15290840512',
        '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '2', '会员', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '432648', '', null, null);
INSERT INTO `sys_user`
VALUES ('b931f1e257f346ec92259d42dfa715e5', '2020-08-17 11:08:10', 'register', 'register', 'register',
        '2020-08-17 11:08:10', 'register', '教皇', '13663739801', '13663739801',
        '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '2', '会员', '380d1b09a4cc41da8908721c4c715286',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', 'o-OciwXrXmwCCVn5WY-lSjRqRFPo',
        '274318', 'head/ca255ca7b4b445aab7e8d0c494184e83.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('cd269fa995b5484d8c13fd85ae62df2b', '2020-08-13 09:20:10', 'register', 'register', 'register',
        '2020-08-13 09:20:10', 'register', '?', '15670004181', '15670004181',
        '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '2', '会员', '', '', '1', '0', '100.08', '100.06', '100000.0000',
        '0', 'o-OciwbJzj5xxbd96zUDAXXie34k', '825028', 'head/bed295451ced41799a8a5c44b910c8b4.jpg', null, null);
INSERT INTO `sys_user`
VALUES ('cf36008500f24aecbcc0e85d6a8fbf21', '2020-08-18 16:00:41', 'register', 'register', 'register',
        '2020-08-18 16:00:41', 'register', 'efqycykq', '17638911245', '17638911245',
        '1cfafdd84b03907d17d4ad4706fc76e840f0219a', '1', '2', '会员', 'cd269fa995b5484d8c13fd85ae62df2b', '', '1', '0',
        '0.00', '0.00', '0.0000', '0', '', '494284', '', null, null);
INSERT INTO `sys_user`
VALUES ('ee52c0f89e7547ddafdf80af5d0eeb76', '2020-08-20 14:22:05', 'register', 'register', 'register',
        '2020-08-20 14:22:05', 'register', 'xvmpmvcv', '17596562668', '17596562668',
        'd51543290e331f325af735297b86b306a99bec25', '1', '2', '会员', 'fd64688534a144e48c84a281ec17c98b',
        '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.00', '0.00', '0.0000', '0', '', '467530', '', null, null);
INSERT INTO `sys_user`
VALUES ('fd64688534a144e48c84a281ec17c98b', '2020-08-17 11:37:38', 'register', 'register', '999', '2020-08-17 12:38:23',
        '超级管理员', '信用卡积分变现、 pos机免费', '15324801333', '15324801333', '6313aacee58a1fd3283ca1be360e6dbd5e1624d7', '1', '2',
        '会员', '04a3b853256f46a8bf43b534488d3169', '380d1b09a4cc41da8908721c4c715286', '1', '0', '0.06', '10.00',
        '100000.0000', '0', 'o-OciwVno8RR08rsZHtOmmCiNPTI', '732406', 'head/bcf4ff712dde434fbc64a93d2ccbeb54.jpg', null,
        null);

-- ----------------------------
-- Table structure for system_set
-- ----------------------------
DROP TABLE IF EXISTS `system_set`;
CREATE TABLE `system_set`
(
    `ID`                                      varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '主键',
    `CREATED_TIME`                            datetime                                NOT NULL COMMENT '创建时间',
    `CREATOR`                                 varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
    `CREATOR_ID`                              varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '创建人ID',
    `LAST_UPDATE_ID`                          varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '修改人ID',
    `LAST_UPDATE_TIME`                        datetime                                NOT NULL COMMENT '最后修改时间',
    `LAST_UPDATER`                            varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
    `MEMBER_UPGRADE_GOLD_PRICE`               decimal(20, 2)                          NOT NULL DEFAULT '88.00' COMMENT '黄金会员价格',
    `MEMBER_UPGRADE_DIAMOND_PRICE`            decimal(20, 2)                          NOT NULL DEFAULT '188.00' COMMENT '钻石会员价格',
    `MEMBER_NORMAL_MONEY_UPGRADE_DIRECT`      decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '普通会员金钱升级直推',
    `MEMBER_NORMAL_MONEY_UPGRADE_INDIRECT`    decimal(20, 2)                          NOT NULL DEFAULT '0.00' COMMENT '普通会员金钱升级间推',
    `MEMBER_NORMAL_EXCHANGE_POINT_DIRECT`     decimal(20, 2)                          NOT NULL DEFAULT '2.00' COMMENT '普通会员积分消费直推',
    `MEMBER_NORMAL_EXCHANGE_POINT_INDIRECT`   decimal(20, 2)                          NOT NULL DEFAULT '1.00' COMMENT '普通会员积分消费间推',
    `MEMBER_GOLD_MONEY_UPGRADE_DIRECT`        decimal(20, 2)                          NOT NULL DEFAULT '50.00' COMMENT '黄金会员金钱升级直推',
    `MEMBER_GOLD_MONEY_UPGRADE_INDIRECT`      decimal(20, 2)                          NOT NULL DEFAULT '20.00' COMMENT '黄金会员金钱升级间推',
    `MEMBER_GOLD_EXCHANGE_POINT_DIRECT`       decimal(20, 2)                          NOT NULL DEFAULT '2.00' COMMENT '黄金会员积分消费直推',
    `MEMBER_GOLD_EXCHANGE_POINT_INDIRECT`     decimal(20, 2)                          NOT NULL DEFAULT '1.00' COMMENT '黄金会员积分消费间推',
    `MEMBER_DIAMOND_MONEY_UPGRADE_DIRECT`     decimal(20, 2)                          NOT NULL DEFAULT '50.00' COMMENT '钻石会员金钱升级直推',
    `MEMBER_DIAMOND_MONEY_UPGRADE_INDIRECT`   decimal(20, 2)                          NOT NULL DEFAULT '20.00' COMMENT '钻石会员金钱升级间推',
    `MEMBER_DIAMOND_EXCHANGE_POINT_DIRECT`    decimal(20, 2)                          NOT NULL DEFAULT '2.00' COMMENT '钻石会员积分消费直推',
    `MEMBER_DIAMOND_EXCHANGE_POINT_INDIRECT`  decimal(20, 2)                          NOT NULL DEFAULT '1.00' COMMENT '钻石会员积分消费间推',
    `MEMBER_NORMAL_EXCHANGE_UNIT_PRICE`       decimal(20, 2)                          NOT NULL DEFAULT '10.00' COMMENT '普通会员兑换价格 元/万积分',
    `MEMBER_GOLD_EXCHANGE_UNIT_PRICE`         decimal(20, 2)                          NOT NULL DEFAULT '12.00' COMMENT '黄金会员兑换价格 元/万积分',
    `MEMBER_DIAMOND_EXCHANGE_UNIT_PRICE`      decimal(20, 2)                          NOT NULL DEFAULT '14.00' COMMENT '钻石会员兑换价格 元/万积分',
    `COMPANY_NORMAL_UPGRADE_PRICE`            decimal(20, 2)                          NOT NULL DEFAULT '598.00' COMMENT '初级盟主价格',
    `COMPANY_ADVANCED_UPGRADE_PRICE`          decimal(20, 2)                          NOT NULL DEFAULT '2588.00' COMMENT '高级盟主价格',
    `COMPANY_SUPER_UPGRADE_PRICE`             decimal(20, 2)                          NOT NULL DEFAULT '5288.00' COMMENT '特级盟主价格',
    `COMPANY_NORMAL_MONEY_UPGRADE_DIRECT`     decimal(20, 2)                          NOT NULL DEFAULT '50.00' COMMENT '初级盟主会员金钱升级直推收益',
    `COMPANY_ADVANCED_MONEY_UPGRADE_DIRECT`   decimal(20, 2)                          NOT NULL DEFAULT '60.00' COMMENT '高级盟主会员金钱升级直推收益',
    `COMPANY_SUPER_MONEY_UPGRADE_DIRECT`      decimal(20, 2)                          NOT NULL DEFAULT '70.00' COMMENT '特级盟主会员金钱升级直推收益',
    `COMPANY_NORMAL_MONEY_UPGRADE_INDIRECT`   decimal(20, 2)                          NOT NULL DEFAULT '5.00' COMMENT '初级盟主会员金钱升级间推收益',
    `COMPANY_ADVANCED_MONEY_UPGRADE_INDIRECT` decimal(20, 2)                          NOT NULL DEFAULT '5.00' COMMENT '高级盟主会员金钱升级间推收益',
    `COMPANY_SUPER_MONEY_UPGRADE_INDIRECT`    decimal(20, 2)                          NOT NULL DEFAULT '5.00' COMMENT '特级盟主会员金钱升级间推收益',
    `COMPANY_NORMAL_PROFIT_RATE`              decimal(20, 2)                          NOT NULL DEFAULT '50.00' COMMENT '初级盟主收益比',
    `COMPANY_ADVANCED_PROFIT_RATE`            decimal(20, 2)                          NOT NULL DEFAULT '70.00' COMMENT '高级盟主收益比',
    `COMPANY_SUPER_PROFIT_RATE`               decimal(20, 2)                          NOT NULL DEFAULT '90.00' COMMENT '特级盟主收益比',
    `COMPANY_NORMAL_PEER_EXCHANGE`            decimal(20, 2)                          NOT NULL DEFAULT '25.00' COMMENT '初级盟主同级兑换奖',
    `COMPANY_ADVANCED_PEER_EXCHANGE`          decimal(20, 2)                          NOT NULL DEFAULT '15.00' COMMENT '高级盟主同级兑换奖',
    `COMPANY_SUPER_PEER_EXCHANGE`             decimal(20, 2)                          NOT NULL DEFAULT '5.00' COMMENT '特级盟主同级兑换奖',
    `COMPANY_NORMAL_TEAM_PROFIT`              decimal(20, 2)                          NOT NULL DEFAULT '1.00' COMMENT '初级盟主团队奖',
    `COMPANY_ADVANCED_TEAM_PROFIT`            decimal(20, 2)                          NOT NULL DEFAULT '1.50' COMMENT '高级盟主团队奖',
    `COMPANY_SUPER_TEAM_PROFIT`               decimal(20, 2)                          NOT NULL DEFAULT '2.00' COMMENT '特级盟主团队奖',
    `COMPANY_NORMAL_HIGHEST_PRICE`            decimal(20, 2)                          NOT NULL DEFAULT '15.00' COMMENT '初级盟主最高价',
    `COMPANY_ADVANCED_HIGHEST_PRICE`          decimal(20, 2)                          NOT NULL DEFAULT '15.50' COMMENT '高级盟主最高价',
    `COMPANY_SUPER_HIGHEST_PRICE`             decimal(20, 2)                          NOT NULL DEFAULT '15.90' COMMENT '特级盟主最高价',
    `RECOMMEND_NORMAL_COMPANY_REWARD`         decimal(20, 2)                          NOT NULL DEFAULT '98.00' COMMENT '推荐初级盟主奖励',
    `RECOMMEND_ADVANCED_COMPANY_REWARD`       decimal(20, 2)                          NOT NULL DEFAULT '988.00' COMMENT '推荐高级盟主奖励',
    `RECOMMEND_SUPER_COMPANY_REWARD`          decimal(20, 2)                          NOT NULL DEFAULT '2588.00' COMMENT '推荐特级盟主奖励',
    `NORMAL_COMPANY_TWICE_UPGRADE_REWARD`     decimal(20, 2)                          NOT NULL DEFAULT '70.00' COMMENT '初级盟主二次升级奖励',
    `ADVANCED_COMPANY_TWICE_UPGRADE_REWARD`   decimal(20, 2)                          NOT NULL DEFAULT '90.00' COMMENT '高级盟主二次升级奖励',
    `COMPANY_ID`                              varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '盟主ID',
    `PLATFORM_ID`                             varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '平台ID',
    `DELETED`                                 int(1)                                           DEFAULT '0' COMMENT '逻辑删除 0未删除 1 已删除',
    `SPARE1`                                  varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '签到奖励金最小值',
    `SPARE2`                                  varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '签到奖励金最大值',
    `SPARE3`                                  varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE4`                                  varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    `SPARE5`                                  varchar(200) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备用字段1',
    PRIMARY KEY (`ID`, `COMPANY_ID`) USING BTREE,
    UNIQUE KEY `ID` (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='系统价格设置表';

-- ----------------------------
-- Records of system_set
-- ----------------------------
INSERT INTO `system_set`
VALUES ('1', '2020-07-30 11:49:41', '1', '1', '999', '2020-08-13 14:44:56', '超级管理员', '88.00', '188.00', '0.00', '0.00',
        '2.00', '1.00', '50.00', '20.00', '2.00', '1.00', '50.00', '20.00', '2.00', '1.00', '10.00', '12.00', '14.00',
        '598.00', '2588.00', '5288.00', '50.00', '60.00', '70.00', '5.00', '5.00', '5.00', '50.00', '70.00', '90.00',
        '25.00', '15.00', '5.00', '1.00', '1.50', '2.00', '15.00', '15.50', '15.90', '98.00', '988.00', '2588.00',
        '70.00', '90.00', '999', '999', '0', '0.01', '0.03', null, null, null);
