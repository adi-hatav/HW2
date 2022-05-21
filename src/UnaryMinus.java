/**
 * Represents arithmetic expression of type UnaryMinus.
 */
public class UnaryMinus extends Expression {

    private Expression expression;

    /**
     * UnaryMinus constructor.
     *
     * @param expression expression to multiply by -1.
     */
    public UnaryMinus(Expression expression) {
        this.expression = expression;
    }

    /**
     * @return expression value  multiplied by -1.
     */
    @Override
    public double evaluate() {
        return (-1) * this.expression.evaluate();

    }

    /**
     * @return a string that includes the expression with '-' sign
     * and brackets at the beginning and the end.
     */
    @Override
    public String toString() {
        return "(-" + this.expression.toString() + ")";
    }
}
