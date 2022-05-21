public class MultiAddition extends Addition {
    private Expression[] expressions;

    public MultiAddition(Expression... expressions) {
        super(expressions[0], expressions[1]);
        this.expressions = expressions;

    }

    @Override
    public double evaluate() {
        double eval = 0;
        for (Expression num : this.expressions) {
            eval += num.evaluate();
        }
        return eval;
    }

    @Override
    public String toString() {
        String MultiAdditionString = "(";
        int i = 0;
        for (; i < this.expressions.length - 1; i++) {
            MultiAdditionString += this.expressions[i].toString() + " + ";
        }
        MultiAdditionString += this.expressions[i].toString() + ")";
        return MultiAdditionString;
    }
}
