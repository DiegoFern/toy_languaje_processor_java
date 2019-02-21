package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>MenosUnario</code>. Invierte el signo del dato de la cima
 * de la pila, colocando el resultado en la cima.
 * 
 */
public class MenosUnario implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Object cima = mp.getPila().pop();
		if (cima instanceof Float) {
			mp.getPila().add(-(Float)cima);
		} else {
			mp.getPila().add(-(Integer)cima);
		}
	}

	public String toString() {
		return "Menos unario";
	}
}
