package amar.designPattern.behavioural.visitor;

import java.util.List;

/**
 * Created by amarendra on 05/09/17.
 */
public class AtvPartsShippingVisitor implements AtvPartVisitor {

    double shippingAmount = 0;

    @Override
    public void visit(final Wheel atvPart) {
        shippingAmount += 15;
        System.out.println("Wheels are heavy and expensive to ship, so 15$.");
    }

    @Override
    public void visit(final Fender fender) {
        shippingAmount += 3;
        System.out.println("Shipping fenders are easy, so 3$.");

    }

    @Override
    public void visit(final Oil oil) {
        shippingAmount += 9;
        System.out.println("Shipping oil is 9$.");
    }

    @Override
    public void visit(final PartsOrder partsOrder) {
        System.out.println("If you bought more than 3 items we will give discount.");
        final List<AtvPart> parts = partsOrder.getParts();
        if (parts.size() > 3) {
            shippingAmount -= 5;
        }

        System.out.println("Total Shipping amount is: " + shippingAmount);
    }

    @Override
    public void visit(final AtvPart atvPart) {
        System.out.println("If you buy generic Items.");
        shippingAmount += 4;
    }
}
