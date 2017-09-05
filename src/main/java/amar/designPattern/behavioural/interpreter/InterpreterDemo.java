package amar.designPattern.behavioural.interpreter;

/**
 * Created by amarendra on 05/09/17.
 */
public class InterpreterDemo {

    public static void main(String[] args) {

        String context = "Lions bears and giraffe in forest";

        Expression define = buildInterpreterTree();

        System.out.println(context + " is "+ define.interpret(context));

    }

    private static Expression buildInterpreterTree() {

        Expression expression = new TerminalExpression("Lions");
        Expression expression1 = new TerminalExpression("goat");

        Expression expressionAnd = new AndExpression(expression,expression1);
        Expression expressionOr = new AndExpression(expression,expression1);

        return expressionAnd;
    }
}
