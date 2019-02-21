package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Divide</code>. Divide el contenido de la subcima de la pila
 * por el de la cima, colocando el resultado en la cima.
 * Aplica la regla de alineamiento de tipos antes de operar.
 * Si el segundo operando es 0, se aborta la ejecucion.

 */
public class Divide implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Object cima = mp.getPila().pop();
		if(cima.equals(0)) {
			mp.abortaDivisionCero();
		}
		Object subcima = mp.getPila().pop();
		Object res = null;
		if (subcima instanceof Float) {
			if (cima instanceof Integer) {
				cima = new Float((Integer) cima);
			}
			res = (Float) subcima / (Float) cima;
		} else if (cima instanceof Float) {
			subcima = new Float((Integer) subcima);
			res = (Float) subcima / (Float) cima;
		} else {
			res = (Integer) subcima / (Integer) cima;
		}
		mp.getPila().push(res);
	}

	public String toString() {
		return "Divide";
	}
}