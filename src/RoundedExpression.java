public class RoundedExpression extends Expression {

    private Expression expressionA;
    private int numDigitToRound;
    private double roundedNum;


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

