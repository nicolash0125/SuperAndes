package uniandes.isis2304.b07.superandes.negocio;

public class Bodega implements VOBodega{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long idSucursal;
	
	private long id;
	
	private long idTipoProducto;
	
	private double capacidadVolumen;
	
	private double capacidadTotalVolumen;
	
	private double capacidadPeso;
	
	private double capacidadTotalPeso;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public Bodega(long idSucursal, long id, long idTipoProducto, double capacidadVolumen, double capacidadTotalVolumen,
			double capacidadPeso, double capacidadTotalPeso) 
	{
		this.idSucursal = idSucursal;
		this.id = id;
		this.idTipoProducto = idTipoProducto;
		this.capacidadVolumen = capacidadVolumen;
		this.capacidadTotalVolumen = capacidadTotalVolumen;
		this.capacidadPeso = capacidadPeso;
		this.capacidadTotalPeso = capacidadTotalPeso;
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
	 * @return the idTipoProducto
	 */
	public long getIdTipoProducto() {
		return idTipoProducto;
	}

	/**
	 * @param idTipoProducto the idTipoProducto to set
	 */
	public void setIdTipoProducto(long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	/**
	 * @return the capacidadVolumen
	 */
	public double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	/**
	 * @param capacidadVolumen the capacidadVolumen to set
	 */
	public void setCapacidadVolumen(double capacidadVolumen) {
		this.capacidadVolumen = capacidadVolumen;
	}

	/**
	 * @return the capacidadTotalVolumen
	 */
	public double getCapacidadTotalVolumen() {
		return capacidadTotalVolumen;
	}

	/**
	 * @param capacidadTotalVolumen the capacidadTotalVolumen to set
	 */
	public void setCapacidadTotalVolumen(double capacidadTotalVolumen) {
		this.capacidadTotalVolumen = capacidadTotalVolumen;
	}

	/**
	 * @return the capacidadPeso
	 */
	public double getCapacidadPeso() {
		return capacidadPeso;
	}

	/**
	 * @param capacidadPeso the capacidadPeso to set
	 */
	public void setCapacidadPeso(double capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}

	/**
	 * @return the capacidadTotalPeso
	 */
	public double getCapacidadTotalPeso() {
		return capacidadTotalPeso;
	}

	/**
	 * @param capacidadTotalPeso the capacidadTotalPeso to set
	 */
	public void setCapacidadTotalPeso(double capacidadTotalPeso) {
		this.capacidadTotalPeso = capacidadTotalPeso;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bodega [idSucursal=" + idSucursal + ", id=" + id + ", idTipoProducto=" + idTipoProducto
				+ ", capacidadVolumen=" + capacidadVolumen + ", capacidadTotalVolumen=" + capacidadTotalVolumen
				+ ", capacidadPeso=" + capacidadPeso + ", capacidadTotalPeso=" + capacidadTotalPeso + "]";
	}
	
	
	
	
}
