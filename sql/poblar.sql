  
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
INSERT INTO Equipo(1,laboratorio)
VALUES(1);

INSERT INTO Equipo(2,laboratorio)
VALUES(2);

INSERT INTO Equipo(3,laboratorio)
VALUES(2);

INSERT INTO Equipo(4,laboratorio)
VALUES(1);

INSERT INTO Equipo(5,laboratorio)
VALUES(3);


-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Torre','Torre A','Descripcion de la torre A',1,1);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Pantalla','Pantalla A','Descripcion de la pantalla A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Mouse','Mouse A','Descripcion del mouse A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Teclado','Teclado A','Descripcion del teclado A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Torre','Torre B','Descripcion de la torre B',1,1);


-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
INSERT INTO Novedad(titulo,detalle,usuario,idEquipo,idElemento)
VALUES('Titulo novedad 1','novedad1.txt',10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Equipo','novedad Equipo.txt',10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Elemento','novedad Elemento.txt',12345689,1, 3);