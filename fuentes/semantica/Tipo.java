package semantica;

import semantica.TablaSimbolos.TIPO;


/**
 * Clase simple para facilitar el paso por referencia del
 * enumerado TIPO (clase TablaSimbolos)
 * tener una traduccion mas directa
 */
public class Tipo {
	private TIPO t;
	
	public Tipo() {t=TIPO.err;}
	public Tipo(TIPO t){ this.t=t; }
	public TIPO getValue() {return t;}
	public void setValue(TIPO v) {t=v;}
	
}
