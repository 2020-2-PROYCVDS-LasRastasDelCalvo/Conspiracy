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
CREATE OR REPLACE FUNCTION disponibilidadEquipo()
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
EXECUTE PROCEDURE disponibilidadEquipo();


CREATE OR REPLACE FUNCTION estadoEquipo()
	RETURNS TRIGGER
AS
$$
BEGIN
	NEW.estado := 'ACTIVO';
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_estado_Equipo
  BEFORE INSERT ON public.Equipo
  FOR EACH ROW
EXECUTE PROCEDURE estadoEquipo();

-- -----------------------------------------------------
-- Table `Elemento`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION FC_SET_ESTADO()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.estado := 'ACTIVO';
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER TR_Elemento_Estado
    BEFORE INSERT ON public.Elemento
    FOR EACH ROW
EXECUTE PROCEDURE FC_SET_ESTADO();

CREATE OR REPLACE FUNCTION estadoElemento()
	RETURNS TRIGGER
AS
$$
BEGIN
    IF NEW.idequipo IS NULL THEN
        NEW.disponible := 1;
    ELSE
        NEW.disponible := 0;
    END IF;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_disponible_Elemento
  BEFORE INSERT OR UPDATE ON public.Elemento
  FOR EACH ROW
EXECUTE PROCEDURE estadoElemento();

-- -----------------------------------------------------
-- Table `Laboratorio`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION FC_SET_ESTADO_LABORATORIO()
              RETURNS TRIGGER
              AS
              $$
BEGIN
    NEW.estado := 'ABIERTO';
RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER TR_Laboratorio_Estado
    BEFORE INSERT ON public.Laboratorio
    FOR EACH ROW
    EXECUTE PROCEDURE FC_SET_ESTADO_LABORATORIO();