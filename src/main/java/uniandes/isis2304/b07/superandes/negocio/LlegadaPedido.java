package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

public class LlegadaPedido implements VOLlegadaPedido{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	public long id;
	
	public long idSucursal;
	
	public Timestamp fechaEntrega;
	
	public int cantidadProductos;
	
	public String calidadProductos;
	
	public String calificacion;
	
	public long idPedido;

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
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
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
	 * @return the cantidadProductos
	 */
	public int getCantidadProductos() {
		return cantidadProductos;
	}

	/**
	 * @param cantidadProductos the cantidadProductos to set
	 */
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	/**
	 * @return the calidadProductos
	 */
	public String getCalidadProductos() {
		return calidadProductos;
	}

	/**
	 * @param calidadProductos the calidadProductos to set
	 */
	public void setCalidadProductos(String calidadProductos) {
		this.calidadProductos = calidadProductos;
	}

	/**
	 * @return the calificacion
	 */
	public String getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return the idPedido
	 */
	public long getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	
	
}
