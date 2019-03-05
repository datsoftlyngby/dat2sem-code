DROP SCHEMA IF EXISTS `databasebasic`;
CREATE SCHEMA `databasebasic`;
USE `databasebasic` ;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `balance` INT NULL,
  `admin` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `user` VALUES (null, 'abc', '123', '1000', '1');
INSERT INTO `user` VALUES (null, 'def', '321', '1001', '0');