package uniandes.isis2304.b07.superandes.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLFactura {

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
	public SQLFactura(PersistenciaSuperAndes persistenciaSuperAndes)
	{
		this.pp = persistenciaSuperAndes;
	}
	
	public List<Object[]> darInfoUsuarioQueCompraronProdConSucursal(PersistenceManager pm, String producto, long sucursal, String orden,  Timestamp fechaInicio, Timestamp fechaFin)
	{
		Query q = pm.newQuery(SQL, "Select cliente.tipodocumento as tipo , cliente.numdocumento as numero, cliente.poseecarro as carro"
		+" FROM ("
		+"    select venta.sucursal as sucursal ,venta.numeroventa as numventa, venta.tipodoccliente as doc, venta.numdoccliente as numero, venta.fechaventa as fechaventa ," 
		+"	ventaproducto.codigoproducto as prod,ventaproducto.cantidad as cantidad"
		+"   from (venta inner join ventaproducto on venta.numeroventa = ventaproducto.numeroventa)"
		+"   where ventaproducto.codigoproducto = ? and venta.sucursal = ? "
		+"    )vep inner join cliente on vep.doc = cliente.tipodocumento and vep.numero= cliente.numdocumento"
		+" where vep.fechaventa > ? and vep.fechaventa < ? "
		+" Order by ? " );
		q.setParameters(producto,sucursal,fechaInicio, fechaFin, orden);
		return q.executeList();
	}
	
	public List<Object[]> darInfoUsuarioQueCompraronProd(PersistenceManager pm, String producto,  String orden,  Timestamp fechaInicio, Timestamp fechaFin)
	{
		Query q = pm.newQuery(SQL, "Select cliente.tipodocumento as tipo , cliente.numdocumento as numero, cliente.poseecarro as carro "
		+" FROM ( "
		+"   select venta.sucursal as sucursal ,venta.numeroventa as numventa, venta.tipodoccliente as doc, venta.numdoccliente as numero, venta.fechaventa as fechaventa , " 
		+"	 ventaproducto.codigoproducto as prod,ventaproducto.cantidad as cantidad "
		+"   from (venta inner join ventaproducto on venta.numeroventa = ventaproducto.numeroventa) "
		+"   where ventaproducto.codigoproducto = ? "
		+"   )vep inner join cliente on vep.doc = cliente.tipodocumento and vep.numero= cliente.numdocumento "
		+" where vep.fechaventa > ? and vep.fechaventa < ? "
		+" Order by ? " );
		q.setParameters(producto,fechaInicio, fechaFin, orden);
		return q.executeList();
	}
	
	public List<Object[]> darInfoUsuarioQueNoCompraronProdConSucursal(PersistenceManager pm, String producto, long sucursal, String orden,  Timestamp fechaInicio, Timestamp fechaFin)
	{
		Query q = pm.newQuery(SQL, "Select cliente.tipodocumento as tipo , cliente.numdocumento as numero, cliente.poseecarro as carro"
		+" FROM ("
		+"    select venta.sucursal as sucursal ,venta.numeroventa as numventa, venta.tipodoccliente as doc, venta.numdoccliente as numero, venta.fechaventa as fechaventa ," 
		+"	ventaproducto.codigoproducto as prod,ventaproducto.cantidad as cantidad"
		+"   from (venta inner join ventaproducto on venta.numeroventa = ventaproducto.numeroventa)"
		+"   where ventaproducto.codigoproducto != ? and venta.sucursal = ?"
		+"    )vep inner join cliente on vep.doc = cliente.tipodocumento and vep.numero= cliente.numdocumento"
		+" where vep.fechaventa > ? and vep.fechaventa < ?"
		+" Order by ?" );
		q.setParameters(producto,sucursal,fechaInicio, fechaFin, orden);
		return q.executeList();
	}
	
	public List<Object[]> darInfoUsuarioQueNoCompraronProd(PersistenceManager pm, String producto,  String orden,  Timestamp fechaInicio, Timestamp fechaFin)
	{
		Query q = pm.newQuery(SQL, "Select cliente.tipodocumento as tipo , cliente.numdocumento as numero, cliente.poseecarro as carro"
		+" FROM ("
		+"   select venta.sucursal as sucursal ,venta.numeroventa as numventa, venta.tipodoccliente as doc, venta.numdoccliente as numero, venta.fechaventa as fechaventa ," 
		+"	 ventaproducto.codigoproducto as prod,ventaproducto.cantidad as cantidad"
		+"   from (venta inner join ventaproducto on venta.numeroventa = ventaproducto.numeroventa)"
		+"   where ventaproducto.codigoproducto != ? "
		+"   )vep inner join cliente on vep.doc = cliente.tipodocumento and vep.numero= cliente.numdocumento"
		+" where vep.fechaventa > ? and vep.fechaventa < ? "
		+" Order by ? " );
		q.setParameters(producto,fechaInicio, fechaFin, orden);
		return (List<Object[]>)q.executeList();
	}

}
