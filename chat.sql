SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `db_messg` DEFAULT CHARACTER SET utf8 ;
USE `db_messg` ;

-- -----------------------------------------------------
-- Table `db_messg`.`spr_avtors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_messg`.`spr_avtors` ;

CREATE TABLE IF NOT EXISTS `db_messg`.`spr_avtors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `avtor` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `avtor_UNIQUE` (`avtor` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_messg`.`table1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_messg`.`table1` ;

CREATE TABLE IF NOT EXISTS `db_messg`.`table1` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `spr_avtors_id` INT(11) NOT NULL,
  `text` VARCHAR(155) NOT NULL DEFAULT '',
  `timez` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_table1_spr_avtors1_idx` (`spr_avtors_id` ASC),
  CONSTRAINT `fk_table1_spr_avtors1`
    FOREIGN KEY (`spr_avtors_id`)
    REFERENCES `db_messg`.`spr_avtors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
