/**
 * Represents parser from polish notation to arithmetic expression.
 */
public class PolishNotationParser extends ExpressionParser {

    /**
     * Creates new list of all the expressions in the polish notation.
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
        Expression[] allExpressions = new Expression[listString.length];
        int shrankArrayLength = listString.length;

        // initialize allExpressions list with the corresponded Expression types
        for (int i = 0; i < listString.length; i++) {
            if (isOperator(listString[i]))
                allExpressions[i] = new PrimitiveOperator(listString[i]);
            else allExpressions[i] = numberToClass(listString[i]);
        }

        // run until there is only one expression
        while (shrankArrayLength != 1) {
            // run from left to right, over the allExpressions list.
            for (int i = shrankArrayLength - 1; i >= 0; i--) {
                if (allExpressions[i] instanceof PrimitiveOperator) {

                    // creates new Expression in allExpressions[i] and shrinks the list.
                    // if the operator is -u then deletes the expression in the i+1 location
                    // else it deletes the expressions in the i+1, i+2 locations
                    if (allExpressions[i].toString().equals("-u")) {
                        allExpressions[i] =
                                expressionByOperator("-u", allExpressions[i + 1], numberToClass("0"));
                        shrankArrayLength--;
                        allExpressions = shrinkArray(allExpressions, i + 1, 1);
                    } else {
                        allExpressions[i] = expressionByOperator(allExpressions[i].toString(),
                                allExpressions[i + 1], allExpressions[i + 2]);
                        shrankArrayLength -= 2;
                        allExpressions = shrinkArray(allExpressions, i + 1, 2);
                    }
                    break;

                }
            }

        }
        return allExpressions[0];

    }

    /**
     * Shrinks the expressions array, deletes len expressions from end location.
     *
     * @param expressions list of expressions to shrink
     * @param start       the starting location, from which to begin to shrink.
     * @param len         the number of expressions to delete
     * @return the shrank array.
     */
    private Expression[] shrinkArray(Expression[] expressions, int start, int len) {
        Expression[] newArray = new Expression[expressions.length - len];
        for (int i = 0; i < start; i++) {
            newArray[i] = expressions[i];
        }
        for (int i = start + len; i < expressions.length; i++) {
            newArray[i - len] = expressions[i];
        }
        return newArray;

    }

}
