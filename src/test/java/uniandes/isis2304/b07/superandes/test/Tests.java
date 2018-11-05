package uniandes.isis2304.b07.superandes.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.b07.superandes.negocio.SuperAndes;
import uniandes.isis2304.b07.superandes.persistencia.PersistenciaSuperAndes;

/**
 * Clase con los métdos de prueba de funcionalidad sobre TIPOBEBIDA
 * @author Germán Bravo
 *
 */
public class Tests
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD también
	 */
	private static final String CONFIG_TABLAS_A = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
	/**
	 * La clase que se quiere probar
	 */
    private SuperAndes superAndes;
	
    /* ****************************************************************
	 * 			Métodos de prueba para la tabla TipoBebida - Creación y borrado
	 *****************************************************************/
	/**
	 * Método que prueba las operaciones sobre la tabla TipoBebida
	 * 1. Adicionar un tipo de bebida
	 * 2. Listar el contenido de la tabla con 0, 1 y 2 registros insertados
	 * 3. Borrar un tipo de bebida por su identificador
	 * 4. Borrar un tipo de bebida por su nombre
	 */
    @Test
	public void CRDSuperAndes() 
	{
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando las operaciones CRD sobre SuperAndes");
			superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_A));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de CRD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de CRD de SuperAndes incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de superAndes y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
    	try
		{
			superAndes.registrarProveedor("TESTOKO", "TEST");
			superAndes.registrarSucursal("TEST", "NA", "NA", "NA", "NA");
			superAndes.registrarPersonaNatural("CC", "TESTNATURAL", "NA", "NA");
			superAndes.registrarPersonaJuridica("TESTJURIDICA", "NA", "NA");
		
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla TipoBebida.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas sobre la tabla TipoBebida");
		}
		finally
		{
			
    		superAndes.cerrarUnidadPersistencia ();    		
		}
	}
    	
    	
    	@Test
    	public void CRDSuperAndesConLlenadoTablas() 
    	{
        	// Probar primero la conexión a la base de datos
    		try
    		{
    			log.info ("Probando las operaciones CRD sobre SuperAndes");
    			superAndes = new SuperAndes (openConfig (CONFIG_TABLAS_A));
    		}
    		catch (Exception e)
    		{
//    			e.printStackTrace();
    			log.info ("Prueba de CRD de SuperAndes incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
    			log.info ("La causa es: " + e.getCause ().toString ());

    			String msg = "Prueba de CRD de SuperAndes incompleta. No se pudo conectar a la base de datos !!.\n";
    			msg += "Revise el log de superAndes y el de datanucleus para conocer el detalle de la excepción";
    			System.out.println (msg);
    			fail (msg);
    		}
    		
    		// Ahora si se pueden probar las operaciones
        	try
    		{
    			superAndes.registrarEstante(1, "NA", 2, 2, 2, 2);
    			superAndes.registrarBodega(1, 2, 2, 3, 3);
    			double[]precios=new double[1];
    			precios[0]=1;
    			double[]cantidad=new double[1];
    			cantidad[0]=1;
    			String[] codigos=new String[1];
    			codigos[0]="fc9847d6";
    			superAndes.registrarPedido("1",codigos , cantidad, precios, "400500080", new Timestamp(29), 200.0);
    		}
    		catch (Exception e)
    		{
//    			e.printStackTrace();
    			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla TipoBebida.\n";
    			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
    			System.out.println (msg);

        		fail ("Error en las pruebas ");
    		}
    		finally
    		{
    			
        		superAndes.cerrarUnidadPersistencia ();    		
    		}
	}


	/* ****************************************************************
	 * 			Métodos de configuración
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración de tablas válido");
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de tablas válido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }	
}
