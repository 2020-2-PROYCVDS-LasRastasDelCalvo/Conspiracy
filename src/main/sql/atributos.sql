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

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
ALTER TABLE Equipo
ADD CONSTRAINT CK_disponible_Equipo
CHECK(
	disponible  IN (0,1)
);