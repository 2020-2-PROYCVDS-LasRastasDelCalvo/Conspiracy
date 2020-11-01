-- -----------------------------------------------------
-- Table `Usuario` (revisar porque no compilan )
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION fechaEquipo() 
	RETURNS TRIGGER 
AS 
$$
BEGIN
	NEW.fechaRegistro := CURRENT_DATE;
	RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

CREATE TRIGGER AD_fechaRegistro_Equipo
  BEFORE INSERT ON public.Equipo
  FOR EACH ROW
EXECUTE PROCEDURE fechaEquipo();

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION Elemento() 
	RETURNS TRIGGER 
AS 
$$
BEGIN
	NEW.idEquipo := 0;
	RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

CREATE TRIGGER AD_idEquipo
  BEFORE INSERT ON Elemento
  FOR EACH ROW
EXECUTE PROCEDURE Elemento();
