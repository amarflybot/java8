package amar.designPattern.creational.prototype;

/**
 * Created by kumarao on 06-08-2016.
 */
public class Circle extends Shape {

    public Circle() {
        System.out.println("Creating Circle");
    }

    @Override
    void draw() {
        System.out.println("Draw Circle inside Circle");
    }
}
