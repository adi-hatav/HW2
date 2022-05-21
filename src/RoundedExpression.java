public class RoundedExpression extends Expression {

    private Expression numA;
    private int numDigitToRound;
    private double roundedNum;


    public RoundedExpression(Expression numA, int numDigitToRound) {
        this.numA = numA;
        this.numDigitToRound = numDigitToRound;

        double pow = Math.pow(10, this.numDigitToRound);
        double aux = numA.evaluate() * (pow);
        this.roundedNum = Math.round(aux) / pow;
    }

    @Override
    public double evaluate() {
        return this.roundedNum;

    }

    @Override
    public String toString() {
        return this.numA.toString();
    }
}

