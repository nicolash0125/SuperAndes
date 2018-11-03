package uniandes.isis2304.b07.superandes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLPedido {
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
	public SQLPedido (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	
	public long adicionarPedido(PersistenceManager pm, long codigoPedido, String idSucursal, String nitProveedor, Timestamp fechaPrevista, double precioTotal) {
		Query q = pm.newQuery(SQL, "INSERT INTO" + " PEDIDO "+"(CODIGOPEDIDO,FECHAENTREGA,PRECIOTOTAL,ESTADOORDEN, NITPROVEEDOR,IDSUCURSAL) values (?,?,?,'En proceso',?,?)");
		q.setParameters(codigoPedido, fechaPrevista,precioTotal,nitProveedor, idSucursal);
		return (long) q.executeUnique();	
	}

	public long consolidarPedidos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
