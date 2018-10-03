package uniandes.isis2304.b07.superandes.persistencia;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;




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
		tablas.add ("SupeAndes_sequence");
//		tablas.add ("TIPOBEBIDA");
//		tablas.add ("BEBIDA");
//		tablas.add ("BAR");
//		tablas.add ("BEBEDOR");
//		tablas.add ("GUSTAN");
//		tablas.add ("SIRVEN");
//		tablas.add ("VISITAN");
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
//		sqlTipoBebida = new SQLTipoBebida(this);
//		sqlBebida = new SQLBebida(this);
//		sqlBar = new SQLBar(this);
//		sqlBebedor = new SQLBebedor(this);
//		sqlGustan = new SQLGustan(this);
//		sqlSirven = new SQLSirven (this);
//		sqlVisitan = new SQLVisitan(this);		
//		sqlUtil = new SQLUtil(this);
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
    public void registrarProveedores(String nombre)
    {
    	log.info ("Registrando proveedor: " + nombre);
    	
    }
    
    public void registrarProductos()
    {
    	
    }
    
    public void registrarClientes()
    {
    	
    }
    
    public void registrarSucursal(String nombre, String segmentacion, String tamanio, String ciudad, String direccion)
    {
    	log.info ("Registrando sucursal: " + nombre);
    	
    }
    
    public void registrarBodega(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
    {
    	log.info ("Registrando bodega en la sucursal: " + idSucursal);
    
    }
    
    public void registrarEstante(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
    {
    	log.info ("Registrando estante en la sucursal: " + idSucursal);
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
	public void indiceOcupacion(long idSucursal)
	{
		log.info ("Obteniendo indice de ocupacion de la sucursal: " + idSucursal);
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
	
	
}
