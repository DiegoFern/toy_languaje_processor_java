package instrucciones;

import java.io.IOException;
import java.io.Serializable;

import semantica.TablaSimbolos.TIPO;

import maquina.MaquinaP;

/**
 * Instruccion <code>Lee</code>. Lee un dato usando el mecanismo de entrada de
 * la maquina P y lo coloca en la cima de la pila.
 * Si el dato no es del tipo que se esperaba, se aborta la ejecucion.
 * 
 */
public class Lee implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;
	// TODO no se si es correcto que lo del tipo se haga aqui

	public Lee() {
	}

	public void ejecuta(MaquinaP mp) {
		System.out.print("<<< ");
		String line = null;
		Object dato = null;
		try {
			line = mp.getReader().readLine();
			System.out.println();
			dato = Integer.parseInt(line);
		} catch (IOException e) {
			e.printStackTrace();
			mp.abortaLectura(TIPO.err);
		} catch (NumberFormatException e2) {
			try {
				dato = Float.parseFloat(line);
			} catch (Exception e) {
				mp.abortaLectura(TIPO.err);
			}
		}
		mp.getPila().push(dato);
	}
	
	public String toString() {
		return "Lee";
	}

}
