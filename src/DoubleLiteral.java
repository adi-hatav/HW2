/**
 * Represents number expression of type Double.
 */
public class DoubleLiteral extends Expression {
    private double number;

    /**
     * double literal constructor, sets its number.
     *
     * @param number the literal's number
     */
    public DoubleLiteral(double number) {
        this.number = number;
    }

    /**
     * @return the double number itself.
     */
    @Override
    public double evaluate() {
        return this.number;
    }

    /**
     * @return string with brackets at the beginning and the end.
     */
    @Override
    public String toString() {
        return "(" + this.number + ")";
    }
}
