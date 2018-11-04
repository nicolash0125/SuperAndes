package uniandes.isis2304.b07.superandes.persistencia;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.b07.superandes.negocio.Bodega;
import uniandes.isis2304.b07.superandes.negocio.Cliente;
import uniandes.isis2304.b07.superandes.negocio.DescPorcentajePromo;
import uniandes.isis2304.b07.superandes.negocio.Estante;
import uniandes.isis2304.b07.superandes.negocio.LlegadaPedido;
import uniandes.isis2304.b07.superandes.negocio.Pague1Lleve2ConDescPromo;
import uniandes.isis2304.b07.superandes.negocio.PagueNUnidadesLleveMPromo;
import uniandes.isis2304.b07.superandes.negocio.PagueXCantidadLleveYPromo;
import uniandes.isis2304.b07.superandes.negocio.PaqueteDeProductos;
import uniandes.isis2304.b07.superandes.negocio.Pedido;
import uniandes.isis2304.b07.superandes.negocio.PersonaJuridica;
import uniandes.isis2304.b07.superandes.negocio.Producto;
import uniandes.isis2304.b07.superandes.negocio.Promocion;
import uniandes.isis2304.b07.superandes.negocio.Proveedor;
import uniandes.isis2304.b07.superandes.negocio.Sucursal;
import uniandes.isis2304.b07.superandes.negocio.Venta;




public class PersistenciaSuperAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el �nico objeto de la clase - Patr�n SINGLETON
	 */
	private static PersistenciaSuperAndes instance;

	/**
	 * F�brica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;

	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 */
	private List <String> tablas;


	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;



	/**
	 * Atributos para manejar los sql de las tablas.
	 */

	private SQLBodega sqlBodega;

	private SQLCategoria sqlCategoria;

	private SQLCategoriaProducto sqlCategoriaProducto;

	private SQLCliente sqlCliente;

	private SQLDescPorcentajePromo sqlDescPorcentajePromo;

	private SQLEstante sqlEstante;

	private SQLFactura sqlFactura;

	private SQLLegadaPedido sqlLegadaPedido;

	private SQLPague1Lleve2ConDescPromo sqlPague1Lleve2ConDescPromo;

	private SQLPagueNUnidadesLleveMPromo sqlPagueNUnidadesLleveMPromo;

	private SQLPagueXCantidadLleveYPromo sqlPagueXCantidadLleveYPromo ;

	private SQLPedido sqlPedido;

	private SQLPersonaJuridica sqlPersonaJuridica;

	private SQLProducto sqlProducto;

	private SQLProductoPedido sqlProductoPedido;

	private SQLProductoPromocion sqlProductoPromocion;

	private SQLProductoProveedor sqlProductoProveedor;

	private SQLProductoSucursal sqlProductoSucursal;

	private SQLPromocion sqlPromocion;

	private SQLProveedor sqlProveedor;

	

	private SQLSucursal sqlSucursal;

	private SQLVenta sqlVenta;

	private SQLVentaProducto sqlVentaProducto;

	private SQLCarrito sqlCarrito;


	/* ****************************************************************
	 * 			M�todos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patr�n SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();

		// Define los nombres por defecto de las tablas de la base de datos


		tablas = new LinkedList<String> ();
		tablas.add ("SuperAndes_sequence");
		tablas.add ("BODEGA");
		tablas.add ("CATEGORIA");
		tablas.add ("CATEGORIAPRODUCTO");
		tablas.add ("CLIENTE");
		tablas.add ("DESCPORCENTAJEPROMO");		
		tablas.add ("ESTANTE");
		tablas.add ("FACTURA");
		tablas.add ("LLEGADAPEDIDO");
		tablas.add ("PAGUE1LLEVE2CONDESCPROMO");
		tablas.add ("PAGUENUNIDADESLLEVEMPROMO");		
		tablas.add ("PAGUEXCANTIDADLLEVEYPROMO");
		tablas.add ("PEDIDO");
		tablas.add ("PERSONAJURIDICA");
		tablas.add ("PRODUCTO");
		tablas.add ("PRODUCTOPEDIDO");		
		tablas.add ("PRODUCTOPROMOCION");
		tablas.add ("PRODUCTOPROVEEDOR");
		tablas.add ("PRODUCTOSUCURSAL");
		tablas.add ("PROMOCION");
		tablas.add ("PROVEEDOR");		
		tablas.add ("RESTRICCIONBODEGA");
		tablas.add ("RESTRICCIONESTANTE");
		tablas.add ("SUCURSAL");
		tablas.add ("VENTA");
		tablas.add ("VENTAPRODUCTO");
	}

	public String darSeqParranderos()
	{
		return tablas.get (0);
	}

	public String darTablaBodega()
	{
		return "BODEGA";
	}

	public String darTablaCategoria()
	{
		return tablas.get (2);
	}

	public String darTablaCategoriaProducto()
	{
		return tablas.get (3);
	}


	public String darTablaCliente()
	{
		return tablas.get (4);
	}


	public String darTablaDescPorcentajePromo()
	{
		return "descporcentajepromo";
	}


	public String darTablaEstante()
	{
		return "ESTANTE";
	}


	public String darTablaFactura()
	{
		return tablas.get (7);
	}


	public String darTablaLlegadaPedido()
	{
		return "LLEGADAPEDIDO";
	}


	public String darTablaPague1Lleve2ConDescPromo()
	{
		return "pague1lleve2condescpromo";
	}

	public String darTablaPagueNUnidadesLleveMPromo()
	{
		return "PAGUENUNIDADESLLEVEMPROMO";
	}


	public String darTablaPagueXCantidadLleveYPromo()
	{
		return "paguexcantidadlleveypromo";
	}

	public String darTablaPedido()
	{
		return tablas.get (12);
	}

	public String darTablaPersonaJuridica()
	{
		return tablas.get (13);
	}

	public String darTablaProducto()
	{
		return tablas.get (14);
	}

	public String darTablaProductoPedido()
	{
		return tablas.get (15);
	}	

	public String darTablaProductoPromocion()
	{
		return "PRODUCTOPROMOCION";
	}

	public String darTablaProductoProveedor()
	{
		return tablas.get (17);
	}

	public String darTablaProductoSucursal()
	{
		return tablas.get (18);
	}

	public String darTablaPromocion()
	{
		return "PROMOCION";
	}

	public String darTablaProveedor()
	{
		return "PROVEEDOR";
	}

	public String darTablaRestriccionBodega()
	{
		return tablas.get (21);
	}

	public String darTablaRestriccionEstante()
	{
		return tablas.get (22);
	}

	public String darTablaSucursal()
	{
		return "SUCURSAL";
	}

	public String darTablaVenta()
	{
		return tablas.get (24);
	}

	public String darTablaVentaProducto()
	{
		return tablas.get (25);
	}




	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patr�n SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el �nico objeto PersistenciaParranderos existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes ();
		}
		return instance;
	}

	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el �nico objeto PersistenciaParranderos existente - Patr�n SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexi�n con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}

		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlBodega = new SQLBodega(this);
		sqlCategoria = new SQLCategoria(this);
		sqlCategoriaProducto = new SQLCategoriaProducto(this);
		sqlCliente = new SQLCliente(this);
		sqlDescPorcentajePromo = new SQLDescPorcentajePromo(this);

		sqlEstante = new SQLEstante(this);
		sqlFactura = new SQLFactura(this);
		sqlLegadaPedido = new SQLLegadaPedido(this);
		sqlPague1Lleve2ConDescPromo = new SQLPague1Lleve2ConDescPromo(this);
		sqlPagueNUnidadesLleveMPromo = new SQLPagueNUnidadesLleveMPromo(this);
		sqlProductoPromocion = new SQLProductoPromocion(this);
		sqlSucursal=new SQLSucursal(this);


		sqlPagueXCantidadLleveYPromo = new SQLPagueXCantidadLleveYPromo(this);		
		sqlPedido = new SQLPedido(this);
		sqlPersonaJuridica = new SQLPersonaJuridica(this);
		sqlProducto = new SQLProducto(this);
		sqlProductoPedido = new SQLProductoPedido(this);

		sqlProductoPromocion = new SQLProductoPromocion(this);		
		sqlProductoProveedor = new SQLProductoProveedor(this);
		sqlProductoSucursal = new SQLProductoSucursal(this);
		sqlPromocion = new SQLPromocion(this);
		sqlProveedor = new SQLProveedor(this);

		sqlSucursal = new SQLSucursal(this);
		sqlVenta = new SQLVenta(this);
		sqlVentaProducto = new SQLVentaProducto(this);		
		sqlCarrito = new SQLCarrito(this);
		sqlUtil = new SQLUtil(this);

	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes ()
	{
		return "SuperAndes_sequence";
	}

	/* ****************************************************************
	 * 			Requerimientos funcionales de modificacion
	 *****************************************************************/
	public Proveedor registrarProveedor(String nit, String nombre)	{

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlProveedor.adicionarProveedor(pm,nit,nombre);
			tx.commit();

			log.trace ("Insercion de proveedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			
			return new Proveedor(nit, nombre);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public Producto registrarProductos(String codigoDeBarras, String nombre, String presentacion, String marca, String unidadDeMedida, String especificacionEmpacado, long categoria)
	{
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlProducto.adicionarProducto(pm, codigoDeBarras, nombre, presentacion, marca,  unidadDeMedida, especificacionEmpacado, categoria);
			tx.commit();

			log.trace ("Insercion de producto: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Producto(codigoDeBarras, nombre , presentacion, marca,unidadDeMedida, especificacionEmpacado, categoria);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}		
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public Cliente registrarPersonaNatural(String tipodocumento, String numDocumento, String nombre, String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {

			tx.begin();
			long tuplasInsertadas = sqlCliente.registrarCliente(pm, tipodocumento, numDocumento);
			tuplasInsertadas += sqlCliente.registrarPersonaNatural(pm, tipodocumento, numDocumento, nombre, correo);
			tx.commit();

			log.trace ("Insercion de cliente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Cliente(tipodocumento, numDocumento, nombre, correo);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}	
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	public PersonaJuridica registrarPersonaJuridica( String numDocumento, String nombre, String direccion) {


		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlCliente.registrarCliente(pm, "NIT", numDocumento);
			tuplasInsertadas += sqlPersonaJuridica.adicionarPersonaJuridica(pm, "NIT", numDocumento,nombre,direccion);
			tx.commit();

			log.trace ("Insercion de personaJuridica: " + numDocumento + ": " + tuplasInsertadas + " tuplas insertadas");

			return new PersonaJuridica( numDocumento, direccion);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}	

		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}


	public Sucursal registrarSucursal(String nombre, String segmentacion, String tamanio, String ciudad, String direccion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try 
		{
			tx.begin();
			long idSucursal= nextval();
			long tuplasInsertadas = sqlSucursal.insertarSucursal(pm, idSucursal, nombre, segmentacion, tamanio, ciudad, direccion);
			tx.commit();
			log.trace ("Insercion de sucursal: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Sucursal(idSucursal, nombre, segmentacion, direccion, tamanio, ciudad);

		} 
		catch (Exception e) 
		{

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}	
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}

	public Bodega registrarBodega(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try 
		{
			tx.begin();
			long idBodega= nextval();	
			long tuplasInsertadas = sqlBodega.insertarBodega(pm,idBodega,idSucursal,capacidadVolumen,capacidadTotalVolumen,capacidadPeso,capacidadTotalPeso);
			tx.commit();
			log.trace ("Insercion de bodega: " + idBodega + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Bodega(idSucursal, idBodega, 0, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public Estante registrarEstante(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try 
		{
			tx.begin();
			long idEstante= nextval();	
			long tuplasInsertadas = sqlEstante.insertarEstante(pm,idEstante,idSucursal,capacidadVolumen,capacidadTotalVolumen,capacidadPeso,capacidadTotalPeso);
			tx.commit();
			log.trace ("Insercion de estante: " + idEstante + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Estante(idSucursal, idEstante, "", 0, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso, 0);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}




	public PagueNUnidadesLleveMPromo registrarPromocionPagueNLleveM(String codigoProducto, Timestamp fechaVencimientoPromocion, int compraUnidades, int llevaUnidades)
	{

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			String codigoPromo= nextval()+"";
			long tuplasInsertadas=sqlPromocion.adicionarPromocion(pm, codigoPromo, 1, fechaVencimientoPromocion);
			tuplasInsertadas+=sqlPagueNUnidadesLleveMPromo.adicionarPromocion(pm, codigoPromo, compraUnidades, llevaUnidades);		
			tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm,codigoProducto , codigoPromo);
			tx.commit();
			log.trace ("Insercion de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
			return new PagueNUnidadesLleveMPromo(codigoPromo, compraUnidades, llevaUnidades);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public DescPorcentajePromo registrarPromocionDescPorcentaje(String codigoProducto, Timestamp fechaVencimientoPromocion, double porcentaje)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			String codigoPromo= nextval()+"";
			long tuplasInsertadas=sqlPromocion.adicionarPromocion(pm, codigoPromo, 1, fechaVencimientoPromocion);
			tuplasInsertadas+=sqlDescPorcentajePromo.adicionarPromocion(pm, codigoPromo, porcentaje);		
			tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm,codigoProducto , codigoPromo);
			tx.commit();
			log.trace ("Insercion de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
			return new DescPorcentajePromo(codigoPromo, porcentaje);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public PagueXCantidadLleveYPromo registrarPromocionPagueXLleveY(String codigoProducto, Timestamp fechaVencimientoPromocion, int cantidadPaga, int cantidadLleva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			String codigoPromo= nextval()+"";
			long tuplasInsertadas=sqlPromocion.adicionarPromocion(pm, codigoPromo, 1, fechaVencimientoPromocion);
			tuplasInsertadas+=sqlPagueXCantidadLleveYPromo.adicionarPromocion(pm, codigoPromo, cantidadPaga, cantidadLleva);		
			tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm,codigoProducto , codigoPromo);
			tx.commit();
			log.trace ("Insercion de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
			return new PagueXCantidadLleveYPromo(codigoPromo, cantidadPaga, cantidadLleva);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public Pague1Lleve2ConDescPromo registrarPromocionPague1Lleve2doDesc(String codigoProducto, Timestamp fechaVencimientoPromocion, double porcentaje)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			String codigoPromo= nextval()+"";
			long tuplasInsertadas=sqlPromocion.adicionarPromocion(pm, codigoPromo, 1, fechaVencimientoPromocion);
			tuplasInsertadas+=sqlPague1Lleve2ConDescPromo.adicionarPromocion(pm, codigoPromo, porcentaje);		
			tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm,codigoProducto , codigoPromo);
			tx.commit();
			log.trace ("Insercion de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Pague1Lleve2ConDescPromo(codigoPromo, porcentaje);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public Promocion registrarPromocionPaqueteProductos(String codigoProducto, Timestamp fechaVencimientoPromocion, String producto2, double precioConjunto)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			String codigoPromo= nextval()+"";
			long tuplasInsertadas=sqlPromocion.adicionarPromocion(pm, codigoPromo, 1, fechaVencimientoPromocion);
			tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm,codigoProducto , codigoPromo);
			tx.commit();
			log.trace ("Insercion de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Promocion(codigoPromo, fechaVencimientoPromocion);
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public long finalizarPromocion(Timestamp fecha)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try 
		{
			tx.begin();
			long tuplasEliminadas=sqlPromocion.eliminarPromocion(pm, fecha);
			log.trace ("Eliminacion de promocion, "  + tuplasEliminadas + " tuplas eliminadas");
			tx.commit();
			return tuplasEliminadas;
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return 0;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public Pedido registrarPedido(String idSucursal, String[] codigosProductos, double[] cantidad, double[] precios, String nitProveedor, Timestamp fechaPrevista, double precioTotal )
	{
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			long codigoPedido = nextval();

			long tuplasInsertadas = sqlPedido.adicionarPedido(pm, codigoPedido, idSucursal, nitProveedor, fechaPrevista, precioTotal);

			

			for (int i = 0; i < codigosProductos.length; i++) {

				tuplasInsertadas += sqlProductoPedido.adicionarProductoPedido(pm, codigoPedido,codigosProductos[i],cantidad[i],precios[i]);		

			}

			tx.commit();

			log.trace ("Insercion de pedido a proveedor: " + nitProveedor + ": " + tuplasInsertadas + " tuplas insertadas");



			return new Pedido(pm, idSucursal, codigosProductos, nitProveedor, fechaPrevista, precioTotal);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}		
	}

	public LlegadaPedido registrarLlegadaPedido(long codigoPedido,Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		{
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx=pm.currentTransaction();
			try 
			{
				tx.begin();
				long id= nextval();
				long tuplasInsertadas=sqlLegadaPedido.registrarLlegadaPedido(pm, codigoPedido, fechaLlegada, cantidadProductos, calidadProductos, calificacion);
				log.trace ("Insercion de llegada pedido: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
				tx.commit();
				return new LlegadaPedido(id, fechaLlegada, cantidadProductos, calidadProductos, calificacion, codigoPedido);
			} 
			catch (Exception e) 
			{
				log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
				return null;
			}
			finally
			{
				if (tx.isActive())
				{
					tx.rollback();
				}
				pm.close();
			}
		}
	}

	public Venta registrarVenta(long sucursal, String tipodocumento, String documento, String[] codigosProductos,
			String[] cantidad, String[] precios, double precioTotal, Timestamp fecha) {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			long numeroVenta = nextval();

			long tuplasInsertadas = sqlVenta.adicionarVenta(pm, sucursal, numeroVenta, tipodocumento, documento, precioTotal, fecha);

			long tuplasInsertadas2 = 0;

			for (int i = 0; i < codigosProductos.length; i++) {

				tuplasInsertadas2 += sqlVentaProducto.adicionarVentaProducto(pm, numeroVenta, codigosProductos[i],cantidad[i]);		
			}

			tx.commit();

			log.trace ("Insercion de venta: " + numeroVenta + ": " + tuplasInsertadas + " tuplas insertadas");

			log.trace ("Insercion de ventaProducto: " + numeroVenta + ": " + tuplasInsertadas2 + " tuplas insertadas");


			return new Venta( numeroVenta, tipodocumento, documento, precioTotal);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}		

	}

	/* ****************************************************************
	 * 			Requerimientos funcionales de consulta
	 *****************************************************************/


	public List<Object[]> dineroRecolectado(Timestamp fechaInicio,Timestamp fechaFin)
	{
		log.info ("Obteniendo dinero recolectado en las sucursales entre " + fechaInicio+" y "+fechaFin);
		PersistenceManager pm = pmf.getPersistenceManager();
		return sqlVenta.obtenerDineroRecolectado(pm, fechaInicio, fechaFin);
	}

	/**
	 * 
	 */
	public void promocionesMasPopulares()
	{
		log.info ("Obteniendo las 20 promociones mas populares ");
	}

	/**
	 * 
	 * @param idSucursal
	 */
	public List<Object []> indiceOcupacion(long idSucursal)
	{
		return sqlSucursal.darIndiceOcupacion(pmf.getPersistenceManager(), idSucursal);
	}

	public void productosConCiertaCaracteristica(int precioInferior, int precioSuperior, Timestamp fechaVencimientoMinima, double pesoMinimo, double pesoMaximo,
			String nitProveedor, String ciudad, long idSucursal, String tipo, String categoria, int cantidadMinimaVentas, Timestamp fechaMinCantMinVentas,
			Timestamp fechaMaxCantMinVentas)
	{

	}
	/* ****************************************************************
	 *			Requerimientos funcionales de Bono
	 *****************************************************************/
	public void comprasAProveedores()
	{

	}

	public List<Venta> ventasAUsuario(String tipoDocumento, long numeroCliente, Timestamp fechaInicio, Timestamp fechaFin)
	{
		return sqlVenta.obtenerVentasDeCliente(pmf.getPersistenceManager(),tipoDocumento,numeroCliente,fechaInicio,fechaFin);
	}

	/**
	 * Transacci�n para el generador de secuencia de SuperAndes
	 * Adiciona entradas al log de la aplicaci�n
	 * @return El siguiente n�mero del secuenciador de SuperAndes
	 */
	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle espec�fico del problema encontrado
	 * @param e - La excepci�n que ocurrio
	 * @return El mensaje de la excepci�n JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}



	/* ****************************************************************
	 *		M�todos adicionales
	 *****************************************************************/


	public String[] obtenerPreciosSucursal(long sucursal, String[] productos) {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			String[] precios = sqlProductoSucursal.darPrecioProductosSucursal(pm, sucursal, productos);

			tx.commit();


			return precios;

		} 
		catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}	
	}

	/* ****************************************************************
	 * 			Requerimientos funcionales Iteracion 2
	 *****************************************************************/
	public void solicitarCarrito(String tipoDocumento, String numeroCliente)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try 
		{
			tx.begin();
			sqlCliente.solicitarCarrito(pm, tipoDocumento, numeroCliente);
			log.trace ("Cliente " + tipoDocumento + numeroCliente + " asignado carro");
			tx.commit();

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public boolean adicionarProductoACarrito(String tipoDocumento, String numeroCliente, long idEstante, String idProducto, int cantidad)
	{
		boolean logro=false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try 
		{
			tx.begin();
			
			int tieneCarrito=sqlCliente.tieneCarrito(pm, tipoDocumento, numeroCliente);
			if(tieneCarrito==0)
				throw new Exception("El cliente no tiene un carrito asignado");
			
			sqlEstante.tomarProducto(pm, idEstante, idProducto, cantidad);
			sqlCarrito.anadirProducto(pm, tipoDocumento, numeroCliente, idProducto, cantidad);
			tx.commit();
			logro=true;

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}	
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		return logro;

	}
	public boolean devolverProductoDelCarrito(String tipoDocumento, String numeroCliente, long idEstante, String idProducto, int cantidad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean logro=false;
		try 
		{
			tx.begin();
			
			int tieneCarrito=sqlCliente.tieneCarrito(pm, tipoDocumento, numeroCliente);
			if(tieneCarrito==0)
				throw new Exception("El cliente no tiene un carrito asignado");
			
			sqlEstante.devolverProducto(pm, idEstante, idProducto, cantidad);
			sqlCarrito.eliminarProducto(pm, tipoDocumento, numeroCliente, idProducto, cantidad);
			tx.commit();
			logro=true;

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		return logro;
	}
	
	public boolean pagarCompraCarrito(String tipoDocumento, String numeroCliente, long sucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean logro=false;
		try 
		{
			tx.begin();
			int tieneCarrito=sqlCliente.tieneCarrito(pm, tipoDocumento, numeroCliente);
			if(tieneCarrito==0)
				throw new Exception("El cliente no tiene un carrito asignado");
			
			long numeroVenta=nextval();
			List<Object[]>productos=sqlCarrito.obtenerCarritoDeCliente(pm, tipoDocumento, numeroCliente);
			Date d=new Date();
			
			sqlVenta.adicionarVenta(pm, sucursal, numeroVenta, tipoDocumento, numeroCliente, 0, new Timestamp(d.getTime()));
			for (Object[] prod : productos) {
				sqlVenta.adicionarProductoAVenta(pm, numeroVenta,((String) prod[4]), ((BigDecimal) prod[2]).intValue());
			}
			sqlCarrito.pagarCarrito(pm, tipoDocumento, numeroCliente);
			sqlCliente.abandonarCarrito(pm, tipoDocumento, numeroCliente);
			tx.commit();
			logro=true;
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		return logro;
	}
	
	public boolean abandonarCarrito(String tipoDocumento, String numeroCliente)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean logro=false;
		try 
		{
			tx.begin();
			int tieneCarrito=sqlCliente.tieneCarrito(pm, tipoDocumento, numeroCliente);
			if(tieneCarrito==0)
				throw new Exception("El cliente no tiene un carrito asignado");
			
			sqlCarrito.abandonarCarrito(pm, tipoDocumento, numeroCliente);
			sqlCliente.abandonarCarrito(pm, tipoDocumento, numeroCliente);
			tx.commit();
			logro=true;

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		return logro;
	}
	
	public boolean recolectarProductosAbandonados()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean logro=false;
		try 
		{
			tx.begin();
			List<Object[]> productosAbandonados=sqlCarrito.obtenerProductosAbandonados(pm);
			//Numdoc,TipoDoc,Cantidad,Abandonado,producto
	        for (Object[] objects : productosAbandonados) {
				sqlEstante.devolverProductoPrimerEstante(pm, objects[4]+"", ((BigDecimal)objects[2]).intValue());
			}
			sqlCarrito.recolectarProductosAbandonados(pm);
			tx.commit();
			logro=true;
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		return logro;
	}
	public void consolidarPedidos()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try 
		{
			tx.begin();
			sqlPedido.consolidarPedidos();
			tx.commit();

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	public void registrarLlegadaPedidoConsolidado(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try 
		{
			tx.begin();
			sqlLegadaPedido.registrarLlegadaPedido(pm, codigoPedido, fechaLlegada, cantidadProductos, calidadProductos, calificacion);
			tx.commit();

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public String analizarOperacion(Timestamp fechaInicio, Timestamp fechaFin)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		String resp="";
		try 
		{
			tx.begin();
			resp+="\n";
			resp+="   SUCURSAL   CANTMAX    CODIGOPRODUCTO    FECHAVENTA";
			List<Object[]> maxC=sqlVenta.analizarCantidadMax(pm,fechaInicio,fechaFin);
			for (Object[] objects : maxC) {
				resp+="\n"+"        "+((BigDecimal)objects[0]).intValue()+"               "+((BigDecimal)objects[1]).intValue()+"           "+objects[2]+"          "+objects[3];
			}
			resp+="\n";
			resp+="\n";
			resp+="   SUCURSAL   PRECIOMAX    CODIGOPRODUCTO    FECHAVENTA";
			List<Object[]> maxP=sqlVenta.analizarPrecioMax(pm,fechaInicio,fechaFin);
			for (Object[] objects : maxP) {
				resp+="\n"+"        "+((BigDecimal)objects[0]).intValue()+"          $"+((BigDecimal)objects[1]).doubleValue()+"           "+objects[2]+"          "+objects[3];
			}
			resp+="\n";
			resp+="\n";
			resp+="   SUCURSAL   CANTMIN    CODIGOPRODUCTO    FECHAVENTA";
			List<Object[]> minC=sqlVenta.analizarCantidadMin(pm,fechaInicio,fechaFin);
			for (Object[] objects : minC) {
				resp+="\n"+"        "+((BigDecimal)objects[0]).intValue()+"               "+((BigDecimal)objects[1]).intValue()+"            "+objects[2]+"          "+objects[3];
			}
			tx.commit();
			resp+="\n";
			resp+="\n";
		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			resp+="/n Error: "+e.getMessage();
		}
		return resp;
	}
	
	public void clientesFrecuentes()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try 
		{
			tx.begin();
			tx.commit();

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
	}
	public void productosPocaDemanda()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try 
		{
			tx.begin();
			tx.commit();

		} 
		catch (Exception e) 
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

		}
	}


}
