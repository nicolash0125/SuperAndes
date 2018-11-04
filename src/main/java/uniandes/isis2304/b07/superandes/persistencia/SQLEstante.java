package uniandes.isis2304.b07.superandes.persistencia;

import java.math.BigInteger;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLEstante {
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
	public SQLEstante (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	public long insertarEstante(PersistenceManager pm, long idEstante, long idSucursal, double capacidadVolumen,
			double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + " ESTANTE " + "(idsucursal, idestante,capacidadvolumen,capacidadtotalvolumen,capacidadpeso,capacidadtotalpeso) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idSucursal, idEstante, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);
        return (long) q.executeUnique();
	}

	public long tomarProducto(PersistenceManager pm,long idEstante, String idProducto, int cantidad) {
		
		Query q = pm.newQuery(SQL, "UPDATE " + " ESTANTEPRODUCTO " + "SET cantidad=cantidad-? WHERE idEstante = ? AND idProducto = ? ");
        q.setParameters(cantidad, idEstante, idProducto);
        return (long) q.executeUnique();
	}

	public long devolverProducto(PersistenceManager pm, long idEstante, String idProducto, int cantidad) {
		Query q = pm.newQuery(SQL, "UPDATE " + " ESTANTEPRODUCTO " + "SET cantidad=cantidad+? WHERE idEstante = ? AND idProducto = ? ");
        q.setParameters(cantidad, idEstante, idProducto);
        return (long) q.executeUnique();
	}

	
	public long devolverProductoPrimerEstante(PersistenceManager pm, String idProducto, int cantidad) {
		Query q = pm.newQuery(SQL, "UPDATE " + " ESTANTEPRODUCTO " + "SET cantidad=cantidad+? WHERE   idProducto = ? ");
        q.setParameters(cantidad, idProducto);
        return (long) q.executeUnique();
	}
	
}
