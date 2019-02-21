package semantica;

import instrucciones.And;
import instrucciones.Or;
import instrucciones.CastInt;
import instrucciones.CastReal;
import instrucciones.CimaDir;
import instrucciones.Distinto;
import instrucciones.Divide;
import instrucciones.Igual;
import instrucciones.Instruccion;
import instrucciones.Mayor;
import instrucciones.MayorOIgual;
import instrucciones.Menor;
import instrucciones.MenorOIgual;
import instrucciones.MenosUnario;
import instrucciones.Modulo;
import instrucciones.Multiplica;
import instrucciones.Negacion;
import instrucciones.Resta;
import instrucciones.Suma;

import java.util.ArrayList;
import java.util.List;

import semantica.TablaSimbolos.EntradaTs;
import semantica.TablaSimbolos.TIPO;
import traductor.TraductorConstants;



/**
* Funciones semanticas
*/
public class FuncionesSemanticas implements TraductorConstants {
	
	/**
	 * Crea un objeto FuncionesSemanticas
	 */
	public  FuncionesSemanticas(){
	}
	
	/**
	 * Devuelve el tipo resultante de aplicar una
	 * operacion binaria
	 * 
	 * @param op
	 * @param tipo1
	 * @param tipo2
	 * @return
	 */
	public TIPO tipoDeB(int op, TIPO tipo1, TIPO tipo2){
		if(tipo1 == TIPO.err || tipo2 == TIPO.err) return TIPO.err;
		else if( op == opMenor || op == opMenIg||
			op == opMayor|| op == opIgual||
			op == opMayIg || op == opDistinto){
			return TIPO.ent;
		}
		else if( op == opSuma || op == opMult||
			op == opMenos || op == opDiv){
			if(tipo1 == TIPO.ent && tipo2 == TIPO.ent) return TIPO.ent;
			else return TIPO.real;
		}
		else if( op == opAnd || op == opMod||
			op == opOr){
			if(tipo1 == TIPO.ent && tipo2 == TIPO.ent) return TIPO.ent;
			else return TIPO.err;
		}
		else/*( op == opAsig)*/{
			if(tipo1 == TIPO.ent && tipo2 == TIPO.ent) return TIPO.ent;
			else if( (tipo1 == TIPO.real && tipo2 == TIPO.ent) ||
					 (tipo1 == TIPO.real && tipo2 == TIPO.real)){
				return TIPO.real;
			}
			else return TIPO.err;
		}
	}
	
	/**
	 * Devuelve el tipo resultante de aplicar una
	 * operacion unaria
	 * 
	 * @param op
	 * @param tipo
	 * @return
	 */
	public TIPO tipoDeU(int op, TIPO tipo){
		if(tipo == TIPO.err|| (tipo == TIPO.real && op == opNot))
			return TIPO.err;
		else if( op == opCastInt) return TIPO.ent;
		else if( op == opCastReal) return TIPO.real;
		else return tipo;
	}
	
	/**
	 * Devuelve el numero entero de un lexema
	 * 
	 * @param lex
	 * @return
	 * @throws ExcepcionTraductor
	 */
	public Integer toInt(String lex) {
		Integer i=-1;
		try{
			i=Integer.parseInt(lex);
		}catch(NumberFormatException e){
			System.err.println("error, numero demasiado largo");
		}
		return i;
	}
	
	/**
	 * Devuelve el numero real de un lexema
	 * @param lex
	 * @return
	 */
	public Float toReal(String lex){
		return Float.parseFloat(lex);
	}
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * @param ts
	 * @param cod
	 * @param op
	 * @param lex
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod1(TablaSimbolos ts, int op, String lex){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opAsig){
			cod.add(new CimaDir(ts.get(lex).dir));
		}
		return cod;
	}
	
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * 
	 * @param cod
	 * @param op
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod2(int op){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opMayor){
			cod.add(new Mayor());
		}
		else if(op==opMayor){
			cod.add(new Mayor());
		}
		else if(op==opMenor){
			cod.add(new Menor());
		}
		else if(op==opMayIg){
			cod.add(new MayorOIgual());
		}
		else if(op==opMenIg){
			cod.add(new MenorOIgual());
		}
		else if(op==opIgual){
			cod.add(new Igual());
		}
		else if(op==opDistinto){
			cod.add(new Distinto());
		}
		return cod;
	}
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * 
	 * @param cod
	 * @param op
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod3(int op){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opSuma){
			cod.add(new Suma());
		}
		else if(op==opMenos){
			cod.add(new Resta());
		}
		else if(op==opOr){
			cod.add(new Or());
		}
		return cod;
	}
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * 
	 * @param cod
	 * @param op
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod4(int op){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opMult){
			cod.add(new Multiplica());
		}
		else if(op==opDiv){
			cod.add(new Divide());
		}
		else if(op==opMod){
			cod.add(new Modulo());
		}
		else if(op==opAnd){
			cod.add(new And());
		}	
		return cod;
	}
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * 
	 * @param cod
	 * @param op
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod5a(int op){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opMenos){
			cod.add(new MenosUnario());
		}
		else if(op==opNot){
			cod.add(new Negacion());
		}
		return cod;
	}
	
	/**
	 * Devuelve la lista de instrucciones resultante de añadir a la lista de
	 * instrucciones cod la instrucción generada a partir del resto de parámetros.
	 * 
	 * @param cod
	 * @param op
	 * @return lista de instrucciones
	 */
	public  List<Instruccion> genCod5n(int op){
		List<Instruccion> cod = new ArrayList<Instruccion>();
		if(op==opCastInt){
			cod.add(new CastInt());
		}
		else if(op==opCastReal){
			cod.add(new CastReal());
		}
		return cod;
	}
	
	
	/**
	 * Si el identificador id aparece en la tabla de simbolos t,
	 * entonces devuelve su tipo. Si no, devuelve error.
	 * @param ts
	 * @param id
	 * @return
	 */
	public TIPO tipoId(TablaSimbolos ts, String id){
		EntradaTs e=ts.get(id);
		if( e==null)return TIPO.err;
		return e.tipo;
	}
	
	/**
	 * Convierte una categoria lexica(ent, real o err)
	 * a su tipo correspondiente
	 * @param c
	 * @return
	 */
	public TIPO toTipo(int c)
	{
		if(c==tInt)return TIPO.ent;
		else if(c==tReal)return TIPO.real;
		else return TIPO.err;
	}


	/**
	 * Concatena dos listas de instrucciones
	 * 
	 * @param codh
	 * @param cod
	 * @return lista de instrucciones resultante de concatenar
	 * las dos listas de instrucciones
	 */
	public List<Instruccion> emite(List<Instruccion> codh,
			List<Instruccion> cod) {
		codh.addAll(cod);
		return codh;
	}

	/**
	 * Aniade una instruccion a una lista de instrucciones
	 * 
	 * @param cod1
	 * @param cod2
	 * @return lista de instrucciones resultante de aniadir 
	 * la instrucciona a la lista
	 */
	public List<Instruccion> emite(List<Instruccion> cod1, Instruccion cod2) {
			cod1.add(cod2);
			return cod1;
	}

}
