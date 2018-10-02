package uniandes.isis2304.b07.superandes.negocio;

public class PagueNUnidadesLleveMPromo implements VOPagueNUnidadesLleveMPromo{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long id;
	
	private int compraUnidades;
	
	private int llevaUnidades;
	
	private long idPromocion;

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
	 * @return the compraUnidades
	 */
	public int getCompraUnidades() {
		return compraUnidades;
	}

	/**
	 * @param compraUnidades the compraUnidades to set
	 */
	public void setCompraUnidades(int compraUnidades) {
		this.compraUnidades = compraUnidades;
	}

	/**
	 * @return the llevaUnidades
	 */
	public int getLlevaUnidades() {
		return llevaUnidades;
	}

	/**
	 * @param llevaUnidades the llevaUnidades to set
	 */
	public void setLlevaUnidades(int llevaUnidades) {
		this.llevaUnidades = llevaUnidades;
	}

	/**
	 * @return the idPromocion
	 */
	public long getIdPromocion() {
		return idPromocion;
	}

	/**
	 * @param idPromocion the idPromocion to set
	 */
	public void setIdPromocion(long idPromocion) {
		this.idPromocion = idPromocion;
	}
	
	
}
