package geeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class HundredDoors {

    public static void main(String[] args) {

        Map<Integer, Boolean> doors = new HashMap<>();

        for (int i = 1; i <= 100; i++) {
            doors.put(i, false);
        }
        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            doors.forEach((x, status) -> {
                if (x % finalI == 0) {
                    status = !status;
                    doors.put(x,status);
                }
            });
        }
        doors.forEach((x,status) -> {
            if (status) {
                System.out.println(x);
            }
        });
    }
}
