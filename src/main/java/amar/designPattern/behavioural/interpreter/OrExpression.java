package amar.designPattern.behavioural.interpreter;

/**
 * Created by amarendra on 05/09/17.
 */
public class OrExpression implements Expression {

    private Expression expression;
    private Expression expression1;

    public OrExpression(final Expression expression, final Expression expression1) {
        this.expression = expression;
        this.expression1 = expression1;
    }

    @Override
    public boolean interpret(final String str) {
        return expression.interpret(str) || expression1.interpret(str);
    }
}
