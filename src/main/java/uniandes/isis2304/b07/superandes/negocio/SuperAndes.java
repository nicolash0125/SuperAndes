package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.b07.superandes.persistencia.PersistenciaSuperAndes;




public class SuperAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(SuperAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		pp = PersistenciaSuperAndes.getInstance ();
	}
	
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		pp = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
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
    
    public Sucursal registrarSucursal(String nombre, String segmentacion, String tamanio, String ciudad, String direccion)
    {
    	log.info ("Registrando sucursal: " + nombre);
    	return null;
    	
    }
    
    public Bodega registrarBodega(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
    {
    	log.info ("Registrando bodega en la sucursal: " + idSucursal);
    	return null;
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

}
