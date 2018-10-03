package uniandes.isis2304.b07.superandes.persistencia;

import java.sql.Timestamp;
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
import uniandes.isis2304.b07.superandes.negocio.IndiceOcupacion;
import uniandes.isis2304.b07.superandes.negocio.Pague1Lleve2ConDescPromo;
import uniandes.isis2304.b07.superandes.negocio.PagueNUnidadesLleveMPromo;
import uniandes.isis2304.b07.superandes.negocio.PagueXCantidadLleveYPromo;
import uniandes.isis2304.b07.superandes.negocio.PaqueteDeProductos;
import uniandes.isis2304.b07.superandes.negocio.PersonaJuridica;
import uniandes.isis2304.b07.superandes.negocio.Producto;
import uniandes.isis2304.b07.superandes.negocio.Proveedor;
import uniandes.isis2304.b07.superandes.negocio.Sucursal;




public class PersistenciaSuperAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
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
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaSuperAndes instance;

	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
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

	private SQLRestriccionBodega sqlRestriccionBodega;

	private SQLRestriccionEstante sqlRestriccionEstante;

	private SQLSucursal sqlSucursal;

	private SQLVenta sqlVenta;

	private SQLVentaProducto sqlVentaProducto;




	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");		
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
		return tablas.get (1);
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
		return tablas.get (5);
	}


	public String darTablaEstante()
	{
		return tablas.get (6);
	}


	public String darTablaFactura()
	{
		return tablas.get (7);
	}


	public String darTablaLlegadaPedido()
	{
		return tablas.get (8);
	}


	public String darTablaPague1Lleve2ConDescPromo()
	{
		return tablas.get (9);
	}

	public String darTablaPagueNUnidadesLleveMPromo()
	{
		return "PAGUENUNIDADESLLEVEMPROMO";
	}


	public String darTablaPagueXCantidadLleveYPromo()
	{
		return tablas.get (11);
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
		return tablas.get (20);
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
		return tablas.get (23);
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
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
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
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
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
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
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
	 * Cierra la conexión con la base de datos
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

		sqlRestriccionBodega = new SQLRestriccionBodega(this);		
		sqlRestriccionEstante = new SQLRestriccionEstante(this);
		sqlSucursal = new SQLSucursal(this);
		sqlVenta = new SQLVenta(this);
		sqlVentaProducto = new SQLVentaProducto(this);		

		sqlUtil = new SQLUtil(this);

	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
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

			log.trace ("Inserción de proveedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Proveedor(nit, nombre);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}

	}

	public Producto registrarProductos(String codigosBarras, String nombres, String presentaciones, String marcas, int cantidades, String unidadesMedida, String especificacionesEmpacado)
	{
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlProducto.adicionarProducto(pm, codigosBarras, nombres, presentaciones, marcas, cantidades, unidadesMedida, especificacionesEmpacado);
			tx.commit();

			log.trace ("Inserción de producto: " + nombres + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Producto(codigosBarras, nombres , presentaciones, marcas, cantidades,unidadesMedida, especificacionesEmpacado);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}		

	}

	public Cliente registrarCliente(String tipodocumento, String numDocumento, String nombre, String apellido, String correo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlCliente.adicionarCliente(pm, tipodocumento, numDocumento, nombre, apellido, correo);
			tx.commit();

			log.trace ("Inserción de cliente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Cliente(tipodocumento, numDocumento, nombre, apellido, correo);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
		}	

	}
	

	public PersonaJuridica registrarPersonaJuridica(String documento, String numDocumento, String direccion) {


		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			long tuplasInsertadas = sqlPersonaJuridica.adicionarPersonaJuridica(pm, documento, numDocumento,direccion);
			tx.commit();

			log.trace ("Inserción de personaJuridica: " + numDocumento + ": " + tuplasInsertadas + " tuplas insertadas");

			return new PersonaJuridica(documento, numDocumento, direccion);

		} catch (Exception e) {

			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));

			return null;
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
			log.trace ("Inserción de sucursal: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Sucursal();

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
			log.trace ("Inserción de bodega: " + idBodega + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Bodega();

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
			log.trace ("Inserción de estante: " + idEstante + ": " + tuplasInsertadas + " tuplas insertadas");
			return new Estante();

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

	/**
	 * 
	 * @param tipoPromocion
	 * @param codigoProducto
	 * @param fechaVencimientoPromocion
	 * @param cantidadPaga
	 * @param cantidadLleva
	 * @param porcentajeDescSegundoP
	 * @param porcentajeDesc
	 * @param precioConjunto
	 * @param codigoNuevoProducto
	 * @param compraUnidades
	 * @param llevaUnidades
	 */
	public void registrarPromocion(String tipoPromocion,String codigoProducto, Timestamp fechaVencimientoPromocion,double cantidadPaga, double cantidadLleva, double porcentajeDescSegundoP, 
			double porcentajeDesc, int precioConjunto, String codigoNuevoProducto, int compraUnidades, int llevaUnidades)
	{
		switch (tipoPromocion) {
		case "":

			break;

		default:
			break;
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
			//tuplasInsertadas+=sqlProductoPromocion.adicionarPromocion(pm, codigoProducto, "3");
			tx.commit();
			log.trace ("Inserción de promocion: " + codigoPromo + ": " + tuplasInsertadas + " tuplas insertadas");
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
		return null;
	}
	public PagueXCantidadLleveYPromo registrarPromocionPagueXLleveY(String codigoProducto, Timestamp fechaVencimientoPromocion, int cantidadPaga, int cantidadLleva)
	{
		return null;
	}
	public Pague1Lleve2ConDescPromo registrarPromocionPague1Lleve2doDesc(String codigoProducto, Timestamp fechaVencimientoPromocion, double porcentaje)
	{
		return null;
	}
	public PaqueteDeProductos registrarPromocionPaqueteProductos(String codigoProducto, Timestamp fechaVencimientoPromocion, String producto2, double precioConjunto)
	{
		return null;
	}

	public void finalizarPromocion()
	{
		System.out.println("Hola");
	}

	public void registrarPedido(String[] codigosProductos, String nitProveedor, Timestamp fechaPrevista, int precioTotal )
	{
		log.info ("Registrando pedido con numero de productos: " + codigosProductos.length);
	}

	public void registrarLlegadaPedido(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		log.info ("Registrando llegada pedido: " + codigoPedido);
	}

	public void registrarVenta(String codigoProducto, int unidadesVendidas, String tipoDocumentoCliente, String numeroDocumentoCLiente)
	{
		log.info ("Registrando venta de producto: " + codigoProducto);
	}

	/* ****************************************************************
	 * 			Requerimientos funcionales de consulta
	 *****************************************************************/
	public void dineroRecolectado(Timestamp fechaInicio,Timestamp fechaFin)
	{
		log.info ("Obteniendo dinero recolectado en las sucursales entre " + fechaInicio+" y "+fechaFin);
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
	public List<IndiceOcupacion> indiceOcupacion(long idSucursal)
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

	public void ventasAUsuario()
	{

	}

	/**
	 * Transacción para el generador de secuencia de SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de SuperAndes
	 */
	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
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






}
