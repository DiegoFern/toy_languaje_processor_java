package programas;

import instrucciones.Instruccion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import maquina.MaquinaP;

/**
 * Interprete que simula el comportamiento de la maquina P.
 * 
 */
public class Interprete {

	/**
	 * Simula el comportamiento de la maquinaP. Ejecuta las instrucciones
	 * encontradas en el fichero recibido. 
	 * Tiene dos modos: 
	 * - modo normal: el unico resultado visible es el producido por las 
	 * instrucciones de lectura y escritura.
	 * - modo traza: se muestra una traza con los distintos pasos de ejecucion.
	 * 
	 * @param args
	 *            <code>args[0]</code> es el fichero con las instrucciones;
	 *            <code>args[1]</code> es opcional, e indica si el interprete se
	 *            ejecuta en modo traza.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if (args.length == 1 || args.length == 2) {
			try {
				List<Instruccion> programa = new ArrayList<Instruccion>();
				FileInputStream fis = new FileInputStream(args[0]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				programa = (ArrayList<Instruccion>) ois.readObject();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				MaquinaP maquina = new MaquinaP(programa, br);
				maquina.ejecuta((args.length == 2)
						&& (args[1].contains("-traza")));
			} catch (FileNotFoundException e) {
				System.err
						.println("Error: el fichero de instrucciones no existe"
								+ " o es inaccesible.");
			} catch (IOException e) {
				System.err.println("Error de lectura / escritura de ficheros.");
			} catch (ClassNotFoundException e) {
				System.err.println("Error en la lectura de las instrucciones."
						+ " Vuelva a generar el fichero de instrucciones.");
			}
		} else {
			System.err.println("USO: java Interprete fichero_instrucciones"
					+ " [-traza]");
		}
	}
}
