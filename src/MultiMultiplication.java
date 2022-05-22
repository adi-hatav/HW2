/**
 * Represents arithmetic expression of type multi multiplication.
 */
public class MultiMultiplication extends Multiplication {
    private Expression[] expressions;

    /**
     * Multi multiplication constructor, creates multiplication of multi expressions.
     *
     * @param expressions list of expression
     */
    public MultiMultiplication(Expression... expressions) {
        super(expressions[0], expressions[1]);
        this.expressions = expressions;

    }

    /**
     * calculates and returns the multiplication of all the expressions.
     */
    @Override
    public double evaluate() {
        double eval = 1;
        for (Expression num : this.expressions) {
            eval *= num.evaluate();
        }
        return eval;
    }

    /**
     * @return a string that includes the expressions, the operator
     * and brackets at the beginning and the end.
     */
    @Override
    public String toString() {
        String MultiMultiplicationString = "(";
        int i = 0;
        for (; i < this.expressions.length - 1; i++) {
            MultiMultiplicationString = MultiMultiplicationString.concat(this.expressions[i].toString() + " * ");
        }
        MultiMultiplicationString = MultiMultiplicationString.concat(this.expressions[i].toString() + ")");
        return MultiMultiplicationString;
    }
}
