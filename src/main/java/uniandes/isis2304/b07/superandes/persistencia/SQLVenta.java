package uniandes.isis2304.b07.superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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

	public long adicionarVenta(PersistenceManager pm, long numeroVenta, String tipodocumento, String documento,
			double precioTotal) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaVenta()+"(NUMEROVENTA,TIPODOCCLIENTE,NUMDOCCLIENTE,TOTALVENTA) values (?,?,?,?)");
		q.setParameters(numeroVenta,tipodocumento, documento, precioTotal);
		return (long) q.executeUnique();
	}
}
