package amar.designPattern.creational.prototype;

/**
 * Created by kumarao on 06-08-2016.
 */
public class Rectangle extends Shape {

    public Rectangle() {
        System.out.println("Creating Rectangle");
    }

    @Override
    void draw() {
        System.out.println("Draw Rectangle inside Rectangle");
    }
}
