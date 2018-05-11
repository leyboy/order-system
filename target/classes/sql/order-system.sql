/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.17-log : Database - orders
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orders` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `orders`;

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾客id',
  `customer_name` varchar(30) NOT NULL COMMENT '顾客姓名',
  `customer_number` varchar(30) NOT NULL COMMENT '顾客学号',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_customer` */

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(30) NOT NULL COMMENT '菜品名',
  `menu_dish_price` int(8) NOT NULL COMMENT '菜品单价',
  `window_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `window_id` (`window_id`),
  CONSTRAINT `tb_menu_ibfk_1` FOREIGN KEY (`window_id`) REFERENCES `tb_window` (`window_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_menu` */

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_reservation_time` varchar(10) DEFAULT NULL COMMENT '订单预定时间',
  `order_discount` double DEFAULT NULL COMMENT '订单折扣',
  `order_code` varchar(30) NOT NULL COMMENT '订单号',
  `order_dish_number` tinyint(4) DEFAULT NULL COMMENT '订单菜品数量',
  `order_pick_number` tinyint(4) DEFAULT NULL COMMENT '订单取货号',
  `window_id` int(11) DEFAULT NULL COMMENT '窗口id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜品id',
  `customer_id` int(11) DEFAULT NULL COMMENT '顾客id',
  PRIMARY KEY (`order_id`),
  KEY `window_id` (`window_id`),
  KEY `menu_id` (`menu_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`window_id`) REFERENCES `tb_window` (`window_id`),
  CONSTRAINT `tb_order_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `tb_menu` (`menu_id`),
  CONSTRAINT `tb_order_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

/*Table structure for table `tb_window` */

DROP TABLE IF EXISTS `tb_window`;

CREATE TABLE `tb_window` (
  `window_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '窗口id',
  `window_name` varchar(30) NOT NULL COMMENT '窗口名',
  `window_number` tinyint(4) NOT NULL COMMENT '窗口号',
  PRIMARY KEY (`window_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_window` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
