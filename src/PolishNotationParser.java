public class PolishNotationParser extends  ExpressionParser{


    @Override
    public Expression parse(String expression) {
        String[] listString = expression.split(" ");
        int i = listString.length-1;
        for( ;i>=0;i--)
        {
            if(isOperator(listString[i]))
            {
                String operator =listString[i];
                String numA = listString[i+1];
                String numB = (operator.equals("-u"))?"0":listString[i+2];
                Expression temp = expressionByOperator(operator,numA,numB);


            }
        }
    }
    private boolean isOperator(String character){
        return character.equals("+") || character.equals("-") ||
                character.equals("*") || character.equals("/") ||
                character.equals("-u");
    }

    private Expression numberToClass(String num){
        if(num.indexOf('.')== -1){
            return new IntegerLiteral(Integer.parseInt(num));
        }
        return new DoubleLiteral(Double.parseDouble(num));
    }
    private Expression expressionByOperator(String operator,String numA, String numB){
        Expression numAExpression = numberToClass(numA);
        Expression numBExpression = numberToClass(numB);
        switch (operator){
            case ("+") :return new Addition(numAExpression,numBExpression);
            case ("*") :return new Multiplication(numAExpression,numBExpression);
            case ("/") :return new Division(numAExpression,numBExpression);
            case ("-") :return new Subtraction(numAExpression,numBExpression);
            case ("-U") :return new UnaryMinus(numAExpression);
            default: return null;
        }
    }
}
