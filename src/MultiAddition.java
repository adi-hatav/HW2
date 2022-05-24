/**
 * Represents arithmetic expression of type multi addition.
 */
public class MultiAddition extends Addition {
    private Expression[] expressions;

    /**
     * MultiAddition constructor, creates addition of multi expressions.
     *
     * @param expressions list of expression
     */
    public MultiAddition(Expression expressionA, Expression expressionB, Expression... expressions) {
        super(expressionA, expressionB);
        this.expressions = expressions;

    }

    /**
     * calculates and returns the addition of all the expressions.
     */
    @Override
    public double evaluate() {
        double eval = super.evaluate();
        for (Expression num : this.expressions) {
            eval += num.evaluate();
        }
        return eval;
    }

    /**
     * @return a string that includes the expressions, the operator
     * and brackets at the beginning and the end.
     */
    @Override
    public String toString() {
        String MultiAdditionString = super.toString();
        if (this.expressions.length == 0)
            return MultiAdditionString;

        // if there are more than 2 multiplications
        int toStringLength = MultiAdditionString.length();
        MultiAdditionString = MultiAdditionString.substring(0, toStringLength - 1);
        MultiAdditionString = MultiAdditionString.concat(" * ");
        int i = 0;
        for (; i < this.expressions.length - 1; i++) {
            MultiAdditionString = MultiAdditionString.concat(this.expressions[i].toString() + " + ");
        }
        MultiAdditionString = MultiAdditionString.concat(this.expressions[i].toString() + ")");
        return MultiAdditionString;
    }
}
