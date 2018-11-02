package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;

public class Venta implements VOVenta{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long numeroVenta;
	
	private String tipoDocCliente;
	
	private String numDocCliente;
	
	private Timestamp fechaVenta;
	
	private double total;
	
	private double totalImpuestos;
	
	private long sucursal;
	
	public Venta() {
		// TODO Terminar este constructor
	}

	public Venta(long numeroVenta, String tipodocumento, String documento, double precioTotal) {
		this.numeroVenta=numeroVenta;
		this.tipoDocCliente=tipodocumento;
		this.numDocCliente=documento;
		this.total=precioTotal;
	}

	/**
	 * @return the numeroVenta
	 */
	public long getNumeroVenta() {
		return numeroVenta;
	}

	/**
	 * @param numeroVenta the numeroVenta to set
	 */
	public void setNumeroVenta(long numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	/**
	 * @return the tipoDocCliente
	 */
	public String getTipoDocCliente() {
		return tipoDocCliente;
	}

	/**
	 * @param tipoDocCliente the tipoDocCliente to set
	 */
	public void setTipoDocCliente(String tipoDocCliente) {
		this.tipoDocCliente = tipoDocCliente;
	}

	/**
	 * @return the numDocCliente
	 */
	public String getNumDocCliente() {
		return numDocCliente;
	}

	/**
	 * @param numDocCliente the numDocCliente to set
	 */
	public void setNumDocCliente(String numDocCliente) {
		this.numDocCliente = numDocCliente;
	}

	/**
	 * @return the fechaVenta
	 */
	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta the fechaVenta to set
	 */
	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the totalImpuestos
	 */
	public double getTotalImpuestos() {
		return totalImpuestos;
	}

	/**
	 * @param totalImpuestos the totalImpuestos to set
	 */
	public void setTotalImpuestos(double totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}

	/**
	 * @return the sucursal
	 */
	public long getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(long sucursal) {
		this.sucursal = sucursal;
	}

	public String toString(){
		return "        "+numeroVenta+"                "+tipoDocCliente+"              "+numDocCliente+"       "+(fechaVenta.getYear()+1900)+"/"+(fechaVenta.getMonth()+1)+"/"+fechaVenta.getDay()+"      "+total+"        "+totalImpuestos+"        "+sucursal;
		
	}
	
	
}
