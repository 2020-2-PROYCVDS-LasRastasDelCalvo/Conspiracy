-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------

DROP TRIGGER IF EXISTS AD_fechaRegistro_Equipo
ON Equipo;

-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------

DROP TRIGGER IF EXISTS  AD_fecha_Novedad
ON Novedad;

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------

DROP TRIGGER IF EXISTS  AD_disponible_Equipo
ON Equipo;

DROP TRIGGER IF EXISTS  AD_estado_Equipo
ON Equipo;
-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------

DROP TRIGGER IF EXISTS  AD_disponible_Elemento
ON Elemento;

DROP TRIGGER IF EXISTS TR_Elemento_Estado
ON Elemento;

-- -----------------------------------------------------
-- Table `Laboratorio`
-- -----------------------------------------------------

DROP TRIGGER IF EXISTS  TR_Laboratorio_Estado
    ON Laboratorio;