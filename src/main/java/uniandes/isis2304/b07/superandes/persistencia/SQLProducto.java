package uniandes.isis2304.b07.superandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLProducto {
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
	public SQLProducto (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarProducto(PersistenceManager pm, String codigoDeBarras, String nombre, String presentacion, String marca, String unidadDeMedida, String especificacionEmpacado, long categoria) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO" + " PRODUCTO "+"(CODIGODEBARRAS,NOMBRE,PRESENTACION,MARCA,UNIDADDEMEDIDA,ESPECIFICACIONEMPACADO, CATEGORIA) values (?,?,?,?,?,?,?)");
		q.setParameters(codigoDeBarras,nombre,presentacion,marca, unidadDeMedida,especificacionEmpacado,categoria);
		return (long) q.executeUnique();
	}
	public List<Object[]> darInfoConCararacteristica(PersistenceManager pm, String caracteristica, double valIni, double valFin)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM PRODUCTOOFRECIDOSUCURSAL suc INNER JOIN PRODUCTO prod ON suc.codigobarras=prod.codigodebarras"
				+"WHERE (?) BETWEEN (?) AND (?);" );
		q.setParameters(caracteristica,valIni, valFin);
		return q.executeList();
	}
}
