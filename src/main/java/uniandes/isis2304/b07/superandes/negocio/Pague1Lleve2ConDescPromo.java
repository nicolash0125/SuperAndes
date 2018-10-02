package uniandes.isis2304.b07.superandes.negocio;

public class Pague1Lleve2ConDescPromo implements VOPague1Lleve2ConDescPromo{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long id;
	
	private double porcentaje;
	
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
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
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
