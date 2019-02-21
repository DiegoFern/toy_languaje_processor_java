package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>Imprime</code>. Imprime por la salida estandar el contenido
 * de la cima de la pila.
 * 
 */
public class Imprime implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		System.out.println(">>> " + mp.getPila().peek() + "\n");
	}

	public String toString() {
		return "Imprime";
	}

}
