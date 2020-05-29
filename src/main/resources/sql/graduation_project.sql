/*
 Navicat Premium Data Transfer

 Source Server         : MyDB
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : graduation_project

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 29/05/2020 18:20:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/home', 'WarehouseManagement', 'Home', 'iconfont icon-kufang', '库房管理', 0, '::');
INSERT INTO `menu` VALUES (2, '/home', 'ToolManagement', 'Home', 'iconfont icon-gongju', '工具管理', 0, '::');
INSERT INTO `menu` VALUES (3, '/home', 'WorkOrderManagement', 'Home', 'iconfont icon-order', '工单管理', 0, '::');
INSERT INTO `menu` VALUES (4, '/home', 'VehicleManagement', 'Home', 'iconfont icon-cheliang', '车辆管理', 0, '::');
INSERT INTO `menu` VALUES (5, '/home', 'NodeManagement', 'Home', 'iconfont icon-jiedian', '节点管理', 0, '::');
INSERT INTO `menu` VALUES (6, '/home', 'SystemManagement', 'Home', 'iconfont icon-xitong', '系统管理', 0, '::');
INSERT INTO `menu` VALUES (7, '/warehouse/info', 'WarehouseInfo', 'WarehouseManagement/WarehouseInfo', 'iconfont icon-ico_kufangguanli_wupinpandian', '库房信息', 1, 'warehouse::info');
INSERT INTO `menu` VALUES (8, '/tool/type', 'ToolType', 'ToolManagement/ToolType', 'iconfont icon-tool', '工具类型', 2, 'tool::type');
INSERT INTO `menu` VALUES (9, '/tool/ledger', 'ToolLedger', 'ToolManagement/ToolLedger', 'iconfont icon-taizhangguanli', '工具台账', 2, 'tool::ledger');
INSERT INTO `menu` VALUES (10, '/tool/storage', 'ToolStorage', 'ToolManagement/ToolStorage', 'iconfont icon-ruku', '工具入库', 2, 'tool::storage');
INSERT INTO `menu` VALUES (11, '/tool/borrowing', 'BorrowingTools', 'ToolManagement/BorrowingTools', 'iconfont icon-ziyuanjieyong', '工具借还', 2, 'tool::borrowing');
INSERT INTO `menu` VALUES (12, '/worksheet/info', 'WorksheetInformation', 'WorkOrderManagement/WorksheetInformation', 'iconfont icon-ico_kufangguanli_wupinpandian', '工单信息', 3, 'worksheet::info');
INSERT INTO `menu` VALUES (13, '/worksheet/type', 'OperationType', 'WorkOrderManagement/OperationType', 'iconfont icon-leixing', '作业类型', 3, 'worksheet::type');
INSERT INTO `menu` VALUES (14, '/worksheet/log', 'WorksheetLog', 'WorkOrderManagement/WorksheetLog', 'iconfont icon-rizhi', '工单日志', 3, 'worksheet::log');
INSERT INTO `menu` VALUES (15, '/vehicle/info', 'VehicleInformation', 'VehicleManagement/VehicleInformation', 'iconfont icon-ico_kufangguanli_wupinpandian', '车辆信息', 4, 'vehicle::info');
INSERT INTO `menu` VALUES (16, '/vehicle/borrowing', 'BorrowingVehicles', 'VehicleManagement/BorrowingVehicles', 'iconfont icon-ziyuanjieyong', '车辆借还', 4, 'vehicle::borrowing');
INSERT INTO `menu` VALUES (17, '/node/info', 'NodeInformation', 'NodeManagement/NodeInformation', 'iconfont icon-icon-test', '节点信息', 5, 'node::info');
INSERT INTO `menu` VALUES (18, '/node/dis', 'NodeDisplay', 'NodeManagement/NodeDisplay', 'iconfont icon-zhanshi', '节点展示', 5, 'node::dis');
INSERT INTO `menu` VALUES (19, '/sys/user', 'UserManagement', 'SystemManagement/UserManagement', 'iconfont icon-yonghuguanli', '用户管理', 6, 'sys::user');
INSERT INTO `menu` VALUES (20, '/sys/role', 'RoleManagement', 'SystemManagement/RoleManagement', 'iconfont icon-navicon-jsgl', '角色管理', 6, 'sys::role');
INSERT INTO `menu` VALUES (21, '/sys/file', 'FileManagement', 'SystemManagement/FileManagement', 'iconfont icon-ziyuan', '文件管理', 6, 'sys::file');
INSERT INTO `menu` VALUES (22, '/sys/log', 'LogInformation', 'SystemManagement/LogInformation', 'iconfont icon-rizhi', '日志管理', 6, 'sys::log');

-- ----------------------------
-- Table structure for node_info
-- ----------------------------
DROP TABLE IF EXISTS `node_info`;
CREATE TABLE `node_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `principal` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node_info
-- ----------------------------
INSERT INTO `node_info` VALUES (1, 'node1', '一号节点', 1, 'xx省xx市', NULL, '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `node_info` VALUES (2, 'node2', '二号节点', 2, 'xxx省xxx市', NULL, '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `node_info` VALUES (3, 'node3', '三号节点', 3, 'xxxx省xxxx市', NULL, '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `node_info` VALUES (4, 'node4', '四号节点', 4, 'xxxxx省xxxxx市', NULL, '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `node_info` VALUES (5, 'node5', '五号节点', 1, 'xxxxxx省xxxxxx市', NULL, '1990-01-01 14:42:27', '1990-01-01 14:42:27');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'SystemManager', '系统管理员', '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `role` VALUES (2, 'WarehouseManager', '库房管理员', '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `role` VALUES (3, 'Driver', '驾驶员', '1990-01-01 14:42:27', '1990-01-01 14:42:27');
INSERT INTO `role` VALUES (4, 'Leader', '分公司领导', '1990-01-01 14:42:27', '1990-01-01 14:42:27');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 1, 2);
INSERT INTO `role_menu` VALUES (3, 1, 3);
INSERT INTO `role_menu` VALUES (4, 1, 4);
INSERT INTO `role_menu` VALUES (5, 1, 5);
INSERT INTO `role_menu` VALUES (6, 1, 6);
INSERT INTO `role_menu` VALUES (7, 1, 7);
INSERT INTO `role_menu` VALUES (8, 1, 8);
INSERT INTO `role_menu` VALUES (9, 1, 9);
INSERT INTO `role_menu` VALUES (10, 1, 10);
INSERT INTO `role_menu` VALUES (11, 1, 11);
INSERT INTO `role_menu` VALUES (12, 1, 12);
INSERT INTO `role_menu` VALUES (13, 1, 13);
INSERT INTO `role_menu` VALUES (14, 1, 14);
INSERT INTO `role_menu` VALUES (15, 1, 15);
INSERT INTO `role_menu` VALUES (16, 1, 16);
INSERT INTO `role_menu` VALUES (17, 1, 17);
INSERT INTO `role_menu` VALUES (18, 1, 18);
INSERT INTO `role_menu` VALUES (19, 1, 19);
INSERT INTO `role_menu` VALUES (20, 1, 20);
INSERT INTO `role_menu` VALUES (21, 1, 21);
INSERT INTO `role_menu` VALUES (22, 1, 22);
INSERT INTO `role_menu` VALUES (23, 2, 9);
INSERT INTO `role_menu` VALUES (24, 2, 10);
INSERT INTO `role_menu` VALUES (25, 2, 11);
INSERT INTO `role_menu` VALUES (26, 2, 15);
INSERT INTO `role_menu` VALUES (27, 2, 16);
INSERT INTO `role_menu` VALUES (28, 2, 2);
INSERT INTO `role_menu` VALUES (29, 2, 4);
INSERT INTO `role_menu` VALUES (30, 3, 1);
INSERT INTO `role_menu` VALUES (31, 3, 2);
INSERT INTO `role_menu` VALUES (32, 3, 3);
INSERT INTO `role_menu` VALUES (33, 3, 4);
INSERT INTO `role_menu` VALUES (34, 3, 5);
INSERT INTO `role_menu` VALUES (35, 3, 7);
INSERT INTO `role_menu` VALUES (36, 3, 8);
INSERT INTO `role_menu` VALUES (37, 3, 9);
INSERT INTO `role_menu` VALUES (38, 3, 10);
INSERT INTO `role_menu` VALUES (39, 3, 11);
INSERT INTO `role_menu` VALUES (40, 3, 12);
INSERT INTO `role_menu` VALUES (41, 3, 13);
INSERT INTO `role_menu` VALUES (42, 3, 14);
INSERT INTO `role_menu` VALUES (43, 3, 15);
INSERT INTO `role_menu` VALUES (44, 3, 16);
INSERT INTO `role_menu` VALUES (45, 3, 17);
INSERT INTO `role_menu` VALUES (46, 4, 1);
INSERT INTO `role_menu` VALUES (47, 4, 2);
INSERT INTO `role_menu` VALUES (48, 4, 3);
INSERT INTO `role_menu` VALUES (49, 4, 4);
INSERT INTO `role_menu` VALUES (50, 4, 5);
INSERT INTO `role_menu` VALUES (51, 4, 6);
INSERT INTO `role_menu` VALUES (52, 4, 7);
INSERT INTO `role_menu` VALUES (53, 4, 8);
INSERT INTO `role_menu` VALUES (54, 4, 9);
INSERT INTO `role_menu` VALUES (55, 4, 10);
INSERT INTO `role_menu` VALUES (56, 4, 11);
INSERT INTO `role_menu` VALUES (57, 4, 12);
INSERT INTO `role_menu` VALUES (58, 4, 13);
INSERT INTO `role_menu` VALUES (59, 4, 14);
INSERT INTO `role_menu` VALUES (60, 4, 15);
INSERT INTO `role_menu` VALUES (61, 4, 16);
INSERT INTO `role_menu` VALUES (62, 4, 17);
INSERT INTO `role_menu` VALUES (63, 4, 19);
INSERT INTO `role_menu` VALUES (64, 4, 20);
INSERT INTO `role_menu` VALUES (65, 4, 21);
INSERT INTO `role_menu` VALUES (66, 4, 22);

-- ----------------------------
-- Table structure for tool_info
-- ----------------------------
DROP TABLE IF EXISTS `tool_info`;
CREATE TABLE `tool_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tool_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tool_type` int(255) NULL DEFAULT NULL,
  `tool_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `use_time` int(11) NULL DEFAULT NULL,
  `tool_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tool_info
-- ----------------------------
INSERT INTO `tool_info` VALUES (1, 'tool-1', '一号工具', 1, '1-1-1-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (2, 'tool-2', '二号工具', 1, '1-1-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (3, 'tool-3', '三号工具', 1, '1-6-3-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (4, 'tool-4', '四号工具', 1, '2-1-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (5, 'tool-5', '五号工具', 1, '1-1-3-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (6, 'tool-6', '六号工具', 2, '1-1-4-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (7, 'tool-7', '七号工具', 2, '1-1-5-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (8, 'tool-8', '八号工具', 2, '1-1-6-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (9, 'tool-9', '九号工具', 2, '1-2-1-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (10, 'tool-10', '十号工具', 3, '1-2-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (11, 'tool-11', '十一号工具', 4, '1-2-3-1', NULL, 'x5个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (12, 'tool-12', '十二号工具', 2, '1-2-4-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (13, 'tool-13', '十三号工具', 3, '1-2-5-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (14, 'tool-14', '十四号工具', 4, '1-3-1-1', NULL, 'x10副', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (15, 'tool-15', '十五号工具', 2, '1-3-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (16, 'tool-16', '十六号工具', 3, '1-3-3-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (17, 'tool-17', '十七号工具', 1, '1-3-4-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (18, 'tool-18', '十八号工具', 1, '1-3-5-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (19, 'tool-19', '十九号工具', 3, '1-4-1-1', NULL, 'x2套', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (20, 'tool-20', '二十号工具', 3, '1-4-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (21, 'tool-21', '二十一号工具', 3, '1-4-3-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (22, 'tool-22', '二十二号工具', 1, '1-4-4-1', NULL, 'x2套', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 2, '1');
INSERT INTO `tool_info` VALUES (23, 'tool-23', '二十三号工具', 2, '1-4-5-1', NULL, 'x2套', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '1');
INSERT INTO `tool_info` VALUES (24, 'tool-24', '二十四号工具', 2, '1-5-1-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '1');
INSERT INTO `tool_info` VALUES (25, 'tool-25', '二十五号工具', 2, '1-5-2-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '1');
INSERT INTO `tool_info` VALUES (26, 'tool-26', '二十六号工具', 2, '1-5-3-1', NULL, 'x2套', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '0');
INSERT INTO `tool_info` VALUES (27, 'tool-27', '二十七号工具', 1, '1-5-4-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '0');
INSERT INTO `tool_info` VALUES (28, 'tool-28', '二十八号工具', 1, '1-5-5-1', NULL, 'x1个', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '0');
INSERT INTO `tool_info` VALUES (29, 'tool-29', '二十九号工具', 4, '1-6-1-1', NULL, 'x10副', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '0');
INSERT INTO `tool_info` VALUES (30, 'tool-30', '三十号工具', 4, '1-6-2-1', NULL, 'x10副', '2020-04-16 15:21:38', '2020-04-16 15:21:38', 1, '0');

-- ----------------------------
-- Table structure for tool_stream
-- ----------------------------
DROP TABLE IF EXISTS `tool_stream`;
CREATE TABLE `tool_stream`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_id` int(11) NOT NULL,
  `worksheet_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tool_stream
-- ----------------------------
INSERT INTO `tool_stream` VALUES (1, 1, 1);
INSERT INTO `tool_stream` VALUES (2, 2, 1);
INSERT INTO `tool_stream` VALUES (3, 3, 1);
INSERT INTO `tool_stream` VALUES (4, 4, 1);
INSERT INTO `tool_stream` VALUES (5, 5, 1);
INSERT INTO `tool_stream` VALUES (6, 6, 2);
INSERT INTO `tool_stream` VALUES (7, 7, 2);
INSERT INTO `tool_stream` VALUES (8, 8, 2);
INSERT INTO `tool_stream` VALUES (9, 9, 2);
INSERT INTO `tool_stream` VALUES (10, 10, 2);
INSERT INTO `tool_stream` VALUES (11, 11, 3);
INSERT INTO `tool_stream` VALUES (12, 12, 3);
INSERT INTO `tool_stream` VALUES (13, 13, 3);
INSERT INTO `tool_stream` VALUES (14, 14, 3);
INSERT INTO `tool_stream` VALUES (15, 15, 3);
INSERT INTO `tool_stream` VALUES (16, 16, 3);
INSERT INTO `tool_stream` VALUES (17, 17, 4);
INSERT INTO `tool_stream` VALUES (18, 18, 4);
INSERT INTO `tool_stream` VALUES (19, 19, 4);
INSERT INTO `tool_stream` VALUES (20, 20, 4);
INSERT INTO `tool_stream` VALUES (21, 21, 4);
INSERT INTO `tool_stream` VALUES (22, 22, 4);
INSERT INTO `tool_stream` VALUES (23, 1, 5);
INSERT INTO `tool_stream` VALUES (24, 2, 5);
INSERT INTO `tool_stream` VALUES (25, 3, 5);
INSERT INTO `tool_stream` VALUES (26, 4, 5);
INSERT INTO `tool_stream` VALUES (27, 5, 5);
INSERT INTO `tool_stream` VALUES (28, 6, 5);
INSERT INTO `tool_stream` VALUES (29, 7, 6);
INSERT INTO `tool_stream` VALUES (30, 8, 6);
INSERT INTO `tool_stream` VALUES (31, 9, 6);
INSERT INTO `tool_stream` VALUES (32, 10, 6);
INSERT INTO `tool_stream` VALUES (33, 11, 6);
INSERT INTO `tool_stream` VALUES (34, 12, 6);
INSERT INTO `tool_stream` VALUES (35, 13, 7);
INSERT INTO `tool_stream` VALUES (36, 14, 7);
INSERT INTO `tool_stream` VALUES (37, 15, 7);
INSERT INTO `tool_stream` VALUES (38, 16, 7);
INSERT INTO `tool_stream` VALUES (39, 17, 7);
INSERT INTO `tool_stream` VALUES (40, 18, 7);
INSERT INTO `tool_stream` VALUES (41, 19, 7);
INSERT INTO `tool_stream` VALUES (42, 20, 8);
INSERT INTO `tool_stream` VALUES (43, 21, 8);
INSERT INTO `tool_stream` VALUES (44, 22, 8);
INSERT INTO `tool_stream` VALUES (45, 23, 8);
INSERT INTO `tool_stream` VALUES (46, 24, 8);
INSERT INTO `tool_stream` VALUES (47, 25, 8);

-- ----------------------------
-- Table structure for tool_type
-- ----------------------------
DROP TABLE IF EXISTS `tool_type`;
CREATE TABLE `tool_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tool_type
-- ----------------------------
INSERT INTO `tool_type` VALUES (1, '工具类型一');
INSERT INTO `tool_type` VALUES (2, '工具类型二');
INSERT INTO `tool_type` VALUES (3, '工具类型三');
INSERT INTO `tool_type` VALUES (4, '工具类型四');

-- ----------------------------
-- Table structure for treasury_information
-- ----------------------------
DROP TABLE IF EXISTS `treasury_information`;
CREATE TABLE `treasury_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `treasury_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_type` int(11) NOT NULL,
  `node` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of treasury_information
-- ----------------------------
INSERT INTO `treasury_information` VALUES (1, 'tool1-1', '工具库1-1', 1, '一号节点', NULL);
INSERT INTO `treasury_information` VALUES (2, 'car1-2', '车库1-2', 3, '一号节点', NULL);
INSERT INTO `treasury_information` VALUES (3, 'tool2-1', '工具库2-1', 1, '二号节点', NULL);
INSERT INTO `treasury_information` VALUES (4, 'car2-2', '车库2-2', 3, '二号节点', NULL);
INSERT INTO `treasury_information` VALUES (5, 'tool3-1', '工具库3-1', 1, '三号节点', NULL);
INSERT INTO `treasury_information` VALUES (6, 'car3-2', '车库3-2', 3, '三号节点', NULL);
INSERT INTO `treasury_information` VALUES (7, 'tool4-1', '工具库4-1', 1, '四号节点', NULL);
INSERT INTO `treasury_information` VALUES (8, 'car5-2', '车库5-2', 3, '五号节点', NULL);

-- ----------------------------
-- Table structure for treasury_type
-- ----------------------------
DROP TABLE IF EXISTS `treasury_type`;
CREATE TABLE `treasury_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of treasury_type
-- ----------------------------
INSERT INTO `treasury_type` VALUES (1, '普通工具库');
INSERT INTO `treasury_type` VALUES (2, '绝缘工具库');
INSERT INTO `treasury_type` VALUES (3, '车库');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_sex` tinyint(1) NULL DEFAULT NULL,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 'wang', '不论成功还是失败，都是系于自己', '汪淼', '91c8479748a30fae3666e0e10fece612', 'T70sHCxY5oceVd+UF1tgRA==', '123456', '1', 'http://localhost:8081/file/avatar/1/a915858d7027cb6b1c5eb67bb618463a.jpg', '1990-01-01 00:00:00');
INSERT INTO `user` VALUES (2, 0, 'ye', '自信是成功的第一诀窍', '叶文洁', '34f85d659b60adf6e060bc3ddc349e77', 'wmot5qwvD/g5xDSnbRib8g==', '1234567', '1', 'http://localhost:8081/file/avatar/2/17ceee157d536b3dac708ca5ec8f9798.png', '1990-01-01 14:42:27');
INSERT INTO `user` VALUES (3, 1, 'luo', '所有的努力，大家都会绕个大权回报给你', '罗辑', '90933e2040f0ba2a110088b0d3b48169', '3YQCwU42zrZ1z9zn2DXaJQ==', '12345678', '1', NULL, '1990-01-01 14:42:27');
INSERT INTO `user` VALUES (4, 0, 'cheng', '觉得自己做的到和做不到，都在一念之间', '程心', '2ba290e34aae105009bb71e92218a119', 'SyV9ghhidG211BNLWjV1Kw==', '123456789', '1', NULL, '1990-01-01 14:42:27');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 4);
INSERT INTO `user_role` VALUES (4, 4, 3);

-- ----------------------------
-- Table structure for vehicle_infomation
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_infomation`;
CREATE TABLE `vehicle_infomation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vehicle_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vehicle_location` int(11) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `vehicle_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_infomation
-- ----------------------------
INSERT INTO `vehicle_infomation` VALUES (1, '车辆一', 'car1', 2, NULL, '2020-04-16 16:05:11', '2020-04-16 16:05:38', '0');
INSERT INTO `vehicle_infomation` VALUES (2, '车辆二', 'car2', 2, NULL, '2020-04-16 16:05:30', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (3, '车辆三', 'car3', 2, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (4, '车辆四', 'car4', 4, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '0');
INSERT INTO `vehicle_infomation` VALUES (5, '车辆五', 'car5', 4, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (6, '车辆六', 'car6', 4, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '0');
INSERT INTO `vehicle_infomation` VALUES (7, '车辆七', 'car7', 6, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (8, '车辆八', 'car8', 6, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (9, '车辆九', 'car9', 6, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (10, '车辆十', 'car10', 6, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');
INSERT INTO `vehicle_infomation` VALUES (11, '车辆十一', 'car11', 8, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '0');
INSERT INTO `vehicle_infomation` VALUES (12, '车辆十二', 'car12', 8, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '0');
INSERT INTO `vehicle_infomation` VALUES (13, '车辆十三', 'car13', 8, NULL, '2020-04-16 16:05:38', '2020-04-16 16:05:38', '1');

-- ----------------------------
-- Table structure for vehicle_stream
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_stream`;
CREATE TABLE `vehicle_stream`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) NOT NULL,
  `worksheet_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_stream
-- ----------------------------
INSERT INTO `vehicle_stream` VALUES (1, 1, 1);
INSERT INTO `vehicle_stream` VALUES (2, 2, 1);
INSERT INTO `vehicle_stream` VALUES (3, 3, 2);
INSERT INTO `vehicle_stream` VALUES (4, 4, 2);
INSERT INTO `vehicle_stream` VALUES (5, 5, 3);
INSERT INTO `vehicle_stream` VALUES (6, 6, 3);
INSERT INTO `vehicle_stream` VALUES (7, 7, 3);
INSERT INTO `vehicle_stream` VALUES (8, 8, 8);
INSERT INTO `vehicle_stream` VALUES (9, 2, 5);
INSERT INTO `vehicle_stream` VALUES (10, 7, 5);
INSERT INTO `vehicle_stream` VALUES (11, 5, 5);
INSERT INTO `vehicle_stream` VALUES (12, 3, 6);
INSERT INTO `vehicle_stream` VALUES (13, 13, 6);
INSERT INTO `vehicle_stream` VALUES (14, 10, 7);
INSERT INTO `vehicle_stream` VALUES (15, 9, 8);

-- ----------------------------
-- Table structure for worksheet_info
-- ----------------------------
DROP TABLE IF EXISTS `worksheet_info`;
CREATE TABLE `worksheet_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` int(11) NULL DEFAULT NULL,
  `worksheet_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `worksheet_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `worksheet_type` int(11) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `worksheet_status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worksheet_info
-- ----------------------------
INSERT INTO `worksheet_info` VALUES (1, 1, '一号工单', '1000.00RMB', 1, NULL, '2020-04-17 11:32:06', '2020-04-19 11:32:37', '0');
INSERT INTO `worksheet_info` VALUES (2, 2, '二号工单', '2000.00RMB', 2, NULL, '2020-04-16 11:34:14', '2020-04-23 11:34:21', '0');
INSERT INTO `worksheet_info` VALUES (3, 3, '三号工单', '1500.00RMB', 3, NULL, '2020-04-18 11:35:44', '2020-05-01 11:35:49', '0');
INSERT INTO `worksheet_info` VALUES (4, 4, '四号工单', '2500.00RMB', 4, NULL, '2020-05-01 11:36:25', '2020-05-02 11:36:41', '0');
INSERT INTO `worksheet_info` VALUES (5, 1, '五号工单', '3000.00RMB', 5, NULL, '2020-05-07 11:37:21', NULL, '1');
INSERT INTO `worksheet_info` VALUES (6, 2, '六号工单', '2222.00RMB', 6, NULL, '2020-05-05 11:38:12', NULL, '1');
INSERT INTO `worksheet_info` VALUES (7, 3, '七号工单', '3333.00RMB', 7, NULL, '2020-05-03 11:40:28', NULL, '1');
INSERT INTO `worksheet_info` VALUES (8, 4, '八号工单', '1234.00RMB', 8, NULL, '2020-05-04 11:41:00', NULL, '1');

-- ----------------------------
-- Table structure for worksheet_type
-- ----------------------------
DROP TABLE IF EXISTS `worksheet_type`;
CREATE TABLE `worksheet_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `worksheet_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worksheet_type
-- ----------------------------
INSERT INTO `worksheet_type` VALUES (1, '工单类型一');
INSERT INTO `worksheet_type` VALUES (2, '工单类型二');
INSERT INTO `worksheet_type` VALUES (3, '工单类型三');
INSERT INTO `worksheet_type` VALUES (4, '工单类型四');
INSERT INTO `worksheet_type` VALUES (5, '工单类型五');
INSERT INTO `worksheet_type` VALUES (6, '工单类型六');
INSERT INTO `worksheet_type` VALUES (7, '工单类型七');
INSERT INTO `worksheet_type` VALUES (8, '工单类型八');

SET FOREIGN_KEY_CHECKS = 1;
