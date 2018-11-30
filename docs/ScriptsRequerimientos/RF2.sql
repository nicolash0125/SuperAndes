﻿-- Primero crearemos las 3 categor�as que se encuentran al crear los estantes, RF6
-- Creamos 3 categorias de prueba
INSERT INTO CATEGORIA (IDCATEGORIA, TIPOCAT) VALUES (1, 'ASEO PERSONAL');
INSERT INTO CATEGORIA (IDCATEGORIA, TIPOCAT) VALUES (2, 'COMPUTADORES');
INSERT INTO CATEGORIA (IDCATEGORIA, TIPOCAT) VALUES (3, 'FRUTAS Y VERDURAS');

-- Vamos creando cada producto y asociandolo con su categoria

-- Productos de aseo personal

INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('57d9b18e', 'Jabon', '1 unidad en caja','Dove', 1,'gr', '125 gr');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('fc9847d6', 'Shampoo','Botella','Pantene',1,'cm3','500 cm3');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('10893f3ea', 'Crema Dental', 'Tubo','Colgate', 1,'cm^3', '100 cm^3');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('239109cc6', 'Crema de afeitar', 'Spray', 'Prestobarba', 1,'cm^3', '300 cm^3');

-- Computadores

INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('cf88a7b7', 'Portatil', 'Caja', 'Asus', 2,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('1a1b593ae', 'Notebook', 'Caja', 'Acer', 2,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('154422331', 'PC Escritorio', 'Caja', 'Dell', 2,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('cfd36e72', 'Portatil', 'Caja', 'Janus', 2,'unidad', '1 unidad');

-- Frutas y verduras

INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('113a25be9', 'Tomate', '1 unidad','Tomatico', 3,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('1fb6498b1', 'Cebolla', '1 unidad','Cebollita', 3,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('fd7a5f75', 'Mazorca', '1 unidad','Mazorquita', 3,'unidad', '1 unidad');
INSERT INTO PRODUCTO (CODIGODEBARRAS, NOMBRE, PRESENTACION, MARCA, CATEGORIA, UNIDADDEMEDIDA, ESPECIFICACIONEMPACADO) VALUES ('4f918bc6', 'Ajo', '1 unidad', 'Ajitos', 3,'unidad', '1 unidad');

--Posteriormente se anaden los productos a  sucursales ya existentes
--Correr RF4

INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (1,'113a25be9',2350,18.8,40,200,450);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (1,'1a1b593ae',12350,188,45,220,550);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (2,'113a25be9',2550,25.8,40,200,250);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (2,'1a1b593ae',16350,198,45,220,450);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (3,'113a25be9',2750,28.8,40,120,200);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (3,'1a1b593ae',1550,192,45,220,400);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (4,'113a25be9',2950,18.8,40,200,453);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (4,'1a1b593ae',1150,188,45,220,557);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (5,'113a25be9',2550,25.8,40,210,230);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (5,'1a1b593ae',18350,188,45,250,480);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (6,'113a25be9',2250,28.8,40,220,234);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (6,'1a1b593ae',1750,142,45,220,403);

INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (1,'57d9b18e',350,18.8,40,200,1450);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (1,'cfd36e72',1002350,188,45,25,55);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (2,'57d9b18e',255,25.8,40,200,2350);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (2,'cfd36e72',1677350,198,45,23,40);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (3,'57d9b18e',750,28.8,40,120,2040);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (3,'cfd36e72',1785550,192,45,20,40);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (4,'57d9b18e',290,18.8,40,200,4503);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (4,'cfd36e72',1135550,188,45,20,57);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (5,'57d9b18e',250,25.8,40,210,2300);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (5,'cfd36e72',1463500,188,45,25,48);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (6,'57d9b18e',220,28.8,40,202,2304);
INSERT INTO PRODUCTOOFRECIDOSUCURSAL (IDSUCURSAL,CODIGOBARRAS,PRECIOUNITARIO,PRECIOUNIDADMEDIDA,NIVELDEREORDEN,CANTIDADRECOMPRA,CANTIDAD) VALUES (6,'cfd36e72',1347500,142,45,20,43);


commit;

