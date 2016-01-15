package amar.designPattern.factoryPattern;

/**
 * Created by amarendra on 15/01/16.
 */

interface Shape{
    public void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

interface Color{
    public void draw();
}

class Red implements Color{

    @Override
    public void draw() {
        System.out.println("Drawing red");
    }
}

class Green implements Color{

    @Override
    public void draw() {
        System.out.println("Drawing green");
    }
}
abstract class Factory{
    abstract Shape getShape(String shape);
    abstract Color getColor(String color);
}
class ShapeFactory extends Factory{

     Shape getShape(String shape){
        if(shape.equals("Circle")){
            return new Circle();
        }
        else if(shape.equals("Square")){
            return new Square();
        }
        else return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends Factory{

    @Override
    Shape getShape(String shape) {
        return null;
    }

    Color getColor(String color){
        if(color.equals("red")){
            return new Red();
        }
        else if(color.equals("green")){
            return new Green();
        }
        else return null;
    }
}

class FactoryImpl{
    Factory colorFactory = new ColorFactory();
    Factory shapeFactory = new ShapeFactory();

    public void drawShape(String shape, String color){
        try {
            colorFactory.getColor(color).draw();
            shapeFactory.getShape(shape).draw();
        } catch (Exception e) {
            System.out.println("Shape or Color Not found");
        }
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        new FactoryImpl().drawShape("Circle","green");
    }
}
