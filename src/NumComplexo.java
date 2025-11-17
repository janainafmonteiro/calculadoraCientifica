public class NumComplexo{
    private double real ;
    private double imaginario ;

    public NumComplexo(double real , double imaginario){
        this.real = real;
        this.imaginario = imaginario;
    }

    public double getReal(){
        return this.real;
    }

    public double getImaginario(){
        return this.imaginario;
    }
    
    public NumComplexo adicionar(NumComplexo b) {
    	return Operacoes.somar(this, b);
    }
    
    public NumComplexo subtrair(NumComplexo b) {
    	return Operacoes.subtrair(this, b);
    }
    
    public NumComplexo multiplicar(NumComplexo b) {
    	return Operacoes.multiplicar(this, b);
    }
    
    public NumComplexo dividir(NumComplexo b) {
    	return Operacoes.dividir(this, b);
    }
    
    public NumComplexo elevar(NumComplexo b) {
    	if(b.imaginario != 0.0) {
    		throw new RuntimeException("Tentou elevar número complexo " + this + " a outro número complexo " + b);
    	}
    	return Operacoes.potencia(this, (int)b.real);
    }

    @Override
    public String toString(){
        if(imaginario == 0){
            return String.valueOf(real);
        }
        if(real == 0){
            return imaginario + "i";
        }
        if(imaginario > 0){
            return real + " + " + imaginario + "i";
        }else{
            return real + " - " + Math.abs(imaginario) + "i";
        }
    }
}

    

