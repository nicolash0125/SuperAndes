package uniandes.isis2304.b07.superandes.negocio;

import java.sql.Timestamp;

public class Promocion implements VOPromocion{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long id;
	
	private Timestamp fechaTerminacion;

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
