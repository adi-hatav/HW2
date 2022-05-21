/**
 * Represents arithmetic expression of type Rounded expression.
 */
public class RoundedExpression extends Expression {

    private Expression expressionA;
    private int numDigitToRound;
    private double roundedNum;

    /**
     * RoundedExpression constructor, calculates the round number based on the numDigitToRound.
     *
     * @param expressionA     the expression to round.
     * @param numDigitToRound the number of digits after the decimal point.
     */
    public RoundedExpression(Expression expressionA, int numDigitToRound) {
        this.expressionA = expressionA;
        this.numDigitToRound = numDigitToRound;

        double pow = Math.pow(10, this.numDigitToRound);
        double aux = expressionA.evaluate() * (pow);
        this.roundedNum = Math.round(aux) / pow;
    }

    @Override
    public double evaluate() {
        return this.roundedNum;

    }

    @Override
    public String toString() {
        return this.expressionA.toString();
    }
}

