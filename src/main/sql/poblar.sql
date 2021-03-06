  
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
INSERT INTO Laboratorio( nombre, estado)
VALUES('Disponibles','ABIERTO');

INSERT INTO Laboratorio( nombre, estado)
VALUES('Ingeniería de Software','ABIERTO');

INSERT INTO Laboratorio( nombre, estado)
VALUES('Plataformas Computacionales','ABIERTO');

INSERT INTO Laboratorio( nombre, estado)
VALUES('Redes de Computadores','ABIERTO');

INSERT INTO Laboratorio( nombre, estado)
VALUES('Multimedia y Móviles','ABIERTO');

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible,estado)
VALUES(1,1,CURRENT_DATE ,1,'ACTIVO');

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible,estado)
VALUES(2,2,CURRENT_DATE ,1,'ACTIVO');

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible,estado)
VALUES(3,2,CURRENT_DATE ,1,'ACTIVO');

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible,estado)
VALUES(4,1,CURRENT_DATE ,1,'ACTIVO');

INSERT INTO Equipo(idEquipo,laboratorio,fechaRegistro,disponible,estado)
VALUES(5,3,CURRENT_DATE ,1,'ACTIVO');

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Torre','Torre A','Descripcion de la torre A',1,0,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Pantalla','Pantalla A','Descripcion de la pantalla A',1,0,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Mouse','Mouse A','Descripcion del mouse A',1,0,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Teclado','Teclado A','Descripcion del teclado A',1,0,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Torre','Torre B','Descripcion de la torre B',null,1,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Torre','Torre C','Descripcion de la torre C',null,1,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Mouse','Mouse C','Descripcion del Mouse C',null,1,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Pantalla','Pantalla C','Descripcion de la pantalla C',null,1,'ACTIVO');

INSERT INTO Elemento(tipo,nombre,descripcion,idEquipo,disponible,estado)
VALUES('Teclado','Torre C','Descripcion del teclado C',null,1,'ACTIVO');

-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad 1','novedad1.txt',CURRENT_DATE ,10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Equipo','novedad Equipo.txt',CURRENT_DATE ,10048240,1, NULL);

INSERT INTO Novedad(titulo,detalle,fecha,usuario,idEquipo,idElemento)
VALUES('Titulo novedad Elemento','novedad Elemento.txt',CURRENT_DATE ,12345689,1, 3);