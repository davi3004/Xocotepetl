/*
Tabla principal
*/
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

/*
Tabla mientras se compra
*/
DROP TABLE IF EXISTS Ventas;

CREATE TABLE Ventas (
  ID_Producto INT,
  Nombre VARCHAR(50),
  Precio DECIMAL(6,2),
  Cantidad INT
);

LOCK TABLES `ventas` WRITE;

UNLOCK TABLES;


/*
Tabla ticket
*/
DROP TABLE IF EXISTS ticket;

CREATE TABLE ticket (
  ID_Transaccion INT,
  Nombre VARCHAR(50),
  Precio DECIMAL(6,2),
  Cantidad INT,
  Semitotal DECIMAL(6,2)
);

LOCK TABLES `ticket` WRITE;

UNLOCK TABLES;

/*
Tabla de historial de ventas
*/
DROP TABLE IF EXISTS historial;

CREATE TABLE historial (
  ID_Transaccion INT,
  Nombre VARCHAR(50),
  Precio DECIMAL(6,2),
  Cantidad INT,
  Semitotal DECIMAL(6,2)
);

LOCK TABLES `historial` WRITE;

UNLOCK TABLES;