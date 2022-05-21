/**
 * Abstract class, represents general expression parser.
 */
public abstract class ExpressionParser {
    public abstract Expression parse(String expression);

    /**
     * @param character to check if it is an operator.
     * @return true if the character is an operator (+,-,/,*,-u) and false otherwise.
     */
    protected boolean isOperator(String character) {
        return character.equals("+") || character.equals("-") ||
                character.equals("*") || character.equals("/") ||
                character.equals("-u");
    }

    /**
     * @param number double or integer number in string formatting.
     * @return IntegerLiteral if the number is int, else DoubleLiteral.
     */
    protected Expression numberToClass(String number) {
        if (number.indexOf('.') == -1) {
            return new IntegerLiteral(Integer.parseInt(number));
        }
        return new DoubleLiteral(Double.parseDouble(number));
    }

    /**
     * @param operator    new Expression's operator
     * @param expressionA first expression
     * @param expressionB second expression
     * @return new Expression on the given expressions based on the given operator.
     */
    protected Expression expressionByOperator(String operator, Expression expressionA, Expression expressionB) {
        switch (operator) {
            case ("+"):
                return new Addition(expressionA, expressionB);
            case ("*"):
                return new Multiplication(expressionA, expressionB);
            case ("/"):
                return new Division(expressionA, expressionB);
            case ("-"):
                return new Subtraction(expressionA, expressionB);
            default:
                return new UnaryMinus(expressionA);
        }
    }
}
