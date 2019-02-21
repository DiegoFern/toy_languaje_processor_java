/* Generated By:JavaCC: Do not edit this line. Traductor.java */
package traductor;

import instrucciones.*;
import java.util.ArrayList;
import semantica.TablaSimbolos;
import semantica.TablaSimbolos.TIPO;
import semantica.FuncionesSemanticas;
import semantica.Tipo;
import semantica.Int;

public class Traductor implements TraductorConstants {

        boolean errProg = false;
        TablaSimbolos ts;
        FuncionesSemanticas f= new FuncionesSemanticas();
        ArrayList<Instruccion> cod = new ArrayList<Instruccion>();

        public static void main(String[] args)
                throws ParseException, java.io.FileNotFoundException {

                Traductor t = new Traductor(new
                                java.io.FileInputStream(args[0]));
                t.prog();
                System.out.println(t.ts);
                System.out.println(t.cod);
        }

        public boolean getError() {return errProg;}
        public ArrayList<Instruccion> getCode() {return cod;}

////////////////////////////////////////////////////////////////////////
// ////////////////////// Producciones ////////////////////////////// //
////////////////////////////////////////////////////////////////////////
  final public void prog() throws ParseException {
               Int dir=new Int();
         errProg = false;
    decs(dir);
    accs();
    jj_consume_token(0);
  }

////////////////////////////////////////////////////////////////////////
  final public void decs(Int dirDecs0) throws ParseException {
                StringBuilder idDec= new StringBuilder();
                Tipo tipoDec=new Tipo();
                Int dirDecs1= new Int();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tInt:
    case tReal:
      dec(idDec, tipoDec);
      decs(dirDecs1);
         dirDecs0.setValue(dirDecs1.getValue()+1);
        errProg = errProg || ts.existeId(idDec.toString());
        ts.aniadeID(idDec.toString(),tipoDec.getValue(),dirDecs1.getValue());
      break;
    default:
      jj_la1[0] = jj_gen;

         dirDecs0.setValue(1);
        ts = new TablaSimbolos();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void dec(StringBuilder idDec, Tipo tipoDec) throws ParseException {
         Tipo tip=new Tipo(); Token tok;
    tipo(tip);
         tipoDec.setValue(tip.getValue());
    tok = jj_consume_token(id);
         idDec.append(tok.image);
    jj_consume_token(pyc);
  }

////////////////////////////////////////////////////////////////////////
  final public void tipo(Tipo tipoTipo) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tInt:
      jj_consume_token(tInt);
         tipoTipo.setValue(TIPO.ent);
      break;
    case tReal:
      jj_consume_token(tReal);
         tipoTipo.setValue(TIPO.real);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void accs() throws ParseException {
    acc();
    raccs();
  }

////////////////////////////////////////////////////////////////////////
  final public void raccs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case litNat:
    case litReal:
    case opIn:
    case opOut:
    case opMenos:
    case opNot:
    case opCastInt:
    case opCastReal:
    case pa:
    case id:
      acc();
      raccs();
      break;
    default:
      jj_la1[2] = jj_gen;

    }
  }

////////////////////////////////////////////////////////////////////////
  final public void acc() throws ParseException {
              Tipo tipoE0 = new Tipo();
    expr0(tipoE0);
                if(tipoE0.getValue() == TIPO.err) {
                        errProg=true;
                        System.err.println("error de tipos en linea:"+
                                token.endLine+ " col:"+token.endColumn);
                }
                f.emite(cod, new VaciaPila());
    jj_consume_token(pyc);
  }

////////////////////////////////////////////////////////////////////////
  final public void expr0(Tipo tipoE0) throws ParseException {
                           Token t; Tipo tipoE1 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opIn:
      jj_consume_token(opIn);
      t = jj_consume_token(id);
                tipoE0.setValue(f.tipoDeU(opIn, ts.get(t.image).tipo));
                f.emite(cod, new Lee());
                f.emite(cod, new CimaDir(ts.get(t.image).dir));
      break;
    case opOut:
      jj_consume_token(opOut);
      expr1(tipoE1);
                f.emite(cod, new Imprime());
                tipoE0.setValue(f.tipoDeU(opOut, tipoE1.getValue()));
      break;
    case litNat:
    case litReal:
    case opMenos:
    case opNot:
    case opCastInt:
    case opCastReal:
    case pa:
    case id:
      expr1(tipoE1);
         tipoE0.setValue(tipoE1.getValue());
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr1(Tipo tipoE1) throws ParseException {
                           Tipo tipoE50 = new Tipo();
                                Tipo tipohR4 = new Tipo();
                                Tipo tipohR3 = new Tipo();
                                Tipo tipohR2 = new Tipo();
                                Tipo tipoR2 = new Tipo();
                                Tipo tipoR3 = new Tipo();
                                Tipo tipoR4 = new Tipo();
                                Tipo tipohR1 = new Tipo();
                                StringBuilder lexhR1 = new StringBuilder();
                                Token lex;
                                Tipo tipoR1 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case litNat:
    case litReal:
    case opMenos:
    case opNot:
    case opCastInt:
    case opCastReal:
    case pa:
      expr5o(tipoE50);
         tipohR4.setValue(tipoE50.getValue());
      res4(tipohR4, tipoR4);
         tipohR3.setValue(tipoR4.getValue());
      res3(tipohR3, tipoR3);
         tipohR2.setValue(tipoR3.getValue());
      res2(tipohR2,tipoR2);
         tipoE1.setValue(tipoR2.getValue());
      break;
    case id:
      /*------------------------------------------------------------------*/
              lex = jj_consume_token(id);
                tipohR1.setValue(f.tipoId(ts, lex.image));
                lexhR1.append(lex.image);
      res1(lexhR1, tipohR1, tipoR1);
          tipoE1.setValue(tipoR1.getValue());
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void res1(StringBuilder lexhR1, Tipo tipohR1, Tipo tipoR1) throws ParseException {
         Int opO1 = new Int(); Tipo tipoE1 = new Tipo();
         Tipo tipohR2 = new Tipo(); Tipo tipoR2 = new Tipo();
         Tipo tipohR3 = new Tipo(); Tipo tipoR3 = new Tipo();
         Tipo tipohR4 = new Tipo(); Tipo tipoR4 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opAsig:
      oper1(opO1);
      expr1(tipoE1);
                tipoR1.setValue(
                f.tipoDeB(opO1.getValue(),tipohR1.getValue(),tipoE1.getValue()));
                f.emite(cod, f.genCod1(ts, opO1.getValue(), lexhR1.toString()));
      break;
    default:
      jj_la1[5] = jj_gen;
                f.emite(cod, new ApilaDir(ts.get(lexhR1.toString()).dir));
                tipohR4.setValue(tipohR1.getValue());
      res4(tipohR4, tipoR4);
         tipohR3.setValue(tipoR4.getValue());
      res3(tipohR3, tipoR3);
         tipohR2.setValue(tipoR3.getValue());
      res2(tipohR2, tipoR2);
         tipoR1.setValue(tipoR2.getValue());
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper1(Int op) throws ParseException {
    jj_consume_token(opAsig);
                                  op.setValue(opAsig);
  }

////////////////////////////////////////////////////////////////////////
  final public void res2(Tipo tipohR2, Tipo tipoR2) throws ParseException {
         Int opO2 = new Int(); Tipo tipoE3 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opIgual:
    case opMenor:
    case opMayor:
    case opMenIg:
    case opMayIg:
    case opDistinto:
      oper2(opO2);
      expr3(tipoE3);
                tipoR2.setValue(f.tipoDeB(opO2.getValue(),
                        tipohR2.getValue(), tipoE3.getValue()));
                f.emite(cod, f.genCod2(opO2.getValue()));
      break;
    default:
      jj_la1[6] = jj_gen;

         tipoR2.setValue(tipohR2.getValue());
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper2(Int op) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opMayor:
      jj_consume_token(opMayor);
                   op.setValue(opMayor);
      break;
    case opMenor:
      jj_consume_token(opMenor);
                   op.setValue(opMenor);
      break;
    case opMayIg:
      jj_consume_token(opMayIg);
                   op.setValue(opMayIg);
      break;
    case opMenIg:
      jj_consume_token(opMenIg);
                   op.setValue(opMenIg);
      break;
    case opIgual:
      jj_consume_token(opIgual);
                   op.setValue(opIgual);
      break;
    case opDistinto:
      jj_consume_token(opDistinto);
                      op.setValue(opDistinto);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr3(Tipo tipoE3) throws ParseException {
         Tipo tipoE4 = new Tipo(); Tipo tipohR3 = new Tipo();
        Tipo tipoR3 = new Tipo();
    expr4(tipoE4);
                       tipohR3.setValue(tipoE4.getValue());
    res3(tipohR3, tipoR3);
                               tipoE3.setValue(tipoR3.getValue());
  }

////////////////////////////////////////////////////////////////////////
  final public void res3(Tipo tipohR30, Tipo tipoR30) throws ParseException {
         Int opO3= new Int(); Tipo tipoE4 = new Tipo();
         Tipo tipohR31 = new Tipo(); Tipo tipoR31 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opMenos:
    case opOr:
    case opSuma:
      oper3(opO3);
      expr4(tipoE4);
                f.emite(cod, f.genCod3(opO3.getValue()));
                tipohR31.setValue(f.tipoDeB(opO3.getValue(),
                        tipohR30.getValue(), tipoE4.getValue()));
      res3(tipohR31, tipoR31);
                                 tipoR30.setValue(tipoR31.getValue());
      break;
    default:
      jj_la1[8] = jj_gen;

            tipoR30.setValue(tipohR30.getValue());
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper3(Int op) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opSuma:
      jj_consume_token(opSuma);
                  op.setValue(opSuma);
      break;
    case opMenos:
      jj_consume_token(opMenos);
                   op.setValue(opMenos);
      break;
    case opOr:
      jj_consume_token(opOr);
                op.setValue(opOr);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr4(Tipo tipoE4) throws ParseException {
         Tipo tipoE5 = new Tipo(); Tipo tipohR4 = new Tipo();
         Tipo tipoR4 = new Tipo();
    expr5(tipoE5);
                       tipohR4.setValue(tipoE5.getValue());
    res4(tipohR4, tipoR4);
                               tipoE4.setValue(tipoR4.getValue());
  }

////////////////////////////////////////////////////////////////////////
  final public void res4(Tipo tipohR40, Tipo tipoR40) throws ParseException {
         Int opO4= new Int(); Tipo tipoE5 = new Tipo();
         Tipo tipohR41 = new Tipo(); Tipo tipoR41 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opAnd:
    case opMult:
    case opDiv:
    case opMod:
      oper4(opO4);
      expr5(tipoE5);
                f.emite(cod, f.genCod4(opO4.getValue()));
                tipohR41.setValue(f.tipoDeB(opO4.getValue(),
                        tipohR40.getValue(), tipoE5.getValue()));
      res4(tipohR41, tipoR41);
                                 tipoR40.setValue(tipoR41.getValue());
      break;
    default:
      jj_la1[10] = jj_gen;

            tipoR40.setValue(tipohR40.getValue());
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper4(Int op) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opMult:
      jj_consume_token(opMult);
                  op.setValue(opMult);
      break;
    case opDiv:
      jj_consume_token(opDiv);
                 op.setValue(opDiv);
      break;
    case opMod:
      jj_consume_token(opMod);
                 op.setValue(opMod);
      break;
    case opAnd:
      jj_consume_token(opAnd);
                 op.setValue(opAnd);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr5(Tipo tipoE5) throws ParseException {
                           Tipo tipoE50 = new Tipo(); Token tok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case id:
      tok = jj_consume_token(id);
                f.emite(cod, new ApilaDir(ts.get(tok.image).dir));
                tipoE5.setValue(f.tipoId(ts, tok.image));
      break;
    case litNat:
    case litReal:
    case opMenos:
    case opNot:
    case opCastInt:
    case opCastReal:
    case pa:
      expr5o(tipoE50);
                         tipoE5.setValue(tipoE50.getValue());
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr5o(Tipo tipoE50) throws ParseException {
                             Int op= new Int(); Tipo tipoE5 = new Tipo();
        Tipo tipoE6 = new Tipo(); Tipo tipoE60 = new Tipo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opMenos:
    case opNot:
      oper5a(op);
      expr5(tipoE5);
                f.emite(cod, f.genCod5a(op.getValue()));
                tipoE50.setValue(f.tipoDeU(op.getValue(), tipoE5.getValue()));
      break;
    case opCastInt:
    case opCastReal:
      oper5n(op);
      expr6(tipoE6);
                f.emite(cod, f.genCod5n(op.getValue()));
                tipoE50.setValue(f.tipoDeU(op.getValue(), tipoE6.getValue()));
      break;
    case litNat:
    case litReal:
    case pa:
      expr6o(tipoE60);
                tipoE50.setValue(tipoE60.getValue());
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper5a(Int op) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opMenos:
      jj_consume_token(opMenos);
                   op.setValue(opMenos);
      break;
    case opNot:
      jj_consume_token(opNot);
                 op.setValue(opNot);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void oper5n(Int op) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case opCastInt:
      jj_consume_token(opCastInt);
                     op.setValue(opCastInt);
      break;
    case opCastReal:
      jj_consume_token(opCastReal);
                      op.setValue(opCastReal);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr6(Tipo tipoE6) throws ParseException {
                           Tipo tipoE60 = new Tipo(); Token tok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case id:
      tok = jj_consume_token(id);
                f.emite(cod, new ApilaDir(ts.get(tok.image).dir));
                tipoE6.setValue(f.tipoId(ts, tok.image));
      break;
    case litNat:
    case litReal:
    case pa:
      expr6o(tipoE60);
                         tipoE6.setValue(tipoE60.getValue());
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////////////////////////////////////////////////////////////////////////
  final public void expr6o(Tipo tipoE60) throws ParseException {
                             Tipo tipoE0= new Tipo(); Token tok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case litNat:
      tok = jj_consume_token(litNat);
                f.emite(cod, new ApilaEntero(f.toInt(tok.image)));
                tipoE60.setValue(TIPO.ent);
      break;
    case litReal:
      /*------------------------------------------------------------------*/
              tok = jj_consume_token(litReal);
                f.emite(cod, new ApilaReal(f.toReal(tok.image)));
                tipoE60.setValue(TIPO.real);
      break;
    case pa:
      jj_consume_token(pa);
      expr0(tipoE0);
                tipoE60.setValue(tipoE0.getValue());
      jj_consume_token(pc);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public TraductorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[18];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc000,0xc000,0x7801800,0x7801800,0x6001800,0x10000,0x7e0000,0x7e0000,0x12000000,0x12000000,0xe8000000,0xe8000000,0x6001800,0x6001800,0x6000000,0x0,0x1800,0x1800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x2e,0x2e,0x2e,0x0,0x0,0x0,0x1,0x1,0x0,0x0,0x2e,0xe,0x0,0x6,0x28,0x8,};
   }

  /** Constructor with InputStream. */
  public Traductor(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Traductor(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TraductorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Traductor(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TraductorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Traductor(TraductorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TraductorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 18; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
