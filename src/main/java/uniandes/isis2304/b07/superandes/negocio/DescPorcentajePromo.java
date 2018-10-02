package uniandes.isis2304.b07.superandes.negocio;

public class DescPorcentajePromo implements VODescPorcentajePromo{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private String codigoPromo;
	
	private double porcentaje;
	
	

	/**
	 * @return the codigoPromo
	 */
	public String getCodigoPromo() {
		return codigoPromo;
	}

	/**
	 * @param codigoPromo the codigoPromo to set
	 */
	public void setCodigoPromo(String codigoPromo) {
		this.codigoPromo = codigoPromo;
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


	
	
}
