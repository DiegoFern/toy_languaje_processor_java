package semantica;

import java.util.HashMap;

/**
 * Parte del Analizador Sintactico asignatura PLG
 */
public class TablaSimbolos {
	
	/**
	 * tipos permitidos en la tabla
	 */
	public enum TIPO{
		ent,real,err,
	};
	
	
	/**
	 * Entrada de la tabla de simbolos
	 * contiene un tipo y una direccion
	 *
	 */
	public class EntradaTs{
		public TIPO tipo;
		public int dir;
		EntradaTs(TIPO tipo,int dir){
			this.tipo=tipo; this.dir=dir;
		}
		public String toString() {
			return "<"+tipo+":"+dir+">";
		}
	}
	
	/**
	 * estructura que guarda la informacion de la tabla
	 */
	private HashMap<String, EntradaTs > map;
	
	
	/**
	 * crea una tabla de simbolos vacia
	 */
	public TablaSimbolos() {
		map = new HashMap<String, EntradaTs>();
	}
	
	
	/**
	 * Produce la tabla de simbolos que resulta de aniadir el identificador 
	 * id de Tipo tipo, a la tabla, en la direccion dir.
	 * 
	 * @param id identificador no case-sensitive
	 * @oaram t tipo basico
	 * @param dir direccion
	 */
	public boolean aniadeID(String id, TIPO t, int dir){
		if(map.containsKey(id.toLowerCase()))return false;
		EntradaTs e = new EntradaTs(t, dir);
		map.put(id.toLowerCase(), e);
		return true;
	}
	
	/**
	 * Produce la tabla de simbolos que resulta de aniadir el identificador 
	 * id de Tipo tipo, a la tabla, en la direccion dir.
	 * 
	 * @param id  no case-sensitive
	 * @param e
	 */
	public boolean aniadeID(String id, EntradaTs e){
		if(map.containsKey(id.toLowerCase()))return false;
		map.put(id.toLowerCase(), e);
		return true;
	}
	
	/**
	 * Permite comprobar si el identificador id está en la tabla t. 
	 *  no case-sensitive
	 * @return cierto si está, y falso en otro caso.
	 */
	public boolean existeId(String id){
		return map.containsKey(id.toLowerCase());
	}
	
	/**
	 * Permite acceder a una entrada de la tabla de símbolos.
	 * @param id  no case-sensitive
	 * @return
	 */
	public EntradaTs get(String id){
		return map.get(id.toLowerCase());
	}
	
	public String toString() {
		StringBuffer s= new StringBuffer("TS {\n");
		for(java.util.Map.Entry<String, EntradaTs> e : map.entrySet()) {
			s.append(e+"\n");
		}
		return s.toString();
	}
	
}
