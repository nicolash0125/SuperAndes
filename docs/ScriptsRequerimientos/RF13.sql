--Agregar productos al carrito del cliente X
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-5 WHERE idProducto='57d9b18e';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','1234567',5,0,'57d9b18e');
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-3 WHERE idProducto='1a1b593ae';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','1234567',3,0,'1a1b593ae');
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-6 WHERE idProducto='239109cc6';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','1234567',6,0,'239109cc6');
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-7 WHERE idProducto='113a25be9';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','1234567',7,0,'113a25be9');
--Agregar productos al carrito del cliente Y
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-2 WHERE idProducto='1a1b593ae';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','8765',2,0,'1a1b593ae');
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-5 WHERE idProducto='cf88a7b7';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','8765',5,0,'cf88a7b7');
UPDATE ESTANTEPRODUCTO SET cantidad=cantidad-3 WHERE idProducto='10893f3ea';
INSERT INTO CARRITO(tipoDocumento,numDocumento,cantidad, abandonado ,producto) VALUES ('CC','8765',3,0,'10893f3ea');

commit;