package geeksForGeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GFG1 {

    public static void main(String[] args) throws IOException {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();                // Reading input from STDIN

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String k = br2.readLine();                // Reading input from STDIN

        final String[] split = input.split(",");
        Integer kInt = Integer.valueOf(k);
        List<Integer> integers = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < split.length; i++) {
            final Integer integer = Integer.valueOf(split[i]);
            integers.add(integer);
            sum =+ integer;
        }
        Integer rem = sum % kInt;
        //integers.iterator()
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        while (!voidCompletableFuture.isDone()) {
            System.out.println("Running");
        }
    }
}
