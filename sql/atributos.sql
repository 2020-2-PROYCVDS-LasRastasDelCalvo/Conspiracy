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