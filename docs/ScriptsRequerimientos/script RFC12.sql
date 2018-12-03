select  sum(cantidad) AS cantidadtotal , ventaproducto.codigoproducto as prod
from  ventaproducto inner join venta on ventaproducto.numeroventa = venta.numeroventa  AND to_number (to_char(to_date( venta.fechaventa,'DD-MM-YYYY'),'WW')) = 41
and to_number (to_char(to_date( venta.fechaventa,'DD-MM-YYYY'),'YYYY')) = 18
GROUP by ventaproducto.codigoproducto
order by cantidadtotal DESC;

select  count(proveedor.nit) as cantidadtotal , proveedor.nit as nit
from  pedido inner join proveedor on pedido.nitproveedor = proveedor.nit  and to_number(to_char(to_date( pedido.fechaentrega ,'DD-MM-YYYY'),'WW')) = 45
and to_number (to_char(to_date( pedido.fechaentrega,'DD-MM-YYYY'),'YYYY')) = 18
group by proveedor.nit 
order by cantidadtotal DESC; 