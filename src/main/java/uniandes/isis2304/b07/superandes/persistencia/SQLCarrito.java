package uniandes.isis2304.b07.superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCarrito {
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
	public SQLCarrito (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	public long anadirProducto(PersistenceManager pm, String tipoDocumento, long numeroCliente, String idProducto,
			int cantidad) {
		Query q = pm.newQuery(SQL, "INSERT INTO  " + " CARRITO " + " (tipoDocumento,numDocumento,cantidad,abandonado,producto)"
				+ " VALUES(?,?,?,0,?) ");
        q.setParameters(tipoDocumento, numeroCliente, cantidad,idProducto);
        return (long) q.executeUnique();
	}

	public long eliminarProducto(PersistenceManager pm, String tipoDocumento, long numeroCliente, String idProducto,
			int cantidad) {
		Query q = pm.newQuery(SQL, "UPDATE  " + " CARRITO " + " SET cantidad=cantidad-? WHERE tipoDocumento=? AND numDocumento=? AND producto=?");
        q.setParameters(cantidad, tipoDocumento, numeroCliente,idProducto);
        return (long) q.executeUnique();
	}

	public long pagarCarrito(PersistenceManager pm, String tipoDocumento, long numeroCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long abandonarCarrito(PersistenceManager pm, String tipoDocumento, long numeroCliente) {
		Query q = pm.newQuery(SQL, "UPDATE  " + " CARRITO " + " SET abandonado= 1 WHERE tipoDocumento=? AND numDocumento=? ");
        q.setParameters(tipoDocumento, numeroCliente);
        return (long) q.executeUnique();
	}

	public long recolectarProductosAbandonados(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "DELETE FROM   " + " CARRITO " + " WHERE abandonado=1 ");
        return (long) q.executeUnique();
	}

}
