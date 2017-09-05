package amar.designPattern.creational.prototype;

/**
 * Created by kumarao on 06-08-2016.
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape circle = ShapeCache.getShape("1");
        System.out.println("Shape : " + circle.getType() + " "+ System.identityHashCode(circle));

        Shape square = ShapeCache.getShape("2");
        System.out.println("Shape : " + square.getType()+ " "+ System.identityHashCode(square));

        Shape rectangle = ShapeCache.getShape("3");
        System.out.println("Shape : " + rectangle.getType()+ " "+ System.identityHashCode(rectangle) + " " + rectangle.getRecord().hashCode());

        Shape rectangle2 = ShapeCache.getShape("3");
        System.out.println("Shape : " + rectangle2.getType()+ " "+ System.identityHashCode(rectangle2) + " " + rectangle2.getRecord().hashCode());
    }

}
