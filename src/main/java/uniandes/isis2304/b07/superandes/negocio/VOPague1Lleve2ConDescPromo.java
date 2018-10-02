package uniandes.isis2304.b07.superandes.negocio;

public interface VOPague1Lleve2ConDescPromo {
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return el id de la promocion pague 1 lleve 2 con desc
	 */
	public long getId();
	
	/**
	 * @return porcentaje del 2do producto
	 */
	public double getPorcentaje();
	
	/**
	 * @return id de la promocion generica
	 */
	public long getIdPromocion();
}
