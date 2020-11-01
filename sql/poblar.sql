-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
INSERT INTO Usuario( idUsuario, nombre, correo, contraseña, estado, rol)
VALUES(12345689, 'Leonardo Galeano', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1, 'administrador');

INSERT INTO Usuario( idUsuario, nombre, correo, contraseña, estado, rol)
VALUES(10048240, 'Camilo Rincon', 'Rincon10', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1, 'administrador');

INSERT INTO Usuario( idUsuario, nombre, correo, contraseña, estado, rol)
VALUES(98765432, 'Jeisson Otalvaro', 'usuario', '9250e222c4c71f0c58d4c54b50a880a312e9f9fed55d5c3aa0b0e860ded99165', 1, 'usuario');

-- -----------------------------------------------------
-- Table `Laboratorio`
-- -----------------------------------------------------
INSERT INTO Laboratorio( nombre )
VALUES('Ingeniería de Software');

INSERT INTO Laboratorio( nombre )
VALUES('Plataformas Computacionales');

INSERT INTO Laboratorio( nombre )
VALUES('Redes de Computadores');

INSERT INTO Laboratorio( nombre )
VALUES('Multimedia y Móviles');


-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
INSERT INTO Equipo(usuario,laboratorio,fecharegistro,disponible)
VALUES(10048240,1,CURRENT_DATE,1);

INSERT INTO Equipo(usuario,laboratorio,fecharegistro,disponible)
VALUES(12345689,2,CURRENT_DATE,1);

INSERT INTO Equipo(usuario,laboratorio,fecharegistro,disponible)
VALUES(12345689,2,CURRENT_DATE,1);

INSERT INTO Equipo(usuario,laboratorio,fecharegistro,disponible)
VALUES(10048240,1,CURRENT_DATE,1);

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
INSERT INTO Elemento(idEquipo,tipo,nombre,descripcion)
VALUES(NULL,1,'Torre','Torre...');

INSERT INTO Elemento(idEquipo,tipo,nombre,descripcion)
VALUES(NULL,2,'Pantalla Plasma.','Pantalla Plasma...');

INSERT INTO Elemento(idEquipo,tipo,nombre,descripcion)
VALUES(1,1,'Pantalla Plasma 2.0','Pantalla Plasma 2.0...');

-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
INSERT INTO Novedad(titulo,detalle,fecha,idEquipo,idElemento)
VALUES('Titulo novedad 1','novedad1.txt',CURRENT_DATE,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,idEquipo,idElemento)
VALUES('Titulo novedad Equipo','novedad Equipo.txt',CURRENT_DATE,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,idEquipo,idElemento)
VALUES('Titulo novedad Elemento','novedad Elemento.txt',CURRENT_DATE,1, 3);
