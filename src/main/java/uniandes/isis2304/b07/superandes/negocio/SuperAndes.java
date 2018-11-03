package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.b07.superandes.persistencia.PersistenciaSuperAndes;



/**
 * Clase principal del mundo
 * @author Santiago Carrero y Nicolas Hernandez 
 *
 */
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
	public Proveedor registrarProveedor(String nit ,String nombre)
	{
		log.info ("Registrando proveedores");	
		return pp.registrarProveedor(nit, nombre);
	}

	public Producto registrarProductos(String codigoDeBarras, String nombre, String presentacion, String marca, String unidadeDeMedida, String especificacionEmpacado, long categoria)
	{
		log.info ("Registrando producto: " + codigoDeBarras);
		return pp.registrarProductos(codigoDeBarras, nombre, presentacion, marca, unidadeDeMedida, especificacionEmpacado, categoria);
		
	}

	public Cliente registrarPersonaNatural(String documento, String numDocumento, String nombre, String correo)
	{
		log.info ("Registrando cliente: " + nombre);
		return pp.registrarPersonaNatural(documento, numDocumento, nombre, correo);
	}


	public PersonaJuridica registrarPersonaJuridica(String numDocumento, String nombre,String direccion) {

		log.info ("Registrando personaJuridica: " +numDocumento);

		PersonaJuridica x = pp.registrarPersonaJuridica( numDocumento, nombre, direccion);


		return x;
	}

	public Sucursal registrarSucursal(String nombre, String segmentacion, String tamanio, String ciudad, String direccion)
	{
		log.info ("Registrando sucursal: " + nombre);
		return pp.registrarSucursal(nombre, segmentacion, tamanio, ciudad, direccion);

	}

	public Bodega registrarBodega(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		log.info ("Registrando bodega en la sucursal: " + idSucursal);
		return pp.registrarBodega(idSucursal, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);
	}

	public Estante registrarEstante(long idSucursal, String nombre ,double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		log.info ("Registrando estante en la sucursal: " + idSucursal);
		return pp.registrarEstante(idSucursal, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);
	}


	public PagueNUnidadesLleveMPromo registrarPromocionPagueNLleveM(String codigoProducto, Timestamp fechaVencimientoPromocion, int compraUnidades, int llevaUnidades)
	{
		return pp.registrarPromocionPagueNLleveM(codigoProducto, fechaVencimientoPromocion, compraUnidades, llevaUnidades);
	}
	public DescPorcentajePromo registrarPromocionDescPorcentaje(String codigoProducto, Timestamp fechaVencimientoPromocion, double porcentaje)
	{
		return pp.registrarPromocionDescPorcentaje(codigoProducto, fechaVencimientoPromocion, porcentaje);
	}
	public PagueXCantidadLleveYPromo registrarPromocionPagueXLleveY(String codigoProducto, Timestamp fechaVencimientoPromocion, int cantidadPaga, int cantidadLleva)
	{
		return pp.registrarPromocionPagueXLleveY(codigoProducto, fechaVencimientoPromocion, cantidadPaga, cantidadLleva);
	}
	public Pague1Lleve2ConDescPromo registrarPromocionPague1Lleve2doDesc(String codigoProducto, Timestamp fechaVencimientoPromocion, double porcentaje)
	{
		return pp.registrarPromocionPague1Lleve2doDesc(codigoProducto, fechaVencimientoPromocion, porcentaje);
	}
	public Promocion registrarPromocionPaqueteProductos(String codigoProducto, Timestamp fechaVencimientoPromocion, String producto2, double precioConjunto)
	{
		return pp.registrarPromocionPaqueteProductos(codigoProducto, fechaVencimientoPromocion, producto2, precioConjunto);
	}


	public long finalizarPromocion(Timestamp fecha)
	{
		return pp.finalizarPromocion(fecha);
	}

	public Pedido registrarPedido(String idSucursal, String[] codigosProductos, double[] cantidad, double[] precios, String nitProveedor, Timestamp fechaPrevista, double precioTotal )
	{
		log.info ("Registrando pedido con numero de productos: " + codigosProductos.length);
		return pp.registrarPedido(idSucursal, codigosProductos,cantidad, precios, nitProveedor, fechaPrevista, precioTotal);
	}

	public LlegadaPedido registrarLlegadaPedido(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		log.info ("Registrando llegada pedido: " + codigoPedido);
		return pp.registrarLlegadaPedido(codigoPedido, fechaLlegada, cantidadProductos, calidadProductos, calificacion);
	}


	public Venta registrarVenta(String sucursal, String tipodocumento, String documento, String[] codigosProductos,
			String[] cantidad, String[] precios, double precioTotal, Timestamp fecha) {

		return pp.registrarVenta(sucursal, tipodocumento, documento, codigosProductos, cantidad, precios, precioTotal,fecha);

	}



	public String[] obtenerPreciosSucursal(String sucursal, String[] productos) {

		return pp.obtenerPreciosSucursal(sucursal, productos);
	}



	/* ****************************************************************
	 * 			Requerimientos funcionales de consulta
	 *****************************************************************/
	public List<Object[]> dineroRecolectado(Timestamp fechaInicio,Timestamp fechaFin)
	{
		log.info ("Obteniendo dinero recolectado en las sucursales entre " + fechaInicio+" y "+fechaFin);
		
		return pp.dineroRecolectado(fechaInicio, fechaFin);
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
	public List<Object[]> indiceOcupacion(long idSucursal)
	{
		log.info ("Obteniendo indice de ocupacion de la sucursal: " + idSucursal);
		return pp.indiceOcupacion(idSucursal);
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
		return pp.ventasAUsuario(tipoDocumento,numeroCliente,fechaInicio,fechaFin);
	}


	public void productosEnRangoPrecios(double precioMin, double precioMax) 
	{

	}


	public void productosPorFechaVencimiento(Timestamp fechaVencimiento) {
		

	}


	public void productosEnRangoPesos(double pesoMin, double pesoMax) {

	}


	public void productosEnRangoVolumen(double volumenMin, double volumenMax) {

	}


	public void productosDeProveedor(String nit) {

	}

	/* ****************************************************************
	 * 			Requerimientos funcionales Iteracion 2
	 *****************************************************************/
	public void solicitarCarrito()
	{
		pp.solicitarCarrito();
	}
	
	public void adicionarProductoACarrito(String tipoDocumento, long numeroCliente, long idEstante, long idProducto, int cantidad)
	{
		pp.adicionarProductoACarrito(tipoDocumento, numeroCliente, idEstante, idProducto, cantidad);
	}
	public void devolverProductoDelCarrito(String tipoDocumento, long numeroCliente, long idEstante, long idProducto, int cantidad)
	{
		pp.devolverProductoDelCarrito(tipoDocumento, numeroCliente, idEstante, idProducto, cantidad);
	}
	public void pagarCompraCarrito(String tipoDocumento, long numeroCliente)
	{
		pp.pagarCompraCarrito(tipoDocumento, numeroCliente);
	}
	public void abandonarCarrito(String tipoDocumento, long numeroCliente)
	{
		pp.abandonarCarrito(tipoDocumento, numeroCliente);
	}
	public void recolectarProductosAbandonados()
	{
		pp.recolectarProductosAbandonados();
	}
	public void consolidarPedidos()
	{
		pp.consolidarPedidos();
	}
	public void registrarLlegadaPedidoConsolidado(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		pp.registrarLlegadaPedidoConsolidado(codigoPedido,fechaLlegada,cantidadProductos,calidadProductos,calificacion);
	}
	
	public void analizarOperacion()
	{
		pp.analizarOperacion();
	}
	
	public void clientesFrecuentes()
	{
		pp.clientesFrecuentes();
	}
	public void productosPocaDemanda()
	{
		pp.productosPocaDemanda();
	}


}
