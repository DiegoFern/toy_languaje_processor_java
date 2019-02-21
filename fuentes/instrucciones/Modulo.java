package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Modulo</code>. Calcula el resto de dividir la subcima de la
 * pila por la cima, colocando el resultado en la cima.
 * Se aborta la ejecucion si el segundo operando es menor o igual a cero.
 * 
 */
public class Modulo implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Integer cima = (Integer) mp.getPila().pop();
		if (cima <= 0) {
			mp.abortaModuloNoPositivo();
		}
		Integer subcima = (Integer) mp.getPila().pop();
		mp.getPila().push(subcima % cima);
	}

	public String toString() {
		return "Modulo";
	}
}
