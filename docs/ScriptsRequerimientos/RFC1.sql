INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (1,'CC','1234567',TO_DATE('2018/10/10','yyyy/mm/dd'),50,5,1);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (2,'CC','8765',TO_DATE('2018/10/11','yyyy/mm/dd'),80,8,1);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (3,'CC','9876543',TO_DATE('2018/10/15','yyyy/mm/dd'),80,8,1); 

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (4,'CC','7654',TO_DATE('2018/10/22','yyyy/mm/dd'),90,9,1);
    

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (5,'CC','89765456',TO_DATE('2018/10/17','yyyy/mm/dd'),500,50,2);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (6,'CC','8765',TO_DATE('2018/11/11','yyyy/mm/dd'),850,85,2);

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (7,'CC','8765',TO_DATE('2018/11/12','yyyy/mm/dd'),80,8,2); 

INSERT INTO VENTA (numeroVenta,tipoDocCliente,numDocCliente,fechaVenta,total,totalImpuestos,sucursal) 
    VALUES (8,'CC','8765',TO_DATE('2018/10/12','yyyy/mm/dd'),10,1,2);
    
--SELECT * FROM CLIENTE;
SELECT sucursal, sum(total) FROM venta WHERE fechaventa BETWEEN TO_DATE('2018/9/12','yyyy/mm/dd') AND TO_DATE('2018/12/12','yyyy/mm/dd') GROUP BY sucursal;
commit;