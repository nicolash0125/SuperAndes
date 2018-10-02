package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;
import java.util.List;

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
    public List<Proveedor> registrarProveedores(String[]nit ,String[] nombre)
    {
    	log.info ("Registrando proveedores: " + nit.length);
    	
    	return null;
    }
    
    public List<Producto> registrarProductos(String[]codigosBarras,String[] nombres,String[] presentaciones,int[]cantidades, String[]unidadesMedida,String[] especificacionesEmpacado)
    {
    	log.info ("Registrando productos: " + codigosBarras.length);
    	
    	return null;
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
    
    public Estante registrarEstante(long idSucursal, String nombre ,double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
    {
    	log.info ("Registrando estante en la sucursal: " + idSucursal);
    	return null;
    }
    
    
    public PagueNUnidadesLleveMPromo registrarPromocionPagueNLleveM(String codigoProducto, Timestamp fechaVencimientoPromocion, int compraUnidades, int llevaUnidades)
    {
    	return null;
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
    
    public Pedido registrarPedido(String[] codigosProductos, String nitProveedor, Timestamp fechaPrevista, double precioTotal )
    {
    	log.info ("Registrando pedido con numero de productos: " + codigosProductos.length);
    	return null;
    }
    
    public LlegadaPedido registrarLlegadaPedido(long codigoPedido, long idSucursal, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
    {
    	log.info ("Registrando llegada pedido: " + codigoPedido);
    	return null;
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
