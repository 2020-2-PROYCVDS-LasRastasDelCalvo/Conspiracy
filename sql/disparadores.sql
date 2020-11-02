-- -----------------------------------------------------
-- Table `Usuario`
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
-- Table `Novedad`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION fechaNovedad()
	RETURNS TRIGGER
AS
$$
BEGIN
	NEW.fecha := CURRENT_DATE;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_fecha_Novedad
  BEFORE INSERT ON public.Novedad
  FOR EACH ROW
EXECUTE PROCEDURE fechaNovedad();

-- -----------------------------------------------------
-- Table `Equipo`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION estadoEquipo()
	RETURNS TRIGGER
AS
$$
BEGIN
	NEW.disponible := 1;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_disponible_Equipo
  BEFORE INSERT ON public.Equipo
  FOR EACH ROW
EXECUTE PROCEDURE estadoEquipo();