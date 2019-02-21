package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Negacion</code>. Realiza la inversion logica del dato de la
 * cima de la pila, colocando el resultado en la cima.
 * 
 */
public class Negacion implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Integer cima = (Integer) mp.getPila().pop();
		if (cima == 0) {
			mp.getPila().push(1);
		} else {
			mp.getPila().push(0);
		}
	}

	public String toString() {
		return "Negacion";
	}
}
