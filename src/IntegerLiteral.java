/**
 * Represents number expression of type int.
 */
public class IntegerLiteral extends Expression {
    private int number;

    /**
     * integer literal constructor, sets its number.
     *
     * @param number the literal's number
     */
    public IntegerLiteral(int number) {
        this.number = number;
    }

    /**
     * @return the number as double.
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
        return "(" + number + ")";
    }
}
