package amar.algorithm;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by amarendrakumar on 03/06/17.
 */
public class OverlappingRectangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTests = Integer.valueOf(in.next());
        if (numberOfTests > 0){
            while (numberOfTests != 0){
                int rect1_x0 = Integer.parseInt(in.next());
                int rect1_y0 = Integer.parseInt(in.next());
                int rect1_x1 = Integer.parseInt(in.next());
                int rect1_y1 = Integer.parseInt(in.next());

                int rect2_x0 = Integer.parseInt(in.next());
                int rect2_y0 = Integer.parseInt(in.next());
                int rect2_x1 = Integer.parseInt(in.next());
                int rect2_y1 = Integer.parseInt(in.next());

                Rectangle rectangleA = new Rectangle(rect1_x0,rect1_y1, (rect1_x1-rect1_x0), (rect1_y0-rect1_y1));
                Rectangle rectangleB = new Rectangle(rect2_x0,rect2_y1, (rect2_x1-rect2_x0), (rect2_y0-rect2_y1));

                boolean intersects = rectangleA.intersects(rectangleB);
                if (intersects){
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
