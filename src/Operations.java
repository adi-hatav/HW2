public abstract class Operations extends Expression{

    private Expression numA;
    private Expression numB;
    protected String operator;

    public Operations(Expression numA, Expression numB,String operator) {
        this.numA = numA;
        this.numB = numB;
        this.operator = operator;
    }

    @Override
    public double evaluate() {
        switch (this.operator){
            case ("+") :return numA.evaluate()+ numB.evaluate();
            case ("*") :return numA.evaluate()* numB.evaluate();
            case ("/") :return numA.evaluate()/ numB.evaluate();
            case ("-") :return numA.evaluate()- numB.evaluate();
            default: return 0;
        }

    }
    @Override
    public String toString() {
        return "("+this.numA.toString()+" "+this.operator+" "+this.numB.toString()+")";
    }

}
