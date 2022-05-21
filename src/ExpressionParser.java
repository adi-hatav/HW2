public abstract class ExpressionParser {
    public abstract Expression parse(String expression);

    protected boolean isOperator(String character) {
        return character.equals("+") || character.equals("-") ||
                character.equals("*") || character.equals("/") ||
                character.equals("-u");
    }

    protected Expression numberToClass(String number) {
        if (number.indexOf('.') == -1) {
            return new IntegerLiteral(Integer.parseInt(number));
        }
        return new DoubleLiteral(Double.parseDouble(number));
    }

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
