package uniandes.isis2304.b07.superandes.persistencia;

import javax.jdo.PersistenceManager;

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

	public long anadirProducto(PersistenceManager pm, String tipoDocumento, long numeroCliente, long idProducto,
			int cantidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long eliminarProducto(PersistenceManager pm, String tipoDocumento, long numeroCliente, long idProducto,
			int cantidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long pagarCarrito(PersistenceManager pm, String tipoDocumento, long numeroCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long abandonarCarrito(PersistenceManager pm, String tipoDocumento, long numeroCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long recolectarProductosAbandonados(PersistenceManager pm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
