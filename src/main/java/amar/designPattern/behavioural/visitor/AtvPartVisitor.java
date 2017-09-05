package amar.designPattern.behavioural.visitor;

/**
 * Created by amarendra on 05/09/17.
 */
public interface AtvPartVisitor {

    void visit(Wheel atvPart);

    void visit(Fender fender);

    void visit(Oil oil);

    void visit(PartsOrder partsOrder);
}
