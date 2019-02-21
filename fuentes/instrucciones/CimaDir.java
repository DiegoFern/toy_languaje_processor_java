package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>CimaDir</code>. Guarda el contenido de la cima de la pila
 * en la direccion de memoria dada.

 */
public class CimaDir implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;
	private int dir;
	
	/**
	 * Construye una instruccion <code>CimaDir</code>.
	 * 
	 * @param dir
	 *            direccion de la memoria de datos sobre la que se va a copiar
	 *            el contenido de la cima de la pila.
	 */
	public CimaDir(int dir) {
		this.dir = dir;
	}
	
	public void ejecuta(MaquinaP mp) {
		mp.getMemDatos().put(dir, mp.getPila().peek());
	}

	public String toString(){
		return "Cima dir: " + dir;
	}
}
