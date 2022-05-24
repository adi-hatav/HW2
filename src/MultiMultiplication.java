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
    public MultiMultiplication(Expression expressionA, Expression expressionB, Expression... expressions) {
        super(expressionA, expressionB);
        this.expressions = expressions;

    }

    /**
     * calculates and returns the multiplication of all the expressions.
     */
    @Override
    public double evaluate() {
        double eval = super.evaluate();
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
        String MultiMultiplicationString = super.toString();
        if (this.expressions.length == 0)
            return MultiMultiplicationString;

        // if there are more than 2 multiplications
        int toStringLength = MultiMultiplicationString.length();
        MultiMultiplicationString = MultiMultiplicationString.substring(0, toStringLength - 1);
        MultiMultiplicationString = MultiMultiplicationString.concat(" * ");
        int i = 0;
        for (; i < this.expressions.length - 1; i++) {
            MultiMultiplicationString = MultiMultiplicationString.concat(this.expressions[i].toString() + " * ");
        }
        MultiMultiplicationString = MultiMultiplicationString.concat(this.expressions[i].toString() + ")");
        return MultiMultiplicationString;
    }
}
