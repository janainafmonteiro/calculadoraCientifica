import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
       String expressao, exp1 = "", exp2 = "";
        
       try (Scanner scan = new Scanner(System.in)) {
            int op = 0;
            while(op !=3){
            System.out.println("----------------------------------------");
            System.out.println("1- Comparar expressão");
            System.out.println("2- Resolver expressão");
            System.out.println("Digite um número diferente para sair");
            System.out.println("----------------------------------------");
            op = scan.nextInt();
            scan.nextLine();
            switch (op) {      
            case 1:
                System.out.println("------Comparar expressões---------");
                System.out.println("Digite a expressão 1:");
                expressao = scan.nextLine();
                try {
                    AnalisarExpressao a = new AnalisarExpressao(expressao);
                    expressao = a.verificar();
                    Analise p = new Analise(expressao);
                    No root = p.parse();
                    exp1 = root.converteLisp();
                }catch(Exception e) {
                    System.err.println("Erro: " + e.getMessage());
                    break;
                }
                System.out.println("Digite a expressão 2:");
                expressao = scan.nextLine();
                try {
                    AnalisarExpressao a = new AnalisarExpressao(expressao);
                    expressao = a.verificar();
                    Analise p = new Analise(expressao);
                    No root = p.parse();
                    exp2 = root.converteLisp();
                }catch(Exception e) {
                    System.err.println("Erro: " + e.getMessage());
                    break;
                }
                if(exp1.equals(exp2)){
                    System.out.println("As expressões são iguais " + exp2);
                }else{
                    System.out.println("As expressões são diferentes\n" + exp1 + " != " + exp2);
                }
                break;

            case 2:
                System.out.println("----------Resolver expressão---------------");
                System.out.println("Conjugado: ~\nExemplo: ~(2+3i) \nRaiz: #\nPotencia: ^ \nDigite as expressao:");
                expressao = scan.nextLine();
                try {
                    AnalisarExpressao a = new AnalisarExpressao(expressao);
                    expressao = a.verificar();
                    Analise p = new Analise(expressao);
                    No root = p.parse();       
                    System.out.println("Valor: " + root.eval());
                    System.out.println("Lisp: " + root.converteLisp());
                }catch(Exception e) {
                    System.err.println("Erro: " + e.getMessage());
                    break;
                }
                break;
            default:
                System.out.println("Saindo...");
            }
        }      
    }
    }
}
