/**
 * Represents arithmetic expression of type multiplication.
 */
public class Multiplication extends Operations {

    /**
     * Multiplication constructor, creates multiplication of two expressions.
     *
     * @param expressionA first expression
     * @param expressionB second expression
     */
    public Multiplication(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB, "*");
    }
}
