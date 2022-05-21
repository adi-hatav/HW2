/**
 * Represents arithmetic expression of type subtraction.
 */
public class Subtraction extends Operations {

    /**
     * Subtraction constructor, creates subtraction of two expressions.
     *
     * @param expressionA first expression
     * @param expressionB second expression
     */
    public Subtraction(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB, "-");
    }
}