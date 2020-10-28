-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` INT(7) NOT NULL,
  `nombre` VARCHAR(40)  NOT NULL,
  `correo` VARCHAR(50)  NOT NULL,
  `contraseña` VARCHAR(50)  NOT NULL,
  `estado` INT(1)  NOT NULL,
  `rol` VARCHAR(10) NOT NULL);


-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Equipo` (
  `idEquipo` INT(10) NOT NULL,
  `usuario` INT(7) NOT NULL,
  `fechaRegistro` DATE NOT NULL,
  `disponible` INT(1)  NOT NULL);


-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Elemento` (
  `idElemento` INT(10) NOT NULL,
  `idEquipo` INT(10) NOT NULL,
  `tipo` INT(1)  NOT NULL,
  `nombre` VARCHAR(50)  NOT NULL,
  `descripcion` VARCHAR(500)  NOT NULL);


-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Novedad` (
  `idNovedad` INT(10) NOT NULL,
  `titulo` VARCHAR(20) NOT NULL,
  `detalle` VARCHAR(200) NOT NULL);

-- -----------------------------------------------------
-- Table `Tiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tiene` (
  `idNovedad` INT(10) NOT NULL,
  `idEquipo` INT(10) NOT NULL,
  `fechaNovedad` DATE NOT NULL);

-- -----------------------------------------------------
-- Table `Asigna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Asigna` (
  `idNovedad` INT(10) NOT NULL,
  `idElemento` INT(10) NOT NULL,
  `fechaNovedad` DATE NOT NULL);

-- -----------------------------------------------------
-- Table `Laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Laboratorio` (
  `idLaboratorio` INT(10) NOT NULL,
  `idEquipo` INT(10) NOT NULL,
  `nombre` INT(10) NOT NULL);
  
  



