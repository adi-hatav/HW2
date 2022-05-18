public class Main {
    public static void main(String[] args) {
        testPartA();
        testPartB();
    }

    private static void testPartA() {
        System.out.println("--------------- Tests for part A ---------------");
        Clock c1 = new Clock(10, 30);
        Object o1 = c1;
        AccurateClock ac1 = new AccurateClock(10, 30, 20);
        Clock c2 = ac1;
        Object o2 = c2;
        System.out.println("c1 with o1: " + c1.equals(o1));
        System.out.println("o1 with c1: " + o1.equals(c1));

        System.out.println("c1 with ac1: " + c1.equals(ac1));
        System.out.println("ac1 with c1: " + ac1.equals(c1));
        System.out.println("c1 with c2: " + c1.equals(c2));
        System.out.println("c2 with c1: " + c2.equals(c1));
        System.out.println("c1 with o2: " + c1.equals(o2));
        System.out.println("o2 with c1: " + o2.equals(c1));

        System.out.println("ac1 with c2: " + ac1.equals(c2));
        System.out.println("c2 with ac1: " + c2.equals(ac1));
        System.out.println("ac1 with o2: " + ac1.equals(o2));
        System.out.println("o2 with ac1: " + o2.equals(ac1));
        System.out.println("c2 with o2: " + c2.equals(o2));
        System.out.println("o2 with c2: " + o2.equals(c2));
        System.out.println("c1 with null: " + c1.equals(null));
        System.out.println("o1 with null: " + o1.equals(null));
        System.out.println("ac1 with null: " + ac1.equals(null));

        System.out.println("c1: " + c1);
        System.out.println("o1: " + o1);
        System.out.println("ac1: " + ac1);
        System.out.println("c2: " + c2);
        System.out.println("o2: " + o2);
        System.out.println("new: " + new AccurateClock(5, 6, 3));
    }

    private static void testPartB() {
        System.out.println("--------------- Tests for part B ---------------");

        Expression intExp1 = new IntegerLiteral(5);
        printExpression(intExp1, "intExp1");

        Expression doubleExp1 = new DoubleLiteral(7.5);
        printExpression(doubleExp1, "doubleExp1");

        Expression intExp2 = new IntegerLiteral(-5);

        Expression exp1 = new Multiplication(
                new Addition(
                        intExp1,
                        doubleExp1),
                intExp2);
        printExpression(exp1, "exp1");

        Expression exp2 = new Multiplication(
                new Addition(
                        intExp1,
                        doubleExp1),
                new UnaryMinus(
                        new UnaryMinus(
                                intExp2)));
        printExpression(exp2, "exp2");

        Expression exp3 = new Subtraction(intExp1, intExp2);
        printExpression(exp3, "exp3");

        Expression divisionExp = new Division(
                new Addition(
                        new Subtraction(
                                new Multiplication(
                                        intExp1,
                                        intExp2),
                                doubleExp1),
                        exp2),
                exp1);
        printExpression(divisionExp, "divisionExp");

        Expression multiAdd1 = new MultiAddition(
                new DoubleLiteral(21.03),
                new IntegerLiteral(3));
        printExpression(multiAdd1, "multiAdd1");

        Expression multiAdd2 = new MultiAddition(
                new DoubleLiteral(21.03),
                new IntegerLiteral(3),
                new IntegerLiteral(5),
                new DoubleLiteral(3.1415));
        printExpression(multiAdd2, "multiAdd2");

        Expression multiMultiplication1 = new MultiMultiplication(new IntegerLiteral(5), new DoubleLiteral(7));
        printExpression(multiMultiplication1, "multiMultiplication1");

        Expression multiMultiplication2 = new MultiMultiplication(
                new IntegerLiteral(5),
                new DoubleLiteral(7),
                new UnaryMinus(
                        new Addition(
                                new DoubleLiteral(4),
                                new IntegerLiteral(3))));
        printExpression(multiMultiplication2, "multiMultiplication2");

        Expression roundExp1 = new RoundedExpression(new DoubleLiteral(5.123456), 2);
        printExpression(roundExp1, "roundExp1");

        Expression roundExp2 = new RoundedExpression(new DoubleLiteral(5.123456), 0);
        printExpression(roundExp2, "roundExp2");

        Expression roundExp3 = new RoundedExpression(new DoubleLiteral(5.1234567), 5);
        printExpression(roundExp3, "roundExp3");

        Expression roundExp4 = new RoundedExpression(multiAdd2, 2);
        printExpression(roundExp4, "roundExp4");

        Expression roundExp5 = new RoundedExpression(multiAdd2, 1);
        printExpression(roundExp5, "roundExp5");

        Expression massiveExp = new Multiplication(
                divisionExp,
                new UnaryMinus(
                        new Multiplication(
                                divisionExp,
                                new Division(
                                        new Addition(
                                                new Subtraction(
                                                        intExp1,
                                                        intExp2),
                                                doubleExp1),
                                        new UnaryMinus(
                                                new Division(
                                                        new DoubleLiteral(2.17),
                                                        new Subtraction(divisionExp, exp3)))))));
        printExpression(massiveExp, "massiveExp");

        ExpressionParser polishParser = new PolishNotationParser();
        ExpressionParser reversePolishParser = new ReversePolishNotationParser();

        Expression parsed1 = polishParser.parse("1.5");
        printExpression(parsed1, "parsed1", true);

        Expression parsed2 = reversePolishParser.parse("1");
        printExpression(parsed2, "parsed2", true);

        Expression parsed3 = polishParser.parse("1.0");
        printExpression(parsed3, "parsed3", true);

        Expression parsed4 = polishParser.parse("+ 1 2");
        printExpression(parsed4, "parsed4", true);

        Expression parsed5 = reversePolishParser.parse("1 2 +");
        printExpression(parsed5, "parsed5", true);

        Expression parsed6 = polishParser.parse("* + 1.0 2 + 3.0 4");
        printExpression(parsed6, "parsed6", true);

        Expression parsed7 = reversePolishParser.parse("1 2.0 + 3 4.0 + *");
        printExpression(parsed7, "parsed7", true);

        Expression parsed8 = reversePolishParser.parse("1 2.0 -u + 3 4.0 + * -u");
        printExpression(parsed8, "parsed8", true);

        Expression parsed9 = polishParser.parse("-u -u -u * + 1.0 2 + 3.0 -u 4");
        printExpression(parsed9, "parsed9", true);

        Addition exp4 = new Addition(exp3, parsed6);
        printExpression(exp4, "exp4");
    }

    private static void printExpression(Expression exp, String name, boolean withClass) {
        System.out.println(name + ": " + exp);
        System.out.println(name + " with toString: " + exp.toString());
        System.out.println(name + " value: " + exp.evaluate());

        if (withClass) {
            System.out.println(name + " class: " + exp.getClass());
        }
        System.out.println();
    }

    private static void printExpression(Expression exp, String name) {
        printExpression(exp, name, false);
    }
}
