public class ReversePolishNotationParser  extends  ExpressionParser {

//    public Expression parsed(String expression) {
//        String[] listString = expression.split(" ");
//        Expression temp = numberToClass(listString[0]);
//        if (listString.length>1) {
//            String operator, expA, numB;
//            for (int i=0; i< listString.length; i++) {
//                if (isOperator(listString[i])) {
//                    operator = listString[i];
//                    //expA = temp.toString();
//                    numB = (operator.equals("-u")) ? "0" : listString[i - 1];
//                    temp = expressionByOperator(operator, temp, numB);
//                }
//            }
//        }
//        return temp;
//    }

    @Override
    public Expression parse(String expression) {
        return null;
    }
}
