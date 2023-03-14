# Xocotepetl
Actividad de aprendizaje 14. Desarrolla un proyecto que administre una base de datos.

---

##  Integrantes: 
+ David Nájera Escobar    
+ Fabiola Ramírez Negrete
+ Sergio Eduardo Islas Romero     

---

## Nombre del sistema

Xocotepetl

---

## Descripción breve de la problemática

El dueño de una chocolatería llamada Xocotepetl tiene dificultades para mantener el control del inventario de su negocio. Actualmente, lleva el registro de los productos y el inventario de forma manual en una hoja de cálculo, lo que hace que el proceso sea propenso a errores y poco eficiente.

---

## Solución propuesta

Se propone desarrollar un sistema de inventario automatizado llamado Xocotepetl, que permita al dueño de la chocolatería llevar un registro preciso y eficiente del inventario de su negocio. El sistema permitirá agregar, editar y eliminar productos del inventario, y también permitirá calcular el costo total de los productos que se van a llevar y generar un ticket de compra para el cliente.

El menú que se tomará en cuenta para la creación de la base de datos será el siguiente

![Menu](https://github.com/davi3004/Xocotepetl/blob/main/imgs/menu1.jpg)
![Menu](https://github.com/davi3004/Xocotepetl/blob/main/imgs/menu%201.jpg)

---

## Diagrama de la base de datos

El diagrama de la base de datos será el siguiente: 

![Diagrama de la base de datos](https://github.com/davi3004/Xocotepetl/blob/main/imgs/diagrama%20de%20base%20de%20datos.jpg)

Las tablas que tendrá serán las siguientes:

### Tabla chocolateria

Esta tabla tendrá el inventario, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.

![Tabla chocolateria](https://github.com/davi3004/Xocotepetl/blob/main/imgs/chcolater%C3%ADa%20tabla.jpg)

### Tabla ventas

Esta tabla tendrá el las ventas al momento, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.

![Tabla ventas](https://github.com/davi3004/Xocotepetl/blob/main/imgs/ventas%20tabla.jpg)

---

## Código de base de datos

Ahora bien, el código fuente de la base de datos es el siguiente.

```
DROP TABLE IF EXISTS Chocolateria;

CREATE TABLE Chocolateria (
  ID_Producto INT,
  Nombre VARCHAR(50),
  Descripcion VARCHAR(200),
  Precio DECIMAL(6,2)
);

LOCK TABLES `Chocolateria` WRITE;

INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (213, 'Frappé', 'Bebida helada con consistencia espesa semejante a la de un helado.', 46.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (543, 'Té', 'Infusión herbal de la planta Camellia Sinensis, se puede preparar frío o caliente.', 34.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (657, 'Chocolate caliente', 'Bebida preparada a base de leche y chocolate blanco u oscuro.', 34.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (546, 'Dona', 'Bollo con forma de anillo con glaseado de glass, chocolate o maple.', 17.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (765, 'Galleta', 'Masa crujiente sabor a vainilla con chispas de chocolate belga o avena con pasas.', 15.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (234, 'Bellini', 'Pastelito individual sabor 3 chocolates sellado con mousse de chocolate.', 49.00);
INSERT INTO `Chocolateria` (ID_Producto, Nombre, Descripcion, Precio) VALUES (246, 'Muffin', 'Panquesito suave con sabor a chocolate con chispas o vainilla con mora azul.', 39.00);

UNLOCK TABLES;

DROP TABLE IF EXISTS Ventas;

CREATE TABLE Ventas (
  ID_Producto INT,
  Nombre VARCHAR(50),
  Precio DECIMAL(6,2),
  Cantidad INT
);

LOCK TABLES `ventas` WRITE;

UNLOCK TABLES;
```
Puede descargar la base de datos a través del siguiente enlace, dando [click aquí](https://github.com/davi3004/Xocotepetl/blob/main/Base%20de%20datos%20Xocotepetl.sql).

---

## Limitaciones

Algunas de las limitaciones son las que cuenta el software son las siguientes:
+ Dificultad para almacenar el stock, debido a que son bebidas preparadas, se hacen al momento, es decir no hay posibilidad de hacer el conteo sin los ingredientes.
+ Guardar ventas anteriores, debido a que la base de datos "ventas" se usa para anotar los productos vendidos entonces se borra cada que se sale del programa o se 
imprime el ticket

---

## Software

La clase principal se llama `Xocotepetl.java`

Para usar el software es necesario modificar la siguiente parte del código dentro de la clase `Conexion_interac`.

![Clave](https://github.com/davi3004/Xocotepetl/blob/main/imgs/%C3%ADndice.jpeg)

El apartado que se debe cambiar es donde dice `INSERTE SU LLAVE AQUÍ`.

El software además puede ser ejecutado descargando y configurando todo, para esto recomiendo usar.

+ MySQL
+ Apache NetBeans IDE 17
+ Java: 19.0.2; Java HotSpot(TM) 64-Bit Server VM 19.0.2+7-44

A continuación, se muestra un ejemplo del uso del sistema, este sistema puede ser descargado y ejecutado como se mencionó anteriormente.

### Capturas


