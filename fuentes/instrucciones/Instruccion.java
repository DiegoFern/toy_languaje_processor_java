package instrucciones;

import maquina.MaquinaP;

/**
 * Interfaz Instruccion.
 * 
 */
public interface Instruccion {

	/**
	 * Ejecuta las operaciones pertinentes en la maquina P recibida.
	 * 
	 * @param mp maquina P en la que ejecutar esta instruccion.
	 */
	public void ejecuta(MaquinaP mp);
	
}
