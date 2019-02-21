package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Igual</code>. Determina si la subcima de la pila es igual
 * a la cima, colocando el resultado en la cima.
 * Antes de operar, aplica la regla de alineamiento de tipos.
 * 
 */
public class Igual implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Object cima = mp.getPila().pop();
		Object subcima = mp.getPila().pop();
		Object res = null;
		if (subcima instanceof Float) {
			if (cima instanceof Integer) {
				cima = new Float((Integer) cima);
			}
			res = new Integer(((Float) subcima == (Float) cima ? 1 : 0));
		} else if (cima instanceof Float) {
			subcima = new Float((Integer) subcima);
			res = new Integer(((Float) subcima == (Float) cima ? 1 : 0));
		} else {
			res = new Integer(((Integer) subcima == (Integer) cima ? 1 : 0));
		}
		mp.getPila().push(res);
	}

	public String toString() {
		return "Igual";
	}
}
