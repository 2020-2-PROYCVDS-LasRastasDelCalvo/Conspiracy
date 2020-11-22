# Plataforma Historial de Equipos
## CICLOS DE VIDA Y DESARROLLO DE SOFTWARE / 2020-2

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

> **REGISTROS.**

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosRegistro.png)

* _Registro Equipo._
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Registro_equipo.png)

El registro de un equipo consta con que el administrador dé el número del laboratorio al cuál el equipo va a estar asociado y así mismo el identificador con el cuál va a quedar registrado. 

Para que se haga válido el registro de un equipo, se deben seleccionar los cuatro elementos fundamentales para su funcionamiento (Torre, Mouse, Pantalla, Teclado), sin haber hecho esto, la aplicación no dejará hacer el registro.

Esta página también ofrece al administrador la opción de poder registrar un elemento nuevo que necesite.

* _Registro Elemento._
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_elemento.png)

Para el registro de un elemento, se debe ingresar el nombre que se le va a asignar, su tipo y una descripción para conocer mejor la características de este.

* _Registro Laboratorio._
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Registro_Lab.png)

Para el registro de un laboratorio, se debe ingresar su identificador y el nombre. También, tiene la opción de asociar los equipos que desee para ese laboratorio.

> **CONSULTAS.**

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosConsulta.png)

* _Consultar Equipo._
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Consulta_Equipo.png)

Al entrar a la consulta de equipos, encontraremos la tabla de todos lo equipos registrados, cada equipo con su información. Para el cambio de estado de los equipos, se seleccionan los equipos que se quieren cambiar y luego se oprime el botón “Cambiar estado”. También, tenemos la posibilidad de tener un reposte completo de los equipo activos, se obtiene presionando el botón “Reporte”.

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_equipo.png)

En el reporte se encuentran los equipos con estado activo y sus respectivas novedades. Estos reportes se pueden exportar a formato Excel presionando la imagen con el logotipo de Excel.

* _Consultar Elemento._
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Consulta_elementos.png)

Al entrar a la consulta de elementos, se encuentra cada uno de los elementos registrados con su información. En esta página también está la opción de generar un reporte de los elementos que el administrador seleccione, para obtener el reporte se oprime el botón “Ver reporte”.

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/Reporte_elemento.png)

En esta página se encontrará el reporte de los elementos seleccionados anteriormente, de igual forma se podrá cambiar el estado de los elementos (Botón “Cambiar estado”) y ver las novedades correspondientes a estos. Los reportes se pueden exportar a formato Excel presionando la imagen con el logotipo de Excel.
 
 * _Consultar laboratorios. **(FALTA PARTE DE REPORTES PARA COMPLETAR)**_
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/consulta_lab.png)

Al entrar a la consulta de laboratorios, se encuentran los laboratorios registrados con su información. En este mismo espacio se podrá cambiar el estado de los laboratorios seleccionados. (ABIERTO – CERRADO)

* _Consultar Novedades. **(FALTA PARTE DE REPORTES PARA COMPLETAR)**_
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/consulta_nov.png)

Al entrar a la consulta de novedades, se encuentran todas las novedades generadas para los objetos que maneja la aplicación. (Registros, cambios de estado, Asociaciones).

> **ASOCIACIONES**
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/serviciosAscociaciones.png)

* _Asociación Elemento – Equipo_
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/ASO_elementoEquipo.png)

Esta página funciona para asociar elementos previamente registrados a un equipo, se debe escribir el identificador del equipo al que se le quieren asociar los elementos seleccionados de la tabla, para que se haga efectiva la asociación, se debe presionar el botón “Asociar”.

* _Asociación Equipo – Laboratorio_
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/MANUAL%20DE%20USUARIO/ASO_EquipoLab.png)

Esta página funciona para asociar equipos previamente registrados a un laboratorio, se debe escribir el identificador del laboratorio al que se le quieren asociar los equipos seleccionados de la tabla, para que se haga efectiva la asociación, se debe presionar el botón “Asociar”.


**Los botones “Actualizar” en cada una de la páginas tienen la función como su nombre lo indica de actualizar la página con los cambios que se hicieron en ella. (Cambios de estados, asociaciones)** 

--- 

### __Funcionalidades Principales__


## __Arquitectura y Diseño__ 

### __Modelo E-R__

### __Diagrama de clase__


### __Tecnologías utilizadas__

### _Integración continua_ ✔️
[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy)


 
### _Calidad del código_ 👨‍💻
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a06a6e2b3c104857975f54fcb1997d68)](https://www.codacy.com/gh/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy&amp;utm_campaign=Badge_Grade)

 
### _Despliegue en Heroku_ 🚀
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

## __Taiga__
Enlace de [Taiga](https://tree.taiga.io/project/gabrielaasilva-historial-de-equipos-labinfo/timeline) para ver el seguimiento y manejo que dimos al proyecto. 

## __Release-Burndown Chart:__

### __Sprint1:__
![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/SPRINT1.png)

* Backlog

 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/Backlog%20Sprint1.png)

### __Sprint2:__

![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/SPRINT2.png)

* Backlog

 ![](https://github.com/2020-2-PROYCVDS-LasRastasDelCalvo/Conspiracy/blob/main/modelos/SPRINTS/Backlog%20Sprint2.png)

### __Sprint3:__

## __Reporte De Pruebas:__


## __Reporte de análisis estático de código:__
