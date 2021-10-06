# TODO

- [ ] Permitir a usuario quitarse de una actividad.
- [ ] Añadir método de pago a usuario y que éste pueda seleccionar sólo UNA en el pago de actividad (cambiar `@OneToOne` a `@OneToMany`).
- [ ] Creacion de Error 404.
- [ ] Implementar UIKit en el proyecto (Boostrap a UIKit).
- [ ] Implementar operadores ternarios en todas las condiciones posibles de JSP con EL.
- [ ] Creación de página de contacto y redigir a ella desde información extra de actividad.
- [ ] Cambiar relación `@OneToOne` de actividad - entrenador a `@OneToMany` para permitir que puedan mostrarse más de un entrenador (relación hecha en BBDD).
- [ ] Traducción todo *back-end* al inglés y todo *front-end* al español e inglés (soporte multi-idioma).
- [ ] Deshabilitar todos los enlaces directos redundantes. Si está en *index*, eliminar los enlaces que llevan a *index*.
- [ ] Desahbilitar botón guardar cambios en el perfil de usuario si no hay ninguna modificación.
- [ ] Mover los *scripts* a una carpeta externa, llamar a todo con funciones y uso de *this*.
- [ ] Arreglar enlace de suscripción a actividad.
- [ ] Creación de un controlador principal, que deriva a otros controladores.
- [ ] Resolver el fallo de *nullpointerexception* con el uso del patrón comando. Eliminando dicho patrón, funciona correctamente.

# Ya resuelto

-  [x] Corregir y solucionar el despliegue de Payara.
-  [x] Implementación de CRUD para el usuario.
-  [x] Implementación de CRUD para las actividades.
-  [x] Arreglar todos los conflictos.
-  [x] Aplicación de relación `@manytomany` para relacionar usuario con actividad.
-  [x] Mostrar al usuario 6 actividades por defecto en inicio y dar la opción de ver todas las actividades mediante botón en JS.
-  [x] Usuario ha de poder registrarse en actividad.
-  [x] Aplicar cabecera y pie de página a todas las páginas que lo necesiten.
-  [x] Mostrar descripción individual de actividades mediante clic en su botón correspondiente.
-  [x] Usuario ha de poder modificar su perfil.
