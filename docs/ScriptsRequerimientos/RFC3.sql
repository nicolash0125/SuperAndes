INSERT INTO SUCURSAL (IDSUCURSAL,NOMBRE,SEGMENTACION,TAMANO,CIUDAD,DIRECCION) VALUES (100,'Galerias','Psicografica','Grande','Bucaramanga','Calle 45 # 22-31');
--Inserta Categorias
INSERT INTO CATEGORIA (IDCATEGORIA, TIPOCAT) VALUES (100, 'ASEO PERSONAL');
INSERT INTO CATEGORIA (IDCATEGORIA, TIPOCAT) VALUES (200, 'VERDURAS');

--Inserta Bodegas
INSERT INTO BODEGA (IDSUCURSAL,IDBODEGA,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO) VALUES (100, 100, 100, 500,700,500,700);
INSERT INTO BODEGA (IDSUCURSAL,IDBODEGA,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO) VALUES (100, 200, 200, 1000,1000,1300,1500);
INSERT INTO BODEGA (IDSUCURSAL,IDBODEGA,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO) VALUES (100, 300, 100, 500,1600,400,500);
INSERT INTO BODEGA (IDSUCURSAL,IDBODEGA,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO) VALUES (100, 400, 200, 1000,1050,900,1000);
--Inserta Estantes
INSERT INTO ESTANTE (IDSUCURSAL,IDESTANTE,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO,NIVELDEABASTECIMIENTO) VALUES (100, 100, 100, 500,550,500,550,60);
INSERT INTO ESTANTE (IDSUCURSAL,IDESTANTE,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO,NIVELDEABASTECIMIENTO) VALUES (100, 200, 270, 1000,5000,1000,10000,120);
INSERT INTO ESTANTE (IDSUCURSAL,IDESTANTE,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO,NIVELDEABASTECIMIENTO) VALUES (100, 300, 100, 10,550,500,50000,60);
INSERT INTO ESTANTE (IDSUCURSAL,IDESTANTE,CATEGORIA,CAPACIDADVOLUMEN,CAPACIDADTOTALVOLUMEN,CAPACIDADPESO,CAPACIDADTOTALPESO,NIVELDEABASTECIMIENTO) VALUES (100, 400, 200, 100,101,1000,1001,120);


    SELECT idEstante as id_elemento,'ESTANTE' AS TIPO, 100*CAPACIDADVOLUMEN / CAPACIDADTOTALVOLUMEN as INDICE_VOLUMEN, 100*CAPACIDADPESO / CAPACIDADTOTALPESO as INDICE_PESO FROM ESTANTE WHERE idsucursal=100 UNION ALL SELECT idBodega as id_elemento,'BODEGA' AS TIPO, 100 * CAPACIDADVOLUMEN / CAPACIDADTOTALVOLUMEN AS INDICE_VOLUMEN, 100 * CAPACIDADPESO / CAPACIDADTOTALPESO as INDICE_PESO FROM BODEGA WHERE idsucursal=100
;
commit;

