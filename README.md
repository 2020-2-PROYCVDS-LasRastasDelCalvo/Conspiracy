# Plataforma Historial de Equipos
## CICLOS DE VIDA Y DESARROLLO DE SOFTWARE / 2020-2

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://lasrastasdelcalvo.herokuapp.com/)

## Integrantes

|     Nombre    |     Rol         |
|--------------|------------- |
|Oscar Ospina	|Product Owner    |
|Ana Gabriela |Scrum Master   
|Camilo Rincón|Developer   |
|Galeano Garzón |Developer   |
|Andrés Pico|Developer   |

--- 

## Descripción del producto

### __Descripción General__
La **_Plataforma Historial de Equipos_**, es una herramienta donde el personal del laboratorio de informática (LabInfo) pertenecientes a la decanatura de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito, pueden registrar los laboratorio, equipos y elementos de cada equipo, junto con las novedades que se realizan a cada uno de estos. El sistema, más allá de facilitar el registro de los equipos y novedades, es una valiosa base de conocimiento donde el personal del laboratorio, puede revisar el histórico de novedades que se le han realizado a cada elemento a través del tiempo durante todo su ciclo de vida útil. El personal administrativo del laboratorio puede crear laboratorios, equipos y elementos, asociar unos a otros y registrar novedades para cada uno; además de tener una variedad de reportes que les permitirá tener el control administrativo de estos implementos.

### Manual De usuario
 Páginas iniciales.
 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Inicial1.png)
 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Inicial2.jpg)

La aplicación maneja 2 tipos de roles para el inicio de sesión, administrador y usuario. Se dará inicio con el rol de administrador, luego de hacer el ingreso, lleva al administrador a la página donde puede realizar todas las funciones pedidas para la aplicación.

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Login.jpg)

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/admin.jpg)

Los servicios con los que cuenta el administrador son:

- Registrar.

- Consultar.

- Asociar.

> #### **REGISTRAR.**

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosRegistro.png)

* _Registrar Equipo._

_¿Cómo registrar un equipo?_

1. Indicar el número del laboratorio correspondiente (1 si el equipo está libre a la hora del registro).

2. Indicar el número identificador del equipo a registrar (Este no puede ser duplicado).

3. Seleccionar qué elementos hacen parte del equipo a registrar (1 de cada tipo).

4. En caso de no encontrar elementos disponibles de cualquier tipo, clicar en el botón correspondiente.

5. Clicar en el botón "Registrar", en caso de ser válido se registrará, en caso contrario recibirá una notificación.

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Registro_equipo.png)

* _Registrar Elemento._

_¿Cómo registrar un elemento?_

1. Ingresar el nombre del elemento a registrar.

2. Seleccionar el tipo del elemento.

3. Ingresar la descripción del elemento en cuestión.

4. Clic en el botón "Registrar".

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Registro_Elemento.png)

* _Registrar Laboratorio._

_¿Cómo registrar un laboratorio?_

1. Ingresar un identificador para el laboratorio.

2. Ingresar el nombre del laboratorio.

3. Seleccionar los equipos que desee asociar al laboratorio (estos se pueden modificar después).

4. Clic en el botón "Registrar".

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Registro_Lab.png)

> **CONSULTAS.**

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosConsulta.png)

* _Consultar Equipo._

_¿Qué encontramos y podemos hacer aquí?_

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Consulta_Equipo.png)

Encontraremos una lista de todos los equipos registrados en la base de datos en el momento junto a tres botones, que funcionaran respecto a los equipos seleccionados en la tabla:

  - Actualizar: Refrescará la información mostrada si es que algún equipo ha sido de baja o algun otro ha sido agregado.
  
  - Ver reporte: Redirigirá a la pagina de reportes de equipo, que mostrará la información de interes de cada equipo y todas las novedades relacionadas a estos (Además de una opción de exportar a Excel esta información).
  
  - Cambiar estado: Cambia el estado de los equipos seleccionados, esta acción requiere presionar el botón de Actualizar después.

En el reporte se encuentran los equipos con estado activo y sus respectivas novedades. Estos reportes se pueden exportar a formato Excel presionando la imagen con el logotipo de Excel.

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_equipo.png)

* _Consultar Elemento._

_¿Qué encontramos y podemos hacer aquí?_

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Consulta_elementos.png)

Encontraremos una lista de todos los elementos disponibles junto a su información de interés junto a dos botones:

  - Actualizar: Refresca la información mostrada en la tabla, en caso de que haya algún cambio de estado en algún elemento o se agregue uno nuevo a la base de datos.
  
  - Ver reporte: Redirige a la página de reporte de elementos en función de los seleccionados, en esta podremos ver la información relevante de estos junto a las novedades relacionadas, además de poder cambiar el estado de estos con el botón "Cambiar Estado", esto requiere presionar el botón "Actualizar" para mostrar la información correcta (Incluye una opción de exportar a Excel esta información).

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_elemento.png)
 
 * _Consultar laboratorios._
 
 _¿Qué encontramos y podemos hacer aquí?_
 
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/consulta_lab.png)

Encontraremos una lista de todos los elementos disponibles junto a su información de interés junto a dos botones que funcionarán respecto a los laboratorios seleccionados en la tabla:

  - Actualizar: Refresca la información mostrada en la tabla, en caso de que haya algún cambio de estado en algún laboratorio o se agregue uno nuevo a la base de datos.
  
  - Ver reporte: Redirige a la página de reporte de laboratorios en función de los seleccionados, en esta podremos ver la información relevante de estos, además de poder cambiar el estado de estos con el botón "Cambiar Estado" (ABIERTO – CERRADO), esto requiere presionar el botón "Actualizar" para mostrar la información correcta (Incluye una opción de exportar a Excel esta información).

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_laboratorio.png)

* _Consultar Novedades._

 _¿Qué encontramos y podemos hacer aquí?_

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/consulta_nov.png)

Encontraremos una lista con todas las novedades generadas a partir de registros, cambios de estado y asociaciones de los objetos utilizados en la aplicación. Además, incluye una opción de exportar a Excel esta información. 

> **ASOCIACIONES**

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosAscociaciones.png)

* _Asociación Elemento – Equipo_

 _¿Cómo asociar elementos a un equipo?_

1. Indicar el identificador del equipo.
2. Seleccionar los elementos para asociar.
3. Clic en el botón "Asociar".
4. Clic en el botón "Actualizar" para refrescar la tabla con la información de las asociaciones hechas previamente. 

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/ASO_elementoEquipo.png)

* _Asociación Equipo – Laboratorio_

 _¿Cómo asociar equipos a un laboratorio?_
 
1. Indicar el identificador del laboratorio.
2. Seleccionar los equipos para asociar.
3. Clic en el botón "Asociar".
4. Clic en el botón "Actualizar" para refrescar la tabla con la información de las asociaciones hechas previamente. 

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/ASO_EquipoLab.png)

--- 

## __Arquitectura y Diseño__ 

### __Modelo E-R__
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/DIAGRAMAS/ER-HistorialEquipos.png)

### __Diagrama de clase__
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/DIAGRAMAS/DiagramaClases.png)

### __Tecnologías utilizadas__

## _Integración continua_ ✔️
[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy)
 
## _Despliegue en Heroku_ 🚀
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://lasrastasdelcalvo.herokuapp.com/)



## __Descripción del proceso:__

## __Integrantes:__

|     Nombre    |     Git         |
|--------------|------------- |
|Ana Gabriela |[gabrielaasilva](https://github.com/gabrielaasilva)   
|Iván Camilo Rincón|[Rincon10](https://github.com/Rincon10 )  |
|Galeano Garzón |[Ersocaut](https://github.com/Ersocaut)   |
|Andrés Pico|[Jandres1420](https://github.com/Jandres1420) |

### __Metodología Utilizada:__

Planeamos todos los sprints en la primera reunión de equipo que tuvimos, discutiendo sobre qué y cómo deberiamos hacer el proyecto.

_¿Cómo ordenamos los sprints?:_

Discutimos entre todo el grupo de trabajo qué tareas deberían hacerse primero, guiandonos tan solo por lo que decían como tal, haciendonos preguntas al estilo _¿Cómo vamos a haer reportes o asociaciones sin antes crear cada objeto?_ lo que después nos llevaría a la siguiente organización:

- Sprint 1:

  - Seguridad: login, accesos y permisos de administrador.
  
  - Creación: equipos, elementos, laboratorios y novedades.
  
- Sprint 2:

  - Asociación: de equipo a laboratorio y de elemento a equipo.
  
  - Eliminar asociación: de elemento a laboratorio.
  
  - Cambiar estado: de elemento, equipo.
  
  - Novedades: cada vez que se realice alguna de las acciones mencionadas anteriormente.

- Sprint 3:

  - Eliminar asociación: de equipo a laboratorio.
  
  - Cambiar estado: de laboratorio.
  
  - Novedades: cada vez que se realice alguna de las acciones mencionadas anteriormente.
  
  - Reportes: de laboratorio, equipo y elemento, exportar a excel.
  
  - UI: mejoras del aspecto visual de la página web.

### __Taiga__

Enlace de [Taiga](https://tree.taiga.io/project/gabrielaasilva-historial-de-equipos-labinfo/timeline) para ver el seguimiento y manejo que dimos al proyecto. 

### __Release-Burndown Chart:__

#### __Sprint1:__
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/SPRINT1.png)

* Backlog

 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/Backlog%20Sprint1.png)

#### __Sprint2:__

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/SPRINT2.png)

* Backlog

 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/Backlog%20Sprint2.png)

#### __Sprint3:__

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/SPRINT3.png)

* Backlog

 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/Backlog%20Sprint3.png)

### __Reporte De Pruebas:__

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/JACOCO/ReporteJacoco2.png)

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/JACOCO/ReporteJacoco1.png)

### __Reporte de análisis estático de código:__

#### _Calidad del código_ 👨‍💻
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a06a6e2b3c104857975f54fcb1997d68)](https://www.codacy.com/gh/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy&amp;utm_campaign=Badge_Grade)
