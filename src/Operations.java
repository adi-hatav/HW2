public class Operations extends Expression{

    private Expression expA;
    private Expression expB;
    protected String operator;

    public Operations(){
    }

    public Operations(Expression expA, Expression expB,String operator) {
        this.expA = expA;
        this.expB = expB;
        this.operator = operator;
        this.expressionString = "("+this.expA.toString()+" "+this.operator+" "+this.expB.toString()+")";
        switch (this.operator){
            case ("+") :this.expressionValue =  expA.evaluate()+ expB.evaluate();
            case ("*") :this.expressionValue = expA.evaluate()* expB.evaluate();
            case ("/") :this.expressionValue = expA.evaluate()/ expB.evaluate();
            case ("-") :this.expressionValue = expA.evaluate()- expB.evaluate();
            default: this.expressionValue = expA.evaluate();
        }

    }

    @Override
    public double evaluate() { return this.expressionValue;
    }
    @Override
    public String toString() {
        return this.expressionString ;
    }

}
