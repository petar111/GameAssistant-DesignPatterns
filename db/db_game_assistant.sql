/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.13-MariaDB : Database - gamesdss_softverskipaterniseminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gamesdss_softverskipaterniseminarski` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `gamesdss_softverskipaterniseminarski`;

/*Table structure for table `game` */

DROP TABLE IF EXISTS `game`;

CREATE TABLE `game` (
  `Id` bigint(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Info` varchar(255) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `game` */

insert  into `game`(`Id`,`Name`,`Info`,`Description`) values (1,'Prisoner\'s dillema','https://en.wikipedia.org/wiki/Prisoner%27s_dilemma','One of the most controversial and difficult games.'),(2,'Chicken game','Info-FIXME','If you want to be the best, you must face death and scare the opponent.'),(3,'Coordinate number variation','Info-FIXME','You must think like the other player.');

/*Table structure for table `playerconfiguration` */

DROP TABLE IF EXISTS `playerconfiguration`;

CREATE TABLE `playerconfiguration` (
  `GameId` bigint(20) NOT NULL,
  `Id` bigint(20) NOT NULL,
  `Strategies` varchar(1000) NOT NULL,
  `Payoffs` varchar(500) NOT NULL,
  PRIMARY KEY (`GameId`,`Id`),
  CONSTRAINT `playerconfiguration_ibfk_1` FOREIGN KEY (`GameId`) REFERENCES `game` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `playerconfiguration` */

insert  into `playerconfiguration`(`GameId`,`Id`,`Strategies`,`Payoffs`) values (1,1,'Cooperate,Defect','3,1,4,2'),(1,2,'Cooperate,Defect','3,1,4,2'),(2,1,'Bail,Face','3,2,4,1'),(2,2,'Bail,Face','3,2,4,1'),(3,1,'1,2,3','1,0,0,0,1,0,0,0,1'),(3,2,'1,2,3','1,0,0,0,1,0,0,0,1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
