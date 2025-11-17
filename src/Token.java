enum TK {NUMERO, I, MAIS, MENOS, MULT, DIVI, POT, RAIZ, CONJUGADO, PAR_ESQ, PAR_DIR, FIM}

public class Token {
	TK t;
	String texto;
	Token(TK t, String texto) {this.t = t; this.texto = texto;}
}
