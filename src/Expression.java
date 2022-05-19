public abstract class Expression {
    protected String expressionString = "";
    protected double expressionValue = 0;
    public abstract double evaluate();
    public abstract String toString();

}
