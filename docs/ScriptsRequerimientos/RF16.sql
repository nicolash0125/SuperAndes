--Abandona carrito cliente X
UPDATE CARRITO SET abandonado=1  WHERE   tipoDocumento='CC' AND numDocumento ='1234567';
--Abandona carrito del cliente Y
UPDATE CARRITO SET abandonado=1  WHERE   tipoDocumento='CC' AND numDocumento ='8765';
commit;
