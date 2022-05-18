public class IntegerLiteral extends Expression {
    private int num;

    public IntegerLiteral(int num) {
        this.num = num;
    }

    @Override
    public double evaluate() {
        return this.num;
    }

    @Override
    public String toString() {
        return "(" + num + ")";
    }
}
