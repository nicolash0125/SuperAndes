package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;

public class Pedido implements VOPedido{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long id;
	
	private Timestamp fechaEntrega;
	
	private double precioTotal;
	
	private String estadoOrden;
	
	private String nitProveedor;

	public Pedido(PersistenceManager pm, String idSucursal, String[] codigosProductos, String nitProveedor2,
			Timestamp fechaPrevista, double precioTotal2) {
		// TODO hacer este constructor
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the precioTotal
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the estadoOrden
	 */
	public String getEstadoOrden() {
		return estadoOrden;
	}

	/**
	 * @param estadoOrden the estadoOrden to set
	 */
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	/**
	 * @return the nitProveedor
	 */
	public String getNitProveedor() {
		return nitProveedor;
	}

	/**
	 * @param nitProveedor the nitProveedor to set
	 */
	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	
	
	
}
