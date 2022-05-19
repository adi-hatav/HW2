public class Operations extends Expression {

    private Expression expA;
    private Expression expB;
    protected String operator;

    public Operations(Expression expA, Expression expB, String operator) {
        this.expA = expA;
        this.expB = expB;
        this.operator = operator;
        this.expressionString = "(" + this.expA.toString() + " " + this.operator + " " + this.expB.toString() + ")";

    }

    @Override
    public double evaluate() {
        switch (this.operator) {
            case ("+"):
                return expA.evaluate() + expB.evaluate();
            case ("*"):
                return expA.evaluate() * expB.evaluate();
            case ("/"):
                return  expA.evaluate() / expB.evaluate();
            case ("-"):
                return expA.evaluate() - expB.evaluate();
            default:
                return expA.evaluate();
        }
    }

    @Override
    public String toString() {
        return this.expressionString;
    }

}
