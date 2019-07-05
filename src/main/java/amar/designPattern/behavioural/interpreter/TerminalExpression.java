package amar.designPattern.behavioural.interpreter;

import java.util.StringTokenizer;

/**
 * Created by amarendra on 05/09/17.
 */
public class TerminalExpression implements Expression {

    private String str;

    public TerminalExpression(final String str) {
        this.str = str;
    }

    @Override
    public boolean interpret(final String str) {

        final StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            final String test = stringTokenizer.nextToken();
            if (test.equals(this.str)) {
                return true;
            }
        }
        return false;
    }
}
