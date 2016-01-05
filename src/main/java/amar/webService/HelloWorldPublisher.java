package amar.webService;

import javax.xml.ws.Endpoint;

/**
 * @author Amarendra Kumar
 * @date 05-01-2016 AM 09:00.
 */
//Endpoint publisher
public class HelloWorldPublisher{

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}
