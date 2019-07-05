package amar.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by kumarao on 17-06-2016.
 */
public class Client {

    public static void main(String args[]) {
        try {
            Socket skt = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(skt.getInputStream()));
            System.out.print("Received string: '");

            while (!in.ready()) {
            }
            System.out.println(in.readLine()); // Read one line and output it

            System.out.print("'\n");
            in.close();
        } catch (Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }

}
