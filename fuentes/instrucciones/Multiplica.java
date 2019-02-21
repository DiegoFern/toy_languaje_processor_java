package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Multiplica</code>. Multiplica el contenido de la subcima y
 * la cima de la pila, colocando el resultado en la cima.
 * Aplica la regla de alineamiento de tipos antes de operar.
 * 
 */
public class Multiplica implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Object cima = mp.getPila().pop();
		Object subcima = mp.getPila().pop();
		Object res = null;
		if (subcima instanceof Float) {
			if (cima instanceof Integer) {
				cima = new Float((Integer) cima);
			}
			res = (Float) subcima * (Float) cima;
		} else if (cima instanceof Float) {
			subcima = new Float((Integer) subcima);
			res = (Float) subcima * (Float) cima;
		} else {
			res = (Integer) subcima * (Integer) cima;
		}
		mp.getPila().push(res);
	}

	public String toString() {
		return "Multiplica";
	}
}
