package amar.designPattern.behavioural.visitor;

/**
 * Created by amarendra on 05/09/17.
 */
public class VisitorDemo {

    public static void main(String[] args) {

        PartsOrder order = new PartsOrder();
        order.addPart(new Wheel());
        order.addPart(new Fender());
        order.addPart(new Oil());

        order.addPart(new AtvPart() {
            @Override
            public void accept(final AtvPartVisitor visitor) {
                visitor.visit(this);
            }
        });

        order.accept(new AtvPartsShippingVisitor());
        order.accept(new AtvPartsDisplayVisitor());


    }
}
