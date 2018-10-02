package uniandes.isis2304.b07.superandes.negocio;

public class PagueXCantidadLleveY implements VOPagueXCantidadLleveY{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long id;
	
	private int cantidadPaga;
	
	private int cantidadLleva;
	
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
	 * @return the cantidadPaga
	 */
	public int getCantidadPaga() {
		return cantidadPaga;
	}

	/**
	 * @param cantidadPaga the cantidadPaga to set
	 */
	public void setCantidadPaga(int cantidadPaga) {
		this.cantidadPaga = cantidadPaga;
	}

	/**
	 * @return the cantidadLleva
	 */
	public int getCantidadLleva() {
		return cantidadLleva;
	}

	/**
	 * @param cantidadLleva the cantidadLleva to set
	 */
	public void setCantidadLleva(int cantidadLleva) {
		this.cantidadLleva = cantidadLleva;
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
