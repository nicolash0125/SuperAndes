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
		
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaVenta()+"(NUMEROVENTA,TIPODOCCLIENTE,NUMDOCCLIENTE,TOTALVENTA,FECHAVENTA,IDSUCURSAL) values (?,?,?,?,?,?)");
		q.setParameters(numeroVenta, tipoDoc, numDoc, precioTotal, fecha, sucursal);
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
}
