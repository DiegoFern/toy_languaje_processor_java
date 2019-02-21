package maquina;

import instrucciones.Instruccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Map.Entry;

import semantica.TablaSimbolos.TIPO;


/**
 * Maquina P capaz de ejecutar archivos de instrucciones.
 * 
 */
public class MaquinaP {
	
	private HashMap<Integer, Object> memoriaDatos;
	private List<Instruccion> programa;
	private int PC;
	private Stack<Object> pila;
	private int registroHalt;
	private BufferedReader reader;

	/**
	 * Crea una maquina P dada una lista de instrucciones y un buffer de
	 * lectura.
	 * 
	 * @param programa
	 *            lista de instrucciones a ejecutar.
	 * @param input
	 *            buffer de lectura.
	 */
	public MaquinaP(List<Instruccion> programa, BufferedReader input) {
		memoriaDatos = new HashMap<Integer, Object>();
		PC = 0;
		pila = new Stack<Object>();
		registroHalt = 1;
		this.reader = input;
		this.programa = programa;
	}
	
	/**
	 * Devuelve la pila de datos de la maquina.
	 * 
	 * @return pila de datos.
	 */
	public Stack<Object> getPila() {
		return pila;
	}
	
	/**
	 * Devuelve la memoria de datos de la maquina.
	 * 
	 * @return memoria de datos.
	 */
	public HashMap<Integer, Object> getMemDatos() {
		return memoriaDatos;
	}
	
	/**
	 * Devuelve el buffer de lectura.
	 * 
	 * @return buffer de lectura.
	 */
	public BufferedReader getReader() {
		return reader;
	}
	
	/**
	 * Ejecuta la lista de instrucciones. Si se activa el modo traza, se
	 * ejecutaran paso a paso, mostrando el estado de la pila y la memoria.
	 * 
	 * @param traza
	 *            indica si se debe ejecutar en modo traza.
	 */
	public void ejecuta(boolean traza) {
		if (programa.size() != 0)
			registroHalt = 0;
		while (registroHalt == 0) {
			if (traza) {
				mostrarTraza();
			}
			step();
		}
		pila.clear();
	}
	
	/**
	 * Ejecuta la instruccion apuntada por PC, e incrementa PC en 1.
	 */
	private void step() {
		if (PC >= programa.size())
			registroHalt = 1;
		else {
			Instruccion ins = programa.get(PC);
			ins.ejecuta(this);
			PC++;
		}
	}
	
	/**
	 * Espera a que el usuario pulse Enter para continuar. Si escribe "abortar"
	 * aborta la ejecucion de las instrucciones.
	 */
	private void esperaEnter() {
		if(PC < programa.size()) {
			System.out.print("Pulsa Enter para continuar...\n");
			try {
				if (reader.readLine().equals("abortar"))
					System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* --------------- Errores en tiempo de ejecucion ---------------- */
	
	/**
	 * Aborta la ejecucion de las instrucciones debido a un error de division
	 * por cero.
	 */
	public void abortaDivisionCero() {
		System.err.println("Error: division por cero.");
		System.err.println("Ejecucion abortada.");
		System.exit(1);
	}
	
	/**
	 * Aborta la ejecucion de las instrucciones debido a un error de modulo no
	 * positivo.
	 */
	public void abortaModuloNoPositivo() {
		System.err.println("Error: segundo operando de modulo no positivo.");
		System.err.println("Ejecucion abortada.");
		System.exit(1);
	}
	
	/**
	 * Aborta la ejecucion de las instrucciones debido a un error de lectura.
	 */
	public void abortaLectura(TIPO tipo) {
		switch(tipo) {
		case ent: 
			System.err.println("Error: se esperaba leer un numero entero.");
			break;
		case real:
			System.err.println("Error: se esperaba leer un numero real.");
			break;
		default:
			System.err.println("Error de lectura.");
		}
		System.err.println("Ejecucion abortada.");
		System.exit(1);
	}
	
	/* ---------- Representacion de memoria y pila para modo traza -------- */
	
	/**
	 * Muestra por la salida contenido de la pila y la memoria, y espera la
	 * interaccion del usuario para continuar.
	 */
	private void mostrarTraza() {
		StringBuffer traza = new StringBuffer();
		int separacion = 30;
		traza.append("[pila]" + getStringSep("[pila]", separacion)
				+ "[memoria]\n");
		int mayor = (pila.size() > memoriaDatos.size() ? pila.size()
				: memoriaDatos.size());
		Iterator<Entry<Integer, Object>> md = memoriaDatos.entrySet()
				.iterator();
		for (int i = 0; i < mayor; i++) {
			String linea = "      ";
			if (i < pila.size())
				linea = "[" + pila.get(pila.size() - 1 - i) + "]";
			if (md.hasNext()) {
				Entry<Integer, Object> entrada = md.next();
				linea += getStringSep(linea, separacion) + "["
						+ entrada.getKey() + ": " + entrada.getValue() + "]";
			}
			traza.append(linea + "\n");
		}
		if(PC < programa.size()) {
			traza.append("\nSiguiente instruccion: " + programa.get(PC));
			System.out.println(traza.toString());
			esperaEnter();
		} else {
			traza.append("\nPrograma terminado.");
			System.out.println(traza.toString());
		}
	}
	
	/**
	 * Devuelve una cadena de espacios de separacion.
	 * 
	 * @param inicioLinea
	 *            contenido de la parte izquierda de la linea.
	 * @param separacion
	 *            separacion maxima.
	 * @return cadena de espacios de separacion.
	 */
	private String getStringSep(String inicioLinea, int separacion) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < separacion - inicioLinea.length(); i++) {
			out.append(' ');
		}
		return out.toString();
	}
	
}

