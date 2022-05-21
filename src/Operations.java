/**
 * Abstract class, represents general arithmetic expression.
 */
public abstract class Operations extends Expression {

    private Expression expressionA;
    private Expression expressionB;
    protected String operator;

    /**
     * Operation constructor, creates an operation on two expression based on the given operator.
     *
     * @param expressionA first expression.
     * @param expressionB second expression.
     * @param operator    the operator represents the operation type.
     */
    public Operations(Expression expressionA, Expression expressionB, String operator) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
        this.operator = operator;
    }

    /**
     * @return the calculations on the two expressions based on the operator.
     */
    @Override
    public double evaluate() {
        switch (this.operator) {
            case ("+"):
                return expressionA.evaluate() + expressionB.evaluate();
            case ("*"):
                return expressionA.evaluate() * expressionB.evaluate();
            case ("/"):
                return expressionA.evaluate() / expressionB.evaluate();
            case ("-"):
                return expressionA.evaluate() - expressionB.evaluate();
            default:
                return expressionA.evaluate();
        }
    }

    /**
     * @return a string that includes the expressions, the operator
     * and brackets at the beginning and the end.
     */
    @Override
    public String toString() {
        return "(" + this.expressionA.toString() + " " + this.operator + " " + this.expressionB.toString() + ")";
    }

}
