package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>ApilaDir</code>. Apila el contenido de la direccion de la
 * memoria de datos dada en la pila de la maquina P.
 * 
 */
public class ApilaDir implements Serializable, Instruccion {

	private static final long serialVersionUID = 1L;
	private int dir;
	
	/**
	 * Construye una instruccion <code>ApilaDir</code>.
	 * 
	 * @param dir
	 *            direccion de la memoria de dato cuyo contenido se va a apilar
	 *            en la pila de la maquina P.
	 */
	public ApilaDir(int dir) {
		this.dir = dir;
	}
	
	public void ejecuta(MaquinaP mp) {
		if(mp.getMemDatos().get(dir) == null) {
			mp.getPila().push(0);
		} else {
			mp.getPila().push(mp.getMemDatos().get(dir));
		}
	}
	
	public String toString(){
		return "Apila dir: " + dir;
	}

}
