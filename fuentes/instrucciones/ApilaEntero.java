package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>ApilaEntero</code>. Apila el numero entero dado en la pila
 * de la maquina P.
 */
public class ApilaEntero implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;
	private int entero;

	/**
	 * Construye una instruccion <code>ApilaEntero</code>.
	 * 
	 * @param entero
	 *            numero entero a apilar en la pila de la maquina P.
	 */
	public ApilaEntero(int entero) {
		this.entero = entero;
	}

	public void ejecuta(MaquinaP mp) {
		mp.getPila().push(entero);
	}

	public String toString() {
		return "Apila entero: " + entero;
	}
}
