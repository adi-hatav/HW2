public abstract class ExpressionParser {
    public abstract Expression parse(String expression);

    protected boolean isOperator(String character) {
        return character.equals("+") || character.equals("-") ||
                character.equals("*") || character.equals("/") ||
                character.equals("-u");
    }

    protected Expression numberToClass(String num) {
        if (num.indexOf('.') == -1) {
            return new IntegerLiteral(Integer.parseInt(num));
        }
        return new DoubleLiteral(Double.parseDouble(num));
    }

    protected Expression expressionByOperator(String operator, Expression expA, Expression expB) {
        switch (operator) {
            case ("+"):
                return new Addition(expA, expB);
            case ("*"):
                return new Multiplication(expA, expB);
            case ("/"):
                return new Division(expA, expB);
            case ("-"):
                return new Subtraction(expA, expB);
            default:
                return new UnaryMinus(expA);
        }
    }
}
