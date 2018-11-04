package uniandes.isis2304.b07.superandes.negocio;

public class Carrito {
	private long numDocumento;
	private String tipoDocumento;
	private int cantidad;
	private int abandonado;
	private String producto;
	
	
	public Carrito(long numDocumento, String tipoDocumento, int cantidad, int abandonado, String producto) {
	
		this.numDocumento = numDocumento;
		this.tipoDocumento = tipoDocumento;
		this.cantidad = cantidad;
		this.abandonado = abandonado;
		this.producto = producto;
	}
	/**
	 * @return the numDocumento
	 */
	public long getNumDocumento() {
		return numDocumento;
	}
	/**
	 * @param numDocumento the numDocumento to set
	 */
	public void setNumDocumento(long numDocumento) {
		this.numDocumento = numDocumento;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the abandonado
	 */
	public int getAbandonado() {
		return abandonado;
	}
	/**
	 * @param abandonado the abandonado to set
	 */
	public void setAbandonado(int abandonado) {
		this.abandonado = abandonado;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
}
