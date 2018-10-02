package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

public class Promocion implements VOPromocion{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private String codigoPromo;
	
	private Timestamp fechaTerminacion;

	
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
	 * @return the fechaTerminacion
	 */
	public Timestamp getFechaTerminacion() {
		return fechaTerminacion;
	}

	/**
	 * @param fechaTerminacion the fechaTerminacion to set
	 */
	public void setFechaTerminacion(Timestamp fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}
	
	

}
