SELECT  COUNT(numeroventa) AS  numCompras , tipodoccliente,numdoccliente
FROM venta , (SELECT min (fechaventa) FROM   venta) fechaIni 
WHERE SUCURSAL =1
and fechaventa BETWEEN fechaIni AND '24/12/2018' GROUP BY numdoccliente, tipodoccliente;




