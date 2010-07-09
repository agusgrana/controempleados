SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `EMPLEADITOS` ;
CREATE SCHEMA IF NOT EXISTS `EMPLEADITOS` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Horario` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Horario` (
  `idHorarios` INT NOT NULL AUTO_INCREMENT ,
  `nombreHorario` VARCHAR(45) NOT NULL ,
  `horaEntrada` TIME NOT NULL ,
  `horaSalida` TIME NOT NULL ,
  PRIMARY KEY (`idHorarios`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Vinculacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Vinculacion` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Vinculacion` (
  `idVinculacion` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idVinculacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Empleado` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Empleado` (
  `idEmpleado` INT NOT NULL ,
  `nombres` VARCHAR(45) NOT NULL ,
  `apellidos` VARCHAR(45) NOT NULL ,
  `fechaNacimiento` DATE NOT NULL ,
  `direccion` VARCHAR(200) NOT NULL ,
  `telefono` INT NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `tipoSangre` VARCHAR(45) NOT NULL ,
  `vinculacion` INT NOT NULL ,
  `foto` BLOB NOT NULL ,
  PRIMARY KEY (`idEmpleado`) ,
  INDEX `vinculacionEmpleado` (`vinculacion` ASC) ,
  CONSTRAINT `vinculacionEmpleado`
    FOREIGN KEY (`vinculacion` )
    REFERENCES `EMPLEADITOS`.`Vinculacion` (`idVinculacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Salario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Salario` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Salario` (
  `idsalario` INT NOT NULL AUTO_INCREMENT ,
  `codEmpleado` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `valorBruto` INT NOT NULL ,
  `valorNeto` INT NOT NULL ,
  `salud` INT NOT NULL ,
  `pension` INT NOT NULL ,
  `accionJudicial` INT NOT NULL ,
  `cooperativa` INT NOT NULL ,
  `prestaciones` INT NOT NULL ,
  `extras` INT NOT NULL ,
  `adicionales` INT NOT NULL ,
  `cesantias` INT NOT NULL ,
  `primas` INT NOT NULL ,
  `bonificaciones` INT NOT NULL ,
  PRIMARY KEY (`idsalario`) ,
  INDEX `salarioEmpleado` (`codEmpleado` ASC) ,
  CONSTRAINT `salarioEmpleado`
    FOREIGN KEY (`codEmpleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Registro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Registro` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Registro` (
  `idRegistro` INT NOT NULL AUTO_INCREMENT ,
  `horaEntrada` DATETIME NOT NULL ,
  `horaSalida` DATETIME NULL ,
  PRIMARY KEY (`idRegistro`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Anomalia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Anomalia` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Anomalia` (
  `idAnomalia` INT NOT NULL AUTO_INCREMENT ,
  `Empleado` INT NOT NULL ,
  `Fecha` DATETIME NOT NULL ,
  `Descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idAnomalia`) ,
  INDEX `anomaliaEmpleado` (`Empleado` ASC) ,
  CONSTRAINT `anomaliaEmpleado`
    FOREIGN KEY (`Empleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Turnos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Turnos` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Turnos` (
  `idTurnos` INT NOT NULL AUTO_INCREMENT ,
  `Horario` INT NOT NULL ,
  `Registro` INT NOT NULL ,
  `Empleado` INT NOT NULL ,
  `Fecha` DATE NOT NULL ,
  PRIMARY KEY (`idTurnos`) ,
  INDEX `turnosHorario` (`Horario` ASC) ,
  INDEX `turnosRegistro` (`Registro` ASC) ,
  INDEX `turnosEmpleado` (`Empleado` ASC) ,
  CONSTRAINT `turnosHorario`
    FOREIGN KEY (`Horario` )
    REFERENCES `EMPLEADITOS`.`Horario` (`idHorarios` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `turnosRegistro`
    FOREIGN KEY (`Registro` )
    REFERENCES `EMPLEADITOS`.`Registro` (`idRegistro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `turnosEmpleado`
    FOREIGN KEY (`Empleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Huellas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Huellas` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Huellas` (
  `idHuellas` INT NOT NULL AUTO_INCREMENT ,
  `Empleado` INT NOT NULL ,
  `Huella` BLOB NOT NULL ,
  PRIMARY KEY (`idHuellas`) ,
  INDEX `huellaEmpleado` (`Empleado` ASC) ,
  CONSTRAINT `huellaEmpleado`
    FOREIGN KEY (`Empleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`Familiar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`Familiar` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`Familiar` (
  `idFamiliar` INT NOT NULL ,
  `nombres` VARCHAR(45) NOT NULL ,
  `apellidos` VARCHAR(45) NOT NULL ,
  `fechaNacimiento` DATE NOT NULL ,
  `parentesco` VARCHAR(45) NOT NULL ,
  `empleado` INT NOT NULL ,
  PRIMARY KEY (`idFamiliar`) ,
  INDEX `empleadoFamiliar` (`empleado` ASC) ,
  CONSTRAINT `empleadoFamiliar`
    FOREIGN KEY (`empleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EMPLEADITOS`.`HistoriaLaboral`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EMPLEADITOS`.`HistoriaLaboral` ;

CREATE  TABLE IF NOT EXISTS `EMPLEADITOS`.`HistoriaLaboral` (
  `idHistoriaLaboral` INT NOT NULL AUTO_INCREMENT ,
  `empleado` INT NOT NULL ,
  `cargo` VARCHAR(45) NOT NULL ,
  `fechaInicio` DATE NOT NULL ,
  `fechaSalida` DATE NOT NULL ,
  `salarioBase` INT NOT NULL ,
  `valorHoraExtra` INT NOT NULL ,
  PRIMARY KEY (`idHistoriaLaboral`) ,
  INDEX `CargoEmpleado` (`empleado` ASC) ,
  CONSTRAINT `CargoEmpleado`
    FOREIGN KEY (`empleado` )
    REFERENCES `EMPLEADITOS`.`Empleado` (`idEmpleado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
