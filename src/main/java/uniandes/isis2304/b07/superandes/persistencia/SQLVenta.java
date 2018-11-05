package uniandes.isis2304.b07.superandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.b07.superandes.negocio.Venta;

public class SQLVenta {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLVenta (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarVenta(PersistenceManager pm, long sucursal, long numeroVenta, String tipoDoc,
			String numDoc, double precioTotal, Timestamp fecha) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO " + " VENTA "+"(NUMEROVENTA,TIPODOCCLIENTE,NUMDOCCLIENTE,TOTAL,TOTALIMPUESTOS,FECHAVENTA,SUCURSAL) values (?,?,?,?,?,?,?)");
		q.setParameters(numeroVenta, tipoDoc, numDoc, precioTotal, (precioTotal*0.19), fecha, sucursal);
		return (long) q.executeUnique();
	}

	public List<Object[]> obtenerDineroRecolectado(PersistenceManager pm, Timestamp fechaInicio, Timestamp fechaFin) {
		
		Query q = pm.newQuery(SQL, "SELECT sucursal, sum(total) FROM venta "
				+ "WHERE fechaventa BETWEEN ? AND ? "
				+ "GROUP BY sucursal");
		q.setParameters(fechaInicio, fechaFin);
		return (List<Object[]>) q.executeList();
		
	}

	public List<Venta> obtenerVentasDeCliente(PersistenceManager pm, String tipoDocumento, long numeroCliente, Timestamp fechaInicio,
			Timestamp fechaFin) {
		Query q = pm.newQuery(SQL, "SELECT * FROM VENTA WHERE tipoDocCLiente = ?"
				+ " AND numDocCliente= ? AND "
				+ "fechaVenta BETWEEN ? AND ?");
		q.setParameters(tipoDocumento, numeroCliente, fechaInicio, fechaFin);
		q.setResultClass(Venta.class);
		return (List<Venta>) q.executeList();
	}
	
	public void adicionarProductoAVenta(PersistenceManager pm, long numeroVenta, String codigoProducto,int cantidad){
		Query q = pm.newQuery(SQL, "INSERT INTO " + " VENTAPRODUCTO "+"(NUMEROVENTA,CODIGOPRODUCTO,CANTIDAD) values (?,?,?)");
		q.setParameters(numeroVenta, codigoProducto, cantidad);
		q.executeUnique();
	}

	public List<Object[]> analizarCantidadMax(PersistenceManager pm, Timestamp fechaInicio, Timestamp fechaFin) {
		Query q = pm.newQuery(SQL, ""
				+ "SELECT t1.SUCURSAL, t1.CANTMAX, t1.codigoProducto, t2.fechaVENTA FROM "
				+ " ( "
				+ " SELECT  sucursal,MAX(cantt) as CANTMAX ,codigoProducto FROM "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM "
				+ " ( "
				+ "	SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
				+ " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
				+ " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
				+ " WHERE v.fechaVenta BETWEEN ? AND ? "
				+ " ) "
				+ " GROUP BY sucursal,fechaVenta,codigoProducto "
				+ " ) "
				+ " GROUP BY sucursal,codigoProducto "
				+ "  ) t1 "
				+ "  INNER JOIN "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM "
				+ " ( "
				+ " SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
                + " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
                + " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
                + " WHERE v.fechaVenta BETWEEN ? AND ? "
                + " ) "
                + " GROUP BY sucursal,fechaVenta,codigoProducto "
                + " ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.cantMax=t2.cantt "
                + " ORDER BY t1.sucursal ");
		q.setParameters(fechaInicio, fechaFin, fechaInicio,fechaFin);
		return (List<Object[]>) q.executeList();
	}

	public List<Object[]> analizarPrecioMax(PersistenceManager pm, Timestamp fechaInicio, Timestamp fechaFin) {
		Query q = pm.newQuery(SQL, ""
				+ "SELECT t1.SUCURSAL, t1.MAXPRE, t1.codigoProducto, t2.fechaVENTA FROM "
				+ " ( "
				+ " SELECT  sucursal,MAX(SUMPRECIONETO) as MAXPRE ,codigoProducto FROM  "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) as SUMPRECIONETO FROM "
				+ " ( "
				+ "	SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
				+ " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
				+ " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
				+ " WHERE v.fechaVenta BETWEEN ? AND ? "
				+ " ) "
				+ " GROUP BY sucursal,fechaVenta,codigoProducto "
				+ " ) "
				+ " GROUP BY sucursal,codigoProducto "
				+ "  ) t1 "
				+ "  INNER JOIN "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, SUM(PRECIONETO) AS SUMPRECIONETO FROM "
				+ " ( "
				+ " SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
                + " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
                + " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
                + " WHERE v.fechaVenta BETWEEN ? AND ? "
                + " ) "
                + " GROUP BY sucursal,fechaVenta,codigoProducto "
                + " ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.MAXPRE=t2.SUMPRECIONETO "
                + " ORDER BY t1.sucursal ");
		q.setParameters(fechaInicio, fechaFin, fechaInicio,fechaFin);
		return (List<Object[]>) q.executeList();
	}

	public List<Object[]> analizarCantidadMin(PersistenceManager pm, Timestamp fechaInicio, Timestamp fechaFin) {
		Query q = pm.newQuery(SQL, ""
				+ "SELECT t1.SUCURSAL, t1.CANTMIN, t1.codigoProducto, t2.fechaVENTA FROM "
				+ " ( "
				+ " SELECT  sucursal,MIN(cantt) as CANTMIN ,codigoProducto FROM "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM "
				+ " ( "
				+ "	SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
				+ " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
				+ " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
				+ " WHERE v.fechaVenta BETWEEN ? AND ? "
				+ " ) "
				+ " GROUP BY sucursal,fechaVenta,codigoProducto "
				+ " ) "
				+ " GROUP BY sucursal,codigoProducto "
				+ "  ) t1 "
				+ "  INNER JOIN "
				+ " ( "
				+ " SELECT sucursal,fechaVenta, codigoProducto, sum(CANTIDAD) as CantT, SUM(PRECIONETO) FROM "
				+ " ( "
				+ " SELECT v.NumeroVenta,vp.codigoproducto, vp.cantidad, ps.preciounitario*vp.cantidad AS PrecioNeto,v.fechaventa ,v.sucursal "
                + " FROM VENTA v INNER JOIN VENTAPRODUCTO vp "
                + " ON v.numeroventa=vp.numeroventa INNER JOIN productoofrecidosucursal ps "
                + " ON ps.codigobarras=vp.codigoproducto AND ps.idsucursal=v.sucursal "
                + " WHERE v.fechaVenta BETWEEN ? AND ? "
                + " ) "
                + " GROUP BY sucursal,fechaVenta,codigoProducto "
                + " ) t2 ON t1.sucursal=t2.sucursal AND t1.codigoProducto=t2.codigoProducto AND t1.cantMin=t2.cantt "
                + " ORDER BY t1.sucursal ");
		q.setParameters(fechaInicio, fechaFin, fechaInicio,fechaFin);
		return (List<Object[]>) q.executeList();
	}
	
	public List<Object[]> darClientesFrecuentes (PersistenceManager pm, long sucursal)
	{
		Query q = pm.newQuery(SQL,""
				+"Select numCompras, documento, numero "
				+"FROM(SELECT  COUNT(numeroventa) AS  numCompras , tipodoccliente as documento,numdoccliente as numero "
				+"FROM "
				+"(SELECT min (fechaventa) as minimo FROM   venta) fechaIni ,(SELECT max (fechaventa) as maximo FROM   venta) fechaFin , venta "
				+"WHERE venta.fechaventa BETWEEN  minimo AND maximo AND venta.sucursal = ?  "
				+"GROUP BY numdoccliente, tipodoccliente) numComprasEnSucPorCliente , "
				+"(SELECT MONTHS_BETWEEN  (TO_DATE(maximo,'MM-DD-YYYY'),    TO_DATE(minimo,'MM-DD-YYYY') ) as meses "
				+"FROM "
				+"(SELECT min (fechaventa) as minimo FROM   venta) fechaIni ,(SELECT max (fechaventa) as maximo FROM   venta) fechaFin ) diffEnMeses "	
				+" WHERE NUMCOMPRAS>= (meses -0.04)*0 ");
		q.setParameters(sucursal);
		return (List<Object[]>) q.executeList();
				
	}
}
