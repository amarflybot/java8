package geeksForGeeks;

import java.util.Scanner;

public class AneoPuzzel {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int speed = in.nextInt();
            double speedMtPerSec = speed * 0.277778;
            double time = 0;
            int lightCount = in.nextInt();
            int totalDistance = 0;
            int totalDuration = 0;
            for (int i = 0; i < lightCount; i++) {
                int distance = in.nextInt();
                int duration = in.nextInt();
                totalDuration = totalDuration + duration;
                totalDistance = totalDistance + distance;
                if (i % 2 == 0) {
                    final double localTime = distance / speedMtPerSec;
                    time = time + localTime;
                    if ( localTime < duration) {
                        break;
                    }
                }
            }

            // Write an answer using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int totalSpeed = (int) (totalDistance/time*3.6);
            System.out.println(totalSpeed);

    }
}
