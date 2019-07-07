-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` varchar(36) NOT NULL,
  `rname` varchar(128) NOT NULL,
  `ravailable` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('001', '超级管理员', '1');
INSERT INTO `role` VALUES ('002', '订单管理员', '1');
INSERT INTO `role` VALUES ('004', '物料管理员', '1');
INSERT INTO `role` VALUES ('005', '普通用户', '1');
INSERT INTO `role` VALUES ('007', '设备管理员', '1');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rp_id` varchar(50) NOT NULL,
  `rp_role_id` varchar(50) NOT NULL COMMENT '角色id',
  `rp_permission_id` varchar(300) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1456115611515', '002', '11,12,13,201,202,203,');
INSERT INTO `role_permission` VALUES ('147729449886163', '15615615151', '11,12,13,231,232,233,271,273,');
INSERT INTO `role_permission` VALUES ('147737863632731', '005', '11,33,81,83,91,93,101,102,103,121,192,131,133,151,153,173,273,252,51,53,');
INSERT INTO `role_permission` VALUES ('148007157091762', '004', '181,182,183,191,192,193,221,222,223,');
INSERT INTO `role_permission` VALUES ('148255367614063', '007', null);
INSERT INTO `role_permission` VALUES ('149122370655248', '31931', null);
INSERT INTO `role_permission` VALUES ('149122382565714', '424', null);
INSERT INTO `role_permission` VALUES ('149122469890916', '3213', null);
INSERT INTO `role_permission` VALUES ('149122510431476', '3214321', null);
INSERT INTO `role_permission` VALUES ('149122513769244', '213213213', '11,12,13,');
INSERT INTO `role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f21', '001', '11,12,13,21,22,23,31,32,33,61,62,63,71,72,73,81,82,83,91,92,93,101,102,103,111,112,113,121,122,123,181,182,183,191,192,193,221,222,223,131,132,133,141,142,143,151,152,153,161,162,163,171,172,173,231,232,233,271,272,273,241,242,243,251,252,253,261,262,263,41,42,43,51,52,53,201,202,203,211,212,213,');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '王经理', '11', '1');
INSERT INTO `user` VALUES ('002', '22', '22', '1');
INSERT INTO `user` VALUES ('003', '张三', 'aaa', '1');
INSERT INTO `user` VALUES ('004', 'aa', 'aa', '1');
INSERT INTO `user` VALUES ('005', '11', '11', '1');
INSERT INTO `user` VALUES ('006', '王二', '12345', '2');
INSERT INTO `user` VALUES ('007', '李大山', '11', '1');
INSERT INTO `user` VALUES ('3213', 'ga', '22', '1');
INSERT INTO `user` VALUES ('321321', '55', '55', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ur_id` varchar(36) NOT NULL,
  `ur_user_id` varchar(32) NOT NULL,
  `ur_role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('001', '001', '001');
INSERT INTO `user_role` VALUES ('147705484492576', '003', '002');
INSERT INTO `user_role` VALUES ('148228593447685', '004', '005');
INSERT INTO `user_role` VALUES ('148232608456017', '002', '001');
INSERT INTO `user_role` VALUES ('148232650257115', '005', '002');
INSERT INTO `user_role` VALUES ('148237251058254', '321321', '004');
INSERT INTO `user_role` VALUES ('148237503507696', '3213', '005');
INSERT INTO `user_role` VALUES ('148249856407793', '006', '002');
INSERT INTO `user_role` VALUES ('148255363744945', '007', '004');