package semantica;

/**
 * Clase simple para facilitar el paso por referencia de enteros y
 * tener una traduccion mas directa
 */
public class Int {
	private int i;
	
	public Int() {i=-1;}
	public Int(int i){ this.i=i; }
	public int getValue() {return i;}
	public void setValue(int v) {i=v;}
	
}