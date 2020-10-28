-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario(
  idUsuario INTEGER PRIMARY KEY ,
  nombre VARCHAR(40)  NOT NULL,
  correo VARCHAR(50)  NOT NULL,
  contraseña VARCHAR(50)  NOT NULL,
  estado INTEGER  NOT NULL,
  rol VARCHAR(10) NOT NULL
  
  
);

-- -----------------------------------------------------
-- Table `Laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Laboratorio (
  idLaboratorio serial PRIMARY KEY,
  nombre INT NOT NULL);

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Equipo (
  idEquipo serial PRIMARY KEY,
  usuario INT REFERENCES Usuario(idUsuario) DEFERRABLE, 
  laboratorio INT REFERENCES Laboratorio(idLaboratorio) DEFERRABLE,
  fechaRegistro DATE NOT NULL,
  disponible INT  NOT NULL
  
  
);

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Elemento (
  idElemento serial PRIMARY KEY,
  idEquipo INT REFERENCES Equipo(idEquipo) DEFERRABLE,
  tipo INT  NOT NULL,
  nombre VARCHAR(50)  NOT NULL,
  descripcion VARCHAR(500)  NOT NULL);


-- -----------------------------------------------------
-- Table `Novedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Novedad (
  idNovedad serial PRIMARY KEY,
  titulo VARCHAR(20) NOT NULL,
  detalle VARCHAR(200) NOT NULL
);

-- -----------------------------------------------------
-- Table `Tiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Tiene (
  idNovedad INT REFERENCES Novedad(idNovedad) DEFERRABLE,
  idEquipo INT REFERENCES Equipo(idEquipo) DEFERRABLE,
  fechaNovedad DATE NOT NULL,
  PRIMARY KEY (idNovedad, idEquipo)
);

-- -----------------------------------------------------
-- Table `Asigna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Asigna (
  idNovedad INT REFERENCES Novedad(idNovedad) DEFERRABLE,
  idElemento INT REFERENCES Elemento(idElemento) DEFERRABLE,
  fechaNovedad DATE NOT NULL,
  PRIMARY KEY (idNovedad, idElemento)
);








DROP TABLE Tiene;
DROP TABLE Asigna;
DROP TABLE Novedad;
DROP TABLE Elemento;
DROP TABLE Equipo;
DROP TABLE Usuario;
DROP TABLE Laboratorio; 
  



