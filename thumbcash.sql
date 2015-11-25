-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema thumbcash
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema thumbcash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `thumbcash` DEFAULT CHARACTER SET utf8 ;
USE `thumbcash` ;

-- -----------------------------------------------------
-- Table `thumbcash`.`cards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thumbcash`.`cards` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `card_num` VARCHAR(255) NOT NULL COMMENT '',
  `cvc` VARCHAR(255) NOT NULL COMMENT '',
  `type` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `expires` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `thumbcash`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thumbcash`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(255) NOT NULL COMMENT '',
  `apellidos` VARCHAR(255) NOT NULL COMMENT '',
  `huella` BLOB NOT NULL COMMENT '',
  `credito` DOUBLE(6,2) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `thumbcash`.`card_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thumbcash`.`card_user` (
  `card_id` INT(11) NOT NULL COMMENT '',
  `user_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`card_id`, `user_id`)  COMMENT '',
  INDEX `fk_users_has_cards_cards1_idx` (`card_id` ASC)  COMMENT '',
  INDEX `fk_users_has_cards_users_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_users_has_cards_cards1`
    FOREIGN KEY (`card_id`)
    REFERENCES `thumbcash`.`cards` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_cards_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `thumbcash`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `thumbcash`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thumbcash`.`contact` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `direccion` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `telefono` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `estado` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `ciudad` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `user_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '',
  INDEX `fk_contact_users_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `fk_contact_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `thumbcash`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `thumbcash`.`movements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thumbcash`.`movements` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `description` TEXT NULL DEFAULT NULL COMMENT '',
  `amount` DOUBLE(6,2) NULL DEFAULT NULL COMMENT '',
  `date` DATETIME NULL DEFAULT NULL COMMENT '',
  `card_id` INT(11) NOT NULL COMMENT '',
  `user_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)  COMMENT '',
  INDEX `fk_movements_users1_idx` (`user_id` ASC)  COMMENT '',
  INDEX `fk_movements_cards1_idx` (`card_id` ASC)  COMMENT '',
  CONSTRAINT `fk_movements_cards1`
    FOREIGN KEY (`card_id`)
    REFERENCES `thumbcash`.`cards` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movements_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `thumbcash`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
