
SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
    FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
        ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
        ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal;


--Obtiene las ventas de un producto y los agrupa segun la sucursal, fecha, acumula las cantidades vendidas y todos los precios        
SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM
(SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
    FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
        ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
        ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal)GROUP BY sucursal,fechaVenta,codigoProducto ;
        
--Obtiene mayor cantidad        
SELECT sucursal,fechaVenta, codigoProducto,MAX(cantT) FROM (SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as as CantT, SUM(PRECIONETO) FROM
(SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
    FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
        ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
        ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal)GROUP BY sucursal,fechaVenta,codigoProducto) GROUP BY cantt,sucursal,fechaVenta,codigoProducto;