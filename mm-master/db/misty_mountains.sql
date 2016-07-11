-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mmountains
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mmountains
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mmountains` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mmountains` ;

-- -----------------------------------------------------
-- Table `mmountains`.`dwarf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mmountains`.`dwarf` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mmountains`.`treasure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mmountains`.`treasure` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `type` VARCHAR(45) NULL COMMENT '',
  `value` INT NULL COMMENT '',
  `acknowledge` INT NULL DEFAULT 0 COMMENT '',
  `dwarf_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `dwarf_id`)  COMMENT '',
  INDEX `fk_treasure_dwarf_idx` (`dwarf_id` ASC)  COMMENT '',
  CONSTRAINT `fk_treasure_dwarf`
    FOREIGN KEY (`dwarf_id`)
    REFERENCES `mmountains`.`dwarf` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mmountains`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mmountains`.`message` (
  `id` INT NOT NULL COMMENT '',
  `content` VARCHAR(2000) NULL COMMENT '',
  `read` INT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mmountains`.`dwarf`
-- -----------------------------------------------------
START TRANSACTION;
USE `mmountains`;
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (1, 'bombur');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (2, 'bofur');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (3, 'ori');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (4, 'balin');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (5, 'dwalin');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (6, 'gloin');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (7, 'fili');
INSERT INTO `mmountains`.`dwarf` (`id`, `name`) VALUES (8, 'kili');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mmountains`.`treasure`
-- -----------------------------------------------------
START TRANSACTION;
USE `mmountains`;
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (1, 'coin', 500, 0, 1);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (2, 'coin', 500, 1, 2);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (3, 'rubin', 750, 0, 5);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (4, 'rubin', 750, 0, 4);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (5, 'coin', 500, 1, 3);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (6, 'coin', 500, 1, 2);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (7, 'coin', 500, 1, 1);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (8, 'coin', 500, 0, 8);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (9, 'rubin', 750, 0, 8);
INSERT INTO `mmountains`.`treasure` (`id`, `type`, `value`, `acknowledge`, `dwarf_id`) VALUES (10, 'rubin', 750, 0, 2);

COMMIT;

