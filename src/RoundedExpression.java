public class RoundedExpression extends Expression{

    private Expression numA;
    private int numDigitToRound;
    private double roundedNum;


    public RoundedExpression(Expression numA, int numDigitToRound) {
        this.numA = numA;
        this.numDigitToRound = numDigitToRound;

        double pow= Math.pow(10,numDigitToRound);
        double aux=numA.evaluate()*(pow);
        this.roundedNum = ((int)aux)/pow;
    }

    @Override
    public double evaluate() {
        return this.roundedNum;

    }
    @Override
    public String toString() {
        return "(-"+this.roundedNum+")";
    }
}

