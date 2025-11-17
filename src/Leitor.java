import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitor {
	private static final Pattern PADRAO = Pattern.compile("^\\d+(?:\\.\\d+)?");
    private String texto = "";
    private int pos = 0;
    Leitor(String expressao){this.texto = expressao.trim();}
    Token proximo() throws ExcecaoLeitura {
    	while(pos < texto.length() && Character.isWhitespace(texto.charAt(pos))) pos++;
    	if(pos >= texto.length()) return new Token(TK.FIM, "");
    	char c = texto.charAt(pos);
    	switch(c) {
    		case '+':
    			pos++;
    			return new Token(TK.MAIS, "+");
    		case '-':
    			pos++;
    			return new Token(TK.MENOS, "-");
    		case '*':
    			pos++;
    			return new Token(TK.MULT, "*");
    		case '/':
    			pos++;
    			return new Token(TK.DIVI, "/");
    		case '^':
    			pos++;
    			return new Token(TK.POT, "^");
			case '#':
				pos++;
				return new Token(TK.RAIZ, "#");
			case '~':
				pos++;
				return new Token(TK.CONJUGADO, "~");
    		case '(':
    			pos++;
    			return new Token(TK.PAR_ESQ, "(");
    		case ')':
    			pos++;
    			return new Token(TK.PAR_DIR, ")");
    		case 'i':
    			pos++;
    			return new Token(TK.I, "i");
    		default:
    			if(Character.isDigit(c)) {
    				Matcher m = PADRAO.matcher(texto.substring(pos));
    				if(m.find()) {
    					String num = m.group();
    					pos += num.length();
    					return new Token(TK.NUMERO, num);
    				}
    			}
    			throw new ExcecaoLeitura("Caráctere estranho: " + c + " em " + pos);
    	}
    }
}
