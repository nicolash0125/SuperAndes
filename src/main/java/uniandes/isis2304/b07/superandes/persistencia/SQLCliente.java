package uniandes.isis2304.b07.superandes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCliente {
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
	public SQLCliente (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	

	public long registrarPersonaNatural(PersistenceManager pm, String tipodocumento, String numDocumento, String nombre,
			String correo) {
		Query q = pm.newQuery(SQL, "INSERT INTO" + " PERSONANATURAL "+"(TIPODOCUMENTO,NUMDOCUMENTO,NOMBRE,CORREO) values (?,?,?,?)");
		q.setParameters(tipodocumento,numDocumento,nombre,correo);
		return (long) q.executeUnique();
	}



	public long registrarCliente(PersistenceManager pm, String tipodocumento, String numDocumento) {
		Query q = pm.newQuery(SQL, "INSERT INTO" + " CLIENTE "+"(TIPODOCUMENTO,NUMDOCUMENTO,POSEECARRO) values (?,?,0)");
		q.setParameters(tipodocumento,numDocumento);
		return (long) q.executeUnique();
	}



	public long solicitarCarrito(PersistenceManager pm, String tipoDocumento, String numeroCliente) {
		Query q = pm.newQuery(SQL, "UPDATE " + " CLIENTE "+" SET poseeCarro = 1 WHERE tipoDocumento = ? AND numDocumento = ?");
		q.setParameters(tipoDocumento,numeroCliente);
		return (long) q.executeUnique();
	}

	public long abandonarCarrito(PersistenceManager pm, String tipoDocumento, String numeroCliente) {
		Query q = pm.newQuery(SQL, "UPDATE " + " CLIENTE "+" SET poseeCarro = 0 WHERE tipoDocumento = ? AND numDocumento = ?");
		q.setParameters(tipoDocumento,numeroCliente);
		return (long) q.executeUnique();
	}


	public int tieneCarrito(PersistenceManager pm, String tipoDocumento, String numeroCliente) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + " CLIENTE "+"  WHERE tipoDocumento = ? AND numDocumento = ?");
		q.setParameters(tipoDocumento,numeroCliente);
		Object[] obj=(Object[])q.executeUnique();
		return ((BigDecimal)obj[2]).intValue();
	}
}
