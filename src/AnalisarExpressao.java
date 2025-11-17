import java.util.Scanner;

public class AnalisarExpressao {
    private String expressao;
    
    public AnalisarExpressao(String expressao){
        this.expressao = expressao;
        this.expressao = this.expressao.replaceAll("\\s+", "");
        this.expressao = this.expressao.toLowerCase();
        this.expressao = this.expressao.replace(",", ".");
    }
    public String verificar(){
        verificarRaiz();
        valorVariaveis();
        parenteses();
        return this.expressao;
    }

    public void parenteses(){
        for (int i = 0; i < expressao.length(); i++) {           
            if(expressao.charAt(i)== '('){
                if(i > 0){
                    char a = expressao.charAt(i-1);
                if(a >= '0' && a<='9' || a >= 'a' && a <= 'z' || a == ')'){
                    this.expressao = expressao.substring(0, i) + '*' + expressao.substring(i);
                    i++;
                }
                }
                
            }
        }
    }
    public boolean verificarRaiz(){
        for(int i = 0; i < expressao.length(); i++){
            if(expressao.charAt(i) == '#'){
                if(i == expressao.length()-1){
                    return false;
                }
                if(!((expressao.charAt(i+1) >= '0' && expressao.charAt(i+1) <= '9') || (expressao.charAt(i+1) >= 'a' && expressao.charAt(i+1) <= 'z') || expressao.charAt(i+1) == '(')){
                    return false;
                }
                if(i != 0){
                    if((expressao.charAt(i-1) >= '0' && expressao.charAt(i-1) <= '9') || (expressao.charAt(i-1) >= 'a' && expressao.charAt(i-1) <= 'z') || expressao.charAt(i-1) == ')'){
                        this.expressao = expressao.substring(0, i) + '*' + expressao.substring(i);
                        i++;
                    }
                }
            }
        }
        return true;
    }


    
    public String verificarVariaveis(){
        int i = 0;
        while(i < expressao.length()){
            if(expressao.charAt(i) >= 'a' && expressao.charAt(i) <= 'z' && expressao.charAt(i) != 'i'){
                if(i==0){
                    if(expressao.length() > 1){
                        if((expressao.charAt(i+1) >='0' && expressao.charAt(i+1)<='9') || (expressao.charAt(i+1) >= 'a' && expressao.charAt(i+1) <= 'z' && expressao.charAt(i+1) != 'i') || expressao.charAt(i+1) == '('){                       
                            this.expressao = expressao.substring(0, i+1) + '*' + expressao.substring(i+1);
                            i++;
                        }
                    }
                }else{
                    if(expressao.charAt(i-1) >='0' && expressao.charAt(i-1)<='9'|| (expressao.charAt(i-1) >= 'a' && expressao.charAt(i-1) <= 'z' && expressao.charAt(i-1) != 'i') || expressao.charAt(i-1) == ')'){
                        this.expressao = expressao.substring(0, i) + '*' + expressao.substring(i);
                        i++;
                    } 
                    if(i != expressao.length()-1){
                        if((expressao.charAt(i+1) >='0' && expressao.charAt(i+1)<='9') || (expressao.charAt(i+1) >= 'a' && expressao.charAt(i+1) <= 'z' && expressao.charAt(i+1) != 'i') || expressao.charAt(i+1) == '('){
                            this.expressao = expressao.substring(0, i+1) + '*' + expressao.substring(i+1);
                            i++;
                        }
                    }
                }
            }
            i++;
        }
        return this.expressao;
    }
    public String valorVariaveis(){
        this.expressao = verificarVariaveis();
        for (int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) >= 'a' && expressao.charAt(i) <= 'z' && expressao.charAt(i) != 'i'){              
                System.err.println("Qual sera o valor da variavel: "+ expressao.charAt(i) + " ?");
                Scanner scan = new Scanner(System.in);
                double valor = scan.nextDouble();            
                this.expressao = expressao.replaceAll(String.valueOf(expressao.charAt(i)), String.valueOf(valor));
                i++;
            }
        }
        return this.expressao;
    } 


}