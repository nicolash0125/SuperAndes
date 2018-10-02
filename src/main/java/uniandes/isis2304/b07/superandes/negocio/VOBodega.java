package uniandes.isis2304.b07.superandes.negocio;

public interface VOBodega {
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * @return el id de la sucursal de la bodega
	 */
	public long getIdSucursal();
	
	/**
	 * @return el id de la bodega
	 */
	public long getId();
	
	/**
	 * @return el id del tipo producto de la bodega
	 */
	public long getIdTipoProducto();
	
	/**
	 * @return la capacidad actual en volumen
	 */
	public double getCapacidadVolumen();
	
	/**
	 * @return la capacidad maxima en volumen
	 */
	public double getCapacidadTotalVolumen();
	
	/**
	 * @return la capacidad actual en peso
	 */
	public double getCapacidadPeso();
	
	/**
	 * @return la capacidad maxima en peso
	 */
	public double getCapacidadTotalPeso();
	
	/**
	 * @return Una cadena de caracteres con la información de la bodega
	 */
	@Override
	public String toString(); 

	/**
	 * Define la igualdad dos Bodegas
	 * @param b - La bodega a comparar
	 * @return true si tienen el mismo identificador 
	 */
	@Override
	public boolean equals (Object b); 
}
