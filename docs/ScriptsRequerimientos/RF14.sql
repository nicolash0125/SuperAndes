--Devuelve productos del carrito del cliente X

UPDATE ESTANTEPRODUCTO SET cantidad=cantidad+
    (SELECT CANTIDAD FROM CARRITO WHERE tipoDocumento='CC' AND numDocumento ='1234567' AND producto = '57d9b18e')
WHERE idProducto='57d9b18e';
DELETE FROM CARRITO WHERE   tipoDocumento='CC' AND numDocumento ='1234567' AND producto = '57d9b18e';

UPDATE ESTANTEPRODUCTO SET cantidad=cantidad+
    (SELECT CANTIDAD FROM CARRITO WHERE tipoDocumento='CC' AND numDocumento ='1234567' AND producto = '113a25be9')
WHERE idProducto='113a25be9';
DELETE FROM CARRITO WHERE   tipoDocumento='CC' AND numDocumento ='1234567' AND producto = '113a25be9';
--Devuelve productos del carrito del cliente Y

UPDATE ESTANTEPRODUCTO SET cantidad=cantidad+
    (SELECT CANTIDAD FROM CARRITO WHERE tipoDocumento='CC' AND numDocumento ='8765' AND producto = '113a25be9')
WHERE idProducto='113a25be9';
DELETE FROM CARRITO WHERE   tipoDocumento='CC' AND numDocumento ='8765' AND producto = '1a1b593ae';
commit;