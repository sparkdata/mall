
-- 创建数据库
CREATE DATABASE mall CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_general_ci';

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`USER_ID` BIGINT (11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	`NICK_NAME` VARCHAR (32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
	`NAME` VARCHAR (32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名字',
	`GENDER` VARCHAR (64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
	`CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
	`UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 10000 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表';

-- 订单表
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `USER_ID` bigint(11) NOT NULL COMMENT '用户ID',
  `ORDER_NO` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `PRODUCT_NAME` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消费商品名称',
  `PRODUCT_UNIT_PRICE` decimal(8,2) DEFAULT NULL COMMENT '消费商品单价',
  `PRODUCT_CONSUME_COUNT` int(11) DEFAULT NULL COMMENT '消费商品数量',
  `CONSUME_DATE` date DEFAULT NULL COMMENT '消费日期',
  `CONSUME_TIME` datetime DEFAULT NULL COMMENT '消费时间',
  `SERIAL_NO` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易流水号',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';


