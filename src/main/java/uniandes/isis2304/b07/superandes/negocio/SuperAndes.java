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
	/**
	 * Registra proveedor
	 * @param nit
	 * @param nombre
	 * @return
	 */
	public Proveedor registrarProveedor(String nit ,String nombre)
	{
		log.info ("Registrando proveedores");	
		return pp.registrarProveedor(nit, nombre);
	}

	/**
	 * Registra producto
	 * @param codigoDeBarras
	 * @param nombre
	 * @param presentacion
	 * @param marca
	 * @param unidadeDeMedida
	 * @param especificacionEmpacado
	 * @param categoria
	 * @return
	 */
	public Producto registrarProductos(String codigoDeBarras, String nombre, String presentacion, String marca, String unidadeDeMedida, String especificacionEmpacado, long categoria)
	{
		log.info ("Registrando producto: " + codigoDeBarras);
		return pp.registrarProductos(codigoDeBarras, nombre, presentacion, marca, unidadeDeMedida, especificacionEmpacado, categoria);
		
	}

	/**
	 * Registra cliente
	 * @param documento
	 * @param numDocumento
	 * @param nombre
	 * @param correo
	 * @return
	 */
	public Cliente registrarPersonaNatural(String documento, String numDocumento, String nombre, String correo)
	{
		log.info ("Registrando cliente: " + nombre);
		return pp.registrarPersonaNatural(documento, numDocumento, nombre, correo);
	}


	/**
	 * Registra p.juridica
	 * @param numDocumento
	 * @param nombre
	 * @param direccion
	 * @return
	 */
	public PersonaJuridica registrarPersonaJuridica(String numDocumento, String nombre,String direccion) {

		log.info ("Registrando personaJuridica: " +numDocumento);

		PersonaJuridica x = pp.registrarPersonaJuridica( numDocumento, nombre, direccion);


		return x;
	}

	/**
	 * Registra sucursal
	 * @param nombre
	 * @param segmentacion
	 * @param tamanio
	 * @param ciudad
	 * @param direccion
	 * @return
	 */
	public Sucursal registrarSucursal(String nombre, String segmentacion, String tamanio, String ciudad, String direccion)
	{
		log.info ("Registrando sucursal: " + nombre);
		return pp.registrarSucursal(nombre, segmentacion, tamanio, ciudad, direccion);

	}

	/**
	 * Registra bodega
	 * @param idSucursal
	 * @param capacidadVolumen
	 * @param capacidadTotalVolumen
	 * @param capacidadPeso
	 * @param capacidadTotalPeso
	 * @return
	 */
	public Bodega registrarBodega(long idSucursal, double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		log.info ("Registrando bodega en la sucursal: " + idSucursal);
		return pp.registrarBodega(idSucursal, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);
	}

	/**
	 * Registra estante
	 * @param idSucursal
	 * @param nombre
	 * @param capacidadVolumen
	 * @param capacidadTotalVolumen
	 * @param capacidadPeso
	 * @param capacidadTotalPeso
	 * @return
	 */
	public Estante registrarEstante(long idSucursal, String nombre ,double capacidadVolumen, double capacidadTotalVolumen, double capacidadPeso, double capacidadTotalPeso)
	{
		log.info ("Registrando estante en la sucursal: " + idSucursal);
		return pp.registrarEstante(idSucursal, capacidadVolumen, capacidadTotalVolumen, capacidadPeso, capacidadTotalPeso);
	}

	/**
	 * Registra promocion
	 * @param codigoProducto
	 * @param fechaVencimientoPromocion
	 * @param compraUnidades
	 * @param llevaUnidades
	 * @return
	 */
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

	/**
	 * Finaliza promocion
	 * @param fecha
	 * @return
	 */
	public long finalizarPromocion(Timestamp fecha)
	{
		return pp.finalizarPromocion(fecha);
	}

	/**
	 * Registra pedido
	 * @param idSucursal
	 * @param codigosProductos
	 * @param cantidad
	 * @param precios
	 * @param nitProveedor
	 * @param fechaPrevista
	 * @param precioTotal
	 * @return
	 */
	public Pedido registrarPedido(String idSucursal, String[] codigosProductos, double[] cantidad, double[] precios, String nitProveedor, Timestamp fechaPrevista, double precioTotal )
	{
		log.info ("Registrando pedido con numero de productos: " + codigosProductos.length);
		return pp.registrarPedido(idSucursal, codigosProductos,cantidad, precios, nitProveedor, fechaPrevista, precioTotal);
	}

	/**
	 * Registra llegada pedido
	 * @param codigoPedido
	 * @param fechaLlegada
	 * @param cantidadProductos
	 * @param calidadProductos
	 * @param calificacion
	 * @return
	 */
	public LlegadaPedido registrarLlegadaPedido(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		log.info ("Registrando llegada pedido: " + codigoPedido);
		return pp.registrarLlegadaPedido(codigoPedido, fechaLlegada, cantidadProductos, calidadProductos, calificacion);
	}

	/**
	 * Registra venta
	 * @param sucursal
	 * @param tipodocumento
	 * @param documento
	 * @param codigosProductos
	 * @param cantidad
	 * @param precios
	 * @param precioTotal
	 * @param fecha
	 * @return
	 */
	public Venta registrarVenta(long sucursal, String tipodocumento, String documento, String[] codigosProductos,
			String[] cantidad, String[] precios, double precioTotal, Timestamp fecha) {

		return pp.registrarVenta(sucursal, tipodocumento, documento, codigosProductos, cantidad, precios, precioTotal,fecha);

	}


	/**
	 * Obtiene precios sucursal
	 * @param sucursal
	 * @param productos
	 * @return
	 */
	public String[] obtenerPreciosSucursal(long sucursal, String[] productos) {

		return pp.obtenerPreciosSucursal(sucursal, productos);
	}



	/* ****************************************************************
	 * 			Requerimientos funcionales de consulta
	 *****************************************************************/
	/**
	 * Dinero recolectado
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<Object[]> dineroRecolectado(Timestamp fechaInicio,Timestamp fechaFin)
	{
		log.info ("Obteniendo dinero recolectado en las sucursales entre " + fechaInicio+" y "+fechaFin);
		
		return pp.dineroRecolectado(fechaInicio, fechaFin);
	}

	/**
	 * Promo populares
	 */
	public void promocionesMasPopulares()
	{
		log.info ("Obteniendo las 20 promociones mas populares ");
	}

	/**
	 * Indice de ocupacion
	 * @param idSucursal
	 */
	public List<Object[]> indiceOcupacion(long idSucursal)
	{
		log.info ("Obteniendo indice de ocupacion de la sucursal: " + idSucursal);
		return pp.indiceOcupacion(idSucursal);
	}

	/**
	 * Productos con x caract
	 * @param precioInferior
	 * @param precioSuperior
	 * @param fechaVencimientoMinima
	 * @param pesoMinimo
	 * @param pesoMaximo
	 * @param nitProveedor
	 * @param ciudad
	 * @param idSucursal
	 * @param tipo
	 * @param categoria
	 * @param cantidadMinimaVentas
	 * @param fechaMinCantMinVentas
	 * @param fechaMaxCantMinVentas
	 */
	public void productosConCiertaCaracteristica(int precioInferior, int precioSuperior, Timestamp fechaVencimientoMinima, double pesoMinimo, double pesoMaximo,
			String nitProveedor, String ciudad, long idSucursal, String tipo, String categoria, int cantidadMinimaVentas, Timestamp fechaMinCantMinVentas,
			Timestamp fechaMaxCantMinVentas)
	{

	}
	/* ****************************************************************
	 *			Requerimientos funcionales de Bono
	 *****************************************************************/
	
	/**
	 * Compras a proveedores
	 */
	public void comprasAProveedores()
	{

	}

	/**
	 * Ventas al usuario
	 * @param tipoDocumento
	 * @param numeroCliente
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<Venta> ventasAUsuario(String tipoDocumento, long numeroCliente, Timestamp fechaInicio, Timestamp fechaFin)
	{
		return pp.ventasAUsuario(tipoDocumento,numeroCliente,fechaInicio,fechaFin);
	}


	/**
	 * prodctors en x rango
	 * @param precioMin
	 * @param precioMax
	 * @return
	 */
	public List<Object[]> productosEnRangoPrecios(double precioMin, double precioMax) 
	{
		log.info ("Obteniendo obteniedo los productos con precio entre "+precioMin +" y "+ precioMax );
		return pp.productosConCiertaCaracteristica("PRECIOUNITARIO", precioMin, precioMax);
	}


	public void productosPorFechaVencimiento(Timestamp fechaVencimiento) {
		

	}


	public List<Object[]> productosEnRangoPesos(double pesoMin, double pesoMax)
	{
		log.info ("Obteniendo obteniedo los productos con peso entre" + pesoMin +" y "+ pesoMax);
		return pp.productosConCiertaCaracteristica("UNIDADDEMEDIDA='gr'", pesoMin, pesoMax);
	}


	public List<Object[]> productosEnRangoVolumen(double volumenMin, double volumenMax)
	{
		log.info ("Obteniendo obteniedo los productos con volumen entre" + volumenMin +" y "+ volumenMax);
		return pp.productosConCiertaCaracteristica("UNIDADDEMEDIDA='cm^3'", volumenMin, volumenMax);
	}


	public List<Object[]> productosDeProveedor(String nit) 
	{
		log.info ("Obteniendo obteniedo los productos que puede proveer el proveedor con NIT :" + nit);
		return pp.productosDeUnProveedor(nit);

	}

	/* ****************************************************************
	 * 			Requerimientos funcionales Iteracion 2
	 *****************************************************************/
	/**
	 * Solicitar carrito
	 * @param tipoDocumento
	 * @param numeroCliente
	 */
	public void solicitarCarrito(String tipoDocumento, String numeroCliente)
	{
		pp.solicitarCarrito(tipoDocumento,numeroCliente);
	}
	
	/**
	 * Adicionar prod a car
	 * @param tipoDocumento
	 * @param numeroCliente
	 * @param idEstante
	 * @param idProducto
	 * @param cantidad
	 * @return
	 */
	public boolean adicionarProductoACarrito(String tipoDocumento, String numeroCliente, long idEstante, String idProducto, int cantidad)
	{
		return pp.adicionarProductoACarrito(tipoDocumento, numeroCliente, idEstante, idProducto, cantidad);
	}
	
	/**
	 * devolver prod de car
	 * @param tipoDocumento
	 * @param numeroCliente
	 * @param idEstante
	 * @param idProducto
	 * @param cantidad
	 * @return
	 */
	public boolean devolverProductoDelCarrito(String tipoDocumento, String numeroCliente, long idEstante, String idProducto, int cantidad)
	{
		return pp.devolverProductoDelCarrito(tipoDocumento, numeroCliente, idEstante, idProducto, cantidad);
	}
	
	/**
	 * pagar car
	 * @param tipoDocumento
	 * @param numeroCliente
	 * @param sucursal
	 * @return
	 */
	public boolean pagarCompraCarrito(String tipoDocumento, String numeroCliente, long sucursal)
	{
		return pp.pagarCompraCarrito(tipoDocumento, numeroCliente, sucursal);
	}
	
	/**
	 * Anandonar car
	 * @param tipoDocumento
	 * @param numeroCliente
	 * @return
	 */
	public boolean abandonarCarrito(String tipoDocumento, String numeroCliente)
	{
		return pp.abandonarCarrito(tipoDocumento, numeroCliente);
	}
	
	/**
	 * recolect prod abandon
	 * @return
	 */
	public boolean recolectarProductosAbandonados()
	{
		return pp.recolectarProductosAbandonados();
	}
	/**
	 * consolidar pedidos
	 */
	public void consolidarPedidos()
	{
		pp.consolidarPedidos();
	}
	/**
	 * registrar llegada ped consolid
	 * @param codigoPedido
	 * @param fechaLlegada
	 * @param cantidadProductos
	 * @param calidadProductos
	 * @param calificacion
	 */
	public void registrarLlegadaPedidoConsolidado(long codigoPedido, Timestamp fechaLlegada, int cantidadProductos, String calidadProductos, String calificacion)
	{
		pp.registrarLlegadaPedidoConsolidado(codigoPedido,fechaLlegada,cantidadProductos,calidadProductos,calificacion);
	}
	
	/**
	 * Analizar op
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public String analizarOperacion(Timestamp fechaInicio, Timestamp fechaFin)
	{
		return pp.analizarOperacion(fechaInicio,fechaFin);
	}
	
	/**
	 * client. fec
	 * @param idSucursal
	 * @return
	 */
	public String clientesFrecuentes(long idSucursal)
	{
		log.info ("Obteniendo los clientes frecuentes de la sucursal: " + idSucursal);
		return pp.clientesFrecuentes(idSucursal);
	}
	/**
	 * prod. poca demanda
	 */
	public void productosPocaDemanda()
	{
		pp.productosPocaDemanda();
	}


}
