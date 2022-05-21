/**
 * Represents arithmetic expression of type addition.
 */
public class Addition extends Operations {

    /**
     * Addition constructor, creates addition of two expressions.
     *
     * @param expressionA first expression
     * @param expressionB second expression
     */
    public Addition(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB, "+");
    }
}
