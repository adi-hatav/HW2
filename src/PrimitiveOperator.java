public class PrimitiveOperator extends Expression{
    public String operator;

    public PrimitiveOperator(String operator){
        this.operator = operator;
    }

    @Override
    public double evaluate() {
        return 0;
    }

    @Override
    public String toString() {
        return this.operator;
    }
}
