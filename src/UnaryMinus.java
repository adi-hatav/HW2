public class UnaryMinus extends Expression {

    private Expression expression;

    public UnaryMinus(Expression exp) {
        this.expression = exp;
    }

    @Override
    public double evaluate() {
        return (-1) * this.expression.evaluate();

    }

    @Override
    public String toString() {
        return "(-" + this.expression.toString() + ")";
    }
}
