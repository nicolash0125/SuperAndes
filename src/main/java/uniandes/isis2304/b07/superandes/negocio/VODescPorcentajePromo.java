package uniandes.isis2304.b07.superandes.negocio;

public interface VODescPorcentajePromo {
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return el id de la promocion porcentaje
	 */
	public long getId();
	
	/**
	 * @return porcentaje de descuento
	 */
	public double getPorcentaje();
	
	/**
	 * @return id de la promocion generica
	 */
	public long getIdPromocion();
}
