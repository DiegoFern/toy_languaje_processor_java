package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

/**
 * Instruccion <code>And</code>. Calcula la and logica de la subcima y la cima
 * de la pila, colocando el resultado en la cima.
 * 
 */
public class And implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		Integer b = (Integer) mp.getPila().pop();
		Integer a = (Integer) mp.getPila().pop();
		if (a != 0 && b != 0) {
			mp.getPila().push(new Integer(1));
		} else {
			mp.getPila().push(new Integer(0));
		}		
	}

	public String toString(){
		return "And";
	}
}
