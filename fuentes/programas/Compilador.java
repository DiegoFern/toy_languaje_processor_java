package programas;

import instrucciones.Instruccion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import traductor.ParseException;
import traductor.Traductor;

/**
 * Traductor de codigo fuente a codigo de la maquina P.
 * 
 */
public class Compilador {

	/**
	 * Transforma el codigo fuente a codigo para la maquina P. Recibira los 2
	 * archivos por parametro y generara el codigo solo si el programa fuente es
	 * aceptado por nuestro traductor. Si no es aceptado, mostrara por la linea
	 * de comandos el listado de errores y la ubicacion de cada error en el
	 * codigo fuente (linea y columna)
	 * 
	 * @param args
	 *            <code>args[0]</code> es el fichero origen (codigo fuente);
	 *            <code>args[1]</code> es el fichero destino (codigo de maquina
	 *            P).
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			FileReader origen = null;
			try {
				origen = new FileReader(new File(args[0]));
				try {
					Traductor traductor = new Traductor(origen);
					traductor.prog();
					if (!traductor.getError()) {
						FileOutputStream fos = new FileOutputStream(new File(
								args[1]));
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						System.out.println("Instrucciones generadas:");
						for (Instruccion i : traductor.getCode()) {
							System.out.println(i);
						}
						oos.writeObject(traductor.getCode());
						oos.close();
					}
					
					else {
						System.out.println("El codigo es erroneo, no se genera fichero");
					}
					
				} catch (FileNotFoundException e) {
					System.err.println("Error: el fichero de destino no puede" +
					" ser creado o es inaccesible.");
				} catch (IOException e) {
					System.err.println("Error de lectura / escritura de ficheros");
				} catch (ParseException e) {
					System.err.println("Error sintactico: "+e.getMessage());
					e.printStackTrace();
				}
			} catch(FileNotFoundException e) {
				System.err.println("Error: el fichero de origen no existe o" +
						" es inaccesible.");
			}
		} else {
			System.err.println("USO: java Compilador fichero_origen" +
					" fichero_destino");
		}
	}
}
