# Xocotepetl v2.0
Actividad de recuperación

---

##  Integrantes: 
+ David Nájera Escobar    
     

---

## Nombre del sistema

Xocotepetl

---

## Descripción breve de la problemática

El dueño de una chocolatería llamada Xocotepetl tiene dificultades para mantener el control del inventario de su negocio. Actualmente, lleva el registro de los productos y el inventario de forma manual en una hoja de cálculo, lo que hace que el proceso sea propenso a errores y poco eficiente. La versión dos ahora cuenta con la posibilidad de visualizar que es lo que se está llevando la persona, así como un historial de todas las compras que se han hecho desde el comienzo del sistema.

---

## Solución propuesta

Se propone desarrollar un sistema de inventario automatizado llamado Xocotepetl, que permita al dueño de la chocolatería llevar un registro preciso y eficiente del inventario de su negocio. El sistema permitirá agregar, editar y eliminar productos del inventario, y también permitirá calcular el costo total de los productos que se van a llevar y generar un ticket de compra para el cliente.

El menú que se tomará en cuenta para la creación de la base de datos será el siguiente

![Menú](https://github.com/davi3004/Xocotepetl/blob/main/imgs/Men%C3%BA.jpg)

---

## Diseño del sistema

Ya una vez que tenemos lo anterior en cuenta, podemos pensar en una posible solución para el problema. Para el sistema a ejecutar, podríamos considerar las siguientes funcionalidades:

+ Registro de ventas: el sistema debería permitir registrar las ventas de enchocolatados y bebidas, retornando un total.
+ Consulta de inventario: el sistema debería consultar en cualquier momento el inventario.

En cuanto a los requerimientos específicos, podemos considerar lo siguiente:

+ Registrar ventas con precio correcto: el sistema debería permitir ingresar el precio de venta de cada producto al momento de registrar la venta, para que el sistema pueda calcular el total de ingresos generados por esa venta.

La experiencia de usuario se podría mostrar de la siguiente manera.

![UX](https://github.com/davi3004/Xocotepetl/blob/main/imgs/ux.png)

---

## Diagrama de la base de datos

El diagrama de la base de datos será el siguiente: 

![Diagrama de la base de datos]()

Las tablas que tendrá serán las siguientes:

### Tabla chocolateria

Esta tabla tendrá el inventario, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.

![Tabla chocolateria](https://github.com/davi3004/Xocotepetl/blob/main/imgs/chcolater%C3%ADa%20tabla.jpg)

### Tabla ventas

Esta tabla tendrá el las ventas al momento, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.

![Tabla ventas](https://github.com/davi3004/Xocotepetl/blob/main/imgs/ventas%20tabla.jpg)

## Tabla chocolateria
Esta tabla tendrá el inventario, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.
 
## Tabla ventas
Esta tabla tendrá las ventas al momento, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas.
 
## Tabla ticket
Esta tabla tendrá las ventas al momento, y sus datos, algunos datos pueden variar de acuerdo con la tabla debido a las pruebas realizadas, esta es la tabla que se muestra al seleccionar carrito en el ticket.

## Tabla historial
La tabla historial cuenta con todas las compras realizadas desde el momento en el que se implementó el sistema.

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
Puede descargar la base de datos a través del siguiente enlace, dando [click aquí](https://github.com/davi3004/Xocotepetl/blob/main/chocolateria.sql).

---

## Limitaciones

Algunas de las limitaciones son las que cuenta el software son las siguientes:
+ Dificultad para almacenar el stock, debido a que son bebidas preparadas, se hacen al momento, es decir no hay posibilidad de hacer el conteo sin los ingredientes.
+ Guardar ventas anteriores, debido a que la base de datos "ventas" se usa para anotar los productos vendidos entonces se borra cada que se sale del programa o se 
imprime el ticket

---
## Errores

El software tiene un error donde está la caja de cobro, al añadir o eliminar un objeto de la tabla salen muchos errores, pero esto no afecta al funcionamiento del sistema. 

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

![Pruebas](https://github.com/davi3004/Xocotepetl/blob/main/imgs/2023-03-13%2019-53-43.gif)

Si desea ver las capturas estáticas puede hacerlo dando click al siguiente enlace.
[Capturas](https://github.com/davi3004/Xocotepetl/blob/main/imgs/Capturas.pdf)

Si desea observar la tarea en el formato solicitado, es decir `.docx` puede descargar el pdf que se encuentra en el siguient enlace.
[Tarea](https://github.com/davi3004/Xocotepetl/blob/main/imgs/Actividad%20de%20aprendizaje%2014%20Desarrolla%20un%20proyecto%20que%20administre%20una%20base%20de%20datos.docx)