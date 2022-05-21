public abstract class Operations extends Expression {

    private Expression expressionA;
    private Expression expressionB;
    protected String operator;

    public Operations(Expression expressionA, Expression expressionB, String operator) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
        this.operator = operator;
    }

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

    @Override
    public String toString() {
        return "(" + this.expressionA.toString() + " " + this.operator + " " + this.expressionB.toString() + ")";
    }

}
