package uniandes.isis2304.b07.superandes.negocio;

public class Producto implements VOProducto{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	public String codigoBarras;
	
	public String nombre;
	
	public String presentacion;
	
	public String marca;
	
	public long categoria;
	
	public String unidadMedida;
	
	public String especificacionEmpacado;

	public Producto(String codigosBarras, String nombres, String presentaciones, String marcas,  String unidadesMedida,
			String especificacionesEmpacado, long categoria) {
		
		codigoBarras = codigosBarras;
		
		nombre = nombres;
		
		presentacion = presentaciones;
		
		marca = marcas;
		
		this.categoria = categoria;
		
		unidadMedida = unidadesMedida;
		
		especificacionEmpacado = especificacionesEmpacado;
		
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
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
	 * @return the presentacion
	 */
	public String getPresentacion() {
		return presentacion;
	}

	/**
	 * @param presentacion the presentacion to set
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * @return the categoria
	 */
	public long getCantidad() {
		return categoria;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(long cantidad) {
		this.categoria = cantidad;
	}

	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * @return the especificacionEmpacado
	 */
	public String getEspecificacionEmpacado() {
		return especificacionEmpacado;
	}

	/**
	 * @param especificacionEmpacado the especificacionEmpacado to set
	 */
	public void setEspecificacionEmpacado(String especificacionEmpacado) {
		this.especificacionEmpacado = especificacionEmpacado;
	}
	
	
}
