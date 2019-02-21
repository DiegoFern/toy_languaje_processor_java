package instrucciones;

import java.io.Serializable;

import maquina.MaquinaP;

public class VaciaPila implements Instruccion, Serializable {

	private static final long serialVersionUID = 1L;

	public void ejecuta(MaquinaP mp) {
		mp.getPila().clear();
	}

	public String toString() {
		return "Vacia-Pila";
	}
}
