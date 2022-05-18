public class DoubleLiteral extends Expression {
    private double num;

    public DoubleLiteral(double num) {
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
