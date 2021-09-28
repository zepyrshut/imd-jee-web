# imd-jee-web  

## Instituto municipal de deportes

- Proyecto perteneciente al curso de programación *fullstack* impartido por Arelance.

Consiste en hacer un portal web en el que los usuarios pueda apuntarse a distintas actividades deportivas que se ofertan desde el instituto municipal de deportes (entidad ficticia).

## Características

- La base de datos es relacional. Las entidades-relación están diseñadas cuidadosamente para su correcto funcionamiento.
- Se hace uso de tecnologías de Java Enterprise Edition 8 montado sobre un servidor GlassFish / Payara 5.201.
- Motor de bases de datos MySQL versión 8.0.26.
- No se hace uso de ningún *framework* en el *back-end*.
- Uso del *framework* UIKit para el *front-end*. 

## Para ejecutar este proyecto en tu máquina

### Necesitarás:

- Servidor GlassFish / Payara 5.201.
- Servidor MySQL 8.
- JDK 1.8.
- Uso del esquema de bases de datos denominado: **`dump-imd-202109202239.sql`**, está ubicado en la carpeta *dump*.
- Configurar la conexión a la base de datos en las opciones del servidor, creando un nuevo *data-source*. La unidad de persistencia se llama **`imdPU`**.
- *Clean and build* y probar.

## Autores del proyecto

- [Jorge Hurtado](https://github.com/jorgehurtadodmx)
- [Pedro Pérez](https://github.com/zepyrshut)