public class NoComplexo implements No {
    final NumComplexo v;
    NoComplexo(NumComplexo v){ this.v = v; }
    public NumComplexo eval(){ return v; }
    public String converteLisp(){ return String.format("(complexo %.2f %.2f)", v.getReal(), v.getImaginario()); }
}
