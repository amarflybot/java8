package amar.thread;

import org.hibernate.c3p0.internal.C3P0ConnectionProvider;

import java.util.concurrent.TimeUnit;

/**
 * Created by amarendra on 20/01/16.
 */
public class C3PTest {

    public static void main(String[] args) {
        C3P0ConnectionProvider c3P0ConnectionProvider  = new C3P0ConnectionProvider();
        TimeUnit timeUnit = TimeUnit.HOURS;
    }
}
