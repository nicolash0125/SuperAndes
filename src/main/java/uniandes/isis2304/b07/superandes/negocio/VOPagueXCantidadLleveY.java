package uniandes.isis2304.b07.superandes.negocio;

public interface VOPagueXCantidadLleveY {
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return el id de la promocion pague x cantidad lleve y cantidad
	 */
	public long getId();
	
	/**
	 * @return la cantidad que paga el cliente
	 */
	public int getCantidadPaga();
	
	/**
	 * @return la cantidad que lleva el cliente
	 */
	public int getCantidadLleva();
	
	/**
	 * @return id de la promocion generica
	 */
	public long getIdPromocion();
}
