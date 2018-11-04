INSERT INTO VENTA (NUMEROVENTA,TIPODOCCLIENTE,NUMDOCCLIENTE,FECHAVENTA,TOTAL,TOTALIMPUESTOS,SUCURSAL) 
    VALUES (1,'CC','1234567',TO_DATE('2018/11/10','yyyy/mm/dd'),50000,3400,1);
INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (2,'CC','1234567',TO_DATE('2018/10/10','yyyy/mm/dd'),50,5,1);
INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (3,'CC','8765',TO_DATE('2018/10/11','yyyy/mm/dd'),80,8,1);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (4,'CC','9876543',TO_DATE('2018/10/15','yyyy/mm/dd'),80,8,1); 

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (5,'CC','8765',TO_DATE('2018/10/22','yyyy/mm/dd'),90,9,1);
    

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (6,'CC','8765',TO_DATE('2018/10/17','yyyy/mm/dd'),500,50,2);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (7,'CC','8765',TO_DATE('2018/11/11','yyyy/mm/dd'),850,85,2);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (8,'CC','8765',TO_DATE('2018/11/12','yyyy/mm/dd'),80,8,2); 

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (9,'CC','8765',TO_DATE('2018/10/12','yyyy/mm/dd'),10,1,2);
commit;