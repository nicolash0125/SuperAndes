SELECT atb.table_name,atb.column_name,atb.data_type,atb.data_length, ac.search_condition,ac.search_condition_vc FROM ALL_TAB_COLUMNS atb INNER JOIN ALL_CONSTRAINTS ac ON atb.table_name= ac.table_name WHERE atb.OWNER='ISIS2304B161820' ;
SELECT COUNT(*) AS NUM_BODEGAS FROM BODEGA;
SELECT COUNT(*) AS NUM_CLIENTES FROM CLIENTE;
SELECT COUNT(*) AS NUM_CATEGORIAS FROM CATEGORIA;
SELECT COUNT(*) AS NUM_ESTANTES FROM ESTANTE;
SELECT COUNT(*) AS NUM_PERSONANATURAL FROM PERSONANATURAL;
SELECT COUNT(*) AS NUM_PERSONAJURIDICA FROM PERSONAJURIDICA;
SELECT COUNT(*) AS NUM_PRODUCTO FROM PRODUCTO;
SELECT COUNT(*) AS NUM_PRODUCTOOFRECIDOS FROM PRODUCTOOFRECIDOSUCURSAL;
SELECT COUNT(*) AS NUM_PROVEEDOR FROM PROVEEDOR;
SELECT COUNT(*) AS NUM_SUCURSAL FROM SUCURSAL;
SELECT COUNT(*) AS NUM_VENTA FROM VENTA;
SELECT COUNT(*) AS NUM_VENTAPRODUCTO FROM VENTAPRODUCTO;
SELECT COUNT(*) AS NUM_PEDIDOS FROM PEDIDO;