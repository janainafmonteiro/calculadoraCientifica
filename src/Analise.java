public class Analise {
    Leitor leia;
    Token cur;
    Analise(String texto) throws ExcecaoLeitura{ leia = new Leitor(texto); cur = leia.proximo(); }

    void consume(TK t) throws ExcecaoLeitura{ if (cur.t==t) cur = leia.proximo(); else throw new ExcecaoLeitura("Esperava " + t + " mas " + cur.t); }

    No parse() throws ExcecaoLeitura{
    	No n = analiseExpressao();
        if (cur.t != TK.FIM) throw new RuntimeException("Caráctere rastejante: " + cur.texto);
        return n;
    }

    No analiseExpressao() throws ExcecaoLeitura{
    	No n = analiseTermo();
        while(cur.t==TK.MAIS || cur.t==TK.MENOS){
            String op = cur.texto; consume(cur.t);
            No r = analiseTermo();
            n = new NoOperacao(op, n, r);
        }
        return n;
    }

    No analiseTermo() throws ExcecaoLeitura{
    	No n = analiseFator();
        while(cur.t==TK.MULT || cur.t==TK.DIVI || cur.t==TK.POT){
            String op = cur.texto; consume(cur.t);
            No r = analiseFator();
            n = new NoOperacao(op, n, r);
        }
        return n;
    }

    No analiseFator() throws ExcecaoLeitura{
        if (cur.t==TK.RAIZ){ 
            String op = cur.texto; consume(TK.RAIZ);
            No f = analiseFator(); 
            No dummy = new NoComplexo(new NumComplexo(0,0));
            return new NoOperacao(op, f, dummy); 
        }
        if (cur.t==TK.CONJUGADO){ 
            String op = cur.texto; consume(TK.CONJUGADO);
            No f = analiseFator();        
            No dummy = new NoComplexo(new NumComplexo(0,0)); 
            
            return new NoOperacao(op, f, dummy); 
    }
        if (cur.t==TK.MAIS){ consume(TK.MAIS); return analiseFator(); }
        if (cur.t==TK.MENOS){ 
        	consume(TK.MENOS); 
        	No f = analiseFator(); 
        	return new NoOperacao("-", new NoComplexo(new NumComplexo(0,0)), f); 
        }
        if (cur.t==TK.NUMERO){
            double val = Double.parseDouble(cur.texto);
            consume(TK.NUMERO);
            if (cur.t==TK.I){
                consume(TK.I); return new NoComplexo(new NumComplexo(0, val));
            } else {
                return new NoComplexo(new NumComplexo(val, 0));
            }
        }
        if (cur.t==TK.I){ consume(TK.I); return new NoComplexo(new NumComplexo(0,1)); }
        if (cur.t==TK.PAR_ESQ){
            consume(TK.PAR_ESQ);
            No n = analiseExpressao();
            consume(TK.PAR_DIR);
            return n;
        }
        throw new ExcecaoLeitura("Caráctere inesperado em fator: " + cur.t + " '" + cur.texto + "'");
    }
}

