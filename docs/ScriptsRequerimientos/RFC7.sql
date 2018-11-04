
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
        


--OBTIENE LA MAYOR CANTIDAD (DEMANDA)
SELECT t1.SUCURSAL, t1.CANTMAX, t1.codigoProducto, t2.fechaVENTA FROM
(
    SELECT  sucursal,MAX(cantt) as CANTMAX ,codigoProducto FROM 
        (
        SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM
            (
            SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
                FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
                ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
                ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal 
                WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
            )
            GROUP BY sucursal,fechaVenta,codigoProducto 
        ) 
        GROUP BY sucursal,codigoProducto
    ) t1 
    INNER JOIN  
    ( 
        SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM
        (
        SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
            FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
            ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
            ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal
            WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
        )
        GROUP BY sucursal,fechaVenta,codigoProducto
    ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.cantMax=t2.cantt

ORDER BY t1.sucursal
;

--OBTIENE MAYOR DINERO 
SELECT t1.SUCURSAL, t1.MAXPRE, t1.codigoProducto, t2.fechaVENTA FROM
(
    SELECT  sucursal,MAX(SUMPRECIONETO) as MAXPRE ,codigoProducto FROM 
        (
        SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) as SUMPRECIONETO FROM
            (
            SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
                FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
                ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
                ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal 
                WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
            )
            GROUP BY sucursal,fechaVenta,codigoProducto 
        ) 
        GROUP BY sucursal,codigoProducto
    ) t1 
    INNER JOIN  
    ( 
        SELECT sucursal,fechaVenta, codigoProducto, SUM(PRECIONETO) AS SUMPRECIONETO FROM
        (
        SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
            FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
            ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
            ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal
            WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
        )
        GROUP BY sucursal,fechaVenta,codigoProducto
    ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.MAXPRE=t2.SUMPRECIONETO

ORDER BY t1.sucursal
;

--OBTIENE LA MENOR CANTIDAD (DEMANDA)
SELECT t1.SUCURSAL, t1.CANTMIN, t1.codigoProducto, t2.fechaVENTA FROM
(
    SELECT  sucursal,MIN(cantt) as CANTMIN ,codigoProducto FROM 
        (
        SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM
            (
            SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
                FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
                ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
                ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal 
                WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
            )
            GROUP BY sucursal,fechaVenta,codigoProducto 
        ) 
        GROUP BY sucursal,codigoProducto
    ) t1 
    INNER JOIN  
    ( 
        SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM
        (
        SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal
            FROM VENTA v INNER JOIN VENTAPRODUCTO vp 
            ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps
            ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal
            WHERE v.fechaVenta BETWEEN TO_DATE('2000/10/12','yyyy/mm/dd') AND TO_DATE('2018/10/13','yyyy/mm/dd')
        )
        GROUP BY sucursal,fechaVenta,codigoProducto
    ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.cantMin=t2.cantt

ORDER BY t1.sucursal
;
