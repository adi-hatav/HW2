/**
 * Represents parser from reverse polish notation to arithmetic expression.
 */
public class ReversePolishNotationParser extends ExpressionParser {

    /**
     * Creates new list of all the expressions in the reverse polish notation.
     * Calculates each expression based on the operators and the numbers.
     * Use primitiveOperators which are expressions to initialize the expressions list.
     * each time it calculates an expression, it shrinks the list and at the end there is only one expression
     * at the location 0 of allExpressions list.
     *
     * @param expression expression in polish notation.
     * @return arithmetic expression.
     */
    @Override
    public Expression parse(String expression) {
        String[] listString = expression.split(" ");
        Expression[] allExpressions1 = new Expression[listString.length];
        int correctArrayLength = listString.length;

        // initialize allExpressions list with the corresponded Expression types
        for (int i = 0; i < listString.length; i++) {
            if (isOperator(listString[i]))
                allExpressions1[i] = new PrimitiveOperator(listString[i]);
            else allExpressions1[i] = numberToClass(listString[i]);
        }

        // run until there is only one expression
        while (correctArrayLength != 1) {

            // run from right to left, over the allExpressions list.
            for (int i = 0; i < listString.length; i++) {
                if (allExpressions1[i] instanceof PrimitiveOperator) {

                    // creates new Expression in allExpressions[i] and shrinks the list.
                    // if the operator is -u then deletes the expression in the i-1 location
                    // else it deletes the expressions in the i-1, i-2 locations
                    if (allExpressions1[i].toString().equals("-u")) {
                        allExpressions1[i] =
                                expressionByOperator("-u", allExpressions1[i - 1], numberToClass("0"));
                        correctArrayLength--;
                        allExpressions1 = shrinkArray(allExpressions1, i, 1);
                    } else {
                        allExpressions1[i] = expressionByOperator(allExpressions1[i].toString(),
                                allExpressions1[i - 2], allExpressions1[i - 1]);
                        correctArrayLength -= 2;
                        allExpressions1 = shrinkArray(allExpressions1, i, 2);
                    }
                    break;

                }
            }

        }
        return allExpressions1[0];

    }

    /**
     * Shrinks the expressions array, deletes len expressions from location-len.
     *
     * @param expressions list of expressions to shrink
     * @param location    the ending location, from which the shrink ends.
     * @param len         the number of expressions to delete
     * @return the shrank array.
     */
    private Expression[] shrinkArray(Expression[] expressions, int location, int len) {
        Expression[] newArray = new Expression[expressions.length - len];
        for (int i = 0; i <= location - len; i++) {
            newArray[i] = expressions[i];
        }
        for (int i = location; i < expressions.length; i++) {
            newArray[i - len] = expressions[i];
        }

        return newArray;

    }
}
