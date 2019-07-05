package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by amarendra on 13/09/17.
 */
public class Future8Test {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<String> async = calculateAsync();
        System.out.println("async.before.isCancelled() -> " + async.isCancelled());
        System.out.println("async.before.isDone() -> " + async.isDone());
        final String str = async.get();
        System.out.println(str);
        System.out.println("async.after.isCancelled() -> " + async.isCancelled());
        System.out.println("async.after.isDone() -> " + async.isDone());
        System.out.println("async.done.isCancelled() -> " + async.isCancelled());
        System.out.println("async.done.isDone() -> " + async.isDone());
    }

    public static CompletableFuture<String> calculateAsync() {
        final CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete("Hello " + Thread.currentThread().getName());
        });

        return completableFuture;
    }
}
