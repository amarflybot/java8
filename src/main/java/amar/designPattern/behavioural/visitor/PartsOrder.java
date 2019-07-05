package amar.designPattern.behavioural.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amarendra on 05/09/17.
 */
public class PartsOrder implements AtvPart {

    List<AtvPart> list = new ArrayList<>();

    public void addPart(final AtvPart part) {
        list.add(part);
    }

    public List<AtvPart> getParts() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void accept(final AtvPartVisitor visitor) {
        list.forEach(atvPart -> {
            atvPart.accept(visitor);
        });

        visitor.visit(this);
    }
}
