public class NoOperacao implements No {
    final String op;
    final No esquerda, direita;
    NoOperacao(String op, No esquerda, No direita){ this.op = op; this.esquerda = esquerda; this.direita = direita; }
    public NumComplexo eval(){
        NumComplexo a = esquerda.eval();
        if(op.equals("#")){
            return Operacoes.raizQuadrada(a);
        }
        if(op.equals("~")){
            return Operacoes.conjugado(a);
        }
        if (direita == null) {
            throw new RuntimeException("Operação binária incompleta ou malformada: " + op);
        }
        NumComplexo b = direita.eval();
        switch(op){
            case "+": return a.adicionar(b);
            case "-": return a.subtrair(b);
            case "*": return a.multiplicar(b);
            case "/": return a.dividir(b);
            case "^": return a.elevar(b);
            default: throw new RuntimeException("Operação estranha: " + op);
        }
    }
    public String converteLisp(){ 
        if(op.equals("~")){
            return "(conjugado " + esquerda.converteLisp() + ")";
        }
        if(op.equals("#")){
            return "(raiz " + esquerda.converteLisp() + ")";
        }else{
            return "(" + op + " " + esquerda.converteLisp() + " " + direita.converteLisp() + ")";
        }
     }
}
