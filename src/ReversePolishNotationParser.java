public class ReversePolishNotationParser  extends  ExpressionParser {

    @Override
    public Expression parse(String expression) {
        String[] listString = expression.split(" ");
        Expression[] allExpressions1 = new Expression[listString.length];
        int correctArrayLength = listString.length;
        for (int i = 0; i < listString.length; i++) {
            if (isOperator(listString[i]))
                allExpressions1[i] = new PrimitiveOperator(listString[i]);
            else allExpressions1[i] = numberToClass(listString[i]);
        }
        while (correctArrayLength != 1) {
            for (int i = 0; i <listString.length; i++) {
                if (allExpressions1[i] instanceof PrimitiveOperator) {
                    if (allExpressions1[i].toString().equals("-u")) {
                        allExpressions1[i] = expressionByOperator("-u", allExpressions1[i - 1], numberToClass("0"));
                        correctArrayLength--;
                        allExpressions1 = shrinkArray(allExpressions1, i, 1);
                        break;
                    } else {
                        allExpressions1[i] = expressionByOperator(allExpressions1[i].toString(), allExpressions1[i - 2], allExpressions1[i - 1]);
                        correctArrayLength -= 2;
                        allExpressions1 = shrinkArray(allExpressions1, i,2);
                        break;
                    }

                }
            }

        }
        return allExpressions1[0];

    }

    private Expression[] shrinkArray(Expression[] expressions, int start, int len) {
        Expression[] newArray = new Expression[expressions.length - len];
        for (int i = 0; i <= start-len; i++) {
            newArray[i] = expressions[i];
        }
        for (int i = start; i < expressions.length; i++) {
            newArray[i-len] = expressions[i];
        }

        return newArray;

    }
}
