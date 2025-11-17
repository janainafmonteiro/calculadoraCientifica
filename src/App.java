import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
       String expressao;
        
       Scanner scan = new Scanner(System.in);
       
       while(true){ 
        System.out.println("Conjugado: ~\nExemplo: ~(2+3i) \nRaiz: #\nPotencia: ^ \nDigite as expressao:");
        expressao = scan.nextLine();
        if(!expressao.equals("fim")){ 
            try {
                AnalisarExpressao a = new AnalisarExpressao(expressao);
            	expressao = a.verificar();
                System.out.println(expressao);
            	Analise p = new Analise(expressao);
            	No root = p.parse();
            	
            	System.out.println("Valor: " + root.eval());
                System.out.println("Lisp: " + root.converteLisp());
                System.out.println();
            }catch(Exception e) {
            	System.err.println("Erro: " + e.getMessage());
            }
        }else {
        	break;
        }
       }
       
       scan.close();
    }
}
