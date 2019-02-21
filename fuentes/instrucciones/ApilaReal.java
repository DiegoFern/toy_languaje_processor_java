package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>ApilaReal</code>. Apila un numero real dado en la pila de
 * la maquina P.
 * 
 */
public class ApilaReal implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;
	private float real;

	/**
	 * Construye una instruccion <code>ApilaReal</code>.
	 * 
	 * @param real
	 *            numero real a apilar en la pila de la maquina P.
	 */
	public ApilaReal(float real) {
		this.real = real;
	}

	public void ejecuta(MaquinaP mp) {
		mp.getPila().push(real);
	}

	public String toString() {
		return "Apila real: " + real;
	}
}
