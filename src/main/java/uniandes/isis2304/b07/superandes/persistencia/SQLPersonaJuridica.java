package uniandes.isis2304.b07.superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLPersonaJuridica {
	
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
	public SQLPersonaJuridica(PersistenciaSuperAndes pp) {
		this.pp = pp;
	}

	public long adicionarPersonaJuridica(PersistenceManager pm, String documento, String numDocumento,
			String nombre, String direccion) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO" + " PERSONAJURIDICA "+"(TIPODOCUMENTO,NUMDOCUMENTO,NOMBRE,DIRECCION) values (?,?,?,?)");
		q.setParameters(documento,numDocumento,nombre,direccion);
		return (long) q.executeUnique();
	}

}
