package amar.designPattern.behavioural.interpreter;

/**
 * Created by amarendra on 05/09/17.
 */
public class InterpreterDemo {

    public static void main(final String[] args) {

        final String context = "Lions bears and giraffe in forest";

        final Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));

    }

    private static Expression buildInterpreterTree() {

        final Expression expression = new TerminalExpression("Lions");
        final Expression expression1 = new TerminalExpression("bears");
        final Expression expression2 = new TerminalExpression("giraffe");

        final Expression expressionAnd = new AndExpression(expression, expression1);
        final Expression alteration1 = new AndExpression(expressionAnd, expression2);
        final Expression expressionOr = new AndExpression(expression, expression1);

        return alteration1;
    }
}
