public class PolishNotationParser extends ExpressionParser {

    @Override
    public Expression parse(String expression) {
        String[] listString = expression.split(" ");
        Expression[] allExpressions = new Expression[listString.length];
        int correctArrayLength = listString.length;
        for (int i = 0; i < listString.length; i++) {
            if (isOperator(listString[i]))
                allExpressions[i] = new PrimitiveOperator(listString[i]);
            else allExpressions[i] = numberToClass(listString[i]);
        }
        while (correctArrayLength != 1) {
            for (int i = correctArrayLength - 1; i >= 0; i--) {
                if (allExpressions[i] instanceof PrimitiveOperator) {
                    if (allExpressions[i].toString().equals("-u")) {
                        allExpressions[i] = expressionByOperator("-u", allExpressions[i + 1], numberToClass("0"));
                        correctArrayLength--;
                        allExpressions = shrinkArray(allExpressions, i+1, 1);
                        break;
                    } else {
                        allExpressions[i] = expressionByOperator(allExpressions[i].toString(), allExpressions[i + 1], allExpressions[i + 2]);
                        correctArrayLength -= 2;
                        allExpressions = shrinkArray(allExpressions, i+1,2);
                        break;
                    }

                }
            }

        }
        return allExpressions[0];

    }

    private Expression[] shrinkArray(Expression[] expressions, int start, int len) {
        Expression[] newArray = new Expression[expressions.length - len];
        for (int i = 0; i < start; i++) {
            newArray[i] = expressions[i];
        }
        for (int i = start + len; i < expressions.length; i++) {
            newArray[i-len] = expressions[i];
        }
        return newArray;

    }

}
