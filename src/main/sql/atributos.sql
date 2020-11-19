-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
ALTER TABLE Usuario 
ADD CONSTRAINT CK_idUsuario_Usuario
CHECK(
	idUsuario BETWEEN 0 AND 999999999
);

ALTER TABLE Usuario 
ADD CONSTRAINT CK_rol_Usuario
CHECK( 
	rol IN ('administrador','usuario') 
);

ALTER TABLE Usuario 
ADD CONSTRAINT CK_estado_Usuario
CHECK( 
	estado  IN (0,1) 
);


-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
ALTER TABLE Elemento
ADD CONSTRAINT CK_disponible_Elemento
CHECK(
	disponible  IN (0,1)
);

ALTER TABLE Elemento
ADD CONSTRAINT CH_Elemento_estado
CHECK(
    estado IN ('ACTIVO','INACTIVO')
);

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
ALTER TABLE Equipo
ADD CONSTRAINT CK_disponible_Equipo
CHECK(
	disponible  IN (0,1)
);

ALTER TABLE Equipo
ADD CONSTRAINT CK_estado_Equipo
CHECK(
	estado  IN ('ACTIVO','INACTIVO')
);

-- -----------------------------------------------------
-- Table `laboratorio`
-- -----------------------------------------------------
ALTER TABLE Laboratorio
    ADD CONSTRAINT CK_estado_Laboratorio
        CHECK (
            estado IN ('ABIERTO', 'CERRADO')
            );
