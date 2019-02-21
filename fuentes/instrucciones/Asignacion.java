package instrucciones;

import java.io.Serializable;

import semantica.TablaSimbolos.TIPO;
import maquina.MaquinaP;

/**
 * Instruccion <code>Asignacion</code>. Guarda el contenido de la cima de la
 * pila en la direccion de memoria dada. Si el tipo del primero operando es real
 * y el del segundo es entero, convierte el segundo operando a real.
 * 
 */
public class Asignacion implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;
	private int dir;
	private TIPO tipo;

	/**
	 * Construye una instruccion <code>Asignacion</code>.
	 * 
	 * @param dir
	 *            direccion de la memoria de datos sobre la que se va a copiar
	 *            el contenido de la cima de la pila.
	 * @param tipo
	 *            tipo de la variable contenida en la direccion de memoria
	 *            <code>dir</code>.
	 */
	public Asignacion(int dir, TIPO tipo) {
		this.dir = dir;
		this.tipo = tipo;
	}

	public void ejecuta(MaquinaP mp) {
		if (tipo == TIPO.real && mp.getPila().peek() instanceof Integer) {
			Integer cima = (Integer) mp.getPila().pop();
			mp.getPila().push(cima.floatValue());
		}
		mp.getMemDatos().put(dir, mp.getPila().peek());
	}

	public String toString() {
		return "Asignacion: " + dir;
	}
}
