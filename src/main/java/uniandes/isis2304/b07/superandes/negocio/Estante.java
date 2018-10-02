package uniandes.isis2304.b07.superandes.negocio;

public class Estante implements VOEstante{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long idSucursal;
	
	private long id;
	
	private String nombre;
	
	private long idTipoProducto;
	
	private double capacidadVolumen;
	
	private double capacidadTotalVolumen;
	
	private double capacidadPeso;
	
	private double capacidadTotalPeso;
	
	private double nivelDeAbastecimiento;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	/**
	 * @return the nivelDeAbastecimiento
	 */
	public double getNivelDeAbastecimiento() {
		return nivelDeAbastecimiento;
	}

	/**
	 * @param nivelDeAbastecimiento the nivelDeAbastecimiento to set
	 */
	public void setNivelDeAbastecimiento(double nivelDeAbastecimiento) {
		this.nivelDeAbastecimiento = nivelDeAbastecimiento;
	}
	
	
}
