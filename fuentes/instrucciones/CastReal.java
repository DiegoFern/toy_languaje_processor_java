package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>CastReal</code>. Convierte a real el dato de la cima de la
 * pila.
 */
public class CastReal implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		if (mp.getPila().peek() instanceof Integer) {
			Integer cima = (Integer) mp.getPila().pop();
			mp.getPila().push(cima.floatValue());
		}
	}

	public String toString() {
		return "Cast a real";
	}

}
