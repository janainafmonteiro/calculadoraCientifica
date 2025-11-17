public class Operacoes {
    public static NumComplexo somar (NumComplexo a , NumComplexo b){
        return new NumComplexo(a.getReal() + b.getReal() , a.getImaginario() + b.getImaginario() );
    }

    public static NumComplexo subtrair(NumComplexo a , NumComplexo b ){
        return new NumComplexo( a.getReal() - b.getReal() , a.getImaginario() - b.getImaginario() );
    }
    public static NumComplexo multiplicar (NumComplexo a , NumComplexo b){
        double real = a.getReal() * b.getReal() - a.getImaginario() * b.getImaginario();
        double imag = a.getReal() * b.getImaginario() + a.getImaginario() * b.getReal();
        return new NumComplexo(real,imag);
    }
    public static NumComplexo dividir (NumComplexo a, NumComplexo b){
        double denominador = b.getReal() * b.getReal() + b.getImaginario() * b.getImaginario();
        if(denominador == 0){
            throw new ArithmeticException("Divisao por zero");
        }
        double real = (a.getReal() * b.getReal() + a.getImaginario() * b.getImaginario())/ denominador;
        double imag = (a.getImaginario() * b.getReal() - a.getReal() * b.getImaginario()) / denominador ;
        return new NumComplexo(real,imag);
    }
    public static NumComplexo conjugado(NumComplexo a){
        return new NumComplexo(a.getReal(), -a.getImaginario());
    }
    public static NumComplexo potencia(NumComplexo a , int n){
        NumComplexo resultado = new NumComplexo(1,0);
            for (int i = 0; i< n ;i++){
                resultado = multiplicar (resultado,a);
            }
        return resultado;
    }
    public static NumComplexo raizQuadrada(NumComplexo a){
        double moduloRaiz = Math.sqrt(a.getReal() * a.getReal() + a.getImaginario() * a.getImaginario());
        double modulo = Math.sqrt(moduloRaiz);
        double angulo = Math.atan2(a.getImaginario(), a.getReal()) / 2;
        double real = modulo * Math.cos(angulo);
        double imag = modulo * Math.sin(angulo);
        return new NumComplexo(real,imag);
    }
    
}


