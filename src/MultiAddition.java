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
    public MultiAddition(Expression... expressions) {
        super(expressions[0], expressions[1]);
        this.expressions = expressions;

    }

    /**
     * calculates and returns the addition of all the expressions.
     */
    @Override
    public double evaluate() {
        double eval = 0;
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
        String MultiAdditionString = "(";
        int i = 0;
        for (; i < this.expressions.length - 1; i++) {
            MultiAdditionString =MultiAdditionString.concat(this.expressions[i].toString() + " + ");
        }
        MultiAdditionString = MultiAdditionString.concat( this.expressions[i].toString() + ")");
        return MultiAdditionString;
    }
}
