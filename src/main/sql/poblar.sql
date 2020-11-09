  
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
VALUES('Disponibles');

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
INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible)
VALUES(1,1,CURRENT_DATE ,1);

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible)
VALUES(2,2,CURRENT_DATE ,1);

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible)
VALUES(3,2,CURRENT_DATE ,1);

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible)
VALUES(4,1,CURRENT_DATE ,1);

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible)
VALUES(5,3,CURRENT_DATE ,1);

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Torre','Torre A','Descripcion de la torre A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Pantalla','Pantalla A','Descripcion de la pantalla A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Mouse','Mouse A','Descripcion del mouse A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Teclado','Teclado A','Descripcion del teclado A',1,0);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Torre','Torre B','Descripcion de la torre B',null,1);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Torre','Torre C','Descripcion de la torre C',null,1);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Mouse','Mouse C','Descripcion del Mouse C',null,1);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Pantalla','Pantalla C','Descripcion de la pantalla C',null,1);

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible)
VALUES('Teclado','Torre C','Descripcion del teclado C',null,1);

-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad 1','novedad1.txt',CURRENT_DATE ,10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Equipo','novedad Equipo.txt',CURRENT_DATE ,10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Elemento','novedad Elemento.txt',CURRENT_DATE ,12345689,1, 3);