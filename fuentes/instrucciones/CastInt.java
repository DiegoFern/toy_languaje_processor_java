package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>CastInt</code>. Convierte a entero el dato de la cima de la
 * pila.
 * 
 */
public class CastInt implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		if (mp.getPila().peek() instanceof Float) {
			Float cima = (Float) mp.getPila().pop();
			mp.getPila().push(cima.intValue());
		}
	}

	public String toString() {
		return "Cast a entero";
	}

}
