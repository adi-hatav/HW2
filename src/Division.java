/**
 * Represents arithmetic expression of type division.
 */
public class Division extends Operations {

    /**
     * Division constructor, creates division of two expressions.
     *
     * @param expressionA first expression
     * @param expressionB second expression
     */
    public Division(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB, "/");
    }

}
