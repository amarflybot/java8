package amar.designPattern.behavioural.visitor;

/**
 * Created by amarendra on 05/09/17.
 */
public interface AtvPart {

    void accept(AtvPartVisitor visitor);
}
