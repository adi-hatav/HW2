/**
 * Represents primitive operator of type expression.
 */
public class PrimitiveOperator extends Expression {
    public String operator;

    /**
     * Primitive operator constructor, creates operator.
     *
     * @param operator the operator
     */
    public PrimitiveOperator(String operator) {
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
