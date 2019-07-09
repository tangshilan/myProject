DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `pname` varchar(128) NOT NULL COMMENT '资源名称',
  `ptype` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `purl` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `psortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `pavailable` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('权限', 'permission', '', 'order:edit', '0', '0/', '0', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('订单管理', 'menu', '', null, '1', '0/1/', '1.', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('订单新增', 'permission', 'order/add_judge', 'order:add', '11', '0/1/11/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('订单修改', 'permission', 'order/edit_judge', 'order:edit', '11', '0/1/11/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('订单删除', 'permission', 'order/delete_judge', 'order:delete', '11', '0/1/11/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('客户管理', 'menu', '', '', '1', '0/1/', '2.', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('客户新增', 'permission', '', 'custom:add', '21', '0/1/21/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('客户修改', 'permission', '', 'custom:edit', '21', '0/1/21/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('客户删除', 'permission', '', 'custom:delete', '21', '0/1/21/', '', '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('产品管理', 'menu', null, null, null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('产品新增', 'permission', null, 'product:add', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('产品修改', 'permission', null, 'product:edit', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('产品删除', 'permission', null, 'product:delete', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('部门管理', 'menu', null, null, null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('部门新增', 'permission', null, 'department:add', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('部门修改', 'permission', null, 'department:edit', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('部门删除', 'permission', null, 'department:delete', null, null, null, '1');
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('员工管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('员工新增', 'permission', null, 'employee:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('员工修改', 'permission', null, 'employee:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('员工删除', 'permission', null, 'employee:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('作业管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('作业新增', 'permission', null, 'work:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('作业修改', 'permission', null, 'work:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('作业删除', 'permission', null, 'work:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产计划管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产计划新增', 'permission', null, 'manufacture:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产计划修改', 'permission', null, 'manufacture:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产计划删除', 'permission', null, 'manufacture:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产派工管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产派工新增', 'permission', null, 'task:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产派工修改', 'permission', null, 'task:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('生产派工删除', 'permission', null, 'task:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('工艺管理', 'menu', null, '', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('工艺新增', 'permission', null, 'technology:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('工艺修改', 'permission', null, 'technology:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES('工艺删除', 'permission', null, 'technology:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序新增', 'permission', null, 'process:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序修改', 'permission', null, 'process:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序删除', 'permission', null, 'process:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺计划管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺计划新增', 'permission', null, 'technologyPlan:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺计划修改', 'permission', null, 'technologyPlan:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺计划删除', 'permission', null, 'technologyPlan:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺要求管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺要求新增', 'permission', null, 'technologyRequirement:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺要求修改', 'permission', null, 'technologyRequirement:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工艺要求删除', 'permission', null, 'technologyRequirement:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计数质检', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计数质检新增', 'permission', null, 'fCountCheck:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计数质检修改', 'permission', null, 'fCountCheck:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计数质检删除', 'permission', null, 'fCountCheck:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计量质检', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计量质检新增', 'permission', null, 'fMeasureCheck:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计量质检修改', 'permission', null, 'fMeasureCheck:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '成品计量质检删除', 'permission', null, 'fMeasureCheck:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计数质检', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计数质检新增', 'permission', null, 'pCountCheck:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计数质检修改', 'permission', null, 'pCountCheck:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计数质检删除', 'permission', null, 'pCountCheck:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计量质检', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计量质检新增', 'permission', null, 'pMeasureCheck:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计量质检修改', 'permission', null, 'pMeasureCheck:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '工序计量质检删除', 'permission', null, 'pMeasureCheck:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '不合格品申请', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '不合格品申请新增', 'permission', null, 'unqualify:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '不合格品申请修改', 'permission', null, 'unqualify:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '不合格品申请删除', 'permission', null, 'unqualify:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料新增', 'permission', null, 'material:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料修改', 'permission', null, 'material:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料删除', 'permission', null, 'material:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料收入', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料收入新增', 'permission', null, 'materialReceive:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料收入修改', 'permission', null, 'materialReceive:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料收入删除', 'permission', null, 'materialReceive:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '用户管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '用户新增', 'permission', null, 'user:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '用户修改', 'permission', null, 'user:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '用户删除', 'permission', null, 'user:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '角色管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '角色新增', 'permission', null, 'role:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '角色修改', 'permission', null, 'role:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '角色删除', 'permission', null, 'role:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料消耗', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料消耗新增', 'permission', null, 'materialConsume:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料消耗修改', 'permission', null, 'materialConsume:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '物料消耗删除', 'permission', null, 'materialConsume:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备新增', 'permission', null, 'deviceList:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备修改', 'permission', null, 'deviceList:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备删除', 'permission', null, 'deviceList:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备例检管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备例检新增', 'permission', null, 'deviceCheck:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备例检修改', 'permission', null, 'deviceCheck:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备例检删除', 'permission', null, 'deviceCheck:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备故障管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备故障新增', 'permission', null, 'deviceFault:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备故障修改', 'permission', null, 'deviceFault:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备故障删除', 'permission', null, 'deviceFault:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备维修管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备维修新增', 'permission', null, 'deviceMaintain:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备维修修改', 'permission', null, 'deviceMaintain:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备维修删除', 'permission', null, 'deviceMaintain:delete', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备种类管理', 'menu', null, null, null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备种类新增', 'permission', null, 'deviceType:add', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备种类修改', 'permission', null, 'deviceType:edit', null, null, null, null);
INSERT INTO `permission`(pname,ptype,purl,percode,parentid,parentids,psortstring,pavailable) VALUES( '设备种类删除', 'permission', null, 'deviceType:delete', null, null, null, null);


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(36) NOT NULL auto_increment,
  `rname` varchar(128) NOT NULL,
  `ravailable` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `role` (rname,ravailable) VALUES ('超级管理员', '1');
INSERT INTO `role`(rname,ravailable)  VALUES ('订单管理员', '1');
INSERT INTO `role` (rname,ravailable) VALUES ('物料管理员', '1');
INSERT INTO `role` (rname,ravailable) VALUES ('普通用户', '1');
INSERT INTO `role` (rname,ravailable) VALUES ('设备管理员', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rp_id` int(50) NOT NULL auto_increment,
  `rp_role_id` varchar(50) NOT NULL COMMENT '角色id',
  `rp_permission_id` varchar(300) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- `role_permission`(rp_role_id,rp_permission_id) VALUES
-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('002', '11,12,13,201,202,203,');
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('15615615151', '11,12,13,231,232,233,271,273,');
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('005', '11,33,81,83,91,93,101,102,103,121,192,131,133,151,153,173,273,252,51,53,');
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('004', '181,182,183,191,192,193,221,222,223,');
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('007', null);
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('31931', null);
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('424', null);
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('3213', null);
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('3214321', null);
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('213213213', '11,12,13,');
INSERT INTO `role_permission`(rp_role_id,rp_permission_id) VALUES ('001', '11,12,13,21,22,23,31,32,33,61,62,63,71,72,73,81,82,83,91,92,93,101,102,103,111,112,113,121,122,123,181,182,183,191,192,193,221,222,223,131,132,133,141,142,143,151,152,153,161,162,163,171,172,173,231,232,233,271,272,273,241,242,243,251,252,253,261,262,263,41,42,43,51,52,53,201,202,203,211,212,213,');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(36) NOT NULL auto_increment COMMENT '主键',
  `username` varchar(64) DEFAULT NULL COMMENT '姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- `user`(username,password,locked) VALUES
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`(username,password,locked) VALUES ('王经理', '11', '1');
INSERT INTO `user`(username,password,locked) VALUES ('22', '22', '1');
INSERT INTO `user`(username,password,locked) VALUES ('张三', 'aaa', '1');
INSERT INTO `user`(username,password,locked) VALUES ( 'aa', 'aa', '1');
INSERT INTO `user`(username,password,locked) VALUES ('11', '11', '1');
INSERT INTO `user`(username,password,locked) VALUES ('王二', '12345', '2');
INSERT INTO `user`(username,password,locked) VALUES ('李大山', '11', '1');
INSERT INTO `user`(username,password,locked) VALUES ('ga', '22', '1');
INSERT INTO `user`(username,password,locked) VALUES ('55', '55', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ur_id` int(36) NOT NULL auto_increment,
  `ur_user_id` varchar(32) NOT NULL,
  `ur_role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- `user_role`(ur_user_id,ur_role_id) VALUES
-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('001', '001');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('003', '002');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('004', '005');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('002', '001');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('005', '002');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('321321', '004');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('3213', '005');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('006', '002');
INSERT INTO `user_role`(ur_user_id,ur_role_id) VALUES ('007', '004');

