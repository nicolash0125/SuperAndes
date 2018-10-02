package uniandes.isis2304.b07.superandes.negocio;

public interface VOPagueNUnidadesLleveMPromo {
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return el id de la promocion pague n unidades lleve m unidades
	 */
	public long getId();
	
	/**
	 * @return las unidades que paga el cliente
	 */
	public int getCompraUnidades();
	
	/**
	 * @return las unidades que lleva el cliente
	 */
	public int getLlevaUnidades();
	
	/**
	 * @return id de la promocion generica
	 */
	public long getIdPromocion();
}
