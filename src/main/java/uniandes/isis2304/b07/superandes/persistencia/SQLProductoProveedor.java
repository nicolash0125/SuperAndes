package uniandes.isis2304.b07.superandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProductoProveedor {
	/* **********************
	 * 			Constantes
	 ***********************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acÃ¡ para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* **********************
	 * 			Atributos
	 ***********************/
	/**
	 * El manejador de persistencia general de la aplicaciÃ³n
	 */
	private PersistenciaSuperAndes pp;

	/* **********************
	 * 			Metodos
	 ***********************/

	public SQLProductoProveedor(PersistenciaSuperAndes persistenciaSuperAndes) {
		this.pp =persistenciaSuperAndes;
	}
	
	public List<Object []> darProductosDeProveedor(PersistenceManager pm,String nit)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM PROVEEDORPRODUCTO suc INNER JOIN PRODUCTO prod ON suc.codigobarras=prod.codigodebarras"
		+"WHERE nitProveedor = ?;" );
		q.setParameters(nit);
		return q.executeList();
	}

}
