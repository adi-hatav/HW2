public class UnaryMinus extends Expression {

    private Expression exp;

    public UnaryMinus(Expression exp) {
        this.exp = exp;
    }

    @Override
    public double evaluate() {
        return (-1) * this.exp.evaluate();

    }

    @Override
    public String toString() {
        return "(-" + this.exp.toString() + ")";
    }
}
