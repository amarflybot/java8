package amar.designPattern.behavioural.visitor;

/**
 * Created by amarendra on 05/09/17.
 */
public class AtvPartsDisplayVisitor implements AtvPartVisitor {
    @Override
    public void visit(final Wheel atvPart) {
        System.out.println("Displaying Wheel");
    }

    @Override
    public void visit(final Fender fender) {
        System.out.println("Displaying Fender");
    }

    @Override
    public void visit(final Oil oil) {
        System.out.println("Displaying Oil");
    }

    @Override
    public void visit(final PartsOrder partsOrder) {
        System.out.println("Displaying Orders");
    }
}
