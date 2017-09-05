package amar.designPattern.creational.prototype;

/**
 * Created by kumarao on 06-08-2016.
 */
public class Square extends Shape {

    public Square() {
        System.out.println("Creating Square");
    }

    @Override
    void draw() {
        System.out.println("Draw Square inside Square");
    }
}
