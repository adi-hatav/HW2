public class MultiAddition extends Addition {
    private Expression[] numbers;

    public MultiAddition(Expression... numbers) {
        super(numbers[0], numbers[1]);
        this.numbers = numbers;

    }
    @Override
    public double evaluate() {
        double eval = 0;
        for(Expression num:this.numbers){
            eval += num.evaluate();
        }
        return eval;
    }

    @Override
    public String toString() {
        String MultiAdditionString = "(";
        int i = 0;
        for (; i < this.numbers.length - 1; i++) {
            MultiAdditionString += this.numbers[i].toString() + " + ";
        }
        MultiAdditionString += this.numbers[i].toString() + ")";
        return MultiAdditionString;
    }
}
