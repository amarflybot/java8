package amar.designPattern.creational.factoryPattern;

enum ColorType {
    RED {
        @Override
        public void draw() {
            System.out.println("Draw Red");
        }
    }, GREEN {
        @Override
        public void draw() {
            System.out.println("Draw Green");
        }
    };

    public void draw() {
        System.out.println("Draw color");
    }
}

enum ShapeType {
    CIRCLE {
        @Override
        public void draw() {
            System.out.println("Draw Circle");
        }
    }, SQUARE {
        @Override
        public void draw() {
            System.out.println("Draw Square");
        }
    };

    public void draw() {
        System.out.println("Draw Shape");
    }
}

/**
 * Created by amarendra on 15/01/16.
 */

interface Shape {
    void draw();
}

interface Color {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Red implements Color {

    @Override
    public void draw() {
        System.out.println("Drawing red");
    }
}

class Green implements Color {

    @Override
    public void draw() {
        System.out.println("Drawing green");
    }
}

abstract class Factory {
    abstract Shape getShape(ShapeType shape);

    abstract Color getColor(ColorType color);
}

class ShapeFactory extends Factory {

    Shape getShape(final ShapeType shape) {
        switch (shape) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }

    @Override
    Color getColor(final ColorType color) {
        return null;
    }
}

class ColorFactory extends Factory {

    @Override
    Shape getShape(final ShapeType shape) {
        return null;
    }

    Color getColor(final ColorType color) {
        switch (color) {
            case RED:
                return new Red();
            case GREEN:
                return new Green();
            default:
                return null;
        }
    }
}

class FactoryImpl {
    Factory colorFactory = new ColorFactory();
    Factory shapeFactory = new ShapeFactory();

    public void drawShape(final ShapeType shape, final ColorType color) {
        try {
            //colorFactory.getColor(color).draw();
            //shapeFactory.getShape(shape).draw();
            shape.draw();
            color.draw();
        } catch (final Exception e) {
            System.out.println("Shape or Color Not found");
        }
    }
}

public class FactoryPattern {
    public static void main(final String[] args) {
        new FactoryImpl().drawShape(ShapeType.CIRCLE, ColorType.GREEN);
    }
}
