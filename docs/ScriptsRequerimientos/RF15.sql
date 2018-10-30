--cliente X realiza el pago
DELETE FROM CARRITO WHERE   tipoDocumento='CC' AND numDocumento ='1234567';
--cliente Y realiza el pago
DELETE FROM CARRITO WHERE   tipoDocumento='CC' AND numDocumento ='8765';
commit;