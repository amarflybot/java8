package amar.algorithm.general;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by amarendrakumar on 03/06/17.
 */
public class OverlappingRectangle {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        Integer numberOfTests = Integer.valueOf(in.next());
        if (numberOfTests > 0) {
            while (numberOfTests != 0) {
                final int rect1_x0 = Integer.parseInt(in.next());
                final int rect1_y0 = Integer.parseInt(in.next());
                final int rect1_x1 = Integer.parseInt(in.next());
                final int rect1_y1 = Integer.parseInt(in.next());

                final int rect2_x0 = Integer.parseInt(in.next());
                final int rect2_y0 = Integer.parseInt(in.next());
                final int rect2_x1 = Integer.parseInt(in.next());
                final int rect2_y1 = Integer.parseInt(in.next());

                final Rectangle rectangleA = new Rectangle(rect1_x0, rect1_y1, (rect1_x1 - rect1_x0), (rect1_y0 - rect1_y1));
                final Rectangle rectangleB = new Rectangle(rect2_x0, rect2_y1, (rect2_x1 - rect2_x0), (rect2_y0 - rect2_y1));

                final boolean intersects = rectangleA.intersects(rectangleB);
                if (intersects) {
                    System.out.println(1);
                } else {
                    rectangleA.getLocation();
                    System.out.println(0);
                }

                numberOfTests--;
            }
        }

    }
}
