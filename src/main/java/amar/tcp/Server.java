package amar.tcp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kumarao on 17-06-2016.
 */
public class Server {
    public static void main(final String[] args) {
        final String data = "Toobie ornaught toobie";
        try {
            final ServerSocket srvr = new ServerSocket(1234);
            final Socket skt = srvr.accept();
            System.out.print("Server has connected!\n");
            final PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending string: '" + data + "'\n");
            out.print(data);
            out.close();
            skt.close();
            srvr.close();
        } catch (final Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }

}
