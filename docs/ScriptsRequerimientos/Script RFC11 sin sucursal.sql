
Select cliente.tipodocumento as tipo , cliente.numdocumento as numero, cliente.poseecarro as carro
FROM (
    select venta.sucursal as sucursal ,venta.numeroventa as numventa, venta.tipodoccliente as doc, venta.numdoccliente as numero, venta.fechaventa as fechaventa , 
    ventaproducto.codigoproducto as prod,ventaproducto.cantidad as cantidad
    from (venta inner join ventaproducto on venta.numeroventa = ventaproducto.numeroventa)
    where ventaproducto.codigoproducto != '57d9b18e'  
    )vep inner join cliente on vep.doc = cliente.tipodocumento and vep.numero= cliente.numdocumento
where vep.fechaventa > '01/01/2000' and vep.fechaventa < '01/11/2020'
order by vep.cantidad