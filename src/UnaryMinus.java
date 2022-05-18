public class UnaryMinus extends Expression{

    private Expression numA;

    public UnaryMinus(Expression numA) {
        this.numA = numA;
    }

    @Override
    public double evaluate() {
        return (-1)*this.numA.evaluate();

    }
    @Override
    public String toString() {
        return "(-"+this.numA.toString()+")";
    }
}
